package Assignment8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class NoteManager {
    public static void main(String[] arguments) throws IOException {
        boolean looping = true;
        while (looping) {
            System.out.println("Press 1 to Create New Note\nPress 2 to View All Notes\nPress 3 to Update Note\nPress 4 to Delete Note\nPress 5 to Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> create();
                case 2 -> read();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> looping = false;
                default -> looping = false;
            }
        }
    }

    static void create() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter note:");
        String content = sc2.nextLine();
        Scanner sc3 = new Scanner(content);
        System.out.println("Enter note name: ");
        String name = sc2.nextLine();
        name=name+".txt";
        Path p = Paths.get("out/Assignment8 notes",name);
        if (Files.exists(p)) {
            System.out.println("Note already exists. Overwrite? y/n");
            char c = sc2.next().charAt(0);
            if (c == 'n' || c == 'N') {
                 create();
            }else{
                //overwrite logic
                 write(sc2,p,name,content);
            }
        } else {
            //write logic
             write(sc2,p,name,content);
        }
    }


    static void read() throws IOException {
        //System.out.println(fileScanner(new File("out/Assignment8 notes/")));
        List<Path> listOfFiles= fileScanner(new File("out/Assignment8 notes/"));
        System.out.println("Here is the list of files:");
        //listOfFiles.forEach(System.out::println);
        System.out.println("index\tDirectory");
        for(int i=0;i<listOfFiles.size();i++){
            System.out.println(i+"\t"+listOfFiles.get(i));
        }
        System.out.println("Enter the index of the file you want to read.");
        Scanner sc3=new Scanner(System.in);
        int index=sc3.nextInt();
        String content=Files.readString(listOfFiles.get(index),StandardCharsets.UTF_8);
        System.out.println("Note content:\n"+content);

    }

    static void update() throws IOException {
        List<Path> listOfFiles= fileScanner(new File("out/Assignment8 notes/"));
        System.out.println("Here is the list of files:");
        System.out.println("index\tDirectory");
        for(int i=0;i<listOfFiles.size();i++){
            System.out.println(i+"\t"+listOfFiles.get(i));
        }
        System.out.println("Enter the index of the file you want to update.");
        Scanner sc3=new Scanner(System.in);
        int index=sc3.nextInt();
        String name=listOfFiles.get(index).getFileName().toString();
        String content=Files.readString(listOfFiles.get(index),StandardCharsets.UTF_8);
        System.out.println("Original content:\n"+content);
        System.out.println("New content: ");
        sc3.nextLine();
        String content2=sc3.nextLine();
        write(sc3,listOfFiles.get(index),name,content2);
    }

    static void delete() throws IOException {
        List<Path> listOfFiles= fileScanner(new File("out/Assignment8 notes/"));
        System.out.println("Here is the list of files:");
        System.out.println("index\tDirectory");
        for(int i=0;i<listOfFiles.size();i++){
            System.out.println(i+"\t"+listOfFiles.get(i));
        }
        System.out.println("Enter the index of the file you want to Delete.");
        Scanner sc3=new Scanner(System.in);
        int index=sc3.nextInt();
        Files.deleteIfExists(listOfFiles.get(index));
        //String name=listOfFiles.get(index).getFileName().toString();
    }

    static List<Path> fileScanner(File p) throws IOException {
        List<Path> list = new ArrayList<>();
        for(File f : Objects.requireNonNull(p.listFiles())){
            if(f.getName().endsWith(".txt")){
                Path p2=Paths.get(p+"/"+f.getName().trim());
                list.add(p2);
            }
        }
        return list;
    }

    static int write(Scanner sc, Path p,String name, String content) {
        try { //study files.writeString();
            Files.write(p, content.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}




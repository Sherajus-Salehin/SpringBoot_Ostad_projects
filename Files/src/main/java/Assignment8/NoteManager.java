package Assignment8;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class NoteManager {
    public static void main(String[] arguments) {
        boolean looping = true;
        while (looping) {
            System.out.println("Press 1 to Create New Note\nPress 2 to View All Notes\nPress 3 to Update Note\nPress 4 to Delete Note\nPress 5 to Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Creating");
                case 2 -> System.out.println("Viewing All Notes");
                case 3 -> System.out.println("Update Note");
                case 4 -> System.out.println("Delete Note");
                case 5 -> looping = false;
            }
        }
    }

    static int create(Scanner sc) {
        System.out.println("Enter note:");
        String content = sc.nextLine();
        System.out.println("Enter note name");
        String name = sc.nextLine();
        Path p = Paths.get(name);
        if (Files.exists(p)) {
            System.out.println("Note already exists. Overwrite? y/n");
            char c = sc.next().charAt(0);
            if (c == 'n' || c == 'N') {
                return -1;
            }else{
                //overwrite logic
            }
        } else {
            //write logic
        }
        return 0;
    }
    static int write(Scanner sc, Path p,String name, String content) {
        try {
            Files.write(p, content.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    return 0;
    }

    static String read() {

        return "";
    }

    static int update() {
        return 0;
    }

    static int delete() {
        return 0;
    }
}




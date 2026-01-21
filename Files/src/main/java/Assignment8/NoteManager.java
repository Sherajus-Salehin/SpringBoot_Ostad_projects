package Assignment8;

import java.util.Scanner;

public class NoteManager {
    public static void main(String [] arguments ) {
        boolean looping=true;
        while(looping){
            System.out.println("Press 1 to Create New Note\nPress 2 to View All Notes\nPress 3 to Update Note\nPress 4 to Delete Note\nPress 5 to Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1-> System.out.println("Creating");
                case 2-> System.out.println("Viewing All Notes");
                case 3-> System.out.println("Update Note");
                case 4-> System.out.println("Delete Note");
                case 5-> looping=false;
            }
        }
    }
    static int create(){

    return 0;
    }
    static String read(){

    return "";
    }
    static int update(){
        return 0;
    }
    static int delete(){
        return 0;
    }
}




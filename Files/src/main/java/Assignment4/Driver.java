package Assignment4;

import java.util.Scanner;
public class Driver {
    // ASSIGNMENT 4 -> DEADLINE 27 DECEMBER
    static int[] UserInput(Scanner uI){
        System.out.println("Enter the length in meters: ");
        int l=uI.nextInt();
        System.out.println("Enter the width in meters: ");
        int w=uI.nextInt();
        if(l*w<0){
            System.err.println("Length and the width must be a positive Integer. ");
            return UserInput(uI);
        }
        return new int[]{l,w};
    }
    static int calculation(boolean area, int l, int w){
        if(area) return l*w;
        else return 2*l+2*w;
    }
    static void display(int l, int w,int res, boolean c){
        if(c) System.out.println("The area of the rectangle for given \nlength:"+l+"meters\nwidth: "+w+"meters\nis: "+res+" square meters.");
        else System.out.println("The Perimeter of the area for given \nlength: "+l+"meters\nwidth: "+w+"meters\nis: "+res+" meters.");
    }

    public static void main(String[] ar){
        Scanner sc=new Scanner(System.in);
        int [] inputs= UserInput(sc);
        System.out.println("Enter: \n <1> for area.\n <2> for perimeter.");
        int choice= sc.nextInt();
        boolean area=(choice==1);
        int result=calculation(area,inputs[0],inputs[1]);
        display(inputs[0],inputs[1],result,area);
        sc.close();
    }

    }

package Assignment5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CartItem Egg=new CartItem(10,0,false);
        CartItem Milk=new CartItem(20,0,false);
        CartItem Noodles=new CartItem(30,0,false);
        boolean looping=true;
        int currentItem=-1;
        while (looping){
            System.out.println("Press <1> to add/remove Egg to cart.\nPress <2> to add/remove Milk to cart.\nPress <3> to add/remove Noodles to cart.");
            int choice= sc.nextInt();
            switch (choice){
                case 1 ->{
                    Egg.setAddedToCArt(!Egg.isAddedToCArt());
                    currentItem=1;
                }
                case 2->{
                    currentItem=2;
                    Milk.setAddedToCArt(!Milk.isAddedToCArt());
                }
                case 3->{
                    currentItem=3;
                    Noodles.setAddedToCArt(!Noodles.isAddedToCArt());
                }
            }
            System.out.println("Press <5> to increase quantity.\nPress <6 to decrease quantity.> ");
            choice= sc.nextInt();
            switch (choice){
                case 5->{
                    if(currentItem==1) Egg.incrementQuantity();
                    else if (currentItem==2) Milk.incrementQuantity();
                    else if (currentItem==3) Noodles.incrementQuantity();
                }
                case 6->{
                    if(currentItem==1) Egg.decrementQuantity();
                    else if (currentItem==2) Milk.decrementQuantity();
                    else if (currentItem==3) Noodles.decrementQuantity();
                }
            }

            //remaining task 1. fix add remove 2. add cart printing 3. add total payable printing
            looping=false;
        }


    }
}

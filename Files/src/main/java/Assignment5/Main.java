package Assignment5;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CartItem Egg=new CartItem("Egg",10,0,false);
        CartItem Milk=new CartItem("Milk",20,0,false);
        CartItem Noodles=new CartItem("Noodles",30,0,false);
        boolean looping=true;
        boolean added=true;
        int currentItem=-1;
        while (looping){
            System.out.println("Press <1> to add/remove Egg to cart.\nPress <2> to add/remove Milk to cart.\nPress <3> to add/remove Noodles to cart.\n<4> to skip.");
            int choice= sc.nextInt();
            switch (choice){
                case 1 ->{
                    added=Egg.addOrRemove();
                    currentItem=1;
                }
                case 2->{
                    currentItem=2;
                    added=Milk.addOrRemove();
                }
                case 3->{
                    currentItem=3;
                    added=Noodles.addOrRemove();
                }
            }
            if(added && choice<4){
                while (choice!=7){
                    System.out.println("Press <5> to increase quantity.\nPress <6> to decrease quantity.>\n<7>to continue. ");
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
                }
            }

            System.out.println("Press <7> to print the cart \npress <8> to check total payable amount \npress <9> to exit\nPress<0> to continue shopping");
            choice=sc.nextInt();
            if(choice==7){
                printCart(Egg,Milk,Noodles);
            } else if (choice==8) {
                totalPayable(Egg,Milk,Noodles);
            }else if(choice==9) looping=false;

        }

    }
    static void printCart(CartItem E,CartItem M,CartItem N){
        StringBuilder cart = new StringBuilder();
        cart.append("\n").append("Product id----Product Name----Price----Quantity");
        if (E.isAddedToCArt()) cart.append("\n--------").append(E.getProductId()).append("-----------").append(E.getName()).append("----").append(E.getUnitPrice()).append("--------").append(E.getQuantity());
        if (M.isAddedToCArt()) cart.append("\n--------").append(M.getProductId()).append("-----------").append(M.getName()).append("----").append(M.getUnitPrice()).append("--------").append(M.getQuantity());
        if (N.isAddedToCArt()) cart.append("\n--------").append(N.getProductId()).append("-----------").append(N.getName()).append("----").append(N.getUnitPrice()).append("---------").append(N.getQuantity());
        System.out.println(cart);
    }
    static void totalPayable(CartItem E,CartItem M,CartItem N){
        System.out.println("Total payable: "+(E.totalPayable()+M.totalPayable()+N.totalPayable()));
    }
}

import java.util.Scanner;

public class Main {
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

    public static void main(String[] args) {
    // ASSIGNMENT 4 -> DEADLINE 27 DECEMBER
        Scanner sc=new Scanner(System.in);
        int [] inputs= UserInput(sc);
        System.out.println("Enter: \n <1> for area.\n <2> for perimeter.");
        int choice= sc.nextInt();
        boolean area=(choice==1);
        int result=calculation(area,inputs[0],inputs[1]);
        display(inputs[0],inputs[1],result,area);
        sc.close();













    /*ASSIGNMENT 3 -> DEADLINE 18 DECEMBER 2025.

    Assignment3.consoleATM ca=new Assignment3.consoleATM();
    Scanner sc=new Scanner(System.in);
    boolean looping=true;
        while (looping) {
            System.out.println("Welcome to the Simple Console ATM!\n" +
                    "Please select an option:\n" +
                    "1. Check Balance\n" +
                    "2. Deposit Funds\n" +
                    "3. Withdraw Funds\n" +
                    "4. Exit\n");
            int choice=sc.nextInt();
            int amount;
            switch(choice){
                case 1 -> System.out.println("Your balance is "+ca.Balance+"bdt\n");
                case 2 -> {
                    System.out.println("Enter amount");
                    amount = sc.nextInt();
                    ca.Deposit(amount);
                }
                case 3 -> {
                    System.out.println("Enter amount");
                    amount = sc.nextInt();
                    switch (ca.Withdraw(amount)){
                        case 1 -> System.out.println("Withdrawal Successful\n");
                        case 0 -> System.err.println("Max limit = 100 bdt\n");
                        case-1 -> System.err.println("Insufficient balance\n");
                    }
                }
                case 4 -> {
                    looping=false;
                }
                default -> System.out.println("Invalid Choice\n");
            }
        }
        sc.close();
        System.out.println("Thank you for using the ATM! Goodbye,");

        //ASSIGNMENT 2 -> DEADLINE 11 DECEMBER 2025

        Scanner s=new Scanner(System.in);
        Sales saleCalculation= new Sales();
        //sales info collection
        System.out.print("Enter selling price of potato per kg: ");
        double potatoPrice=s.nextDouble();
        System.out.print("Enter selling price  onion per kg: ");
        double onionPrice=s.nextDouble();
        System.out.print("Enter selling price of oil per liter: ");
        double OilPrice=s.nextDouble();
        System.out.print("Total amount of potato sold: ");
        double potatoSold=s.nextDouble();
        System.out.print("Total amount of  onion sold: ");
        double onionSold=s.nextDouble();
        System.out.print("Total amount of  oil sold: ");
        double OilSold=s.nextDouble();
        saleCalculation.setPrices(potatoPrice,onionPrice,OilPrice);
        saleCalculation.setSales(potatoSold,onionSold,OilSold);
        //Cost info collection (re-using previous variables) here, sold=purchased
        System.out.print("Enter Purchasing price of potato per kg: ");
        potatoPrice=s.nextDouble();
        System.out.print("Enter Purchasing price  onion per kg: ");
        onionPrice=s.nextDouble();
        System.out.print("Enter Purchasing price of oil per liter: ");
        OilPrice=s.nextDouble();
        System.out.print("Total amount of potato purchased: ");
        potatoSold=s.nextDouble();
        System.out.print("Total amount of  onion purchased: ");
        onionSold=s.nextDouble();
        System.out.print("Total amount of  oil purchased: ");
        OilSold=s.nextDouble();
        System.out.print("Enter total Transport cost: ");
        int transportCost=s.nextInt();
        saleCalculation.setPurchasePrice(potatoPrice,onionPrice,OilPrice,transportCost);
        saleCalculation.setPurchased(potatoSold,onionSold,OilSold);//sold=purchased


        System.out.println(saleCalculation.saleSummary()+"\n"+saleCalculation.CostSummary()
        +"\n"+saleCalculation.netIncome());

        s.close();

        //ASSIGNMENT 1 -> DEADLINE 6 DECEMBER 2025

        Identity i1= new Identity();
        System.out.println(i1.AllInfo());
        System.out.println("\n### Module Summary ###");
        System.out.println("1.Java basics, JDK, variables"+"\n2.Project setup");
        System.out.println("what I learned: Refreshed the basics of JAVA."+"\nProject created: 1(assignment purpose). \nSuggestion: No suggestion till now.");
    */
         }
}

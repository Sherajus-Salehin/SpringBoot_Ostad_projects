import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Assignment2
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




        /*  ASSIGNMENT 1
        Identity i1= new Identity();
        System.out.println(i1.AllInfo());
        System.out.println("\n### Module Summary ###");
        System.out.println("1.Java basics, JDK, variables"+"\n2.Project setup");
        System.out.println("what I learned: Refreshed the basics of JAVA."+"\nProject created: 1(assignment purpose). \nSuggestion: No suggestion till now.");
    */
         }
}

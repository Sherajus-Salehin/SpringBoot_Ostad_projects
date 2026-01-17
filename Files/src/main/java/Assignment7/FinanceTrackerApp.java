package Assignment7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FinanceTrackerApp {
    static void main(String [] ar) {
        ArrayList<Transaction>  transactions = new ArrayList<>();
        Set<String> ids = new HashSet<>();
        Set<String> types=Set.of("INCOME","EXPENSE");
        boolean looping=true;
        Scanner sc=new Scanner(System.in);
        while(looping){
            System.out.println("Enter 1 to add an transaction\nEnter 2 to See all Transactions\nEnter 3 to update a record\nEnter 4 to delete a record\nEnter 5 to Check balance\nEnter 6 to exit");
            //c-done r-done u- done d- done balance-done
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1->{
                    Transaction t=Create(sc,ids,types);
                    transactions.add(t);
                    ids.add(t.getId());
                }
                case 2-> System.out.println(Read(transactions));
                case 3-> Update(sc, ids, types, transactions);
                case 4-> Delete(transactions,sc,ids);
                case 5-> System.out.println("Balance is "+CheckBalance(transactions));
                case 6-> looping=false;
            }
        }

    }

    static Transaction Create(Scanner sc, Set<String> ids, Set<String> types) {
        String id=IDSetter(sc,ids);
        //ids.add(id);
        String type=TypeSetter(sc,types);
        double amount=AmountSetter(sc);
        System.out.println("Enter Description of your transaction");
        String description=sc.nextLine();
        String date=DateSetter(sc);
        return new Transaction(id,amount,type,description,date);
    }
    static String Read(ArrayList<Transaction>  transactions){
        StringBuilder s=new StringBuilder();
        s.append("Id"+"\t"+"Type"+"\t"+"Amount"+"\t"+"Description"+"\t"+"Date");
        for(Transaction t:transactions){
            s.append("\n").append(t.toString());
        }
    return s.toString();
    }
    static void Update(Scanner sc, Set<String> ids, Set<String> types, ArrayList<Transaction>  transactions) {
        System.out.println("Enter ID of your transaction");
        String id=sc.nextLine();
        //sc.nextLine();
        if(ids.contains(id)){
            int index=0;
            for(int i=0;i<ids.size();i++){
                if(id.equals(transactions.get(i).getId())){
                    index=i;
                }
            }
            // type, amount, description, and date
            Transaction t=transactions.get(index);
            System.out.println("Press 1 to change type\nPress 2 to change amount\nPress 3 to change description\nPress 4 to change date");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1->{
                    String type=TypeSetter(sc,types);
                    t.setType(type);
                }
                case 2->{
                    double amount=AmountSetter(sc);
                    t.setAmount(amount);
                }
                case 3->{
                    System.out.println("Updated description: ");
                    String description=sc.nextLine();
                    t.setDescription(description);
                }
                case 4->{
                    String date=DateSetter(sc);
                    t.setDate(date);
                }
            }
            transactions.set(index,t);
        }else {
            System.out.println("Invalid ID");
        }
    }
    static void Delete(ArrayList<Transaction>  transactions,Scanner sc, Set<String> ids) {
        System.out.println("Enter ID of your transaction");
        String id = sc.nextLine();
        //sc.nextLine();
        if (ids.contains(id)) {
            int index = 0;
            for (int i = 0; i < ids.size(); i++) {
                if (id.equals(transactions.get(i).getId())) {
                    index = i;
                }
            }
            transactions.remove(index);
        }else{
            System.out.println("Invalid ID");
        }
    }
    static double CheckBalance(ArrayList<Transaction>  transactions) {
        double balance=0;
        for(Transaction t:transactions){
            if(t.getType().equals("INCOME")){
                balance+=t.getAmount();
            }else{
                balance-=t.getAmount();
            }

        }
    return balance;
    }


    static String IDSetter(Scanner sc, Set<String> IDs) {
        System.out.println("Enter transaction ID: ");
        String id=sc.nextLine();
        if(IDs.contains(id)){
            System.out.println("ID already exists. Enter properly");
             return IDSetter(sc,IDs);
        }
        return id;
    }
    static String TypeSetter(Scanner sc, Set<String> types) {
        System.out.println("Enter transaction Type: (INCOME or EXPENSE)");
        String type=sc.nextLine().toUpperCase();
        if(types.contains(type)){
            return type;
        }else {
            System.out.println("Type doesn't exist. Enter properly");
            return TypeSetter(sc,types);
        }
    }
    static double AmountSetter(Scanner sc) {
        System.out.println("Enter transaction Amount: ");
        double amount=sc.nextDouble();
        sc.nextLine();
        if(amount<0){
            System.out.println("Cannot be less than zero");
             return AmountSetter(sc);
        }
        return amount;
    }
    static String DateSetter(Scanner sc) {
        System.out.println("write <today> to enter today's date or Enter manually (Format- YYYY-MM-DD) ");
        String date=sc.nextLine();
        //sc.nextLine();
        if (date.equals("today")){
            int year= LocalDate.now().getYear();
            int month= LocalDate.now().getMonthValue();
            int day= LocalDate.now().getDayOfMonth();
            return year+"-"+month+"-"+day;
        }else {
            String [] dateParts=date.split("-");
            int year=Integer.parseInt(dateParts[0]);
            int month=Integer.parseInt(dateParts[1]);
            int day=Integer.parseInt(dateParts[2]);
            if(year<2000 ||year>3000 || month>12 || day>30) {
                System.out.println("Invalid date");
                 return DateSetter(sc);
            }
            return date;
        }
    }
}

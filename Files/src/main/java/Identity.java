import java.time.LocalDate;
public class Identity {

    String name, course, purpose, greetings;
    String date= String.valueOf(LocalDate.now());
    String day=date.substring(8);
    int month=Integer.parseInt(date.substring(5,7));
    String Month=getMonth(month);
    String year=date.substring(0,4);
    public Identity() {
        name = "Sherajus Salehin";
        course="Spring Boot Development";
        purpose="To learn about industry standard and scalable projects,\nwith focus on E-commerce backend systems.";
        greetings="Hello everyone!";
    }

    String AllInfo(){
        return "name: "+name+"\ncourse name:"+course+"\nPurpose: "+purpose+"\nThe current date today: "+Month+" "+day+", "+year+"\n"+greetings;
    }

    public String getName() {
        return name;
    }



    public String getPurpose() {
        return purpose;
    }
    String getMonth(int m){
        String month="";
        switch (m){
            case 1 ->month="JAN";
            case 2-> month="Feb";
            case 3-> month="Mar";
            case 4-> month="Apr";
            case 5-> month="May";
            case 6-> month="Jun";
            case 7-> month="Jul";
            case 8-> month="Aug";
            case 9-> month="Sep";
            case 10-> month="Oct";
            case 11-> month="Nov";
            case 12-> month="Dec";
        }

        return month;
    }

}

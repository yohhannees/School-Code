import java.util.Scanner;

public class Hourly_employee  extends Employee{
    Scanner in=new Scanner(System.in);
    int hours;
  double wage,salary;

    Hourly_employee(String fname, String lname, int ssn,int hours,double wage) {
        super(fname, lname, ssn);
        this.hours=hours;
        this.wage=wage;
    }

    @Override
    double earnings() {
        if (hours<=40){
            salary=wage*hours;

        } else  {
          salary=(wage*40) +(hours-40)*(wage*1.5);
        }
        return salary;
    }






}

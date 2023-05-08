import java.util.Scanner;

public class Salarid_Employee extends Employee {
    double weekly_salary,monthly_salary,salary;

 /*Scanner input=new Scanner(System.in);*/

    Salarid_Employee(String fname,String lname,int ssn){
         super(fname,lname,ssn);
    }




    @Override
    double earnings() {
         salary=monthly_salary*12;

        return salary;
    }
    public double weekly_salary(){
         weekly_salary=(monthly_salary*12)/52;

        return weekly_salary;
    }





}

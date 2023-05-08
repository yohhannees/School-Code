public class BasePulsCommission  extends Commisson_employee{

   double baseSalary,salary;
    BasePulsCommission(String fname, String lname, int ssn, double grossRate, double commissionRate,double baseSalary) {
        super(fname, lname, ssn, grossRate, commissionRate);
        this.baseSalary =baseSalary;
    }


    double earnings(){
        salary=(super.commissionRate*super.grossRate)+baseSalary;
        return salary;
     }


}

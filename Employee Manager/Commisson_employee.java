public class Commisson_employee extends Employee{
    double grossRate,commissionRate;
    private double salary;
    Commisson_employee(String fname, String lname, int ssn,double grossRate,double commissionRate) {
        super(fname, lname, ssn);
        this.commissionRate=commissionRate;;
        this.grossRate=grossRate;
    }

    @Override
    double earnings() {
          salary=commissionRate*grossRate;
        return salary;
    }
}

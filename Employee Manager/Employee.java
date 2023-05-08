import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Employee {


    Employee(String fname, String lname, int ssn) {
        this.fname = fname;
        ;
        this.lname = lname;
        this.ssn = ssn;
    }

    abstract double earnings();

    private String fname, lname;
    private int ssn;


    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return getClass().getName();
    }

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver found");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }

        String url = "jdbc:mysql://localhost/employee";
        String root = "root";
        String password = "Yihune.Zewdie@123";
        Connection conn = DriverManager.getConnection(url, root, password);
        System.out.println("success");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = null;
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("1.insert\n2. display");
        System.out.println("option:");
        while (input.hasNextDouble()) {
            try {
                option = input.nextInt();
            } catch (InputMismatchException e) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("1.salarid_employee \n2.hourlyEmployee\n3.commissionEmployee \n4. base plus commission employee\n");
                    int choice;
                    choice = input.nextInt();
                                    switch (choice) {
                                        case 1:

                                            String fname = "", lname = " ";
                                            int ssn = 0;
                                            double weekly_salary, monthly_salary, salary;
                                            Salarid_Employee salarid_employee = new Salarid_Employee(fname, lname, ssn);
                                            System.out.println("\t***Insert employee data***");
                                            System.out.println("Enter first name:");
                                            fname = input.next();
                                            System.out.println("Enter last name:");
                                            lname = input.next();
                                            System.out.println("Enter ssn:");
                                            ssn = input.nextInt();
                                            System.out.println("Enter monthly salary:");
                                            monthly_salary = input.nextDouble();

                                            salarid_employee.monthly_salary = monthly_salary;
                                            weekly_salary = salarid_employee.weekly_salary();
                                            salary = salarid_employee.earnings();

                                            String s = "INSERT INTO salarid_employee " +
                                                    "VALUES('" + fname + "','" +
                                                    lname + "','" + ssn + "','"
                                                    + weekly_salary + "','" + monthly_salary
                                                    + "','" + salary + "')";
                                            stmt.execute(s);
                                            System.out.println("successfully inserted!\n");
                                            break;
                                        case 2:
                                             fname = "";
                                             lname = " ";
                                             ssn = 0;
                                            int hours = 0;
                                            double wage = 0;
                                            Hourly_employee hourlyEmployee = new Hourly_employee(fname, lname, ssn, hours, wage);

                                            System.out.println("\t***Insert employee data***");
                                            System.out.println("Enter first name:");
                                            fname = input.next();
                                            System.out.println("Enter last name:");
                                            lname = input.next();
                                            System.out.println("Enter ssn:");
                                            ssn = input.nextInt();
                                            System.out.println("Enter hours:");
                                            hours = input.nextInt();
                                            System.out.println("Enter wage:");
                                            wage = input.nextDouble();


                                            salary = hourlyEmployee.earnings();
                                            s = "INSERT INTO hourly_employee " +
                                                    "VALUES('" + fname + "','" +
                                                    lname + "','" + ssn + "','"
                                                    + hours + "','" + wage
                                                    + "','" + salary + "')";

                                            stmt.execute(s);
                                            System.out.println("successfully inserted!");

                                            break;
                                        case 3:
                                            fname = "";
                                            lname = " ";
                                            ssn = 0;
                                            double grossRate = 0;
                                            double commisionRate = 0;
                                            double Salary = 0;
                                            Commisson_employee commissionEmployee = new Commisson_employee(fname, lname, ssn, grossRate, commisionRate);

                                            System.out.println("\t***Insert employee data***");
                                            System.out.println("Enter first name:");
                                            fname = input.next();
                                            System.out.println("Enter last name:");
                                            lname = input.next();
                                            System.out.println("Enter ssn:");
                                            ssn = input.nextInt();
                                            System.out.println("Enter gross rate:");
                                            grossRate = input.nextInt();
                                            System.out.println("Enter commission rate:");
                                            commisionRate = input.nextDouble();

                                            salary = commissionEmployee.earnings();
                                            s = "INSERT INTO commission_employee " +
                                                    "VALUES('" + fname + "','" +
                                                    lname + "','" + ssn + "','"
                                                    + grossRate + "','" + commisionRate
                                                    + "','" + Salary + "')";
                                            stmt.execute(s);
                                            System.out.println("successfully inserted!");
                                            break;
                                        case 4:
                                            fname = "";
                                            lname = " ";
                                            ssn = 0;
                                             grossRate = 0;
                                             commisionRate = 0;
                                             Salary = 0;
                                            double baseSalary=0;
                                            BasePulsCommission basePulsCommission = new BasePulsCommission(fname, lname, ssn, grossRate, commisionRate,baseSalary);

                                            System.out.println("\t***Insert employee data***");
                                            System.out.println("Enter first name:");
                                            fname = input.next();
                                            System.out.println("Enter last name:");
                                            lname = input.next();
                                            System.out.println("Enter ssn:");
                                            ssn = input.nextInt();
                                            System.out.println("Enter gross rate:");
                                            grossRate = input.nextInt();
                                            System.out.println("Enter commission rate:");
                                            commisionRate = input.nextDouble();
                                            System.out.println("Enter base salary:");
                                            baseSalary=input.nextDouble();

                                             basePulsCommission.baseSalary=baseSalary;
                                            salary = basePulsCommission.earnings();
                                            s = "INSERT INTO basePlusCommission " +
                                                    "VALUES('" + fname + "','" +
                                                    lname + "','" + ssn + "','"
                                                    + grossRate + "','" + commisionRate
                                                    + "','" + baseSalary +"','"+salary +"')";
                                            stmt.execute(s);
                                            System.out.println("successfully inserted!");

                                            break;
                                        default:
                                            System.out.println("error try again!");
                                    }

                           break;
                case 2:
                    System.out.println("1.salarid_employee \n2.hourlyEmployee\n3.commissionEmployee \n4. base plus commission employee\n");

                    System.out.println("Enter choice:");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:

                            resultSet = stmt.executeQuery("SELECT * FROM salarid_employee");
                            if (resultSet != null) {
                                while (resultSet.next()) {
                                    String  fname = resultSet.getString("fname");
                                    String  lname = resultSet.getString("lname");
                                    int ssn = resultSet.getInt("ssn");
                                    double   weekly_salary = resultSet.getDouble("weekly_salary");
                                    double monthly_salary = resultSet.getDouble("monthly_salary");
                                    double   salary = resultSet.getDouble("salary");

                                    System.out.println(fname + " " + lname + " " + ssn + " " + weekly_salary + " " + monthly_salary + " " + salary);

                                }
                            } else {
                                System.out.println("There is no file");
                            }
                            break;
                        case 2:
                            resultSet = stmt.executeQuery("SELECT * FROM hourly_employee");
                            if (resultSet != null) {
                                while (resultSet.next()) {
                                    String  fname = resultSet.getString("fname");
                                    String  lname = resultSet.getString("lname");
                                    int ssn = resultSet.getInt("ssn");
                                    int hours= resultSet.getInt("hours");

                                    double   wage = resultSet.getDouble("wage");
                                    double   salary = resultSet.getDouble("salary");

                                    System.out.println(fname + " " + lname + " " + ssn + " "  + " " + wage + " " + salary);

                                }
                            } else {
                                System.out.println("There is no file");
                            }
                            break;
                        case 3:
                            resultSet = stmt.executeQuery("SELECT * FROM commission_employee");
                            if (resultSet != null) {
                                while (resultSet.next()) {
                                    String  fname = resultSet.getString("fname");
                                    String  lname = resultSet.getString("lname");
                                    int ssn = resultSet.getInt("ssn");

                                    double   grossRate = resultSet.getDouble("grossRate");
                                    double   commissionRate = resultSet.getDouble("commissionRate");
                                    double   salary = resultSet.getDouble("salary");

                      System.out.println(fname + " " + lname + "|" + ssn  + " |" + grossRate + " " +commissionRate+" "+ salary);

                                }
                            } else {
                                System.out.println("There is no file");
                            }
                            break;
                        case 4:
                            resultSet = stmt.executeQuery("SELECT * FROM basePlusCommission");
                            if (resultSet != null) {
                                while (resultSet.next()) {
                                    String  fname = resultSet.getString("fname");
                                    String  lname = resultSet.getString("lname");
                                    int ssn = resultSet.getInt("ssn");

                                    double   grossRate = resultSet.getDouble("grossRate");
                                    double   commissionRate = resultSet.getDouble("commissionRate");
                                    double   salary = resultSet.getDouble("salary");
                                    double   baseSalary= resultSet.getDouble("baseSalary");

                                    System.out.println(fname + " " + lname + "|" + ssn  + " " + grossRate + " " +commissionRate+"  "+" "+ salary);

                                }
                            } else {
                                System.out.println("There is no file");
                            }
                            break;
                        default:
                            System.out.println("error try again!");
                    }
            }

        }
    }
}

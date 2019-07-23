public class Employee {

    private int baseHours = 40;
    private double baseSalary = 40000.0;
    private int baseVacationDays = 10;
    private String baseVacationForm = "yellow";

    // a class to represent employees in general
    public int getHours(){
        return baseHours; // 40 hours/week
    }

    public double getSalary(){
        return baseSalary; // $40,000.00
    }

    public int getVacationDays(){
        return baseVacationDays; // 10 days
    }

    public String getVacationForm(){
        return baseVacationForm; // yellow
    }

    public final void setBaseHours(int hours){
        baseHours = hours;
    }

    public final void setBaseSalary(double salary){
        baseSalary = salary;
    }

    public final void setBaseVacationDays (int days){
        baseVacationDays = days;
    }

    public final void setBaseVacationForm (String form){
        baseVacationForm = form;
    }
}

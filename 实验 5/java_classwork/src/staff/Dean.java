package staff;

import java.util.Date;

public class Dean extends Teacher{
    private int adminAward;

    public Dean(String department, String speciality, int postAllowance, int adminAward) {
        super(department, speciality, postAllowance);
        this.adminAward = adminAward;
    }

    public Dean(String name, String address, String sex, int age, int salary, Date dateHired, String department, String speciality, int postAllowance, int adminAward) {
        super(name, address, sex, age, salary, dateHired, department, speciality, postAllowance);
        this.adminAward = adminAward;
    }

    public int getAdminAward() {
        return adminAward;
    }

    public void setAdminAward(int adminAward) {
        this.adminAward = adminAward;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + getAdminAward();
    }

    @Override
    public String toString() {
        return super.toString() + "\n  is Dean{" +
                "adminAward=" + adminAward +
                '}';
    }
}

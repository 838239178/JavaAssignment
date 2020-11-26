package staff;

import java.util.Date;

public class Teacher extends Staff{
    private String department;
    private String speciality;
    private int postAllowance;

    public Teacher(String department, String speciality, int postAllowance) {
        super();
        this.department = department;
        this.speciality = speciality;
        this.postAllowance = postAllowance;
    }

    public Teacher(String name, String address, String sex, int age, int salary, Date dateHired, String department, String speciality, int postAllowance) {
        super(name, address, sex, age, salary, dateHired);
        this.department = department;
        this.speciality = speciality;
        this.postAllowance = postAllowance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getPostAllowance() {
        return postAllowance;
    }

    public void setPostAllowance(int postAllowance) {
        this.postAllowance = postAllowance;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + getPostAllowance();
    }

    @Override
    public String toString() {
        return super.toString() + "\n is Teacher{" +
                "department='" + department + '\'' +
                ", speciality='" + speciality + '\'' +
                ", postAllowance=" + postAllowance +
                '}';
    }
}

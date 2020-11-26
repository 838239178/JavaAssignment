package staff;

import java.util.Date;

public class Staff {
    private String name;
    private String address;
    private String sex;
    private int age;
    private int salary;
    private Date dateHired;

    public Staff(){
        name = address = sex = "null";
        age = salary = 0;
        dateHired = new Date();
    }
    public Staff(String name, String address, String sex, int age, int salary, Date dateHired) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + getSalary() +
                ", dateHired=" + dateHired +
                '}';
    }
}

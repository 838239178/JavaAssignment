package staff;

import java.util.Date;

public class SecurityGuard extends Staff{
    private String skills;
    int dangerousAllowance;

    public SecurityGuard(String skills, int dangerousAllowance){
        super();
        this.skills = skills;
        this.dangerousAllowance = dangerousAllowance;
    }

    public SecurityGuard(String name, String address, String sex, int age, int salary, Date dateHired, String skills, int dangerousAllowance) {
        super(name, address, sex, age, salary, dateHired);
        this.skills = skills;
        this.dangerousAllowance = dangerousAllowance;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getDangerousAllowance() {
        return dangerousAllowance;
    }

    public void setDangerousAllowance(int dangerousAllowance) {
        this.dangerousAllowance = dangerousAllowance;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + getDangerousAllowance();
    }

    @Override
    public String toString() {
        return super.toString() + "\n is SecurityGuard{" +
                "skills='" + skills + '\'' +
                ", dangerousAllowance=" + dangerousAllowance +
                '}';
    }
}

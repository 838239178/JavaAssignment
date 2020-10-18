package staff;

import java.util.*;

public class StaffTest {
    public static void main(String[] args) {
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(new Teacher("computer", "software", 5000));
        staffs.add(new Dean("computer", "software", 8000, 4000));
        staffs.add(new SecurityGuard("fight",3000));
        staffs.add(new Staff());
        for (Staff temp : staffs) {
            temp.setSalary( (int) (Math.random() * 500 + 500));
            temp.setAddress("Xiamen");
            temp.setAge((int) (Math.random() * 35 + 20));
            temp.setDateHired(new Date(2015-1900, (int)(Math.random() * 11 + 1), (int)(Math.random() * 29 + 1)));
            temp.setSex("man");
            temp.setName("张三" + staffs.indexOf(temp));
            System.out.println(temp.toString());
        }

        printName(staffs.toArray(new Staff[0]));
        printSalary(staffs.toArray(new Staff[0]));
        sortByDateHired(staffs.toArray(new Staff[0]));
        sortBySalary(staffs.toArray(new Staff[0]));
        sortByAge(staffs.toArray(new Staff[0]));

    }

    public static void printName(Staff[] persons){
        System.out.println("name of staff:");
        for (Staff temp : persons) {
            System.out.println(temp.getName());
        }
    }

    public static void printSalary(Staff[] staffs){
        System.out.println("salary of staff:");
        for (Staff temp : staffs) {
            System.out.println(temp.getName() + ": " + temp.getSalary());
        }
    }

    public static void sortBySalary(Staff[] staffs){
        for(int i = 1; i<staffs.length; i++){
            Staff temp = staffs[i];
            int j = i;
            while(j>0 && temp.getSalary()<staffs[j-1].getSalary()){
                staffs[j] = staffs[j-1];
                j--;
            }
            staffs[j] = temp;
        }

        System.out.println("sorted by salary");
        for (Staff temp : staffs) {
            System.out.println(temp.getName() + ": " + temp.getSalary());
        }
    }

    private static void sortByAge(Staff[] staffs){
        for(int i = 1; i<staffs.length; i++){
            Staff temp = staffs[i];
            int j = i;
            while(j>0 && temp.getAge()<staffs[j-1].getAge()){
                staffs[j] = staffs[j-1];
                j--;
            }
            staffs[j] = temp;
        }

        System.out.println("sorted by age");
        for (Staff temp : staffs) {
            System.out.println(temp.getName() + ": " + temp.getAge());
        }
    }

    private static void sortByDateHired(Staff[] staffs){
        for(int i = 1; i<staffs.length; i++){
            Staff temp = staffs[i];
            int j = i;
            while(j>0 && temp.getDateHired().getTime()<staffs[j-1].getDateHired().getTime()){
                staffs[j] = staffs[j-1];
                j--;
            }
            staffs[j] = temp;
        }

        System.out.println("sorted by hired day");
        for (Staff temp : staffs) {
            System.out.println(temp.getName() + ": " + temp.getDateHired());
        }
    }

}

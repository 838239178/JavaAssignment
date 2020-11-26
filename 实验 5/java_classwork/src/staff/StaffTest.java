package staff;

import staff.comparator.AgeComparator;
import staff.comparator.ComplexComparator;
import staff.comparator.NameComparator;

import java.util.*;

public class StaffTest {
    public static void main(String[] args) {
        //鍒濆鍖�
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
            temp.setName("Tom" + staffs.indexOf(temp));
        }
        Staff[] sArray = staffs.toArray(new Staff[0]);

        sortByDateHired(sArray);
        System.out.println("sorted by date");
        printStaff(sArray);

        sortBySalary(sArray);
        System.out.println("sorted by salary");
        printStaff(sArray);
        
        sortByAge(sArray); 
        System.out.println("sorted by age");
        printStaff(sArray);

        sortByName(sArray);
        System.out.println("sorted by name");
        printStaff(sArray);

        sortBySalaryAndName(sArray);
        System.out.println("sorted by salary and name");
        printStaff(sArray);

        sortByAgeLambda(sArray);
        System.out.println("sorted by age (lambda)");
        printStaff(sArray);

        sortByNameLambda(sArray);
        System.out.println("sorted by name (lambda)");
        printStaff(sArray);

        sortBySalaryAndNameLambda(sArray);
        System.out.println("sorted by salary and name (lambda)");
        printStaff(sArray);
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

    public static void printStaff(Staff[] staffs){
        for(Staff s : staffs)
            System.out.println(s.toString());
        System.out.println(" ");
    }

    private static void sortByAge(Staff[] staffs){
        Arrays.sort(staffs, new AgeComparator());
    }

    public static void sortBySalaryAndName(Staff[] staffs){
        Arrays.sort(staffs, new ComplexComparator());
    }

    public static void sortBySalary(Staff[] staffs){
        Arrays.sort(staffs, (o1, o2) -> -Integer.compare(o1.getSalary(), o2.getSalary()));
    }

    public static void sortByName(Staff[] staffs){
        Arrays.sort(staffs, new NameComparator());
    }

    private static void sortByDateHired(Staff[] staffs){
        Arrays.sort(staffs, Comparator.comparing(Staff::getDateHired));
    }

    public static void sortBySalaryAndNameLambda(Staff[] staffs){
        Arrays.sort(staffs, (s1, s2)->{
            if(s1.getSalary() == s2.getSalary())
                return s1.getName().compareTo(s2.getName());
            else
                return s1.getSalary()-s2.getSalary();
        });
    }

    public static void sortByNameLambda(Staff[] staffs){
        Arrays.sort(staffs, (s1,s2) -> s1.getName().compareTo(s2.getName()));
    }

    private static void sortByAgeLambda(Staff[] staffs){
        Arrays.sort(staffs, (s1,s2) -> s1.getAge()-s2.getAge());
    }



}

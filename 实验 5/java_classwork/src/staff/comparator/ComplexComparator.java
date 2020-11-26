package staff.comparator;

import staff.Staff;

import java.util.Comparator;

public class ComplexComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        if(o1.getSalary() == o2.getSalary())
            return o1.getName().compareTo(o2.getName());
        else
            return o1.getSalary() - o2.getSalary();
    }
}

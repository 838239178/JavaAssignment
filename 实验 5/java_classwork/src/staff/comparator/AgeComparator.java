package staff.comparator;

import staff.Staff;

import java.util.Comparator;

public class AgeComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

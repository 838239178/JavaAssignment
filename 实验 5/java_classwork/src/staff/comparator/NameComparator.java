package staff.comparator;

import staff.Staff;

import java.util.Comparator;

public class NameComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

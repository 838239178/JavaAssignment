package myutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        Student[] stu = new Student[100];
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student(Util.getRandomName(1, 4), Util.getRandomNumber(16, 23), Util.getRandomNumber(40, 100));
        }
        List stuList = new ArrayList<>(Arrays.asList(stu));
        System.out.println(stuList);
        
        Collections.sort(stuList);
        System.out.println("sorted: \n" + stuList);

        System.out.println("min=" + Collections.min(stuList));
        System.out.println("max=" + Collections.max(stuList));
        System.out.println("binary search 60 =" + stuList.get(Collections.binarySearch(stuList, new Student(60))));

        List otherList = findFailedStudents(stuList);
        System.out.println("other list: \n" + otherList);

        stuList.removeAll(otherList);
        System.out.println("remove other list:\n" + stuList);

        Collections.shuffle(stuList);
        System.out.println("shuffled:\n" + stuList);
        stuList.toArray(stu);
    }

    public static List findFailedStudents(List<Student> students) {
        List failedStudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade() < 60) {
                failedStudent.add(student);
            }
        }
        return failedStudent;
    }
}

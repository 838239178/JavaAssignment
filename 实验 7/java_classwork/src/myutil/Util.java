package myutil;

import java.util.*;

public class Util {
    public static String getRandomName(int min, int max) {
        StringBuilder sb = new StringBuilder();

        int n = getRandomNumber(min, max);

        while (n>0) {
            sb.append((char) getRandomNumber('a','z'));
            n--;
        }
        return sb.toString();
    }

    public static int getRandomNumber(int min, int max) {
        if(max<min)
            throw new IllegalArgumentException();

        return new Random().nextInt(max-min+1) + min;
    }

    public static List<Student> getRandomStudents(int n) {
        List<Student> stuList = new ArrayList<>();
        ListIterator it = stuList.listIterator();
        for (int i = 0; i < n; i++) {
            it.add(new Student(getRandomName(1, 4), getRandomNumber(15, 23)));
        }
        return stuList;
    }

    public static Map<String, Student> makeStudentMap(List<Student> stuList) {
        Map<String, Student> stuMap = new HashMap<>();
        ListIterator<Student> it = stuList.listIterator();
        while (it.hasNext()) {
            Student stu = it.next();
            stuMap.put(stu.getName(), stu);
        }
        return stuMap;
    }

    public static String searchName(List<String> nameList, String name) {
        for (String s : nameList) {
            if (s.equals(name))
                return name;
        }
        return null;
    }

    public static Student searchStudent(Map<String, Student> stuMap, String name) {
        return stuMap.getOrDefault(name, null);
    }

    public static List<String> generateNameList(int n) {
        List<String> strList = new ArrayList<>();
        ListIterator it = strList.listIterator();
        for (int i = 0; i < n; i++) {
            it.add(getRandomName(1, 4));
        }
        return strList;
    }

    public static Map<String, Student> generateStudentMap(int n) {
        List<Student> stuList = getRandomStudents(n);
        return makeStudentMap(stuList);
    }

    public static long getRuntime(Runnable command) {
        long start = System.nanoTime();
        command.run();
        long end = System.nanoTime();
        return end - start;
    }

    //测试
    public static void main(String[] args) {
        int size = 10000000;

        List<String> nameList = Util.generateNameList(size);
        Map<String, Student> stuMap = Util.generateStudentMap(size);

        //思考题：用哈希表更快，因为哈希表的原理是计算对象的hashcode从而达到接近O(1)的访问时间，而list是O(N)
        System.out.println("search name list (ms): " + (getRuntime(() -> Util.searchName(nameList, "tv"))/1e6));
        System.out.println("search student hashmap (ms):" + (getRuntime(() -> Util.searchStudent(stuMap, "tv"))/1e6));

        Iterator<Map.Entry<String, Student>> it = stuMap.entrySet().iterator();
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Student> entry = it.next();
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue() + ", entry=" + entry);
        }
    }
}

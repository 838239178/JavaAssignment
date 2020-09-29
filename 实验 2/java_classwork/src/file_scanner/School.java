package file_scanner;

import java.util.ArrayList;
import java.util.Random;

public class School {

    private ArrayList<Student> students;

    School(){
        students = new ArrayList<>();
    }

    public void addStudent(Student stu){
        students.add(stu);
    }

    public ArrayList<Student> getAllStu(){
        return (ArrayList<Student>) students.clone();
    }

    public void setStudents(ArrayList<Student> stus){
        students = (ArrayList<Student>) stus.clone();
    }

    public String[] findStudent(String name){
        ArrayList<String> result = new ArrayList<>();
        students.forEach((Student s)->{
            if(s.getName().equals(name))
                result.add(s.toString());
        });
        String[] resTemp = new String[result.size()];
        result.toArray(resTemp);
        return resTemp;
    }

    /**
     * 计算每一位学生的平均分和总分
     */
    public void countSource(){
        students.forEach((Student s)->{
            s.src.countAverage();
            s.src.countTotal();
        });
    }

    public ArrayList<Student> getExcellentStu(){
        students.sort(Student::compareTo);
        ArrayList<Student> excellent = new ArrayList<>();
        for(int i = 0; i<10; i++) excellent.add(students.get(i));
        return excellent;
    }

    /**
     * 静态方法，生成随机的学生数据
     * @param count 数量
     * @return 数组
     */
    public static ArrayList<Student> getRandomStu(int count){
        ArrayList<Student> stus = new ArrayList<>();
        Student stu;
        Random rand = new Random();
        for(int i = 0; i<count; i++){
            stu = new Student(i,rand.nextInt(50)+50,rand.nextInt(50)+50,rand.nextInt(50)+50);
            stus.add(stu);
        }
        return stus;
    }

}

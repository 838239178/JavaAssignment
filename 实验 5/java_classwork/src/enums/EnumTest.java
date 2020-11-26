package enums;

public class EnumTest {
    public static void main(String[] args) {
        City[] cities = {City.BEIJING, City.XIAMEN, City.SHANGHAI};
        University[] unis = {University.JMU, University.THU, University.XMU, University.PKU};
        for(City c : cities)
            System.out.println(c.toString()+" "+c.describe);
        for(University u : unis)
            System.out.println(u.toString() + " " + u.city + " " + u.describe);
    }
}

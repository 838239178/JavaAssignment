package enums;

public enum University {
    JMU(City.XIAMEN, "集美大学"),
    XMU(City.XIAMEN, "厦门大学"),
    THU(City.BEIJING, "清华大学"),
    PKU(City.BEIJING, "北京大学");
    public final City city;
    public final String describe;
    University(City city, String describe){
        this.city = city;
        this.describe = describe;
    }
}

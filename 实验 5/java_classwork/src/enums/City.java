package enums;

public enum City {
    XIAMEN("厦门市"),
    BEIJING("北京市"),
    SHANGHAI("上海市");

    public final String describe;
    City(String describe){
        this.describe = describe;
    }

}

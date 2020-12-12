package norm;

import java.util.*;

public class NameDaoImpl implements NameDao{
    @Override
    public List getNameFromArray(String[] names) {
        List<String> nameList = new LinkedList<>();
        ListIterator<String> it = nameList.listIterator();
        for (String name : names) {
            it.add(name);
        }
        return nameList;
    }

    @Override
    public int searchName(List nameList, String name) {
        return nameList.indexOf(name);
    }

    @Override
    public boolean removeFromList(List nameList, int id) throws IllegalArgumentException{
        try{
            nameList.remove(id);
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException();
        }
        return true;
    }

    //测试
    public static void main(String[] args) {
        NameDaoImpl impl = new NameDaoImpl();
        String[] names = {"android", "sony", "google"};
        List nameList = impl.getNameFromArray(names);

        System.out.println(nameList.toString());

        System.out.println("try search \"sony\": " + impl.searchName(nameList, "sony"));
        System.out.println("try search \"iphone\": " + impl.searchName(nameList, "iphone"));

        try{
            impl.removeFromList(nameList, 1);
            System.out.println("try remove \"id=1\" : result=" + nameList.toString());

            System.out.println("try remove \"id=100\"");
            impl.removeFromList(nameList, 100);
        } catch (IllegalArgumentException e){
            System.out.println("caught : " + e.toString());
        }
    }
}

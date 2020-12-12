package norm;

import java.util.List;

public interface NameDao {

    /**
     * 将数组中的字符串放入列表，该方法需要使用ListIterator接口实现添加
     *
     * @param names string[]
     * @return list
     */
    List getNameFromArray(String[] names);

    /**
     * 在列表中搜索到与name相同的项目，就返回该name所在的序号，找不到返回-1。
     *
     * @param nameList list
     * @param name string
     * @return list
     */
    int searchName(List nameList, String name);

    /**
     * 根据指定id，从列表中移除指定的项目，如果id指定错误(负数或者超出列表最大值)抛出IllegalArgumentException异常，移除成功返回true
     *
     * @param nameList list
     * @param id int
     * @return list
     */
    boolean removeFromList(List nameList, int id);
}

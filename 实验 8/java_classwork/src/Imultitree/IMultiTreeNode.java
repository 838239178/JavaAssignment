package Imultitree;

import java.util.*;

public class IMultiTreeNode<T> {
    private final List<IMultiTreeNode> children;
    private Object object;

    public IMultiTreeNode(T initialObject) {
        this.object = initialObject;
        children = new LinkedList<>();
    }

    public boolean hasChildren(){
        return !children.isEmpty();
    }

    public Iterator<IMultiTreeNode> getChildrenIterator() {
        return children.iterator();
    }


    public IMultiTreeNode addChild(T file) {
        IMultiTreeNode node = new IMultiTreeNode(file);
        addChild(node);
        return node;
    }

    public void addChild(IMultiTreeNode<T> node) {
        children.add(node);
    }

    public T get() {
        return (T) object;
    }

    public void set(T object) {
        this.object = object;
    }
}

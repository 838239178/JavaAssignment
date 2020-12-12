package Imultitree;

import java.util.*;

/**
 * 多叉树工具类
 *
 */
public abstract class IMultiTree {
    /**
     * 先序遍历迭代器
     *
     * @param root 树根结点
     * @param <T> 类型
     * @return Iterator迭代器
     */
    public static<T> Iterator<T> preOrderIterator(IMultiTreeNode<T> root){
        return new TreePreOrderIterator<>(root);
    }

    private static class TreePreOrderIterator<T> implements Iterator<T> {
        private final Stack<IMultiTreeNode> nodeStore;
        IMultiTreeNode current;

        public TreePreOrderIterator(IMultiTreeNode root) {
            nodeStore = new Stack<>();
            current = root;
        }

        @Override
        public boolean hasNext() {
            return current != null || !nodeStore.isEmpty();
        }

        @Override
        public T next() {
            IMultiTreeNode nextNode = current;
            current = null;
            if(nextNode == null)
                throw new NoSuchElementException();
            if (nextNode.hasChildren()) {
                Iterator<IMultiTreeNode> it = nextNode.getChildrenIterator();
                while (it.hasNext()) {
                    current = it.next();
                    nodeStore.push(current);
                }
                //删去current
                nodeStore.pop();
            } else if (!nodeStore.isEmpty()) {
                current = nodeStore.pop();
            }

            return (T) nextNode.get();
        }
    }

}

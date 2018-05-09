package com.demo.tree.tree;

import android.util.Log;

import java.util.Arrays;

/**
 * Description : 完全二叉树
 * <p/>
 * Created : TIAN FENG
 * Date : 2018/5/9
 * Email : 27674569@qq.com
 * Version : 1.0
 */
public class BinaryTree<T> implements Tree<T> {

    /**
     * 树的容器 这里使用数组实现树的结构
     */
    private Object[] treeContainer;

    /**
     * 默认容量
     */
    private static int sDafaultLen = 10;

    /**
     * 树的大小
     */
    private int treeSize;


    public BinaryTree() {
        this(sDafaultLen);
    }

    public BinaryTree(int len) {
        treeContainer = new Object[len];
    }

    /**
     * 找左子树
     *
     * @param parentNode 父节点
     * @return
     */
    @Override
    public T leftTree(T parentNode) {

        // 找这个节点的位置
        int index = find(parentNode);

        // 表示找到了这个节点
        if (index != -1) {
            // 左子树 = 2n + 1
            // 右子树 = 2n + 2

            // 左子树位置
            int childIndex = index * 2 + 1;
            if (childIndex < treeSize) {
                return (T) treeContainer[childIndex];
            }

        }
        return null;
    }

    /**
     * 找右子树
     *
     * @param parentNode 父节点
     * @return
     */
    @Override
    public T rightTree(T parentNode) {

        // 找这个节点的位置
        int index = find(parentNode);

        // 表示找到了这个节点
        if (index != -1) {
            // 左子树 = 2n + 1
            // 右子树 = 2n + 2

            // 左子树位置
            int childIndex = index * 2 + 2;
            if (childIndex < treeSize) {
                return (T) treeContainer[childIndex];
            }
        }

        return null;
    }

    /**
     * 找父节点
     *
     * @param target
     * @return
     */
    @Override
    public T findParent(T target) {
        // 找这个节点的位置
        int index = find(target);
        // 表示找到了这个节点
        if (index > 0) {
            // 先判断这个节点是左子树还是右子树
            // 左子树都为奇数
            // 右子树都为偶数
            boolean isLeft = index % 2 == 1;

            if (isLeft) {
                // 如果是左子树
                return (T) treeContainer[(index - 1) << 1];
            } else {
                // 如果是右子树
                return (T) treeContainer[(index - 2) << 1];
            }
        }
        return null;
    }

    /**
     * 找兄弟节点
     *
     * @param target
     * @return
     */
    @Override
    public T findBrother(T target) {
        // 找这个节点的位置
        int index = find(target);

        // 必须不是根节点
        if (index > 0) {
            // 判断是左子树还是右子树
            boolean isLeft = index % 2 == 1;

            // 是左子树
            if (isLeft) {
                // 判断有没有右子树
                if (index + 1 < treeSize) {
                    return (T) treeContainer[index + 1];
                }
            } else {
                // 有右子树必定有左子树
                return (T) treeContainer[index - 1];
            }
        }

        return null;
    }

    /**
     * 添加
     */
    @Override
    public void add(T data) {
        // 判断是否需要扩容
        if (treeSize >= treeContainer.length) {
            // 扩容
            resize();
        }

        // 赋值
        treeContainer[treeSize] = data;

        // 长度++
        treeSize++;
    }

    private void resize() {
        treeContainer = Arrays.copyOf(treeContainer, treeContainer.length << 1);
    }

    /**
     * 打印树
     */
    @Override
    public void prentTree() {
        prentTree(0);
    }

    /**
     * 求树的深度
     *
     * @return
     */
    @Override
    public int depth() {
        return (int) (log(treeSize,2)+1);
    }

    /**
     * 打印位置
     *
     * @param index
     */
    private void prentTree(int index) {
        if (index < treeSize) {

            // 先根 再左 再右
            Log.e("BinaryTree", treeContainer[index].toString());

            // 打左子树
            prentTree((index * 2 + 1));

            // 打右子树
            prentTree((index * 2 + 2));
        }
    }

    /**
     * 找位置
     */
    private int find(T data) {
        for (int i = 0; i < treeSize; i++) {
            if (data.equals(treeContainer[i])) {
                return i;
            }
        }
        return -1;
    }


    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}

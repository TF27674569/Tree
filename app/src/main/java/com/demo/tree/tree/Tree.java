package com.demo.tree.tree;

/**
 * Description : 树抽象接口
 * <p/>
 * Created : TIAN FENG
 * Date : 2018/5/9
 * Email : 27674569@qq.com
 * Version : 1.0
 */
public interface Tree<T> {

    /**
     * 找左子树
     *
     * @param parentNode 父节点
     * @return
     */
    T leftTree(T parentNode);

    /**
     * 找右
     *
     * @param parentNode 父节点
     * @return
     */
    T rightTree(T parentNode);

    /**
     * 找父节点
     *
     * @param target
     * @return
     */
    T findParent(T target);

    /**
     * 找兄弟节点
     *
     * @param target
     * @return
     */
    T findBrother(T target);

    /**
     * 添加
     *
     * @param data 添加
     */
    void add(T data);


    /**
     * 打印树
     */
    void prentTree();

    /**
     * 求树的深度
     * @return
     */
    int depth();

}

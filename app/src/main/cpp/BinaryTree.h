/**
 * Description : 二叉树
 * <p/>
 * Created : TIAN FENG
 * Date : 2018/5/9
 * Email : 27674569@qq.com
 * Version : 1.0
 */

#include <jni.h>
#ifndef TREE_BINARYTREE_H
#define TREE_BINARYTREE_H


#define TAG "BinaryTree-jni" // 这个是自定义的LOG的标识
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型



class BinaryTree {
public:
    BinaryTree();

    ~BinaryTree();

    void clear();

    void add(int const& data);

    void printTree();

private:
    // 树的容器
    int * treeContainer;
    int len;
    int index = 0;
    void _printTree(int index);
};


#endif //TREE_BINARYTREE_H

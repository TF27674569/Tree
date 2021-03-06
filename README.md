# 完全二叉树

## **一、树**
一种数据结构，它是由n（n>=1）个有限节点组成一个具有层次关系的集合。  
把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。 
它具有以下的特点：  
每个节点有零个或多个子节点；  
没有父节点的节点称为根节点；  
每一个非根节点有且只有一个父节点；  
除了根节点外，每个子节点可以分为多个不相交的子树  

&nbsp;　　1.节点度：每个节点有几个子节点则度为几   
&nbsp;　　2.树的度：所有节点中最大的节点度为树的度  
&nbsp;　　3.树的高：最底层的节点所在的层树，为树的高度  

![图1  普通树](https://github.com/TF27674569/Tree/blob/master/image/commontree.png)   
"普通树" 

&nbsp;　　树高为4，树的度为3  
![图2  有序树](https://github.com/TF27674569/Tree/blob/master/image/tree1.png)    
"有序树"     
![图3  无序树](https://github.com/TF27674569/Tree/blob/master/image/tree2.png)     
"无序树"  


## **二、二叉树**
是最大度为2的树成为二叉树，二叉树分为左子树，和右子树  

###### 相关术语
树的结点：包含一个数据元素及若干指向子树的分支；  
孩子结点：结点的子树的根称为该结点的孩子；  
双亲结点：B 结点是A 结点的孩子，则A结点是B 结点的双亲；  
兄弟结点：同一双亲的孩子结点； 堂兄结点：同一层上结点；  
祖先结点: 从根到该结点的所经分支上的所有结点子孙结点：以某结点为根的子树中任一结点都称为该结点的子孙  
结点层：根结点的层定义为1；根的孩子为第二层结点，依此类推；  
树的深度：树中最大的结点层  
结点的度：结点子树的个数  
树的度： 树中最大的结点度。  
叶子结点：也叫终端结点，是度为 0 的结点；  
分枝结点：度不为0的结点；  
有序树：子树有序的树，如：家族树；(一般研究二叉树都是以有序树为主)  
无序树：不考虑子树的顺序；  

## **三、满二叉树**
节点数为2的n-1次幂的二叉树
![图3  满二叉树](https://github.com/TF27674569/Tree/blob/master/image/full_two_tree.png)  

## **四、完全二叉树**
完全二叉树从根结点到倒数第二层满足完美二叉树，最后一层可以不完全填充，其叶子结点都靠左对齐。
![图4  完全二叉树](https://github.com/TF27674569/Tree/blob/master/image/prefct_two_tree.png) 
 
部分概念：  
1.满二叉树是完全二叉树，反正不一定  
2.在满二叉树的最底层，从最右边开始连续删除若干个节点后的树，为完全二叉树  
3.在完全二叉树中，如果没有左子树，必然没有右子树，但没有右子树，可能会有左子树  

算法规律：  
&nbsp;　　1.如果父节点下标为i，那么左子树下标为2*i+1,右子树下标为2*i+2  
&nbsp;　　2.如果子节点下标为1，那么父节点下标为(i-1)/2,如果为i为0，则为根节点  
&nbsp;　　3.除开根节点，左子树下标除2余1，左子树下标除2余0  


本demo使用数据结构表示树：  
1.数组省内存空间  
2.数组查询速度快  
3.下为关系图


![图5  完全二叉树](https://github.com/TF27674569/Tree/blob/master/image/tree4.png) 

## **五、代码实现**
1.抽象树函数
```java
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
```
2.树的存储对象和大小
```java
    /**
     * 树的容器 这里使用数组实现树的结构
     */
    private Object[] treeContainer;

    /**
     * 树的大小
     */
    private int treeSize;
```
3.由于是以数组的结构并且完全二叉树的添加都是在树为尾部操作所以给用户呈现的打印为树结构

```java
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
    
         if (index < treeSize) {
               
                // 打左子树
                prentTree((index * 2 + 1));
                
                 // 先左 再根 再右
                  Log.e("BinaryTree", treeContainer[index].toString());
    
                // 打右子树
                prentTree((index * 2 + 2));
            }
    
         if (index < treeSize) {
               
                // 打左子树
                prentTree((index * 2 + 1));
    
                // 打右子树
                prentTree((index * 2 + 2));
                
                 // 先左 再右 再根 
                  Log.e("BinaryTree", treeContainer[index].toString());
            }
```

可以将左子树，右子树 打印 的顺序改变，打印更多的结果




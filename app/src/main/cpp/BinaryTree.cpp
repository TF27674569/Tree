/**
 * Description :
 * <p/>
 * Created : TIAN FENG
 * Date : 2018/5/9
 * Email : 27674569@qq.com
 * Version : 1.0
 */


#include "BinaryTree.h"
#include "malloc.h"


BinaryTree::BinaryTree() {
    len = 20;
    treeContainer = (int *) malloc(sizeof(int) * len);
}

BinaryTree::~BinaryTree() {
    clear();
}

void BinaryTree::clear() {
    free(treeContainer);
}

template<class T>
void BinaryTree::add(int const &data) {
    treeContainer[index] = data;
    index++;
}

void BinaryTree::printTree() {
    _printTree(0);
}


void BinaryTree::_printTree(int position) {
    if (position<index){
        int value = treeContainer[position];
        _printTree(2*position+1);
        _printTree(2*position+2);
    }
}

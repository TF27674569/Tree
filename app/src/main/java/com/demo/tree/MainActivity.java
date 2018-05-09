package com.demo.tree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.demo.tree.tree.BinaryTree;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.

    BinaryTree<String> binaryTree = new BinaryTree<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 11; i++) {
            binaryTree.add(""+i);
        }

        binaryTree.prentTree();


        Log.e("TAG", binaryTree.depth()+"" );
    }

}

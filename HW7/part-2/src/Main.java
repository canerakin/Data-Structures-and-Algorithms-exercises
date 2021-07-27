import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();

        int i;
        BinarySearchTree<Integer> test_avl = new AVLTree<Integer>();
        for (i=1 ; i<=5 ; i++) {
            test_avl.add(i*10);
        }
        System.out.println(test_avl.toString());

        BinarySearchTree<Integer> test_RedBlack = new RedBlackTree<>();
        for (i=1; i<=5 ; i++) {
            test_RedBlack.add(i*11);
        }
        System.out.println(test_RedBlack.toString());
    }

}

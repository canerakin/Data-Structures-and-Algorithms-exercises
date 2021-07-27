import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i;
        System.out.print("Start Binary Search Tree : ");
        for(i = 0; i < 10; i++){
            BinarySearchTree();
        }
        System.out.print("\n\n");
        System.out.print("Start Red Black Tree : ");
        for(i = 0; i < 10; i++){
            RedBlackTree();
        }
        System.out.print("\n\n");
        System.out.print("Start 2 3 Tree : ");
        for(i = 0; i < 10; i++){
            TwoThreeTree();
        }
        System.out.print("\n\n");
        System.out.print("Start Binary Tree : ");
        for(i = 0; i < 10; i++){
            BinaryTree();
        }
        System.out.print("\n\n");
        System.out.print("Start Skip List : ");
        for(i = 0; i < 10; i++){
            SkipList();
        }

    }
    static void BinaryTree(){
        BTree<Integer> test = new BTree<Integer>(4);
        Random rand = new Random();
        int size = 80000;
        long startTime1 = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            test.add(rand.nextInt());
        }
        long stopTime1 = System.currentTimeMillis();
        System.out.print(stopTime1 - startTime1 + ", ");

    }
    static void BinarySearchTree(){
        BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
        int [] temp = new int[11];
        Random rand = new Random();
        int size = 10000;
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            test.add(rand.nextInt());
        }
        long stopTime2 = System.currentTimeMillis();
        System.out.print(stopTime2 - startTime2 + ", ");
    }
    static void RedBlackTree(){
        RedBlackTree<Integer> test = new RedBlackTree<Integer>();
        Random rand = new Random();
        int size = 80000;
        long startTime3 = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            test.add(rand.nextInt());
        }
        long stopTime3 = System.currentTimeMillis();
        System.out.print(stopTime3 - startTime3 + ", ");
    }
    static void TwoThreeTree(){
        BTree<Integer> test = new BTree<Integer>(10);
        Random rand = new Random();
        int size = 80000;
        long startTime4 = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            test.add(rand.nextInt());
        }
        long stopTime4 = System.currentTimeMillis();
        System.out.print(stopTime4 - startTime4 + ", ");
    }
    static void SkipList(){
        SkipList<Integer> test = new SkipList<Integer>();
        Random rand = new Random();
        int size = 80000;
        long startTime5 = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            test.add(rand.nextInt());
        }
        long stopTime5 = System.currentTimeMillis();
        System.out.print(stopTime5 - startTime5 + ", ");
    }
}

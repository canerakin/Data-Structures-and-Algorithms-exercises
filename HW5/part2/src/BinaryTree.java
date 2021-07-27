import java.io.Serializable;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * implemented BinaryTree
 * @param <K> generic key
 * @param <V> generic value
 */
public class BinaryTree<K,V> implements Serializable {

    /**
     * implemnted inner class for key-value
     * @param <K> generic key
     * @param <V> generic value
     */
    protected static class Entry<K,V> implements Serializable{
        /**
         * field key
         */
        protected K key;
        /**
         * field value of key
         */
        protected V value;
        /**
         * size
         */
        protected int numberOfPeople=1;
        /**
         * reference for left tree
         */
        protected Entry<K,V> left;
        /**
         * reference for right
         */
        protected Entry<K,V> right;

        /**
         * no parameter constructor
         */
        public Entry(){

        }

        /**
         * key - value constructor
         * @param key is key of value
         * @param value is value of key
         */
        public Entry(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }

        /**
         * constructor connected entry
         * @param data is value
         * @param size is size
         */
        public Entry(V data,int size){
            this.value=data;
            this.numberOfPeople=size;
            left=null;
            right=null;
        }

        /**
         * get key
         * @return key
         */
        public K getKey() {
            return key;
        }

        /**
         * set key
         * @param key is key of value
         */
        public void setKey(K key) {
            this.key = key;
        }

        /**
         * get value
         * @return value
         */
        public V getValue() {
            return value;
        }

        /**
         * set value
         * @param value is value of key
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * constructor connected tree
         * @param keyVal key value
         * @param dataVal value
         * @param left left reference
         * @param right right reference
         */
        public  Entry(K keyVal, V dataVal, Entry<K,V> left, Entry<K,V> right) {
            this.value = dataVal;
            this.key=keyVal;
            this.left=left;
            this.right=right;
        }

        /**
         * compare to
         * @param key is key
         * @param value is value
         * @return boolean
         */
        public boolean compareTo(K key,V value){
            if(this.key.equals(key) && this.value.equals(value)){
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * show key-value
         * @return string
         */
        public String toString(){
            return key.toString() + " " + value.toString();
        }
    }
    /********************************************************************************************************/
    /**
     * root of tree
     */
    protected Entry<K,V> root;


    /**
     * no parameter constructor
     */

    public BinaryTree(){
        root=null;
    }

    /**
     * The constructor that takes a Entry as a parameter is a protected constructor.
     * This is because client classes do not know about the Entry<K,V></K,V> class
     * This constructor can be used only by methods internal to the BinaryTree class and its subclass
     * @param root is head of binaryTree
     */
    protected BinaryTree(Entry<K,V> root){
        this.root = root;
    }

    /**
     * connected tree constructor
     * @param key is key of value
     * @param data calue of key
     * @param leftTree reference left
     * @param rightTree reference right
     */
    public BinaryTree(K key, V data,BinaryTree<K,V> leftTree,BinaryTree<K,V> rightTree){
        root = new Entry<K,V>(key,data);

        if(leftTree != null){
            root.left = leftTree.root;
        }
        else{
            root.left=null;
        }
        if(rightTree != null){
            root.right=rightTree.root;
        }
        else{
            root.right = null;
        }
    }


    /**
     *  give left tree
     * @return left tree
     */
    public BinaryTree<K,V> getLeftSubtree(){
        if(root!=null && root.left!=null){
            return new BinaryTree<>(root.left);
        }
        else
        {
            return null;
        }
    }

    /**
     * set root
     * @param root update
     */
    public void setRoot(Entry<K,V> root) {
        this.root = root;
    }

    /**
     *
     * give right tree
     * @return tree
     */
    public BinaryTree<K,V> getRightSubtree(){
        if(root!=null && root.right!=null){
            return new BinaryTree<>(root.right);
        }
        else
        {
            return null;
        }

    }

    /**
     * give value
     * @return value
     */
    public V getData(){
        return this.root.value;
    }

    /**
     * is there leaf
     * @return boolean
     */
    public boolean isLeaf(){
        return (root.left==null && root.right==null);
    }
    /**
     * show key value
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root,1,sb);
        return sb.toString();
    }

    /**
     * helping toString
     * @param node key value class(entry)
     * @param depth is depth
     * @param sb string builder
     */
    private void toString(Entry<K,V> node,int depth,StringBuilder sb){
        for(int i = 1 ;i< depth;i++){
            sb.append(" ");
        }
        if(node==null){
            sb.append("null\n");
        }
        else{
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left,depth+1,sb);
            toString(node.right,depth+1,sb);

        }
    }

    /**
     * Starter method for preorder traversal
     * @param consumer an object that instantiates
     *                 the BiConsumer interface.Its method implement
     *                 abstract method apply.
     */
    public void preOrderTraverse(BiConsumer<V,Integer> consumer){
        preOrderTraverse(root,1,consumer);
    }

    /**
     *  Performs a recursive preorder traversal of the tree,
     *  applying the action specified in the consumer object.
     * @param node is entry class (key-value)
     * @param depth is depth
     * @param consumer object whose accept method specifies the action to be performed on each node
     */
    private void preOrderTraverse(Entry<K,V> node ,int depth,BiConsumer<V,Integer> consumer){
        if(node==null){
            consumer.accept(null,depth);
        }else{
            consumer.accept(node.value,depth);
            preOrderTraverse(node.left,depth+1,consumer);
            preOrderTraverse(node.right,depth+1,consumer);
        }
    }

    /**
     * Method to read a binary tree
     * pre: The input consists of a preorder traversal of the binary tree .
     * The line "null" indicates a null tree.
     * @param scan the scanner attached to the input file
     * @return the binary tree
     */
    public  BinaryTree readBinaryTree(Scanner scan){

        //Read a line and trim leading and tailing spaces.

        String data = scan.nextLine().trim();
        String key = scan.nextLine().trim();
        if(data.equals("null")){
            return null;
        }
        else{
            BinaryTree<String,String> leftTree = readBinaryTree(scan);
            BinaryTree<String,String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String, String> (key,data,leftTree,rightTree);
        }
    }

}

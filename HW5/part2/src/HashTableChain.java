
/**
 * implemeted KWHashMap interface
 * hold on binaryTree in every index of table array
 * @param <K> generic key
 * @param <V> generic value
 */
public class HashTableChain<K, V extends Comparable<V>> implements KWHashMap<K, V> {


    private BinarySearchTree[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * no parameter constructor
     */
    public HashTableChain() {
        table = new BinarySearchTree[CAPACITY];
        for(int i = 0 ; i< CAPACITY;i++){
            table[i] = new BinarySearchTree<>();
            table[i].root = new BinaryTree.Entry();
            table[i].root.key = new BinaryTree.Entry<K,V>();
        }
    }

    /**
     * is there empty hashtablechain
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        if(size()==0)
            return  true;
        return false;
    }

    /**
     * helping remove metod
     * @param key is key of value
     * @param binarySearchTree  corresponding key tree of the table
     * @return removed value
     */
    private V remove(Object key,BinarySearchTree<K,V> binarySearchTree){

        V res = null;
        if (binarySearchTree.root.value == null) {
            return null;
        }
        else if (binarySearchTree.root.value != null) {
            if (binarySearchTree.root.getKey().equals(key)) {

                V oldVal = binarySearchTree.root.getValue();
                binarySearchTree.delete(oldVal);
                return oldVal;
            }
            else {
                res = get(key, binarySearchTree.getLeftSubtree());
                if (res != null) {
                    return res;
                }
                else {
                    res = get(key, binarySearchTree.getRightSubtree());
                    return res;
                }

            }
        }
        return res;
    }

    /**
     * remove all value to the corresponding key tree of the table
     * @param key is key of value
     * @return deleted value
     */
    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            return null;
        }
        V oldValue = get(key);

        /**
         while(!table[index].isLeaf()){
         oldValue = get(key);
         if(oldValue!=null){
         remove(key,table[index]);
         }
         }
         oldValue = get(key);
         if(oldValue!=null){
         remove(key,table[index]);
         }
         */
        numKeys--;
        table[index]=null;
        return oldValue;
    }

    /**
     * remove value of key (one item)
     * @param key is key of value
     * @param value is value of key
     * @return deleted value
     */
    public V remove(K key,V value){
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            return null;
        }
        table[index].delete(value);

        return value;

    }
    /**
     * return size of trees
     * @return size of trees
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * helping get method
     * @param key is key of value
     * @param binarySearchTree  corresponding key tree of the table
     * @return value of key
     */
    private V get(Object key,BinaryTree<K,V> binarySearchTree){
        V res=null;
        if(binarySearchTree.root.key==null){
            return null;
        }
        if(binarySearchTree.root.getKey().equals(key)){
            return binarySearchTree.root.getValue();
        }
        else{
            if(binarySearchTree.getLeftSubtree()!=null){
                res = get(key,binarySearchTree.getLeftSubtree());
            }

            if(res!=null){
                return res;
            }
            else{
                if(binarySearchTree.getRightSubtree()!=null)
                    res = get(key,binarySearchTree.getRightSubtree());
                return res;
            }

        }
    }
    /**
     *  return corresponding key tree of the table  Test
     * @param key is key of value
     * @return corresponding key tree of the table  Test
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        if(table[index]!=null)
            while(table[index].getData()!=null){
                BinaryTree<K,V> binarySearchTree = table[index];
                V res = get(key,binarySearchTree);
                if(res!=null){
                    return res;
                }
                index++;
            }

        return null;
    }

    /**
     * for table size
     * allocate array and copy old array to new array
     */
    private void rehash() {
        // Save a reference to oldTable.
        BinarySearchTree<K,V>[] oldTable = table;
        // Double capacity of this table.
        table = new BinarySearchTree[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;

        for(int i = 0 ; i< table.length;i++){
            table[i] = new BinarySearchTree<>();
            table[i].root = new BinaryTree.Entry();
            table[i].root.key = new BinaryTree.Entry<K,V>();
        }

        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null)) {
                // Insert entry in expanded table
                put(oldTable[i].root.getKey(), oldTable[i].root.getValue());
            }
        }
    }

    /**
     * helping toString method
     * @param binarySearchTree corresponding key tree of the table
     * @return string
     */
    private String toString(BinaryTree.Entry<K,V> binarySearchTree){
        if(binarySearchTree!=null && binarySearchTree.key!=null && binarySearchTree.value!=null){
            return binarySearchTree.key + " - " +  binarySearchTree.value +" ," + toString(binarySearchTree.left) + " ," + toString(binarySearchTree.right)  ;
        }
        return " ";
    }


    /**
     * helping put method
     * adds value to the corresponding key tree of the table
     * @param key is key of value
     * @param value is value of key
     * @param binarySearchTree corresponding key tree of the table
     * @return added value
     */
    private V put (K key,V value,BinarySearchTree<K,V> binarySearchTree) {
        V res = null;
        if (binarySearchTree.root.value == null) {
            return null;
        }
        else if (binarySearchTree.root.value != null) {
            if (binarySearchTree.root.getKey().equals(key)) {
                V oldVal = binarySearchTree.root.getValue();
                binarySearchTree.add(key,value);
                return oldVal;
            }
            else {
                res = get(key, binarySearchTree.getLeftSubtree());
                if (res != null) {
                    return res;
                }
                else {
                    res = get(key, binarySearchTree.getRightSubtree());
                    return res;
                }

            }
        }
        return res;
    }

    /**
     *  adds value to the corresponding key tree of the table
     * @param key is key of value
     * @param value is value of key
     * @return added value
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new BinarySearchTree();
            table[index].root = new BinaryTree.Entry();
            table[index].root.key = new BinaryTree.Entry<K,V>();
        }


        BinarySearchTree<K,V> binarySearchTree = table[index];
        V res = get(key,binarySearchTree);
        if(res!=null){
            put(key,value,binarySearchTree);
            return res;
        }

        table[index].root = new BinaryTree.Entry<>(key, value);
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;


    }

    /**
     * show key-value
     * @return string
     */
    @Override
    public String toString() {
        String res = "HASH TABLE CHAIN (size : " + size() + ") \n";
        for(int i = 0 ; i < table.length ;i++){
            if(table[i]!=null)
                if(table[i].root!=null){
                    if(table[i].root.key!=null){
                        res = res + toString(table[i].root)+"\n" ;
                    }
                }
        }
        return res;
    }
}
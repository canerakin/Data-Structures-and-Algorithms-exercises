
import java.util.LinkedList;

/**
 * design evey table index with linked list
 * @param <K> generic key of value
 * @param <V> generic value of key
 */
public class HashTableChainBook<K, V extends Comparable<V>> implements KWHashMap<K, V>{


    /**
     * inner class
     * @param <K> key of value
     * @param <V> value of key
     */
    private static class Entry<K, V> {
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }



    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    // Constructor
    public HashTableChainBook() {
        table = new LinkedList[CAPACITY];
    }

    /** Method get for class HashTableChainBook.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key))
                return nextItem.getValue();
        }
        // assert: key is not in the table.
        return null;
    }



    /** Method put for class HashTableChainBook.
     @post This key value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<>();
        }

        for(int i = 0 ; i< table.length;i++){
            if(table[i]!=null)
                for(int j = 0; j<table[i].size();j++){
                    if(table[i].get(j)!=null)
                        if(table[i].get(j).getKey().equals(key)){
                            V oldVal = table[i].get(j).getValue();
                            table[i].get(j).setValue(value);
                            return oldVal;
                        }
                }
        }

        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    /**
     * if table array exceed length ,create 2* length table array and copy oldtable array to new table array
     */
    private void rehash() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[2 * oldTable.length + 1];
        numKeys = 0;

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<Entry<K, V>>();
        }
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null)) {
                for (int j = 0; j < table[i].size(); j++) {
                    put(table[i].get(j).key, table[i].get(j).value);
                }
            }
        }
    }

    /**
     * remove values of key
     * @param key is key of value
     * @return removed values
     */
    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            return null;
        }
        V oldValue = get(key);
        numKeys--;
        table[index]=null;
        return oldValue;
    }

    /**
     * give size --> size is how much added key - value
     * @return size is how much added key - value
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * if table[i] linkedlist is empty true otherwise false
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * show key-value
     * @return string
     */
    @Override
    public String toString() {
        String res= "";

        for(int i = 0;i<table.length;i++){
            if(table[i]!=null)
                for(int j=0;j<table[i].size();j++){
                    res = res + " index :" + i +" --> " + table[i].get(j).key + " " + table[i].get(j).value + " ,";
                }
            res = res + " \n";
        }
        return res;
    }
}

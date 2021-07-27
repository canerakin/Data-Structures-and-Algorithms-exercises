/**
 * design hash table with array
 * probing hash(x) + hash(x)^2
 * @param <K> generic key of value
 * @param <V> generic value of key
 */
public class HashTableOpen<K, V> implements KWHashMap<K, V> {

    /**
     * for probing
     * @return
     */
    @Override
    public int hashCode() {
        return (super.hashCode()  + (super.hashCode() * super.hashCode()));
    }


    /**
     * inner class hold key and value
     * @param <K> generic key of value
     * @param <V> generic value of key
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


    /**
     * hashtable
     */
    private Entry<K, V>[] table;
    /**
     * start capacity
     */
    private static final int START_CAPACITY = 101;
    /**
     * load_thereshold for rehash
     */
    private double LOAD_THRESHOLD = 0.75;
    /**
     * added entry size
     */
    private int numKeys;
    /**
     * deleted entry size
     */
    private int numDeletes;
    /**
     *  to prevent leakage
     */
    private final Entry<K, V> DELETED = null;

    /**
     * no parameter constructor
     * create table
     */
    public HashTableOpen() {
        table = new Entry[START_CAPACITY];
    }



    /** Finds either the target key or the first empty slot in the
     search chain using linear probing.
     @pre The table is not full.
     @param key The key of the target object
     @return The position of the target or the first empty slot if
     the target is not in the table.
     */
    private int find(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;

        while ((table[index] != null)
                && (!key.equals(table[index].getKey()))) {
            index++;

            if (index >= table.length)
                index = 0;
        }
        return index;
    }


    /** Method get for class HashtableOpen.
     @param key The key being sought
     @return the value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = find(key);
        if (table[index] != null)
            return table[index].getValue();
        else
            return null;
    }



    /** Method put for class HashtableOpen.
     @post This key value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed. If the LOAD_THRESHOLD
     is exceeded, the table is expanded.
     @param key The key of item being inserted
     @param value The value for this key
     @return Old value associated with this key if found;
     otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = find(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }
        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }



    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     @post The size of the table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        Entry<K, V>[] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }


    /**
     * remove index
     * @param key is key of value
     * @return removed item
     */
    @Override
    public V remove(Object key) {
        int index = find(key);
        if (table[index] == null) {
            return null;
        }
        V res = table[index].value;
        table[index] = DELETED;
        numDeletes++;
        numKeys--;
        return res;
    }

    /**
     * return added hash table size(numKeys)
     * @return
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * if table is empty return true otherwise return false
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        if(size()==0){
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
        String res = "";

        for(int i = 0 ; i< table.length ;i++){

            if(table[i] != null){
                res = res + table[i].key + " - " + table[i].value + " table index " +  i + "\n";
            }
        }
        return res;
    }
}

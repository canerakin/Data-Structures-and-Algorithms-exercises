/**
 * define methods for KwHashTableChin class
 * @param <K> is key value
 * @param <V> is value of key
 */
public interface KWHashMap<K,V> {
    /**
     *  return corresponding key tree of the table  Test
     * @param key is key of value
     * @return corresponding key tree of the table  Test
     */
    V get(Object key);

    /**
     *
     * @return if map is emty true otherwise false
     */
    boolean isEmpty();

    /**
     *  adds value to the corresponding key tree of the table
     * @param key is key of value
     * @param value is value of key
     * @return added value
     */
    V put(K key, V value);

    /**
     * remove all value to the corresponding key tree of the table
     * @param key is key of value
     * @return deleted value
     */
    V remove(Object key);

    /**
     * return size of trees
     * @return size of trees
     */
    int size();

}

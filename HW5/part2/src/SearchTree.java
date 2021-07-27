/**
 * define binarySearchTree class
 * @param <K> generic key
 * @param <V> generic value
 */
public interface SearchTree<K,V> {
    /**
     * added key-value item in tree
     * @param key is key of value
     * @param item value of key
     * @return added value
     */
    boolean add(K key,V item);

    /**
     *
     * @param target is value of key
     * @return boolean
     */
    boolean contains(V target);

    /**
     * find value
     * @param target is value of key
     * @return key-value item
     */
    BinaryTree.Entry<K,V> find(V target);

    /**
     * deleted value
     * @param target value of key
     * @return deleted value
     */
    V delete(V target);

    /**
     * removed value
     * @param target value of key
     * @return boolean
     */
    boolean remove(V target);
}

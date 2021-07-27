public class BinarySearchTree<K,V extends Comparable<V>>
        extends BinaryTree<K,V> implements SearchTree<K,V> {

    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;
    /**
     * Return value from the public delete method.
     */
    protected V deleteReturn;

    /**
     * Starter method find.
     * pre: The target object must implement
     * the Comparable interface.
     *
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    public Entry<K,V> find(V target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtree's root
     * @param target    The object being sought
     * @return The object, if found, otherwise null
     */
    private Entry<K,V> find(Entry<K,V> localRoot, V target) {
        if (localRoot == null)
            return null;
        // Compare the target with the value field at the root.
        int compResult = target.compareTo(localRoot.value);
        if (compResult == 0)
            return localRoot;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /**
     * Starter method add.
     * pre: The object to insert must implement the
     * Comparable interface.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false
     * if the object already exists in the tree
     */
    public boolean add(K key,V item) {
        root = add(root, key, item);
        return addReturn;
    }

    @Override
    public boolean contains(V target) {
        return false;
    }

    /**
     * Recursive add method.
     * post: The value field addReturn is set true if the item is added to
     * the tree, false if the item is already in the tree.
     * @param key  key of value
     * @param localRoot The local root of the subtree
     * @param item      The object to be inserted
     * @return The new local root that now contains the
     * inserted item
     */
    private Entry<K,V> add(Entry<K,V> localRoot, K key,V item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Entry<K,V>(key , item);
        } else if (item.compareTo(localRoot.value) == 0) {
            // item is equal to localRoot.value
            addReturn = true;
            localRoot.numberOfPeople++;
            return localRoot;
        } else if (item.compareTo(localRoot.value) < 0) {
            // item is less than localRoot.value
            localRoot.left = add(localRoot.left, key,item);
            return localRoot;
        } else {
            // item is greater than localRoot.value
            localRoot.right = add(localRoot.right,key, item);
            return localRoot;
        }
    }


    /**
     * Starter method delete.
     * post: The object is not in the tree.
     *
     * @param target The object to be deleted
     * @return The object deleted from the tree
     * or null if the object was not in the tree
     * @throws ClassCastException if target does not implement
     *                            Comparable
     */
    public V delete(V target) {
        root = delete(root, target);
        return deleteReturn;
    }

    @Override
    public boolean remove(V target) {

        return false;
    }

    /**
     * Recursive delete method.
     * post: The item is not in the tree;
     * deleteReturn is equal to the deleted item
     * as it was stored in the tree or null
     * if the item was not found.
     *
     * @param localRoot The root of the current subtree
     * @param item      The item to be deleted
     * @return The modified local root that does not contain
     * the item
     */
    private Entry<K,V> delete(Entry<K,V> localRoot, V item) {
        if (localRoot == null) {

            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.value);
        if (compResult < 0) {

            // item is smaller than localRoot.value.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.value.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            if(localRoot.numberOfPeople!=1){
                localRoot.numberOfPeople--;
                return localRoot;
            }

            // item is at local root.
            deleteReturn = localRoot.value;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;

            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {


                // Entry being deleted has 2 children, replace the value
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the value with the value in the
                    // left child.
                    localRoot.value = localRoot.left.value;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's value with ip.
                    localRoot.value = findLargestChild(localRoot.left);
                    return localRoot;
                }

            }

        }
    }

    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * post: The inorder predecessor is removed from the tree.
     *
     * @param parent The parent of possible inorder
     *               predecessor (ip)
     * @return The value in the ip
     */
    private V findLargestChild(Entry<K,V> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            V returnValue = parent.right.value;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * show root
     * @return string
     */
    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}


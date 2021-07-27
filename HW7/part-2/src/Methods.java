

public class Methods {
    /**
     *  There check is that a AVL tree
     * @param test is Binary search tree
     * @return boolean expiression
     */
    public boolean Is_AVL(BinarySearchTree test){
        boolean control = true;
        Is_AVLTree( test ,true );
        if (control == true) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This control mean if true , avl tree
     * @param test is binary search tree
     * @param control is a AVL
     * @return height of node
     */
    private int Is_AVLTree(BinarySearchTree test , boolean control) {
        try {
            if (test == null) {
                return 0;
            }
            else {
                int left = Is_AVLTree((BinarySearchTree<Integer>) test.getLeftSubtree(),control);
                int right = Is_AVLTree((BinarySearchTree<Integer>) test.getRightSubtree(),control);
                int minus = right - left;
                if (minus > 1) {
                    control = false ;
                    return right + 1;
                }
                else if (minus < -1) {
                    control = false;
                    return left + 1;
                }
                else if (minus == -1) {
                    return left + 1 ;
                }
                else {
                    return right + 1;
                }
            }
        }catch (Exception exception) {
            System.out.println("AVL tree \n Exception");
            control = false;
            return -2;
        }
    }


    /**
     * This method for check is Red Black Tree
     * @param test is binary search tree
     * @return is red black or not
     */
    public boolean Is_RedBlack(BinarySearchTree test){
        boolean control = true;
        Is_RedBlackTree( test ,true );
        if (control == true) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This control mean if true , RedBlack tree
     * @param test is binary search tree
     * @param control if check
     * @return boolean expression
     */
    private int Is_RedBlackTree(BinarySearchTree test , boolean control) {
        try {
            if (test == null) {
                return 0;
            }
            else
            {
                int left = Is_RedBlackTree((BinarySearchTree<Integer>) test.getLeftSubtree(),control);
                int right = Is_RedBlackTree((BinarySearchTree<Integer>) test.getRightSubtree(),control);

                if (test.isLeaf() == true){
                    if (left != right) {
                        control = false;
                        return right + 1;
                    }
                    else
                    {
                        return left + 1;
                    }
                }
                else
                {
                    if (left != right) {
                        control = false;
                        return right;
                    }
                    else
                    {
                        return left;
                    }
                }
            }
        }catch (Exception exception) {
            System.out.println("Red Black tree \n Exception");
            control = false;
            return -2;
        }
    }
}

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *  2 3 Tree implementation
 */
class Tree23{
    Node root = new Node();

    protected static class Node{
        private static final int ORDER = 4;
        private int numItems = 0;
        private Node parent;
        private Node childArray[] = new Node[ORDER];
        private DataItem itemArray[] = new DataItem[ORDER-1];

        public DataItem findItem(int value){
            for(DataItem item : itemArray){
                if(item.getValue() == value){
                    return item;
                }
            }
            return null;
        }

        public void displayNode(){
            for(int i = 0; i < numItems; i++){
                System.out.print(itemArray[i]);
            }
            System.out.println();
        }

        public int getNumItems(){
            return numItems;
        }

        public Node getChild(int index){
            return childArray[index];
        }

        public DataItem remove(int index){
            DataItem item = itemArray[index];
            itemArray[index] = null;
            numItems--;
            return item;
        }

        public Node disconnect(int index){
            Node node = childArray[index];
            childArray[index] = null;
            return node;
        }

        public void connect(int index, Node node){
            childArray[index] = node;
        }

        public Node getParent(){
            return parent;
        }

        public void setParent(Node node){
            parent = node;
        }

        public boolean isFull(){
            return numItems == 3;
        }

        public int insertItem(DataItem item){
            int i = 0;
            for(; i < numItems; i++){
                if(item.getValue() < itemArray[i].getValue()){
                    for(int j = numItems; j > i; j--){
                        itemArray[j] = itemArray[j-1];
                    }
                    break;
                }else if(item.getValue() == itemArray[i].getValue()){
                    return -1;
                }
            }
            itemArray[i] = item;
            numItems++;
            return i;
        }

        public Node getNextNode(int value){
            for(int i = 0; i < numItems; i++){
                if(value < itemArray[i].getValue()){
                    return childArray[i];
                }
            }
            return childArray[numItems];
        }

        public boolean isLeaf(){
            return childArray[0] == null;
        }
    }

    protected static class DataItem{
        private int value;

        public DataItem(int v){
            value = v;
        }

        @Override
        public String toString(){
            return "/" + value;
        }

        public int getValue(){
            return value;
        }
    }



    public DataItem find(int value){
        Node node = root;
        while(node != null){
            DataItem item = node.findItem(value);
            if(item == null){
                node = node.getNextNode(value);
            }else{
                return item;
            }
        }
        return null;
    }

    public void insert(DataItem item){
        Node node = root;
        while(node != null){
            if(node.isFull()){
                // split when encountering a full node
                split(node);
                node = node.getParent().getNextNode(item.getValue());
            }else if(node.isLeaf()){
                //Found the leaves
                break;
            }else{
                //Continue to look down
                node = node.getNextNode(item.getValue());
            }
        }
        node.insertItem(item);
    }

    public void split(Node node){
        DataItem item1 = node.remove(1);
        DataItem item2 = node.remove(2);
        Node child2 = node.disconnect(2);
        Node child3 = node.disconnect(3);

        Node newRight = new Node();
        newRight.insertItem(item2);
        newRight.connect(0, child2);
        newRight.connect(1, child3);

        if(node == root){
            //When the root node is full
            root = new Node();
            root.insertItem(item1);
            root.connect(0, node);
            root.connect(1, newRight);
            node.setParent(root);
            newRight.setParent(root);
        }else {
            // child node
            int loc = node.getParent().insertItem(item1);
            Node parent = node.getParent();
            int i;
            for(i = node.getParent().getNumItems(); i > loc + 1; i--){
                parent.connect(i, parent.getChild(i-1));
            }
            node.getParent().connect(i, newRight);
            newRight.setParent(parent);
        }
        //You can find that the tree is up and up when you insert it.
    }

    public void levelTraverse() throws InterruptedException {
        if(root == null){return;}
        Queue<Node> que = new ArrayBlockingQueue<Node>(20);
        ((ArrayBlockingQueue<Node>) que).put(root);
        while(!que.isEmpty()){
            Node node = que.poll();
            node.displayNode();
            if(!node.isLeaf()){
                for(int i = 0; i <= node.getNumItems(); i++){
                    ((ArrayBlockingQueue<Node>) que).put(node.getChild(i));
                }
            }
        }
    }
}
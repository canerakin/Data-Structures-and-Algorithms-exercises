import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class
 */
public class Driver {
    /**
     * Driver function
     */
    public Driver() {
        System.out.println("Create a new min Heap");
        Heaps<Integer> heaps = new Heaps();

        System.out.println("Try to research element in empty tree");
        heaps.Search(10);
        heaps.add(15);
        heaps.add(20);
        heaps.add(25);
        heaps.add(5);
        heaps.add(35);
        heaps.add(45);
        heaps.add(55);

        System.out.println("Try to research element and take index");
        heaps.Search(35);

        System.out.println("Show all element with index");
        heaps.to_String();

        System.out.println("Try delete element with root");
        heaps.delete();

        System.out.println("Show all element with index");
        heaps.to_String();

        System.out.println("Create new heap for merge ");
        Heaps<Integer> heap2 = new Heaps();
        heap2.add(40);
        heap2.add(50);
        heap2.add(60);
        heap2.add(53);

        System.out.println("Removing i th element");
        heap2.delete(1);

        System.out.println("New heap is :");
        heap2.to_String();

        System.out.println("Merge with another heap");
        heaps.Merge_heap(heap2);

        System.out.println("Last heap element : ");
        heaps.to_String();
    }

}

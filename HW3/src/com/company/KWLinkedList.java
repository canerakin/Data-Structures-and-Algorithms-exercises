package com.company;
import java.util.*;

/**
 * KWLinkedList implementation
 * @param <E> is data type
 */
public class KWLinkedList<E>
{
    /**
     * points to the head of the list
     */
    private Node<E> head = null;
    /**
     * points to the tail of the list
     */
    private Node<E> tail = null;
    /**
     * the number of items in the list
     */
    private int size = 0;

    /**
     * Create new object and add
     * @param index is new object where store
     * @param obj is new object
     */
    public void add(int index, E obj)
    {
        ListIterator<E> iter = listIterator(index);
        iter.add(obj);
    }

    /**
     * new object add first
     * @param obj is new object
     */
    public void addFirst(E obj) { add(0, obj);  }

    /**
     * new object add last
     * @param obj is new object
     */
    public void addLast(E obj) { add(size, obj);  }

    /**
     * if need object there call
     * @param index is object station
     * @return the object
     */
    public E get(int index)
    { 	ListIterator<E> iter = listIterator(index);
        return iter.next();
    }

    /**
     * first object need
     * @return the first object
     */
    public E getFirst() { return head.data;  }

    /**
     * last object need
     * @return the last object
     */
    public E getLast() { return tail.data;  }

    /**
     * list size
     * @return the size
     */
    public int size() {  return size;  }

    /**
     * if need delete the object in index
     * @param index object size
     * @return the remove object
     */
    public E remove(int index)
    {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
    }

    /**
     * iterator
     * @return iterator
     */
    public Iterator iterator() { return new KWListIter(0);  }

    /**
     * list iterator
     * @return iterator
     */
    public ListIterator listIterator() { return new KWListIter(0);  }

    /**
     * iterator class function
     * @param index is iter location
     * @return iterator
     */
    public ListIterator listIterator(int index){return new KWListIter(index);}

    /**
     * iterator class function
     * @param iter is iterator
     * @return iterator
     */
    public ListIterator listIterator(ListIterator iter)
    {     return new KWListIter( (KWListIter) iter);  }

    /**
     * Inner class
     * @param <E> type of object
     */
    private static class Node<E>
    {
        /**
         * object type
         */
        private E data;
        /**
         * keep next node
         */
        private Node<E> next = null;
        /**
         * keep last node
         */
        private Node<E> prev = null;

        /**
         * inner class constructor
         * @param dataItem is if define with first element
         */
        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
    }  // end class Node

    /**
     * Iterator class
     */
    public class KWListIter implements ListIterator<E>
    {
        /**
         * the current node
         */
        private Node<E> nextItem;
        /**
         * the previous node
         */
        private Node<E> lastItemReturned;
        /**
         * keep element size
         */
        private int index = 0;   //

        /**
         * constructor for KWListIter class
         * @param i is index
         */
        public KWListIter(int i)
        {
            if (i < 0 || i > size)
            {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size)     // Special case of last item
            {     index = size;     nextItem = null;      }
            else          // start at the beginning
            {   nextItem = head;
                for (index = 0; index < i; index++)  nextItem = nextItem.next;
            }// end else
        }  // end constructor

        /**
         * constructor for KWListIter class
         * @param other is start with new index
         */
        public KWListIter(KWListIter other)
        {   nextItem = other.nextItem;
            index = other.index;
        }
        /**
         *  hasNext implementation
         * @return the next item
         */
        public boolean hasNext() {   return nextItem != null;    }

        /**
         * hasPrevious implementation
         * @return the prev item
         */
        public boolean hasPrevious()        {   return (nextItem == null && size != 0) || nextItem.prev != null;   }

        /**
         * need last element index
         * @return last element index
         */
        public int previousIndex() {  return index - 1;    }

        /**
         * need next item index
          * @return next item index
         */
        public int nextIndex() {  return index;    }

        /**
         * iter set
          * @param o is new iter
         */
        public void set(E o)  { }  // not implemented

        /**
         * remove iter
         */
        public void remove(){}      // not implemented

        /**
         * pass the next iter
         * @return the data
         */
        public E next()
        {   if (!hasNext()) {  throw new NoSuchElementException();   }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * turn back the previous
         * @return the last data
         */
        public E previous()
        {
            if (!hasPrevious()) {   throw new NoSuchElementException();   }
            if (nextItem == null) { nextItem = tail;  }
            else {  nextItem = nextItem.prev;  }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * add a new object
         * @param obj is the new object
         */
        public void add(E obj)
        {
            if (head == null)     // add to an empty list
            {   head = new Node(obj);
                tail = head;
            }
            else if (nextItem == head)  // insert at head
            {   Node newNode = new Node(obj);    // Create a new node
                newNode.next = nextItem; // link it to the nextItem
                nextItem.prev = newNode;  // link nextItem to the new node
                head = newNode; // The new node is now the head
            }
            else if (nextItem == null) // insert at tail
            {     Node newNode = new Node(obj);// Create a new node
                tail.next = newNode; // Link the tail to the new node
                newNode.prev = tail;      // Link the new node to the tail
                tail = newNode; // The new node is the new tail
            }
            else      // insert into the middle
            {     Node newNode = new Node(obj);
                newNode.prev = nextItem.prev; // Link it to nextItem.prev
                nextItem.prev.next = newNode;  // Link it to the nextItem
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            // Increase size and index
            size++;
            index++;
        } // end of method add


    }/* end of inner class KWListIter*/
} /* end of class KWLinnkedList*/

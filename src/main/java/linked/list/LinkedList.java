package linked.list;

/**
 * This class is supposed to represent a doubly linked list
 * Finish the methods below
 * The tests can guide you in the right direction but are not absolute infallible
 */
public class LinkedList implements OOSELinkedList {
    /***
     * Leave these three variables.
     */
    private LinkedListNode<Double> head;
    private LinkedListNode<Double> tail;
    private Integer size = 0;

    /**
     * @return The value of the head of the linked list.
     * Checks if head is null. If it is, return null.
     */
    @Override
    public Double getFirst() {

        return null;
    }

    /**
     * @return The value of the tail of the linked list.
     * Checks if tail is null. If it is, return null.
     */
    @Override
    public Double getLast() {
        return null;
    }

    /**
     * @return The size of the linked list
     */
    @Override
    public Integer getSize() {
        return null;
    }

    /**
     * @param index
     * @return An element of the LinkedList based on an index.
     * If index is not present (List to small or negative index), throw IndexOutOfBoundsException
     * STUDENTS: implementing the exception is optional. You are allowed to return null a test will fail.
     */
    @Override
    public Double get(int index) {
        return null;
    }

    /**
     * @param d Adds an element to head of the linked list and increases the size.
     *          In case the head is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the tail.
     */
    @Override
    public void addFirst(Double d) {
    }

    /**
     * @param d Adds an element to tail of the linked list and increases the size.
     *          In case the tail is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the head.
     */
    @Override
    public void addLast(Double d) {
    }

    /**
     * @param index
     * @param d     Adds an element to the linked list based on an index
     *              In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *              Updates the surrounding nodes' previous and next variables
     *              Also updates the size
     *              <p>
     *              TIP: be smart with how you 'move' to the correct element.
     *              Mind the time complexity - O(?)
     */
    @Override
    public void add(int index, Double d) {
    }

    /**
     * Removes the head of the linked list.
     * If there is only one element - also remove tail
     * Otherwise it updates the next elements previous/next node variables
     * Also updates the size
     */
    @Override
    public void removeFirst() {
    }

    /**
     * Removes the tail of the linked list.
     * If there is only one element - also remove head
     * Otherwise it updates the previous elements previous/next node variables
     * Also updates the size
     */
    @Override
    public void removeLast() {
    }

    /**
     * @param index Removes an element based on an index.
     *              In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *              Updates the surrounding nodes' previous and next variables
     *              Also updates the size
     */
    @Override
    public void remove(int index) {

    }


    /**
     * Sets the value of an element based on an index.
     * In case index out of bounds, throw and IndexOutOfBoundsException (optional but a test will fail if you don't)
     *
     * @param index
     * @param value
     */
    @Override
    public void set(int index, Double value) {
    }


    /**
     * Sorts the list in ascending order.
     * You can use any existing sorting algorithm like Bubble sort, Merge sort, quick sort etc.
     * Or you can create your own...
     * You cannot use build in sort methods like Collection.sort() or Arrays.sort()
     * The sorting algorithm should be a different from the one used for the Stack.
     */
    public static OOSELinkedList sort(OOSELinkedList list) {
        return null;

    }

    /*
     * OPTIONAL:
     *  Make the most out of the doubly linked list by determining whether to start from the head or from the tail
     *  Can be interesting for the Add(), Get() and Remove() methods
     *
     *  Also, optional: implement the following methods:
     *  Clear()
     *  Contains()
     *  IndexOf()
     * */

}



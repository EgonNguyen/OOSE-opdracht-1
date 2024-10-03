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
        if (head == null){
            return null;
        }
        else{
            return head.getValue();
        }
    }

    /**
     * @return The value of the tail of the linked list.
     * Checks if tail is null. If it is, return null.
     */
    @Override
    public Double getLast() {
        if (tail == null){
            return null;
        }
        else{
            return tail.getValue();
        }
    }

    /**
     * @return The size of the linked list
     */
    @Override
    public Integer getSize() {
        return size;
    }

    /**
     * @param index
     * @return An element of the LinkedList based on an index.
     * If index is not present (List to small or negative index), throw IndexOutOfBoundsException
     * STUDENTS: implementing the exception is optional. You are allowed to return null a test will fail.
     */
    @Override
    public Double get(int index) {
        LinkedListNode<Double> currentNode = head;

        if(index > size){
            throw new IndexOutOfBoundsException("index is bigger than size of the list");
        }
        else{

            for (int i = 0; i < index ; i++){
                currentNode = currentNode.getNext();
            }
            return currentNode.getValue();
        }
    }

    /**
     * @param d Adds an element to head of the linked list and increases the size.
     *          In case the head is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the tail.
     */
    @Override
    public void addFirst(Double d) {
        LinkedListNode<Double> newNode = new LinkedListNode<>(d);
        if(size > 0){
            //move head to second place
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        else{
            //first element in list
            tail = newNode;
        }
        //set head
        head = newNode;
        //size increases by 1
        ++size;
     }

    /**
     * @param d Adds an element to tail of the linked list and increases the size.
     *          In case the tail is already filled, this method also updates the previous/next node attributes.
     *          In case this is the element added, also fill the head.
     */
    @Override
    public void addLast(Double d) {
        LinkedListNode<Double> newNode = new LinkedListNode<>(d);
        if(size > 0 && tail !=null){ //a little confused about the test: addLast_should_check_if_tail_null_before_trying_to_remove()
            //move tail from last place
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        else{
            //first element in list
            head = newNode;
        }
        //set new tail
        tail = newNode;
        //size increases by 1
        ++size;
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
    public void add(int index, Double d) {      //can use some cleanup if time
        //creating the new node
        LinkedListNode<Double> newNode = new LinkedListNode<>(d);
        LinkedListNode<Double> currentNode;

        System.out.println("Start adding node: " + newNode.getValue());
        System.out.println("with index: " + index +" and size: "+ size);


        //check for boundaries
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("index is bigger than size of the list");
        }

        //start at head if index is small
        if(index < size/2){
            System.out.println("Starting from head: " + head.getValue());
            currentNode = head;
            for(int i = 0 ; i < index ; i++){
                if(currentNode.hasNext()){
                    currentNode = currentNode.getNext();
                }
            }

            if(currentNode.hasPrevious()){
                newNode.setPrevious(currentNode.getPrevious());
                currentNode.getPrevious().setNext(newNode);
            }
            currentNode.setPrevious(newNode);
            newNode.setNext(currentNode);


        }
        else if(index == size){
            if(head == null){ //create first node
                head = newNode;
                tail = head;
                System.out.println("created first node: " + head.getValue());
                System.out.println("created tail node: " + tail.getValue());
            }
            else{
                //new tail
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail = newNode;
                System.out.println("created tail node: " + tail.getValue());
            }
        }

        //start at tail if index is big
        else{
            System.out.println("Starting from tail: " + tail.getValue());
            currentNode = tail;
            for(int i = index; i < size ; i++){
                if(currentNode.hasPrevious()){
                    currentNode = currentNode.getPrevious();
                }
            }

            if(currentNode.hasNext()){
                newNode.setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(newNode);
            }
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
        }
        ++size;
        System.out.println("current size: " + size);
    }



    /**
     * Removes the head of the linked list.
     * If there is only one element - also remove tail
     * Otherwise it updates the next elements previous/next node variables
     * Also updates the size
     */
    @Override
    public void removeFirst() {
        if(size == 0){
            throw new IndexOutOfBoundsException("List is empty, nothing to remove");
        }
        else{
            if(head.hasNext()){ //if there is more than 1 element
                head.getNext().setPrevious(null); //remove reference to previous node from the new head
                head = head.getNext(); //set new head
            }
            else{
                //there is only 1 element
                head = null;
                tail = null;
            }
            --size; //decrease size by 1
        }
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



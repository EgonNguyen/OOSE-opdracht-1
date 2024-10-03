package stack;

import linked.list.LinkedListNode;

import java.util.EmptyStackException;

/**
 * This class is supposed to represent a stack
 * Finish the methods below
 * The tests can guide you in the right direction but are not absolute infallible
 */
public class Stack implements OOSEStack {
    /***
     * Leave these two variables
     */
    private StackNode<Double> top;
    int size = 0;

    /**
     * @param d Pushes element to the top of the stack.
     *          If an element already exists on the top. Update the reference (Stacknode.next)
     *          Also increases size
     */
    @Override
    public void push(Double d) {
        StackNode<Double> newNode = new StackNode<>(d);
        if(top != null){
            newNode.setNext(top);
        }
        top = newNode;
        ++size;
    }

    /**
     * @return The element on top of the stack but does NOT remove it.
     * If stack is empty throw an EmptyStackException
     * Also checks if top is null. If it is, throw an exception.
     */
    @Override
    public Double peek() {
        if(top == null){
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    /**
     * @return The element on top of the stack and removes it.
     * If stack is empty throw an EmptyStackException.
     * Also checks if top is null. If it is, throw an exception.
     */
    @Override
    public Double pop() {
        StackNode<Double> popNode;
        if(top == null){
            throw new EmptyStackException();
        }
        --size;
        if(top.hasNext()){
            popNode = top;
            top = top.getNext();
            return popNode.getValue();
        }
        else{
            popNode = top;
            top = null;
            return popNode.getValue();
        }
    }

    /**
     * @return the size of the stack
     */
    @Override
    public Integer getSize() {
        if(top == null){
            return 0;
        }
        int size = 1;
        StackNode<Double> currentNode = top;
        while(currentNode.hasNext()){
            ++size;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    /**
     * Sorts the stack in ascending order.
     * You can use any existing sorting algorithm like Bubble sort, Merge sort, quick sort etc.
     * Or you can create your own...
     * You cannot use build in sort methods like Collection.sort() or Arrays.sort()
     * The sorting algorithm should be a different from the one used for the LinkedList.
     */
    public static OOSEStack sort(OOSEStack stack) {
        if(stack == null){
            return stack;
        }
        Stack sortedStack = sortStack((Stack) stack);
        return sortedStack;

    }
    public static Stack sortStack(Stack stack){
        if(stack.getSize() == 0){
            return stack;
        }

        //begin at top
        Double temp = stack.pop();
        System.out.println("popping : " + temp);

        sortStack(stack);
        sortedInsert(stack, temp);

        return stack;
    }

    public static void sortedInsert(Stack stack, Double element){

        if (stack.getSize() == 0 || stack.peek() >= element) {
            stack.push(element);
            System.out.println("Inserting: " + element);
            return;
        }

        Double temp = stack.pop();
        sortedInsert(stack, element);

        stack.push(temp);
        System.out.println("Pushing back: " + temp);

    }




}

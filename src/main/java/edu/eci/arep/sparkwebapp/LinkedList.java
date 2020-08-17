package edu.eci.arep.sparkwebapp;;

import java.util.Iterator;

/**
 * Manual implementation of a doubly LinkedList
 * @author Johan Sebastián Arias
 * @param <Obj> Object type of the class Node
 */
public class LinkedList<Obj> implements Iterable<Obj> {
    Node<Obj> head,tail;
    private int size;

    /**
     * Empty constructor
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds a node in the right side of the LinkedList
     * @param x Node to be added
     */
    public void addNodeRight(Obj x){
        Node<Obj> node = new Node<Obj>(x,null,null);
        if (tail == null) {
            head = tail = node;
        }else{
            tail.setNext(node);
            node.setPrior(tail);
            tail = node;
        }
        size+=1;
    }

    /**
     * Adds a node in the left side of the LinkedList
     * @param x Node to be added
     */
    public void addNodeLeft(Obj x){
        Node<Obj> node = new Node<Obj>(x,null,null);
        if (head == null){
            head = tail = node;
        }else {
            head.setPrior(node);
            node.setNext(head);
            head = node;
        }
        size+=1;
    }

    /**
     * Removes from the right side of the list.
     * @return value
     * @throws ListException when the LinkedList is empty
     */
    public Obj removeNodeRight() throws ListException {
        if (tail == null){
            throw new ListException(ListException.EMPTY_LIST);
        }
        Obj value = tail.getValue();
        if (tail.equals(head)){
            tail = head = null;
        }else{
            Node<Obj> penult = tail.getPrior();
            penult.setNext(null);
            tail = penult;
        }
        size-=1;
        return value;
    }


    /**
     * Returns the head of the LinkedList
     * @return head
     */
    public Node<Obj> getHead() {
        return head;
    }

    /**
     * Sets the head of the LinkedList
     * @param head new head Node
     */
    public void setHead(Node<Obj> head) {
        this.head = head;
    }

    /**
     * Returns the tail of the LinkedList
     * @return tail
     */
    public Node<Obj> getTail() {
        return tail;
    }

    /**
     * Sets the tail of the LinkedList
     * @param tail new tail of the list
     */
    public void setTail(Node<Obj> tail) {
        this.tail = tail;
    }

    /**
     * Returns the length of the LinkedList
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the List.
     * @param size new size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Implementation method of the class Iterable
     * @return LinkedList
     */
    public Iterator<Obj> iterator() {
        return new IteratorImpl<Obj>(this);
    }



}

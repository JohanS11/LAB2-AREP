package edu.eci.arep.sparkwebapp;

import java.util.Iterator;

/** Iterator implementation of the LinkedList class
 * @author Johan Sebastián Arias
 */

public class IteratorImpl<Obj> implements Iterator<Obj> {

    Node<Obj> nodeA;

    /**
     * IteratorImpl  constructor
     * @param list LinkedList
     */
    public IteratorImpl(LinkedList<Obj> list){
        nodeA = list.getHead();
    }

    /**
     * Verify if there is a right node
     * @return true if the head node is different of null
     */
    public boolean hasNext() {
        return nodeA != null;
    }

    /**
     * Returns the next node of the LinkedList
     * @return value of the node
     */
    public Obj next() {
        Obj value = nodeA.getValue();
        nodeA = nodeA.getNext();
        return value;
    }

    public void remove() {

    }
}

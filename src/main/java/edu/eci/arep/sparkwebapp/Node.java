package edu.eci.arep.sparkwebapp;;


/**
 * Node class that contains a value, prior node and next node
 * @author Johan Sebastian Arias
 * @param <Obj> type of the object in the node
 */
public class Node<Obj> {

    private Node<Obj> prior,next;
    private Obj value;

    /**
     * Node's constructor
     * @param value data stored
     * @param prior node that comes before the current one.
     * @param next node that comes after the current one.
     */
    public Node(Obj value, Node<Obj> prior, Node<Obj> next) {
        this.value = value;
        this.prior = prior;
        this.next = next;
    }

    /**
     * Empty constructor
     */
    public Node() {
    }

    /**
     * Gets the node that comes before the current one.
     * @return prior
     */
    public Node<Obj> getPrior() {
        return prior;
    }

    /**
     * Sets the node that comes before the current one.
     * @param prior left node.
     */
    public void setPrior(Node<Obj> prior) {
        this.prior = prior;
    }

    /**
     * Gets the node that comes after the current one.
     * @return next
     */
    public Node<Obj> getNext() {
        return next;
    }

    /**
     * Sets the node that comes after the current one.
     * @param next right node
     */
    public void setNext(Node<Obj> next) {
        this.next = next;
    }

    /**
     * returns the data stored by the node
     * @return value
     */
    public Obj getValue() {
        return value;
    }

    /**
     * Sets the data stored by the node
     * @param value new value
     */
    public void setValue(Obj value) {
        this.value = value;
    }
}

package edu.eci.arep.sparkwebapp;;

import java.util.List;

/**
 * Exception that is generated when the LinkedList is empty.
 * @author Johan Sebastián Arias
 */
public class ListException extends Exception{
    public static final String EMPTY_LIST = "Empty list, unable to remove the element!";

    public ListException(){
        super();
    }
    public ListException(String message) {
        super(message);
    }
}

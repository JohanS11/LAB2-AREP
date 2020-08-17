package edu.eci.arep.sparkwebapp;;


/**
 * Calculator class that calculates the mean and the standard deviation
 * @author Johan Sebastián Arias
 */
public class Calculator {

    /**
     * Calculates the mean given a LinkedList of numbers
     * @param list LinkedList containing the nodes with the values
     * @return a quantity that represents the mean
     */
    public double calcMean(LinkedList<Double> list){
        double suma = 0;
        for (double element : list){
            suma += element;
        }
        return (double)Math.round(suma/list.getSize() *100d)/100d;

    }

    /**
     * Calculates the standard deviation given a LinkedList of numbers
     * @param list LinkedList containing the nodes with the values
     * @return  a quantity that represents the standard deviation
     */
    public double calcStandardDeviation(LinkedList<Double> list){
        double average = calcMean(list);
        double numerador = 0;
        for (double i : list){
            numerador += Math.pow(i-average,2);
        }
        return (double)Math.round(Math.sqrt((numerador)/ (list.getSize()-1))* 100d) /100d;
    }
}

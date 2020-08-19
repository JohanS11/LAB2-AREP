package edu.eci.arep.sparkwebapp;
import spark.Request;
import spark.Response;

import java.util.Arrays;

import static spark.Spark.*;

/**
 * This is a simple WebApplication deployed in Heroku using SparkWeb.
 * @author Johan Arias
 */

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * @param req This is the object that represents the HTTP request
     *            in order to retrieve a resource from the web server.
     * @param res This is the object that represents the HTTP response
     *            given by the webserver
     * @return A string with html code that will build the web page, in this case
     *          the resource located at /inputdata
     */
    private static String inputDataPage(Request req, Response res) {
        return "<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "<h2>LABORATORY 2 AREP 2020-2</h2>"
        + "<p> Insert a set of numbers separated by a <br> " +
                "comma and we will calculate the mean and standard deviation </p>"
        + "<form action=\"/results\">"
        + "  Data set:<br>"
        + "  <input name=\"data\" >"
        + "  <br>"
        + "  <input type=\"submit\" value=\"Submit\">"
        + "</form>"
        + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
        + "</body>"
        + "</html>";
    }

    /**
     * This method retrieves a data set from a parameter from the resource "inputdata"
     * called data and builds the webpage based on this set.
     * @param req This is the object that represents the HTTP request
     *             in order to retrieve a resource from the web server.
     * @param res This is the object that represents the HTTP response
     *      *            given by the webserver
     * @return A string with html code that will build the web page, in this case
     *      *          the resource located at /results
     */
    private static String resultsPage(Request req, Response res) {

        LinkedList<Double> linkedList = new LinkedList<Double>();
        Calculator calculator = new Calculator();
        String [] data = req.queryParams("data").split(",");
        for (String datum : data) {
            linkedList.addNodeRight(Double.parseDouble(datum));
        }
        double mean = calculator.calcMean(linkedList);
        double sd = calculator.calcStandardDeviation(linkedList);
        return "<!DOCTYPE html>"
                + " <html>" +
                "<body>" +
                "<h2>The Mean for the inserted data set  is: "+
                    "<p>" + mean + "</p>" +
                "</h2>" +
                "<h2>The Standard Deviation inserted data set is: "+
                    "<p>" + sd + "</p>" +
                "</h2>" +
                "<h2>Data set: " + Arrays.toString(data) + "</h2>" +
                "</body>" +
                "</html>";

    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }



}

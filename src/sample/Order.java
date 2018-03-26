package sample; /**
 * Object Orientated Principles
 *
 * Project
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 5/12/17
 */

import java.util.ArrayList;


public class Order {

    //----------------------------//
    //      Attributes            //
    //----------------------------//

    private ArrayList<OrderDetails> orderList;



    //----------------------------//
    //      Constructor           //
    //----------------------------//
    /**
     *  constructor
     */
    public Order(){

        // an order will have an array of products
        ArrayList<Product> orders = new ArrayList<Product>();

        // create new orderList
        orderList = new ArrayList<OrderDetails>();

    }
    //----------------------------//
    //      Methods               //
    //----------------------------//
    /**
     * addOrder
     *
     * Adds order
     *
     * @param p  - product to be added
     * @param qty - quantity of product to be ordered
     */
    public void addOrder(Product p, int qty) {

        // create new order details
       // OrderDetails orderAdd = new OrderDetails(p, qty);//

        orderList.add(new OrderDetails(p,qty));

        // add order to list
       // orderList.add(orderAdd);
    }
    /**
     * removeOrder
     *
     * removes  order
     *
     * @param index  - index of order to be removed
     */
    public void removeOrder(int index) {

        // Scenario 1: The index is greater than zero and smaller than the size of the orderList
        if (index >= 0 && index <= this.orderList.size()) {
            orderList.remove(index);

        // Scenario 2: invalid index
        } else {
            System.out.println("Error: Index could not be found!");
        }
    }
    /**
     * viewOrder
     *
     *
     * @param index
     */
    public void viewOrder(int index) {
        OrderDetails temp=null;

        // Scenario 1: The index is greater than zero and smaller than the size of the orderList
        if (index >= 0 && index < orderList.size()) {
            // sets the temp object to the index of the order
            temp = orderList.get(index);


            temp.printOrderDetails();

         // Scenario 2: invalid index
        } else {
            System.out.println("Error: invalid index");

        }
    }
}

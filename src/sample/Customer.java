package sample; /**
 * Object Orientated Principles
 *
 * Project
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 3/12/17
 */

import java.util.ArrayList;


public class Customer {

    //----------------------------//
    //      Attributes            //
    //----------------------------//
    private String name;
    private String address;

    // create array List of orders that each customer will hold
    ArrayList<Order> customerOrder;

    //----------------------------//
    //      Constructor           //
    //----------------------------//
    /**
     * Default Constructor
     */
    public  Customer(){
        //create array list of orders
        customerOrder = new ArrayList<>();
    }
    /**
     * Overloaded Constructor
     *
     *
     * @param iName    - name of customer
     * @param iAddress - address of customer
     */
    public Customer(String iName, String iAddress) {

        // set name
        this.name    = iName;

        //set address
        this.address = iAddress;

        //create array list of orders
        customerOrder = new ArrayList<>();
    }
    //----------------------------//
    //      Methods               //
    //----------------------------//
    //
    // Set methods
    //

    /**
     * SetName
     *
     * Sets the name of the customer
     *
     * @param iName - name of the customer
     *
     */
    public void setName(String iName) {
        this.name = iName;
    }


    /**
     * setAddress
     *
     * Sets the address of the customer
     *
     * @param iAddress - address of the customer
     *
     */
    public void setAddress (String iAddress) {
        this.address = iAddress;
    }



    //
    // order methods
    //
    /**
     * addOrder
     *
     * Ads an order to the customers order arrayList
     *
     * @param orderTemp - order for customer
     *
     */
    public void addOrder(Order orderTemp){
        customerOrder.add(orderTemp);
    }

    /**
     * removeOrder
     *
     * removes an order to the customers order arrayList
     *
     * @param index - index of order
     *
     */
    public void removeOrder(int index){
        customerOrder.remove(index);
    }


    /**
     * getOrder
     *
     * returns an order to the customers order arrayList
     *
     * @param index - index of order
     *
     * @return - returns order
     *
     */
    public Order getOrder(int index){


       return customerOrder.get(index);
    }


    /**
     * viewAll
     *
     * returns all orders from the customers order arrayList
     *
     *
     *
     */
    public void viewAll(){
        for(int i = 0; i<customerOrder.size(); i++) {
           customerOrder.get(i).viewOrder(i);
        }
    }

    /**
     * viewOrder
     *
     * Provides details to single order
     *
     *
     */
    public void viewOrder(int index){
        customerOrder.get(index);
    }


    //
    // Get methods
    //

    /**
     * getName
     *
     * gets and returns the name of the customer
     *
     * @return name - name of the customer
     */
    public String getName() {
        return this.name;
    }

    /**
     * getAddress
     *
     * gets and returns the address of the customer
     *
     * @return address - address of the customer
     *
     */
    public String getAddress() {
        return this.address;

    }



}

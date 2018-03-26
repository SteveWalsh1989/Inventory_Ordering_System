package sample;

/**
 * Object Orientated Principles
 *
 * Project
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 5/12/17
 *
 *
 *  Order details class
 *
 *  Holds the product for order and its quantity
 *
 */

public class OrderDetails {

    //----------------------------//
    //      Attributes            //
    //----------------------------//

    private Product product;
    private int qty;

    //----------------------------//
    //      Constructor           //
    //----------------------------//
    /**
     *
     * Constructor
     *
     *
     * @param product - product for order
     * @param qty - number of that product type to be ordered
     */
    public OrderDetails(Product product, int qty){

        this.product = product;

        this.qty = qty;
    }
    /**
     * printOrderDetails
     *
     * prints details of the order
     *
     */

    public void printOrderDetails(){
        System.out.println("The order is for the " + this.product.getName() +
                           ", and the quantity ordered is " + this.qty + ".");

    }
}

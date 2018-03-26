package sample;

import static sample.Main.customerList;

/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 26/3/18
 *
 *
 * Controller class stores the methods used for the program
 *
 *****************************/


@SuppressWarnings("CanBeFinal")
public class Controller {

    private static ProductDB productDB = new ProductDB();        // Create new ProductDB to store all products

    // For adding Phone
    final static private String  ASK_MAKE_PHONE          = "What is the make of the Phone?" ;
    final static private String  ASK_MODEL_PHONE         = "What is the model of the Phone?" ;
    final static private String  ASK_PRICE_PHONE         = "What is the price of the Phone?" ;
    final static private String  ASK_STORAGE_PHONE       = "What is the storage of the Phone?" ;

    // For adding TV
    final static private String  ASK_MAKE_TV             = "What is the make of the TV?" ;
    final static private String  ASK_SCREENSIZE_TV       = "What is the screen size, in inches, of the TV?";
    final static private String  ASK_TYPE_TV             = "What type of of TV is it:  \n 1: LED \n 2: LCD \n 3: Plasma" ;
    final static private String  ASK_3D_TV               = "Is the TV capable of displaying 3D content? (Y/N) " ;
    final static private String  ASK_PRICE_TV            = "What is the price of the TV?" ;
    // option 1 : add product variables
    final static private String  ASK_PRODUCT_TYPE    = " What product would you like to order: \n"
            + " 1: Phone  \n"
            + " 2: TV     \n";

    // option 3 : Display All Products
    final static private String  ASK_PRODUCTID           = "Please enter the product ID for the item you want to display";

    // option 4 : Order Products
    final static private String ASK_CST_NAME             = "What is the name of the customer? ";
    final static private String ASK_CST_ADDRESS          = "What is the address of the customer? ";
    final static private String ASK_ORDER_PRODUCTID      = "Please enter the product ID of the item you want to order: ( Enter -1 to finish ) ";
    final static private String ASK_ORDER_QUANTITY       = "How many do you want to order? ";

    // option 5 : Display Order for a customer
    final static private String ASK_CST_ORDER            = "Enter a customer name to view the orders for them. ";
    final static private String CST_NAME_ERROR           = "There was no customer with that name found";


    //-------------------------------//
    //         Methods               //
    //-------------------------------//
    //---------------------------------------------------------------
    // Option 1 - Create a new Product Methods
    //---------------------------------------------------------------
    /**
     * ask product type
     *
     * @return choice = user choice of product type
     */
    static int askProductType() {

        int choice;                                                                // initialize return variable

        choice = Validate.readInt(ASK_PRODUCT_TYPE, 2);                      // display options to user for products and store result if valid choice

        return choice;                                                                 // return users choice
    }
    /**
     * addProduct
     *
     * Method will call either addPhone or addTV methods depending on user choice
     *
     * @param choice - user choice of TV or Phone
     */
    static void addProduct(int choice) {

        switch (choice) {                                                              // select add method based on user choice

            case 1:                                                                    // Scenario 1 : choice = 1, User wants to add a phone

                addPhone();                                                            // run addPhone method to add new phone to the Product DB
                break;
            case 2:                                                                    // Scenario 2 : choice = 2, User wants to add a TV

                addTV();                                                               // run addTV method to add new tv to the Product DB
                break;
        }
    }
    /**
     * addPhone
     *
     * Method will create a new Phone object and prompt the user to enter details about it including:
     * Name
     * Description
     * Make
     * Model
     * Storage
     * Price
     *
     * The method will then add this new object to the productDB arrayList
     */
    private static void addPhone() {

        Phone newPhone = new Phone();                                   // create new Phone object

        String make = Validate.readString(ASK_MAKE_PHONE);              // Ask for and set the make

        newPhone.setMake(make);                                         // set make of phone based on user input

        String model = Validate.readString(ASK_MODEL_PHONE);            // Ask for and set the model

        newPhone.setModel(model);                                       // set model of phone based on user input

        int storage = Validate.readInt(ASK_STORAGE_PHONE);              // Ask for and set the storage

        newPhone.setStorage(storage);                                   // set storage of phone based on user input

        double price = Validate.readDouble(ASK_PRICE_PHONE);            // Ask for and set the price

        newPhone.setPrice(price);                                       // set price of phone based on user input

        ProductDB.addProduct(newPhone);                                 // add new Phone to the product DB

        newPhone.savePhone();                                           // saves new phone to productDB text file
    }
    /**
     * addTV
     *
     * Method will create a new TV object and prompt the user to enter details about it including:
     * Name
     * Description
     * Make
     * ScreenSize
     * capableOf3D
     * Price
     *
     * The method will then add this new object to the productDB arrayList
     */
    private static void addTV() {

        TV newTV = new TV();                                      // create new TV object

        String TVMake = Validate.readString(ASK_MAKE_TV);         // Ask for the make and store input

        newTV.setMake(TVMake);                                    // set make of TV based on user input

        int screenSize = Validate.readInt(ASK_SCREENSIZE_TV);     // Ask for the screen size

        newTV.setScreenSize(screenSize);                          // set screensize of TV based on user input

        int type = Validate.readInt(ASK_TYPE_TV,3);     // Ask for type of TV

        newTV.setType(type);                                      // set type of TV based on user input

        boolean capableOf3D = Validate.readBoolean(ASK_3D_TV);    // Ask if 3d compatible

        newTV.set3DCapability(capableOf3D);                       // set 3d capability  of TV based on user input

        double price = Validate.readDouble(ASK_PRICE_TV);         // Ask for price of TV

        newTV.setPrice(price);                                    // set price of TV based on user input

        ProductDB.addProduct(newTV);                              // add new TV to the product DB

        newTV.saveTV();                                           // saves new tv to productDB text file

    } // close method

    //---------------------------------------------------------------
    // Option 2 - Search for a product Method
    //---------------------------------------------------------------
    /**
     * searchProductDB
     *
     * Method will prompt the user to enter a product ID
     *
     * Will search the productDB arrayList for matching ID and print details of product if found
     *
     */
    static void searchProductDB() {

        int productID = Validate.readInt(ASK_PRODUCTID);         // store product ID of user entry


        productDB.findProduct(productID);                        // use user entry as parameter for the findProduct method and if found will print details of product

    }
    //---------------------------------------------------------------
    // Option 4 - Order Product Method
    //---------------------------------------------------------------
    /**
     * AddCustomer
     *
     * Adds a new customer and their order
     *
     *
     * Stores the customers order by product and quanity
     */
    static void addCustomerOrder() {

        Customer newCustomer = new Customer();                      // create new customer

        Product orderedProduct;                              // initialise ordered product variable

        int quantity;                                           // set quantity to zero

        String name = Validate.readString(ASK_CST_NAME);            // Asks for name of the customer

        newCustomer.setName(name);                                  // stores name of the customer

        String address = Validate.readString(ASK_CST_ADDRESS);      // Asks for address of the customer

        newCustomer.setAddress(address);                            // stores address of the customer

        customerList.add(newCustomer);                              // add new customer to the customerList

        int orderProductID = -2;                                    // initialize orderProductID

        while (orderProductID != -1) {                              // keep looping until user enters -1

            orderProductID = Validate.readInt(ASK_ORDER_PRODUCTID); // ask for product ID  of product to be ordered

            if(orderProductID != -1) {                              // keep looping until user enters -1

                quantity = Validate.readInt(ASK_ORDER_QUANTITY);    // ask for the quantity of the order

                orderedProduct = ProductDB.returnProduct(orderProductID); // Search product DB for product by product ID number, return and store as orderedProduct

                Order newOrder = new Order();                       // create new order for customer

                newOrder.addOrder(orderedProduct, quantity);        // add the new order details and quantity to the new order

                newCustomer.addOrder(newOrder);                     // add new order to customer

                System.out.println("You ordered " + orderedProduct.getName() + ", and the quantity ordered is " + quantity);  // print order
            }
        }
    }
    //---------------------------------------------------------------
    // Option 5 - Display Order for a customer Methods
    //---------------------------------------------------------------
    /**
     * askCustomerName
     *
     * aks the customers name from the user, validates input and returns customer
     *
     *
     * Stores the customers order by product and quanity
     */
    static void displayOrders() {

        String customerSearch;
        boolean customerFound = false;

        while(!customerFound){
            customerSearch = Validate.readString(ASK_CST_ORDER);        // ask for customer to locate their order

            Customer temp;                                              // new customer object

            for (Customer aCustomerList : customerList) {                 // loops through the customer list

                if (customerSearch.toUpperCase().equals(aCustomerList.getName().toUpperCase())) {   // Scenario 1: name is found in the customer list

                    customerFound = true;                               // set to true to stop loop

                    temp = aCustomerList;                         // sets temp customer object to found object

                    System.out.println("The orders for " + temp.getName() + " are: \n"); // prints out the name of customer

                    temp.viewAll();                                     // prints all orders for that customer
                } else {                                                   // Scenario 2: name is not found in the customer list

                    System.out.println(CST_NAME_ERROR);                 // print error saying cannot find customer
                }
            }
        }
    }
}

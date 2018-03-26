package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.ArrayList;

public class Main extends Application {



    //----------------------------//
    //      Attributes            //
    //----------------------------//

    static ArrayList<Customer> customerList = new ArrayList<Customer>();      // create arrayList of customers

    static ProductDB productDB = new ProductDB();                             // Create new ProductDB to store all products


    // read in product from file to the ProductDB list


    final static Scanner kb = new Scanner(System.in);                         // allow for keyboard input


    final static private String MENUTITLE = "--------------------------------------- \n" +
                                            "|                                     | \n" +
                                            "|                                     | \n" +
                                            "|      Inventory Application          | \n" +
                                            "|                                     | \n" +
                                             "--------------------------------------- \n\n";

    // holds title page message
    final static private String OPTIONLIST  = "1. Create a new Product\n"          +
                                              "2. Search for a product \n"         +
                                              "3. Display all products \n"         +
                                              "4. Order Product \n"                +
                                              "5. Display Order for a customer\n"  +
                                              "6. Exit";


    // option 1 : add product variables
    final static private String  ASK_PRODUCT_HEADING = "| -------   Add a new Product   ------- | \n\n";
    final static private String  ASK_PRODUCT_TYPE    = " What product would you like to order: \n"
                                                     + " 1: Phone  \n"
                                                     + " 2: TV     \n";

    // option 2 : Search for a Product
    final static private String  SEARCH_PRODUCT_HEADING  = "| -------   Search for a Product   ------- | \n\n";

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

    // option 3 : Display All Products
    final static private String  DISPLAY_PRODUCT_HEADING = "| -------   Display all products   ------- | \n\n";
    final static private String  ASK_PRODUCTID           = "Please enter the product ID for the item you want to display";

    // option 4 : Order Products
    final static private String ORDER_PRODUCT_HEADING    = "| -------   Order Product   ------- | \n\n";
    final static private String ASK_CST_NAME             = "What is the name of the customer? ";
    final static private String ASK_CST_ADDRESS          = "What is the address of the customer? ";
    final static private String ASK_ORDER_PRODUCTID      = "Please enter the product ID of the item you want to order: ( Enter -1 to finish ) ";
    final static private String ASK_ORDER_QUANTITY       = "How many do you want to order? ";

    // option 5 : Display Order for a customer
    final static private String DISPLAY_ORDER_HEADING    = "| -------   Display Order for a customer   ------- | \n\n";
    final static private String ASK_CST_ORDER            = "Enter a customer name to view the orders for them. ";
    final static private String CST_NAME_ERROR           = "There was no customer with that name found";




    //-------------------------------//
    //        Program Start          //
    //-------------------------------//

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        // print application heading
        System.out.println(MENUTITLE);

        // loop checks when user types 6 to exit program
        boolean exit = false;
        while (!exit) {

            // prints options message to user and store next input as users choice
            int choice = Validate.readInt(OPTIONLIST, 6);

            // switch statement to select users keyboard choice
            switch (choice) {

                //---------------------------------------------------------------
                // Option 1 - Create a new Product
                //---------------------------------------------------------------
                case 1:
                    // show heading for option
                    System.out.println(ASK_PRODUCT_HEADING) ;

                    // check which product
                    int selection = askProductType();

                    // chooses which add Product method to use based on the user input
                    addProduct(selection);

                    break;
                //---------------------------------------------------------------
                // Option 2 - Search for a product
                //---------------------------------------------------------------
                case 2:
                    // show heading for option
                    System.out.println(SEARCH_PRODUCT_HEADING) ;

                    // takes productID from user and returns matching product details
                    searchProductDB();

                    break;
                //---------------------------------------------------------------
                // Option 3 - Display all products
                //---------------------------------------------------------------
                case 3:
                    // show heading for option
                    System.out.println(DISPLAY_PRODUCT_HEADING) ;

                    // displays all products stored in the productDB arrayList
                    ProductDB.printAll();

                    break;
                //---------------------------------------------------------------
                // Option 4 - Order Product
                //---------------------------------------------------------------
                case 4:
                    // show heading for option
                    System.out.println(ORDER_PRODUCT_HEADING) ;

                    // take customer details and adds new customer with their order details
                    addCustomerOrder();

                    break;
                //---------------------------------------------------------------
                // Option 5 - Display Order for a customer
                //---------------------------------------------------------------
                case 5:
                    // show heading for option
                    System.out.println(DISPLAY_ORDER_HEADING) ;


                    //ask for customer name and display order details
                    displayOrders();

                    break;
                //---------------------------------------------------------------
                // Option 6 - Exit Program
                //---------------------------------------------------------------
                case 6:
                    // Exits application
                    exit = true;
                    break;
            }
            // prints message to press return to continue
            System.out.println("PRESS_RETURN");
            kb.nextLine();
        }
    } // close main method

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
    public static int askProductType() {

        int choice = 0;

        // display options to user for products and store result if valid choice
        choice = Validate.readInt(ASK_PRODUCT_TYPE, 2);

        return choice;
    }
    /**
     * addProduct
     *
     * Method will call either addPhone or addTV methods depending on user choice
     *
     * @param choice - user choice of TV or Phone
     */
    public static void addProduct(int choice) {

        // select add method based on user choice
        switch (choice) {

            // Scenario 1 : choice = 1, User wants to add a phone
            case 1:
                // run addPhone method to add new phone to the Product DB
                addPhone();
                break;

            // Scenario 2 : choice = 2, User wants to add a TV
            case 2:
                // run addTV method to add new tv to the Product DB
                addTV();
                break;
        }
    }
    /**
     * addPhone
     *
     *
     * Method will create a new Phone object and prompt the user to enter details about it including:
     * Name
     * Description
     * Make
     * Model
     * Storage
     * Price
     *
     *
     * The method will then add this new object to the productDB arrayList
     *
     */
    public static void addPhone() {

        // create new Phone object
        Phone newPhone = new Phone();


        // Ask for and set the make
        String make = Validate.readString(ASK_MAKE_PHONE);
        newPhone.setMake(make);

        // Ask for and set the model
        String model = Validate.readString(ASK_MODEL_PHONE);
        newPhone.setModel(model);

        // Ask for and set the storage
        int storage = Validate.readInt(ASK_STORAGE_PHONE);
        newPhone.setStorage(storage);


        // Ask for and set the price
        double price = Validate.readDouble(ASK_PRICE_PHONE);
        newPhone.setPrice(price);


        // add new Phone to the product DB
        ProductDB.addProduct(newPhone);

    } // close method
    /**
     * addTV
     *
     *
     * Method will create a new TV object and prompt the user to enter details about it including:
     * Name
     * Description
     * Make
     * ScreenSize
     * capableOf3D
     * Price
     *
     *
     * The method will then add this new object to the productDB arrayList
     *
     */
    public static void addTV() {

        // create new TV object
        TV newTV = new TV();

        // Ask for the make
        String TVMake = Validate.readString(ASK_MAKE_TV);
        newTV.setMake(TVMake);

        // Ask for the screen size
        int screenSize = Validate.readInt(ASK_SCREENSIZE_TV);
        newTV.setScreenSize(screenSize);

        int type = Validate.readInt(ASK_TYPE_TV,3);
        newTV.setType(type);

        // Ask if 3d compatible
        boolean capableOf3D = Validate.readBoolean(ASK_3D_TV);
        newTV.set3DCapability(capableOf3D);

        // Ask for and set the price
        double price = Validate.readDouble(ASK_PRICE_TV);
        newTV.setPrice(price);

        // add new TV to the product DB
        ProductDB.addProduct(newTV);

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
    public static void searchProductDB () {

        // store product ID of user entry
        int productID = Validate.readInt(ASK_PRODUCTID);

        // use user entry as parameter for the findProduct method and if found will print details of product
        productDB.findProduct(productID);
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
    public static void addCustomerOrder() {

        Customer newCustomer = new Customer();

        Product orderedProduct = null;

        int quantity = 0;

        // Asks for and stores name of the customer
        String name = Validate.readString(ASK_CST_NAME);
        newCustomer.setName(name);


        // Asks for and stores address of the customer
        String address = Validate.readString(ASK_CST_ADDRESS);
        newCustomer.setAddress(address);

        // add new customer to the customerList
        customerList.add(newCustomer);

        // initialize orderProductID
        int orderProductID = -2;

        // keep looping until user enters -1
        while (orderProductID != -1) {

            // ask for product ID  of product to be ordered
            orderProductID = Validate.readInt(ASK_ORDER_PRODUCTID);

            // keep looping until user enters -1
            if(orderProductID != -1) {

                // ask for the quantity of the order
                quantity = Validate.readInt(ASK_ORDER_QUANTITY);

                // Search product DB for product by product ID number, return and store as orderedProduct
                orderedProduct = ProductDB.returnProduct(orderProductID);

                // create new order for customer
                Order newOrder = new Order();

                // add the new order details and quantity to the new order
                newOrder.addOrder(orderedProduct, quantity);

                // add new order to customer
                newCustomer.addOrder(newOrder);

                // print out what they ordered
                System.out.println("You ordered " + orderedProduct.getName() + ", and the quantity ordered is " + quantity);

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
    public static void displayOrders() {

        String customerSearch;
        boolean customerFound = false;

        while(customerFound == false){
            customerSearch = Validate.readString(ASK_CST_ORDER);

            // new customer object
            Customer temp;

            // loops through the customer list
            for(int i = 0; i<customerList.size(); i++){

                // Scenario 1: name is found in the customer list
                if(customerSearch.toUpperCase().equals(customerList.get(i).getName().toUpperCase())){

                    // set to true to stop loop
                    customerFound = true;

                    // sets temp customer object to found object
                    temp = customerList.get(i);

                    // prints out the name of customer
                    System.out.println("The orders for " + temp.getName() + " are: \n");

                    // prints all orders for that customer
                    temp.viewAll();
                }
                // Scenario 2: name is not found in the customer list
                else{
                    System.out.println(CST_NAME_ERROR);
                }
            }
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.ArrayList;

/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 26/3/18
 *
 *****************************/
public class Main extends Application {

    //----------------------------//
    //      Attributes            //
    //----------------------------//

    static ArrayList<Customer> customerList = new ArrayList<Customer>();                                              // create arrayList of customers

    final static Scanner kb = new Scanner(System.in);                                                                 // allow for keyboard input

    final static private String MENUTITLE = "--------------------------------------- \n" +                            // application tit;e
                                            "|                                     | \n" +
                                            "|                                     | \n" +
                                            "|      Inventory Application          | \n" +
                                            "|                                     | \n" +
                                             "--------------------------------------- \n\n";
    final static private String OPTIONLIST  = "1. Create a new Product\n"          +                                  // holds options page message
                                              "2. Search for a product \n"         +
                                              "3. Display all products \n"         +
                                              "4. Order Product \n"                +
                                              "5. Display Order for a customer\n"  +
                                              "6. Exit";
    final static private String  ASK_PRODUCT_HEADING     = "| -------   Add a new Product   ------- | \n\n";           // option 1 : add product variables

    final static private String  SEARCH_PRODUCT_HEADING  = "| -------   Search for a Product   ------- | \n\n";        // option 2 : Search for a Product

    final static private String  DISPLAY_PRODUCT_HEADING = "| -------   Display all products   ------- | \n\n";        // option 3 : Display All Products

    final static private String ORDER_PRODUCT_HEADING    = "| -------   Order Product   ------- | \n\n";               // option 4 : Order Products

    final static private String DISPLAY_ORDER_HEADING    = "| -------   Display Order for a customer   ------- | \n\n";// option 5 : Display Order for a customer
    //-------------------------------//
    //        Program Start          //
    //-------------------------------//

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();                                                            // display primary stage of GUI

        ProductDB.loadSavedProducts();                                                  // load any saved products from file

        System.out.println(MENUTITLE);                                                  // print application heading

        boolean exit = false;                                                           // loop checks when user types 6 to exit program
        while (!exit) {

            int choice = Validate.readInt(OPTIONLIST, 6);                     // prints options message to user and store next input as users choice
            switch (choice) {                                                           // switch statement to select users keyboard choice

                //---------------------------------------------------------------
                // Option 1 - Create a new Product
                //---------------------------------------------------------------
                case 1:
                    System.out.println(ASK_PRODUCT_HEADING) ;                           // show heading for option

                    int selection = Controller.askProductType();                        // check which product

                    Controller.addProduct(selection);                                   // chooses which add Product method to use based on the user input
                    break;
                //---------------------------------------------------------------
                // Option 2 - Search for a product
                //---------------------------------------------------------------
                case 2:
                    System.out.println(SEARCH_PRODUCT_HEADING) ;                        // show heading for option

                    Controller.searchProductDB();                                       // takes productID from user and returns matching product details
                    break;
                //---------------------------------------------------------------
                // Option 3 - Display all products
                //---------------------------------------------------------------
                case 3:
                    System.out.println(DISPLAY_PRODUCT_HEADING) ;                       // show heading for option

                    ProductDB.printAll();                                               // displays all products stored in the productDB arrayList

                    break;
                //---------------------------------------------------------------
                // Option 4 - Order Product
                //---------------------------------------------------------------
                case 4:
                    System.out.println(ORDER_PRODUCT_HEADING) ;                         // show heading for option

                    Controller.addCustomerOrder();                                      // take customer details and adds new customer with their order details
                    break;
                //---------------------------------------------------------------
                // Option 5 - Display Order for a customer
                //---------------------------------------------------------------
                case 5:
                    System.out.println(DISPLAY_ORDER_HEADING) ;                         // show heading for option

                    Controller.displayOrders();                                         // ask for customer name and display order details
                    break;
                //---------------------------------------------------------------
                // Option 6 - Exit Program
                //---------------------------------------------------------------
                case 6:
                    exit = true;                                                        // Exits application
                    break;
            }
            System.out.println("PRESS_RETURN");                                         // prints message to press return to continue

            kb.nextLine();                                                              // consume enter key
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import java.io.*;
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


public class ProductDB {
    //----------------------------//
    //      Attributes            //
    //----------------------------//

    static ArrayList<Product> productDB ;                                         // create new productDB array list

    static int numItems= 0;                                                       // store number of items in the product Database

    //----------------------------//
    //      Methods               //
    //----------------------------//
    /**
     * Constructor
     */
    public  ProductDB () {

       productDB = new ArrayList<>();                                             // create array List of products
    }
    /**
     * add a product
     *
     * a product to the productDB list
     *
     */
    public static void loadSavedProducts() {

        String fileName = "src/sample/ProductDB.txt";                             // The name of the file to open.

        String line;                                                              // This will reference one line at a time

        try {

            FileReader fileReader = new FileReader(fileName);                     // FileReader reads text files in the default encoding.

            BufferedReader bufferedReader = new BufferedReader(fileReader);       //  wrap FileReader in BufferedReader.

            while ((line = bufferedReader.readLine()) != null) {                  // keep going whilst there are mor lines in file

                String[]  ProductInfo = line.split(":");                   // split by colon to create array of products

                if(ProductInfo[0].equals("Phone") )  {                            // if phone create phone object

                    Phone filePhone = new Phone();                                // create new phone object

                    filePhone.setProductID(Integer.parseInt(ProductInfo[1]));     // set product ID of phone

                    filePhone.setMake(ProductInfo[2] );                           // set make of phone

                    filePhone.setModel(ProductInfo[3] );                          // set model of phone

                    filePhone.setStorage(Integer.parseInt(ProductInfo[4]));       // set storage of phone

                    filePhone.setPrice(Double.parseDouble(ProductInfo[5]));       // set price of phone

                    addProduct(filePhone);                                        // add product to ProductDB list

                } else if (ProductInfo[0].equals("TV")) {                         // if TV create tv object  f

                    TV fileTV= new TV();                                          // create new phone object

                    fileTV.setProductID(Integer.parseInt(ProductInfo[1]));        // set product ID of TV

                    fileTV.setName(ProductInfo[2] );                              // set name  of TV

                    int type = fileTV.findType(ProductInfo[3]);                   // finds type of tv

                    fileTV.setType(type);                                         // set type of TV

                    fileTV.setScreenSize(Integer.parseInt(ProductInfo[4]));       // set storage of phone

                    boolean capable = fileTV.convertBoolean(ProductInfo[5]);      // set type of TV

                    fileTV.set3DCapability(capable);                              // set if 3d capable

                    fileTV.setPrice(Double.parseDouble(ProductInfo[6]));          // set price of phone

                    addProduct(fileTV);                                           // add product to ProductDB list
                }
            }
            bufferedReader.close();                                               //  close file

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");         // print error about opening file
        } catch (IOException ex) {
            System.out.println("Error reading file '"  + fileName + "'");         // print error about reading file

        }
        numItems++;                                                               // increase number of items
    }
    /**
     * add a product
     *
     * a product to the productDB list
     *
     */
    public static void addProduct(Product p) {
        productDB.add(p);                                                         // add product to productDB list

        numItems++;                                                               // increase number of items

    }
    /**
     * remove a product
     *
     * remove a product from the productDB list
     */
    public void removeProduct(Product p) {
        productDB.remove(p);                                                      // remove product to productDB list

        numItems--;                                                               // decrease number of items
    }

    /**
     * findProduct
     *
     *
     * searches and prints products details to user
     *
     *
     */
    public void findProduct(int productID) {

        for(int i=0; i< productDB.size(); i++){


            if( productDB.get(i).getProductID() == productID){                    // Scenario 1: locates product

                productDB.get(i).print();                                         // prints details of product

            }else                                                                 // Scenario 2: Cannot locate product

                System.out.println("Cannot find Product");                        // print message saying cannot find product
        }
    }
    /**
     * returnProduct
     *
     *
     * searches and returns products details to user
     *
     *
     */
    public static Product returnProduct(int productID) {

        Product product = null;

        for(int i=0; i< productDB.size(); i++){

            if( productDB.get(i).getProductID() == productID){                    // Scenario 1: locates product

                product = productDB.get(i);

            } else
                System.out.println("Cannot find Product");                        // Scenario 2: Cannot locate product
        }
        return product;
    }
    /**
     *
     * PrintAll
     *
     * Prints all products in the productDB list
     *
     * if object is a TV then casts to TV and calls its print method
     * if object is a Phone then casts to Phone and calls its print method
     *
     *
     */
    public static void printAll() {
        Product resProduct;
        Phone resPhone;
        TV resTV;

        for (int i = 0; i < productDB.size(); i++) {

            if (productDB.get(i) != null) {                                        // loop through product DB list

                resProduct = productDB.get(i);                                     // get product from list

                if(resProduct instanceof Phone) {                                  // Scenario 1 : Product is of type Phone

                    resPhone = (Phone) resProduct;                                 // casts type to Phone

                    resPhone.print();                                              // prints details

                    System.out.println("\n");                                      // create new line
                }
                else if(resProduct instanceof TV) {                                // Scenario 1 : Product is of type TV

                    resTV = (TV) resProduct;                                       // casts type to TV

                    resTV.print();                                                 // prints details

                    System.out.println("\n");                                      // create new line
                }
            }
        }
    }
}

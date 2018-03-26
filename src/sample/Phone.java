package sample;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 26/3/18
 *
 *****************************/

// Phone is a subclass of Product class
public class Phone extends Product{


    //----------------------------//
    //      Attributes            //
    //----------------------------//

   private String make;    // store make of phone
   private String model;   // store model of phone
   private int storage;    // store storage of phone, in GB
   private int productID;



    //----------------------------//
    //      Constructor           //
    //----------------------------//
    /**
     * default constructor
     */
    public Phone(){
    }
    /**
     *
     * Overloaded Constructor
     *
     *
     */
    public Phone( String name, String model, double iPrice,
                 String iMake, String iModel, int iStorage) {

        super.setName(name);
        super.setDescription(model);
        super.setPrice(iPrice);

        // set local attributes
        this.make    = iMake;
        this.storage = iStorage;
        this.model   = iModel;

    }


    //----------------------------//
    //      Methods               //
    //----------------------------//
    //
    // Set methods
    //

    /**
     * setMake
     *
     * set the make of the product
     *
     * @param iMake - make of product
     */
    public void setMake(String iMake){
        super.setName(iMake);

        this.make = iMake;
    }

    /**
     * setModel
     *
     * set the model of the product
     *
     * @param iModel - model of product
     */
    public void setModel(String iModel){


        super.setDescription(iModel);


        this.model = iModel;
    }


    /**
     * SetStorage
     *
     * sets the storage amount of the
     *
     * @param iStorage - storage of phone
     *
     */
    public void setStorage(int iStorage) {
        this.storage = iStorage;

    }

    //
    // Get Methods
    //

    /**
     * getMake
     *
     * get the make of the phone
     *
     * @return make - returns make of the phone
     */
    public String getMake(){
        return make;
    }

    /**
     * getModel
     *
     * get the model of the phone
     *
     * @return model - returns model of the phone
     */
    public String getModel() {
        return model;
    }

    /**
     * getStorage
     *
     * get the storage of the phone
     *
     * @return storage - returns storage of the phone in GB
     */
    public int getStorage(){
        return storage;
    }


    /**
     * savePhone
     *
     * saves Phone details to file
     *
     */
    public void savePhone()  {

        try(FileWriter fw = new FileWriter("src/sample/ProductDB.txt", true);  // product to product DB file
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("Phone" + ":" + this.getProductID() + ":" + this.getName() + ":"+
                    this.getDescription() +":" + this.getStorage() + ":"+ this.getPrice() );

            bw.close();

        } catch (IOException e) {
        }

    }
    /**
     * print
     *
     * Prints details of the tv by overloading the super class print method
     *
     *
     */
    public void print() {
        // call print from super class
        super.print(this.storage, this.model);

    }




}

package entities;

public class Item {
     // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
    
    //  THIS CLASS CODE IS OK
    
    //----------------------------------------
    // instance variables
    //---------------------------------------- 
    private String name;
    private String description;
    private double price;

    //----------------------------------------
    // constructor
    //---------------------------------------- 

    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    //----------------------------------------
    // instance methods
    //---------------------------------------- 
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}//end class

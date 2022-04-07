package payments.credit;

import entities.Item;
import entities.Person;


public abstract class CreditCard {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
    
    // THIS CLASS IS OK
    
    
    //----------------------------------------
    // class variables
    //----------------------------------------  
    private static int creditTransactionCount = 0;
   
    //----------------------------------------
    // instance variables
    //----------------------------------------  
    protected Person cardHolder;
    protected String cardNumber;
    protected double creditLimit;
    protected double balance;
    protected String type;
    
    //----------------------------------------
    // Constructor
    //----------------------------------------

    public CreditCard(Person cardHolder, double creditLimit, double balance) {
        this.cardHolder = cardHolder;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.type = "Generic CreditCard";
        
    }

    //----------------------------------------
    // class methods 
    //----------------------------------------
    public static int getCreditTransactionCount() {
        return creditTransactionCount;
    }

    public static void setCreditTransactionCount(int creditTransactionCount) {
        CreditCard.creditTransactionCount = creditTransactionCount;
    }
    
    //----------------------------------------
    // abstract methods 
    //----------------------------------------
    protected abstract void fees();
    
    public  void makePurchase(Item item){
        
        System.out.println("Credit Card makePurchase() executed");
    }
    
    //----------------------------------------
    // setter and getter methods
    //----------------------------------------

    public Person getCardHolder() {
        return cardHolder;
    }


    public String getCardNumber() {
        return cardNumber;
    }

 
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

}//end class

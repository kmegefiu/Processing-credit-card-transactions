package payments;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cash {
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    
    //----------------------------------------
    // class variables
    //----------------------------------------    
    private static int cashTransactionCount = 0;
    
    //----------------------------------------
    // instance variables
    //----------------------------------------    
    private Person person;
    private double amount;
    
    //----------------------------------------
    // constructor
    //----------------------------------------    
    public Cash(Person person, double amount) {
        this.person = person;
        this.amount = amount;
        
       
    }

    public static int getCashTransactionCount() {
        return cashTransactionCount;
    }

    public static void setCashTransactionCount(int cashTransactionCount) {
        Cash.cashTransactionCount = cashTransactionCount;
    }
    
    //----------------------------------------
    // instance methods
    //----------------------------------------    
    public Person getPerson() {
        return person;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void addCash(double moreCash){
        amount += moreCash;
    }
    
    public void substractCash(double payment){
        amount -= payment;
    }
    
    public void makePurchase(Item item){
        
        if(item.getPrice() <= amount){
            substractCash(item.getPrice());
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "CASH-" + person.getLastName();
            String message = "<" + dateStr + ">" + "  Purchased " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            cashTransactionCount++;
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
           
            
            String sender = "CASH-" + person.getLastName();
            String message = "<" + dateStr + ">" + "  Do not enough cash to buy " + item.getName() + 
             " for $" + item.getPrice();
            Logger.output(sender, message);
        }//end if-else        
    }

}//end class

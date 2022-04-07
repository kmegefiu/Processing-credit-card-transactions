package payments;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import reports.Reporter;
import transactions.SecureTransaction;
import java.util.ArrayList;


public class SecureCash extends Cash implements Reporter, SecureTransaction {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO

    //----------------------------------------
    // class variables
    //----------------------------------------    
    // you will use this to create secureTransaction Pin
    private static final String[] letterIndex = { " ", "a", "b", "c", "d", "e", "f", "g", "h", 
                                         "i", "j", "k", "l", "m", "n", "o", "p", "q", 
                                         "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    
    boolean CashType;
    
    // ------------------------------------------------------
    // Constructor
    // ------------------------------------------------------
    public SecureCash(Person person, double amount) {
        super(person, amount);
    }
    
    // ------------------------------------------------------
    // instance method
    // ------------------------------------------------------
    public void makePurchase(Item item, String pin){
        

        if(item.getPrice() <= super.getAmount()){
            substractCash(item.getPrice());
            
            CashType = true;
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "SECURECASH-" + super.getPerson().getLastName()+ "-" + pin;
            String message = "<" + dateStr + ">" + "  Purchased " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            Cash.setCashTransactionCount(Cash.getCashTransactionCount()+1);
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "SECURECASH-" + super.getPerson().getLastName() + "-" + pin;
            String message = "<" + dateStr + ">" + "  Do not enough cash to buy " 
            + item.getName() + " for $" + item.getPrice();
            Logger.output(sender, message);
            //CashType = false;
        }
        
    }
    
    
    
    // ======================================================
    // Interface Methods
    // ======================================================
    
    // ------------------------------------------------------
    // Reporter Interface
    // ------------------------------------------------------
    
    @Override
     public void runReports(){
         
         
     }
     
     
    // ------------------------------------------------------
    // SecureTransaction Interface
    // ------------------------------------------------------
    @Override
    public String  generateTransactionSecret(){
        
       
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 9");       
System.out.println("//////////////////////////////////////////////");  
    
        //if you are cash type
        // take the first four letters of the Last name 
        // then for each letter index letter to location in the alphabet
        // same index for upper and lower case
        // example
        // Index:  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ..... 25 26
        // Letter: a b c d e f g h i j  k  l  m  n  o  ....  y  z   
        // mod each letter index by 10 to generate pin
        
        // Example: first Name = Richard
        // W   h   i   t <- first four letters
        // 23  8   9   20 <- index to alphabet location
        // 3   8   9   0 <- %10 
        // 3890 <- final pin
        
     ArrayList<Integer> arrayTest = new ArrayList<Integer>();   
         //YOUR CODE HERE
         String pin = " ";
     String Name = super.getPerson().getLastName().substring(0,4);
     String Name2 = Name.toLowerCase();
     int i;
     int index = 0;
     
     for(i = 0; i<4; i++){
     for(int j = 0; j<letterIndex.length; j++){
        if(letterIndex[j].equals(Name2.substring(i,(i+1))))  
        {
              index = j%10;   
              arrayTest.add(index);
        }// end of if statement
    }
         
         String pin1 = Integer.toString(arrayTest.get(i));
         pin +=pin1;
     } // end of for loops
     
        //debugging code
       // System.out.println("Pin:\t" + pin);
        
        return pin;
     }
    
    @Override
    public void secureTransaction(Item item){
        String pin = generateTransactionSecret();
        makePurchase(item, pin);
    }
    

}

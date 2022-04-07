
package payments.credit;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import reports.CreditCardReport;


public class MasterRewards extends MasterCard {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    
    
    protected int rewardPoints ;
    
    public MasterRewards(Person cardHolder, double creditLimit) {
        super(cardHolder, creditLimit);
        
        rewardPoints = 0;
         type = "Master Rewards";
    }
    
    
    protected  void fees(){
        
        double fee = 0;
       
        if(purchases.size() > 0 && purchases.size()%5 == 0){
            
            //why am I using the super here: because the cardholder's interestRate is in the supper class
            fee = balance * super.getInterestRate()/400;
            totalFees = fee;
            
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + String.format("  $%-5.2f fee charged", fee);
            Logger.output(sender, message);
            
            
        }//end if-else
    
    }
    
    public void makePurchase(Item item){
        
            if(item.getPrice() <= (creditLimit - balance)){

                Date date = new Date();

                balance += item.getPrice();
                purchases.add(item);
                transactionTime.add(date);


                String pattern = "MM-dd-YYYY|HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String dateStr = simpleDateFormat.format(new Date());

                String sender = "MC-" + cardHolder.getLastName();
                String message = "<" + dateStr + ">" + "  Charged " + item.getName() + " for $" + item.getPrice();

                Logger.output(sender, message);

                fees();
                
                // why did I cast this
                rewardPoints +=  (int)item.getPrice(); 
                
                CreditCard.setCreditTransactionCount(CreditCard.getCreditTransactionCount()+ 1);

            }else{
                String pattern = "MM-dd-YYYY|HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String dateStr = simpleDateFormat.format(new Date());

                String sender = "MC-" + cardHolder.getLastName();
                String message = "<" + dateStr + ">" + " Charge declined due to credit limits";
                Logger.output(sender, message);
            }//end if-else
    }
        
    public void infoReport(){
        
          Map<String, Object> map = new LinkedHashMap<>();
        
       
        
        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add(type + " Info Report");
        header.add("=======================================");

        
        map.put("Card Holder", cardHolder.getFirstName() + " " + cardHolder.getLastName());
        map.put("Number", "\t"+ cardNumber);
        map.put("Interest Rate", String.format("%-4.2f%%",super.getInterestRate() ));
        map.put("Credit Limit", String.format("%-10.2f", creditLimit));
        map.put("Balance", String.format("%-10.2f",  balance));
        map.put("Remaining Credit", String.format("%-10.2f", (creditLimit - balance)) );
        map.put("Reward Points", String.format("%d", rewardPoints ));
        map.put("Fees", String.format("\t%-10.2f", totalFees ));
   
        map.put("Transaction Count", transactionTime.size());
        
     
       CreditCardReport creditCardReport = new CreditCardReport(header, map);
       creditCardReport.display();    
    }
    
}//end class

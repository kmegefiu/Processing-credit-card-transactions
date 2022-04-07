
package reports;

import java.util.ArrayList;
import java.util.Map;


public class CreditCardReport extends Report {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    //----------------------------------------
    // constructor 
    //----------------------------------------  
    

    public CreditCardReport(ArrayList<String> header, Map<String, Object> reportData) {
        super(header, reportData);
    }
    
    //----------------------------------------
    // instance method 
    //----------------------------------------  

    public void display() {
        
        for(String str:header){
            System.out.println(str);
        }//end for
        
        for (Map.Entry<String, Object> entry : reportData.entrySet()) {
            
            if(entry.getKey().equals("Remaining Credit") || entry.getKey().equals("Transaction Count") ){
                System.out.println(entry.getKey() + ":\t" + entry.getValue().toString());
            }else{
                System.out.println(entry.getKey() + ":\t\t" + entry.getValue().toString());
            }//end if else
        }//end for
        
        System.out.println("");
        
    }
    
}//end class

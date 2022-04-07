package reports;

import java.util.ArrayList;
import java.util.Map;


public class LoggerReport extends Report{
    
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    // THIS CLASS iS OK
    
    //----------------------------------------
    // constructor 
    //----------------------------------------  
    
    public LoggerReport(ArrayList<String> header, Map<String, Object> reportData) {
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
            System.out.println( entry.getValue().toString());
        }//end for
        
        System.out.println("");
    }
    
}//end class

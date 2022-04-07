package entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import reports.LoggerReport;
import reports.Reporter;


public class Logger implements Reporter{
    
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    //  I WILL TAKE A LOT OF POINT OFF IF YOU DO
    
    // THIS CLASS CODE IS OK
    
    // LOOK AT THIS CODE CAREFULLY
    // I DID A WORKAROUND TO MAKE IT WORK 
    // WHAT DID I DO AND WHY...... (you will see something interesting)
    
    //----------------------------------------
    // class varaivles
    //----------------------------------------
    
    private static int logNumber = 1;
    private static ArrayList<String> messages = new ArrayList<>();
    
    
    //----------------------------------------
    // constructor
    //----------------------------------------
    
    // hack here
    public Logger(){
        
        // WHY IS THE NO CODE HERE
        // WHY DID I NEED A CONSTRUCTOR
        // HINT LOOK AT THE runReportS()  
    }
    
    //----------------------------------------
    // class methods
    //----------------------------------------
    
    // why did I make this method final
    public static final void output(String sender, String message){
        
        // understand the formatted output 
        // match this code to the console output
        String output =  String.format("[%d]:[%s] -> %s", logNumber, sender, message);
        
        // understand what I am do here
        // where are all the messages store of the entire system
        messages.add(output);
        
        System.out.println("");
        System.out.printf(output);
        System.out.println("");
        logNumber++;
    }
    
    public static ArrayList<String> getMessages(){
        return Logger.messages;
    }
    
    //----------------------------------------
    // istance method
    //----------------------------------------
    
    @Override
    // hacked the OO code to make it work
    public void runReports(){
        
        Map<String, Object> map = new LinkedHashMap<>();

        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add("Logger Report");
        header.add("=======================================");
        
        String value = "";
        for(String str: messages){
            value = value + str + "\n";
        }
        map.put("", value);
        

        LoggerReport loggerReport = new LoggerReport(header, map);
        loggerReport.display();
        
    }
    
}// end of class

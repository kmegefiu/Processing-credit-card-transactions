package entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import payments.Cash;
import payments.credit.CreditCard;
import payments.credit.MasterCard;
import reports.FinancialReport;
import reports.PersonReport;
import reports.Reporter;


public class Person implements Reporter{
    // DO NOT CHANGE THE ACCESS MODIFIERS NAYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    
    //----------------------------------------
    // class variables
    //----------------------------------------    
    private static int personCount = 0;
 
    //----------------------------------------
    // instance variables
    //---------------------------------------- 
    private Person accountHolder;
    
    private String firstName;
    private String lastName;
    private String address;
    private String password; 
    private int creditScore;
    private ArrayList wallet;

    public Person(String firstName, 
                  String lastName, 
                  String address, 
                  String password,
                  int creditScore) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.creditScore = creditScore;
        

        wallet = new ArrayList<>();
        
        personCount++;



    }    

    //-----------------------------------------------------------
    // class methods
    //-----------------------------------------------------------    

    public static int getPersonCount() {
        return personCount;
    }
    
    //-----------------------------------------------------------
    // instance methods: setters and getters
    //-----------------------------------------------------------
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList getWallet() {
        return wallet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCreditScore() {
        return creditScore;
    }
    

   //-----------------------------------------------------------
   // instance methods: utiltity
   //-----------------------------------------------------------

    public void personReport(){
  
        // look at this carefully
        // look at the constructors type and the variable type
        
        Map<String, Object> map = new LinkedHashMap<>();
        
        map.put("First Name", firstName);
        map.put("Last Name", lastName);
        map.put("Address", address);
        
        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add("Person Report");
        header.add("=======================================");
        
        PersonReport personReport = new PersonReport(header, map);
        personReport.display();
        
    }
       
    public void financialReport(){
  
        // look at this carefully
        // look at the constructors type and the variable type
        
        Map<String, Object> map = new LinkedHashMap<>();
        
        map.put("First Name", "\t" + firstName);
        map.put("Last Name", "\t" + lastName);
        map.put("Address", "\t" + address);
        
        String walletContents = "\t";
        
        double totalCreditLimit = 0;
        double creditBalance = 0;
        double cash = 0;
        
        for(Object obj: wallet){
            if(obj instanceof CreditCard){
               walletContents = walletContents + "\t" + ((CreditCard)obj).getType() ;
               totalCreditLimit = totalCreditLimit + ((CreditCard) obj).getCreditLimit();
               creditBalance += ((CreditCard)obj).getBalance();
            }else if(obj instanceof Cash){
                walletContents = walletContents + "\t" + "Cash";
                cash +=  ((Cash)obj).getAmount();
            }
        }
        
        map.put("Wallet", walletContents);
        map.put("Total Credit Limit", String.format("%-10.2f",totalCreditLimit) );
        map.put("Credit Balance", String.format("\t%-10.2f",creditBalance) );
        map.put("Cash", String.format("\t\t%-10.2f", cash) );
        
        
        
        
        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add("Person Financial Report");
        header.add("=======================================");
        
        FinancialReport finacialReport = new FinancialReport(header, map);
        finacialReport.display();
        
    }
    
    //==============================================
    // reporter interface methods
    //==============================================
    @Override
    public void runReports(){
        financialReport();
    }

}//end class

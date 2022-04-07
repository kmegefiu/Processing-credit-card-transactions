//======================================================================================
// GOOD THE KNOW THESE ITEMS BELOW OF THE EXAM
//======================================================================================
/*


Rules for using Interface

    Methods inside Interface must not be static, final, native or strictfp.
    All VARIABLES declared inside interface are implicitly public, static, and final variables(constants).
    All MOTHODS declared inside Java Interfaces are implicitly public and abstract, even if you don't use public or abstract keyword.
    Interface can extend one or more other interface.
    Interface cannot implement a class.
    Interface can be nested inside another interface.

from: https://www.studytonight.com/java/java-interface.php


Important points about interface or summary of article:

    We can’t create instance(interface can’t be instantiated) of interface but we can 
        make reference of it that refers to the Object of its implementing class.
    A class can implement more than one interface.
    An interface can extends another interface or interfaces (more than one interface) .
    A class that implements interface must implements all the methods in interface.
    All the methods are public and abstract. And all the fields are public, static, and final.
    It is USED TO ACHIEVE multiple inheritance.
    It is used to achieve loose coupling.


From Java 9 onwards, interfaces can contain following also

    Static methods
    Private methods
    Private Static methods

from: https://www.geeksforgeeks.org/interfaces-in-java/
*/

//======================================================================================
// IMPORTANT READ THE TOP OF THIS FILE
//======================================================================================

package transactions;

import entities.Item;


public interface SecureTransaction{
    
    // interface can have static constants
    // this is static final public
     final double VERSION = 0.9;
    
    // interface can have variable  
    // can not do this why: Because the variable name is not all uppercase,
     //the compiler will run with no errors but it's not recommended 
    //int numberOfSecureTransaction = 0;
    // double totalTransactionAmount = 0;
    
    
    // this is public  method
    // public not needed
    String generateTransactionSecret();
    
    public void secureTransaction(Item item);
    
  
    // after Java 1.8 interface can jave static methods
    //public static method
    
    // DO I NEED TO WRTIE THIS METHOD
    // OR CAN GET THE VERSION WITHOUT THIS METHOD....You csn get it without the method
    static double version(){
        return VERSION;
    }

}//end class

//======================================================================================
// GOOD THE KNOW THESE ITEMS BELOW OF THE EXAM
//======================================================================================
/*

Rules for using Interface

    Methods inside Interface must not be static, final, native or strictfp.
    All variables declared inside interface are implicitly public static final variables(constants).
    All methods declared inside Java Interfaces are implicitly public and abstract, 
even if you don't use public or abstract keyword. (Compiler)
    Interface can extend one or more other interface.
    Interface cannot implement a class.(it can be extended)
    Interface can be nested inside another interface.

from: https://www.studytonight.com/java/java-interface.php


Important points about interface or summary of article:

    We can’t create instance(interface can’t be instantiated) of interface but we can 
        make reference of it that refers to the Object of its implementing class.
    A class can implement more than one interface.
    An interface can extends another interface or interfaces (more than one interface) .
    A class that implements interface must implements all the methods in interface.
    All the methods are public and abstract. And all the fields are public, static, and final.
    It is used to achieve multiple inheritance.
    It is used to achieve loose coupling.

Main reason for using interface classes: abstract classes may contain non-final variables, 
whereas variables in interface are final, public and static


From Java 9 onwards, interfaces can contain following also

    Static methods
    Private methods
    Private Static methods

from: https://www.geeksforgeeks.org/interfaces-in-java/
*/

//======================================================================================
// IMPORTANT READ THE TOP OF THIS FILE
//======================================================================================


package reports;

public interface Reporter {
    
    // DO NOT CHANGE THE ACCESS MODIFIERS ANYWHERE
    // I WILL TAKE A LOT OF POINT OFF IF YOU DO
   
    public void runReports();
    
}//end class

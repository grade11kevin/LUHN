// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.*;
import java.io.*;
// More packages may be imported in the space below


class CustomerSystem{
    public static void main(String[] args){             
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        confirmPostalCodeValidation = "5";
        exitCondition = "9";
    

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
            }
 
            
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }

    public static void enterCustomerInfo() {
        Scanner reader =  new Scanner(System.in);
        System.out.println("Please enter your first name:"); // prompts user for first name
        String firstName = reader.nextLine();
        System.out.println("Please enter your last name:"); // prompts user for last name
        String lastName = reader.nextLine();

        System.out.println("Please enter the name of your city:"); // prompts user for city
        String city = reader.nextLine();

        System.out.println("Please enter your postal code: "); // asks user for postal code
        String postalCode = reader.nextLine();
        String postalCodeValidation = validatePostalCode(postalCode); // calls from the validatePostalCode method to determine if the postal code is valid or not

        System.out.println("Please enter your credit card number"); // asks user for credit card number
        String creditCardNum = reader.nextLine();

    }

    public static void validatePostalCode(String[] args){
        try{
            File postalcodefile = new File("postal_codes.csv"); // reads the postal_code.csv
            Scanner reader = new Scanner(postalcodefile);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data); // prints out postal code  to match with the postal_codes.csv file to vladiate if its correct or not
            }
            reader.close();
        } catch (FileNotFoundException e){ //If the user inputs an invalid postal code; something that doesn't match any of the postal codes in the postal_codes.csv file, it will prompt user to try again and type a valid one
            System.out.println("Please enter a valid postal code");
            e.printStackTrace();
        }
            }
        
    
    public static void generateCustomerDataFile(){
    }

}
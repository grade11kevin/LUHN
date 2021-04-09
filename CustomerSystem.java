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
        String creditCardNum;
        while(!validateCreditCard(creditCardNum = reader.nextLine())){
            System.out.println("Invalid credit card number. Please enter a valid credit card number.");
        }
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

    public static boolean validateCreditCard(String creditCardNum){
        //These are local variables 
        String reverseCard = "";
        String digit = "";
        int cardNumber = 0;
        int sum1 = 0;
        String newNum = "";
        String digit1String = "";
        String digit2String = "";
        int digit1 = 0;
        int digit2 = 0;
        int digitSum = 0;
        int sum2 = 0;
        int totalSum = 0;
        String totalSumString = "";

        try{  //Try and catch loop just in case used inputs invalid credit card and causes an error to occur //While loop to make sure user inputs the correct number of digits
            int creditCardLength = creditCardNum.length(); //Checks the digits of the credit card

            if (creditCardLength != 9){ //If the card is not equal to 9 digits, will reloop
                System.out.println("\nPlease enter a card with a valid number of digits.\n");
                return false;
            }
            for (int i = 8; i >= 0; i --){ //Reverses the digits of the card
                reverseCard = reverseCard + creditCardNum.charAt(i);
            }
            for (int j = 0; j <= 8; j += 2){ //Loop that counts by twos in order to isolate odd digits
                digit = digit + reverseCard.charAt(j); //Turns the digit variable to the digit on the corresponding spot in the reversedCard
                cardNumber = Integer.parseInt(digit); //Turns the digit into a number
                sum1 = sum1 + cardNumber; //adds the number into the sum1
                digit = ""; //Resets the digit
            } 
            for (int k = 1; k <= 7; k += 2){ //Loops in order to isolate even digits
                digit = digit + reverseCard.charAt(k); //Adds the character in the kth spot of the card
                cardNumber = Integer.parseInt(digit); //Turns the character into a number
                cardNumber = cardNumber * 2; //Multiplies the character by 2
                newNum = String.valueOf(cardNumber); //Turns the number back into a string
                if (newNum.length() == 2){ //If the number has two digits, run internal code
                    digit1String = digit1String + newNum.charAt(0); //Separates both digits
                    digit2String = digit2String + newNum.charAt(1);
                    digit1 = Integer.parseInt(digit1String); //Turns each digit into a number
                    digit2 = Integer.parseInt(digit2String);
                    digitSum = digit1 + digit2; //Adds the digits together
                    sum2 = sum2 + digitSum; //Adds the digitSum to the sum2
                    digitSum = 0; //Resets digitSum and the digitStrings, as well as the digits
                    digit1String = "";
                    digit2String = "";
                    digit1 = 0;
                    digit2 = 0;
                }
                else{ //If number of digits is not 2, just add the sum2 to cardNumber
                    sum2 = sum2 + cardNumber;
                } 
                digit = ""; //Resets digit
            }

            totalSum = sum1 + sum2; //Adds the sum1 and sum2 together

            totalSumString = String.valueOf(totalSum); //Turns the total sum into a string
            digit1String = digit1String + totalSumString.charAt(0); //Turns digit1String into the 1st digit of totalSumString
            if (totalSumString.length() == 2){ //If the total sum has two digits...
                digit2String = digit2String + totalSumString.charAt(1); //Digit2String is equal to the 2nd digit of totalSumString
                digit2 = Integer.parseInt(digit2String); //Turns the second digit into a number
                if (digit2 == 0){ //If the digit is 0, it is valid
                    return true;
                }
                else{ //If the digit is not 0, it is invalid
                    return false;
                }
            }
            else{
                digit1 = Integer.parseInt(digit1String); //Turns digit1String into a number

                if (digit1 == 0){ //Change to boolean first //If digit1 is 0, valid
                    return true;
                }
                else{ //If it is not 0, it is invalid
                    return false;
                }
            }
        }
        catch(NumberFormatException e){ //Catches numberFormatException errors and prints corresponding message
            System.out.println("Please enter only numbers");
        }
        catch(Exception e){ //Catches any other errors that could be made 
            System.out.println("Something went wrong"); //Prints error message
        }

        return false; //Returns a boolean value of false
    }

}
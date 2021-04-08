import java.util.Scanner;

public class CardValidation {
    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            boolean cardDigitCheck = false;
            String reverseCard = "";
            String creditCard = "";
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

            try{  
                while (cardDigitCheck != true){
                    System.out.print("Please enter credit card number (No spaces): ");
                    creditCard = sc.nextLine();

                    int creditCardLength = creditCard.length();

                    if (creditCardLength != 9){
                        System.out.println("\nPlease enter a card with a valid number of digits.\n");
                    }

                    else {
                        cardDigitCheck = true;
                    }

                }

                for (int i = 8; i >= 0; i --){
                    reverseCard = reverseCard + creditCard.charAt(i);
                }


                for (int j = 0; j <= 8; j += 2){
                    digit = digit + reverseCard.charAt(j);
                    cardNumber = Integer.parseInt(digit);
                    sum1 = sum1 + cardNumber;
                    digit = "";
                } 

                //This entire thing doesn't work rn

                for (int k = 1; k <= 7; k += 2){
                    digit = digit + reverseCard.charAt(k);
                    cardNumber = Integer.parseInt(digit);
                    cardNumber = cardNumber * 2;
                    newNum = String.valueOf(cardNumber);
                    if (newNum.length() == 2){
                        digit1String = digit1String + newNum.charAt(0);
                        digit2String = digit2String + newNum.charAt(1);
                        digit1 = Integer.parseInt(digit1String);
                        digit2 = Integer.parseInt(digit2String);
                        digitSum = digit1 + digit2;
                        sum2 = sum2 + digitSum;
                        digitSum = 0;
                        digit1String = "";
                        digit2String = "";
                        digit1 = 0;
                        digit2 = 0;
                    }
                    else{
                        sum2 = sum2 + cardNumber;
                    }
                    
                    digit = "";
                }

                totalSum = sum1 + sum2;

                totalSumString = String.valueOf(totalSum);
                digit1String = digit1String + totalSumString.charAt(0);
                if (totalSumString.length() == 2){
                    digit2String = digit2String + totalSumString.charAt(1);
                    digit2 = Integer.parseInt(digit2String);
                    if (digit2 == 0){ //Change this to boolean first
                        System.out.println("valid");
                    }
                    else{
                        System.out.println("Not valid");
                    }
                }
                else{
                    digit1 = Integer.parseInt(digit1String);

                    if (digit1 == 0){ //Change to boolean first
                        System.out.println("valid");
                    }
                    else{
                        System.out.println("Not valid");
                    }

                }

            }

            catch(Exception e){
                System.out.println("Something went wrong");
            }
        
    }
    
}

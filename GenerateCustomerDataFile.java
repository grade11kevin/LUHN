import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class GenerateCustomerDataFile {
    public static void main(String[] args) throws IOException{
        String idString = "";
        String data = "";
        int id = 0;
        String fName = "";
        String lName = "";
        String city = "";
        String postalCode = "";
        String creditCard = "";


        try{
            File myText = new File("CustomerData.txt");
            Scanner myReader = new Scanner(myText);
            while (myReader.hasNextLine()){
                data = myReader.nextLine();
            }

            idString = data.substring(9);
            id = Integer.parseInt(idString);
            id = id + 1;
            idString = String.valueOf(id);


            FileWriter fw = new FileWriter("customerData.txt");
            fw.write("Name: " + fName + " " + lName + "\n");
            fw.write("City: " + city + "\n");
            fw.write("Postal Code " + postalCode + "\n");
            fw.write("Credit Card: " + creditCard + "\n");
            fw.write("User ID: " + idString);
            fw.close();

            myReader.close();


        } 
        catch(FileNotFoundException e){
            System.out.println("An error has occured");
            e.printStackTrace();
        }


    }
    
}

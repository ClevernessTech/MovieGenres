/* Assignment 4
 * Student: Jose Soto
 * CISC 3130-MY9
 * Brooklyn College, Spring 2020
 *
 * Used the opencsv-5.1.jar to do the CSV parsing this time when inputting the csv files, Apache commons-lang3-3.9.jar dependency is required.
 * Movie ID 171749 was edited as the year was (2006-2007), every other entry has just a 4 digit entry for year and it threw and error when
 * using parseInt
 *
 * Used OpenCSV again to read the CSV file, and then use an if statement to check if the last character of the Titles
 * substring is a ).  Certain lines in the data either have a space at the end, or some entries like Babylon 5 at ID 40697
 * have no year information at all in their titles column which will cause errors when parsing data.
 */


import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MovieGenres {

    // Test program
    public static void main( String [ ] args ) {
        BSTNode temp = new BSTNode( );
        File file = new File("csvFiles/movies.csv");
        String[] inputLine;

        try{
            CSVReader reader = new CSVReader(new FileReader(file));
            reader.skip(1); //CSVReader method to skip certain number of lines before reading data

            while ((inputLine = reader.readNext()) != null) {
                int tempID = Integer.parseInt(inputLine[0]);
                //int titleYearEnd = 0;
                String tempTitle;
                int tempYear = 0, length = inputLine[1].length();
                String lastLetter = inputLine[1].substring(length-1);
                if(lastLetter.equals(")")){
                    int titleYearEnd = inputLine[1].lastIndexOf(')') ;
                    int titleYearStart = inputLine[1].lastIndexOf('(') + 1;
                    tempTitle = inputLine[1].substring(0, (titleYearStart-2));
                    tempYear = Integer.parseInt(inputLine[1].substring(titleYearStart, titleYearEnd));
                }
                else{
                    tempTitle = inputLine[1];
                }


                String tempGenre = inputLine[2];
                MovieInfo info = new MovieInfo(tempID, tempTitle, tempYear, tempGenre);
                System.out.println(tempID + "\t" + tempTitle + "\t" + tempYear + "\t" + tempGenre);

                temp.insert(info);

            }reader.close();//stops reading file after while loop
        }catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }catch(NumberFormatException ex) {//Error handling incase wrong data is run through parseInt
            System.out.println("Error. Please input a valid number :-");
        }





    }
}
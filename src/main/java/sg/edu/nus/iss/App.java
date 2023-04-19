package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathfileName = dirPath + File.separator + fileName;

        File newDirectory = new File(dirPath);
        if (newDirectory.exists()){
            System.out.println("Directory already exists");
        } else {
            newDirectory.mkdir();
        }

        File myFile = new File(dirPathfileName);

        if (myFile.exists()){
            System.out.println("File " + myFile + " already exists");
        } else {
            myFile.createNewFile();
        }

        CSVWriter csvWriter = new CSVWriter();
        List<Employee> empList = csvWriter.generateEmployees();
        csvWriter.writeToCSV(empList, dirPathfileName);
        
        CSVReader csvReader = new CSVReader();
        List<Employee> retrievedList = csvReader.readCSV(dirPathfileName);
        System.out.println(retrievedList.toString());
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LSApp {
    /**
     * LSApp main method
     * @param args
     */
    public static void main (String[] args) {

        Scanner file=null;

/**
 * @Expection IOFile @throws FileNotFound Exception in case a non existant file is entered
*read from the Load Shedding text file using a scanner
 */
        try{
            file = new Scanner(new File("src\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }

        ArrayList<String> list = new ArrayList<>();
/**
*read file and store contents in arraylist

 */
        while (file.hasNext()) {
            try{
                list.add(file.nextLine());
            }catch(Exception e){
            e.printStackTrace();}

        }
/**
*store text file contents in array list into a String array
 */
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        /**
        *call the printAllArea method  to display all areas in text file

         */
        if(args.length==0){
            printAllAreas(arr);

        }
        else {
        /**
        *assign values of stage, day and startTime to search from the String array to get the areas that meet the search requirements by calling the printAreas() method
         */

            String stage = args[0];
            String day = args[1];
            String startTime = args[2];
            printAreas(stage, day, startTime, arr);
        }

    }
/**
 * @param a
 * @param day
 * @param stage
 * @param startTime
*create printAreas method to search through array the areas that have a certain stage , date and startTime
 */
    public static void printAreas(String stage, String day, String startTime, String[] a) {
        String key = stage + "_" + day + "_" + startTime;
        boolean flag=false;
        int opCount=0;
        for (int i = 0; i < a.length; i++) {
            opCount=opCount+1  ;
             int index= a[i].indexOf('_', 2);
            if (a[i].contains(key)) {
                flag=true;
                System.out.println(a[i].substring(index+4));
            }
        }
        if (flag==false){
           System.out.println(" Areas not found");
        }
        System.out.println("number of operations ="+opCount);



    }
    /**
     * @param a
    *create method printAllAreas to display all areas stored in the string array or in file
     */
        public static void printAllAreas(String[]a){
            for (int index = 0; index < a.length; index++) {
                //String[] line = null;
                //line = a[index].split(" ");
                System.out.println(a[index]);

        }

    }
}

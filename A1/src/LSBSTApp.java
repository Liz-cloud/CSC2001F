import java.io.File;
import java.util.Scanner;

public class LSBSTApp {
    /**
     * LSBSTApp main method
     * @param args
     */
    public static void main(String[] args){
        /**
        *create BinarySearchTree of type LoadS declare variables used in the reading of LoadShedding text file and insertion of LoadS objects in BinarySearchTree
         */
        BinarySearchTree<LoadS> b=new BinarySearchTree<LoadS>();
        Scanner file=null;
        String key =null;
        String area=null;
        String line=null;
/**
 * @Expection IOFile @throws FileNotFound Exception in case a non existant file is entered
*read from text file using Scanner use try catch to catch any errors example file not found error
 */
        try {
             file = new Scanner(new File("src\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        }catch(Exception e){
            System.out.println("file not found");
        }
        /**
        *loop through scanner variable .
        * Use substring to create key and area LoadS instance variables.
         *Create a LoadS object using the accessed instance variables from the text file .
        *Use try catch to any errors example index out of bound error/ exception
         */
        while(file.hasNextLine()){
            try {
                line = file.nextLine();
                int i = line.indexOf(" ");
                key = line.substring(0, i);
                area = line.substring(i + 1);
                LoadS ld = new LoadS(key, area);
                b.insert(ld);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //String k=args[0]+"_"+args[1]+"_"+args[2]+" ";
        //LoadS l=new LoadS(k,"12, 4, 8");
        // BinaryTreeNode<LoadS> x=b.find(l);
        //  System.out.println(x.toString());
        /**
         *if the are no arguments passed print all the LoadShedding areas else find the node that has the required key and print the areas
         */
        if (args.length == 0) {
            printAllAreas(b);
        } else {
            printAreas(args[0], args[1], args[2], b);
        }
        System.out.println("number of operations: " + b.getOpCount());

    }
    /**
     * @param a
    *Create printAllAreas method to display all Load Shedding areas in  text file
     */
    public static void printAllAreas(BinarySearchTree<LoadS> a){
        a.inOrder();


    }
    /**
     * @param startTime
     * @param a
     * @param stage
     * @param day
      *Create a printAreas method that searches for the node that has the required stage, day and start Time ie.(key) then print the areas out else print areas not found
     */
    public static void printAreas(String stage, String day, String startTime ,BinarySearchTree< LoadS> a){
        String key = stage + "_" + day + "_" + startTime;
        LoadS l = new LoadS(key, "");
        boolean flag=false;
        BinaryTreeNode<LoadS> area= a.find(l);
        System.out.println("here");
        if(area!=null) {
            flag = true;
        }
        String x=(area.toString());
        if (flag==true ){
           // int index= x.indexOf('_', 2);
            System.out.println(area.data.getArea());
        }
        else{
            System.out.println(" Areas not found");
        }
        }

    }




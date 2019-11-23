import java.io.FileNotFoundException;

public class Driver {
    /*
        Purpose: The driver classed contains the program's main method for sorting students by their id
        1) A student parser object is created using the StudentsInput text file
        2) The current student file is printed to terminal
        3) The sort (binary insertion sort) method is called on the student parser object
        4) The sorted student file is printed to terminal
        5) The sorted student file is written to the Output text file

     */
    public static void main(String[] args){
        try {
            StudentParser sp = new StudentParser("StudentsInput.txt");
            System.out.println("Original File");
            System.out.println(sp);
            System.out.println("Sorted File");
            sp.sort();
            System.out.println(sp);
            sp.writeToFile("OutputFile.txt");
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }

    }


}


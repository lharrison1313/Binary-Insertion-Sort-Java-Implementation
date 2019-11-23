import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Formatter;

public class StudentParser {
    /*
        Purpose: the purpose of the studentParser class is to parse, store, and sort a collection of student objects obtained from a text file
        Fields: the studentParser fields are described as follows
            - (ArrayList<String>) students: an array of student objects parsed from a text file
     */
    private ArrayList<Student> students;

    //StudentParser constructor that initializes the students ArrayList and calls the parsFile method
    //Inputs: a string representing the file path of the file containing students
    public StudentParser(String inputFile) throws FileNotFoundException{
        students = new ArrayList<>();
        parseFile(inputFile);
    }

    //Parses the provided text file of students into an ArrayList of student objects
    //Inputs: a string representing the file path of the file containing students
    public void parseFile(String inputFile) throws FileNotFoundException{
        students.clear();
        Scanner s = new Scanner(new File(inputFile));
        String line;
        String[] studInfo;
        String name;
        int id;
        int age;
        double gpa;
        Student stud;
        while(s.hasNext()){
            //loops until all lines are parsed
            line = s.nextLine();
            studInfo = line.split(" ");
            name = studInfo[0];
            id = Integer.parseInt(studInfo[1]);
            gpa = Double.parseDouble(studInfo[2]);
            age =  Integer.parseInt(studInfo[3]);
            stud = new Student(name,id,gpa,age);
            students.add(stud);
        }
    }

    //Writes the ArrayList of students objects to the file as a formatted string of students
    //Inputs: a string representing the path of an output file or file name
    public void writeToFile(String outputFile)throws FileNotFoundException{
        Formatter f = new Formatter(outputFile);
        f.format("%s",toString());
        f.close();
    }

    //Sorts the ArrayList students field using binary insertion sort
    public void sort(){
        Student temp;
        int left, right, center, newPos;
        for(int x = 1; x<students.size(); x++){
            temp =  students.get(x);
            left = 0;
            right = x-1;
            newPos = x;
            //binary search to find new position
            while(left <= right){
                center = (int) Math.floor((left+right)/2);
                if(temp.getId() >=  students.get(center).getId()){
                    left = center+1;
                }
                else{
                    right = center-1;
                    newPos = center;
                }
            }
            //moving value at position x to new position
            if(newPos != x){
                students.remove(x);
                students.add(newPos,temp);
            }
        }
    }

    //Student parser's toString method that converts the ArrayList students field into a formatted string
    //Output: a formatted string of the ArrayList student field
    public String toString(){
        String output = "";
        for(Student s: students){
            output += s.toString()+"\n";
        }
        return output;
    }
}

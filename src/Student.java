public class Student {
    /*
        Purpose: the purpose of the student class is to store data associated with each student in the text file
        Fields: the student fields are described as follows
            - (String) name: holds the name of the student
            - (int) id: holds the students id
            - (int) gpa: holds the students gpa
            - (int) age: holds the students age
     */
    private String name;
    private int id;
    private double gpa;
    private int age;

    //Student constructor that initializes all fields with values from parameters
    //inputs: a string representing the name of the person, and integers representing their id, gpa, and age
    public Student(String name, int id, double gpa, int age){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.age = age;
    }

    //Returns the students id
    public int getId(){
        return id;
    }

    //The student class's to string method which prints a formatted string consisting of all its fields
    //Output: A formatted string of all the students fields
    public String toString(){
        return String.format("Name: %s ID: %d GPA: %.2f AGE: %d", name,id,gpa,age);
    }
}

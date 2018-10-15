package com.decipher;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author purushottam
 * perform various operations according to user userInput
 *
 */

public class Operations {
    private File file = new File("text.txt");
    private BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    private List<Student> studentList = new ArrayList<Student>();
    private int userInput = 0;
    private int id = 0;


    /**
     * To create a New File
     */
    public void filecreation() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException io) {
            System.out.println(io);
        }
    }//end of Method

    /**
     *to Generate the auto Incremental Id
     *@return int id
     */
    public int idgenerate() {
        id = 0;
        try {
            readfile();
            for (Student student : studentList) {
                if (student.getId() > id) {
                    id = student.getId();
                }
            }
            id++;
            studentList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }//method end


    /**
     * Read From Txt File and Store In a ArrayLisst
     * @throws IOException

     */
    public void readfile() throws IOException {
        studentList.clear();
        filecreation();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String string = bufferedReader.readLine();
            while (string != null) {
                String words = string.toString();
                String wordslist[] = words.split(" +");
                int id = Integer.parseInt(wordslist[0]);
                String name = wordslist[1];
                int age = Integer.parseInt(wordslist[2]);
                Student student1 = new Student(name, age, id);
                // System.out.println(id + " " + name + " " + age);
                studentList.add(student1);
                string = bufferedReader.readLine();
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println(a);
        } finally {
            bufferedReader.close();
        }
    }//end of method


    /**
     *@throws IOException
     *write in Txt file To ArrayList
     */
    public void write() throws IOException {
        filecreation();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        try {
            for (Student student2 : studentList) {
                bufferedWriter.write(student2.getId() + " " + student2.getName() + " " + student2.getAge() + "\n");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            bufferedWriter.close();
        }
        studentList.clear();

    }//method end


    /**
     * add a new Student in the File
     * @throws IOException
     * Firstly called method if there is no Data in File
     */
    public void addStudent(int id) throws IOException {
        filecreation();
        try {
            studentList.clear();

            System.out.println("Enter Student Name");
            String name = bufferReader.readLine();
            System.out.println("Enter Student Age");
            int age = Integer.parseInt(bufferReader.readLine());

            Student student = new Student(name, age, id);
            studentList.add(student);
            write();
            System.out.println("Insert Successfully");

        } catch (NumberFormatException e) {
           e.getStackTrace();
        }

    }//method end

    /**
     * to Show the File Data
     * @throws IOException
     *
     */
    public void display() throws IOException {
        filecreation();
        readfile();
        if (studentList.isEmpty()) {
            System.out.println("no data Found");
        } else {

            for (Student student : studentList) {
                System.out.println(student.toString());
            }

        }

    }


    /**
     * to Remove a particular Student to File
     * @throws IOException
     *
     */
    public void remove(int id ) throws IOException {
        filecreation();
        readfile();
        int found = 0;
        PrintWriter writer = new PrintWriter(file);
        try {

            userInput = id;
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId() == userInput) {
                    found = 1;
                    studentList.remove(i);
                }
            }
            if (found == 1) {
                System.out.println(" stuent record  deleted from file");
            } else {
                System.out.println(" Stuent not Found ");
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
        } finally {
            writer.close();
        }
        writer.print("");
        write();
    }//method end


    /**
     *  to show the particular Student
     *  takes  Integer arrgument
     */
    public void displayById(int id) throws IOException {
        studentList.clear();
        filecreation();
        readfile();
        String name = "";
        int age = 0;

        int found = 0;

        try {

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId() == id) {
                    found = 1;
                    name = studentList.get(i).getName();
                    age = studentList.get(i).getAge();
                    id = studentList.get(i).getId();

                }
            }
            if (found == 1) {
                System.out.println( id+" "+name+" "+" "+age);

            } else {
                System.out.println("No student found");
            }
        } catch (NumberFormatException n) {
            System.out.println("Invalid Input!");
        }
    }//method end


    /**
     * update the Record of particular Student
     * @throws IOException
     */


    public void update() throws IOException {
        studentList.clear();
        filecreation();
        readfile();
        int found = 0;
        PrintWriter writer = new PrintWriter(file);
        try {
            System.out.println("Enter the id");
            userInput = Integer.parseInt(bufferReader.readLine());
            for (Student student : studentList) {
                if (student.getId() == userInput) {
                    found = 1;
                    System.out.println("Enter Student Name");
                    String name = bufferReader.readLine();
                    System.out.println("Enter Student Age");
                    int age = Integer.parseInt(bufferReader.readLine());
                    student.setName(name);
                    student.setAge(age);
                }
            }
            if (found == 1) {
                System.out.println("id " + userInput + " is updated");
            } else {
                System.out.println("id " + userInput + " Not found");
            }
        } catch (NumberFormatException n) {
            System.out.println("Invalid Input!");
        } finally {
            writer.close();
        }
        writer.print("");
        write();
    }//method end

}
//class end


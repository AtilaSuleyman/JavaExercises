package Intermediate;

import java.io.*;
import java.util.ArrayList;

public class WorkingWithFiles {

    ArrayList<Person> people = new ArrayList<Person>();

    public WorkingWithFiles(){

        Person p = new Person("Atila", 22, "IT Consultant");
        people.add(p);
        p = new Person("Mahmoud", 22, "IT Consultant");
        people.add(p);
        p = new Person("Ben", 22, "IT Consultant");
        people.add(p);
        p = new Person("Sky", 22, "Meterologist");
        people.add(p);
        p = new Person("Becky", 22, "HR");
        people.add(p);

    }

    public void writeToFile() {
        try{
            String filename = "exercise.txt";
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Person p : people) {
                System.out.println(p);
                bw.write(p.getName()+","+p.getAge()+","+p.getJobTitle()+"\n");
            }
            bw.close();
            System.out.println("DONE!");
        }catch(IOException e){
            e.printStackTrace();
        };
    }

    public void readFromFile() {

        BufferedReader reader = null;
        ArrayList<Person> peopleReadFromFile = new ArrayList<Person>();

        try {
            File file = new File("exercise.txt");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] personInfo=line.split(",");
                Person person = new Person(personInfo[0],Integer.parseInt(personInfo[1]),personInfo[2]);
                peopleReadFromFile.add(person);
            }
            //For testing purposes
            for (Person p: peopleReadFromFile) {
                System.out.println(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main (String [] args){
        WorkingWithFiles createFile = new WorkingWithFiles();
        createFile.writeToFile();
        createFile.readFromFile();
    }
}

package com.amber;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.io.Serializable;

public class Binary implements Serializable {
    //z: serializing: sending to object
    //z: deserialize: getting back from the object

    private File file = new File("students.txt");
    private static ArrayList<Student> students = new ArrayList<>();

    public Binary() {
        students.add(new Student("Amber", 4.0));
        students.add(new Student("Cami", 3.8));
        students.add(new Student("Mom", 5.0));
        output();

    }
    private void output(){
        try{
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fo);
            for(Student s : students){
                output.writeObject(s);
            }
            output.close();

        }catch(IOException ex ){
            //z: the file not found exception is a child of IO exception,so we can only use one
            System.out.println("catch");
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    //z: DESERIALIZE
    public void deserialize(){
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fi);
            ArrayList<Student> secondStudents = new ArrayList<>();

            try{
                while (true){
                    Student s = (Student)input.readObject();
                    secondStudents.add(s);
                }
            }catch (EOFException | ClassNotFoundException ex){
                System.out.println("end of loop");
                System.out.printf("ERROR: %s\n", ex);
                System.out.println("--");
            }

            //z: check it
            for(Student s : secondStudents){
                System.out.println(s.getName());
            }


        }catch (IOException ex){
            System.out.printf("ERROR: %s\n", ex);
        }

    }





}

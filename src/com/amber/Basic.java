package com.amber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Basic {
    private File file = new File("test.txt");

    //w: read file
    public void readFile(){
        try {
            Scanner scan = new Scanner(file);
            String name = scan.nextLine();
            System.out.printf("Name: %s\n", name);
            String age = scan.nextLine();
            System.out.printf("Age: %s\n", age);
        } catch (
                FileNotFoundException ex){
            System.out.println("File not found");
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    //w: write to file... always close it
    public void writeToFile(){
        try {
        PrintWriter output = new PrintWriter(file);
            output.println("Amber Jones");
            output.println(32);
            output.close();

        }catch (IOException ex){
            System.out.printf("ERROR: %s\n", ex);
        }
        }





}

package paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//z: Path is the core

public class PathPractice {
    private List<String> animals = Arrays.asList("Shelby", "Punkin", "Sophia");
    private Path loremFile = Paths.get("files", "lorem.txt");

    public boolean checkPath(){
        boolean exists = Files.exists(loremFile);
        System.out.println(exists);
        return exists;
    }

    public void readLines(){
        try {
            if(!checkPath()) throw new IOException();
            List<String> data = Files.readAllLines(loremFile);
            System.out.println(data);
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    public void writeTo(){
        try {
            if(!checkPath()) throw new IOException();
            Files.write(loremFile, animals, StandardOpenOption.APPEND);
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }


}

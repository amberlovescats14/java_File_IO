package paths;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//z: Path is the core

public class PathPractice {
    public void checkPath(){
        //z: folder, fileName
        Path loremFile = Paths.get("files", "lorem.txt");

        //z: same unless you are using a relative path
        loremFile.toString();
        loremFile.getFileName();

       boolean exists = Files.exists(loremFile);
        System.out.println(exists);

        try {
            List<String> data = Files.readAllLines(loremFile);
            System.out.println(data);
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }



    }
}

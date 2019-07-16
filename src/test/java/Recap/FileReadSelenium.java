package Recap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadSelenium {

    public static void main(String[] args) throws IOException {

        File myFile = new File("/Users/dinash/Downloads/test.txt");
        FileReader fr = new FileReader(myFile);

        for(int i = 0; i < myFile.length(); i++){
            System.out.print((char)fr.read());

        }
        fr.close();
    }
}

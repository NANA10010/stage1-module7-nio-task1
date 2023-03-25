package com.epam.mjc.nio;

import java.io.File;
import java.io.*;
import java.nio.file.*;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        
        Path path = Path.of(file.getPath());

        String[] arr = new String[4];

        String name = "";
        String email = "";
        Integer age = 0;
        long phoneNumber = 0;


        try (InputStream in = Files.newInputStream(path);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {

            int ind = 0;

            while (  ind <4) {
                arr[ind] = reader.readLine();
                String newStr = "";
                int index=  arr[ind].indexOf(':');
                for (int i=index+2; i<arr[ind].length(); i++){
                    newStr+=arr[ind].charAt(i);
                }
                arr[ind] = newStr;
                ind++;
            }

        } catch (IOException x) {
            System.err.println(x);
        }

        name = arr[0];
        age = Integer.parseInt(arr[1]);
        email = arr[2];
        phoneNumber = Long.parseLong(arr[3]);

       return new Profile(name, age, email, phoneNumber);
    }
}

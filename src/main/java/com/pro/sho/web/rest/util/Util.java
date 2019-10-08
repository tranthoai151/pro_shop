package com.pro.sho.web.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Util {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public static String writeFile(byte[] bytes, String fileName) throws IOException {

        BufferedOutputStream bufferedOutputStream = null;

        try {
            // Creating the directory to store file
            File dir = new File(System.getProperty("img") + File.separator);

            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            String filePath = dir.getAbsolutePath() + File.separator + fileName;
            File serverFile = new File(filePath);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFile));
            bufferedOutputStream.write(bytes);

            return filePath;
        } catch (Exception e) {

            e.printStackTrace();
            throw new IOException();
        } finally {

            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

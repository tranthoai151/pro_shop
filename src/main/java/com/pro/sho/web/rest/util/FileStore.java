package com.pro.sho.web.rest.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStore {
    public static boolean createFile(MultipartFile file) throws IOException {
        File f = new File("/Users/develop/My_Project_Tutorial/my_pro/pro_shop/src/main/resources/img/"+  file.getOriginalFilename());

        f.createNewFile();
        return true;
    }
}

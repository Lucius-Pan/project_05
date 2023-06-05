package indi.Lucius.controller;

import indi.Lucius.dto.JsonDto;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: FileControl
 * @Description: 文件相关控制
 * @Author: Lucius Pan
 * @Date: 2023/6/1 21:12
 */

@RestController
public class FileControl {

    @PostMapping("/upload")
    public JsonDto uploadFile(MultipartFile chooseFile) {
        System.out.println("收到了："+chooseFile.getOriginalFilename());
        try {
            InputStream inputStream = chooseFile.getInputStream();
            int copy = IOUtils.copy(inputStream, new FileOutputStream("/Users/lucius/Documents/"+chooseFile.getOriginalFilename()));
            System.out.println("copy: "+copy);
        } catch (IOException e) {
           e.printStackTrace();
        }

        return new JsonDto("200","succeed");
    }
}

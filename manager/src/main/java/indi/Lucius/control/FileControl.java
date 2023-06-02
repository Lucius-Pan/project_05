package indi.Lucius.control;

import indi.Lucius.dto.NormalDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FileControl
 * @Description: 文件相关控制
 * @Author: Lucius Pan
 * @Date: 2023/6/1 21:12
 */

@RestController
public class FileControl {

    @PostMapping("manager/upload")
    public NormalDto uploadFile(){
        System.out.println("收到了：upload");
        return null;
    }
}

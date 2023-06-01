package indi.Lucius.control;

import indi.Lucius.dto.NormalDto;
import indi.Lucius.pojo.UserPojo;
import indi.Lucius.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: UserControl
 * @Description: user相关control
 * @Author: Lucius Pan
 * @Date: 2023/5/31 14:24
 */


@RestController
public class UserControl {

    @Resource
    UserServiceImpl userService;

    //使用账号密码登陆
     @PostMapping("/userLogin")
     public NormalDto userLogin(String userName,String userPwd) {
         UserPojo userPojo = userService.userLogin(userName, userPwd);
         if (userPojo == null) {
             return new NormalDto("500", "fail");
         }else {
             return new NormalDto("200", "succeed", "manager");
         }
     }
}

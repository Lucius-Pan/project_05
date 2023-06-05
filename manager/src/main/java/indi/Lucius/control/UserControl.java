package indi.Lucius.control;

import indi.Lucius.dto.JsonDto;
import indi.Lucius.pojo.UserPojo;
import indi.Lucius.service.IUserService;
import indi.Lucius.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: UserControl
 * @Description: user相关control
 * @Author: Lucius Pan
 * @Date: 2023/5/31 14:24
 */


@RestController
public class UserControl {

    @Resource
    IUserService userService;

    //使用账号密码登陆
     @PostMapping("/userLogin")
     public JsonDto userLogin( HttpServletRequest request) {
            String userName = request.getParameter("userName");
            String userPwd = request.getParameter("userPwd");
         UserPojo userPojo = userService.userLogin(userName, userPwd);

         if (userPojo == null) {
             return new JsonDto("500", "fail");
         }else {
             request.getSession().setAttribute("user",userPojo);
             JsonDto jsonDto = new JsonDto("200", "succeed");
             jsonDto.getData().put("location","manager");
             return jsonDto;
         }
     }


}

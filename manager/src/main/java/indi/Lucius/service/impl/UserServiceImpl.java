package indi.Lucius.service.impl;

import indi.Lucius.mapper.UserMapper;
import indi.Lucius.pojo.UserPojo;
import indi.Lucius.service.IUserService;
import indi.Lucius.until.SpringFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务业务处理实现类
 * @Author: Lucius Pan
 * @Date: 2023/5/28 21:11
 */

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public UserPojo userLogin(String userName, String userPwd) {
        userMapper = SpringFactory.getApplicationContext().getBean(UserMapper.class);
        UserPojo userPojo = userMapper.selectUserByAccAndPwd(userName, userPwd);
        return userPojo;
    }
}

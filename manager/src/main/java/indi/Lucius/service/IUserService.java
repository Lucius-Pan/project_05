package indi.Lucius.service;

import indi.Lucius.pojo.UserPojo;

/**
 * @InterfaceName: IUserService
 * @Description: 用户服务业务处理
 * @Author: Lucius Pan
 * @Date: 2023/5/28 21:10
 */

public interface IUserService {
    UserPojo userLogin(String userName,String userPwd);
}

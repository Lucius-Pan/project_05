package indi.Lucius.mapper;

import indi.Lucius.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName: UserMapper
 * @Description: 关于User的SQL语句
 * @Author: Lucius Pan
 * @Date: 2023/5/26 11:17
 */
public interface UserMapper {

    UserPojo selectUserByAccAndPwd(@Param("userAcc") String userAcc , @Param("userPwd") String userPwd);
}

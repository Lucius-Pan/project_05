package indi.Lucius.pojo;

import lombok.Data;

/**
 * @ClassName: UserPojo
 * @Description: UserPojo
 * @Author: Lucius Pan
 * @Date: 2023/5/26 11:17
 */
@Data
public class UserPojo {
  private int userId;
  private String userName;
  private String userAcc;
  private String userPwd;
}

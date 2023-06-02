package indi.Lucius.pojo;

import lombok.Data;

/**
 * @ClassName: EmpPojo
 * @Description: 员工表Pojo
 * @Author: Lucius Pan
 * @Date: 2023/5/29 21:13
 */

@Data
public class EmpPojo {
    private int empId;
    private String empName;
    private int roomId;
    private int roleId;
    private int bState;

    public EmpPojo() {
    }

    public EmpPojo(int empId, String empName, int roomId, int roleId, int bState) {
        this.empId = empId;
        this.empName = empName;
        this.roomId = roomId;
        this.roleId = roleId;
        this.bState = bState;
    }
}

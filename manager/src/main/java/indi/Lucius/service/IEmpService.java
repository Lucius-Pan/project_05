package indi.Lucius.service;

import java.util.List;

/**
 * @InterfaceName: IEmpService
 * @Description: 员工表有关业务逻辑控制
 * @Author: Lucius Pan
 * @Date: 2023/5/29 16:49
 */
public interface IEmpService {
    List selectAll(String name,String roleId,String roomId,String bState,Integer page);
    Integer selectAllNum(String name,String roleId,String roomId,String bState);

    Integer insertEmp(String name,String roleId,String roomId);

    Integer updateEmp(String empId,String roleId,String roomId);


}

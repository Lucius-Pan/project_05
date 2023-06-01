package indi.Lucius.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName: EmpMapper
 * @Description: Emp的mapper
 * @Author: Lucius Pan
 * @Date: 2023/5/29 16:57
 */
public interface EmpMapper {
    List selectAll(@Param("empName") String empName, @Param("roleId") String roleId, @Param("roomId") String roomId, @Param("bState") String bState, @Param("page") int page);
    Integer selectAllNum(@Param("empName") String empName, @Param("roleId") String roleId, @Param("roomId") String roomId, @Param("bState") String bState);

    Integer insertEmp(@Param("empName") String empName, @Param("roleId") String roleId, @Param("roomId") String roomId);

    Integer updateEmp(@Param("empId") String empId, @Param("roleId") String roleId, @Param("roomId") String roomId);


}

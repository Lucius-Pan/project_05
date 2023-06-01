package indi.Lucius.service.impl;

import indi.Lucius.mapper.EmpMapper;
import indi.Lucius.pojo.EmpPojo;
import indi.Lucius.service.IEmpService;
import indi.Lucius.until.SpringFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: EmpServiceImpl
 * @Description: 员工表有关业务逻辑控制实现类
 * @Author: Lucius Pan
 * @Date: 2023/5/29 16:55
 */

@Service
public class EmpServiceImpl implements IEmpService {
    @Override
    public List selectAll(String name,String roleId,String roomId,String bState,Integer page) {
        page = (page - 1) * 5;
        EmpMapper empMapper = SpringFactory.getApplicationContext().getBean(EmpMapper.class);
        List<EmpPojo> list = empMapper.selectAll(name, roleId, roomId, bState, page);


        return list;
    }

    @Override
    public Integer selectAllNum(String name, String roleId, String roomId, String bState) {
        EmpMapper empMapper = SpringFactory.getApplicationContext().getBean(EmpMapper.class);
        Integer num = empMapper.selectAllNum(name, roleId, roomId, bState);
        return num;
    }

    @Override
    public Integer insertEmp(String name, String roleId, String roomId) {

        EmpMapper empMapper = SpringFactory.getApplicationContext().getBean(EmpMapper.class);
        Integer num = empMapper.insertEmp(name, roleId, roomId);
        return num;
    }

    @Override
    public Integer updateEmp(String empId, String roleId, String roomId) {
        EmpMapper empMapper = SpringFactory.getApplicationContext().getBean(EmpMapper.class);
        Integer num = empMapper.updateEmp(empId, roleId, roomId);
        return num;
    }


}

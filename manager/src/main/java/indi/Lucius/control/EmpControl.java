package indi.Lucius.control;

import indi.Lucius.dto.ListPassDto;
import indi.Lucius.dto.NormalDto;
import indi.Lucius.pojo.EmpPojo;
import indi.Lucius.service.impl.EmpServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: EmpControl
 * @Description: user相关control
 * @Author: Lucius Pan
 * @Date: 2023/5/31 14:21
 */

@RestController
public class EmpControl {

    @Resource
    EmpServiceImpl empService;

    @PostMapping("/insertEmp")
    public NormalDto insertEmp(String userName, String roleId, String roomId) {
        Integer flag = empService.insertEmp(userName, roleId, roomId);
        if (flag > 0) {
            return new NormalDto("200", "succeed");
        } else {
            return new NormalDto("500", "failed");
        }
    }

    @PostMapping("/selectAllEmp")
    public ListPassDto selectAllEmp(String userName, String role, String room, String b_state, Integer page) {
        List<EmpPojo> list = empService.selectAll(userName, role, room, b_state, page);
        Integer num = empService.selectAllNum(userName, role, room, b_state);
        if (list == null || list.size() == 0) {
            return new ListPassDto("500", "error or List is null");
        } else {
            return new ListPassDto("200", "succeed", list, num);
        }
    }

    @PostMapping("/updateEmp")
    public NormalDto updateEmp(String empId, String roleId, String roomId) {
        Integer flag = empService.updateEmp(empId, roleId, roomId);
        if (flag > 0) {
            return new NormalDto("200", "succeed");
        } else {
            return new NormalDto("500", "failed");
        }
    }
}

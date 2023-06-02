package indi.Lucius.control;

import indi.Lucius.dto.JsonDto;
import indi.Lucius.pojo.EmpPojo;
import indi.Lucius.service.IEmpService;
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
    IEmpService empService;

    @PostMapping("/insertEmp")
    public JsonDto insertEmp(String userName, String roleId, String roomId) {
        Integer flag = empService.insertEmp(userName, roleId, roomId);
        if (flag > 0) {
            return new JsonDto("200", "succeed");
        } else {
            return new JsonDto("500", "failed");
        }
    }

    @PostMapping("/selectAllEmp")
    public JsonDto selectAllEmp(String userName, String role, String room, String b_state, Integer page) {
        List<EmpPojo> list = empService.selectAll(userName, role, room, b_state, page);
        Integer num = empService.selectAllNum(userName, role, room, b_state);
        if (list == null || list.size() == 0) {
            return new JsonDto("500", "error or List is null");
        } else {
            JsonDto jsonDto = new JsonDto("200", "succeed");
            jsonDto.getData().put("list", list);
            jsonDto.getData().put("num", num);
            return jsonDto;
        }
    }

    @PostMapping("/updateEmp")
    public JsonDto updateEmp(String empId, String roleId, String roomId) {
        Integer flag = empService.updateEmp(empId, roleId, roomId);
        if (flag > 0) {
            return new JsonDto("200", "succeed");
        } else {
            return new JsonDto("500", "failed");
        }
    }

    @PostMapping("/deleteEmp")
    public JsonDto deleteEmp(String empId) {
        System.out.println("eid: "+empId);
        Integer flag = empService.deleteEmp(empId);
        if (flag > 0) {
            return new JsonDto("200", "succeed");
        } else {
            return new JsonDto("500", "failed");
        }
    }
}

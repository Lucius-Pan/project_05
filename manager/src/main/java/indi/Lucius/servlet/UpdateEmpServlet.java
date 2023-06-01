package indi.Lucius.servlet;

import com.alibaba.fastjson.JSON;
import indi.Lucius.dto.NormalDto;
import indi.Lucius.service.IEmpService;
import indi.Lucius.until.SpringFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UpdateEmpServlet
 * @Description: 更新员工表信息
 * @Author: Lucius Pan
 * @Date: 2023/5/30 21:19
 */

@WebServlet("/updateEmp")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        String empId = req.getParameter("empId");
        String roleId = req.getParameter("roleId");
        String roomId = req.getParameter("roomId");
        System.out.println(empId+" : "+roleId+" : "+roomId);
        Integer integer = SpringFactory.getApplicationContext().getBean(IEmpService.class).updateEmp(empId, roleId, roomId);
        if (integer >0) {
           resp.getWriter().println(JSON.toJSONString(new NormalDto("200", "succeed")));
        } else {
            resp.getWriter().println(JSON.toJSONString(new NormalDto("500", "failed")));
        }

    }
}

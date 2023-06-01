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
 * @ClassName: InsertServlet
 * @Description: 新增员工Servlet
 * @Author: Lucius Pan
 * @Date: 2023/5/30 15:43
 */

@WebServlet("/insertEmp")
public class InsertEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String roleId = req.getParameter("roleId");
        String roomId = req.getParameter("roomId");
        System.out.println(userName+" : "+roleId+" : "+roomId);
        IEmpService empService = SpringFactory.getApplicationContext().getBean(IEmpService.class);
        Integer num = empService.insertEmp(userName,roleId,roomId);
        if (num > 0) {
            resp.getWriter().println(JSON.toJSONString(new NormalDto("200", "succeed")));
        } else {
            resp.getWriter().println(JSON.toJSONString(new NormalDto("500", "failed")));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}

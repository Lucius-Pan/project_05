package indi.Lucius.servlet;

import com.alibaba.fastjson.JSON;
import indi.Lucius.dto.ListPassDto;
import indi.Lucius.pojo.EmpPojo;
import indi.Lucius.service.impl.EmpServiceImpl;
import indi.Lucius.until.SpringFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: SelectAllServlet
 * @Description: 获取所有数据的Servlet
 * @Author: Lucius Pan
 * @Date: 2023/5/29 16:40
 */

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");

        String role = req.getParameter("role");
        String room = req.getParameter("room");
        String b_state = req.getParameter("b_state");
        Integer page = Integer.parseInt(req.getParameter("page"));
        System.out.println(userName+" : "+role+" : "+room+" : "+b_state+" : "+page);
        EmpServiceImpl empService = SpringFactory.getApplicationContext().getBean(EmpServiceImpl.class);
        List<EmpPojo> list = empService.selectAll(userName, role, room, b_state, page);
        Integer num = empService.selectAllNum(userName, role, room, b_state);
        if (list==null || list.size()==0){
            resp.getWriter().println(JSON.toJSONString(new ListPassDto("500","error or List is null")));
        }else {
            resp.getWriter().println(JSON.toJSONString(new ListPassDto("200","succeed",list,num)));
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

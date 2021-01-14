package com.yaollllllsan.web;

import com.yaollllllsan.dao.CupDAO;
import com.yaollllllsan.vo.ResultVO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class CupDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            new CupDAO().delCup(id);
            resp.getWriter().write(ResultVO.ok(1).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(ResultVO.err(2, e.getMessage()).toJSON());
        }
    }
}

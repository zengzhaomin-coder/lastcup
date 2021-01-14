package com.yaollllllsan.web;

import com.yaollllllsan.bean.Cup;
import com.yaollllllsan.dao.CupDAO;
import com.yaollllllsan.vo.ResultVO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class CupListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Cup> cups = new CupDAO().getAllCup();
            resp.getWriter().write(ResultVO.ok(cups).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(ResultVO.err(222, e.getMessage()).toJSON());
        }
    }
}

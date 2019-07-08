package com.servlet;

import com.domain.Location;
import com.service.PointService;
import com.service.impl.PointServiceImple;
import com.util.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "PointServlet")
public class PointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PointService ps = new PointServiceImple();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<Location> point = new ArrayList<Location>();
        point = ps.getPoint(request.getParameter("videoid"));
        String x = "";
        String y = "";
        String value = "";
        Map map = ps.countX(request.getParameter("videoid"));
        Map map1 =ps.countY(request.getParameter("videoid"));
        Value valu = new Value(map,map1);
        for(int i = 0;i<point.size();i++){
            x=x+point.get(i).getX()+",";
            y=y+point.get(i).getY()+",";
            value = value + valu.getValue(valu,point.get(i).getX(),point.get(i).getY())+",";
        }
        String re = "{\"X\":\""+x+"\",\"Y\":\""+y+"\",\"VALUE\":\""+value+"\"}";
        out.write(re);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

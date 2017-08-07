package com.db;


import com.db.awesomeapp.controllers.CounterPartyController;
import com.db.awesomeapp.models.CounterParty;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestConnection")
public class TestConnectionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        CounterPartyController cpc = new CounterPartyController();
        try {
            Connection conn = cpc.getConnection();
            if ( conn != null && conn.isValid(3)) {
                request.setAttribute("connectionStatus", "Connected <br/>");
                request.setAttribute("statusInfo", "Connection: " + conn.toString() + "<br/> Table is: " + conn.getCatalog());
            }
            else {
                request.setAttribute("connectionStatus", "Disconnected ");
                request.setAttribute("statusInfo", "Something has gone wrong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CounterParty cp = cpc.getEntityById("703");
        request.setAttribute("nameOfParty", cp.getName());
        request.setAttribute("date", cp.getRegisteredDate());
        
        getServletContext().getRequestDispatcher("/TestConnection.jsp").forward(request, resp);
    }
}

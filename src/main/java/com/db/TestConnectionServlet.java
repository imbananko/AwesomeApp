package com.db;


import com.db.awesomeapp.ConnectionHandler;

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
        ConnectionHandler connectionHandler = new ConnectionHandler();
        try {
            Connection conn = connectionHandler.getConnection();
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
        getServletContext().getRequestDispatcher("/TestConnection.jsp").forward(request, resp);
    }
}

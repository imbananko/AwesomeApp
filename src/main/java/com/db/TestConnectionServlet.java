package com.db;


import com.db.awesomeapp.dao.DaoFactory;
import com.db.awesomeapp.exceptions.PersistException;
import com.db.awesomeapp.mysql.MySqlDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TestConnection")
public class TestConnectionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        DaoFactory daoFactory = new MySqlDaoFactory();
        Connection connection = null;
        try {
            connection = (Connection) daoFactory.getContext();
        } catch (PersistException e) {
            e.printStackTrace();
        }

        try {
            if ( connection != null && connection.isValid(3)) {
                request.setAttribute("connectionStatus", "Connected <br/>");
                request.setAttribute("statusInfo", "Connection: " + connection.toString() + "<br/> Table is: " + connection.getCatalog());
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

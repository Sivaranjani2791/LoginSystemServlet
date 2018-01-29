package com.srccode.loginsystem;

import java.io.IOException;
import java.sql.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String passwrd = request.getParameter("pass");
		
		if(Validate.checkUser(email,passwrd))
		{
			RequestDispatcher rs =request.getRequestDispatcher("Welcome");
			rs.forward(request, response);
		}
		else
		{
			out.println("Username and Password are incorrect:");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request,response);
		}
		
	}

}

package com.acmebanking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
  name = "BankAccountServlet", 
  description = "Represents an ACME Bank Account and it's transactions", 
  urlPatterns = {"/account", "/bankAccount" })
@ServletSecurity(
  value = @HttpConstraint(rolesAllowed = {"Member"}),
  httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"Admin"})})
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private double accountBalance = 1000d;  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.accountBalance = accountBalance + 100d;
		 
        PrintWriter writer = response.getWriter();
        writer.println("<html> Balance of account is: $" + this.accountBalance  + "</html>");
        writer.flush();
	}
}

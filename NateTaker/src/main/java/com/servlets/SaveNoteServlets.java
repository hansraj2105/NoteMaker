package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Notes;
import com.helper.FactoryProvider;


public class SaveNoteServlets extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			
			String title=request.getParameter("title");
			String contant=request.getParameter("contant");
			
			Notes note=new Notes(title, contant, new Date());
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			out.println("<h2 style='text-align:center;'>Your Note Added Successfully</h2>");
			out.println("<center><a href='all_notes.jsp'>Click here to show all notes</a><br>");
			out.println("<a href='add_notes.jsp'>Click here to go back add more notes</a></center>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Notes;
import com.helper.FactoryProvider;

public class DeleteServlets extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		try {
			
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			
			Session s= FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			Notes note =(Notes)s.get(Notes.class, noteId);
			
			
			s.delete(note);
			tx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

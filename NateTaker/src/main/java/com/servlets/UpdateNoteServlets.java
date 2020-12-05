package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entites.Notes;
import com.helper.FactoryProvider;


public class UpdateNoteServlets extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		try {
			
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			String title=request.getParameter("title");
			String contant=request.getParameter("contant");
			Session s= FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			Notes note =(Notes)s.get(Notes.class, noteId);
			
			note.setTitle(title);
			note.setContant(contant);
			note.setAddedDate(new Date());
			
			tx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

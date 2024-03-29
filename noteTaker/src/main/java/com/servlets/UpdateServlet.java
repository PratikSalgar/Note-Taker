package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			try
			{
				int noteId = Integer.parseInt(request.getParameter("noteId").trim());
				String titel = request.getParameter("titel");
				String content = request.getParameter("content");
				
				Session s = FactoryProvider.getFactory().openSession();
				Transaction t = s.beginTransaction();
				Note note = s.get(Note.class, noteId);
				
				note.setTitle(titel);
				note.setContent(content);
				note.setAddedDate(new Date());
				
				t.commit();
				s.close();
					
				response.sendRedirect("all_notes.jsp");
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}

package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Note;
import com.helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int noteid = Integer.parseInt(request.getParameter("note_id").trim());
		
		Session s = FactoryProvider.getFactory().openSession();
		Transaction t = s.beginTransaction();
		Note note = s.get(Note.class, noteid);
		s.delete(note);
		response.sendRedirect("all_notes.jsp");
		
		t.commit();
		s.close();
	}

}

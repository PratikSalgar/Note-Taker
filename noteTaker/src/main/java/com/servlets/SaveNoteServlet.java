package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Note;
import com.helper.FactoryProvider;

@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try
		{
			String titel = req.getParameter("titel");
			String content = req.getParameter("content");
			
			 Note note = new Note(titel, content, new Date());
			 
			 Session s = FactoryProvider.getFactory().openSession();
			 Transaction t = s.beginTransaction();
			 s.save(note);
			 
			 t.commit();
			 s.close();
			 System.out.println("value submitted....");
			 res.setContentType("text/html");
			 PrintWriter out = res.getWriter();
			 out.print("<h1 style='text-align:center;'>Note added successfully....</h1>");
			 out.print("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</hq>");
			 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

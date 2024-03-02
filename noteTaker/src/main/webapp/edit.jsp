<%@page import="com.Entity.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Edit your note</h1>
		<br>
		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Note note = s.get(Note.class, noteId);
	
		%>

		<form action="UpdateServlet" method="post">
		
			<input name="noteId" value="<%=note.getId()%>" type="hidden">
		
			<div class="form-group">
				<label for="exampleInputEmail1">Note Titel</label> <input
					name="titel" required type="text" class="form-control" id="titel"
					aria-describedby="emailHelp" placeholder="Enter Here"
					value="<%=note.getTitle()%>" />

			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Note Content</label>
				<textarea name="content" required id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px"><%=note.getContent()%></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save your
					update</button>
			</div>

		</form>

	</div>
</body>
</html>
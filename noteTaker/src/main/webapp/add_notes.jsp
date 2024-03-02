<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please Enter your Note Details</h1>

		<!-- This is add form -->

		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Note Titel</label> <input
					name="titel"
					required type="text" class="form-control" id="titel"
					aria-describedby="noteHelp" placeholder="Enter Here"/>

			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Note Content</label> 
				<textarea 
				name="content"
				required id="content" placeholder="Enter your content here"
							class="form-control" style="height:300px"
				 ></textarea>
			</div>
			
			<div class="container text-center">
				<button type="submit" class="btn btn-primary" onclick="submitForm()">Add</button>
			</div>
			
		</form>
	</div>
</body>
</html>
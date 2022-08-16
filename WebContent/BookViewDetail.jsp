<%@include file="StudentNavbar.jsp" %>
<%@page import="com.librarymanagement.entity.BookEntity" %>

<%
	BookEntity book=(BookEntity)request.getAttribute("book");
%>

<%
	if(session.getAttribute("Id")!=null){
%>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<img src="img\\<%=book.getImage() %>"> 
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<h4><b>Book Name : </b><span style="color:red"><%=book.getBookName() %></span></h4>
				<br>
				<h4><b>Author Name : </b><span style="color:red"><%=book.getAuthorName() %></span></h4>
				<br>
				<h4><b>Book Edition : </b><span style="color:red"><%=book.getEdition() %></span></h4>
				<br>
				<h4><b>Book Description : </b><span style="color:red"><%=book.getDescription() %></span></h4>
				<br>
				<h4><b>Book Available : </b><span style="color:red"><%=book.getQuantity() %></span></h4>
				<br>
				<br>
				<a href="issuebook?bookId=<%=book.getId()%>" class="btn btn-primary">Issue Book</a>
			</div>
		</div>
	</div>
<%
	}else{
		response.sendRedirect("commonSignin.jsp");
	}
%>
<%@include file="StudentNavbar.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.model.Book" %>

<div class="container mt-5">
<%
	if(session.getAttribute("Id")!=null){
%>
	
	<%
		ArrayList<Book> books=(ArrayList<Book>)session.getAttribute("books");
		if(books.size()>0){
	%>
			<h1 class="text-center mb-4">Search Books</h1>
					<div class="row mt-5">
					<%
							for(int i=0;i<books.size();i++){
					%>
							
								<div class="col-md-3">
									<div class="card" style="width: 15rem;">
									  <img height="300" width="300" src="img\\<%=books.get(i).getImage()%>" class="card-img-top" >
									  <ul class="list-group list-group-flush">
									    <li class="list-group-item" style="over-flow:hidden">Name : <%=books.get(i).getBookName()%></li>
									  </ul>
									  <div class="card-body">
									    <a href="issuebook?bookId=<%=books.get(i).getId() %>" class="card-link">Issue Book</a>
									    <a href="viewdetails?bookId=<%=books.get(i).getId()%>" class="card-link">View Detail</a>
									  </div>
									</div> 
							</div> 
						
					<%
							}
							session.removeAttribute("books");
					%>
						</div>
				</div>
				
	<%
		}else{
	%>
				<h1 class="text-center mb-4">No Books Available....</h1>
	<%
		}
	%>
<%
	}else
		response.sendRedirect("commonSignin.jsp");
%>
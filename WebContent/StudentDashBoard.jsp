<%@include file="StudentNavbar.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.librarymanagement.entity.BookEntity" %>

<%
	if(request.getAttribute("succMsg")!=null){
%>
	<input type="hidden" id="msg" value="<%=request.getAttribute("succMsg")%>">
	<script type="text/javascript">
		var m=document.getElementById("msg"); 
		alert(m.defaultValue)
	</script>
<%
	}
%>

<%
	if(request.getAttribute("failMsg")!=null){
%>
	<input type="hidden" id="msg" value="<%=request.getAttribute("failMsg")%>">
	<script type="text/javascript">
	var m=document.getElementById("msg"); 
	alert(m.defaultValue)
	</script>
<%
	}
%>

<%
	if(session.getAttribute("Id")!=null){
%>
	<div class="container mt-5 frontpage">
	<h1 class="text-center mb-4">All Books		</h1>
		<div class="row mt-5">
		<%
			ArrayList<BookEntity> books=(ArrayList<BookEntity>)session.getAttribute("books");
				for(int i=0;i<books.size();i++){
		%>
				
					<div class="col-md-3 mt-4">
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
	}else
	response.sendRedirect("commonSignin.jsp");
%>
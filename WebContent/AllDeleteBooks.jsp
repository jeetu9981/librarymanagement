<%@include file="AdminNavbar.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.model.Book" %>
<%
	ArrayList<Book> books=(ArrayList<Book>)session.getAttribute("books");
%>

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

	<h1 class="text-center mt-5">All Delete Books</h1>
	<div class="container mt-5" style="background-color:white">
		<div class="row">
		
			<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">S.No</th>
	      <th scope="col">Book Name</th>
	      <th scope="col">Author Name</th>
	      <th scope="col">Quantity</th>
	      <th scope="col">Description</th>
	      <th scope="col">Image</th>
	      <th scope="col">Renew</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  	for(int i=0;i<books.size();i++){
	  %>
	    <tr class="mt-4">
	      <td><%=i+1 %></td>
	      <td><%=books.get(i).getBookName() %></td>
	      <td><%=books.get(i).getAuthorName()%></td>
	      <td><%=books.get(i).getQuantity()%></td>
	      <td><%=books.get(i).getDescription()%></td>
	      <td><img height="100" width="100" src="img\\<%=books.get(i).getImage()%>"></td>
	      <td><a class="btn btn-warning" href="RenewBook.jsp?id=<%=books.get(i).getId()%>">Renew</a></td>
	    </tr>
	   <%
	  	}
	  	session.removeAttribute("books");
	   %>
	  </tbody>
	</table>
		</div>
	</div>
<%
	}else{
		response.sendRedirect("commonSignin.jsp");
	}
%>
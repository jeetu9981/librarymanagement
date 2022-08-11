<%@include file="StudentNavbar.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.model.ExpireIssuseBooks" %>
<%
	ArrayList<ExpireIssuseBooks> books=(ArrayList<ExpireIssuseBooks>)request.getAttribute("expires");
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
	<h1 class="text-center mt-5">All Issue Expire Books</h1>
	<div class="container mt-5" style="background-color:white">
		<div class="row">
		
			<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">S.No</th>
	      <th scope="col">Student Name</th>
	      <th scope="col">Book Name</th>
	      <th scope="col">Return Date</th>
	      <th scope="col">Charges</th>
	      <th scope="col">Image</th>
	      <th scope="col">Return Book</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  	for(int i=0;i<books.size();i++){
	  %>
	    <tr class="mt-4">
	      <td><%=i+1 %></td>
	      <td><%=books.get(i).getStudentName() %></td>
	      <td><%=books.get(i).getBookName()%></td>
	      <td><%=books.get(i).getReturnDate()%></td>
	      <td><%=books.get(i).getCharges()%></td>
	      <td><img height="100" width="100" src="img\\<%=books.get(i).getImage()%>"></td>
	      <td><a class="btn btn-warning" href="returnbook?bookId=<%=books.get(i).getBookId()%>&charges=<%=books.get(i).getCharges()%>">Return</a></td>
	    </tr>
	   <%
	  	}
	  	request.removeAttribute("expires");
	   %>
	  </tbody>
	</table>
		</div>
	</div>
<%
	}else
		response.sendRedirect("commonSignin.jsp");
%>
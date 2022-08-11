<%@include file="AdminNavbar.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.model.Student" %>
<%
	ArrayList<Student> students=(ArrayList<Student>)request.getAttribute("students");
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

	<h1 class="text-center mt-5">All User</h1>
	<div class="container mt-5" style="background-color:white">
		<div class="row">
		
			<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">S.No</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  	for(int i=0;i<students.size();i++){
	  %>
	    <tr class="mt-4">
	      <td><%=i+1 %></td>
	      <td><%=students.get(i).getName() %></td>
	      <td><%=students.get(i).getEmail()%></td>
	    </tr>
	   <%
	  	}
	  	session.removeAttribute("books");
	   %>
	  </tbody>
	</table>
		</div>
	</div>
	<div class="container mt-5">
	<a href="dashboard" class="btn btn-primary">Back</a>
	</div>
<%
	}else{
		response.sendRedirect("commonSignin.jsp");
	}
%>
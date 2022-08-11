<%@include file="AdminNavbar.jsp" %>

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
	if((request.getAttribute("failMsg")!=null)){
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
	
	<div class="container mt-5">
		<div class="row">
			<h1 class="text-center">Edit Form</h1>
			<div class="col-md-4 mt-5"></div>
			<div class="col-md-4 mt-3" style="background-color:white;padding:25px;border-radius:15px">
				<form action="edit" method="get">
				<input type="hidden" value="<%=request.getParameter("id")%>" name="id">
				  <div class="mb-3">
				    <label for="exampleInputEmail1" class="form-label">Description</label>
				    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="description">
				  </div>
				  <button type="submit" class="btn btn-primary text-center mt-4">Submit</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
<%
	}else{
		response.sendRedirect("commonSignin.jsp");
	}
%>
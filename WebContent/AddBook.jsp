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

	<div class="container mt-5">
		<div class="row">
			<h1 class="text-center">Add Book</h1>
			<div class="col-md-4 mt-5"></div>
			<div class="col-md-4 mt-3" style="background-color:white;padding:25px;border-radius:15px">
				<form action="addbook" method="post" enctype = "multipart/form-data">
				  <div class="mb-3">
				    <label for="exampleInputEmail1" class="form-label">Book Name</label>
				    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name">
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Author</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" name="authorName">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Edition</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" name="edition">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Description</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" name="description">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Image</label>
				    <input type="file" class="form-control" id="exampleInputPassword1" name="image">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Quantity</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="quantity">
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


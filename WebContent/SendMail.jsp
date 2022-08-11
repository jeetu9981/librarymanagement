<%@include file="AdminNavbar.jsp" %>


<%
	if(session.getAttribute("Id")!=null){
%>
	<div class="container mt-5">
		<div class="row">
			<h1 class="text-center">Add Book</h1>
			<div class="col-md-4 mt-5"></div>
			<div class="col-md-4 mt-3" style="background-color:white;padding:25px;border-radius:15px">
				<form action=sendmail method="post" >  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Student Email</label>
				    <input dissabled type="email" class="form-control" id="exampleInputPassword1" name="email" value="<%=request.getParameter("email")%>">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Add Subject</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" name="subject">
				  </div>
				  
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Add Message</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" name="msg">
				  </div>
				  
				  <button type="submit" class="btn btn-primary text-center mt-4">Submit</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
<%
	}else
		response.sendRedirect("commonSignin.jsp");
%>
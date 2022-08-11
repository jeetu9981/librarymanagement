<%@include file="CommonNavbar.jsp" %>

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

<div class="container mt-5">
	<div class="row">
		<h1 class="text-center">Signin Form</h1>
		<div class="col-md-4 mt-5"></div>
		<div class="col-md-4 mt-3" style="background-color:white;padding:25px;border-radius:15px">
			<form action="signin" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">MemberShip Number</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" name="memership">
			  </div>
			  <div class="form-check">
				  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault1" value="admin">
				  <label class="form-check-label" for="flexRadioDefault1">
				    Admin
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="role" id="flexRadioDefault2" value="student" checked>
				  <label class="form-check-label" for="flexRadioDefault2">
				    Student
				  </label>
				</div>
			  <button type="submit" class="btn btn-primary text-center mt-4">Submit</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>

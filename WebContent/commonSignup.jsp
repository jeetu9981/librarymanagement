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
		<h1 class="text-center">Signup Form</h1>
		<div class="col-md-4 mt-5"></div>
		<div class="col-md-4 mt-3" style="background-color:white;padding:25px;border-radius:15px">
			<form novalidate onsubmit="return validate()" action="signup" method="post">
			<div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Name</label>
			    <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
			    <small id="nameField" style="color:red"></small>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email</label>
			    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
			    <small id="emailField" style="color:red"></small>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="password" class="form-control" id="password" name="password">
			    <small id="passwordField" style="color:red"></small>
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
				  <br>
				</div>
			  <button type="submit" class="btn btn-primary text-center mt-4">Submit</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>

<script>

	function validate(){
		var flag=false;
		var exp=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

		let name=$("#name").val();
		if(name=="" || name==undefined){
			$("#nameField").html("Please enter valid name...");
			flag=false;
		}else{
			$("#nameField").html("");
			flag=true;
		}
		
		let email=$("#email").val();
		if(email=="" || email==undefined){
			$("#emailField").html("Please enter valid email...");
			flag=false;
		}else if(exp.test(email)==false){
			$("#emailField").html("Email Invalid ,email must contain(@ or .) example(example@gmail.com)");
			flag=false;
		}
		else{
			$("#emailField").html("");
			flag=true;
		}
		
		let password=$("#password").val();
		if(password=="" || password==undefined){
			$("#passwordField").html("Please enter valid password...");
			flag=false;
		}
		else{
			$("#passwordField").html("");
			flag=true;
		}
		return flag;
	}

	
</script>

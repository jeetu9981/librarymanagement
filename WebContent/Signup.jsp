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
			<form novalidate onsubmit="return validate()" action="adminsignup" method="post">
			<input type="hidden" value="<%=request.getAttribute("email")%>" name="email">
			<div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Address</label>
			    <input type="text" class="form-control" id="address" aria-describedby="emailHelp" name="address">
			    <small id="addressField" style="color:red"></small>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Library name</label>
			    <input type="TEXT" class="form-control" id="name" aria-describedby="emailHelp" name="libraryName">
			    <small id="nameField" style="color:red"></small>
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
		let address=$("#address").val();
		if(address=="" || address==undefined){
			$("#addressField").html("Please enter address...");
			flag=false;
		}else{
			$("#addressField").html("");
			flag=true;
		}
		
		let name=$("#name").val();
		if(name=="" || name==undefined){
			$("#nameField").html("Please enter Library Name...");
			flag=false;
		}
		else{
			$("#nameField").html("");
			flag=true;
		}
		
		return flag;
	}
</script>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
</head>
<body style="background-color:	#F5F5F5">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="studentdashboard">Student</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       <form class="d-flex" >
        <input class="form-control me-2 search" type="search" placeholder="Search Books" aria-label="Search" name="search">
      </form>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Books
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="studentissuebooks">Issue Books</a></li>
            <li><a class="dropdown-item" href="studentexpireIssuebook">Expire Issue Books</a></li>
            <li><hr class="dropdown-divider"></li>
          </ul>
        </li>
      </ul>
      <a href="logout" class="btn btn-primary mx-4">Logout</a>
      <button class="btn btn-warning">Welcome : <%=session.getAttribute("Name") %></button>
    </div>
  </div>
</nav>
</body>

<div id="fix"></div>
<script>
$(".search").keyup(()=>{
	let s=$(".search").val();
	$.ajax({
		url: 'studentsearchbook?search='+s,  
		type: 'GET',  
		  success: function(data) {  
			  console.log(data)
			  $(".frontpage").html("");
			  $("#fix").html(data);
		  }  
	});
});
</script>














</html>
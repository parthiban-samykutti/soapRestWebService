<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
		    $("#update").click(function(){
			    console.log('updating.....');
			    var values = {};
		    	$.each($('#updateForm').serializeArray(), function(i, field) {
		    	    values[field.name] = field.value;
		    	});
		    	console.log('update form values:'+values);
		        $.ajax(
					{
						url:'${pageContext.request.contextPath}/webresources/account/updateAccount',
						data:values,
						type:'PUT',
						contentType:'text/html',
						dataType:"JSON",
						success:function(result,status,xhr){console.log('Account is updated successfully');$('#responseArea').text(result);},
						error:function(xhr,status,error){console.log('error in update:'+status);console.log('error: '+error);}
					}
				        );
		    });
		    $("#delete").click(function(){
		    	console.log('deleting.....');
			    var values = {};
		    	$.each($('#deleteForm').serializeArray(), function(i, field) {
		    	    values[field.name] = field.value;
		    	});
		    	console.log('delete form values:'+values);
		        $.ajax(
					{
						url:'${pageContext.request.contextPath}/webresources/account/deleteAccount',
						data:values,
						type:'DELETE',
						contentType:'text/html',
						dataType:"TEXT",
						success:function(result,status,xhr){console.log('Account is deleted successfully');$('#responseArea').text(result);},
						error:function(xhr,status,error){console.log('error in delete: '+status);console.log('error: '+error);}
					}
				        );
		    });
		});
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/webresources/account/saveAccount" method="post" name="save">
		Enter Name: <input type="text" name="name"/>
		Enter Type: <select name="type">
			<option value="Checking">Checking</option>
			<option value="Savings">Savings</option>
			<option value="Deposit">Deposit</option>
		</select>
		<input type="submit" name="save" value="Save"/>
	</form>
	<form action="${pageContext.request.contextPath}/webresources/account/updateAccount" name="update" id="updateForm">
		Enter Name: <input type="text" name="name"/>
		Enter Number: <input type="text" name="number"/>
		Enter Type: <select name="type">
			<option value="Checking">Checking</option>
			<option value="Savings">Savings</option>
			<option value="Deposit">Deposit</option>
		</select>
		<input type="button" name="update" value="Update" id="update"/>
	</form>
	<form action="${pageContext.request.contextPath}/webresources/account/deleteAccount" name="delete" id="deleteForm">
		Enter Account Number: <input type="text" name="number"/>
		<input type="button" name="delete" value="Delete" id="delete"/>
	</form>
	<textarea rows="5" cols="200" id="responseArea"></textarea>
</body>
</html>
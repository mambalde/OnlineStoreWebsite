
function validateFormInput(){
	var emailField = document.getElementById("email");
	var nameField = document.getElementById("fullname");
	var passwordField= document.getElementById("password");
	if(emailField.value.length==0){
		alert("email cannot be empty");
		emailField.focus();
		return false;

	}
	if(nameField.value.length==0){
		alert("name cannot be empty");
		nameField.focus();
		return false;
	}
	if(passwordField.value.length==0){
		alert("password cannot be empty");
		passwordField.focus();
		return false;
	}
	return true;

}

function confirmDelete(userId){
	if(confirm("Are you Sure you want to delete the User with id "+userId+ "?")){
		window.location = 'delete_user?id='+userId;
	}
}

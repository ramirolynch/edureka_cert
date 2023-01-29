/**
 * 
 */

 var xhr;

function getUserDetails()
{
	xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = stateChanged;
	
	var uno = document.getElementById("id").value;
	
	xhr.open("GET", "search?uno="+uno, true); //true-asynchronous communication
	
	xhr.send();
}

function stateChanged()
{
	var uno = 'NO MATCH';
	
	if(xhr.readyState==4 && xhr.status==200){
		var responseText = xhr.responseText;
		
		if(responseText.length > 0){
			var responseObj = JSON.parse(responseText);
			
			uno = responseObj.uno;
		}
		document.getElementById('user-id').innerHTML = "Welcome User " + uno;
	}
}
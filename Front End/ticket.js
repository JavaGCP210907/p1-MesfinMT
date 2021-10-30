const url = "http://localhost:8040/" 
document.getElementById("login-row").style.visibility = "visible";
document.getElementById("loginButton").addEventListener("click", loginFunc);
document.getElementById("getTicketButton").addEventListener("click", listFunc);
document.getElementById("getAllTicketButton").addEventListener("click", listAllFunc);
document.getElementById("approveTicketButton").addEventListener("click", approveFunc);
document.getElementById("approveButton").addEventListener("click", approvalFunc);
document.getElementById("addTicketButton").addEventListener("click", addFunc);
document.getElementById("submitButton").addEventListener("click", submitFunc);
document.getElementById("logoutButton").addEventListener("click", logoutFunc);

async function loginFunc(){
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;
    let user = {username:usern,password:userp};
    let response = await fetch(url + "login", {method: "POST",body: JSON.stringify(user),credentials: "include"});

   if(response.status === 200){
    let role = await fetch(url + "role", {method: "POST",body: JSON.stringify(user),credentials: "include"});
    let rolem= await role.json(); 
    let usr = await fetch(url + "usr", {method: "POST",body: JSON.stringify(user),credentials: "include"});
    let usrID = await usr.json(); 
console.log(usrID.id);
    window.localStorage.setItem('use', JSON.stringify(usrID.id));
 
if (rolem === "Manager") {
            document.getElementById("login-row").style.visibility = "hidden";
            document.getElementById("logoutButton").style.display = "block";
            document.getElementById("approveget-row").style.display = "block";
}else {
    document.getElementById("login-row").style.display = "none";
    document.getElementById("logoutButton").style.display = "block";
    document.getElementById("addget-row").style.display = "block";
}
    } else {
      document.getElementById("login-row").innerText="Login failed! Do better.";
    }
}

async function listFunc() { 
 document.getElementById('ticketBody').innerHTML = '';
 document.getElementById("table-row").style.display = "block";
    let userId = window.localStorage.getItem('use');
    let response = await fetch(url + "ticket/" + userId, {credentials: "include"});
    if(response.status === 200) { 
        let data = await response.json(); 
       for(let ticket of data){
            console.log(ticket.author.username)
            let row = document.createElement("tr"); 

            let cell = document.createElement("td"); 
            cell.innerHTML = ticket.id; 
            row.appendChild(cell); 
            let cell2 = document.createElement("td"); 
            cell2.innerHTML = ticket.amount; 
            row.appendChild(cell2);

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = ticket.author.first_name; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = ticket.description; 
            row.appendChild(cell4);

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = ticket.resolved; 
            row.appendChild(cell6);

            let cell8 = document.createElement("td"); 
            cell8.innerHTML = ticket.status.Status; 
            row.appendChild(cell8);
            let cell9 = document.createElement("td"); 
            cell9.innerHTML = ticket.submitted; 
            row.appendChild(cell9);
            let cell10 = document.createElement("td"); 
            cell10.innerHTML = ticket.type.type; 
            row.appendChild(cell10);

            document.getElementById("ticketBody").appendChild(row);
        }
    }
}

async function listAllFunc() { 
    document.getElementById('ticketBody').innerHTML = '';
    document.getElementById("table-row").style.display = "block";
      let userId = window.localStorage.getItem('use');
      let response = await fetch(url + "ticket", {credentials: "include"});
      if(response.status === 200) { 
          let data = await response.json(); 
         for(let ticket of data){
              console.log(ticket.author.username)
              let row = document.createElement("tr"); 
  
              let cell = document.createElement("td"); 
              cell.innerHTML = ticket.id; 
              row.appendChild(cell); 
              let cell2 = document.createElement("td"); 
              cell2.innerHTML = ticket.amount; 
              row.appendChild(cell2);
  
              let cell3 = document.createElement("td"); 
              cell3.innerHTML = ticket.author.first_name; 
              row.appendChild(cell3);
  
              let cell4 = document.createElement("td"); 
              cell4.innerHTML = ticket.description; 
              row.appendChild(cell4);
  
              let cell6 = document.createElement("td"); 
              cell6.innerHTML = ticket.resolved; 
              row.appendChild(cell6);
  
              let cell8 = document.createElement("td"); 
              cell8.innerHTML = ticket.status.Status; 
              row.appendChild(cell8);
              let cell9 = document.createElement("td"); 
              cell9.innerHTML = ticket.submitted; 
              row.appendChild(cell9);
              let cell10 = document.createElement("td"); 
              cell10.innerHTML = ticket.type.type; 
              row.appendChild(cell10);
  
              document.getElementById("ticketBody").appendChild(row);
  
          }
  
      }
  
  }
async function submitFunc() { 
    let amount = document.getElementById("amount").value;
	let description = document.getElementById("description").value;
    let type = document.getElementById("type").value;
    window.localStorage.setItem('typp', type);	
	let request = {
		amount: amount,
		description: description,
		type: window.localStorage.getItem('typp', type),
        userid:window.localStorage.getItem('use')
	};
	
	let response = await fetch(url + "addticket", {method: "POST",body: JSON.stringify(request),credentials: "include"});
	
	if(response.status === 200) {
}
}

async function approvalFunc() { 
    let ticket_id = document.getElementById("ticketId").value;
    let status = document.getElementById("status").value;
    window.localStorage.setItem('sts', status);	
	let request = {ticket_id: ticket_id,status: window.localStorage.getItem('sts', status),userid:window.localStorage.getItem('use')};
	
	let response = await fetch(url + "approveticket", {method: "POST",body: JSON.stringify(request),credentials: "include"});
	
	if(response.status === 200) {
}
}

function addFunc() { 
    document.getElementById('ticketBody').innerHTML = '';
    document.getElementById("table-row").style.visibility = "hidden";
    document.getElementById("addTicket").style.display = "block";

   
}
function approveFunc() { 
    document.getElementById('ticketBody').innerHTML = '';
    document.getElementById("table-row").style.visibility = "hidden";
    document.getElementById("approveTicket").style.display = "block";

   
}


async function logoutFunc() {
	let response = await fetch(url + "logout", {credentials:"include"});
	if(response.status === 200) {
        document.getElementById("login-row").style.visibility = "visible";
        document.getElementById("username").value = "";
    	document.getElementById("password").value = "";
        document.getElementById("addget-row").style.visibility = "hidden";
		document.getElementById("logoutButton").style.visibility = "hidden";
        document.getElementById("ticketBody").style.visibility = "hidden";
        document.getElementById("approveget-row").style.visibility = "hidden";     
        document.getElementById("table-row").style.visibility = "hidden";
        document.getElementById("addTicket").style.visibility = "hidden";
		document.getElementById("login-row").style.display = "block";
  
	}
}

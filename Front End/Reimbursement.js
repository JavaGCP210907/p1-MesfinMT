const url = "http://localhost:8040/" //putting our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch requests and make calls to the server by appending endpoints

//add functionality to our buttons using a eventlisteners
//so when these buttons gets clicked, the appropriate function will be called
document.getElementById("getAvengerButton").addEventListener("click", assembleFunc);
document.getElementById("loginButton").addEventListener("click", loginFunc);


async function assembleFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //we need to include {credentials: "include"} in order to make use of the user's cookie
    let response = await fetch(url + "ticket", {credentials: "include"});
  //    let response = await fetch(url + "ticket");

    console.log(response);

    if(response.status === 200) { //if the request comes back successful...

        let data = await response.json(); //get the JSON data, turn it into a JS object

        //For every Avenger object we get back, put it in the table
        for(let tickets of data){

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = tickets.ticket_id; //fill the cell with the appropriate avenger data
            row.appendChild(cell); //add the td element (cell) to the tr element (row)

            //then we do this ^ for every field in the avenger model
            let cell2 = document.createElement("td"); 
            cell2.innerHTML = tickets.amount; 
            row.appendChild(cell2);

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = tickets.author; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = tickets.description; 
            row.appendChild(cell4);

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = tickets.receipt; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = tickets.resolved; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            cell7.innerHTML = tickets.resolver; 
            row.appendChild(cell7);
            let cell8 = document.createElement("td"); 
            cell8.innerHTML = tickets.status; 
            row.appendChild(cell8);
            let cell9 = document.createElement("td"); 
            cell9.innerHTML = tickets.submitted; 
            row.appendChild(cell9);
            let cell10 = document.createElement("td"); 
            cell10.innerHTML = tickets.type; 
            row.appendChild(cell10);

            //the tr called row that we created in the for loop gets appended to the table body
            //a new row will be appended for ever Avenger object that comes in
            document.getElementById("avengerBody").appendChild(row);

        }

    }

}

//login functionality below-----------------

//this function will send the user-inputted login credentials to our server
async function loginFunc(){

    //gather the user input from the login inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need to make a JS object to send
    let user = {
        username:usern,
        password:userp
    }

    console.log(user)

    //Now I'm going to set up my fetch request to the server
    //Remember the second parameter fetch() can take?
    //It's essentially a configuration object! the settings of our fetch request
    //if you don't include it, it'll send a GET request by default
    let response = await fetch(url + "login", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), //turn our Javascript into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //useful for debug :)

    //control flow based on success or failed login
    if(response.status === 200){
        //wipe our login row and welcome the user
        document.getElementById("login-row").innerText="Welcome!";
    } else {
        document.getElementById("login-row").innerText="Login failed! Do better."
    }

}


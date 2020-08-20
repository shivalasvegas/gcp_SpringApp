
    async function getAdminData(form){

        let formData = new FormData(form);

        const url = `http://localhost:8003/checkadmindetails/${formData.get("adminEmail")}/${formData.get("adminPassword")}`;
        
        fetch(url)
        .then(
            function(response) { 
        if (response.status !== 200) {
            console.log('Looks like there was a problem. Status Code: ' +
            response.status);
            return;
        }
      response.json().then(function(data) {
        console.log(data);
        if (data){
            alert ("Login successful");  
            window.location.replace("adminportal.html");
        }
        else{
            alert("Please enter a valid username and password.");
        }
        });
        }
        )
    .catch(function(err) {
        console.log('Fetch Error :-S', err);
    });

        

    }


    



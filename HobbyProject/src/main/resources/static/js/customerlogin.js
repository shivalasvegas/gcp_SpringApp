
    async function getCustomerData(form){

        let formData = new FormData(form);

        const url = `http://localhost:8003/checkcustomerdetails/${formData.get("customerEmail")}/${formData.get("customerPassword")}`;
        console.log(url);
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
            window.location.replace("exclusive.html");
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


    



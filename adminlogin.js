
    async function getAdminData(form){
        
        let formData = new FormData(form);

        const url = `http://35.234.148.111//checkadmindetails/${formData.get("adminEmail")}/${formData.get("adminPassword")}`;
        console.log(url);
        const response = await fetch(url);
        const data = await response.json();
        console.log(data.results);

        if (data){
            alert ("Login successful");  
            window.location.replace("adminportal.html");
        }
        else{
            alert("Please enter a valid username and password.");
        }
    }
    




function readAllCustomers(){
fetch('http://localhost:8003/readallcustomers')
  .then(
    
    function(response) { 
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }
      response.json().then(function(data) {
        console.log(data);
        drawTable(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

  function drawTable(jsondata){
    let mountains = jsondata;
      
      function generateTableHead(table, data) {
        let thead = table.createTHead();
        let row = thead.insertRow();
        for (let key of data) {
          let th = document.createElement("th");
          let text = document.createTextNode(key);
          th.appendChild(text);
          row.appendChild(th);
        }
        
        let hDelete = document.createElement("th");
        let titleD = document.createTextNode("Delete");
        hDelete.appendChild(titleD);
        row.appendChild(hDelete);
      }
          function generateTable(table, data) {
            for (let element of data) {
              let row = table.insertRow();
              
              for (key in element) {
          
                let cell = row.insertCell();
                cell.setAttribute('contentEditable', 'true');
                let text = document.createTextNode(element[key]);
                cell.appendChild(text);
              }

              function deleteCustomer(){
                let url = `http://localhost:8003/deletecustomer/${element.customerId}`;
                let heads = new Headers();
                heads.append('Content-type', 'application/json');
                let req = new Request(url, {
                  headers:heads,
                  method:'DELETE'
                });
                fetch(req) // fetch request recieved and carried out there is no response json object as it has been deleted.
                .then((res)=>res.json())
                .catch(err=>console.log(err));
              }

              // function updateCustomer(event){
              //   let myForm = event.target;
              //   let formData = new FormData(myForm);

              //   for (let key of formData.keys()) {
              //     console.log(key, formData.get(key));
              //   }

              //   let url = `http://localhost:8003/updatecustomer/${element.customerId}`;
              //   let heads = new Headers();
              //   heads.append('Content-type', 'application/json');
              //   let req = new Request(url, {
              //     headers:heads,
              //     body:JSON.stringify(formData),
              //     method:'PUT'
              //   });

              //   fetch(req) // fetch request recieved and carried out => there is no response json object as it has been deleted.
              //   .then((res)=>res.json())
              //   .catch(err=>console.log(err));
              // }

              // let operation =row.insertCell();
              // let bUpdate = document.createElement("button");
              // bUpdate.id = "update" + element.customerId;
              // bUpdate.setAttribute("class", "btn btn-sm btn-secondary");
              // bUpdate.addEventListener("click", updateCustomer);
              // bUpdate.innerHTML = "update";
         
              // operation.appendChild(bUpdate);

              let operation1 =row.insertCell();
              let bDelete = document.createElement("button");
              bDelete.id ="delete" + element.customerId;
              bDelete.setAttribute("class", "btn btn-sm btn-secondary");
              bDelete.addEventListener("click", deleteCustomer);
              bDelete.innerHTML = "Delete";
              operation1.appendChild(bDelete);
            }
          
          }
         
          let table = document.querySelector("table");
          table.innerHTML="";
          
          let data = Object.keys(mountains[0]);
          generateTableHead(table, data);
          generateTable(table, mountains);
        }
    



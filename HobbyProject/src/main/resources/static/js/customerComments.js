
    document.getElementById('formCustomerComments').addEventListener('submit', handleForm);
  function handleForm(event) {
    event.preventDefault(); 
    
    let myForm = event.target;
    let formData = new FormData(myForm);

    for (let key of formData.keys()) {
      console.log(key, formData.get(key));
    }
    let json = convertFD2JSON(formData);

    //send the request with the formdata
    let url = 'http://localhost:8003/createcustomer';
    let heads = new Headers();
    heads.append('Content-type', 'application/json');

    let req = new Request(url, {
      headers: heads,
      body: json,
      method: 'POST',
    });
    //console.log(req);
    fetch(req)
      .then((res) => res.json())
      .then((data) => {
        console.log('Response from server');
        console.log(data);
      })
      .catch(console.warn);
  }

  function convertFD2JSON(formData) {
    let obj = {};
    for (let key of formData.keys()) {
      obj[key] = formData.get(key);
    }
    console.log(JSON.stringify(obj));
    return JSON.stringify(obj);
  }
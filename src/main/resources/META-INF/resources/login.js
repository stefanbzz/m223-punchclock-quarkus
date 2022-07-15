const URL = 'http://localhost:8080';


let resp = {};
let bearer_token ="";
const login = (e) => {
    
    fetch(`${URL}/user/${action}`, {
        method: 'POST'
        ,headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(e)
    }).then(function(response) {
        if(action = 'login'){
            if(response.status != 200) {
            }else {
                response.text().then((token) => {
                    localStorage.setItem("token", token);
                    console.log("token");
                    location.href = `${URL}/index.html`
                })
            }
        }
        else{
            location.href = `${URL}/login.html`
        }
        
    });
};


document.addEventListener('DOMContentLoaded', function(){
    const loginForm = document.querySelector('#loginForm');
    loginForm.addEventListener('submit', createUser);
});
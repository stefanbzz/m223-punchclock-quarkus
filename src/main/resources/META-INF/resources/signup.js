const URL = 'http://localhost:8080';
let resp = {};
let bearer_token ="";
const createUser = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] = formData.get('username');
    user['password'] = formData.get('password');

    fetch(`${URL}/users/signup`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)

    });
    console.log(user);
};


document.addEventListener('DOMContentLoaded', function(){
    const entryForm = document.querySelector('#entryForm');
    entryForm.addEventListener('submit', createUser);
});
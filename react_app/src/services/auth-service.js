import axios from 'axios';

const Authenticate_URL = "http://localhost:8661/users/authenticate";
const Register_URL = "http://localhost:8661/users/register"

class AuthService{
    login(username, password) {
        return axios
            .post(Authenticate_URL, {
                username,
                password
            })
            .then(response => {
                if(response.data){
                    console.log(response.data);
                    localStorage.setItem("user", JSON.stringify(response.data.user));
                    localStorage.setItem("jwt", JSON.stringify(response.data.jwt))
                }
                console.log(localStorage.user);
                return response.data;                
            });
    }

    logout(){
        localStorage.removeItem("user");
        localStorage.removeItem("jwt");
    }

    register(username, firstName, lastName, email, password){
        return axios.post(Register_URL, {
            username,
            firstName,
            lastName,
            email,
            password
        });
    }

    getCurrentUser(){
        return JSON.parse(localStorage.getItem('user'));
    }

    getCurrentJWT(){
        return JSON.parse(localStorage.getItem('jwt'));
    }
}

export default new AuthService()
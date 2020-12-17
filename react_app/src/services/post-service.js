import axios from 'axios';

const POST_URL = "http://localhost:8661/forum/posts";

class PostService{

    listPosts() {
        return axios
            .get(POST_URL)
                .then(response => {
                    console.log(response.data);
                    return response.data;
                }
            );
    }
    

    login(username, password) {
        return axios
            .post(Authenticate_URL, {
                username,
                password
            })
            .then(response => {
                if(response.data){
                    console.log(response.data);
                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response.data;
                
            });
    }

    logout(){
        localStorage.removeItem("user");
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
}

export default new AuthService()
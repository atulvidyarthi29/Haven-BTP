export default function authHeader(){
    const user = JSON.parse(localStorage.getItem('jwt'));
    console.log(user);
    if(user){
        return {Authorization: 'Bearer ' + user};
    }
    else{
        return{};
    }
}
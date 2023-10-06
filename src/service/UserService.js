import axios from 'axios';

const USER_REST_API_URL="http://localhost:8080/api/user/";

class UserService{

    getAllUser(){
        return axios.get(USER_REST_API_URL);
    }

    createUser(user){
        return axios.post(USER_REST_API_URL + "createUser",user)
    }

}
export default new UserService();
import axios from "axios";

export default{
    getAllUsers(){
        return axios.get('/users');
    }

    
}
import axios from "axios";
const currentToken = localStorage.getItem('token')
const apiClient = axios.create({
  baseURL: "http://localhost:9000",
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${currentToken}`
  }
});
const http = axios.create({
    baseURL: "http://localhost:9000"
});



export default{
    getAllUsers(){
        return apiClient.get('/users');
    }, 
    getUserById(name){
        return apiClient.get(`/users/${name}`);
    },
    getLeaderBoard(){
        return http.get(`/users/leaders`);
    }

    
}
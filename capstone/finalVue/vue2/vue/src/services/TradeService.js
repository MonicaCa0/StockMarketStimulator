import axios from 'axios';


const currentToken = localStorage.getItem('token')
const apiClient = axios.create({
  baseURL: "http://localhost:9000",
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${currentToken}`
    `Access-Control-Allow-Origin`=`*`
  }
});

export default{

    buyStock(id, gameID){
        return apiClient.post(`/trades/${id}/buy/${gameID}`);
    },

    sellStock(id, gameID){
        return apiClient.post(`/trades/${id}/sell/${gameID}`);
    },

    getAllTrades(id, gameID){
        return apiClient.get(`/trades/${id}/allTrades/${gameID}`);
    }
}
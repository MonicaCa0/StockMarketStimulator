import axios from 'axios';


const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{

    buyStock(id, gameID){
        return http.post(`/trades/${id}/buy/${gameID}`);
    },

    sellStock(id, gameID){
        return http.post(`/trades/${id}/sell/${gameID}`);
    },

    getAllTrades(id, gameID){
        return http.get(`/trades/${id}/allTrades/${gameID}`);
    }
}
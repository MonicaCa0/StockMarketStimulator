import axios from 'axios';


const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{
    getAllPortfolios(id){
        return http.get(`/portfolios/${id}`)
    },

    getPortfolioBalance(id, accountID){
        alert(`/portfolios/${id}/balance/${accountID}`)
        return http.get(`/portfolios/${id}/balance/${accountID}`)
    }
}
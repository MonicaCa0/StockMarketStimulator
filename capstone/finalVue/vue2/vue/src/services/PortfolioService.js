import axios from 'axios';

const currentToken = localStorage.getItem('token')
const apiClient = axios.create({
  baseURL: "http://localhost:9000",
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${currentToken}`
  }
});


export default{
    getAllPortfolios(id){
        return apiClient.get(`/portfolios/${id}`)
    },

    getPortfolioBalance(id, accountID){
        alert(`/portfolios/${id}/balance/${accountID}`)
        return apiClient.get(`/portfolios/${id}/balance/${accountID}`)
    }
}
import axios from 'axios';


const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
getAllStocks(){
    return http.get('/stocks/')
}
}
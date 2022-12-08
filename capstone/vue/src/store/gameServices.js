import axios from 'axios'

const API_BASE_URL ='https://api.polygon.io/v1/open-close/'

class gameServices{
    getStock(){
        return axios.get(API_BASE_URL);
    }
}

export default new gameServices()
import axios from "axios";

const http = axios.create(
    {
        baseURL: 'http://localhost:9000'
    }
);


export default{
    getAllGames(){
        return http.get(`/games`)
    },
    organizerGames(id){
        return http.get(`/${id}/organizer`);
    },

    addNewGame(id, game){
        return http.post(`/games/${id}/create`, game)
    }
}
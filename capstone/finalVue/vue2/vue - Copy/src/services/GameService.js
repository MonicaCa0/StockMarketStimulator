import axios from 'axios';


const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{

    createGame(id, game){
        return http.post(`/games/${id}/create/`, game);
    },

    viewAllGames(){
        return  http.get('/games')
    },

    getGamesByPlayer(playerId){
        return http.get(`/games/${playerId}/player`);
    },

    getGamesByOrganizer(id){
        return http.get(`/games/${id}/organizer`)
    },

    addUser(id){
        return http.post(`/games/${id}/addUser`);
    },

    allApprovedPlayers(gameId){
        return http.get(`/games/${gameId}/players/approved`);
    },

    allInvitedPlayers(gameId){
        return http.get(`/games/${gameId}/players`);
    },

    approveOrDeny(playerId){
        return http.post(`/games/${playerId}/response/{gameId}`)
    }

}

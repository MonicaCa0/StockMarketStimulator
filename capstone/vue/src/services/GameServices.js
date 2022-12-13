import axios from 'axios';


const http = axios.create({
    baseURL: "https://api.polygon.io/v1/open-close/"
});

export default{

    createGame(){
        return http.post('/{id}/create');
    },

    viewAllGames(){
        return http.get('')
    },

    getGamesByPlayer(){
        return http.get('/{playerId}/player');
    },

    getGamesByOrganizer(){
        return http.get('/{id}/organizer')
    },

    addUser(){
        return http.post('/{id}/addUser');
    },

    allApprovedPlayers(){
        return http.get('{gameId}/players/approved');
    },

    allInvitedPlayers(){
        return http.get('/{gameId}/players');
    },

    approveOrDeny(){
        return http.post('/{playerId}/response/{gameId}')
    }





}



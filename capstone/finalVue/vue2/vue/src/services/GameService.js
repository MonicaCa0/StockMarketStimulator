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

    createGame(id, game){
        return apiClient.post(`/games/${id}/create/`, game);
    },

    viewAllGames(){
        return  apiClient.get('/games')
    },
    getAllPendingGames(playerId){
        return apiClient.get(`/games/${playerId}/invites`);
    },

    getGamesByPlayer(playerId){
        return apiClient.get(`/games/${playerId}/player`);
    },

    getGamesByOrganizer(id){
        return apiClient.get(`/games/${id}/organizer`)
    },

    addUser(id){
        return apiClient.post(`/games/${id}/addUser`);
    },

    allApprovedPlayers(gameId){
        return apiClient.get(`/games/${gameId}/players/approved`);
    },

    allInvitedPlayers(gameId){
        return apiClient.get(`/games/${gameId}/players`);
    },

    approveOrDeny(playerId, gameId){
        return apiClient.post(`/games/${playerId}/response/${gameId}`)
    }

}

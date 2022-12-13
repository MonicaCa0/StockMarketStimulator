<script>
import GameServices from '../services/GameServices.vue';

export default{
    name: 'create-game',
    data() {
        return{
            Game: []
        }
    },
    methods: {
        createNewGame(){
            GameServices.post().then((response) => {
                this.Game = response.data;
            });
        }
    }
    
}

</script>

<script>
import GameServices from '../services/GameServices.vue';
export default{
    name: 'game-list',
    data() {
        return{
            playerId: []
        }
    },
    methods: {
        getAllGamesForPlayer(){
            GameServices.list().then((response) => {
                this.playerId = response.data;
            });
        }
    }   
}
</script>

<script>
import GameServices from '../services/GameServices.vue';
export default{
    name: 'add-user',
    data() {
        return{
           userIdFromGame: []
        }
    },
    methods: {
        addUser(){
            GameServices.post().then((response) => {
                this.userIdFromGame = response.data;
            });
        }
    }   
}
</script>


const app = new Vue({
    el: "#app",
    data() {
        return {
            korisnici: []
        }
    },
    methods: {
        ucitajPocetnu: function() {
            axios.get("/PocetniREST/", {
                })
                .then(response => {
                    this.users = response.data
                })
        }
    },
    mounted: function() {
       this.ucitajPocetnu()
    }
})
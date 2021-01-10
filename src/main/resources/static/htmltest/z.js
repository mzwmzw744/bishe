export default {
    data() {
        return {
            times: 60,
            show:true
        }
    },
    methods: {
        getCode() {
            this.show = false
            this.timer = setInterval(()=>{
                this.times--
                if(this.times===0){
                    this.show = true
                    clearInterval(this.timer)
                }
            },1000)
        }
    } }
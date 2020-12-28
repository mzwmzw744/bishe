const app = new Vue({
    el:'#app',
    data:{
        message:'你好啊5',
        counter:0,
        movies:['星际穿越','大话西游','少年派'],
    },
    methods:{
        add: function () {
            console.log('add被执行');
            this.counter++;
        },
        sub: function () {
            console.log('sub被执行');
            this.counter--;
        }
    }
})


var app2 = new Vue({
    el: '#app-2',
    data: {
        message: '页面加载于 ' + new Date().toLocaleString()
    }
})
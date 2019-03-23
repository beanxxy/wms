<div id="app">
    {{ message }}
</div>
<script>
function addtest(text){
    //const div=document.createElement('div');
    //div.textContent=text;
    //document.body.appendChild(div);
    linkout("123");
    var app=new Vue({

        el:'#app',
        data:{
            message:text
        }
    })
    return app;
}

</script>

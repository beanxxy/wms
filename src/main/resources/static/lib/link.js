var linkdb={};
var linksum=0;
var link=function(url,id){
    var el=document.createElement("link");
    el.rel="import";
    el.href=url;
    el.id="link"+linksum;
    document.head.appendChild(el);
    linkdb[id]=linksum;    
    linksum++;
}
var linkout=function(id){
    var el=document.querySelector("link[id=link"+linkdb[id]+"]");
    el=el.import;
    var els=el.querySelector("body").children;
    for(e in els){
        if(typeof els[e]=="object")
            document.body.appendChild(els[e]);
    } 
}
var linkoutall=function(){
    for(l in linkdb){
        linkout(l);
    }
}

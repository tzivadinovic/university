var wsUri = "ws://localhost:8080/CS230-DZ12-3860-JovanVujovic/wsendpoint";

function init(){
    websocket = new WebSocket(wsUri);
    
    websocket.onopen = function(evt){
        onOpen(evt);
    }
    
    websocket.onerror = function(evt){
        onError(evt);
    }
    
    websocket.onmessage = function(evt){
        onMessage(evt);
    }
}

function onOpen(evt){
    console.log("CONNECTED");
}

function onError(evt){
    console.log("ERROR: " + evt.data);
}

function onMessage(evt){
    console.log("RECEIVED: " + evt.data);
    
    var json = JSON.parse(evt.data);
    
    document.getElementById('firstName').value = json.firstName;
    document.getElementById('lastName').value = json.lastName;
    document.getElementById('city').value = json.city;
}

function doSend(message){
    console.log("SENT: " + message);
    websocket.send(message);
}

window.addEventListener("load", init, false);


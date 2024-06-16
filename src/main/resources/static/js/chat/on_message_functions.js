let webSocket;

function onMessageRealTimeAgent(msg){
    try{

        //const data = JSON.parse(msg.data);
       // console.log(data);


        let chatLog = document.getElementById("chatLog");
        chatLog.innerHTML += "<p>" + msg.data + "</p>";


    }catch (e){
        console.error(e);
        console.log(msg);
    }
}

function sendMessage(){
    let messageInput = document.getElementById("message");
    let message = messageInput.value;
    webSocket.send(message);
    messageInput.value = '';
}

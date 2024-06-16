package com.recipe.recipe_site.websocket.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    /**
     * TextWebSocketHandler는 WebSocektHandler 인터페이스의 구현체 중 하나로
     * 텍스트 기반 WebSocekt메시지를 처리하는데
     * */
    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      log.debug("<CONNECTED> session={}",session.getId());
    sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //   TextMessage msg = new TextMessage(payload);
        log.debug("메시지 수신: {}",message.getPayload());

        for(WebSocketSession s :sessions){
            if(s.isOpen()){
                s.sendMessage(new TextMessage(message.getPayload()));
            }
        }
       // session.sendMessage(new TextMessage(message.getPayload()));//메시지 보내기(화면)
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       log.debug("<DISCONNECTED> session={}, code={}",session.getId(),status.getCode());
      sessions.remove(session);
    }


//    public void sendMessage(String inwrNo, String payload) {
//        TextMessage msg = new TextMessage(payload);
//
//        // 모든 접속한 매니저에 보냄
//        ArrayList<WebSocketSession> webSocketSessions = managerInwrNoMap.get(inwrNo);
//        if (webSocketSessions != null) {
//            for (WebSocketSession webSocketSession : webSocketSessions) {
//                if (webSocketSession.isOpen()) {
//                    try {
//                        webSocketSession.sendMessage(msg);
//                        log.debug("<OUT MANAGER> f_CSLR_INWR_NO: " + inwrNo + "  session = " + webSocketSession.getId());
//                    } catch (IOException e) {
//                        log.error(e.toString());
//                    }
//                }
//            }
//
//        }
//
//    }
}

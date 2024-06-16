package com.recipe.recipe_site.websocket;

import com.recipe.recipe_site.websocket.handler.ChatWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket //build.gradle 종속성 추가해야함
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler chatWebSocketHandler;

    /**
     * WebSocketHandlerRegistry
     *  - Spring Framework에서는 WebScoekt핸들러를 등록하기 위해 사용되는 인터페이스
     *  - 이 인터페이스는 WebSocket 핸들러와 URL 경로를 연결하는 메서드를 제공.
     *
     * */

    //꼭 구현해야함.
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 이 메서드는 WebSocket 핸들러와 하나 이상의 URL 경로를 매핑
        registry.addHandler(chatWebSocketHandler,"ws/chat");
    }
}

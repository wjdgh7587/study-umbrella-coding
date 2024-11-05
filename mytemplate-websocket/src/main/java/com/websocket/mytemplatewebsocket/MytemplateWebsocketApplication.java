package com.websocket.mytemplatewebsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MytemplateWebsocketApplication {

    public static void main(String[] args) {
        log.info("MytemplateWebsocketApplication Start!");
        SpringApplication.run(MytemplateWebsocketApplication.class, args);
    }

}

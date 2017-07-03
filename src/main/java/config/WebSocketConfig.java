package config;

import mvc.controller.CarWebSocketHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

/**
 * Created by Владимир on 02.07.2017.
 */
@Configuration
@PropertySource(value = "classpath:websocket.properties")
@EnableWebSocket//Для активации этой аннотации используется
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Resource
    private Environment env;

    @Bean
    public CarWebSocketHandler getCarWebSocketHandler(){return new CarWebSocketHandler();}


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("IN registerWebSocketHandlers!!! "+ "${carSocket.url}");
        registry.addHandler(getCarWebSocketHandler(),env.getProperty("carSocket.url")).withSockJS();
    }
}

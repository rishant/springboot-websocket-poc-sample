package com.example.springboot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.springboot.config.WebSocketConfig;
import com.example.springboot.event.Greeting;
import com.example.springboot.request.HelloMessage;

@Controller
public class RatecardSocketController {

	///app/hello
    @MessageMapping("/hello")
    @SendTo(WebSocketConfig.STOM_TPOIC + "/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
      Thread.sleep(1000); // simulated delay
      return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
    
    @MessageMapping("/ratecard")
    @SendTo(WebSocketConfig.STOM_TPOIC_RC_NOTIFICATION + "/notify")
    public Greeting notifiation(HelloMessage message) throws Exception {
    	Thread.sleep(1000); // simulated delay
    	return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}

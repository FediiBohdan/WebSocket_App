package ua.fedii.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import ua.fedii.websocket.model.Greeting;
import ua.fedii.websocket.model.Message;

@Controller
public class GreetingController {
    // The @MessageMapping annotation ensures that, if a message is sent to the /hello destination, the greeting() method is called
    @MessageMapping("/hello")
    // The return value is broadcast to all subscribers of /topic/greetings, as specified in the @SendTo
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(500); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}

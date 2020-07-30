//Jeremy Bayangos
//JPMC SHERPA MODULE 1 - 7.8.2020
package Sherpa.Module.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
    //At request of any message needing to be publish/sent, this will handle.
    private final Producer producer;
    @Autowired
    public TestController(Producer producer) {
        this.producer = producer;
    }
    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
}//Make this put on a config file

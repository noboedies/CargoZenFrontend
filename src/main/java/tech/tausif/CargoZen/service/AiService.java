package tech.tausif.CargoZen.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String askAi(String sysPrompt, String userPrompt) {
        String result = chatClient.prompt()
                .system(sysPrompt)
                .user(userPrompt)
                .call()
                .content();
        return result;
    }
}

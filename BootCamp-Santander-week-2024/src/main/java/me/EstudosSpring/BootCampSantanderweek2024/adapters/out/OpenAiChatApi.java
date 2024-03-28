package me.EstudosSpring.BootCampSantanderweek2024.adapters.out;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;

import feign.RequestInterceptor;
import me.EstudosSpring.BootCampSantanderweek2024.domain.ports.GenerativeAiService;

@FeignClient(name = "OpenAiChatApi", url = "https://api.openai.com")
public interface OpenAiChatApi extends GenerativeAiService{
    
    @PostMapping("/v1/chat/completions")
    OpenAiChatCompletionResp chatCompletion(OpenAiChatCompletionReq req);



    @Override
    default String generateContent(String objective, String context) {

        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
            new Message("system", objective),
            new Message("user", context)
        );

        OpenAiChatCompletionReq req = new OpenAiChatCompletionReq(model,messages );

        OpenAiChatCompletionResp resp = chatCompletion(req);
        return resp.choices().getFirst().message().content();
    }

    record OpenAiChatCompletionReq(String model, List<Message> messages){}
    record Message(String role, String content){}

    record OpenAiChatCompletionResp(List<Choice> choices) {}
    record Choice(Message message){}

    public class Config {
        @Value("${api.key}")
        private String apiKey;
    
        @Bean
        public RequestInterceptor apiKeyRequestInterceptor() {
            return requestTemplate -> requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        }
    }
}

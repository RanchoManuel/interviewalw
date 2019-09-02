package com.bitacorajm;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;

@Controller("/interview")
public class InterviewController {

    @Post(value = "/", consumes = MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<AnswerInterview> index(@Body Single<RequestInterview> requestObject) {
        RequestInterview requestInterview = requestObject.blockingGet();
        char[] text = requestInterview.getText();

        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : text) {
            symbol = Character.toLowerCase(symbol);
            Integer count = map.get(symbol);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(symbol, count);
        }

        int answerValue = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                answerValue++;
            }
        }

        AnswerInterview answer = new AnswerInterview(answerValue);
        return HttpResponse.ok(answer);
    }
}

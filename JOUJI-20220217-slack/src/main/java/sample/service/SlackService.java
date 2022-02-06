package sample.service;

import org.springframework.stereotype.Service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import sample.config.SlackConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlackService {
    private final SlackConfig slackConfig;

    /**
     * slackへメッセージを送信する
     * @param name 氏名
     * @param holidayType 休日種別の定数
     */
    public ChatPostMessageResponse sendSlack(String name) throws RuntimeException{
        Slack slack = Slack.getInstance();
        String token = System.getenv(slackConfig.getSlackToken());
        MethodsClient methods = slack.methods(token);

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
            .token(slackConfig.getSlackToken())
            .channel(slackConfig.getSlackChannelId())
            .text("これはテストメッセージです。\n\nおはようございます。本日"+ name + "は、業務を開始致します")
            .build();
        ChatPostMessageResponse response = null;
        try {
            response = methods.chatPostMessage(request);
            log.info(String.valueOf(request));
            return response;
        } catch (IOException e) {
            log.error(String.valueOf(e));
            throw new RuntimeException(String.valueOf(e));
        } catch (SlackApiException e) {
            log.error(String.valueOf(e));
            throw new RuntimeException(String.valueOf(e));
        }
    }
}

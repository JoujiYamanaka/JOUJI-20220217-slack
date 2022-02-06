package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * Slackコンフィグ
 */
@Configuration
@PropertySource("classpath:/slack.properties")
@Data
public class SlackConfig {
    @Value("${slack.token}")
    private String slackToken;
    @Value("${slack.channel.id}")
    private String slackChannelId;
}

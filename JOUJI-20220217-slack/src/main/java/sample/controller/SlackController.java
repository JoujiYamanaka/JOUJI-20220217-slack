package sample.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import lombok.RequiredArgsConstructor;
import sample.service.SlackService;
import sample.util.MessageSourceUtil;
import sample.util.ResponseEntityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/slack")
public class SlackController {
    private final SlackService slackService;

    /**
     * slackメッセージ送信
     * @param request Request
     * @return ResponseEntity
     */
    @PostMapping(value = "/mesageSend",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> paidHolidaysReminder(@RequestBody @Validated Request Request) {

        // slackへメッセージを送信
    	ChatPostMessageResponse response = slackService.sendSlack(Request.getName());

        if (!Objects.isNull(response) && response.isOk()) {
            return ResponseEntityUtil.setResponseEntity(null, HttpStatus.OK, new Response(1));
        }
        return ResponseEntityUtil.setResponseEntity(
                MessageSourceUtil.getMessage("internalServerError"),
                HttpStatus.INTERNAL_SERVER_ERROR,
                String.valueOf(response));
    }
}

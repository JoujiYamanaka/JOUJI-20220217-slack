# JOUJI-20220217-slack
slackへメッセージを送信するサンプルです

## HOW TO USE
1.slackにサンプル用のworkspaceを作成する

2.1で作成したworkspaceにメッセージを送信するチャンネルを作成する

3.2で作成したチャンネルIDを取得する

4.slackにメッセージを送信するbotユーザーを作成する

5.作成したbotユーザーのアクセストークンを取得する

6.slack.propertiesに3と5で取得した内容を追記する。 場所「src/main/resources/slack.properties」

　slack.token=5で取得したトークン

　slack.channel.id=3で取得したチャンネルID

7.postmanにrequest用APIのデータをimportする。場所「/JOUJI-20220217-slack/postmanImportdata」

8.importしたデータからのslackMesageSendAPIを選択して、SENDボタンを押下する

## Development Environment
* Postman v9.13.2
* Spring Tool Suite 4 Version: 4.10.0.RELEASE

## Requirement
* Java 11
* Spring Boot Starter Parent 2.6.3
* Slack API Client 1.16.0
* Apache Commons Validator 1.4.0
* Project Lombok

## License
"2022 JoujiYamanaka" is under [MIT License](https://en.wikipedia.org/wiki/MIT_License).

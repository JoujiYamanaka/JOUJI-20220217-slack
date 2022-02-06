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

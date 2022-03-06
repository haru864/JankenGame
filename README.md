# JankenGame（じゃんけんゲーム）

コンピュータを相手にしたじゃんけんができるアプリです。<br>
N本先取ルールで勝負します。
コンピュータの手はランダムに決定します。

# DEMO

## 初期画面
アプリ起動時に表示される画面です。ボタン押下で勝敗表示画面に遷移します。<br>
<img width="500" alt="初期画面" src="./dev/初期画面.png">

## 勝敗表示画面
`グー`、`チョキ`、`パー`いずれかのボタン押下で初期画面から遷移します。<br>
画面上部プルダウンで、勝利条件（N本先取）を設定できます。設定を変更すると、得点と勝負数がリセットされます。<br>
リセットボタンを押下すると、得点と勝負数がリセットされます。<br>
<img width="500" alt="勝敗表示画面" src="./dev/勝敗表示画面.png">

# Requirement

* java version "17.0.2" 2022-01-18 LTS
* Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
* Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)

# Usage

classフォルダの`GameMain.class`を実行するとアプリが起動されます。<br>
終了するときは、ウィンドウ右上の×ボタンを押下して下さい。


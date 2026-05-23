デジタル時計アプリ (Digital Clock App)
Javaの標準GUIライブラリである「Swing」を使用した、シンプルで見やすいデスクトップ用デジタル時計アプリです。
<img width="412" height="173" alt="スクリーンショット 2026-05-23 192522" src="https://github.com/user-attachments/assets/26e7bd1d-dceb-4483-b55f-aa15ee434bfc" />

特徴
リアルタイム更新: javax.swing.Timer を使用し、1秒ごとに正確に時刻を更新します。

視認性の高いデザイン: 黒背景に緑色のテキストを採用し、レトロなデジタル時計風のデザインに仕上げています。

文字ズレ防止: 等幅フォント（Monospaced）を使用しているため、秒が切り替わる際も文字が左右にガタガタ動きません。

動作環境
Java SE 8 以上 (JDK 8 以降)

ファイル構成
DigitalClock.java : アプリケーションのメインソースコード

実行方法
1. コンパイル
ターミナル（またはコマンドプロンプト）を開き、ソースコードがあるディレクトリで以下のコマンドを実行します。

Bash
javac DigitalClock.java
2. 実行
コンパイルが成功すると DigitalClock.class が生成されます。以下のコマンドでアプリを起動します。

Bash
java DigitalClock
カスタマイズのヒント
ソースコード内の以下の部分を書き換えることで、簡単に見た目を変更できます。

12時間表記（AM/PM）に変えたい場合

Java
// 変更前
timeFormat = new SimpleDateFormat("HH:mm:ss");
// 変更後（例: 03:15:45 PM）
timeFormat = new SimpleDateFormat("hh:mm:ss a");
* **文字の色を「青」に変えたい場合**
  ```java
timeLabel.setForeground(Color.BLUE);
ライセンス
このプロジェクトは MITライセンスのもとで公開されています。個人利用・商用利用を問わず、自由に変更・配布していただけます。

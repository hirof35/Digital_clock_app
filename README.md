

# Classic Sweep Clock

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GUI](https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge)

Java Swingを使用して開発された、クラシックなローマ数字デザインのアナログ時計です。
標準的なステップ運針ではなく、高級時計のような滑らかな**スイープ運針（連続運針）**を再現しています。

## ✨ 特徴

*   **スイープ運針 (Sweep Movement)**: 秒針が1秒ごとに刻むのではなく、ミリ秒単位の計算により滑らかに回転します。
*   **クラシック・デザイン**: 白い文字盤、アンチエイリアス処理された美しい曲線、そして伝統的なローマ数字のインデックスを採用。
*   **ハイブリッド表示**: アナログ表示に加え、右下には現代的なデジタル日付・時刻を表示するインフォメーションパネルを搭載。
*   **レスポンシブ描画**: ウィンドウサイズに合わせて時計の大きさが自動的に調整されます。

## 🛠 技術的なポイント

*   **高頻度タイマー**: `javax.swing.Timer` を50ミリ秒間隔で実行し、描画を更新することで滑らかな動きを実現しています。
*   **数学的座標計算**: 三角関数（$\sin$, $\cos$）を用いて、各針の先端座標や文字盤のインデックス位置を正確に算出しています。
*   **Graphics2D 描画**: `RenderingHints` によるアンチエイリアス有効化、および `BasicStroke` による線の太さ・端点処理の最適化を行っています。

## 🚀 実行方法

1.  Javaがインストールされていることを確認します（Java 8以上推奨）。
2.  リポジトリをクローンします。
    ```bash
    git clone https://github.com/YOUR_USERNAME/classic-sweep-clock.git
    ```
3.  コンパイルして実行します。
    ```bash
    javac classicClock/ClassicClock.java
    java classicClock.ClassicClock
    ```


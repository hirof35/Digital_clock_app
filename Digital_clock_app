package Digital_clock_app;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Digital_clock_app extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public Digital_clock_app() {
        // ウインドウの設定
        setTitle("デジタル時計");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 画面中央に表示
        getContentPane().setBackground(Color.BLACK); // 背景を黒に

        // 時刻のフォーマット（時:分:秒）
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // 時刻を表示するラベルの設定
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 48)); // 等幅フォントで文字ズレを防ぐ
        timeLabel.setForeground(Color.GREEN); // 昔ながらのデジタル風に緑色
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 初回表示の時刻を設定
        updateTime();

        // 1000ミリ秒（1秒）ごとに呼び出されるタイマーを設定
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        // コンポーネントの配置
        add(timeLabel);
    }

    // 現在時刻を取得してラベルを更新するメソッド
    private void updateTime() {
        String currentTime = timeFormat.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        // GUIのイベントディスパッチスレッドで実行
        SwingUtilities.invokeLater(() -> {
            new Digital_clock_app().setVisible(true);
        });
    }
}

package classicClock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ClassicClock extends JFrame {

    public ClassicClock() {
        setTitle("Classic Sweep Clock");
        setSize(450, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new ClockPanel());
        
        // スイープ運針のために更新間隔を50ミリ秒に設定
        Timer timer = new Timer(50, e -> repaint());
        timer.start();
    }

    class ClockPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            // 描画を滑らかにする設定
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;
            int radius = Math.min(width, height) / 2 - 40;

            // 1. 背景（文字盤）
            g2.setColor(Color.WHITE);
            g2.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
            g2.setColor(new Color(40, 40, 40));
            g2.setStroke(new BasicStroke(4));
            g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            // 2. 目盛りとローマ数字
            drawIndexes(g2, centerX, centerY, radius);

            // 3. 現在時刻の取得と角度計算
            Calendar now = Calendar.getInstance();
            double preciseSecond = now.get(Calendar.SECOND) + now.get(Calendar.MILLISECOND) / 1000.0;
            double secDeg = preciseSecond * 6;
            double minDeg = (now.get(Calendar.MINUTE) + preciseSecond / 60.0) * 6;
            double hourDeg = (now.get(Calendar.HOUR) + (now.get(Calendar.MINUTE) + preciseSecond / 60.0) / 60.0) * 30;

            // 4. 針の描画
            drawHand(g2, centerX, centerY, hourDeg, radius * 0.5, 7, Color.BLACK);      // 時針
            drawHand(g2, centerX, centerY, minDeg, radius * 0.75, 5, Color.DARK_GRAY);  // 分針
            drawHand(g2, centerX, centerY, secDeg, radius * 0.85, 2, Color.RED);        // 秒針
            
            // 中心点
            g2.setColor(Color.BLACK);
            g2.fillOval(centerX - 6, centerY - 6, 12, 12);

            // 5. 日付とデジタル時刻の表示
            drawDigitalInfo(g2, now, width, height);
        }

        private void drawIndexes(Graphics2D g2, int cx, int cy, int r) {
            String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
            g2.setFont(new Font("Serif", Font.BOLD, 20));
            FontMetrics fm = g2.getFontMetrics();

            for (int i = 1; i <= 60; i++) {
                double angle = Math.toRadians(i * 6);
                if (i % 5 == 0) {
                    // ローマ数字
                    int idx = i / 5;
                    int x = (int) (cx + (r - 35) * Math.sin(angle));
                    int y = (int) (cy - (r - 35) * Math.cos(angle));
                    String label = roman[idx];
                    g2.drawString(label, x - fm.stringWidth(label) / 2, y + fm.getAscent() / 2 - 2);
                    // 5分ごとの目盛り
                    g2.fillOval((int)(cx + (r-10)*Math.sin(angle))-3, (int)(cy - (r-10)*Math.cos(angle))-3, 6, 6);
                } else {
                    // 1分ごとのドット
                    g2.fillOval((int)(cx + (r-8)*Math.sin(angle))-1, (int)(cy - (r-8)*Math.cos(angle))-1, 2, 2);
                }
            }
        }

        private void drawDigitalInfo(Graphics2D g2, Calendar now, int w, int h) {
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            String dateStr = months[now.get(Calendar.MONTH)] + " " + now.get(Calendar.DATE);
            String timeStr = String.format("%02d:%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
            String fullText = dateStr + "  " + timeStr;

            g2.setFont(new Font("Monospaced", Font.BOLD, 14));
            FontMetrics fm = g2.getFontMetrics();
            int x = w - fm.stringWidth(fullText) - 30;
            int y = h - 30;

            g2.setColor(new Color(230, 230, 230, 180));
            g2.fillRoundRect(x - 10, y - fm.getAscent() - 5, fm.stringWidth(fullText) + 20, fm.getHeight() + 10, 10, 10);
            g2.setColor(Color.BLACK);
            g2.drawString(fullText, x, y);
        }

        private void drawHand(Graphics2D g2, int x, int y, double angle, double len, int thick, Color c) {
            double rad = Math.toRadians(angle);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(thick, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(x, y, (int)(x + len * Math.sin(rad)), (int)(y - len * Math.cos(rad)));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClassicClock().setVisible(true));
    }
}

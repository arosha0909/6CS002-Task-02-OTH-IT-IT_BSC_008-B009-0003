package base;
import java.awt.*;

import javax.swing.*;
/**
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */

public class PictureFrame {
  public int[] reroll = null;
  public Main master = null
		  
  private int _x = 30;
  private int _y = 20;
  private int degree = 10;

  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
        	drawDigitGivenGridCentre(g, _x + see * 20, _x + are * 20, _x,
              master.grid[are][see]);
        }
      }
    }



    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, _x + are * 20, _x, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, _x + see * 20, 10, _y, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) {
      if (d.placed) {
        int y = Math.min(d.ly, d.hy);
        int x = Math.min(d.lx, d.hx);
        int w = Math.abs(d.lx - d.hx) + 1;
        int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(_y + x * 20, _y + y * 20, w * 20, h * 20);
        g.setColor(Color.RED);
        g.drawRect(_y + x * 20, _y + y * 20, w * 20, h * 20);
        drawDigitGivenDominoCentre(g, _x + d.hx * 20, _x + d.hy * 20, _y, d.high,
            Color.BLUE);
        drawDigitGivenDominoCentre(g, _x + d.lx * 20, _x + d.ly * 20, _y, d.low,
            Color.BLUE);
      }
    }

    void drawDigitGivenGridCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      // convert the string to an integer
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void drawDigitGivenDominoCentre(Graphics g, int x, int y, int diameter, int n,
        Color c) {
      int radius = diameter / 2;
      g.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, getWidth(), getHeight());

      // numbaz(g);
      //
      // if (master!=null && master.orig != null) {
      // drawRoll(g, master.orig);
      // }
      // if (reroll != null) {
      // drawReroll(g, reroll);
      // }
      //
      // drawGrid(g);
      Location l = new Location(1,2);

      if (master.mode == 1) {
        l.drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawGuesses(g);
      }
      if (master.mode == 0) {
        l.drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawDominoes(g);
      }
    }

    public Dimension getPreferredSize() {
      // the application window always prefers to be 202x182
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(Main sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }

  public void reset() {
    // TODO Auto-generated method stub

  }

}

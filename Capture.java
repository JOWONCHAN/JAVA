import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;


public class Capture extends JPanel implements ActionListener {

    JButton cbtn;
    Image img = null;

    public Capture() {
    	
        this.cbtn = new JButton("화면캡쳐");
        this.cbtn.addActionListener(this);
        this.setLayout(new BorderLayout());
        this.add(this.cbtn, BorderLayout.SOUTH);
        
    }

    public void actionPerformed(ActionEvent e) {
    	
        String cmd = e.getActionCommand();
        if (cmd.equals("화면캡쳐")) {
            System.out.println("화면을 캡쳐합니다..");
            this.capture();               
        }
        
    }

    private void drawImage(Image img, int x_value, int y_value) {
    	
        Graphics g = this.getGraphics();
        g.drawImage(img, 0, 0, x_value, y_value, this);
        this.paint(g);
        this.repaint();
        
    }

    public void paint(Graphics g) {
    	
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.img.getWidth(this), this.img.getHeight(this), this);
        }
        
    }

    public void capture() {
    	
        Robot rb;
        BufferedImage bufferImage = null;
        
        try {
            rb = new Robot();
            Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            bufferImage = rb.createScreenCapture(area);     
            int width = this.getWidth();
            int height = this.getHeight();

            this.img = bufferImage.getScaledInstance(width, height - 20, Image.SCALE_DEFAULT);
            this.drawImage(img, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void createFrame() {
    	
        JFrame frame = new JFrame("Capture");
        JFrame.setDefaultLookAndFeelDecorated(true);
        Container cont = frame.getContentPane();
        cont.setLayout(new BorderLayout());
        Capture mm = new Capture();
        cont.add(mm, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
        
    }

    public static void main(String... v) {
    	
        JFrame.setDefaultLookAndFeelDecorated(true);
        createFrame();
        
    }
}
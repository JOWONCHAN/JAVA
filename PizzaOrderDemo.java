import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class PizzaOrderDemo extends JFrame implements ActionListener {

	private int sum, temp1, temp2, temp3;
	
	private JButton orderBtn, cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	JPanel welcomePanel = new WelcomePanel();
	
	JPanel typePanel = new TypePanel();
	JPanel toppingPanel = new ToppingPanel();
	JPanel sizePanel = new SizePanel();
	
	public PizzaOrderDemo() {
		
		this.setSize(500, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("피자 주문");
		
		orderBtn = new JButton("주문");
		orderBtn.addActionListener(this);
		
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new JPanel();
		orderPanel.add(orderBtn);
		orderPanel.add(cancelBtn);
		orderPanel.add(priceField);
		
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(orderPanel, BorderLayout.SOUTH);
		this.add(sizePanel, BorderLayout.EAST);
		this.add(typePanel, BorderLayout.WEST);
		this.add(toppingPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int sum1 = 0, sum2 = 0, sum3 = 0;
		
		if ( e.getSource() == orderBtn ) {
			
			if ( temp1 == 0 ) {
				sum1 = 100;
			} else if ( temp1 == 1 ) {
				sum1 = 200;
			} else if ( temp1 == 2 ) {
				sum1 = 300;
			}
			
			if ( temp2 == 0 ) {
				sum2 = 100;
			} else if ( temp2 == 1 ) {
				sum2 = 200;
			} else if ( temp2 == 2 ) {
				sum2 = 300;
			} else if ( temp2 == 3 ) {
				sum2 = 400;
			}
			
			if ( temp3 == 0 ) {
				sum3 = 100;
			} else if ( temp3 == 1 ) {
				sum3 = 200;
			} else if ( temp3 == 2 ) {
				sum3 = 300;
			}
			
			sum = sum1 + sum2 + sum3;
			
			
			priceField.setText(String.valueOf(sum));
			System.out.println("temp1:" + temp1 + ", temp2:" + temp2 + ", temp3:" + temp3);
		} else if ( e.getSource() == cancelBtn ) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			priceField.setText(String.valueOf(sum));
		}
		
	}
	
	class WelcomePanel extends JPanel {
		
		private JLabel message;
		
		public WelcomePanel() {
			
			message = new JLabel("자바 피자에 오신것을 환영합니다.");
			this.add(message);
			
		}
		
	}
	
	class TypePanel extends JPanel implements ActionListener {
		
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup btnGroup;
		
		public TypePanel() {
			
			this.setLayout(new GridLayout(3, 1));
			combo = new JRadioButton("콤보", true);
			combo.addActionListener(this);
			potato = new JRadioButton("포테이토");
			potato.addActionListener(this);
			bulgogi = new JRadioButton("불고기");
			bulgogi.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(combo);
			btnGroup.add(potato);
			btnGroup.add(bulgogi);
			
			this.setBorder(BorderFactory.createTitledBorder("종류"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if ( e.getSource() == combo ) {
				temp1 = 0;
			} else if ( e.getSource() == potato ) {
				temp1 = 1;
			} else if ( e.getSource() == bulgogi ){
				temp1 = 2;
			}
			
		}
	}
	
	class ToppingPanel extends JPanel implements ActionListener {
		
		private JRadioButton pepper, cheese, peperoni, bacon;
		
		private ButtonGroup btnGroup;
		
		public ToppingPanel() {
			
			this.setLayout(new GridLayout(4, 1));
			
			pepper = new JRadioButton("피망", true);
			pepper.addActionListener(this);
			cheese = new JRadioButton("치즈");
			cheese.addActionListener(this);
			peperoni = new JRadioButton("페페로니");
			peperoni.addActionListener(this);
			bacon = new JRadioButton("베이컨");
			bacon.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(pepper);
			btnGroup.add(cheese);
			btnGroup.add(peperoni);
			btnGroup.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("추가토핑"));
			
			this.add(pepper);
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if ( e.getSource() == pepper ) {
				temp2 = 0;
			} else if ( e.getSource() == cheese ) {
				temp2 = 1;
			} else if ( e.getSource() == peperoni ) {
				temp2 = 2;
			} else if ( e.getSource() == bacon ) {
				temp2 = 3;
			}
			
		}
	}
	
	class SizePanel extends JPanel implements ActionListener {
		
		private JRadioButton small, medium, large;
		private ButtonGroup btnGroup;
		
		public SizePanel() {
			
			this.setLayout(new GridLayout(3, 1));
			small = new JRadioButton("smal", true);
			small.addActionListener(this);
			medium = new JRadioButton("Medium");
			medium.addActionListener(this);
			large = new JRadioButton("Large");
			large.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(small);
			btnGroup.add(medium);
			btnGroup.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("크기"));
			
			this.add(small);
			this.add(medium);
			this.add(large);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if ( e.getSource() == small ) {
				temp3 = 0;
			} else if ( e.getSource() == medium ) {
				temp3 = 1;
			} else if ( e.getSource() == large ) {
				temp3 = 2;
			}
			
		}
	}
	
	public static void main(String[] args) {

		new PizzaOrderDemo();
	}

}

package soul_game2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class soultree extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage(); // �̽��ͼǻ���
																													// �̹�����
																													// ����
																													// ��ü
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/close.png")));

	
	private int mouseX, mouseY;
	public soultree() {
		setUndecorated(true); // �⺻������ �����Ǵ� �޴� �� ���̰� ����
		setTitle("soul tree");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// ����â ũ�� 1280 * 720
		setResizable(false); // ����ڰ� ���������� â�� ũ�⸦ ���� ����
		setLocationRelativeTo(null); // ����â�� ���߾ӿ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �� ���� ������ ���� ��ǻ�� ���ο��� ��� ��
		setVisible(true); // ����â�� ���������� ȭ�鿡 ��µǵ��� ��
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);//3�� false ����� ���� ���ϴ� �̹��� ����
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBorderPainted(true);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBorderPainted(false);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					Thread.sleep(100);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				//�̺�Ʈ�� �߻����� �� x��ǥ�� y��ǥ�� ��� ��
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
				//JFrame�� ��ġ�� �ٲ� ��
			}
		});
		add(menuBar);
		
		

		Music introMusic = new Music("�� �� (Original Ver.)_��ȿ��.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720�� �̹����� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��ؼ� �׷��� ��ü�� ������
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);// introBackground�� 0,0��ġ�� �׷���
		paintComponents(g); // �׻� �����ϰ� ���������� �����̴� �̹����� �ƴѰ͵��� �׷���
		this.repaint(); // ����Ʈ�� Jframe�� ��ӹ��� GUI���ӿ��� ���� ù ��°�� ȭ���� �׷��ִ� �Լ�(��� �� ��);
	}
}

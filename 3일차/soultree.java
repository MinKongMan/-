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

import soul_game1.Main;

public class soultree extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�

	private Image Background = new ImageIcon(Main.class.getResource("../images/hyosin.png")).getImage(); // ���� ȭ��
																													// �̹�����
																													// ����
																													// ��ü
	private ImageIcon startButtonimg1 = new ImageIcon(Main.class.getResource("../images/Start1.png"));
	private ImageIcon startButtonimg2 = new ImageIcon(Main.class.getResource("../images/Start2.png"));
	private ImageIcon endButtonimg1 = new ImageIcon(Main.class.getResource("../images/end1.png"));
	private ImageIcon endButtonimg2 = new ImageIcon(Main.class.getResource("../images/end2.png"));

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/close.png")));

	private JButton startButton = new JButton(startButtonimg1);
	private JButton endButton = new JButton(endButtonimg1);
	
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
		exitButton.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
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

				try { // �տ� ������ �� ���� �����Ÿ� sleep �ð� ���� �ֱ�
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonimg2);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonimg1);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false);
				endButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage();
				
				//���� ���� �̺�Ʈ
				
			}
		});
		add(startButton);
		
		endButton.setBounds(40, 30, 400, 100);
		endButton.setBorderPainted(false);
		endButton.setContentAreaFilled(false);
		endButton.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
		endButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				endButton.setIcon(endButtonimg2);
				endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				endButton.setIcon(endButtonimg1);
				endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
				//���� ���� �̺�Ʈ
				try { // �տ� ������ �� ���� �����Ÿ� sleep �ð� ���� �ֱ�
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(endButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				// �̺�Ʈ�� �߻����� �� x��ǥ�� y��ǥ�� ��� ��
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
				// JFrame�� ��ġ�� �ٲ� ��
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
		g.drawImage(Background, 0, 0, null);// Background�� 0,0��ġ�� �׷���
		paintComponents(g); // �׻� �����ϰ� ���������� �����̴� �̹����� �ƴѰ͵��� �׷���
		this.repaint(); // ����Ʈ�� Jframe�� ��ӹ��� GUI���ӿ��� ���� ù ��°�� ȭ���� �׷��ִ� �Լ�(��� �� ��);
	}
}

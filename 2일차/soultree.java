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
	// 더블 버퍼링을 위해서 전체 화면에 대한 이미지를 담는 인스턴스

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage(); // 미스터션샤인
																													// 이미지를
																													// 담을
																													// 객체
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/close.png")));

	
	private int mouseX, mouseY;
	public soultree() {
		setUndecorated(true); // 기본적으로 제공되는 메뉴 안 보이게 해줌
		setTitle("soul tree");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 게임창 크기 1280 * 720
		setResizable(false); // 사용자가 인위적으로 창의 크기를 조절 못함
		setLocationRelativeTo(null); // 게임창이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안 쓰면 게임을 꺼도 컴퓨터 내부에서 계속 돔
		setVisible(true); // 게임창이 정상적으로 화면에 출력되도록 함
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);//3개 false 해줘야 내가 원하는 이미지 나옴
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
				//이벤트가 발생했을 때 x좌표와 y좌표를 얻어 옴
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
				//JFrame의 위치를 바꿔 줌
			}
		});
		add(menuBar);
		
		

		Music introMusic = new Music("그 날 (Original Ver.)_박효신.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720의 이미지를 만듦
		screenGraphic = screenImage.getGraphics();// 스크린 이미지를 이용해서 그래픽 객체를 가져옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);// introBackground를 0,0위치에 그려줌
		paintComponents(g); // 항상 존재하고 역동적으로 움직이는 이미지가 아닌것들을 그려줌
		this.repaint(); // 페인트는 Jframe을 상속받은 GUI게임에서 가장 첫 번째로 화면을 그려주는 함수(약속 된 거);
	}
}

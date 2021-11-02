package soul_game2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import soul_game1.Main;

public class soultree extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위해서 전체 화면에 대한 이미지를 담는 인스턴스


	private Image Background = new ImageIcon(Main.class.getResource("../images/Home.psd")).getImage(); // 메인 화면
																													// 이미지를
																													// 담을
																													// 객체
	private ImageIcon startButtonimg1 = new ImageIcon(Main.class.getResource("../images/Start1.png"));
	private ImageIcon startButtonimg2 = new ImageIcon(Main.class.getResource("../images/Start2.png"));
	private ImageIcon endButtonimg1 = new ImageIcon(Main.class.getResource("../images/end1.png"));
	private ImageIcon endButtonimg2 = new ImageIcon(Main.class.getResource("../images/end2.png"));
	private ImageIcon leftButtonimg = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon rightButtonimg = new ImageIcon(Main.class.getResource("../images/right.png"));

	
	private Image titleImage_gi = new ImageIcon(Main.class.getResource("../images/gift_title.png")).getImage();
	private Image titleImage_ho = new ImageIcon(Main.class.getResource("../images/home_title.png")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/close.png")));

	private JButton startButton = new JButton(startButtonimg1);
	private JButton endButton = new JButton(endButtonimg1);
	private JButton leftButton = new JButton(leftButtonimg);
	private JButton rightButton = new JButton(rightButtonimg);
	
	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private Image titleImage_td;
	private Image selectedImage; // 메인 화면
	private int nowSelected = 0;
	
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

		Music introMusic = new Music("그 날 (Original Ver.)_박효신.mp3", true);
		introMusic.start();//메인 화면으로 넘어왔을 때 음악이 들리지 않기 위해 앞으로 땡김
		
		trackList.add(new Track("gift_title.png", "gift_intro.jpg", "gift_play.jpg", 
				"Gift_박효신_intro.mp3", "Gift_박효신.mp3"));
		trackList.add(new Track("home_title.png", "home_intro.jpg", "home_play.jpg", 
				"Home_박효신_intro.mp3", "Home_박효신.mp3"));
		trackList.add(new Track("the_day_title.png", "mr_sunshine_intro.jpg", "mr_sunshine_play.jpg", 
				"그 날 (Original Ver.)_박효신_intro.mp3", "그 날 (Original Ver.)_박효신.mp3"));
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);// 3개 false 해줘야 내가 원하는 이미지 나옴
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

				try { // 앞에 종료할 때 음악 넣을거면 sleep 시간 맞춰 주기
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
		startButton.setFocusPainted(false);// 3개 false 해줘야 내가 원하는 이미지 나옴
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
				introMusic.close();
				startButton.setVisible(false);
				endButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage();
				isMainScreen = true;
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				selectedTrack(0);
				//게임 시작 이벤트
				
			}
		});
		add(startButton);
		
		endButton.setBounds(40, 30, 400, 100);
		endButton.setBorderPainted(false);
		endButton.setContentAreaFilled(false);
		endButton.setFocusPainted(false);// 3개 false 해줘야 내가 원하는 이미지 나옴
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
				
				
				//게임 시작 이벤트
				try { // 앞에 종료할 때 음악 넣을거면 sleep 시간 맞춰 주기
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(endButton);

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);// 3개 false 해줘야 내가 원하는 이미지 나옴
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setBorderPainted(true);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setBorderPainted(false);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				//왼쪽 버튼 이벤트
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1000, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);// 3개 false 해줘야 내가 원하는 이미지 나옴
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setBorderPainted(true);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setBorderPainted(false);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
				
			}
		});
		add(rightButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				// 이벤트가 발생했을 때 x좌표와 y좌표를 얻어 옴
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
				// JFrame의 위치를 바꿔 줌
			}
		});
		add(menuBar);

	
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720의 이미지를 만듦
		screenGraphic = screenImage.getGraphics();// 스크린 이미지를 이용해서 그래픽 객체를 가져옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// Background를 0,0위치에 그려줌
		
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null); //340, 100의 위치에 보여줌
			g.drawImage(titleImage_td, 340, 70, null);
		}
		paintComponents(g); // 항상 존재하고 역동적으로 움직이는 이미지가 아닌것들을 그려줌 / add로 추가한것을 그려줌
		this.repaint(); // 페인트는 Jframe을 상속받은 GUI게임에서 가장 첫 번째로 화면을 그려주는 함수(약속 된 거);
	}
	
	public void selectedTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage_td = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected==0) {
			nowSelected = trackList.size()-1; // 가장 오른쪽 곡 선택
		}
		else {
			nowSelected--;
		}
		selectedTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected==trackList.size()-1) {
			nowSelected = 0; // 가장 오른쪽 곡 선택
		}
		else {
			nowSelected++;
		}
		selectedTrack(nowSelected);
	}
}

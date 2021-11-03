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
	// ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�


	private Image Background = new ImageIcon(Main.class.getResource("../images/Home.psd")).getImage(); // ���� ȭ��
																													// �̹�����
																													// ����
																													// ��ü
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage(); // ���� ȭ��
	
	private Image judge = new ImageIcon(Main.class.getResource("../images/judge.png")).getImage();
	
	private ImageIcon startButtonimg1 = new ImageIcon(Main.class.getResource("../images/Start1.png"));
	private ImageIcon startButtonimg2 = new ImageIcon(Main.class.getResource("../images/Start2.png"));
	private ImageIcon endButtonimg1 = new ImageIcon(Main.class.getResource("../images/end1.png"));
	private ImageIcon endButtonimg2 = new ImageIcon(Main.class.getResource("../images/end2.png"));
	private ImageIcon leftButtonimg = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon rightButtonimg = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon backButton = new ImageIcon(Main.class.getResource("../images/back.png"));
	private ImageIcon backButtonC = new ImageIcon(Main.class.getResource("../images/back_click.png"));
	
	private ImageIcon easyButton = new ImageIcon(Main.class.getResource("../images/easy.png"));
	private ImageIcon easyButtonC = new ImageIcon(Main.class.getResource("../images/easy_click.png"));
	private ImageIcon hardButton = new ImageIcon(Main.class.getResource("../images/hard.png"));
	private ImageIcon hardButtonC = new ImageIcon(Main.class.getResource("../images/hard._clickpng.png"));
	
	
	
	private Image titleImage_gi = new ImageIcon(Main.class.getResource("../images/gift_title.png")).getImage();
	private Image titleImage_ho = new ImageIcon(Main.class.getResource("../images/home_title.png")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/close.png")));

	private JButton startButton = new JButton(startButtonimg1);
	private JButton endButton = new JButton(endButtonimg1);
	private JButton leftButton = new JButton(leftButtonimg);
	private JButton rightButton = new JButton(rightButtonimg);
	private JButton easy = new JButton(easyButton);
	private JButton hard = new JButton(hardButton);
	private JButton back = new JButton(backButton);
	
	
	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false; // �������� �Ѿ� �Դ��� Ȯ��
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private Image titleImage_td;
	private Image selectedImage; // ���� ȭ��
	private int nowSelected = 0;
	
	private Music introMusic = new Music("�� �� (Original Ver.)_��ȿ��.mp3", true);
	
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
		
		Background = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage();
		
		introMusic.start();//���� ȭ������ �Ѿ���� �� ������ �鸮�� �ʱ� ���� ������ ����
		
		trackList.add(new Track("gift_title.png", "gift_intro.jpg", "gift_play.jpg", 
				"Gift_��ȿ��_intro.mp3", "Gift_��ȿ��.mp3"));
		trackList.add(new Track("home_title.png", "home_intro.jpg", "home_play.jpg", 
				"Home_��ȿ��_intro.mp3", "Home_��ȿ��.mp3"));
		trackList.add(new Track("the_day_title.png", "mr_sunshine_intro.jpg", "mr_sunshine_play.jpg", 
				"�� �� (Original Ver.)_��ȿ��_intro.mp3", "�� �� (Original Ver.)_��ȿ��.mp3"));
		
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
				
				//���� ���� �̺�Ʈ
				enterMain();
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

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
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
				//���� ��ư �̺�Ʈ
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1000, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
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
		
		easy.setVisible(false);
		easy.setBounds(375, 580, 250, 67); // ���ʿ��� , ������ , ��ư ���� ũ��, ��ư ���� ũ��
		easy.setBorderPainted(false);
		easy.setContentAreaFilled(false);
		easy.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
		easy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easy.setIcon(easyButtonC);
				easy.setBorderPainted(true);
				easy.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easy.setBorderPainted(false);
				easy.setIcon(easyButton);
				easy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				//���̵� ���� �̺�Ʈ
				gameStart(nowSelected, "easy");
				
			}
		});
		add(easy);
		
		
		hard.setVisible(false);
		hard.setBounds(655, 580, 250, 67); // ���ʿ��� , ������ , ��ư ���� ũ��, ��ư ���� ũ��
		hard.setBorderPainted(false);
		hard.setContentAreaFilled(false);
		hard.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
		hard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hard.setIcon(hardButtonC);
				hard.setBorderPainted(true);
				hard.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hard.setBorderPainted(false);
				hard.setIcon(hardButton);
				hard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				//���̵� ����� �̺�Ʈ
				gameStart(nowSelected, "hard");
				
			}
		});
		add(hard);
		
		back.setVisible(false);
		back.setBounds(20, 50, 60, 60); // ���ʿ��� , ������ , ��ư ���� ũ��, ��ư ���� ũ��
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);// 3�� false ����� ���� ���ϴ� �̹��� ����
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(backButtonC);
				back.setBorderPainted(true);
				back.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setBorderPainted(false);
				back.setIcon(backButton);
				back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				//���� ȭ������ ���ư��� �̺�Ʈ
				backMain();
				
			}
		});
		add(back);
		
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

	
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720�� �̹����� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��ؼ� �׷��� ��ü�� ������
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// Background�� 0,0��ġ�� �׷���
		
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null); //340, 100�� ��ġ�� ������
			g.drawImage(titleImage_td, 340, 70, null); //Ÿ��Ʋ �̹���
		}
		
		if(isGameScreen) {
			g.drawImage(gameInfoImage, 0, 660, null); //Ÿ��Ʋ �̹���
			g.drawImage(judge, 0, 580, null);
		}
		paintComponents(g); // �׻� �����ϰ� ���������� �����̴� �̹����� �ƴѰ͵��� �׷��� / add�� �߰��Ѱ��� �׷���
		this.repaint(); // ����Ʈ�� Jframe�� ��ӹ��� GUI���ӿ��� ���� ù ��°�� ȭ���� �׷��ִ� �Լ�(��� �� ��);
	}
	
	public void selectedTrack(int nowSelected) { // �ش� ��ġ�� ���� ����
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
			nowSelected = trackList.size()-1; // ���� ������ �� ����
		}
		else {
			nowSelected--;
		}
		selectedTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected==trackList.size()-1) {
			nowSelected = 0; // ���� ������ �� ����
		}
		else {
			nowSelected++;
		}
		selectedTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false; //screenDraw���� 2�� ���� �ȵ�
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easy.setVisible(false);
		hard.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getGameMusic(),false);
		selectedMusic.start();
		back.setVisible(true);
		isGameScreen = true;
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easy.setVisible(true);
		hard.setVisible(true);
		Background = new ImageIcon(Main.class.getResource("../images/hyosin.png")).getImage();
		back.setVisible(false);
		selectedTrack(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain() {
		startButton.setVisible(false);
		endButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/hyosin.png")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easy.setVisible(true);
		hard.setVisible(true);
		introMusic.close();
		selectedTrack(0);
		
	}
}

package soul_game2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class soultree extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위해서 전체 화면에 대한 이미지를 담는 인스턴스
	
	private Image introBackground; // 미스터션샤인 이미지를 담을 객체
	
	public soultree() {
		setTitle("soul tree");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 게임창 크기 1280 * 720
		setResizable(false); // 사용자가 인위적으로 창의 크기를 조절 못함
		setLocationRelativeTo(null); // 게임창이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안 쓰면 게임을 꺼도 컴퓨터 내부에서 계속 돔
		setVisible(true); // 게임창이 정상적으로 화면에 출력되도록 함
	
		introBackground = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage();
	
		Music introMusic = new Music("그 날 (Original Ver.)_박효신.mp3",true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720의 이미지를 만듦
		screenGraphic = screenImage.getGraphics();// 스크린 이미지를 이용해서 그래픽 객체를 가져옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null);
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);//introBackground를 0,0위치에 그려줌
		this.repaint(); // 페인트는 Jframe을 상속받은 GUI게임에서 가장 첫 번째로 화면을 그려주는 함수(약속 된 거);
	}
}

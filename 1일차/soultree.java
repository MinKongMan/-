package soul_game2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class soultree extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	// ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�
	
	private Image introBackground; // �̽��ͼǻ��� �̹����� ���� ��ü
	
	public soultree() {
		setTitle("soul tree");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// ����â ũ�� 1280 * 720
		setResizable(false); // ����ڰ� ���������� â�� ũ�⸦ ���� ����
		setLocationRelativeTo(null); // ����â�� ���߾ӿ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �� ���� ������ ���� ��ǻ�� ���ο��� ��� ��
		setVisible(true); // ����â�� ���������� ȭ�鿡 ��µǵ��� ��
	
		introBackground = new ImageIcon(Main.class.getResource("../images/Mr_sunshine2.jpg")).getImage();
	
		Music introMusic = new Music("�� �� (Original Ver.)_��ȿ��.mp3",true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_WEIGHT);// 1280*720�� �̹����� ����
		screenGraphic = screenImage.getGraphics();// ��ũ�� �̹����� �̿��ؼ� �׷��� ��ü�� ������
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null);
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);//introBackground�� 0,0��ġ�� �׷���
		this.repaint(); // ����Ʈ�� Jframe�� ��ӹ��� GUI���ӿ��� ���� ù ��°�� ȭ���� �׷��ִ� �Լ�(��� �� ��);
	}
}

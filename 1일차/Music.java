package soul_game2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player; // �ڹ� �ܿ� �ִ� ���̺귯��
	private boolean isLoop; //���ѹݺ����� �ѹ��� �ݺ��ϰ� ��������
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
			System.out.println(e.getMessage()+name+" "+isLoop);
		}
		
	}
	
	public int getTime() {
		if(player == null) {
			return 0;
		}
		return player.getPosition();
	}
	
	public void close() { // �׻� ������ �� �ֵ��� ����
		// ��̾�� �ڷΰ��� ������ �ش� ���� �����ϰ� ����ǵ���
		isLoop = false;
		player.close();
		this.interrupt(); // �ش� �����带 �������·� ����
	}
	
	@Override
	public void run() { // �����带 ����ϸ� ������ ����ؾ� �ϴ� �Լ�
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); 
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

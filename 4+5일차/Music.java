package soul_game2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player; // 자바 줌에 있는 라이브러리
	private boolean isLoop; //무한반복인지 한번만 반복하고 꺼지는지
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
	
	public void close() { // 항상 종료할 수 있도록 해줌
		// 재미없어서 뒤로가기 했을때 해당 곡이 안전하게 종료되도록
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 스레드를 중지상태로 만듦
	}
	
	@Override
	public void run() { // 쓰레드를 사용하면 무조건 사용해야 하는 함수
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

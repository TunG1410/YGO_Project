package thread;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayBackgroundMusicThread extends Thread {
	private String soundFile;
	private FloatControl gainControl;

	public PlayBackgroundMusicThread(String soundFile) {
		this.soundFile = soundFile;
	}
	
	public void run() {
		 try {
			 Thread.sleep(1000);
             File file = new File(soundFile);
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
             Clip clip = AudioSystem.getClip();
             clip.open(audioInputStream);
             clip.loop(Clip.LOOP_CONTINUOUSLY); // Lặp lại âm thanh liên tục
             
             // Lấy FloatControl để điều chỉnh mức âm thanh
             gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
             
             // Thiết lập mức âm thanh giảm 25dB
             gainControl.setValue(-35.0f);
             
             clip.start();
         } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
             e.printStackTrace();
         }
	}
	
	public void stopMusic() {
		gainControl.setValue(-80.0f);
	}
	
	public void continueMusic() {
		gainControl.setValue(-35.0f);
	}
	
}

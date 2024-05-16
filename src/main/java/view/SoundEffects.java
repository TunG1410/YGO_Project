package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundEffects {
	private static Boolean isON = true;

	private static void getSound(String soundFile, float volume) {
		try {
			File file = new File(soundFile);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume); // Max: 6.0206, Min: -80.0
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static Boolean getIsON() {
		return isON;
	}

	public static void setIsON(Boolean isON) {
		SoundEffects.isON = isON;
	}

	public static void activeEffectCardSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/ActiveEffectCard.wav", 5);
	}

	public static void cardDestroySound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/CardDestroy.wav", 0);
	}

	public static void clickSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/Click.wav", 0);
	}

	public static void closeGameSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/CloseGame.wav", -20);
	}

	public static void drawCardSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/DrawCard.wav", 6);
	}

	public static void duelEndSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/DuelEnd.wav", 0);
	}

	public static void exceptionSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/Exception.wav", 0);
	}

	public static void hoverCardSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/HoverCard.wav", -20);
	}

	public static void nextPhaseSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/NextPhase.wav", -5);
	}

	public static void selectCardSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/SelectCard.wav", -5);
	}

	public static void selectField() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/SelectField.wav", 0);
	}

	public static void summonMonsterSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/SummonMonster.wav", 0);
	}

	public static void swordHitSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/SwordHit.wav", 0);
	}

	public static void winnerSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/YuGiOhOSTs.wav", 0);
	}

	public static void lifePointSound() {
		if (!isON)
			return;
		getSound("src/main/resources/sound/LifePoint.wav", 0);
	}
}

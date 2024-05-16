package thread;

import view.GUI;

public class CountingTimeThread {

	private boolean paused = false;
	private final Object lock = new Object();
	private long hours;
	private long minutes;
	private long seconds;
	private GUI gui;

	public CountingTimeThread(GUI gui) {
		this.gui = gui;
	}

	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				int seconds1 = 0;
				while (true) {
					synchronized (lock) {
						while (paused) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

					hours = (seconds1 / (60 * 60)) % 24;
					minutes = (seconds1 / 60) % 60;
					seconds = (seconds1) % 60;
					gui.getTimeLabel().setText(hours + ":" + minutes + ":" + seconds);
					seconds1++;

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public String getTime() {
		return hours + ":" + minutes + ":" + seconds;
	}

	public void pause1() {
		synchronized (lock) {
			paused = true;
		}
	}

	public void resume1() {
		synchronized (lock) {
			paused = false;
			lock.notify();
		}
	}
}
package gioi.developer.pilacha_hd.sound;

import gioi.developer.pilacha_hd.R;
import android.content.Context;
import android.media.MediaPlayer;

public class MusicBackground {
	MediaPlayer mediaPlayer;

	/**
	 * Load dữ liệu
	 */
	public void loadMusic(Context mContext) {
		mediaPlayer = MediaPlayer.create(mContext, R.raw.backgroundmusic);
		mediaPlayer.setVolume(0.2f, 0.2f);
		mediaPlayer
				.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mp) {
						// Nhạc nền lặp đi lặp lại
						play();
					}
				});
	}

	public void play() {
		mediaPlayer.seekTo(0);
		mediaPlayer.start();
	}

	public void pause() {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
		}
	}

	public void resume() {
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
	}

	public void release() {
		mediaPlayer.release();
	}
}

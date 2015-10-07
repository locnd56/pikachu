package gioi.developer.pilacha_hd;

/**
 * Định nghĩa để lưu lại các giá trị cài đặt như bật/tắt nhạc nền
 * âm thanh, theme được chọn;
 */
import gioi.developer.pilacha_hd.config.Config;
import gioi.developer.pilacha_hd.log.MyLog;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
	public final String PREFS_NAME = "MyPrefs";
	SharedPreferences my_share;
	SharedPreferences.Editor editor;

	public MySharedPreferences(Context mContext) {
		my_share = mContext.getSharedPreferences(PREFS_NAME, 0);
		editor = my_share.edit();
	}

	// --------------------------------------------------
	/**
	 * Mặc định là mở âm thanh
	 */
	public void getIsSound() {
		Setting.isSound = my_share.getBoolean("isSound", true);
		MyLog.LogInfo("getIsSound = " + Setting.isSound);
	}

	/**
	 * mặc định là nhạc nền mở
	 */
	public void getIsMusic() {
		Setting.isMusic = my_share.getBoolean("isMusic", true);
	}

	/**
	 * Mặc định là theme 1
	 */
	public void getThemes() {
		Config.THEMES = my_share.getInt("THEMES", 1);
	}

	public void updateIsSound(boolean isSound) {
		Setting.isSound = isSound;
		editor.putBoolean("isSound", isSound);
		editor.commit();
		// MyLog.LogInfo("updateIsSound = " + isSound);
	}

	public void updateIsMusic(boolean isMusic) {
		Setting.isMusic = isMusic;
		editor.putBoolean("isMusic", isMusic);
		editor.commit();
	}

	public void updateThemes(int themes) {
		Config.THEMES = themes;
		editor.putInt("THEMES", themes);
		editor.commit();
	}

}

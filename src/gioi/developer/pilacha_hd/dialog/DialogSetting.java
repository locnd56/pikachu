package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.MySharedPreferences;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.Setting;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

/**
 * Hiện thị khi người dùng chọn setting. Người dùng có thể tắt bật nhạc nền cũng
 * như âm thanh trong game
 * 
 * @author VAN GIOI
 *
 */
public class DialogSetting extends Dialog implements
		android.view.View.OnClickListener {

	Button yes;
	Activity activity;
	CheckBox checkBox_music, checkBox_sound;

	MySharedPreferences mySharedPreferences;

	public DialogSetting(Context context) {
		super(context);
		UtilDialog.iniDialog(this);
		activity = (Activity) context;
		setContentView(R.layout.dialog_setting);

		mySharedPreferences = new MySharedPreferences(context);
		mySharedPreferences.getIsMusic();
		mySharedPreferences.getIsSound();

		// resize dialog
		RelativeLayout linearLayout1 = (RelativeLayout) findViewById(R.id.linearLayout1);
		Util.resizeDialog(linearLayout1);

		yes = (Button) findViewById(R.id.yes);
		yes.setOnClickListener(this);

		checkBox_music = (CheckBox) findViewById(R.id.checkBox_music);
		checkBox_music.setOnClickListener(this);
		checkBox_music.setChecked(Setting.isMusic);

		checkBox_sound = (CheckBox) findViewById(R.id.checkBox_sound);
		checkBox_sound.setOnClickListener(this);
		checkBox_sound.setChecked(Setting.isSound);
	}

	@Override
	public void onClick(View v) {
		MenuSetting.mSound.playClick();

		switch (v.getId()) {
		case R.id.yes:
			this.dismiss();
			break;
		case R.id.checkBox_music:
			Setting.isMusic = checkBox_music.isChecked();
			if (Setting.isMusic) {
				Play.mPlay.musicBackground.resume();
			} else {
				Play.mPlay.musicBackground.pause();
			}
			mySharedPreferences.updateIsMusic(Setting.isMusic);
			break;
		case R.id.checkBox_sound:
			Setting.isSound = checkBox_sound.isChecked();
			mySharedPreferences.updateIsSound(Setting.isSound);
			break;

		default:
			break;
		}

	}

}

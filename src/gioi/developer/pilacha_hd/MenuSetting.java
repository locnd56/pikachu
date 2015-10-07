package gioi.developer.pilacha_hd;

import gioi.developer.pilacha_hd.config.Config;
import gioi.developer.pilacha_hd.dialog.DialogExit;
import gioi.developer.pilacha_hd.sound.Sound;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Hiển thị giao diện Menu cho người dùng chọn các chức năng
 * 
 * @author Mr.Incredible
 *
 */
public class MenuSetting extends MyApp implements OnClickListener {
	Button btn_play, btn_help, btn_setting, btn_more, btn_exit, btn_top10;
	public static Sound mSound;
	MySharedPreferences mySharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		// mySharedPreferences = new MySharedPreferences(this);
		// mySharedPreferences.getIsMusic();
		// mySharedPreferences.getIsSound();
		// mySharedPreferences.getThemes();
		mSound = new Sound();
		mSound.loadSound(this);
		Config.getDisplayScreen(this);
		initView();
		initListener();
	}

	private void initView() {
		btn_exit = (Button) findViewById(R.id.exit);
		btn_play = (Button) findViewById(R.id.play);
		btn_setting = (Button) findViewById(R.id.setting);
		btn_help = (Button) findViewById(R.id.help);
		btn_top10 = (Button) findViewById(R.id.top10);
		btn_more = (Button) findViewById(R.id.more);
	}

	private void initListener() {
		btn_play.setOnClickListener(this);
		btn_help.setOnClickListener(this);
		btn_setting.setOnClickListener(this);
		btn_more.setOnClickListener(this);
		btn_exit.setOnClickListener(this);
		btn_top10.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			clickPlay();
			break;
		case R.id.help:
			clickHelp();
			break;
		case R.id.setting:
			clickSetting();
			break;
		case R.id.more:
			nextApplicationOther();
			break;
		case R.id.exit:
			clickExit();
			break;
		case R.id.top10:
			clickTop10();
			break;
		default:
			break;
		}
	}

	public void clickPlay() {
		try {
			Intent intent = new Intent(this, Play.class);
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickHelp() {
		try {
			Intent intent = new Intent(this, Help.class);
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickExit() {
		DialogExit dialogExit = new DialogExit(this);
		dialogExit.show();

	}

	public void clickSetting() {
		try {
			Intent intent = new Intent(this, Setting.class);
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void nextApplicationOther() {
		try {
			Intent marketIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://search?q=pub:Truong531.developer_inc"));
			startActivity(marketIntent);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickTop10() {
		try {
			Intent intent = new Intent(this, HeightDollar.class);
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		mSound.playClick();
		clickExit();
	}

}

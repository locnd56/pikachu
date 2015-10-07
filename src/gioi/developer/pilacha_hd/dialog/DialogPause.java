package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Hiện thị khi người dùng chọn trạng thái tạm dừng game. Sau khi tạm dừng game
 * thì người chơi có thể chọn các chức năng:
 *
 * + Reset: Chơi lại level hiện tại + Setting: Vào phần cài đặt + Menu: Quay lại
 * menu chính + Continue: Tiếp tục chơi
 *
 * @author VAN GIOI
 *
 */
public class DialogPause extends Dialog implements
		android.view.View.OnClickListener {
	Activity activity;

	public DialogPause(Context context) {
		super(context);
		UtilDialog.iniDialog(this);
		activity = (Activity) context;

		setContentView(R.layout.dialog_pause);

		// resize dialog
		RelativeLayout linearLayout1 = (RelativeLayout) findViewById(R.id.linearLayout1);
		Util.resizeDialog(linearLayout1);

		Button button_continue = (Button) findViewById(R.id.button_continue);
		button_continue.setOnClickListener(this);

		Button button_refresh = (Button) findViewById(R.id.button_refresh);
		button_refresh.setOnClickListener(this);

		Button button_setting = (Button) findViewById(R.id.button_setting);
		button_setting.setOnClickListener(this);

		Button button_level = (Button) findViewById(R.id.button_level);
		button_level.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		MenuSetting.mSound.playClick();

		switch (v.getId()) {
		case R.id.button_continue:
			this.dismiss();
			Play.mPlay.resumeGame();
			break;
		case R.id.button_refresh:
			this.dismiss();
			Play.mPlay.resetGame();
			break;
		case R.id.button_setting:
			showDialogSetting();
			break;
		case R.id.button_level:
			this.dismiss();
			Play.mPlay.finish();
			break;
		default:
			break;
		}
	}

	/**
	 * Hiện thị dialog setting
	 */
	public void showDialogSetting() {
		DialogSetting mDialogSetting = new DialogSetting(activity);
		mDialogSetting.show();
	}
}
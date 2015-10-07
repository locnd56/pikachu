package gioi.developer.pilacha_hd.components;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import gioi.developer.pilacha_hd.util.UtilFormat;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Hiện thị khi bắt đầu chơi game. Dialog cho biết bạn chơi level bao nhiêu,
 * thời gian chơi của level đó.
 * 
 * @author VAN GIOI
 *
 */
public class DialogPlay extends Dialog {
	Activity activity;

	/**
	 *
	 * @param context
	 * @param playnext
	 *            : Xác định là reset game hay là bắt đầu chơi mới
	 */
	public DialogPlay(Context context, final int playnext) {
		super(context);
		UtilDialog.iniDialog(this);
		activity = (Activity) context;

		setContentView(R.layout.dialog_play);

		// resize dialog
		LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
		Util.resizeDialog(linearLayout1);

		Button play = (Button) findViewById(R.id.play);
		play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MenuSetting.mSound.playClick();
				if (playnext == 0)
					Play.mPlay.startGame();
				else
					Play.mPlay.resetGame();
				DialogPlay.this.dismiss();
			}
		});

		TextView textView_level = (TextView) findViewById(R.id.textView_level);
		textView_level.setText("Level " + String.valueOf(Level.levelCurrent));

		TextView textView_time = (TextView) findViewById(R.id.textView_time);
		textView_time.setText(UtilFormat.getTime(Level.getTimeLevel()));
	}

}

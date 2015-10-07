package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.config.Config;
import gioi.developer.pilacha_hd.database.ClassDollar;
import gioi.developer.pilacha_hd.database.Database;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Hiện thị khi cần lưu điểm người chơi. Nếu người chơi đạt điểm top 10 thì
 * dialog này mới hiện thị. Khi lưu điểm người chơi chỉ cần nhập thêm tên.
 *
 * @author VAN GIOI
 *
 */
public class DialogSaveDollar extends Dialog {
	Activity activity;
	EditText editText_name;

	public DialogSaveDollar(final Context context) {
		super(context);
		UtilDialog.iniDialog(this);
		activity = (Activity) context;

		setContentView(R.layout.dialog_savedollar);

		// resize dialog
		RelativeLayout linearLayout = (RelativeLayout) findViewById(R.id.linearLayout);
		Util.resizeDialog(linearLayout);

		editText_name = (EditText) findViewById(R.id.editText_name);

		Button button_yes = (Button) findViewById(R.id.button_yes);
		button_yes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MenuSetting.mSound.playClick();

				// Nếu người chơi không nhập tên thì lấy tên mặc định là Player
				String name = editText_name.getText().toString();
				if (name.length() == 0) {
					name = "Player";
				}

				Database mDatabase = new Database(context);
				mDatabase.openDatabase();
				mDatabase.addDollar(new ClassDollar(name,
						Play.mPlay.dollar_current, Config.THEMES));
				mDatabase.closeDatabase();
				DialogSaveDollar.this.dismiss();
				Util.showToast(context, "Save success.");

				Play.mPlay.finish();
			}
		});

	}

}

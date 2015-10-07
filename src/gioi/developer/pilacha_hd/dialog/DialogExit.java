package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Hiển thị thông báo muốn thoát hay không
 * 
 * @author Mr.Incredible
 *
 */
public class DialogExit extends Dialog implements
		android.view.View.OnClickListener {

	private Context context;
	Button btn_yes, btn_no;
	ImageView iv_star;
	Activity activity;

	public DialogExit(Context context) {
		super(context);
		UtilDialog.iniDialog(this);
		activity = (Activity) context;
		setContentView(R.layout.dialog_exit);

		// Resize dialog
		RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.rl_layoutdialogexit1);
		Util.resizeDialog(layout1);
		initView();
		initListener();
	}

	private void initView() {
		btn_no = (Button) findViewById(R.id.no);
		btn_yes = (Button) findViewById(R.id.yes);
		iv_star = (ImageView) findViewById(R.id.icon_star);
	}

	private void initListener() {
		btn_no.setOnClickListener(this);
		btn_yes.setOnClickListener(this);
		iv_star.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.yes:
			this.dismiss();
			activity.finish();
			break;
		case R.id.no:
			this.dismiss();
			break;
		case R.id.icon_star:

			break;

		default:
			break;
		}
	}

}

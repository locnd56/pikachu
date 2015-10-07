package gioi.developer.pilacha_hd.util;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class UtilActivity {
	/**
	 * Yêu cầu 1 activity không có title và full màn hình
	 */
	public static void requestWindowFeature(Activity ac) {
		ac.requestWindowFeature(Window.FEATURE_NO_TITLE);
		ac.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
}

package gioi.developer.pilacha_hd.util;

import gioi.developer.pilacha_hd.R;
import android.app.Dialog;
import android.view.Window;

public class UtilDialog {
	/**
	 * Không hiển thị title của dialog và đặt background là 1 bức ảnh null, đồng
	 * thời đặt hiệu ứng khi xuất hiện và tắt dialog
	 */
	public static void iniDialog(Dialog dialog) {
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_null);
		dialog.setCancelable(false);
		dialog.getWindow().getAttributes().windowAnimations = R.style.Animations_Dialog;
	}
}

package gioi.developer.pilacha_hd.util;

import gioi.developer.pilacha_hd.config.Config;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class Util {
	/**
	 * Lấy ngẫu nhiên 1 giá trị từ min đến max
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomIndex(int min, int max) {
		return (int) ((Math.random() * (max - min + 1)) + min);
	}

	public static void showToast(Context mContext, String txt) {
		Toast.makeText(mContext, txt, Toast.LENGTH_LONG).show();
	}
	/**
	 * Resize Dialog
	 * @param v
	 */
	public static void resizeDialog(View v){
		if (Config.SCREENWIDTH < 800) {
            int h_new = v.getLayoutParams().height * (Config.SCREENWIDTH - 50) / v.getLayoutParams().width;
            v.getLayoutParams().height = h_new;
            v.getLayoutParams().width = Config.SCREENWIDTH - 50;
        }
	}
}

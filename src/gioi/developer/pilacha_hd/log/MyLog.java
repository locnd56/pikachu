package gioi.developer.pilacha_hd.log;

import android.util.Log;

public class MyLog {
	/**
	 * Quản lý việc log hay không log. Nếu cần bỏ log thì chỉ cần gán isLog =
	 * false;
	 */
	public static boolean islog = false;
	static String TAG_INFO = "TAG_INFO";
	static String TAG_ERROR = "TAG_ERROR";

	public static void LogInfo(String str) {
		if (islog) {
			Log.i(TAG_INFO, str);
		}
	}

	public static void LogError(String str) {
		if (islog) {
			Log.e(TAG_ERROR, str);
		}
	}
}

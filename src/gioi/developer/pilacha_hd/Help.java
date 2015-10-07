package gioi.developer.pilacha_hd;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Hiển thị giao diện hướng dẫn người chơi cách ăn đối tượng pikachu
 * 
 * @author Mr.Incredible
 *
 */
public class Help extends MyApp {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		Button btn_ok = (Button) findViewById(R.id.help_back);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

}

package gioi.developer.pilacha_hd;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SplassScreen extends MyApp {
	Button btn_start,btn_quit;
	Thread thread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splass_screen);
		btn_start = (Button) findViewById(R.id.start);
		btn_quit = (Button) findViewById(R.id.splassscreen_quit);
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				SystemClock.sleep(2000);
				Intent intent = new Intent(SplassScreen.this, MenuSetting.class);
				startActivity(intent);
			}
		});
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SplassScreen.this, MenuSetting.class);
				startActivity(intent);
			}
		});
		btn_quit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SplassScreen.this.finish();
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (thread != null) {
			thread.start();
		}
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onPause();
		thread.destroy();
	}

}

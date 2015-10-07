package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.components.Level;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Sau mỗi lần vượt qua 1 level thì dialog sẽ được hiển thị Dialog cho ta biết
 * thời gian hoàn thành level, số sao vào điểm thưởng
 * 
 * @author Mr.Incredible
 *
 */
public class DialogCompleted extends Dialog {
	Activity activity;
	RelativeLayout relativeLayout;
	Button btn_next, btn_menu;
	TextView tv_time, tv_bonus;
	ImageView iv_star1, iv_star2, iv_star3;
	int timeend;

	public DialogCompleted(Context context, int timeend) {
		super(context, timeend);
		this.timeend = timeend;
		UtilDialog.iniDialog(this);
		activity = (Activity) context;
		setContentView(R.layout.dialog_completed);
		initView();
		initData();
		initListener();
	}

	private void initView() {
		btn_next = (Button) findViewById(R.id.button_next);
		btn_menu = (Button) findViewById(R.id.button_level);
		tv_time = (TextView) findViewById(R.id.textView_time);
		tv_bonus = (TextView) findViewById(R.id.textView_bonus);
		iv_star1 = (ImageView) findViewById(R.id.imageView_star1);
		iv_star2 = (ImageView) findViewById(R.id.imageView_star2);
		iv_star3 = (ImageView) findViewById(R.id.imageView_star3);
	}

	private void initData() {
		// Xac dinh so sao dat duoc voi so thoi gian con lai cua nguoi choi
		int numberstar = Level.getStarByLevel(Level.levelCurrent, timeend);
		if (numberstar > 0) {
			iv_star1.setVisibility(View.VISIBLE);
		} else {
			iv_star1.setVisibility(View.GONE);
		}
		if (numberstar > 1) {
			iv_star2.setVisibility(View.VISIBLE);
		} else {
			iv_star2.setVisibility(View.GONE);
		}
		if (numberstar > 2) {
			iv_star3.setVisibility(View.VISIBLE);
		} else {
			iv_star3.setVisibility(View.GONE);
		}
		/**
		 * Tính điểm thưởng
		 * lv hiện tại * 1000;
		 * Nếu 1 sao thì + thêm 10000
		 * 2 sao thì 15000
		 * 3 sao thì 30000
		 * ko sao thì ko cộng
		 */
		int total_bonus = 0;
		total_bonus = Level.levelCurrent * 1000;
		switch (numberstar) {
		case 1:
			total_bonus += 10000;
			break;
		case 2:
			total_bonus += 15000;
			break;
		case 3:
			total_bonus += 30000;
			break;

		default:
			break;
		}
		//update lại điểm ở màn hình chính
		Play.mPlay.total_dollar = Play.mPlay.total_dollar + total_bonus;
        Play.mPlay.dollar_current = Play.mPlay.total_dollar;
        Play.mPlay.mDollar.updateDollar();
   
        tv_bonus.setText("+" + total_bonus);
        /*Dựa vào level vừa hoàn thành ta xác định xem đó có phải là level cuối cùng chưa
         * Nếu là level cuối cùng thì người chơi là người thắng cuộc.
         */   
         if(Level.levelCurrent > Level.totalLevel){
        
             btn_next.setVisibility(View.GONE);
             btn_menu.setVisibility(View.GONE);
        
             Button button_yes = (Button)findViewById(R.id.button_yes);
             button_yes.setVisibility(View.VISIBLE);
             button_yes.setOnClickListener(new View.OnClickListener() {           
                 @Override
                 public void onClick(View arg0) {
                     MenuSetting.mSound.playClick();
                     DialogCompleted.this.dismiss();
                
                     //Hiện thị dialog win. Vượt qua mọi level
                     Handler mHandler = new Handler();
                     mHandler.postDelayed(new Runnable() {       
                         @Override
                         public void run() {
                             //Hiện thị dialog người chơi thắng cuộc
//                             DialogWin mDialogWin = new DialogWin(context);
//                             mDialogWin.show();
                         }
                     }, 0);
                 }
             });
         }
	}

	private void initListener() {
		btn_next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MenuSetting.mSound.playClick();
				Play.mPlay.showDialogPlay(1);
				DialogCompleted.this.dismiss();
			}
		});
		btn_menu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MenuSetting.mSound.playClick();
				DialogCompleted.this.dismiss();
				activity.finish();
			}
		});
	}
}

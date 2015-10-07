package gioi.developer.pilacha_hd.dialog;

import gioi.developer.pilacha_hd.MenuSetting;
import gioi.developer.pilacha_hd.Play;
import gioi.developer.pilacha_hd.R;
import gioi.developer.pilacha_hd.components.Level;
import gioi.developer.pilacha_hd.util.Util;
import gioi.developer.pilacha_hd.util.UtilDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
* Hiện thị khi người chơi hết thời gian.
* Dialog sẽ cho bạn biết số dollar bạn có và level bạn đã vượt qua.
* @author VAN GIOI
*
*/
public class DialogGameOver extends Dialog implements
        android.view.View.OnClickListener {
 
    public DialogGameOver(Context context) {
        super(context);
        UtilDialog.iniDialog(this);
        MenuSetting.mSound.playGameOver();
        setContentView(R.layout.dialog_gameover);
     
        //resize dialog
        RelativeLayout linearLayout = (RelativeLayout)findViewById(R.id.linearLayout);
        Util.resizeDialog(linearLayout);
 
        //Hiện thị tổng số dollar và level
        TextView textView_dollar = (TextView) findViewById(R.id.textView_dollar);
        textView_dollar.setText(Play.mPlay.dollar_current + " - L."
                + Level.levelCurrent);
 
        Button button_yes = (Button) findViewById(R.id.button_yes);
        button_yes.setOnClickListener(this);
    }
 
    @Override
    public void onClick(View v) {
        MenuSetting.mSound.playClick();
        switch (v.getId()) {
        case R.id.button_yes:
            this.dismiss();
            Play.mPlay.finish();
            break;
        default:
            break;
        }
 
    }
 
}

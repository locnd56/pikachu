package gioi.developer.pilacha_hd;

import gioi.developer.pilacha_hd.config.Config;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.content.Context;
import android.os.Bundle;

/**
 * Thiet lap 1 so yeu cau can thiet
 * 
 * @author Mr.Incredible
 *
 */
public class Game extends BaseGameActivity {
	// Cac thuoc tinh
	public Camera mCamera = null;
	public Context mContext;
	public Engine mEngine = null;
	public Scene mScene = null;

	@Override
	protected void onCreate(Bundle pSavedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(pSavedInstanceState);
		mContext = this;
		this.getWindow().getAttributes().windowAnimations = R.style.Animations_Activity;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public Engine onLoadEngine() {
		this.mCamera = new Camera(0, 0, Config.SCREENWIDTH, Config.SCREENHEIGHT);
		this.mEngine = new Engine(new EngineOptions(true,
				Config.ScreenOrientation_DEFAULT, new RatioResolutionPolicy(
						Config.SCREENWIDTH, Config.SCREENHEIGHT), this.mCamera)
				.setNeedsSound(true).setNeedsMusic(true));

		return mEngine;
	}

	@Override
	public void onLoadResources() {
		// TODO Auto-generated method stub

	}

	@Override
	public Scene onLoadScene() {
		mScene = new Scene();
		mScene.setTouchAreaBindingEnabled(true);
		return this.mScene;
	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub

	}

}

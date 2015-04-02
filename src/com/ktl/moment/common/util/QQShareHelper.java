package com.ktl.moment.common.util;

import android.app.Activity;

import com.ktl.moment.config.AppConfig;
import com.tencent.tauth.Tencent;

public class QQShareHelper {
	
	private Tencent tencent;
	private Activity activity;
	
	public QQShareHelper(Activity activity){
		this.activity = activity;
		tencent = Tencent.createInstance(AppConfig.QQ_OPEN_FLAT_APP_ID, activity.getApplicationContext());
	}
	
	public Tencent getTencent(){
		return this.tencent;
	}
}

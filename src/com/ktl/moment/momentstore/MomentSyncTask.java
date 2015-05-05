package com.ktl.moment.momentstore;

import android.util.Log;

import com.ktl.moment.entity.Moment;
import com.ktl.moment.momentstore.MomentStoreUtil.syncLocalCallback;
import com.ktl.moment.utils.db.DBManager;

public class MomentSyncTask {

	private MomentSyncTaskManager mManager = null;
	private Moment mMoment = null;
	public MomentSyncTask(Moment moment,MomentSyncTaskManager manager) {
		// TODO Auto-generated constructor stub
		this.mManager = manager;
		this.mMoment = moment;
	}
	
	public boolean startTask(){
		if(this.mMoment == null || this.mManager == null){
			return false;
		}
		MomentStoreUtil momentStoreUtil = new MomentStoreUtil();
		momentStoreUtil.syncLocalMoment(mMoment, new syncLocalCallback() {
			
			@Override
			public void OnSuccess(Object res) {
				// TODO Auto-generated method stub
				mMoment.setDirty(0);
				DBManager.getInstance().update(mMoment,"dirty");//更新数据库里的dirty字段
				Log.i("MomentUpdae", mMoment.getDirty()+"");
				mManager.finishSync(res);
			}
			
			@Override
			public void OnFailed(String msg) {
				// TODO Auto-generated method stub
				mManager.killSync(msg);
			}
		});
		return true;
	}

}
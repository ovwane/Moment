package com.ktl.moment.android.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ktl.moment.R;
import com.ktl.moment.android.activity.MomentDialogActivity;
import com.ktl.moment.android.adapter.MomentPlaAdapter;
import com.ktl.moment.android.base.BaseFragment;
import com.ktl.moment.android.component.etsy.StaggeredGridView;
import com.ktl.moment.entity.Moment;

public class MomentFragment extends BaseFragment {

	private static final String TAG = "MomentFragment";

	private StaggeredGridView staggeredGridView;
	private List<Moment> momentList;
	private MomentPlaAdapter momentPlaAdapter;
	private OperateCallback opCallback;

	private static final int REAUEST_CODE_OPEN = 1000;
	private static final int REAUEST_CODE_LABEL = 1001;
	private static final int REQUEST_CODE_DELETE = 1002;

	public interface OperateCallback {
		public void OnSelected(int type, int position);

		public void OnError(String msg);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater
				.inflate(R.layout.fragment_moment, container, false);
		staggeredGridView = (StaggeredGridView) view
				.findViewById(R.id.moment_pla_list);

		opCallback = new OperateCallback() {

			@Override
			public void OnSelected(int type, int position) {
				// TODO Auto-generated method stub
				Intent dialogIntent = new Intent(getActivity(),
						MomentDialogActivity.class);
				dialogIntent.putExtra("position", position);
				if(momentList.get(position).getIsPublic() == 1){
					dialogIntent.putExtra("isPublic", 1);
				}else{
					dialogIntent.putExtra("isPublic", 0);
				}
				startActivityForResult(dialogIntent, REAUEST_CODE_OPEN);
			}

			@Override
			public void OnError(String msg) {
				// TODO Auto-generated method stub

			}
		};

		momentList = new ArrayList<Moment>();
		getData();
		momentPlaAdapter = new MomentPlaAdapter(getActivity(), momentList,
				getDisplayImageOptions(), opCallback);
		momentPlaAdapter.notifyDataSetChanged();
		staggeredGridView.setAdapter(momentPlaAdapter);

		return view;
	}

	/**
	 * 从服务器拉取数据
	 */
	private void getData() {
		if (momentList == null) {
			momentList = new ArrayList<Moment>();
		}
		for (int i = 0; i < 20; i++) {
			Moment moment = new Moment();
			moment.setMomentId(i);
			moment.setPostTime("4月10日");
			if (i % 3 == 0) {
				moment.setPublic(1);
			}
			if (i % 4 == 0) {
				moment.setCollect(1);
			}
			moment.setTitle(i + "不再懊悔 App 自动生成器");
			String content = "隔壁小禹说，10 年前，他就有做叫车服务的想法。对面小 S 说";
			moment.setContent(content);
			moment.setLabel("创意、果蔬");
			if (i % 2 == 1) {
				moment.setMomentImg("http://7sbpmg.com1.z0.glb.clouddn.com/1.jpg");
			} else {
				moment.setMomentImg(null);
			}
			momentList.add(moment);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
			case REAUEST_CODE_OPEN: {
				boolean isOpen = data.getBooleanExtra("isClick", false);
				int position = data.getIntExtra("position", 0);
				if (isOpen) {
					if(momentList.get(position).getIsPublic() == 1){
						momentList.get(position).setPublic(0);
					}else{
						momentList.get(position).setPublic(1);
					}
					momentPlaAdapter.notifyDataSetChanged();
				}
				break;
			}
			case REAUEST_CODE_LABEL:

				break;
			case REQUEST_CODE_DELETE:

				break;
			default:
				break;
			}
		}
	}

}

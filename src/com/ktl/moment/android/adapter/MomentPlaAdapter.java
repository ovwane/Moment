package com.ktl.moment.android.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktl.moment.R;
import com.ktl.moment.entity.Moment;
import com.ktl.moment.utils.StrUtils;
import com.ktl.moment.utils.TimeFormatUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MomentPlaAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater layoutInflater;
	private List<Moment> momentList;
	private DisplayImageOptions options;

	public MomentPlaAdapter(Context context, List<Moment> momentList,
			DisplayImageOptions options) {
		this.context = context;
		this.momentList = momentList;
		this.options = options;

		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return momentList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return momentList.get(position);
		// return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MomentPlaHolder momentHolder;
		if (convertView == null) {
			Log.i("position-->", position + "");
			convertView = this.layoutInflater.inflate(
					R.layout.fragment_moment_etsy_list_item, null, false);
			momentHolder = new MomentPlaHolder();
			momentHolder.createDate = (TextView) convertView.findViewById(R.id.moment_create_date);
			momentHolder.publicText = (TextView) convertView.findViewById(R.id.moment_is_public);
			momentHolder.collectImg = (ImageView) convertView.findViewById(R.id.moment_is_collect_img);
			momentHolder.articleImg = (ImageView) convertView.findViewById(R.id.moment_article_img);
			momentHolder.articleTitle = (TextView) convertView.findViewById(R.id.moment_article_title);
			momentHolder.articleAbstract = (TextView) convertView.findViewById(R.id.moment_article_abstract);
			momentHolder.label = (ImageView) convertView.findViewById(R.id.moment_label_img);
			momentHolder.labelText = (TextView) convertView.findViewById(R.id.moment_label_text);
			momentHolder.momentItemLayout = (LinearLayout) convertView.findViewById(R.id.moment_item_layout);
			momentHolder.audioImg = (ImageView) convertView.findViewById(R.id.moment_record_img);
			momentHolder.dirtyImg = (ImageView) convertView.findViewById(R.id.moment_dirty_moment);
			convertView.setTag(momentHolder);
		} else {
			momentHolder = (MomentPlaHolder) convertView.getTag();
		}
		Moment moment = momentList.get(position);
		if (moment.getPostTime() == null || moment.getPostTime() == ""
				|| moment.getPostTime().equals("")) {
			momentHolder.createDate.setText("未知");
		} else {
			momentHolder.createDate.setText(TimeFormatUtil.formatDate(moment
					.getPostTime()));
		}

		if (moment.getIsClipper() == 1) {
			momentHolder.publicText.setVisibility(View.GONE);
			momentHolder.collectImg.setVisibility(View.VISIBLE);
		} else {
			momentHolder.collectImg.setVisibility(View.GONE);
			momentHolder.publicText.setVisibility(View.VISIBLE);
			if (moment.getIsPublic() == 1) {
				momentHolder.publicText.setText("公开");
				momentHolder.publicText.setTextColor(this.context
						.getResources().getColor(
								R.color.moment_etsy_public_color));
			} else {
				momentHolder.publicText.setText("不公开");
				momentHolder.publicText.setTextColor(this.context
						.getResources()
						.getColor(R.color.moment_etsy_text_color));
			}
		}
		if (moment.getMomentImgs() == null || moment.getMomentImgs().equals("")
				|| moment.getMomentImgs() == "") {
			momentHolder.articleImg.setVisibility(View.GONE);
		} else {
			momentHolder.articleImg.setVisibility(View.VISIBLE);
			Log.i("MomentImage", "-->" + moment.getMomentImgs());
			ImageLoader.getInstance().displayImage(moment.getMomentImgs(),
					momentHolder.articleImg, this.options);
		}
		momentHolder.articleTitle.setText(moment.getTitle());
		momentHolder.articleAbstract.setText(moment.getContentAbstract());
		momentHolder.label.setImageResource(R.drawable.label);
		if (StrUtils.isEmpty(moment.getLabel())) {
			momentHolder.labelText.setText("暂无标签");
		} else {
			momentHolder.labelText.setText(StrUtils.subString(moment.getLabel(),8));
		}
		if (!StrUtils.isEmpty(moment.getAudioUrl())) {
			momentHolder.audioImg.setVisibility(View.VISIBLE);
		}else{
			momentHolder.audioImg.setVisibility(View.GONE);
		}
		//本地图标
		if(moment.getDirty() == 1){
			momentHolder.dirtyImg.setVisibility(View.VISIBLE);
		}else{
			momentHolder.dirtyImg.setVisibility(View.GONE);
		}
		return convertView;
	}

	static class MomentPlaHolder {
		TextView createDate;
		TextView publicText;
		ImageView collectImg;
		ImageView articleImg;
		TextView articleTitle;
		TextView articleAbstract;
		ImageView label;
		TextView labelText;
		LinearLayout momentItemLayout;
		ImageView audioImg;
		ImageView dirtyImg;
	}
}

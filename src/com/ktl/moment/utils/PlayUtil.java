package com.ktl.moment.utils;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayUtil implements OnBufferingUpdateListener, OnPreparedListener {
	private SeekBar seekbar;
	private Handler handler;
	private RecordPlaySeekbarUtil seekbarUtil;
	private String path;
	private MediaPlayer player;
	private int duration;
	private boolean isAuto = false;

	private TextView playStatusTv;
	private TextView playTime;

	public PlayUtil(SeekBar seekbar, Handler handler, String path,
			TextView playStatusTv, TextView playTime) {
		this.seekbar = seekbar;
		this.handler = handler;
		this.path = path;
		this.playStatusTv = playStatusTv;
		this.playTime = playTime;

		// this.seekbar.setEnabled(false);
		seekbarUtil = new RecordPlaySeekbarUtil(this.seekbar, this.handler);

		player = new MediaPlayer();
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		player.setOnBufferingUpdateListener(this);
		player.setOnPreparedListener(this);
	}

	public void initPlayer() {
		if (player == null) {
			player = new MediaPlayer();
		}
		try {
			player.reset();
			player.setDataSource(path);
			player.prepare();
			duration = player.getDuration();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub
		seekbar.setSecondaryProgress(percent);
		Log.i("percent", percent + "");
	}

	public void startPlay() {
		player.start();
		Log.i("start duration", duration + "");
		seekbarUtil.startSeekBar(duration / 1000);
	}

	public void pausePlay() {
		player.pause();
		seekbarUtil.pauseSeekBar();
	}

	public void continuePlay() {
		player.start();
		seekbarUtil.restartSeekBar(duration / 1000);
	}

	public void stopPlay() {
		if (player != null) {
			player.stop();
			player.release();
			player = null;
			seekbarUtil.stopSeekBar();
		}
	}

	public int getDuration() {
		Log.i("get duration", duration + "");
		return duration;
	}

	public void stopSeekbar() {
		seekbarUtil.stopSeekBar();
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		// duration = mp.getDuration();
		String time = TimerCountUtil.getInstance().turnInt2Time(
				duration / 1000 + 1);
		playTime.setText(time);
		playStatusTv.setText("加载完成");

		Log.i("prepare", "prepare ok" + duration);
		if (isAuto && mp == player) {
			startPlay();
		}
	}

	public void setIsAutoPlay(boolean isAuto) {
		this.isAuto = isAuto;
	}

}

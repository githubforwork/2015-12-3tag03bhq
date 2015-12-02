package com.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bhq.R;
import com.bhq.app.AppConfig;
import com.bhq.app.AppContext;
import com.bhq.bean.Apk;
import com.bhq.bean.Result;
import com.bhq.bean.ResultDeal;
import com.bhq.common.ConnectionHelper;
import com.bhq.common.FileHelper;
import com.bhq.common.utils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateApkInBackground extends Service
{
	private static final String TAG = "NotificationService";

	public static final String ACTION_NOTIFICATION_CONTROL = "action_notification_control";
	public static final String KEY_COMMAND_SHOW = "show_notification";
	public static final String KEY_COMMAND_UPDATE = "update_notification";
	public static final String KEY_COMMAND_REMOVE = "remove_notification";

	public static final String TIME_KEY = "time_key";
	public static final int NOTIFICATIN_ID = 100;
	String action;
	private Notification mNotification;
	private NotificationManager manager;
	private PendingIntent pendingIntent;
	private Intent intent;

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		action = intent.getAction();
		getListData();
		return super.onStartCommand(intent, flags, startId);
	}

	/*
	 * 创建Notification对象
	 */
	public void createNotification()
	{
		if (mNotification == null)
		{
			mNotification = new Notification();
			mNotification.icon = R.drawable.appicon;
			mNotification.flags |= Notification.FLAG_AUTO_CANCEL;// 表示正处于活动中
			mNotification.flags |= Notification.FLAG_SHOW_LIGHTS;
			intent = new Intent(this, UpdateApkInBackground.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
			mNotification.contentIntent = pendingIntent;

			RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_layout);

			contentView.setImageViewResource(R.id.content_view_image, R.drawable.appicon);
			mNotification.contentView = contentView;
		}
		startForeground(NOTIFICATIN_ID, mNotification);

	}

	// 打开APK程序代码

	private void openFile(File file)
	{
		// TODO Auto-generated method stub
		Log.e("OpenFile", file.getName());
		Intent intent = new Intent();

		startActivity(intent);
	}

	private void getListData()
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String params = ConnectionHelper.setParams("APP.getReNewInfo", "0", hashMap);
		new HttpUtils().send(HttpRequest.HttpMethod.POST, AppConfig.dataBaseUrl, ConnectionHelper.getParas(params), new RequestCallBack<String>()
		{
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo)
			{
				String a = responseInfo.result;
				List<Apk> listNewData = null;
				Result result = JSON.parseObject(responseInfo.result, Result.class);
				if (result.getResultCode() == 200)// 连接数据库成功
				{
					listNewData = JSON.parseArray(ResultDeal.getAllRow(result), Apk.class);
					if (listNewData == null)
					{
						listNewData = new ArrayList<Apk>();
					} else
					{
						Apk apk = listNewData.get(0);
						PackageInfo packageInfo = null;
						try
						{
							packageInfo = UpdateApkInBackground.this.getApplicationContext().getPackageManager().getPackageInfo(UpdateApkInBackground.this.getPackageName(), 0);
						} catch (NameNotFoundException e)
						{
							e.printStackTrace();
						}
						String localVersion = packageInfo.versionName;
						if (localVersion.equals(apk.getVersion()))
						{
							Toast.makeText(UpdateApkInBackground.this, "当前版本已经是最新版本!", Toast.LENGTH_SHORT).show();
						} else
						{
							File file = new File(AppConfig.apkpath);
							FileHelper.RecursionDeleteFile(file);
							if (ACTION_NOTIFICATION_CONTROL.equals(action))
							{
								createNotification();
								downloadApk(AppConfig.url + apk.getUrl(), AppConfig.apkpath);
							} else
							{
								Log.e(TAG, "illegality action:" + action);
							}
						}
					}
				} else
				{
					AppContext.makeToast(UpdateApkInBackground.this, "error_connectDataBase");
					return;
				}

			}

			@Override
			public void onFailure(HttpException error, String msg)
			{
				AppContext.makeToast(UpdateApkInBackground.this, "error_connectServer");
			}
		});
	}

	public void downloadApk(String path, final String target)
	{
		String sss = path;
		HttpUtils http = new HttpUtils();
		http.download(path, target, true, true, new RequestCallBack<File>()
		{
			@Override
			public void onStart()
			{
				super.onStart();
			}

			@Override
			public void onLoading(long total, long current, boolean isUploading)
			{
				super.onLoading(total, current, isUploading);
				int jd = Integer.valueOf(utils.getRateoffloat(current, total));
				mNotification.contentView.setTextViewText(R.id.content_view_text1, jd + "%");
				mNotification.contentView.setProgressBar(R.id.content_view_progress, 100, jd, false);
				startForeground(NOTIFICATIN_ID, mNotification);
			}

			@Override
			public void onFailure(HttpException error, String msg)
			{
				if (msg.equals("maybe the file has downloaded completely"))
				{
					Toast.makeText(UpdateApkInBackground.this, "下载成功!", Toast.LENGTH_SHORT).show();
				} else
				{
					Toast.makeText(UpdateApkInBackground.this, "更新失败!", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onSuccess(ResponseInfo<File> responseInfo)
			{
				File file = new File(target);
				if (!file.exists())
				{
				}
				mNotification.contentView.setTextViewText(R.id.content_view_text1, "下载成功！请点击安装！");
				mNotification.defaults = Notification.DEFAULT_SOUND;
				Toast.makeText(UpdateApkInBackground.this, "下载完成，请在通知栏点击安装！", Toast.LENGTH_LONG).show();
				Intent updateIntent = new Intent(Intent.ACTION_VIEW);
				updateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				updateIntent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
				startActivity(updateIntent);
				pendingIntent = PendingIntent.getActivity(UpdateApkInBackground.this, 0, updateIntent, 0);
				mNotification.contentIntent = pendingIntent;
				startForeground(NOTIFICATIN_ID, mNotification);
			}
		});
	}

}

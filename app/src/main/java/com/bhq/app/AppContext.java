package com.bhq.app;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.widget.Toast;

import com.bhq.bean.dt_manager;
import com.bhq.common.SqliteDb;
import com.bhq.common.StringUtils;

/**
 * @author :sima
 * @version :
 * @createTime：2015-8-6 下午1:50:43
 * @description :全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 */
public class AppContext extends Application
{
	public static final String Progress_SynchronousData = "Progress_SynchronousData";
	public final static String ACTION_REFRESH_ANIMAL = "REFRESH_ANIMAL";
	public final static String ACTION_REFRESH_PEST = "REFRESH_PEST";
	public final static String ACTION_REFRESH_INTERFERE = "REFRESH_INTERFERE";
	public final static String ACTION_REFRESH_FACILITY = "REFRESH_FACILITY";
	public final static String ACTION_REFRESH_PLANT = "REFRESH_PLANT";
	public final static String BROADCAST_MAP_MORE = "MAP_MORE";
	public final static String BROADCAST_OPENDL = "OPENDL";
	public final static int TIME_STOPWATCH = 1001;
	public final static int DISTANCEBETWEEN = 1002;
	public static final int PAGE_SIZE = 10;// 默认分页大小
	String LOCATION_X = "";// 当前坐标
	String LOCATION_Y = "";// 当前坐标
	String XHID = "";// 巡护id

	public void setXHID(String xHID)
	{
		XHID = xHID;
	}

	public String getXHID()
	{
		return XHID;
	}

	public void setLOCATION_X(String lOCATION_X)
	{
		LOCATION_X = lOCATION_X;
	}

	public String getLOCATION_X()
	{
		return LOCATION_X;
	}

	public void setLOCATION_Y(String lOCATION_Y)
	{
		LOCATION_Y = lOCATION_Y;
	}

	public String getLOCATION_Y()
	{
		return LOCATION_Y;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		AppException appException = AppException.getInstance();
		// 注册crashHandler
		appException.init(getApplicationContext());
		// 发送以前没发送的报告(可选)
		appException.sendPreviousReportsToServer();
	}

	/**
	 * 应用程序是否发出提示音
	 * 
	 * @return
	 */
	public boolean isAppSound()
	{
		return isAudioNormal() && isVoice();
	}

	/**
	 * 检测当前系统声音是否为正常模式
	 * 
	 * @return
	 */
	public boolean isAudioNormal()
	{
		AudioManager mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
		return mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
	}

	/**
	 * 是否发出提示音
	 * 
	 * @return
	 */
	public boolean isVoice()
	{
		String perf_voice = getProperty(AppConfig.CONF_VOICE);
		// 默认是开启提示声音
		if (StringUtils.isEmpty(perf_voice))
			return true;
		else
			return StringUtils.toBool(perf_voice);
	}

	public String getProperty(String key)
	{
		return AppConfig.getAppConfig(this).get(key);
	}

	/**
	 * @description:提示信息
	 * @createTime：2015-8-11 上午10:43:42
	 * @param ctx
	 *            上下文
	 * @param type
	 *            提示类型
	 */
	public static void makeToast(Context ctx, String type)
	{
		if (type.equals("load_error"))
		{
			Toast.makeText(ctx, "加载异常!", Toast.LENGTH_SHORT).show();
		} else if (type.equals("error_connectDataBase"))
		{
			Toast.makeText(ctx, "连接数据库异常！", Toast.LENGTH_SHORT).show();
		} else if (type.equals("error_connectServer"))
		{
			Toast.makeText(ctx, "连接服务器异常！", Toast.LENGTH_SHORT).show();
		} else if (type.equals("exception_network"))
		{
			Toast.makeText(ctx, "网络异常！", Toast.LENGTH_SHORT).show();
		} else if (type.equals(""))
		{
			Toast.makeText(ctx, "", Toast.LENGTH_SHORT).show();
		} else if (type.equals(""))
		{
			Toast.makeText(ctx, "", Toast.LENGTH_SHORT).show();
		} else if (type.equals(""))
		{
			Toast.makeText(ctx, "", Toast.LENGTH_SHORT).show();
		}
	}

	public static dt_manager getUserInfo(Context context)
	{
		dt_manager dt_manager = (dt_manager) SqliteDb.getCurrentUser(context, dt_manager.class);
		return dt_manager;
	}
}

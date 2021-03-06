package com.bhq.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bhq.app.AppConfig;
import com.bhq.app.AppContext;
import com.bhq.bean.FJ_SCFJ;
import com.bhq.bean.Result;
import com.bhq.bean.ResultDeal;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.HashMap;
import java.util.List;

/**
 * @author :sima
 * @version :1.0
 * @createTime：2015-8-13 下午4:46:59
 * @description :图片帮助类
 */
public class BitmapHelper
{
	private BitmapHelper()
	{
	}

	private static BitmapUtils bitmapUtils;

	public static void loadImage(Context context, ImageView imageView, String ZPDZ)
	{
		if (bitmapUtils == null)
		{
			bitmapUtils = new BitmapUtils(context);
		}
		// bitmapUtils.configDefaultLoadingImage(R.drawable.loading_0);
		// bitmapUtils.configDefaultLoadFailedImage(R.drawable.loading_0);
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
		bitmapUtils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(context).scaleDown(3));
		bitmapUtils.display(imageView, ZPDZ);
		// 加载网络图片
		// bitmapUtils.display(imageView,
		// "http://bbs.lidroid.com/static/image/common/logo.png");
		// 加载本地图片(路径以/开头， 绝对路径)
		// bitmapUtils.display(imageView, "/sdcard/test.jpg");
		// 加载assets中的图片(路径以assets开头)
		// bitmapUtils.display(imageView, "assets/img/wallpaper.jpg");
	}

	/**
	 * @description:设置图片自适应imageview
	 * @createTime：2015-8-20 下午7:01:43
	 * @param context
	 * @param imageView
	 * @param ZPDZ
	 */
	public static void setImageView(Context context, ImageView imageView, String ZPDZ)
	{
		if (bitmapUtils == null)
		{
			bitmapUtils = new BitmapUtils(context);
		}
		// bitmapUtils.configDefaultLoadingImage(R.drawable.loading_0);
		// bitmapUtils.configDefaultLoadFailedImage(R.drawable.loading_0);
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
		bitmapUtils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(context).scaleDown(3));
		bitmapUtils.display(imageView, ZPDZ, new CustomBitmapLoadCallBack());
	}

	/**
	 * @description:设置图片平铺imageview
	 * @createTime：2015-8-20 下午7:01:36
	 * @param context
	 * @param imageView
	 * @param ZPDZ
	 */
	public static void setImageViewBackground(Context context, ImageView imageView, String ZPDZ)
	{
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPoolSize(20).build();
		ImageLoader.getInstance().init(config);
		DisplayImageOptions options = new DisplayImageOptions.Builder().delayBeforeLoading(0).bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(0)).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();
		ImageLoader.getInstance().displayImage(ZPDZ, imageView, options);
	}

	/**
	 * 
	 * @author sunglasses
	 * @category 图片回调函数
	 */
	static class CustomBitmapLoadCallBack extends DefaultBitmapLoadCallBack<ImageView>
	{
		public CustomBitmapLoadCallBack()
		{
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onLoading(ImageView container, String uri, BitmapDisplayConfig config, long total, long current)
		{
		}

		@Override
		public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from)
		{
			// super.onLoadCompleted(container, uri, bitmap, config, from);
			fadeInDisplay(container, bitmap);
		}

		@Override
		public void onLoadFailed(ImageView container, String uri, Drawable drawable)
		{
			// TODO Auto-generated method stub
		}
	}

	/**
	 * @author sunglasses
	 * @category 图片加载效果
	 * @param imageView
	 * @param bitmap
	 */
	private static void fadeInDisplay(ImageView imageView, Bitmap bitmap)
	{// 目前流行的渐变效果
		final TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[] { TRANSPARENT_DRAWABLE, new BitmapDrawable(imageView.getResources(), bitmap) });
		imageView.setImageDrawable(transitionDrawable);
		transitionDrawable.startTransition(500);
	}

	private static final ColorDrawable TRANSPARENT_DRAWABLE = new ColorDrawable(android.R.color.transparent);

	/**
	 * @description:设置图片自适应imageview
	 * @createTime：2015-8-20 下午6:56:38
	 * @param context
	 * @param glid
	 * @param imageView
	 */
	public static void setImageView(final Context context, String glid, final ImageView imageView)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("GLID", glid);
		hashMap.put("FJLX", "1");
		String params = ConnectionHelper.setParams("APP.SelectFJ_SCFJ", "0", hashMap);
		new HttpUtils().send(HttpRequest.HttpMethod.POST, AppConfig.dataBaseUrl, ConnectionHelper.getParas(params), new RequestCallBack<String>()
		{
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo)
			{

				List<FJ_SCFJ> list_FJ_SCFJ = null;
				Result result = JSON.parseObject(responseInfo.result, Result.class);
				if (result.getResultCode() == 200)// 连接数据库成功
				{
					list_FJ_SCFJ = JSON.parseArray(ResultDeal.getAllRow(result), FJ_SCFJ.class);
					if (list_FJ_SCFJ == null)
					{
						return;
					}
					BitmapHelper.setImageView(context, imageView, AppConfig.url + list_FJ_SCFJ.get(0).getFJLJ());
				} else
				{
					AppContext.makeToast(context, "error_connectDataBase");
					return;
				}

			}

			@Override
			public void onFailure(HttpException error, String msg)
			{
				Toast.makeText(context, "获取失败", Toast.LENGTH_SHORT).show();
			}
		});
	}

	/**
	 * @description:设置图片平铺imageview
	 * @createTime：2015-8-20 下午6:55:59
	 * @param context
	 * @param glid
	 * @param imageView
	 */
	public static void setImageViewBackground(final Context context, String glid, final ImageView imageView)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("GLID", glid);
		hashMap.put("FJLX", "1");
		String params = ConnectionHelper.setParams("APP.SelectFJ_SCFJ", "0", hashMap);
		new HttpUtils().send(HttpRequest.HttpMethod.POST, AppConfig.dataBaseUrl, ConnectionHelper.getParas(params), new RequestCallBack<String>()
		{
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo)
			{
				List<FJ_SCFJ> list_FJ_SCFJ = null;
				Result result = JSON.parseObject(responseInfo.result, Result.class);
				if (result.getResultCode() == 200)// 连接数据库成功
				{
					list_FJ_SCFJ = JSON.parseArray(ResultDeal.getAllRow(result), FJ_SCFJ.class);
					if (list_FJ_SCFJ == null)
					{
						return;
					}
				} else
				{
					AppContext.makeToast(context, "error_connectDataBase");
					return;
				}
				setImageViewBackground(context, imageView, AppConfig.url + list_FJ_SCFJ.get(0).getFJLJ());
			}

			@Override
			public void onFailure(HttpException error, String msg)
			{
				Toast.makeText(context, "获取失败", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public static Bitmap getVideoThumbnail(String videoPath, int width, int height, int kind)
	{
		// 获取视频的缩略图
		Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		return bitmap;
	}
}

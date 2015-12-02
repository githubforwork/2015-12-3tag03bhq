package com.bhq.bean;

import com.bhq.app.AppConfig;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Description: SJ_SBXXFJ 实体类
 * 
 * Copyright: Copyright (c) 2015
 * 
 * Company: 广州海川信息科技有限公司
 * 
 * @version 1.0 时间 2015-3-3
 */
@Table(name = "SJ_SBXXFJ")
public class SJ_SBXXFJ extends Entity
{

	Boolean Change;

	public void setChange(Boolean change)
	{
		Change = change;
	}

	public Boolean getChange()
	{
		return Change;
	}

	private boolean HASUPLOAD;
	private String FJBDLJ;
	private String SCLJ;

	public void setHASUPLOAD(boolean hASUPLOAD)
	{
		HASUPLOAD = hASUPLOAD;
	}

	public boolean getHASUPLOAD()
	{
		return HASUPLOAD;
	}

	public void setFJBDLJ(String fJBDLJ)
	{
		FJBDLJ = fJBDLJ;
	}

	public String getFJBDLJ()
	{
		return FJBDLJ;
	}

	public void setSCLJ(String sCLJ)
	{
		SCLJ = sCLJ;
	}

	public String getSCLJ()
	{
		return SCLJ;
	}

	/**
	 * 包含文件类型如.png
	 *
	 * @return
	 */
	public String FJBDLJToFJMC(String FJLJ)
	{
		String fileName = FJLJ.substring(FJLJ.lastIndexOf("/") + 1, FJLJ.length());
		return fileName;
	}

	/**
	 * 服务器数据库填写的路径
	 * 
	 * @param FJBDLJ
	 * @return
	 */
	public String FJBDLJToFJLJ(String FJBDLJ)
	{
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String PATH = "upload/SJFJ/" + date + "/" + FJBDLJToFJMC(FJBDLJ);
		return PATH;
	}

	/**
	 * 附件在服务器上的存放路径
	 * 
	 * @param FJBDLJ
	 * @return
	 */
	public String FJBDLJToSCLJ(String FJBDLJ)
	{
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String PATH = AppConfig.UPLOADPATH + "XXCJFJ/" + date + FJBDLJToFJMC(FJBDLJ);// 可以任意设置存放位置，不一定要放在相对路径下面
		return PATH;
	}

	int id;
	/** identifier field */

	@Id
	private String FJID;

	/** identifier field */

	private String SJID;

	/** identifier field */

	private String GLID;

	/** identifier field */

	private String FJMC;

	/** identifier field */

	private String FJLJ;

	/** identifier field */

	private String SCSJ;

	/** identifier field */

	private String SCR;

	/** identifier field */

	private String SCRXM;

	/** identifier field */

	private String FJLX;

	/** identifier field */

	private Boolean SFSC;

	/** identifier field */

	private Boolean SCZT;

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	/**
	 * @return 返回 附件ID
	 */
	public String getFJID()
	{
		return FJID;
	}

	/**
	 * @param FJID
	 *            要设置的 附件ID
	 */
	public void setFJID(String FJID)
	{
		this.FJID = FJID;
	}

	/**
	 * @return 返回 事件ID
	 */
	public String getSJID()
	{
		return SJID;
	}

	/**
	 * @param SJID
	 *            要设置的 事件ID
	 */
	public void setSJID(String SJID)
	{
		this.SJID = SJID;
	}

	/**
	 * @return 返回 关联ID
	 */
	public String getGLID()
	{
		return GLID;
	}

	/**
	 * @param GLID
	 *            要设置的 关联ID
	 */
	public void setGLID(String GLID)
	{
		this.GLID = GLID;
	}

	/**
	 * @return 返回 附件名称
	 */
	public String getFJMC()
	{
		return FJMC;
	}

	/**
	 * @param FJMC
	 *            要设置的 附件名称
	 */
	public void setFJMC(String FJMC)
	{
		this.FJMC = FJMC;
	}

	/**
	 * @return 返回 附件路径
	 */
	public String getFJLJ()
	{
		return FJLJ;
	}

	/**
	 * @param FJLJ
	 *            要设置的 附件路径
	 */
	public void setFJLJ(String FJLJ)
	{
		this.FJLJ = FJLJ;
	}

	/**
	 * @return 返回 上传时间
	 */
	public String getSCSJ()
	{
		return SCSJ;
	}

	/**
	 * @param SCSJ
	 *            要设置的 上传时间
	 */
	public void setSCSJ(String SCSJ)
	{
		this.SCSJ = SCSJ;
	}

	/**
	 * @return 返回 上传人
	 */
	public String getSCR()
	{
		return SCR;
	}

	/**
	 * @param SCR
	 *            要设置的 上传人
	 */
	public void setSCR(String SCR)
	{
		this.SCR = SCR;
	}

	/**
	 * @return 返回 上传人姓名
	 */
	public String getSCRXM()
	{
		return SCRXM;
	}

	/**
	 * @param SCRXM
	 *            要设置的 上传人姓名
	 */
	public void setSCRXM(String SCRXM)
	{
		this.SCRXM = SCRXM;
	}

	/**
	 * @return 返回 附件类型 :1为照片,2为视频,3为录音,4为其他
	 */
	public String getFJLX()
	{
		return FJLX;
	}

	/**
	 * @param FJLX
	 *            要设置的 附件类型 :1为照片,2为视频,3为录音,4为其他
	 */
	public void setFJLX(String FJLX)
	{
		this.FJLX = FJLX;
	}

	public void setSFSC(Boolean sFSC)
	{
		SFSC = sFSC;
	}

	public Boolean getSFSC()
	{
		return SFSC;
	}

	public void setSCZT(Boolean sCZT)
	{
		SCZT = sCZT;
	}

	public Boolean getSCZT()
	{
		return SCZT;
	}

	public String toString()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.bhq.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 
 * Description: BHQ_XHSJ 实体类
 * 
 * Copyright: Copyright (c) 2015
 * 
 * Company: 广州海川信息科技有限公司
 * 
 * @version 1.0
 */
@Table(name = "BHQ_XHSJ")
public class BHQ_XHSJ implements Parcelable
{
	@Id
	@NoAutoIncrement
	public String SJID;
	public String SJLX;
	public String SJMS="";
	public String CLQK="";
	public String SBR;
	public String SBRXM;
	public String SBSJ;
	public String SSBHZ;
	public String LCZT;
	public String X="0";
	public String Y="0";
	public String XHID;
	public String SJLXMC;
	public String SFSC="0";
	public String IsUpload="0";

	public void setSFSC(String sFSC)
	{
		SFSC = sFSC;
	}

	public String getSFSC()
	{
		return SFSC;
	}

	public void setIsUpload(String isUpload)
	{
		IsUpload = isUpload;
	}

	public String getIsUpload()
	{
		return IsUpload;
	}

	public void setSJLXMC(String sJLXMC)
	{
		SJLXMC = sJLXMC;
	}

	public String getSJLXMC()
	{
		return SJLXMC;
	}

	public String getSJID()
	{
		return SJID;
	}

	public void setSJID(String SJID)
	{
		this.SJID = SJID;
	}

	public String getSJLX()
	{
		return SJLX;
	}

	public void setSJLX(String SJLX)
	{
		this.SJLX = SJLX;
	}

	public String getSJMS()
	{
		return SJMS;
	}

	public void setSJMS(String SJMS)
	{
		this.SJMS = SJMS;
	}

	public String getCLQK()
	{
		return CLQK;
	}

	public void setCLQK(String CLQK)
	{
		this.CLQK = CLQK;
	}

	public String getSBR()
	{
		return SBR;
	}

	public void setSBR(String SBR)
	{
		this.SBR = SBR;
	}

	public String getSBRXM()
	{
		return SBRXM;
	}

	public void setSBRXM(String SBRXM)
	{
		this.SBRXM = SBRXM;
	}

	public String getSBSJ()
	{
		return SBSJ;
	}

	public void setSBSJ(String SBSJ)
	{
		this.SBSJ = SBSJ;
	}

	public String getSSBHZ()
	{
		return SSBHZ;
	}

	public void setSSBHZ(String SSBHZ)
	{
		this.SSBHZ = SSBHZ;
	}

	public String getLCZT()
	{
		return LCZT;
	}

	public void setLCZT(String LCZT)
	{
		this.LCZT = LCZT;
	}

	public String getX()
	{
		return X;
	}

	public void setX(String X)
	{
		this.X = X;
	}

	public String getY()
	{
		return Y;
	}

	public void setY(String Y)
	{
		this.Y = Y;
	}

	public String getXHID()
	{
		return XHID;
	}

	public void setXHID(String XHID)
	{
		this.XHID = XHID;
	}

	public boolean equals(Object o)
	{
		return false;
	}

	public int hashCode()
	{
		return 0;
	}

	public static final Parcelable.Creator<BHQ_XHSJ> CREATOR = new Creator()
	{
		@Override
		public BHQ_XHSJ createFromParcel(Parcel source)
		{
			// 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
			BHQ_XHSJ p = new BHQ_XHSJ();
			p.setSJID(source.readString());
			p.setSJLX(source.readString());
			p.setSJMS(source.readString());
			p.setCLQK(source.readString());
			p.setSBR(source.readString());
			p.setSBRXM(source.readString());
			p.setSBSJ(source.readString());
			p.setSSBHZ(source.readString());
			p.setLCZT(source.readString());
			p.setX(source.readString());
			p.setY(source.readString());
			p.setXHID(source.readString());
			p.setSJLXMC(source.readString());
			p.setSFSC(source.readString());
			p.setIsUpload(source.readString());
			return p;
		}

		@Override
		public BHQ_XHSJ[] newArray(int size)
		{
			return new BHQ_XHSJ[size];
		}
	};

	@Override
	public void writeToParcel(Parcel p, int arg1)
	{
		p.writeString(SJID);
		p.writeString(SJLX);
		p.writeString(SJMS);
		p.writeString(CLQK);
		p.writeString(SBR);
		p.writeString(SBRXM);
		p.writeString(SBSJ);
		p.writeString(SSBHZ);
		p.writeString(LCZT);
		p.writeString(X);
		p.writeString(Y);
		p.writeString(XHID);
		p.writeString(SJLXMC);
		p.writeString(SFSC);
		p.writeString(IsUpload);
	}

	@Override
	public int describeContents()
	{
		return 0;
	}
}

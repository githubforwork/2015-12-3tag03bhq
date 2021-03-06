//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.bhq.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bhq.R.id;
import com.bhq.R.layout;
import com.tencent.tencentmap.mapsdk.map.MapView;

import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class PatrolContent_
    extends PatrolContent
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.patrolcontent);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static PatrolContent_.IntentBuilder_ intent(Context context) {
        return new PatrolContent_.IntentBuilder_(context);
    }

    public static PatrolContent_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new PatrolContent_.IntentBuilder_(fragment);
    }

    public static PatrolContent_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new PatrolContent_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        mapview = ((MapView) hasViews.findViewById(id.mapview));
        tv_starttime = ((TextView) hasViews.findViewById(id.tv_starttime));
        tv_xhsc = ((TextView) hasViews.findViewById(id.tv_xhsc));
        tv_endtime = ((TextView) hasViews.findViewById(id.tv_endtime));
        tv_xhlc = ((TextView) hasViews.findViewById(id.tv_xhlc));
        imgbtn_back = ((ImageButton) hasViews.findViewById(id.imgbtn_back));
        if (imgbtn_back!= null) {
            imgbtn_back.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    PatrolContent_.this.imgbtn_back();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<PatrolContent_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, PatrolContent_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), PatrolContent_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), PatrolContent_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode);
                } else {
                    super.startForResult(requestCode);
                }
            }
        }

    }

}

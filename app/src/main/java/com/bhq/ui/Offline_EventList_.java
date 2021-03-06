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
import android.widget.ProgressBar;

import com.bhq.R.id;
import com.bhq.R.layout;

import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class Offline_EventList_
    extends Offline_EventList
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.eventlist);
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

    public static Offline_EventList_.IntentBuilder_ intent(Context context) {
        return new Offline_EventList_.IntentBuilder_(context);
    }

    public static Offline_EventList_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new Offline_EventList_.IntentBuilder_(fragment);
    }

    public static Offline_EventList_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new Offline_EventList_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        main_head_progress = ((ProgressBar) hasViews.findViewById(id.main_head_progress));
        imgbtn_back = ((ImageButton) hasViews.findViewById(id.imgbtn_back));
        imgbtn_add = ((ImageButton) hasViews.findViewById(id.imgbtn_add));
        if (imgbtn_add!= null) {
            imgbtn_add.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_EventList_.this.imgbtn_add();
                }

            }
            );
        }
        if (imgbtn_back!= null) {
            imgbtn_back.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_EventList_.this.imgbtn_back();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<Offline_EventList_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, Offline_EventList_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_EventList_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_EventList_.class);
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

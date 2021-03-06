//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.bhq.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bhq.R.id;
import com.bhq.R.layout;

import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

@SuppressLint({
    "NewApi"
})
public final class Offline_MainActivity_
    extends Offline_MainActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.offline_activity_main);
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

    public static Offline_MainActivity_.IntentBuilder_ intent(Context context) {
        return new Offline_MainActivity_.IntentBuilder_(context);
    }

    public static Offline_MainActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new Offline_MainActivity_.IntentBuilder_(fragment);
    }

    public static Offline_MainActivity_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new Offline_MainActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        tv_patro = ((TextView) hasViews.findViewById(id.tv_patro));
        tl_data = ((TableLayout) hasViews.findViewById(id.tl_data));
        imgbtn_patrol = ((ImageButton) hasViews.findViewById(id.imgbtn_patrol));
        tl_patrol = ((TableLayout) hasViews.findViewById(id.tl_patrol));
        tv_knowledge = ((TextView) hasViews.findViewById(id.tv_knowledge));
        tv_setting = ((TextView) hasViews.findViewById(id.tv_setting));
        imgbtn_home = ((ImageButton) hasViews.findViewById(id.imgbtn_home));
        tl_message = ((TableLayout) hasViews.findViewById(id.tl_message));
        tl_home = ((TableLayout) hasViews.findViewById(id.tl_home));
        imgbtn_data = ((ImageButton) hasViews.findViewById(id.imgbtn_data));
        imgbtn_message = ((ImageButton) hasViews.findViewById(id.imgbtn_message));
        tv_home = ((TextView) hasViews.findViewById(id.tv_home));
        if (tl_home!= null) {
            tl_home.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_MainActivity_.this.tl_home();
                }

            }
            );
        }
        if (tl_message!= null) {
            tl_message.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_MainActivity_.this.tl_message();
                }

            }
            );
        }
        if (tl_data!= null) {
            tl_data.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_MainActivity_.this.tl_data();
                }

            }
            );
        }
        if (tl_patrol!= null) {
            tl_patrol.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_MainActivity_.this.tl_patrol();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<Offline_MainActivity_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, Offline_MainActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_MainActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_MainActivity_.class);
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

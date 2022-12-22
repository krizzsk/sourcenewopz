package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;

public class LivenessHelper implements LifecycleObserver {

    /* renamed from: a */
    private final ViewFlipper f47315a;

    /* renamed from: b */
    private final Context f47316b;

    /* renamed from: c */
    private final TextView f47317c;

    /* renamed from: d */
    private final TextView f47318d;

    /* renamed from: e */
    private VideoPlayer f47319e;

    /* renamed from: f */
    private String f47320f;

    public LivenessHelper(Context context, View view, String str) {
        this.f47316b = context;
        this.f47319e = new VideoPlayer(context);
        this.f47320f = str;
        this.f47315a = (ViewFlipper) view.findViewById(R.id.face_action_container);
        this.f47318d = (TextView) view.findViewById(R.id.face_voice_ctr);
        this.f47317c = (TextView) view.findViewById(R.id.tv_recognizing_tip_up);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void reset() {
        this.f47318d.setVisibility(4);
        this.f47317c.setText(R.string.df_liveness_hold_phone);
        if (this.f47315a.getDisplayedChild() != 0) {
            this.f47315a.setDisplayedChild(0);
        }
        this.f47319e.reset();
    }

    public void move(int i, int i2) {
        ActionType index = ActionType.index(i);
        if (index != null) {
            this.f47315a.showNext();
            if ("BR".equals(this.f47320f)) {
                this.f47318d.setVisibility(0);
                this.f47319e.videoPlayer(index.video);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        this.f47319e.reset();
    }

    public void initAction(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            iArr = new int[]{3};
        }
        for (int index : iArr) {
            ActionType index2 = ActionType.index(index);
            ImageView imageView = new ImageView(this.f47316b);
            DiSafetyImageLoader.with(this.f47316b).load(index2.getGif()).into(imageView);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f47315a.addView(imageView, layoutParams);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f47316b, R.anim.liveness_rightin);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f47316b, R.anim.liveness_leftout);
        this.f47315a.setInAnimation(loadAnimation);
        this.f47315a.setOutAnimation(loadAnimation2);
    }
}

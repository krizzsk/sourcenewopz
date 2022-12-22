package com.didi.component.notalk.notalk2;

import android.app.Activity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.NonTalkingVisibilityEvent;
import com.didi.component.notalk.presenter.AbsNoTalkPresenter;
import com.didi.component.notalk.view.INoTalkView;
import com.taxis99.R;

public class NoTalkViewV2 implements INoTalkView {

    /* renamed from: a */
    private Activity f14704a;

    /* renamed from: b */
    private ImageView f14705b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AbsNoTalkPresenter f14706c;
    protected View mRootView;

    public void clearTipsView() {
    }

    public void showTipsView(String str, int i) {
    }

    public NoTalkViewV2(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.global_non_talking_entrance, (ViewGroup) null);
        this.mRootView = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_global_non_talking_entrance);
        this.f14705b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NoTalkViewV2.this.f14706c != null) {
                    NoTalkViewV2.this.f14706c.showNonTalkingMeetCard();
                }
            }
        });
        this.f14704a = activity;
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsNoTalkPresenter absNoTalkPresenter) {
        this.f14706c = absNoTalkPresenter;
    }

    public void setVisible(boolean z) {
        if (z != isVisible()) {
            this.mRootView.setVisibility(z ? 0 : 8);
            if (z) {
                this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (NoTalkViewV2.this.getView().getHeight() != 0) {
                            NoTalkViewV2.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            NoTalkViewV2.this.f14706c.doPublish(BaseEventKeys.NonTalking.EVENT_VISIBILITY_CHANGED, new NonTalkingVisibilityEvent(Math.max((int) (((float) NoTalkViewV2.this.getView().getHeight()) - TypedValue.applyDimension(1, 2.0f, NoTalkViewV2.this.getView().getResources().getDisplayMetrics())), 0), true));
                        }
                    }
                });
            } else {
                this.f14706c.doPublish(BaseEventKeys.NonTalking.EVENT_VISIBILITY_CHANGED, new NonTalkingVisibilityEvent(0, false));
            }
        }
    }

    public boolean isVisible() {
        View view = this.mRootView;
        return view != null && view.getVisibility() == 0;
    }

    public void setTranslationY(int i) {
        getView().setTranslationY((float) i);
    }
}

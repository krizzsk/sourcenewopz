package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FiveStarEvaluatedView extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f13416a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f13417b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f13418c = new Handler();

    /* renamed from: d */
    private OnStarListener f13419d;

    /* renamed from: e */
    private int f13420e = 0;

    /* renamed from: f */
    private boolean f13421f = false;
    protected List<CheckBox> mCheckBoxes = new ArrayList();

    public interface OnStarListener {
        void onStarChanged(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_evaluate_five_star_view_layout;
    }

    public FiveStarEvaluatedView(Context context) {
        super(context);
        m9195a();
    }

    public FiveStarEvaluatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9195a();
    }

    public FiveStarEvaluatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9195a();
    }

    /* renamed from: a */
    private void m9195a() {
        this.f13416a = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(getLayout(), this, true)).findViewById(R.id.global_evaluate_five_star_group);
        for (int i = 0; i < this.f13416a.getChildCount(); i++) {
            View childAt = this.f13416a.getChildAt(i);
            if (childAt instanceof CheckBox) {
                this.mCheckBoxes.add((CheckBox) childAt);
            }
        }
        m9198b();
    }

    /* renamed from: b */
    private void m9198b() {
        for (int i = 0; i < this.mCheckBoxes.size(); i++) {
            this.mCheckBoxes.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (FiveStarEvaluatedView.this.f13417b) {
                        int indexOf = FiveStarEvaluatedView.this.mCheckBoxes.indexOf(view);
                        if (indexOf != -1) {
                            FiveStarEvaluatedView.this.flushRateStar(indexOf);
                        }
                        FiveStarEvaluatedView.this.f13418c.removeCallbacksAndMessages((Object) null);
                    }
                }
            });
        }
    }

    public void showEvaluated(int i) {
        flushRateStar(i - 1);
    }

    /* access modifiers changed from: protected */
    public void flushRateStar(int i) {
        int i2 = i + 1;
        this.f13420e = i2;
        for (int i3 = 0; i3 < this.mCheckBoxes.size(); i3++) {
            CheckBox checkBox = this.mCheckBoxes.get(i3);
            if (i3 <= i) {
                checkBox.setChecked(true);
                if (this.f13421f) {
                    checkBox.setVisibility(0);
                }
            } else {
                checkBox.setChecked(false);
                if (this.f13421f) {
                    checkBox.setVisibility(8);
                }
            }
            checkBox.invalidate();
        }
        OnStarListener onStarListener = this.f13419d;
        if (onStarListener != null) {
            onStarListener.onStarChanged(i2);
        }
    }

    public void setOnStarListener(OnStarListener onStarListener) {
        this.f13419d = onStarListener;
    }

    public void setEnable(boolean z) {
        this.f13417b = z;
        for (CheckBox enabled : this.mCheckBoxes) {
            enabled.setEnabled(z);
        }
    }

    public View getView() {
        return this.f13416a;
    }

    public int getCurrentStar() {
        return this.f13420e;
    }

    public void setMargin(int i) {
        for (int i2 = 0; i2 < this.mCheckBoxes.size(); i2++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mCheckBoxes.get(i2).getLayoutParams();
            if (layoutParams != null && layoutParams.leftMargin > 0) {
                layoutParams.leftMargin = UIUtils.dip2pxInt(getContext(), (float) i);
            }
        }
    }

    public void setIsHideUnselect(boolean z) {
        this.f13421f = z;
    }
}

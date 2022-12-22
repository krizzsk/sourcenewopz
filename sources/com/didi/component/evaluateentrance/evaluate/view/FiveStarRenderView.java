package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FiveStarRenderView extends LinearLayout {
    /* access modifiers changed from: private */
    public final List<CheckBox> checkBoxes = new ArrayList();
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isEnable = true;

    public interface OnClickFiveStarListener {
        void onClickFiveStarLevel(int i);
    }

    public FiveStarRenderView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public FiveStarRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FiveStarRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public FiveStarRenderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.g_xp_five_star_render_layout, this);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof CheckBox) {
                this.checkBoxes.add((CheckBox) childAt);
            }
        }
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, C10448R.styleable.FiveStarRenderView);
            setFiveStarSize(typedArray.getDimensionPixelSize(3, 0), typedArray.getDimensionPixelSize(1, 0), typedArray.getDimensionPixelSize(2, 0));
            setFiveStarBackground(typedArray.getDrawable(0));
            if (typedArray == null) {
                return;
            }
        } catch (Exception unused) {
            if (typedArray == null) {
                return;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
        typedArray.recycle();
    }

    public void setFiveStarSize(int i, int i2, int i3) {
        for (int i4 = 0; i4 < this.checkBoxes.size(); i4++) {
            CheckBox checkBox = this.checkBoxes.get(i4);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) checkBox.getLayoutParams();
            marginLayoutParams.width = i;
            marginLayoutParams.height = i2;
            if (i4 != 0) {
                marginLayoutParams.leftMargin = i3;
            }
            checkBox.setLayoutParams(marginLayoutParams);
        }
    }

    public void setClickFiveStarListener(final OnClickFiveStarListener onClickFiveStarListener) {
        for (int i = 0; i < this.checkBoxes.size(); i++) {
            this.checkBoxes.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (FiveStarRenderView.this.isEnable) {
                        final int indexOf = FiveStarRenderView.this.checkBoxes.indexOf(view);
                        if (indexOf != -1) {
                            FiveStarRenderView.this.flushRateStar(indexOf);
                        }
                        FiveStarRenderView.this.handler.removeCallbacksAndMessages((Object) null);
                        FiveStarRenderView.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                onClickFiveStarListener.onClickFiveStarLevel(indexOf + 1);
                            }
                        }, 10);
                        FiveStarRenderView.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                FiveStarRenderView.this.flushRateStar(-1);
                            }
                        }, 1000);
                    }
                }
            });
        }
    }

    public void setFiveStarBackground(int i) {
        for (int i2 = 0; i2 < this.checkBoxes.size(); i2++) {
            this.checkBoxes.get(i2).setBackgroundResource(i);
        }
    }

    public void setFiveStarBackground(Drawable drawable) {
        for (int i = 0; i < this.checkBoxes.size(); i++) {
            CheckBox checkBox = this.checkBoxes.get(i);
            if (i == 0) {
                checkBox.setBackground(drawable);
            } else {
                checkBox.setBackground(drawable.getConstantState().newDrawable().mutate());
            }
        }
    }

    public void flushRateStar(int i) {
        for (int i2 = 0; i2 < this.checkBoxes.size(); i2++) {
            CheckBox checkBox = this.checkBoxes.get(i2);
            if (i2 <= i) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
            checkBox.invalidate();
        }
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
        for (CheckBox next : this.checkBoxes) {
            next.setEnabled(z);
            next.setClickable(z);
        }
    }
}

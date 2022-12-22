package com.didi.map.global.component.departure.bubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.taxis99.R;

public class BubbleAnimationView extends AppCompatImageView {

    /* renamed from: a */
    private final int f24874a;

    /* renamed from: b */
    private final int f24875b;

    public interface IAnimationListener {
        void onFinish();
    }

    public BubbleAnimationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24874a = 20;
        this.f24875b = 4;
        m17705a();
    }

    /* renamed from: a */
    private void m17705a() {
        setBackgroundResource(R.drawable.mappoiselect_map_pop_tworow);
    }

    public void startAnimation(final int i, final int i2, final IAnimationListener iAnimationListener) {
        postDelayed(new Runnable() {
            public void run() {
                int i = BubbleAnimationView.this.getLayoutParams().width;
                int i2 = BubbleAnimationView.this.getLayoutParams().height;
                int i3 = i;
                if (i < i3) {
                    int i4 = i + 20;
                    if (i4 <= i3) {
                        i3 = i4;
                    }
                    ViewGroup.LayoutParams layoutParams = BubbleAnimationView.this.getLayoutParams();
                    layoutParams.width = i3;
                    if (i2 < i2) {
                        int i5 = i2 + 20;
                        layoutParams.height = i2;
                    }
                    BubbleAnimationView.this.setLayoutParams(layoutParams);
                    BubbleAnimationView.this.startAnimation(i, i2, iAnimationListener);
                    return;
                }
                IAnimationListener iAnimationListener = iAnimationListener;
                if (iAnimationListener != null) {
                    iAnimationListener.onFinish();
                }
            }
        }, 4);
    }
}

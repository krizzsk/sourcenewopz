package com.didi.dimina.starbox.p107ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.widget.TitleBar */
public class TitleBar extends FrameLayout {

    /* renamed from: a */
    private ImageView f18132a;

    /* renamed from: b */
    private ImageView f18133b;

    /* renamed from: c */
    private TextView f18134c;

    /* renamed from: d */
    private TextView f18135d;

    /* renamed from: e */
    private TextView f18136e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnTitleBarClickListener f18137f;

    /* renamed from: com.didi.dimina.starbox.ui.widget.TitleBar$OnTitleBarClickListener */
    public interface OnTitleBarClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public TitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13538a(context, attributeSet);
    }

    /* renamed from: a */
    private void m13538a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.dimina_starbox_title_bar, this, true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.TitleBar);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(3, 0);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(7, 0);
        int color2 = obtainStyledAttributes.getColor(6, getResources().getColor(R.color.dk_color_FFFFFF));
        String string2 = obtainStyledAttributes.getString(4);
        String string3 = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        this.f18132a = (ImageView) findViewById(R.id.left_icon);
        this.f18133b = (ImageView) findViewById(R.id.right_icon);
        this.f18134c = (TextView) findViewById(R.id.title);
        this.f18136e = (TextView) findViewById(R.id.right_text);
        this.f18135d = (TextView) findViewById(R.id.left_text);
        ((ViewGroup) this.f18132a.getParent()).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBar.this.f18137f != null) {
                    TitleBar.this.f18137f.onLeftClick();
                }
            }
        });
        if (resourceId3 == 0) {
            ((ViewGroup) this.f18133b.getParent()).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f18137f != null) {
                        TitleBar.this.f18137f.onRightClick();
                    }
                }
            });
            ((ViewGroup) this.f18136e.getParent()).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f18137f != null) {
                        TitleBar.this.f18137f.onRightClick();
                    }
                }
            });
        } else {
            this.f18133b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (TitleBar.this.f18137f != null) {
                        TitleBar.this.f18137f.onRightClick();
                    }
                }
            });
        }
        setLeftIcon(resourceId);
        setLeftText(string3);
        setRightText(string2);
        setRightIcon(resourceId2);
        setRightTextColor(color);
        setTitle(string);
        setTitleColor(color);
        setBackgroundColor(color2);
    }

    private void setRightTextColor(int i) {
        if (i != 0) {
            this.f18136e.setTextColor(i);
            this.f18136e.setVisibility(0);
        }
    }

    private void setTitleColor(int i) {
        if (i != 0) {
            this.f18134c.setTextColor(i);
            this.f18134c.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        setTitle(str, true);
    }

    public void setTitle(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f18134c.setText("");
            return;
        }
        this.f18134c.setText(str);
        this.f18134c.setVisibility(0);
        if (z) {
            this.f18134c.setAlpha(0.0f);
            this.f18134c.animate().alpha(1.0f).start();
        }
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.f18137f = onTitleBarClickListener;
    }

    public void setLeftIcon(int i) {
        if (i != 0) {
            this.f18132a.setImageResource(i);
            this.f18132a.setVisibility(0);
        }
    }

    public void setRightIcon(int i) {
        if (i != 0) {
            this.f18133b.setImageResource(i);
            this.f18133b.setVisibility(0);
        }
    }

    public void setRightText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18136e.setText(str);
            this.f18136e.setVisibility(0);
            this.f18133b.setVisibility(8);
        }
    }

    public void setLeftText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18135d.setText(str);
            this.f18135d.setVisibility(0);
        }
    }
}

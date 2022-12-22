package com.didi.beatles.p099im.views.buttonView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView */
public class IMSwitchView extends LinearLayout {
    public static final int LEFT_CHECKED = 1;
    public static final int RIGHT_CHECKED = 2;

    /* renamed from: b */
    private static int f10138b = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f10139a;

    /* renamed from: c */
    private Context f10140c;

    /* renamed from: d */
    private TextView f10141d;

    /* renamed from: e */
    private TextView f10142e;

    /* renamed from: f */
    private TextView f10143f;

    /* renamed from: g */
    private TextView f10144g;

    /* renamed from: h */
    private View f10145h;

    /* renamed from: i */
    private View f10146i;

    /* renamed from: j */
    private IMSwitchCheckListener f10147j;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView$Checked */
    public @interface Checked {
    }

    /* renamed from: com.didi.beatles.im.views.buttonView.IMSwitchView$IMSwitchCheckListener */
    public interface IMSwitchCheckListener {
        void leftBtnChecked();

        void rightBtnChecked();
    }

    public IMSwitchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10140c = context;
        m6919a();
    }

    /* renamed from: a */
    private void m6919a() {
        View inflate = LayoutInflater.from(this.f10140c).inflate(R.layout.im_switch_view, this);
        this.f10141d = (TextView) inflate.findViewById(R.id.im_switch_left_btn);
        this.f10142e = (TextView) inflate.findViewById(R.id.im_switch_left_line);
        this.f10143f = (TextView) inflate.findViewById(R.id.im_switch_right_btn);
        this.f10144g = (TextView) inflate.findViewById(R.id.im_switch_right_line);
        this.f10145h = inflate.findViewById(R.id.im_switch_left_ll);
        this.f10146i = inflate.findViewById(R.id.im_switch_right_ll);
        m6920b();
        setDefaultChecked(1);
    }

    public void setDefaultChecked(int i) {
        if (this.f10147j == null) {
            f10138b = i;
            if (i == 1) {
                leftChecked();
            } else {
                m6922c();
            }
        }
    }

    /* renamed from: b */
    private void m6920b() {
        C43231 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.im_switch_left_ll) {
                    if (IMSwitchView.this.f10139a != 1) {
                        IMSwitchView.this.leftChecked();
                    }
                } else if (view.getId() == R.id.im_switch_right_ll && IMSwitchView.this.f10139a != 2) {
                    IMSwitchView.this.m6922c();
                }
            }
        };
        this.f10145h.setOnClickListener(r0);
        this.f10146i.setOnClickListener(r0);
    }

    public void leftChecked() {
        this.f10139a = 1;
        this.f10141d.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f10142e.setVisibility(0);
        this.f10142e.setBackgroundColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f10143f.setTextColor(IMResource.getColor(R.color.im_color_333));
        this.f10144g.setVisibility(8);
        IMSwitchCheckListener iMSwitchCheckListener = this.f10147j;
        if (iMSwitchCheckListener != null) {
            iMSwitchCheckListener.leftBtnChecked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6922c() {
        this.f10139a = 2;
        this.f10141d.setTextColor(IMResource.getColor(R.color.im_color_333));
        this.f10142e.setVisibility(8);
        this.f10143f.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
        this.f10144g.setVisibility(0);
        this.f10144g.setBackgroundColor(IMResource.getColor(R.color.im_nomix_orange));
        IMSwitchCheckListener iMSwitchCheckListener = this.f10147j;
        if (iMSwitchCheckListener != null) {
            iMSwitchCheckListener.rightBtnChecked();
        }
    }

    public void setOnCheckListener(IMSwitchCheckListener iMSwitchCheckListener) {
        this.f10147j = iMSwitchCheckListener;
    }

    public void setText(String str, String str2) {
        TextView textView = this.f10141d;
        if (textView != null && this.f10143f != null) {
            textView.setText(str);
            this.f10143f.setText(str2);
        }
    }
}

package com.didi.beatles.p099im.plugin.robot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotBtmTabContentView */
public class IMRobotBtmTabContentView extends RelativeLayout {

    /* renamed from: a */
    private static final String f9524a = IMRobotBtmTabContentView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f9525b;

    /* renamed from: c */
    private TextView f9526c;

    /* renamed from: d */
    private final boolean f9527d;

    public IMRobotBtmTabContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (IMTabInvokeEnv) null);
    }

    public IMRobotBtmTabContentView(Context context, AttributeSet attributeSet, IMTabInvokeEnv iMTabInvokeEnv) {
        super(context, attributeSet);
        boolean z = true;
        this.f9527d = (iMTabInvokeEnv == null || iMTabInvokeEnv.getPluginTheme() != 1) ? false : z;
        inflate(context, R.layout.im_plugin_robot_btm_tab_content_view, this);
        this.f9525b = (ImageView) findViewById(R.id.im_tab_icon);
        this.f9526c = (TextView) findViewById(R.id.im_tab_text);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6467a() {
        if (this.f9527d) {
            this.f9525b.setImageResource(R.drawable.im_plugin_robot_tab_icon_helper_sel);
        } else {
            this.f9525b.setImageResource(R.drawable.im_plugin_robot_tab_icon_sel);
        }
    }

    /* renamed from: a */
    private void m6468a(String str, final int i) {
        BtsImageLoader.getInstance().loadIntoAsGif(str, this.f9525b, i, new Callback() {
            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
                if (IMRobotBtmTabContentView.this.f9525b != null && IMRobotBtmTabContentView.this.f9525b.isSelected()) {
                    IMRobotBtmTabContentView.this.m6467a();
                }
            }

            public void onFailed() {
                IMRobotBtmTabContentView.this.f9525b.setImageResource(i);
            }
        });
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            m6467a();
        }
    }
}

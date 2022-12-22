package com.didi.dimina.container.p106ui.webview;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.PixUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.webview.DMWebViewScrollClient */
public class DMWebViewScrollClient {

    /* renamed from: a */
    private long f17858a = 0;

    /* renamed from: b */
    private int f17859b = 0;

    /* renamed from: c */
    private int[] f17860c;

    /* renamed from: d */
    private boolean f17861d = false;

    /* renamed from: e */
    private final DMMina f17862e;

    public DMWebViewScrollClient(DMMina dMMina) {
        this.f17862e = dMMina;
    }

    public void setOnPageScrollEmitToEngine(boolean z) {
        this.f17861d = z;
    }

    public void setOnPageScrollThrottle(int i) {
        this.f17859b = i;
    }

    public void setOnPageScrollTopKeys(int[] iArr) {
        this.f17860c = iArr;
        if (iArr != null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                this.f17860c[i] = PixUtil.dip2px(Dimina.getConfig().getApp(), (float) this.f17860c[i]);
            }
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.f17861d) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr = this.f17860c;
            if (iArr != null && iArr.length > 0) {
                for (int i5 : iArr) {
                    if (i2 == i5) {
                        this.f17858a = currentTimeMillis;
                        m13369a(i2);
                        return;
                    }
                }
            }
            int i6 = this.f17859b;
            if (i6 <= 0 || currentTimeMillis - this.f17858a >= ((long) i6)) {
                this.f17858a = currentTimeMillis;
                m13369a(i2);
            }
        }
    }

    /* renamed from: a */
    private void m13369a(int i) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "scrollTop", PixUtil.px2dip(Dimina.getConfig().getApp(), (float) i));
        this.f17862e.getMessageTransfer().sendMessageToServiceFromNative("onPageScroll", new MessageWrapperBuilder().data(jSONObject).build());
    }
}

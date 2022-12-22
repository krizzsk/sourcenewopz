package com.didi.beatles.p099im.access.exportUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageListenerManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* renamed from: com.didi.beatles.im.access.exportUI.MessageEnterView */
public class MessageEnterView extends RelativeLayout implements IMMessageListener {

    /* renamed from: a */
    private static final int f8758a = 99;

    /* renamed from: b */
    private View f8759b = null;

    /* renamed from: c */
    private TextView f8760c = null;

    /* renamed from: d */
    private IMSessionUnreadCallback f8761d = null;

    /* renamed from: e */
    private int f8762e = 0;

    /* renamed from: f */
    private boolean f8763f = false;

    public MessageEnterView(Context context) {
        super(context);
    }

    public MessageEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8759b = findViewById(R.id.message_redpoint);
        this.f8760c = (TextView) findViewById(R.id.message_numv);
    }

    public void refresh() {
        if (this.f8761d == null) {
            this.f8761d = new IMSessionUnreadCallback() {
                public void unReadCount(final int i) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            MessageEnterView.this.m5829a(i);
                        }
                    });
                }
            };
        }
        IMManager.getInstance().getAllUnreadMessageCount(this.f8761d);
    }

    public void onClick() {
        IMTraceUtil.addBusinessEvent("ddim_home_icon_ck").add("redpoint", Integer.valueOf(IMManager.getInstance().isIMHaveRedDot() ? 1 : 0)).add("number", Integer.valueOf(this.f8762e > 0 ? 1 : 0)).add("log_status", 1).report();
        IMManager.getInstance().reInitIM(2);
        IMEngine.startChatListActivity(getContext());
        IMManager.getInstance().clearIMRedDot();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5829a(int i) {
        this.f8762e = i;
        this.f8763f = false;
        if (i > 0) {
            TextView textView = this.f8760c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f8759b.setVisibility(4);
                if (i > 99) {
                    this.f8760c.setText("···");
                } else {
                    TextView textView2 = this.f8760c;
                    textView2.setText(i + "");
                }
                try {
                    this.f8760c.setBackgroundResource(R.drawable.im_dots_with_number);
                } catch (Exception e) {
                    IMLog.m6631d("im_sdk", e.getMessage());
                }
            }
        } else {
            boolean isIMHaveRedDot = IMManager.getInstance().isIMHaveRedDot();
            this.f8763f = isIMHaveRedDot;
            if (isIMHaveRedDot) {
                this.f8760c.setVisibility(4);
                this.f8759b.setVisibility(0);
                return;
            }
            this.f8760c.setVisibility(4);
            this.f8759b.setVisibility(4);
        }
    }

    public Map<String, Object> getStateMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("number", Integer.valueOf(this.f8762e > 0 ? 1 : 0));
        hashMap.put("redpoint", Integer.valueOf(this.f8763f ? 1 : 0));
        return hashMap;
    }

    public void resetState() {
        TextView textView = this.f8760c;
        if (textView != null) {
            textView.setVisibility(4);
        }
        View view = this.f8759b;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IMMessageListenerManager.getInstance().addMessageListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IMMessageListenerManager.getInstance().removeMessageListener(this);
    }

    public void onDestory() {
        IMEngine.getInstance(getContext().getApplicationContext()).removeMessageListener(this);
    }

    public void onMessageArrive() {
        if (isShown()) {
            refresh();
        }
    }
}

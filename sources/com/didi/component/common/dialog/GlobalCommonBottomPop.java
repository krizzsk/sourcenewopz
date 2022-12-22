package com.didi.component.common.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.taxis99.R;

public class GlobalCommonBottomPop extends GlobalAbsBottomPopWin {

    /* renamed from: a */
    private BottomPopModel f11539a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GlobalBottomPopActionListener f11540b;

    public static class BottomPopModel {
        public String content;
        public boolean isShowNegative;
        public String negative;
        public String positive;
        public String title;
    }

    public interface GlobalBottomPopActionListener {
        void onNegativeClick();

        void onPositiveClick();
    }

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.g_common_bottom_pop_layout;
    }

    public GlobalCommonBottomPop(Context context, BottomPopModel bottomPopModel) {
        super(context);
        this.f11539a = bottomPopModel;
    }

    public void setBottomActionListener(GlobalBottomPopActionListener globalBottomPopActionListener) {
        this.f11540b = globalBottomPopActionListener;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        TextView textView = (TextView) findViewById(R.id.g_bottom_pop_title);
        textView.setText(this.f11539a.title);
        if (TextUtils.isEmpty(this.f11539a.title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f11539a.title);
        }
        TextView textView2 = (TextView) findViewById(R.id.g_bottom_pop_content);
        if (TextUtils.isEmpty(this.f11539a.content)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f11539a.content);
        }
        TextView textView3 = (TextView) findViewById(R.id.g_bottom_pop_btn_ok);
        textView3.setText(this.f11539a.positive);
        textView3.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (GlobalCommonBottomPop.this.f11540b != null) {
                    GlobalCommonBottomPop.this.f11540b.onPositiveClick();
                }
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.g_bottom_pop_btn_cancel);
        View findViewById = findViewById(R.id.g_bottom_pop_interval_view);
        if (this.f11539a.isShowNegative) {
            textView4.setVisibility(0);
            findViewById.setVisibility(0);
            textView4.setText(this.f11539a.negative);
            textView4.setOnClickListener(new OnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (GlobalCommonBottomPop.this.f11540b != null) {
                        GlobalCommonBottomPop.this.f11540b.onNegativeClick();
                    }
                }
            });
            return true;
        }
        textView4.setVisibility(8);
        findViewById.setVisibility(8);
        return true;
    }
}

package com.didi.global.globalgenerickit.dialog;

import android.graphics.Typeface;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import java.util.List;

class GGKRealUsedModel {

    /* renamed from: a */
    TextWidgetModel f22085a;

    /* renamed from: b */
    TextWidgetModel f22086b;

    /* renamed from: c */
    TextWidgetModel f22087c;

    /* renamed from: d */
    TextWatcher f22088d;

    /* renamed from: e */
    String f22089e;

    /* renamed from: f */
    CompoundButton.OnCheckedChangeListener f22090f;

    /* renamed from: g */
    List<GGKBtnTextAndCallback> f22091g;

    /* renamed from: h */
    TextWidgetModel f22092h;

    /* renamed from: i */
    GGKOnAntiShakeClickListener f22093i;

    /* renamed from: j */
    GGKImgModel f22094j;

    /* renamed from: k */
    TextWidgetModel f22095k;

    /* renamed from: l */
    List<TextWidgetModel> f22096l;

    GGKRealUsedModel() {
    }

    static class TextWidgetModel {
        int fontColor;
        float fontSize;
        boolean isBold = false;
        String text;

        TextWidgetModel() {
        }

        /* access modifiers changed from: package-private */
        public void bind(TextView textView) {
            if (textView != null) {
                String str = this.text;
                if (str != null) {
                    textView.setText(str);
                }
                int i = this.fontColor;
                if (i != 0) {
                    textView.setTextColor(i);
                }
                float f = this.fontSize;
                if (f != 0.0f) {
                    textView.setTextSize(f);
                }
                if (this.isBold) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
            }
        }
    }
}

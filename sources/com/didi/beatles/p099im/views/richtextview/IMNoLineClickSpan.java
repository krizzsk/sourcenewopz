package com.didi.beatles.p099im.views.richtextview;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.utils.IMTextUtil;
import java.util.regex.Pattern;

/* renamed from: com.didi.beatles.im.views.richtextview.IMNoLineClickSpan */
public class IMNoLineClickSpan extends ClickableSpan {

    /* renamed from: a */
    private String f10439a = "";

    /* renamed from: b */
    private String f10440b = "";

    /* renamed from: c */
    private String f10441c = "";

    /* renamed from: d */
    private String f10442d = "";

    /* renamed from: a */
    private String m7098a(String str) {
        return null;
    }

    /* renamed from: a */
    private void m7099a(String str, String str2) {
    }

    /* renamed from: b */
    private void m7100b(String str) {
    }

    public IMNoLineClickSpan(String str, String str2, String str3, String str4) {
        this.f10439a = str;
        this.f10440b = str2;
        this.f10441c = str3;
        this.f10442d = str4;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(this.f10439a));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!IMTextUtil.isEmpty(this.f10440b)) {
            if (!IMTextUtil.isEmpty(this.f10441c)) {
                m7099a(this.f10441c, this.f10442d);
            } else if (!isNumber(this.f10440b)) {
            } else {
                if (this.f10440b.length() >= 11) {
                    m7100b(this.f10440b);
                } else {
                    view.performClick();
                }
            }
        }
    }

    public boolean isNumber(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}

package com.didi.sdk.view.richtextview;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.Logger;
import com.didi.sdk.util.TextUtil;
import java.util.regex.Pattern;

public class NoLineClickSpan extends ClickableSpan {

    /* renamed from: a */
    private String f38174a = "";

    /* renamed from: b */
    private String f38175b = "";

    /* renamed from: c */
    private String f38176c = "";

    /* renamed from: d */
    private String f38177d = "";

    /* renamed from: a */
    private String m26987a(String str) {
        return null;
    }

    /* renamed from: b */
    private void m26989b(String str) {
    }

    public NoLineClickSpan(String str, String str2, String str3, String str4) {
        this.f38174a = str;
        this.f38175b = str2;
        this.f38176c = str3;
        this.f38177d = str4;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(this.f38174a));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Logger.m25808d("Span OnClick Key: " + this.f38175b + " mLink:" + this.f38176c + " mTitle:" + this.f38177d, new Object[0]);
        if (!TextUtil.isEmpty(this.f38175b)) {
            if (!TextUtil.isEmpty(this.f38176c)) {
                m26988a(this.f38176c, this.f38177d);
            } else if (!isNumber(this.f38175b)) {
            } else {
                if (this.f38175b.length() >= 11) {
                    m26989b(this.f38175b);
                } else {
                    view.performClick();
                }
            }
        }
    }

    /* renamed from: a */
    private void m26988a(String str, String str2) {
        Logger.m25808d("Basespan webview:" + str + " mTitle:" + str2, new Object[0]);
    }

    public boolean isNumber(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}

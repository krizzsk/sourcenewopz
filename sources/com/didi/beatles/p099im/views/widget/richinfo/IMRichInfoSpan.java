package com.didi.beatles.p099im.views.widget.richinfo;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.api.entity.IMRichInfo;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParseUtil;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.views.widget.richinfo.IMRichInfoSpan */
public class IMRichInfoSpan extends SpannableString {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10663a = IMRichInfoSpan.class.getSimpleName();

    public IMRichInfoSpan(CharSequence charSequence, IMRichInfo iMRichInfo) {
        super(charSequence);
        if (iMRichInfo != null && TextUtils.isEmpty(iMRichInfo.content)) {
            iMRichInfo.content = charSequence.toString();
        }
        m7276a(iMRichInfo);
    }

    public IMRichInfoSpan(IMRichInfo iMRichInfo) {
        super(iMRichInfo.content);
        m7276a(iMRichInfo);
    }

    /* renamed from: a */
    private void m7276a(IMRichInfo iMRichInfo) {
        if (iMRichInfo != null && m7277b(iMRichInfo)) {
            if (!TextUtils.isEmpty(iMRichInfo.content) && !TextUtils.isEmpty(iMRichInfo.contentColor)) {
                setSpan(new ForegroundColorSpan(iMRichInfo.contentColorValue), 0, iMRichInfo.content.length(), 18);
            }
            if (iMRichInfo.getBeans() != null && !iMRichInfo.getBeans().isEmpty()) {
                for (IMRichInfo.Bean next : iMRichInfo.getBeans()) {
                    if (next.startPosition < iMRichInfo.content.length() && next.startPosition <= next.endPosition) {
                        if (next.endPosition >= iMRichInfo.content.length()) {
                            next.endPosition = iMRichInfo.content.length() - 1;
                        }
                        if (!TextUtils.isEmpty(next.link)) {
                            setSpan(new ClickSpan(next.link, iMRichInfo), next.startPosition, next.endPosition + 1, 33);
                        }
                        if (!TextUtils.isEmpty(next.colorString)) {
                            setSpan(new ForegroundColorSpan(next.colorStringValue), next.startPosition, next.endPosition + 1, 33);
                        }
                        if (!TextUtils.isEmpty(next.bgColorString)) {
                            setSpan(new BackgroundColorSpan(next.bgColorStringValue), next.startPosition, next.endPosition + 1, 33);
                        }
                        if (next.isBold()) {
                            setSpan(new StyleSpan(1), next.startPosition, next.endPosition + 1, 33);
                        }
                        if (next.realSize > 0) {
                            setSpan(new AbsoluteSizeSpan(next.realSize, true), next.startPosition, next.endPosition + 1, 33);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private int m7274a(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            return Color.parseColor(str.trim());
        }
        return Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + str);
    }

    /* renamed from: b */
    private boolean m7277b(IMRichInfo iMRichInfo) {
        try {
            iMRichInfo.contentColorValue = m7274a(iMRichInfo.contentColor);
            if (iMRichInfo.getBeans() == null) {
                return true;
            }
            for (IMRichInfo.Bean next : iMRichInfo.getBeans()) {
                try {
                    next.colorStringValue = m7274a(next.colorString);
                    try {
                        next.bgColorStringValue = m7274a(next.bgColorString);
                        if (!TextUtils.isEmpty(next.size)) {
                            try {
                                next.realSize = IMParseUtil.parseInt(next.size.trim()) / 2;
                            } catch (Exception e) {
                                IMLog.m6633e(e);
                            }
                        }
                    } catch (Exception e2) {
                        IMLog.m6633e(e2);
                        return false;
                    }
                } catch (Exception e3) {
                    IMLog.m6633e(e3);
                    return false;
                }
            }
            return true;
        } catch (Exception e4) {
            IMLog.m6633e(e4);
            return false;
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.richinfo.IMRichInfoSpan$ClickSpan */
    public static class ClickSpan extends ClickableSpan {
        private IMClickSpanListener clickSpanListener;
        private final String uri;

        public ClickSpan(String str, IMClickSpanListener iMClickSpanListener) {
            this.uri = str;
            this.clickSpanListener = iMClickSpanListener;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            String a = IMRichInfoSpan.f10663a;
            IMLog.m6631d(a, "[ClickSpan] #onClick# " + this.uri);
            IMClickSpanListener iMClickSpanListener = this.clickSpanListener;
            if (iMClickSpanListener != null) {
                iMClickSpanListener.spanClicked(view, this.uri);
            }
            if (!TextUtils.isEmpty(this.uri)) {
                IMCommonUtil.startUriActivity(view.getContext(), this.uri, (Object) null);
            }
        }
    }
}

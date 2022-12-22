package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DisplayUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalTypeFaceSpan;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RichTextInfo implements Serializable {
    @SerializedName("info")
    private List<RichInfo> infoList;
    /* access modifiers changed from: private */
    public RichTextInfoClickListener listener;
    @SerializedName("text")
    private String text;

    public static class RichInfo implements Serializable {
        int bold;
        String color;
        @SerializedName("font_size")
        int fontSize;
        int italic;
        int length;
        String link;
        int start;
        int through;
    }

    public interface RichTextInfoClickListener {
        void onClick(String str);
    }

    public RichTextInfo setInfo(String str) {
        RichTextInfo richTextInfo = null;
        try {
            if (TextUtils.isEmpty(str) || !str.contains(Const.joLeft) || !str.contains("}")) {
                this.text = str;
            } else {
                richTextInfo = (RichTextInfo) new Gson().fromJson(str, RichTextInfo.class);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        if (richTextInfo != null) {
            this.text = richTextInfo.text;
            this.infoList = richTextInfo.infoList;
        }
        return this;
    }

    public String getContent() {
        return this.text;
    }

    public RichTextInfo setOnClickListener(RichTextInfoClickListener richTextInfoClickListener) {
        this.listener = richTextInfoClickListener;
        return this;
    }

    public void bindTo(TextView textView) {
        List<RichInfo> list;
        if (textView != null) {
            if (TextUtils.isEmpty(this.text) || (list = this.infoList) == null || list.size() == 0) {
                textView.setText(this.text);
                return;
            }
            try {
                textView.setText(parseRichInfo(textView.getContext()));
            } catch (Exception e) {
                textView.setText(this.text);
                e.printStackTrace();
            }
        }
    }

    private SpannableString parseRichInfo(Context context) {
        SpannableString spannableString = new SpannableString(this.text);
        for (final RichInfo next : this.infoList) {
            if (next != null && next.start + next.length <= this.text.length()) {
                int i = next.start + next.length;
                if (!TextUtils.isEmpty(next.color)) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(next.color)), next.start, i, 18);
                }
                Typeface didiTypeface = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(3));
                Typeface didiTypeface2 = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(1));
                Typeface didiTypeface3 = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(2));
                if ((next.bold & next.italic) == 1) {
                    spannableString.setSpan(new GlobalTypeFaceSpan(didiTypeface), next.start, i, 18);
                } else if ((next.bold | next.italic) == 1) {
                    if (next.italic == 1) {
                        didiTypeface2 = didiTypeface3;
                    }
                    spannableString.setSpan(new GlobalTypeFaceSpan(didiTypeface2), next.start, i, 18);
                }
                if (next.through == 1) {
                    spannableString.setSpan(new StrikethroughSpan(), next.start, i, 18);
                }
                if (next.fontSize > 0) {
                    spannableString.setSpan(new AbsoluteSizeSpan(getTextSize(context, next.fontSize)), next.start, i, 18);
                }
                if (!TextUtils.isEmpty(next.link)) {
                    spannableString.setSpan(new ClickableSpan() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (RichTextInfo.this.listener != null) {
                                RichTextInfo.this.listener.onClick(next.link);
                            }
                        }
                    }, next.start, i, 18);
                }
            }
        }
        return spannableString;
    }

    private int getTextSize(Context context, int i) {
        return DisplayUtils.dp2px(context, (float) (i / 2));
    }
}

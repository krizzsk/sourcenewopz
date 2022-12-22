package com.didi.map.global.flow.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class GlobalRichInfo implements Serializable {
    @SerializedName("info")
    private List<RichInfo> infoList;
    /* access modifiers changed from: private */
    public RichInfoClickListener listener;
    @SerializedName("text")
    private String text;

    public static class RichInfo implements Serializable {
        int bold;
        String color;
        @SerializedName("font_size")
        int fontSize;
        int length;
        String link;
        int start;
        int through;
    }

    public interface RichInfoClickListener {
        void onClick(String str);
    }

    public GlobalRichInfo setInfo(String str) {
        GlobalRichInfo globalRichInfo;
        try {
            globalRichInfo = (GlobalRichInfo) new Gson().fromJson(str, GlobalRichInfo.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            globalRichInfo = null;
        }
        if (globalRichInfo != null) {
            this.text = globalRichInfo.text;
            this.infoList = globalRichInfo.infoList;
        }
        return this;
    }

    public String getContent() {
        return this.text;
    }

    public GlobalRichInfo setOnClickListener(RichInfoClickListener richInfoClickListener) {
        this.listener = richInfoClickListener;
        return this;
    }

    public void bindTextView(TextView textView) {
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
                if (next.bold == 1) {
                    spannableString.setSpan(new StyleSpan(1), next.start, i, 18);
                }
                if (next.through == 1) {
                    spannableString.setSpan(new StrikethroughSpan(), next.start, i, 18);
                }
                if (!TextUtils.isEmpty(next.link)) {
                    spannableString.setSpan(new ClickableSpan() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (GlobalRichInfo.this.listener != null) {
                                GlobalRichInfo.this.listener.onClick(next.link);
                            }
                        }
                    }, next.start, i, 18);
                }
            }
        }
        return spannableString;
    }
}

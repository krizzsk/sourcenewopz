package com.didi.travel.psnger.model.response;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
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
        public int bold;
        public String color;
        @SerializedName("font_size")
        public int fontSize;
        public int length;
        public String link;
        public int start;
        public int through;
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

    public void setContent(String str) {
        this.text = str;
    }

    public void setInfoList(List<RichInfo> list) {
        this.infoList = list;
    }

    public List<RichInfo> getInfoList() {
        return this.infoList;
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

    public SpannableString parseRichInfo(Context context) {
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
                if (next.fontSize > 0) {
                    spannableString.setSpan(new AbsoluteSizeSpan(getTextSize(next.fontSize, context)), next.start, i, 18);
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

    private int getTextSize(int i, Context context) {
        return UIUtils.dip2pxInt(context, (float) (i / 2));
    }

    public int getRichTextSize(int i) {
        List<RichInfo> list = this.infoList;
        if (list == null || list.size() <= i) {
            return 0;
        }
        return this.infoList.get(i).fontSize;
    }

    public String getRichTextColor(int i) {
        List<RichInfo> list = this.infoList;
        return (list == null || list.size() <= i) ? "" : this.infoList.get(i).color;
    }

    public void updateText(String str) {
        this.text = str;
    }
}

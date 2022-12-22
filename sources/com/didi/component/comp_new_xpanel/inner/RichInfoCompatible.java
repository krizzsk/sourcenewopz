package com.didi.component.comp_new_xpanel.inner;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RichInfoCompatible implements Serializable {
    private String color;
    @SerializedName("info")
    private List<RichInfo> infoList;
    /* access modifiers changed from: private */
    public RichInfoClickListener listener;
    private int size;
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
        int script;
        int start;
        int through;
    }

    public interface RichInfoClickListener {
        void onClick(String str);
    }

    public RichInfoCompatible setInfo(String str) {
        RichInfoCompatible richInfoCompatible;
        try {
            richInfoCompatible = (RichInfoCompatible) new Gson().fromJson(str, RichInfoCompatible.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            richInfoCompatible = null;
        }
        if (richInfoCompatible != null) {
            this.text = richInfoCompatible.text;
            this.infoList = richInfoCompatible.infoList;
        }
        return this;
    }

    public String getContent() {
        return this.text;
    }

    public RichInfoCompatible setOnClickListener(RichInfoClickListener richInfoClickListener) {
        this.listener = richInfoClickListener;
        return this;
    }

    public void bindTextView(TextView textView) {
        List<RichInfo> list;
        if (textView != null) {
            if (TextUtils.isEmpty(this.text) || (list = this.infoList) == null || list.size() == 0) {
                textView.setText(this.text);
                if (!TextUtils.isEmpty(this.color)) {
                    textView.setTextColor(Color.parseColor(this.color));
                }
                int i = this.size;
                if (i != 0) {
                    textView.setTextSize((float) i);
                    return;
                }
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
                if ((next.bold & next.italic) == 1) {
                    spannableString.setSpan(new StyleSpan(3), next.start, i, 18);
                } else if ((next.bold | next.italic) == 1) {
                    spannableString.setSpan(new StyleSpan(next.italic == 1 ? 2 : 1), next.start, i, 18);
                }
                if (next.through == 1) {
                    spannableString.setSpan(new StrikethroughSpan(), next.start, i, 18);
                }
                if (next.fontSize > 0) {
                    spannableString.setSpan(new AbsoluteSizeSpan(getTextSize(next.fontSize, context)), next.start, i, 18);
                }
                if (next.script == 1) {
                    spannableString.setSpan(new SuperscriptSpan(), next.start, i, 33);
                } else if (next.script == 2) {
                    spannableString.setSpan(new SubscriptSpan(), next.start, i, 33);
                }
                if (!TextUtils.isEmpty(next.link)) {
                    spannableString.setSpan(new ClickableSpan() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (RichInfoCompatible.this.listener != null) {
                                RichInfoCompatible.this.listener.onClick(next.link);
                            }
                        }
                    }, next.start, i, 18);
                }
            }
        }
        return spannableString;
    }

    private int getTextSize(int i, Context context) {
        return UiUtils.dip2px(context, (float) (i / 2));
    }
}

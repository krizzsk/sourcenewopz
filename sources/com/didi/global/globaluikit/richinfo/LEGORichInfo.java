package com.didi.global.globaluikit.richinfo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.richinfo.LEGORichInfoExtra;
import com.didi.global.globaluikit.richinfo.model.CustomViewSpanModel;
import com.didi.global.globaluikit.richinfo.model.RichInfoExtraModel;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalTypeFaceSpan;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LEGORichInfo implements Serializable {
    @SerializedName("extra_item")
    private List<RichInfoExtraModel> extraItems;
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
        @SerializedName("font_weight")
        int fontWeight;
        int italic;
        public int length;
        String link;
        int script;
        public int start;
        int through;
    }

    public interface RichInfoClickListener {
        void onClick(String str);
    }

    public LEGORichInfo setInfo(String str) {
        LEGORichInfo lEGORichInfo;
        try {
            lEGORichInfo = (LEGORichInfo) new Gson().fromJson(str, LEGORichInfo.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            lEGORichInfo = null;
        }
        if (lEGORichInfo != null) {
            this.text = lEGORichInfo.text;
            this.infoList = lEGORichInfo.infoList;
            this.extraItems = lEGORichInfo.extraItems;
        }
        return this;
    }

    public List<RichInfoExtraModel> getExtraItems() {
        return this.extraItems;
    }

    public String getContent() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setInfoList(List<RichInfo> list) {
        this.infoList = list;
    }

    public List<RichInfo> getInfoList() {
        return this.infoList;
    }

    public LEGORichInfo setOnClickListener(RichInfoClickListener richInfoClickListener) {
        this.listener = richInfoClickListener;
        return this;
    }

    public void bindTextView(final TextView textView) {
        bindTextView(textView, new SpannableCallback() {
            public boolean beforeSpannableCreated(LEGORichInfo lEGORichInfo) {
                return false;
            }

            public void onSpannableCreated(SpannableString spannableString) {
                textView.setText(spannableString);
            }
        });
    }

    public void bindTextView(TextView textView, SpannableCallback spannableCallback) {
        List<RichInfo> list;
        if (textView != null) {
            if (TextUtils.isEmpty(this.text) || (list = this.infoList) == null || list.size() == 0) {
                textView.setText(this.text);
                return;
            }
            if (spannableCallback != null) {
                try {
                    if (!spannableCallback.beforeSpannableCreated(this)) {
                        textView.setText(this.text);
                    }
                } catch (Exception e) {
                    textView.setText(this.text);
                    e.printStackTrace();
                    return;
                }
            }
            parseRichInfo(textView.getContext(), spannableCallback);
        }
    }

    public void parseRichInfo(Context context, final SpannableCallback spannableCallback) {
        final SpannableString parseRichInfo = parseRichInfo(context);
        List<RichInfoExtraModel> list = this.extraItems;
        if (list != null && !list.isEmpty()) {
            new LEGORichInfoExtra(context).mo67094a(this.extraItems, (LEGORichInfoExtra.SpansCallback) new LEGORichInfoExtra.SpansCallback() {
                public void onSpansLoaded(List<CustomViewSpanModel> list) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parseRichInfo);
                    for (CustomViewSpanModel next : list) {
                        spannableStringBuilder.insert(next.index, " ");
                        spannableStringBuilder.setSpan(next.span, next.index, next.index + 1, 33);
                    }
                    SpannableCallback spannableCallback = spannableCallback;
                    if (spannableCallback != null) {
                        spannableCallback.onSpannableCreated(SpannableString.valueOf(spannableStringBuilder));
                    }
                }
            });
        } else if (spannableCallback != null) {
            spannableCallback.onSpannableCreated(parseRichInfo);
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
                Typeface didiTypeface = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(3));
                Typeface didiTypeface2 = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(1));
                Typeface didiTypeface3 = DIDIFontUtils.Companion.getDidiTypeface(context, Typeface.defaultFromStyle(2));
                if (next.fontWeight > 0) {
                    spannableString.setSpan(new GlobalTypeFaceSpan(DIDIFontUtils.Companion.getDidiTypefaceByWeight(context, next.fontWeight, next.italic == 1)), next.start, i, 18);
                } else if ((next.bold & next.italic) == 1) {
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
                            if (LEGORichInfo.this.listener != null) {
                                LEGORichInfo.this.listener.onClick(next.link);
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

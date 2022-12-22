package com.didi.payment.wallet.global.useraccount.balance.model;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.utils.TextUtils;
import com.didi.payment.base.utils.UIUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class BalanceResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("nextIndex")
        public int nextIndex;
        @SerializedName("statement")
        public List<StatementBean> statement;
    }

    public static class StatementBean implements Serializable {
        @SerializedName("amountText")
        public AmountRichInfo amountText;
        @SerializedName("title")
        public String title;
        @SerializedName("transDate")
        public String transDate;
        @SerializedName("transId")
        public String transId;
    }

    public static class AmountRichInfo implements Serializable {
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
            int italic;
            int length;
            String link;
            int start;
            int through;
        }

        public interface RichInfoClickListener {
            void onClick(String str);
        }

        public AmountRichInfo setInfo(String str) {
            AmountRichInfo amountRichInfo;
            try {
                amountRichInfo = (AmountRichInfo) new Gson().fromJson(str, AmountRichInfo.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                amountRichInfo = null;
            }
            if (amountRichInfo != null) {
                this.text = amountRichInfo.text;
                this.infoList = amountRichInfo.infoList;
            }
            return this;
        }

        public String getContent() {
            return this.text;
        }

        public AmountRichInfo setOnClickListener(RichInfoClickListener richInfoClickListener) {
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
                    if (next.italic == 1) {
                        spannableString.setSpan(new StyleSpan(2), next.start, i, 18);
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
                                if (AmountRichInfo.this.listener != null) {
                                    AmountRichInfo.this.listener.onClick(next.link);
                                }
                            }
                        }, next.start, i, 18);
                    }
                }
            }
            return spannableString;
        }

        private int getTextSize(int i, Context context) {
            return UIUtil.dip2px(context, (float) (i / 2));
        }
    }
}

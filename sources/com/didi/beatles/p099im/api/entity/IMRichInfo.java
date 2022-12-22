package com.didi.beatles.p099im.api.entity;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.didi.beatles.p099im.views.widget.richinfo.IMClickSpanListener;
import com.didi.beatles.p099im.views.widget.richinfo.IMRichInfoSpan;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMRichInfo */
public class IMRichInfo implements IMClickSpanListener, Serializable {
    @SerializedName("rich_info")
    public List<Bean> beans;
    @SerializedName("content")
    public String content;
    @SerializedName("ccolor")
    public String contentColor;
    public transient int contentColorValue;
    public transient boolean isSpanClicked = false;
    private transient IMClickSpanListener mClickSpanListener;

    public List<Bean> getBeans() {
        return this.beans;
    }

    public void setClickSpanListener(IMClickSpanListener iMClickSpanListener) {
        this.mClickSpanListener = iMClickSpanListener;
    }

    public void spanClicked(View view, String str) {
        this.isSpanClicked = true;
        IMClickSpanListener iMClickSpanListener = this.mClickSpanListener;
        if (iMClickSpanListener != null) {
            iMClickSpanListener.spanClicked(view, str);
        }
    }

    public void bindView(TextView textView) {
        if (textView != null) {
            setRichInfo(textView);
        }
    }

    private void setRichInfo(TextView textView) {
        boolean z;
        textView.setVisibility(0);
        if (!TextUtils.isEmpty(this.content)) {
            this.content = this.content.replace("\\n", "\n");
            textView.setText(new IMRichInfoSpan(this));
            List<Bean> list = this.beans;
            if (list != null) {
                Iterator<Bean> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!TextUtils.isEmpty(it.next().link)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            textView.setIncludeFontPadding(false);
            return;
        }
        textView.setVisibility(8);
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content);
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMRichInfo$Bean */
    public static class Bean implements Serializable {
        @SerializedName("bgcolor")
        public String bgColorString;
        public transient int bgColorStringValue;
        @SerializedName("bold")
        public int bold;
        @SerializedName("rcolor")
        public String colorString;
        public transient int colorStringValue;
        @SerializedName("rend")
        public int endPosition;
        @SerializedName("rlink")
        public String link;
        public transient int realSize;
        @SerializedName("size")
        public String size;
        @SerializedName("rstart")
        public int startPosition;

        public boolean isBold() {
            return this.bold == 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Bean bean = (Bean) obj;
            if (this.startPosition != bean.startPosition || this.endPosition != bean.endPosition) {
                return false;
            }
            String str = this.colorString;
            if (str == null ? bean.colorString != null : !str.equals(bean.colorString)) {
                return false;
            }
            String str2 = this.bgColorString;
            if (str2 == null ? bean.bgColorString != null : !str2.equals(bean.bgColorString)) {
                return false;
            }
            String str3 = this.size;
            String str4 = bean.size;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.startPosition * 31) + this.endPosition) * 31;
            String str = this.colorString;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.bgColorString;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.size;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }
    }
}

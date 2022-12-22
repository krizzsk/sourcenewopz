package com.didi.payment.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.UIUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PayRichInfo implements Serializable {
    @SerializedName("info")
    public List<RichInfo> infoList;
    /* access modifiers changed from: private */
    public RichInfoClickListener listener;
    @SerializedName("text")
    public String text;

    public interface ISpannableString {
        SpannableStringBuilder parseRichInfo(Context context, SpannableStringBuilder spannableStringBuilder, String str, List<RichInfo> list, RichInfoClickListener richInfoClickListener);
    }

    public static class RichInfo implements Serializable {
        public int bold;
        String color;
        @SerializedName("font_size")
        int fontSize;
        int italic;
        public int length;
        String link;
        public int start;
        int through;
    }

    public interface RichInfoClickListener {
        void onClick(String str);
    }

    public PayRichInfo setInfo(String str) {
        PayRichInfo payRichInfo;
        try {
            payRichInfo = (PayRichInfo) new Gson().fromJson(str, PayRichInfo.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            payRichInfo = null;
        }
        if (payRichInfo != null) {
            this.text = payRichInfo.text;
            this.infoList = payRichInfo.infoList;
        }
        return this;
    }

    public String getContent() {
        return this.text;
    }

    public PayRichInfo setOnClickListener(RichInfoClickListener richInfoClickListener) {
        this.listener = richInfoClickListener;
        return this;
    }

    public void updateTextColor(String str) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.infoList)) {
            try {
                Color.parseColor(str);
                for (RichInfo richInfo : this.infoList) {
                    richInfo.color = str;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void bindTextView(TextView textView, ISpannableString iSpannableString) {
        List<RichInfo> list;
        if (textView != null) {
            if (TextUtils.isEmpty(this.text) || (list = this.infoList) == null || list.size() == 0) {
                textView.setText(this.text);
                return;
            }
            if (iSpannableString == null) {
                try {
                    iSpannableString = new DefaultSpannable();
                } catch (Exception e) {
                    textView.setText(this.text);
                    e.printStackTrace();
                    return;
                }
            }
            textView.setText(iSpannableString.parseRichInfo(textView.getContext(), (SpannableStringBuilder) null, this.text, this.infoList, this.listener));
        }
    }

    @Deprecated
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

    @Deprecated
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
                            if (PayRichInfo.this.listener != null) {
                                PayRichInfo.this.listener.onClick(next.link);
                            }
                        }
                    }, next.start, i, 18);
                }
            }
        }
        return spannableString;
    }

    /* access modifiers changed from: private */
    public static int getTextSize(int i, Context context) {
        return UIUtil.dip2px(context, (float) (i / 2));
    }

    public static void appendImageSpan(TextView textView, int i) {
        if (textView != null && i != 0) {
            Drawable drawable = textView.getResources().getDrawable(i);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            CenterVerticalImageSpan centerVerticalImageSpan = new CenterVerticalImageSpan(textView.getContext(), drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(centerVerticalImageSpan, 0, 1, 33);
            textView.append(spannableString);
        }
    }

    private static class CenterVerticalImageSpan extends ImageSpan {
        private int paddingLeft;

        public CenterVerticalImageSpan(Context context, Drawable drawable) {
            super(drawable);
            this.paddingLeft = UIUtil.dip2px(context, 10.0f);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = (bounds.bottom - bounds.top) / 2;
                int i5 = i3 / 4;
                int i6 = i4 - i5;
                int i7 = -(i4 + i5);
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                fontMetricsInt.bottom = i6;
                fontMetricsInt.descent = i6;
            }
            return bounds.right;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            canvas.save();
            Drawable drawable = getDrawable();
            Rect bounds = drawable.getBounds();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (fontMetricsInt != null) {
                canvas.translate(f + ((float) this.paddingLeft), (float) (((i4 + fontMetricsInt.descent) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((bounds.bottom - bounds.top) / 2)));
                drawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    public class RadiusBackgroundSpan extends ReplacementSpan {
        private int mColor;
        private int mRadius;
        private int mSize;
        private int paddingLR;

        public RadiusBackgroundSpan(int i, int i2, int i3) {
            this.mColor = i;
            this.mRadius = i2;
            this.paddingLR = i3;
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.paddingLR * 2)));
            this.mSize = measureText;
            return measureText;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            float f2 = f;
            Paint paint2 = paint;
            int color = paint.getColor();
            paint2.setColor(this.mColor);
            paint2.setAntiAlias(true);
            float f3 = (float) i4;
            RectF rectF = new RectF(f, paint.ascent() + f3, ((float) this.mSize) + f2, paint.descent() + f3);
            int i6 = this.mRadius;
            Canvas canvas2 = canvas;
            canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
            paint2.setColor(color);
            canvas.drawText(charSequence, i, i2, f2 + ((float) this.paddingLR), f3, paint2);
        }
    }

    public static class DefaultSpannable implements ISpannableString {
        public SpannableStringBuilder parseRichInfo(Context context, SpannableStringBuilder spannableStringBuilder, String str, List<RichInfo> list, final RichInfoClickListener richInfoClickListener) {
            if (spannableStringBuilder == null) {
                spannableStringBuilder = new SpannableStringBuilder(str);
            }
            for (final RichInfo next : list) {
                if (next != null && next.start + next.length <= str.length()) {
                    int i = next.start + next.length;
                    if (!TextUtils.isEmpty(next.color)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(next.color)), next.start, i, 18);
                    }
                    if (next.bold == 1) {
                        spannableStringBuilder.setSpan(new StyleSpan(1), next.start, i, 18);
                    }
                    if (next.italic == 1) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), next.start, i, 18);
                    }
                    if (next.through == 1) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), next.start, i, 18);
                    }
                    if (next.fontSize > 0) {
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(PayRichInfo.getTextSize(next.fontSize, context)), next.start, i, 18);
                    }
                    if (!TextUtils.isEmpty(next.link)) {
                        spannableStringBuilder.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                RichInfoClickListener richInfoClickListener = richInfoClickListener;
                                if (richInfoClickListener != null) {
                                    richInfoClickListener.onClick(next.link);
                                }
                            }
                        }, next.start, i, 18);
                    }
                }
            }
            return spannableStringBuilder;
        }
    }
}

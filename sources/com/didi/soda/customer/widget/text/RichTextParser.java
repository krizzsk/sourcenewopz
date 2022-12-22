package com.didi.soda.customer.widget.text;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.google.gson.JsonParseException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p071io.input.CharSequenceReader;

public final class RichTextParser {

    /* renamed from: a */
    private static final String f42233a = "RichTextParser";

    /* renamed from: b */
    private static final int f42234b = 4;

    /* renamed from: c */
    private static Pattern f42235c = Pattern.compile("&em#.*?&em#");

    private RichTextParser() {
    }

    public static CharSequence parseText(CharSequence charSequence) {
        return m29778a(charSequence, false);
    }

    public static CharSequence parseIconText(CharSequence charSequence) {
        return m29778a(charSequence, true);
    }

    public static int getRealTextLength(CharSequence charSequence) {
        return parseText(charSequence).length();
    }

    /* renamed from: a */
    private static CharSequence m29778a(CharSequence charSequence, boolean z) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = f42235c.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            if (i < matcher.start()) {
                spannableStringBuilder.append(charSequence.subSequence(i, matcher.start()));
            }
            int start = matcher.start() + 4;
            int end = matcher.end() - 4;
            if (start < end) {
                if (z) {
                    spannableStringBuilder.append(m29779b(charSequence.subSequence(start, end)));
                } else {
                    spannableStringBuilder.append(m29776a(charSequence.subSequence(start, end)));
                }
            }
            i = matcher.end();
        }
        if (i < charSequence.length()) {
            spannableStringBuilder.append(charSequence.subSequence(i, charSequence.length()));
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static SpannableString m29776a(CharSequence charSequence) {
        RichTextModel richTextModel;
        try {
            richTextModel = (RichTextModel) GsonUtil.fromJson((Reader) new CharSequenceReader(charSequence), (Type) RichTextModel.class);
        } catch (JsonParseException e) {
            LogUtil.m29104i(f42233a, "RichTextView produces Exception:" + e.toString());
            e.printStackTrace();
            richTextModel = null;
        }
        if (richTextModel == null) {
            richTextModel = new RichTextModel();
        }
        SpannableString spannableString = new SpannableString(richTextModel.mText);
        if (!"".equals(richTextModel.mColor)) {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(richTextModel.mColor)), 0, richTextModel.mText.length(), 17);
        }
        if (richTextModel.mStroke != 0) {
            spannableString.setSpan(new StrikethroughSpan(), 0, richTextModel.mText.length(), 17);
        }
        if (richTextModel.mSize > 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.dip2px(GlobalContext.getContext(), (float) richTextModel.mSize)), 0, richTextModel.mText.length(), 17);
        }
        if (richTextModel.mWeight > 0) {
            spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(m29777a(richTextModel.mWeight))), 0, richTextModel.mText.length(), 17);
        }
        return spannableString;
    }

    /* renamed from: b */
    private static SpannableString m29779b(CharSequence charSequence) {
        RichTextModel richTextModel;
        try {
            richTextModel = (RichTextModel) GsonUtil.fromJson((Reader) new CharSequenceReader(charSequence), (Type) RichTextModel.class);
        } catch (JsonParseException e) {
            LogUtil.m29104i(f42233a, "RichTextView produces Exception:" + e.toString());
            e.printStackTrace();
            richTextModel = null;
        }
        if (richTextModel == null) {
            richTextModel = new RichTextModel();
        }
        int identifier = GlobalContext.getContext().getResources().getIdentifier(richTextModel.mText, TypedValues.Custom.S_STRING, GlobalContext.getContext().getPackageName());
        if (identifier <= 0) {
            return m29776a(charSequence);
        }
        try {
            String string = ResourceHelper.getString(identifier);
            SpannableString spannableString = new SpannableString(string);
            if (!"".equals(richTextModel.mColor)) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(richTextModel.mColor)), 0, string.length(), 17);
            }
            if (richTextModel.mStroke != 0) {
                spannableString.setSpan(new StrikethroughSpan(), 0, string.length(), 17);
            }
            if (richTextModel.mSize > 0) {
                spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.dip2px(GlobalContext.getContext(), (float) richTextModel.mSize)), 0, string.length(), 17);
            }
            if (richTextModel.mWeight > 0) {
                spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(m29777a(richTextModel.mWeight))), 0, string.length(), 17);
            }
            return spannableString;
        } catch (Exception unused) {
            return m29776a(charSequence);
        }
    }

    /* renamed from: a */
    private static IToolsService.FontType m29777a(int i) {
        if (i == 2) {
            return IToolsService.FontType.MEDIUM;
        }
        if (i == 3) {
            return IToolsService.FontType.BOLD;
        }
        if (i != 4) {
            return IToolsService.FontType.NORMAL;
        }
        return IToolsService.FontType.LIGHT;
    }
}

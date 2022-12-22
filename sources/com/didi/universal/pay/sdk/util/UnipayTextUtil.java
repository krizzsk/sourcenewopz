package com.didi.universal.pay.sdk.util;

import android.content.Context;
import android.net.Uri;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.util.TextUtil;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnipayTextUtil extends SpannableStringBuilder {
    private static final String NEW_LINE_SYMBOL = "&#10;";
    private static final String REGEX_NUM = "(([0-9]*\\.?[0-9]+)*,?[0-9]*)";
    private CharSequence mContent;

    public static String encode(String str) {
        return "";
    }

    public static String[] getStringArray(Context context, int i) {
        return null;
    }

    public static void setTextColorList(Context context, TextView textView, int i) {
    }

    public UnipayTextUtil(CharSequence charSequence) {
        super(charSequence);
        this.mContent = charSequence;
    }

    public static boolean containIllegalChar(String str) {
        return Pattern.matches(".*[`~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]+.*", str);
    }

    public static boolean containIllegalCharCompany(String str) {
        return Pattern.matches(".*[`~!@#$%^&*+=|{}':;',\\[\\]./?~！@#￥%……&*+|{}【】‘；：”“’。，、？]+.*", str);
    }

    public static boolean containIllegalCharUserDes(String str) {
        return Pattern.matches(".*[`@#$%^&*+=|{}''\\[\\].<>/@#￥%……&*——+|{}【】]+.*", str);
    }

    public static boolean isIllegalCharText(String str) {
        return Pattern.matches("[`~!@#$%^&*+=|{}':;',\\[\\]./?~！@#￥%……&*+|{}【】‘；：”“’。，、？]+", str);
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equals("null")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return isEmpty(charSequence.toString());
    }

    public static String escapeFileName(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '/' || charAt == '\\' || charAt == ':' || charAt == '*' || charAt == '?' || charAt == '\"' || charAt == '<' || charAt == '>' || charAt == '|')) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String getIdFromUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".jpg");
        if (lastIndexOf < 0) {
            lastIndexOf = str.length() - 1;
        }
        return str.substring(Math.max(Math.max(str.lastIndexOf("/") + 1, str.lastIndexOf("%2F") + 3), str.lastIndexOf("%252F") + 5), lastIndexOf);
    }

    public static String getIdFromUrl(String str) {
        return getIdFromUrl(str, (String) null);
    }

    public static String trim(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return str.trim();
    }

    public static String trimInner(String str) {
        if (isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\s+)").matcher(str);
        while (matcher.find()) {
            str = str.replaceFirst(matcher.group(1), " ");
        }
        return str;
    }

    public static String getString(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static CharSequence getString(Context context, int i, int i2) {
        return getString(context, i, getString(context, i2));
    }

    public static String getString(Context context, int i, String str) {
        return context.getString(i);
    }

    public static boolean equals(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.trim().equals(str2.trim());
    }

    public static boolean isCoordinateEmpty(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        try {
            if (trim.length() == 0 || trim.equals("null") || Double.parseDouble(trim) == 0.0d) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String cleanPassword(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return str.replaceAll("[^\\x00-\\xff]*|\\s*", "");
    }

    public static void cleanPasswordEditText(EditText editText, TextWatcher textWatcher) {
        Object tag = editText.getTag();
        if (tag != null) {
            try {
                editText.setSelection(((Integer) tag).intValue());
                editText.setTag((Object) null);
            } catch (ClassCastException unused) {
            }
        } else {
            String obj = editText.getText().toString();
            int selectionStart = editText.getSelectionStart();
            int length = obj.length();
            String cleanPassword = cleanPassword(obj);
            int length2 = selectionStart - (length - cleanPassword.length());
            if (length2 < 0) {
                length2 = 0;
            }
            editText.setTag(Integer.valueOf(length2));
            editText.setText(cleanPassword);
        }
    }

    public static void setPasswordFilter(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return UnipayTextUtil.cleanPassword(charSequence.toString());
            }
        }});
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String getIdString(View view) {
        return String.valueOf(view.getId());
    }

    public static String ToSBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                charArray[i] = 12288;
            } else if (charArray[i] < 127) {
                charArray[i] = (char) (charArray[i] + 65248);
            }
        }
        return new String(charArray);
    }

    public static String ToDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 12288) {
                charArray[i] = ' ';
            } else if (charArray[i] > 65280 && charArray[i] < 65375) {
                charArray[i] = (char) (charArray[i] - 65248);
            }
        }
        return new String(charArray);
    }

    public static void setTextColor(Context context, TextView textView, int i) {
        textView.setTextColor(context.getResources().getColor(i));
    }

    public static String valueOf(float f) {
        if (Float.isNaN(f)) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format((double) f);
    }

    public static long paseLong(String str) {
        if (isEmpty(str)) {
            return Long.MIN_VALUE;
        }
        try {
            return Long.parseLong(str);
        } catch (ClassCastException unused) {
            return Long.MIN_VALUE;
        }
    }

    public static String getHtmlFontColorText(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replaceAll("[{]", "<font color='" + str2 + "'>").replaceAll("[}]", "</font>");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getFirstMoneyFromText(String str) {
        if (isEmpty(str)) {
            return "0";
        }
        Matcher matcher = Pattern.compile(REGEX_NUM).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "0";
    }

    public static String format(long j) {
        float f = ((float) j) / 100.0f;
        if (f == 0.0f) {
            return DCryptoMainFragment.DCRYPTO_ZERO;
        }
        return String.format("%.2f", new Object[]{Float.valueOf(f)});
    }

    public SpannableStringBuilder spanNumSize(float f) {
        Matcher matcher = Pattern.compile(REGEX_NUM).matcher(this.mContent);
        while (matcher.find()) {
            spanSize(f, matcher.start(), matcher.end());
        }
        return this;
    }

    private void spanSize(float f, int i, int i2) {
        setSpan(new RelativeSizeSpan(f), i, i2, 33);
    }

    public static String handleString(String str) {
        if (TextUtil.isEmpty(str)) {
            return str;
        }
        return str.replace(NEW_LINE_SYMBOL, "\n");
    }

    public static String buildExtURLParams(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        return buildUpon.build().toString();
    }
}

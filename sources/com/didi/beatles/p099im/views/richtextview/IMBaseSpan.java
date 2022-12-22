package com.didi.beatles.p099im.views.richtextview;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.beatles.im.views.richtextview.IMBaseSpan */
public class IMBaseSpan {

    /* renamed from: a */
    private String f10437a;

    /* renamed from: b */
    private String f10438b;

    public String getmLink() {
        return this.f10437a;
    }

    public void setmLink(String str) {
        this.f10437a = str;
    }

    public String getmTitle() {
        return this.f10438b;
    }

    public void setmTitle(String str) {
        this.f10438b = str;
    }

    /* access modifiers changed from: protected */
    public ArrayList<IMSpan> getSpans(String str, String str2) {
        String str3;
        ArrayList<IMSpan> arrayList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        Matcher matcher = Pattern.compile("(\\u007B)(.*?)(\\u007D)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int indexOf = str.indexOf(matcher.group());
            String[] split = group.split("\\|\\|");
            if (split.length >= 1) {
                str3 = split[0].replace(Const.joLeft, "").replace("}", "");
            } else {
                str3 = "";
            }
            if (split.length >= 2) {
                setmLink(split[1].replace(Const.joLeft, "").replace("}", ""));
            }
            if (split.length >= 3) {
                setmTitle(split[2].replace(Const.joLeft, "").replace("}", ""));
            }
            try {
                matcher.appendReplacement(stringBuffer, str3);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            str = str.replaceFirst("(\\u007B)(.*?)(\\u007D)", str3);
            IMSpan iMSpan = new IMSpan();
            iMSpan.spanStart = indexOf;
            iMSpan.spanEnd = indexOf + str3.length();
            iMSpan.key = str3;
            iMSpan.link = getmLink();
            iMSpan.title = getmTitle();
            arrayList.add(iMSpan);
        }
        matcher.appendTail(stringBuffer);
        IMSpan iMSpan2 = new IMSpan();
        iMSpan2.source = stringBuffer.toString();
        arrayList.add(0, iMSpan2);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public IMSpan keywordNoDisplay(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        Matcher matcher = Pattern.compile("(\\u007B)(.*?)(\\u007D)").matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        IMSpan iMSpan = new IMSpan();
        iMSpan.source = stringBuffer.toString();
        return iMSpan;
    }
}

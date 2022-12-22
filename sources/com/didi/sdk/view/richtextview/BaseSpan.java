package com.didi.sdk.view.richtextview;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseSpan {

    /* renamed from: a */
    private String f38172a;

    /* renamed from: b */
    private String f38173b;

    public String getmLink() {
        return this.f38172a;
    }

    public void setmLink(String str) {
        this.f38172a = str;
    }

    public String getmTitle() {
        return this.f38173b;
    }

    public void setmTitle(String str) {
        this.f38173b = str;
    }

    /* access modifiers changed from: protected */
    public ArrayList<Span> getSpans(String str, String str2) {
        String str3;
        ArrayList<Span> arrayList = new ArrayList<>();
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
            Span span = new Span();
            span.spanStart = indexOf;
            span.spanEnd = indexOf + str3.length();
            span.key = str3;
            span.link = getmLink();
            span.title = getmTitle();
            arrayList.add(span);
        }
        matcher.appendTail(stringBuffer);
        Span span2 = new Span();
        span2.source = stringBuffer.toString();
        arrayList.add(0, span2);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Span keywordNoDisplay(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        Matcher matcher = Pattern.compile("(\\u007B)(.*?)(\\u007D)").matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        Span span = new Span();
        span.source = stringBuffer.toString();
        return span;
    }
}

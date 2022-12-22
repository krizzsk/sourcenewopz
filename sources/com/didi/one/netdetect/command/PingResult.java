package com.didi.one.netdetect.command;

import android.text.TextUtils;
import com.didi.one.netdetect.util.PingParse;
import java.util.List;

public class PingResult {

    /* renamed from: a */
    private String f29429a;

    /* renamed from: b */
    private String f29430b;

    /* renamed from: c */
    private String f29431c;

    /* renamed from: d */
    private int f29432d;

    /* renamed from: e */
    private int f29433e;

    /* renamed from: f */
    private int f29434f;

    /* renamed from: g */
    private float f29435g;

    public PingResult(int i, String str, String str2) {
        this.f29429a = str;
        this.f29430b = str2;
        this.f29432d = i;
        if (TextUtils.isEmpty(str)) {
            this.f29431c = "";
            this.f29435g = -1.0f;
            this.f29434f = i;
            return;
        }
        m20740a();
    }

    /* renamed from: a */
    private void m20740a() {
        this.f29431c = PingParse.getIP(this.f29429a);
        List<String> time = PingParse.getTime(this.f29429a);
        int size = time.size();
        this.f29433e = size;
        this.f29434f = this.f29432d - size;
        if (size == 0) {
            this.f29435g = -1.0f;
            return;
        }
        float f = 0.0f;
        for (String parseFloat : time) {
            try {
                f += Float.parseFloat(parseFloat);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        this.f29435g = f / ((float) this.f29433e);
    }

    public String getNormalValue() {
        return this.f29429a;
    }

    public void setNormalValue(String str) {
        this.f29429a = str;
    }

    public String getIp() {
        return this.f29431c;
    }

    public void setIp(String str) {
        this.f29431c = str;
    }

    public int getSucCount() {
        return this.f29433e;
    }

    public void setSucCount(int i) {
        this.f29433e = i;
    }

    public int getFailCount() {
        return this.f29434f;
    }

    public void setFailCount(int i) {
        this.f29434f = i;
    }

    public float getAverageTime() {
        return this.f29435g;
    }

    public void setAverageTime(float f) {
        this.f29435g = f;
    }

    public int getTotalCount() {
        return this.f29432d;
    }

    public void setTotalCount(int i) {
        this.f29432d = i;
    }

    public boolean isFailAll() {
        return !TextUtils.isEmpty(this.f29429a) && this.f29434f == this.f29432d;
    }

    public String getErrValue() {
        return this.f29430b;
    }

    public void setErrValue(String str) {
        this.f29430b = str;
    }

    public String toString() {
        return "PingResult{normalValue='" + this.f29429a + '\'' + ", errValue='" + this.f29430b + '\'' + ", ip='" + this.f29431c + '\'' + ", totalCount=" + this.f29432d + ", sucCount=" + this.f29433e + ", failCount=" + this.f29434f + ", averageTime=" + this.f29435g + '}';
    }
}

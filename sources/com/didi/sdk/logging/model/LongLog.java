package com.didi.sdk.logging.model;

import android.os.Process;
import android.text.TextUtils;
import com.didi.sdk.logging.Level;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class LongLog extends AbstractLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f36573a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object[] f36574b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Date f36575c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f36576d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f36577e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f36578f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f36579g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f36580h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f36581i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map<?, ?> f36582j;

    public String getContent() {
        Object[] objArr;
        String str = this.f36573a;
        if (this.f36579g && (objArr = this.f36574b) != null && objArr.length > 0) {
            try {
                str = String.format(Locale.getDefault(), this.f36573a, this.f36574b);
            } catch (Exception unused) {
            }
        }
        if (!this.f36579g || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        sb.append(this.logLevel.name);
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(LoggerUtils.formatForLogHead(this.f36575c));
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(this.f36580h);
        sb.append(":");
        sb.append(this.f36581i);
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(this.f36576d);
        sb.append(Const.jaRight);
        sb.append("||msg=");
        sb.append(str);
        sb.append("||");
        Map<?, ?> map = this.f36582j;
        if (map != null) {
            sb.append(map.toString());
        }
        sb.append(Const.jaLeft);
        sb.append(Process.myPid());
        sb.append("-");
        sb.append(this.f36577e);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public String getTag() {
        String str = this.f36576d;
        return str == null ? "" : str;
    }

    public String getMsg() {
        Object[] objArr = this.f36574b;
        if (objArr != null && objArr.length > 0) {
            try {
                return String.format(Locale.getDefault(), this.f36573a, this.f36574b);
            } catch (Exception unused) {
            }
        }
        return this.f36573a;
    }

    public byte[] getData() {
        throw new UnsupportedOperationException();
    }

    public static final class Builder {
        private Level logLevel;
        private Object[] mArgs;
        private String mClassName;
        private Date mDate;
        private boolean mFormat = true;
        private int mLine;
        private String mMsg;
        private String mTag;
        private int mTid;
        private String mTnm;
        private Map<?, ?> userInfo;

        public static Builder create() {
            return new Builder();
        }

        public Builder setMsg(String str) {
            this.mMsg = str;
            return this;
        }

        public Builder setLogLevel(Level level) {
            this.logLevel = level;
            return this;
        }

        public Builder setArgs(Object[] objArr) {
            this.mArgs = objArr;
            return this;
        }

        public Builder setDate(Date date) {
            this.mDate = date;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setTid(int i) {
            this.mTid = i;
            return this;
        }

        public Builder setTnm(String str) {
            this.mTnm = str;
            return this;
        }

        public Builder setFormat(boolean z) {
            this.mFormat = z;
            return this;
        }

        public Builder setClassName(String str) {
            this.mClassName = str;
            return this;
        }

        public Builder setLine(int i) {
            this.mLine = i;
            return this;
        }

        public Builder setUserInfo(Map<?, ?> map) {
            this.userInfo = map;
            return this;
        }

        public LongLog build() {
            LongLog longLog = new LongLog();
            Date unused = longLog.f36575c = this.mDate;
            longLog.logLevel = this.logLevel;
            int unused2 = longLog.f36577e = this.mTid;
            String unused3 = longLog.f36573a = this.mMsg;
            String unused4 = longLog.f36576d = this.mTag;
            String unused5 = longLog.f36578f = this.mTnm;
            Object[] unused6 = longLog.f36574b = this.mArgs;
            boolean unused7 = longLog.f36579g = this.mFormat;
            String unused8 = longLog.f36580h = this.mClassName;
            int unused9 = longLog.f36581i = this.mLine;
            Map unused10 = longLog.f36582j = this.userInfo;
            return longLog;
        }
    }
}

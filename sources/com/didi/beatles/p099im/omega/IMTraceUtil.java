package com.didi.beatles.p099im.omega;

import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.omega.IMTraceUtil */
public class IMTraceUtil {
    public static CodeErrorParam addCodeErrorEvent() {
        return new CodeErrorParam();
    }

    public static BusinessParam addBusinessEvent(String str) {
        return new BusinessParam(str);
    }

    /* renamed from: com.didi.beatles.im.omega.IMTraceUtil$BusinessParam */
    public static class BusinessParam {
        private String eventKey;
        private Map<String, Object> params = new HashMap();

        public BusinessParam(String str) {
            this.eventKey = str;
        }

        public BusinessParam add(String str, Object obj) {
            this.params.put(str, obj);
            return this;
        }

        public <T> BusinessParam add(Map<String, T> map) {
            if (map != null && !map.isEmpty()) {
                this.params.putAll(map);
            }
            return this;
        }

        public void report() {
            this.params.put("ab_test_id", IMCommonContextInfoHelper.isUseFeed() ? "1" : "0");
            IMLog.m6630d(C4234I.m6591t("addOmgEvent EventKey=", this.eventKey, " |Params=", this.params));
            OmegaSDKAdapter.trackEvent(this.eventKey, this.params);
        }
    }

    /* renamed from: com.didi.beatles.im.omega.IMTraceUtil$CodeErrorParam */
    public static class CodeErrorParam {
        private Map<String, Object> params = new HashMap();

        public CodeErrorParam addErrno(int i) {
            this.params.put("errno", Integer.valueOf(i));
            return this;
        }

        public CodeErrorParam addErrMsg(String str) {
            this.params.put("errmsg", str);
            return this;
        }

        public CodeErrorParam addExtendMsg(Object obj) {
            if (obj == null) {
                return this;
            }
            if (obj instanceof String) {
                this.params.put("extendmsg", obj);
                return this;
            }
            if (obj instanceof Map) {
                this.params.putAll((Map) obj);
            }
            return this;
        }

        public void report() {
            OmegaSDKAdapter.trackEvent("im_runtime_error", this.params);
        }
    }
}

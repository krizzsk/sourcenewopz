package com.didi.unifylogin.base.net.pojo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JudgeResponse implements Serializable {
    public JudgeData data;
    public int errdef = -1;
    public int errno;
    public String error;
    public String requestid;

    public static class JudgeData implements Serializable {
        public ArrayList<JudgeDataItem> idc_info;
        public PiiDataItem pii_info;
        public String text;
    }

    public static class JudgeDataItem implements Serializable {
        public String button_text;
        public String idc_sign;
        public String idc_suffix;
    }

    public static class PiiDataItem implements Serializable {
        public String idc_suffix;
        public int timeout;
        public List<String> uri;

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r2.timeout;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean illegal() {
            /*
                r2 = this;
                java.util.List<java.lang.String> r0 = r2.uri
                boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r0)
                if (r0 != 0) goto L_0x001b
                int r0 = r2.timeout
                if (r0 < 0) goto L_0x001b
                r1 = 10
                if (r0 > r1) goto L_0x001b
                java.lang.String r0 = r2.idc_suffix
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r0 = 0
                goto L_0x001c
            L_0x001b:
                r0 = 1
            L_0x001c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.base.net.pojo.response.JudgeResponse.PiiDataItem.illegal():boolean");
        }
    }
}

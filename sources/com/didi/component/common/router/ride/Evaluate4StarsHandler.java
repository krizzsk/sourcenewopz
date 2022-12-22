package com.didi.component.common.router.ride;

import com.didi.drouter.router.IRouterHandler;

public class Evaluate4StarsHandler implements IRouterHandler {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.didi.drouter.router.Request r3, com.didi.drouter.router.Result r4) {
        /*
            r2 = this;
            java.lang.String r4 = "xb_extension"
            java.lang.String r4 = r3.getString(r4)
            if (r4 != 0) goto L_0x0009
            return
        L_0x0009:
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0023 }
            r1.<init>(r4)     // Catch:{ JSONException -> 0x0023 }
            java.lang.String r4 = "biz_params"
            org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ JSONException -> 0x0023 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0023 }
            r1.<init>()     // Catch:{ JSONException -> 0x0023 }
            java.lang.String r0 = "data"
            r1.putOpt(r0, r4)     // Catch:{ JSONException -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r4 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            r4.printStackTrace()
            r1 = r0
        L_0x0028:
            if (r1 != 0) goto L_0x002b
            return
        L_0x002b:
            android.net.Uri r3 = r3.getUri()
            java.lang.String r4 = "rating"
            java.lang.String r3 = r3.getQueryParameter(r4)
            r4 = 0
            java.lang.Object r3 = java.util.Objects.requireNonNull(r3)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0041 }
            int r4 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0045:
            com.didi.travel.psnger.model.response.CommentOnPanel r3 = new com.didi.travel.psnger.model.response.CommentOnPanel
            r3.<init>()
            java.lang.String r0 = r1.toString()
            r3.parse((java.lang.String) r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "extras_unevaluated_satisfied"
            r0.putInt(r1, r4)
            java.lang.String r4 = "extras_unevaluated_comment_data"
            r0.putSerializable(r4, r3)
            r3 = 1
            java.lang.String r4 = "extras_unevaluated_style"
            r0.putInt(r4, r3)
            com.didi.component.core.event.BaseEventPublisher r3 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            com.didi.component.common.base.ComponentWrap r4 = new com.didi.component.common.base.ComponentWrap
            java.lang.String r1 = "evaluate"
            r4.<init>((java.lang.String) r1, (android.os.Bundle) r0)
            java.lang.String r0 = "event_show_popup_component"
            r3.publish(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.router.ride.Evaluate4StarsHandler.handle(com.didi.drouter.router.Request, com.didi.drouter.router.Result):void");
    }
}

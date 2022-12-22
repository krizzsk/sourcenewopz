package com.didi.dimina.container.p106ui.custom.input;

import android.text.TextUtils;
import com.didi.dimina.container.util.ColorUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.soda.blocks.constant.Const;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rui.config.RConfigConstants;

/* renamed from: com.didi.dimina.container.ui.custom.input.b */
/* compiled from: InputAttrUtil */
class C7615b {
    C7615b() {
    }

    /* renamed from: a */
    public static void m13030a(C7614a aVar, Map<String, Object> map) {
        if (map != null) {
            try {
                m13031a(aVar, new JSONObject(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m13031a(C7614a aVar, JSONObject jSONObject) {
        Object opt;
        Object opt2;
        Object opt3;
        Object opt4;
        Object opt5;
        Object opt6;
        Object opt7;
        Object opt8;
        Object opt9;
        Object opt10;
        Object opt11;
        Object opt12;
        Object opt13;
        Object opt14;
        Object opt15;
        Object opt16;
        Object opt17;
        Object opt18;
        Object opt19;
        if (jSONObject.has("id")) {
            aVar.f17522b = jSONObject.optString("id");
        }
        if (jSONObject.has("style") && (opt19 = jSONObject.opt("style")) != null) {
            aVar.f17523c = opt19.toString();
            try {
                aVar.f17521a = new JSONObject(aVar.f17523c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONObject.has("value") && (opt18 = jSONObject.opt("value")) != null) {
            aVar.f17524d = opt18.toString();
        }
        if (jSONObject.has("inputType") && (opt17 = jSONObject.opt("inputType")) != null) {
            aVar.inputType = opt17.toString();
        }
        if (jSONObject.has(CashierAction.ACTION_PASSWORD) && (opt16 = jSONObject.opt(CashierAction.ACTION_PASSWORD)) != null) {
            aVar.f17525e = ((Boolean) opt16).booleanValue();
        }
        if (jSONObject.has(Const.BlockParamConst.PLACEHOLDER) && (opt15 = jSONObject.opt(Const.BlockParamConst.PLACEHOLDER)) != null) {
            aVar.f17526f = opt15.toString();
        }
        if (jSONObject.has("placeholderStyle") && (opt14 = jSONObject.opt("placeholderStyle")) != null) {
            aVar.placeholderStyle = opt14.toString();
        }
        if (jSONObject.has("disabled") && (opt13 = jSONObject.opt("disabled")) != null) {
            aVar.f17527g = ((Boolean) opt13).booleanValue();
        }
        if (jSONObject.has("maxlength") && (opt12 = jSONObject.opt("maxlength")) != null) {
            aVar.f17528h = ((Integer) opt12).intValue();
        }
        if (jSONObject.has("cursorSpacing") && (opt11 = jSONObject.opt("cursorSpacing")) != null) {
            aVar.cursorSpacing = opt11.toString();
        }
        if (jSONObject.has("focus") && (opt10 = jSONObject.opt("focus")) != null) {
            aVar.f17529i = ((Boolean) opt10).booleanValue();
        }
        if (jSONObject.has("confirmType") && (opt9 = jSONObject.opt("confirmType")) != null) {
            aVar.confirmType = opt9.toString();
        }
        if (jSONObject.has("confirmHold") && (opt8 = jSONObject.opt("confirmHold")) != null) {
            aVar.confirmHold = ((Boolean) opt8).booleanValue();
        }
        if (jSONObject.has("cursor") && (opt7 = jSONObject.opt("cursor")) != null) {
            aVar.f17530j = ((Integer) opt7).intValue();
        }
        if (jSONObject.has("selectionStart") && (opt6 = jSONObject.opt("selectionStart")) != null) {
            aVar.selectionStart = ((Integer) opt6).intValue();
        }
        if (jSONObject.has("selectionEnd") && (opt5 = jSONObject.opt("selectionEnd")) != null) {
            aVar.selectionEnd = ((Integer) opt5).intValue();
        }
        if (jSONObject.has("adjustPosition") && (opt4 = jSONObject.opt("adjustPosition")) != null) {
            aVar.adjustPosition = ((Boolean) opt4).booleanValue();
        }
        if (jSONObject.has("holdKeyboard") && (opt3 = jSONObject.opt("holdKeyboard")) != null) {
            aVar.holdKeyboard = ((Boolean) opt3).booleanValue();
        }
        if (jSONObject.has("position") && (opt2 = jSONObject.opt("position")) != null) {
            aVar.f17531k = opt2.toString();
        }
        if (jSONObject.has("autoHeight") && (opt = jSONObject.opt("autoHeight")) != null) {
            aVar.autoHeight = ((Boolean) opt).booleanValue();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13029a(java.lang.String r9) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = -1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = ";"
            java.lang.String[] r9 = r9.split(r0)     // Catch:{ Exception -> 0x009d }
            int r0 = r9.length     // Catch:{ Exception -> 0x009d }
            if (r0 <= 0) goto L_0x009d
            int r0 = r9.length     // Catch:{ Exception -> 0x009d }
            r2 = 0
            r3 = 0
        L_0x0014:
            if (r3 >= r0) goto L_0x009d
            r4 = r9[r3]     // Catch:{ Exception -> 0x009d }
            java.lang.String r5 = ":"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x009d }
            int r5 = r4.length     // Catch:{ Exception -> 0x009d }
            r6 = 2
            if (r5 >= r6) goto L_0x0024
            goto L_0x0099
        L_0x0024:
            r5 = r4[r2]     // Catch:{ Exception -> 0x009d }
            r7 = 1
            r4 = r4[r7]     // Catch:{ Exception -> 0x009d }
            java.lang.String r8 = "background-color"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r5 == 0) goto L_0x0099
            int r5 = r4.hashCode()     // Catch:{ Exception -> 0x009d }
            switch(r5) {
                case -1008851410: goto L_0x0074;
                case -734239628: goto L_0x006b;
                case 112785: goto L_0x0061;
                case 3027034: goto L_0x0057;
                case 93818879: goto L_0x004d;
                case 98619139: goto L_0x0043;
                case 113101865: goto L_0x0039;
                default: goto L_0x0038;
            }     // Catch:{ Exception -> 0x009d }
        L_0x0038:
            goto L_0x007e
        L_0x0039:
            java.lang.String r5 = "white"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 5
            goto L_0x007f
        L_0x0043:
            java.lang.String r5 = "green"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 1
            goto L_0x007f
        L_0x004d:
            java.lang.String r5 = "black"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 6
            goto L_0x007f
        L_0x0057:
            java.lang.String r5 = "blue"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 3
            goto L_0x007f
        L_0x0061:
            java.lang.String r5 = "red"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 0
            goto L_0x007f
        L_0x006b:
            java.lang.String r5 = "yellow"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            goto L_0x007f
        L_0x0074:
            java.lang.String r5 = "orange"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x007e
            r6 = 4
            goto L_0x007f
        L_0x007e:
            r6 = -1
        L_0x007f:
            switch(r6) {
                case 0: goto L_0x0096;
                case 1: goto L_0x0092;
                case 2: goto L_0x008f;
                case 3: goto L_0x008b;
                case 4: goto L_0x0087;
                case 5: goto L_0x0086;
                case 6: goto L_0x0083;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x0099
        L_0x0083:
            r9 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            return r9
        L_0x0086:
            return r1
        L_0x0087:
            r9 = -65281(0xffffffffffff00ff, float:NaN)
            return r9
        L_0x008b:
            r9 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            return r9
        L_0x008f:
            r9 = -256(0xffffffffffffff00, float:NaN)
            return r9
        L_0x0092:
            r9 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            return r9
        L_0x0096:
            r9 = -65536(0xffffffffffff0000, float:NaN)
            return r9
        L_0x0099:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x009d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.custom.input.C7615b.m13029a(java.lang.String):int");
    }

    /* renamed from: a */
    public static int m13028a(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.f17523c)) {
            return -1;
        }
        if (aVar.f17521a == null) {
            try {
                aVar.f17521a = new JSONObject(aVar.f17523c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aVar.f17521a == null) {
            return -1;
        }
        String optString = aVar.f17521a.optString("backgroundColor");
        if (TextUtils.isEmpty(optString)) {
            return -1;
        }
        if (optString.length() <= 4) {
            optString = optString + optString.substring(1);
        }
        if (optString.startsWith("0x")) {
            optString = optString.replaceAll("0x", RConfigConstants.KEYWORD_COLOR_SIGN);
        }
        return ColorUtil.parseColor(optString, "#000000");
    }

    /* renamed from: b */
    public static int m13032b(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.f17523c)) {
            return 8388627;
        }
        if (aVar.f17521a == null) {
            try {
                aVar.f17521a = new JSONObject(aVar.f17523c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aVar.f17521a != null) {
            String optString = aVar.f17521a.optString(Const.BlockParamConst.TEXT_ALIGN);
            if (TextUtils.isEmpty(optString)) {
                return 8388627;
            }
            if (optString.equals("right")) {
                return 21;
            }
            if (optString.equals("center")) {
                return 17;
            }
        }
        return 8388627;
    }

    /* renamed from: c */
    public static int m13033c(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.f17523c)) {
            return -16777216;
        }
        if (aVar.f17521a == null) {
            try {
                aVar.f17521a = new JSONObject(aVar.f17523c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aVar.f17521a == null) {
            return -16777216;
        }
        String optString = aVar.f17521a.optString("color");
        if (TextUtils.isEmpty(optString)) {
            return -16777216;
        }
        if (optString.length() <= 4) {
            optString = optString + optString.substring(1);
        }
        if (optString.startsWith("0x")) {
            optString = optString.replaceAll("0x", RConfigConstants.KEYWORD_COLOR_SIGN);
        }
        return ColorUtil.parseColor(optString, "#000000");
    }

    /* renamed from: d */
    public static float m13034d(C7614a aVar) {
        int i;
        if (TextUtils.isEmpty(aVar.f17523c)) {
            return 14.0f;
        }
        if (aVar.f17521a == null) {
            try {
                LogUtil.m13407d("getFontSize:" + aVar.f17523c);
                aVar.f17521a = new JSONObject(aVar.f17523c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aVar.f17521a != null) {
            String optString = aVar.f17521a.optString(Const.BlockParamConst.FONT_SIZE);
            if (!TextUtils.isEmpty(optString)) {
                String lowerCase = optString.toLowerCase();
                if (lowerCase.endsWith("rpx")) {
                    i = lowerCase.indexOf("rpx");
                } else if (lowerCase.endsWith("px")) {
                    i = lowerCase.indexOf("px");
                } else {
                    i = lowerCase.length();
                }
                try {
                    return Float.parseFloat(lowerCase.substring(0, i));
                } catch (Exception unused) {
                }
            }
        }
        return 14.0f;
    }

    /* renamed from: e */
    public static int m13035e(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.placeholderStyle)) {
            return -16777216;
        }
        String[] split = aVar.placeholderStyle.split(";");
        for (int i = 0; i < split.length; i++) {
            if (split[i].trim().startsWith("color")) {
                String substring = split[i].substring(6);
                if (substring.length() <= 4) {
                    substring = substring + substring.substring(1);
                }
                if (substring.startsWith("0x")) {
                    substring = substring.replaceAll("0x", RConfigConstants.KEYWORD_COLOR_SIGN);
                }
                return ColorUtil.parseColor(substring, "#000000");
            }
        }
        return -16777216;
    }

    /* renamed from: f */
    public static int m13036f(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.inputType)) {
            aVar.inputType = "text";
        }
        String str = aVar.inputType;
        char c = 65535;
        switch (str.hashCode()) {
            case -1193508181:
                if (str.equals("idcard")) {
                    c = 2;
                    break;
                }
                break;
            case -1034364087:
                if (str.equals("number")) {
                    c = 1;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 0;
                    break;
                }
                break;
            case 95582509:
                if (str.equals("digit")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return c != 3 ? 1 : 8194;
                }
                return 8192;
            } else if (aVar.f17525e) {
                return 18;
            } else {
                return 2;
            }
        } else if (aVar.f17525e) {
            return 129;
        } else {
            return 1;
        }
    }

    /* renamed from: g */
    public static int m13037g(C7614a aVar) {
        if (TextUtils.isEmpty(aVar.confirmType)) {
            return 6;
        }
        String str = aVar.confirmType;
        char c = 65535;
        switch (str.hashCode()) {
            case -934396624:
                if (str.equals("return")) {
                    c = 5;
                    break;
                }
                break;
            case -906336856:
                if (str.equals("search")) {
                    c = 1;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    c = 3;
                    break;
                }
                break;
            case 3089282:
                if (str.equals("done")) {
                    c = 4;
                    break;
                }
                break;
            case 3377907:
                if (str.equals("next")) {
                    c = 2;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return 4;
        }
        if (c == 1) {
            return 3;
        }
        if (c == 2) {
            return 5;
        }
        if (c == 3) {
            return 2;
        }
        if (c != 4) {
            return 0;
        }
        return 6;
    }
}

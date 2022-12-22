package com.didi.unifylogin.flutter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.Utils;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class PassportModulePluginHandler {

    /* renamed from: a */
    private Context f44778a;

    /* renamed from: b */
    private Logger f44779b = LoggerFactory.getLogger("PassportModulePluginHandler");

    public PassportModulePluginHandler(Context context) {
        this.f44778a = context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onMethodCall(p242io.flutter.plugin.common.MethodCall r4, final p242io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            java.lang.String r0 = r4.method
            int r1 = r0.hashCode()
            r2 = 1
            switch(r1) {
                case -2109921772: goto L_0x014c;
                case -1771582287: goto L_0x0141;
                case -1729209087: goto L_0x0136;
                case -1728870515: goto L_0x012b;
                case -1699888216: goto L_0x0120;
                case -1355091884: goto L_0x0115;
                case -1341314536: goto L_0x010b;
                case -1331088195: goto L_0x0101;
                case -1286983781: goto L_0x00f6;
                case -1263222033: goto L_0x00ea;
                case -1204749356: goto L_0x00de;
                case -1095361103: goto L_0x00d2;
                case -1088661219: goto L_0x00c6;
                case -1009167044: goto L_0x00ba;
                case -962089385: goto L_0x00ae;
                case -96982436: goto L_0x00a2;
                case 269049112: goto L_0x0096;
                case 329703796: goto L_0x008b;
                case 341222968: goto L_0x007f;
                case 552567418: goto L_0x0074;
                case 615363453: goto L_0x0069;
                case 709674945: goto L_0x005e;
                case 1073045818: goto L_0x0052;
                case 1321118366: goto L_0x0046;
                case 1391332442: goto L_0x003a;
                case 1455237336: goto L_0x002e;
                case 1461397830: goto L_0x0023;
                case 1695483847: goto L_0x0017;
                case 1893584423: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0157
        L_0x000c:
            java.lang.String r1 = "verifyPersonalInfo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 6
            goto L_0x0158
        L_0x0017:
            java.lang.String r1 = "interceptLogin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 18
            goto L_0x0158
        L_0x0023:
            java.lang.String r1 = "signInByCode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 4
            goto L_0x0158
        L_0x002e:
            java.lang.String r1 = "changeIDC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 21
            goto L_0x0158
        L_0x003a:
            java.lang.String r1 = "setEmail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 12
            goto L_0x0158
        L_0x0046:
            java.lang.String r1 = "makePhoneCall"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 27
            goto L_0x0158
        L_0x0052:
            java.lang.String r1 = "userAppeal"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 8
            goto L_0x0158
        L_0x005e:
            java.lang.String r1 = "verifyCaptcha"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 2
            goto L_0x0158
        L_0x0069:
            java.lang.String r1 = "gatekeeper"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 0
            goto L_0x0158
        L_0x0074:
            java.lang.String r1 = "captcha"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 1
            goto L_0x0158
        L_0x007f:
            java.lang.String r1 = "getConfig"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 22
            goto L_0x0158
        L_0x008b:
            java.lang.String r1 = "signInByPassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 3
            goto L_0x0158
        L_0x0096:
            java.lang.String r1 = "faceVerification"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 20
            goto L_0x0158
        L_0x00a2:
            java.lang.String r1 = "logoutAndClean"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 25
            goto L_0x0158
        L_0x00ae:
            java.lang.String r1 = "getWhatsAppKey"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 14
            goto L_0x0158
        L_0x00ba:
            java.lang.String r1 = "openCPFForce"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 17
            goto L_0x0158
        L_0x00c6:
            java.lang.String r1 = "setPassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 11
            goto L_0x0158
        L_0x00d2:
            java.lang.String r1 = "getOmegaMap"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 28
            goto L_0x0158
        L_0x00de:
            java.lang.String r1 = "getCountryList2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 26
            goto L_0x0158
        L_0x00ea:
            java.lang.String r1 = "openCPF"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 16
            goto L_0x0158
        L_0x00f6:
            java.lang.String r1 = "getCompassJudge"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 13
            goto L_0x0158
        L_0x0101:
            java.lang.String r1 = "getVerifyInfo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 5
            goto L_0x0158
        L_0x010b:
            java.lang.String r1 = "verifyBankAccount"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 7
            goto L_0x0158
        L_0x0115:
            java.lang.String r1 = "codeMT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 9
            goto L_0x0158
        L_0x0120:
            java.lang.String r1 = "forgetPassword"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 10
            goto L_0x0158
        L_0x012b:
            java.lang.String r1 = "getLoginType"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 23
            goto L_0x0158
        L_0x0136:
            java.lang.String r1 = "getLoginInfo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 24
            goto L_0x0158
        L_0x0141:
            java.lang.String r1 = "loginEvent"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 19
            goto L_0x0158
        L_0x014c:
            java.lang.String r1 = "signInByWhatsAppKey"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0157
            r0 = 15
            goto L_0x0158
        L_0x0157:
            r0 = -1
        L_0x0158:
            switch(r0) {
                case 0: goto L_0x028d;
                case 1: goto L_0x0282;
                case 2: goto L_0x0277;
                case 3: goto L_0x026c;
                case 4: goto L_0x0261;
                case 5: goto L_0x0256;
                case 6: goto L_0x024b;
                case 7: goto L_0x0240;
                case 8: goto L_0x0235;
                case 9: goto L_0x022a;
                case 10: goto L_0x021f;
                case 11: goto L_0x0214;
                case 12: goto L_0x0209;
                case 13: goto L_0x01fe;
                case 14: goto L_0x01f3;
                case 15: goto L_0x01e8;
                case 16: goto L_0x01dd;
                case 17: goto L_0x01d2;
                case 18: goto L_0x01c5;
                case 19: goto L_0x01b9;
                case 20: goto L_0x01ae;
                case 21: goto L_0x01a3;
                case 22: goto L_0x0198;
                case 23: goto L_0x018d;
                case 24: goto L_0x0182;
                case 25: goto L_0x0177;
                case 26: goto L_0x0169;
                case 27: goto L_0x0165;
                case 28: goto L_0x015d;
                default: goto L_0x015b;
            }
        L_0x015b:
            goto L_0x0297
        L_0x015d:
            java.util.Map r4 = com.didi.unifylogin.utils.LoginOmegaUtil.getOmegaMap()
            r5.success(r4)
            return r2
        L_0x0165:
            r3.makePhoneCall(r4, r5)
            return r2
        L_0x0169:
            com.didi.unifylogin.country.CountryManager r4 = com.didi.unifylogin.country.CountryManager.getIns()
            com.didi.unifylogin.flutter.PassportModulePluginHandler$1 r0 = new com.didi.unifylogin.flutter.PassportModulePluginHandler$1
            r0.<init>(r5)
            r4.getCountriesFromNet(r0)
            goto L_0x0297
        L_0x0177:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.logoutAndClean(r4, r5)
            return r2
        L_0x0182:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.getLoginInfo(r4, r5)
            return r2
        L_0x018d:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.getLoginType(r4, r5)
            return r2
        L_0x0198:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.getConfig(r4, r5)
            return r2
        L_0x01a3:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.changeIDC(r4, r5)
            return r2
        L_0x01ae:
            com.didi.unifylogin.flutter.LoginLogicManager r0 = new com.didi.unifylogin.flutter.LoginLogicManager
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            r0.faceVerification(r4, r5)
            return r2
        L_0x01b9:
            com.didi.unifylogin.flutter.LoginEventHandler r0 = new com.didi.unifylogin.flutter.LoginEventHandler
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1)
            boolean r4 = r0.onEvent(r4, r5)
            return r4
        L_0x01c5:
            android.content.Context r0 = r3.f44778a
            if (r0 == 0) goto L_0x01d1
            com.didi.unifylogin.flutter.request.FInterceptLogin r1 = new com.didi.unifylogin.flutter.request.FInterceptLogin
            r1.<init>(r0, r4, r5)
            r1.request()
        L_0x01d1:
            return r2
        L_0x01d2:
            com.didi.unifylogin.flutter.request.FOpenCPFForce r0 = new com.didi.unifylogin.flutter.request.FOpenCPFForce
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x01dd:
            com.didi.unifylogin.flutter.request.FOpenCPF r0 = new com.didi.unifylogin.flutter.request.FOpenCPF
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x01e8:
            com.didi.unifylogin.flutter.request.FSignInByWhatsAppKey r0 = new com.didi.unifylogin.flutter.request.FSignInByWhatsAppKey
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x01f3:
            com.didi.unifylogin.flutter.request.FGetWhatsAppKey r0 = new com.didi.unifylogin.flutter.request.FGetWhatsAppKey
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x01fe:
            com.didi.unifylogin.flutter.request.FGetCompassJudge r0 = new com.didi.unifylogin.flutter.request.FGetCompassJudge
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0209:
            com.didi.unifylogin.flutter.request.FSetEmail r0 = new com.didi.unifylogin.flutter.request.FSetEmail
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0214:
            com.didi.unifylogin.flutter.request.FSetPassword r0 = new com.didi.unifylogin.flutter.request.FSetPassword
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x021f:
            com.didi.unifylogin.flutter.request.FForgetPassword r0 = new com.didi.unifylogin.flutter.request.FForgetPassword
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x022a:
            com.didi.unifylogin.flutter.request.FCodeMT r0 = new com.didi.unifylogin.flutter.request.FCodeMT
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0235:
            com.didi.unifylogin.flutter.request.FUserAppeal r0 = new com.didi.unifylogin.flutter.request.FUserAppeal
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0240:
            com.didi.unifylogin.flutter.request.FVerifyBankAccount r0 = new com.didi.unifylogin.flutter.request.FVerifyBankAccount
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            goto L_0x0297
        L_0x024b:
            com.didi.unifylogin.flutter.request.FVerifyPersonalInfo r0 = new com.didi.unifylogin.flutter.request.FVerifyPersonalInfo
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0256:
            com.didi.unifylogin.flutter.request.FGetVerifyInfo r0 = new com.didi.unifylogin.flutter.request.FGetVerifyInfo
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0261:
            com.didi.unifylogin.flutter.request.FSignInByCode r0 = new com.didi.unifylogin.flutter.request.FSignInByCode
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x026c:
            com.didi.unifylogin.flutter.request.FSignInByPassword r0 = new com.didi.unifylogin.flutter.request.FSignInByPassword
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0277:
            com.didi.unifylogin.flutter.request.FVerifyCaptcha r0 = new com.didi.unifylogin.flutter.request.FVerifyCaptcha
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x0282:
            com.didi.unifylogin.flutter.request.FGetCaptcha r0 = new com.didi.unifylogin.flutter.request.FGetCaptcha
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
            return r2
        L_0x028d:
            com.didi.unifylogin.flutter.request.FGatekeeper r0 = new com.didi.unifylogin.flutter.request.FGatekeeper
            android.content.Context r1 = r3.f44778a
            r0.<init>(r1, r4, r5)
            r0.request()
        L_0x0297:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.flutter.PassportModulePluginHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):boolean");
    }

    public void makePhoneCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("phone");
        if (!TextUtils.isEmpty(str)) {
            Utils.makePhoneCall(this.f44778a, str);
        }
        result.success(Result.m31807ok());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONArray m31806a(List<CountryListResponse.CountryRule> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < list.size()) {
            try {
                jSONArray.put(list.get(i).getJSONObj());
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return jSONArray;
    }
}

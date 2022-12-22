package com.adyen.threeds2.internal;

import android.content.Context;
import atd.p020f0.C1024b;
import atd.p022g0.C1032a;
import atd.p022g0.C1033b;
import atd.p022g0.C1034c;
import atd.p023h.C1038b;
import atd.p026i0.C1057d;
import atd.p028j0.C1068a;
import atd.p030k0.C1073b;
import atd.p032l0.C1082g;
import atd.p044r0.C1155b;
import atd.p044r0.C1156c;
import atd.p044r0.C1159f;
import atd.p046s0.C1172a;
import atd.p051x.C1219a;
import atd.p051x.C1221c;
import atd.p052y.C1223a;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKAlreadyInitializedException;
import com.adyen.threeds2.exception.SDKNotInitializedException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.parameters.ConfigParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.adyen.threeds2.internal.g */
class C1413g implements C1414h {

    /* renamed from: b */
    private Context f1026b;

    /* renamed from: c */
    private ConfigParameters f1027c;

    /* renamed from: d */
    private UiCustomization f1028d;

    /* renamed from: e */
    private List<Warning> f1029e;

    /* renamed from: f */
    private C1038b f1030f;

    /* renamed from: g */
    private boolean f1031g;

    C1413g() {
    }

    /* renamed from: b */
    private synchronized void m1148b() throws SDKNotInitializedException {
        if (!this.f1031g) {
            throw new SDKNotInitializedException();
        }
    }

    /* renamed from: c */
    private synchronized void m1149c() throws SDKAlreadyInitializedException {
        if (this.f1031g) {
            throw new SDKAlreadyInitializedException();
        }
    }

    /* renamed from: a */
    public UiCustomization mo14877a() {
        return this.f1028d;
    }

    public synchronized void cleanup(Context context) throws SDKNotInitializedException {
        m1148b();
        this.f1027c = null;
        this.f1028d = null;
        this.f1029e = null;
        this.f1030f = null;
        this.f1031g = false;
    }

    public Transaction createTransaction(String str, String str2) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException {
        m1148b();
        C1159f.m731a((Object) str2, C1223a.MESSAGE_VERSION);
        C1397d b = C1397d.m1101b(str2);
        JSONObject a = this.f1030f.mo13772a(b.mo14847b());
        C1033b a2 = C1221c.m904a(str, this.f1027c);
        String e = C1396c.m1098a((C1024b) a2, a).mo13756e();
        if (a2 instanceof C1034c) {
            ((C1034c) a2).mo13765c();
        }
        String uuid = UUID.randomUUID().toString();
        C1398e a3 = C1398e.m1104a(this.f1026b, C1073b.m488a());
        C1032a aVar = new C1032a(C1172a.m764a(-2229541358254L), C1057d.P256);
        return new C1415i(C1219a.m897a(str, this.f1027c), aVar, new C1068a(uuid, e, aVar.mo13763g().toString(), a3.mo14850a(), a3.mo14851b(), b.mo14848c()));
    }

    public String getSDKVersion() {
        return C1172a.m764a(-2233836325550L);
    }

    public List<Warning> getWarnings() {
        return new ArrayList(this.f1029e);
    }

    public synchronized void initialize(Context context, ConfigParameters configParameters, String str, UiCustomization uiCustomization) throws InvalidInputException, SDKAlreadyInitializedException, SDKRuntimeException {
        m1149c();
        C1155b.m723a(6);
        C1159f.m731a((Object) context, C1223a.APPLICATION_CONTEXT);
        C1159f.m731a((Object) configParameters, C1223a.CONFIG_PARAMETERS);
        C1156c.m726b(str);
        Context applicationContext = context.getApplicationContext();
        this.f1026b = applicationContext;
        this.f1027c = configParameters;
        this.f1028d = uiCustomization;
        List<Warning> a = C1082g.m526a(applicationContext, configParameters).mo13819a();
        this.f1029e = a;
        this.f1030f = C1038b.m384a(this.f1026b, this.f1027c, a);
        this.f1031g = true;
    }
}

package com.adyen.threeds2.internal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import atd.p014c0.C0973c;
import atd.p015d.C0976a;
import atd.p015d.C0979b;
import atd.p016d0.C1010g;
import atd.p020f0.C1023a;
import atd.p020f0.C1028f;
import atd.p021g.C1031a;
import atd.p022g0.C1032a;
import atd.p022g0.C1033b;
import atd.p022g0.C1036e;
import atd.p024h0.C1048d;
import atd.p038o0.C1120a;
import atd.p044r0.C1159f;
import atd.p046s0.C1172a;
import atd.p052y.C1223a;
import atd.p052y.C1224b;
import atd.p052y.C1225c;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.ChallengeStatusReceiver;
import com.adyen.threeds2.CompletionEvent;
import com.adyen.threeds2.ProgressDialog;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.p059ui.activity.ChallengeActivity;
import com.adyen.threeds2.parameters.ChallengeParameters;
import java.lang.ref.WeakReference;
import java.security.cert.X509Certificate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adyen.threeds2.internal.i */
class C1415i implements Transaction, C1394a {

    /* renamed from: a */
    final List<X509Certificate> f1033a;

    /* renamed from: b */
    final C1032a f1034b;

    /* renamed from: c */
    private AuthenticationRequestParameters f1035c;

    /* renamed from: d */
    private WeakReference<Activity> f1036d;

    /* renamed from: e */
    private ChallengeStatusReceiver f1037e;

    /* renamed from: f */
    private C1399f f1038f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1120a f1039g;

    /* renamed from: com.adyen.threeds2.internal.i$a */
    class C1416a implements DialogInterface.OnDismissListener {
        C1416a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            C1120a unused = C1415i.this.f1039g = null;
        }
    }

    C1415i(List<X509Certificate> list, C1032a aVar, AuthenticationRequestParameters authenticationRequestParameters) {
        this.f1033a = list;
        this.f1034b = aVar;
        this.f1035c = authenticationRequestParameters;
    }

    /* renamed from: c */
    private ChallengeStatusReceiver m1157c() {
        ChallengeStatusReceiver challengeStatusReceiver = this.f1037e;
        if (challengeStatusReceiver != null) {
            return challengeStatusReceiver;
        }
        throw C1225c.CHALLENGE_PRESENTATION_FAILURE.mo13982a();
    }

    /* renamed from: d */
    private Activity m1158d() {
        WeakReference<Activity> weakReference = this.f1036d;
        if (weakReference == null) {
            runtimeError(C1224b.ACTIVITY_WEAK_REFERENCE_MISSING.mo13980a());
            return null;
        }
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            return activity;
        }
        runtimeError(C1224b.ACTIVITY_REFERENCE_MISSING.mo13980a());
        return null;
    }

    /* renamed from: e */
    private void m1159e() {
        Activity d = m1158d();
        if (d != null && !ChallengeActivity.m1172g()) {
            d.startActivity(mo14880b(d));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Intent mo14880b(Activity activity) {
        return ChallengeActivity.m1171b((Context) activity);
    }

    public void cancelled() {
        m1155b();
        ChallengeStatusReceiver c = m1157c();
        if (c != null) {
            c.cancelled();
        }
    }

    public void close() {
        this.f1034b.mo13765c();
        this.f1035c = null;
        this.f1037e = null;
        WeakReference<Activity> weakReference = this.f1036d;
        if (weakReference != null) {
            weakReference.clear();
            this.f1036d = null;
        }
        C1399f fVar = this.f1038f;
        if (fVar != null) {
            fVar.mo14861b();
            this.f1038f = null;
        }
        C1120a aVar = this.f1039g;
        if (aVar != null) {
            aVar.hide();
            this.f1039g = null;
        }
    }

    public void completed(CompletionEvent completionEvent) {
        m1155b();
        ChallengeStatusReceiver c = m1157c();
        if (c != null) {
            c.completed(completionEvent);
        }
    }

    public void doChallenge(Activity activity, ChallengeParameters challengeParameters, ChallengeStatusReceiver challengeStatusReceiver, int i) throws InvalidInputException {
        Activity activity2 = activity;
        ChallengeStatusReceiver challengeStatusReceiver2 = challengeStatusReceiver;
        C1159f.m731a((Object) activity, C1223a.CURRENT_ACTIVITY);
        ChallengeParameters challengeParameters2 = challengeParameters;
        C1159f.m731a((Object) challengeParameters, C1223a.CHALLENGE_PARAMETERS);
        C1159f.m733b(challengeParameters.getAcsTransactionID(), C1223a.CHALLENGE_PARAMETERS);
        C1159f.m733b(challengeParameters.get3DSServerTransactionID(), C1223a.CHALLENGE_PARAMETERS);
        C1159f.m731a((Object) challengeStatusReceiver2, C1223a.CHALLENGE_STATUS_RECEIVER);
        C1159f.m730a(i, 5, C1223a.TIMEOUT);
        this.f1036d = new WeakReference<>(activity);
        this.f1037e = challengeStatusReceiver2;
        C1031a a = m1153a(challengeParameters.getAcsSignedContent());
        C0979b bVar = new C0979b(this.f1035c.getMessageVersion(), challengeParameters.get3DSServerTransactionID(), challengeParameters.getAcsTransactionID(), this.f1035c.getSDKTransactionID(), !this.f1035c.getMessageVersion().equals(C1397d.V2_1_0.mo14848c()) ? challengeParameters.getThreeDSRequestorAppURL() : null);
        C1023a a2 = m1152a(challengeParameters.getAcsTransactionID(), a.mo13757a());
        C1399f d = C1399f.m1120d();
        this.f1038f = d;
        d.mo14860a(a.mo13758b(), a2, bVar, i, this);
    }

    public AuthenticationRequestParameters getAuthenticationRequestParameters() {
        return this.f1035c;
    }

    public ProgressDialog getProgressView(Activity activity) throws InvalidInputException {
        C1159f.m731a((Object) activity, C1223a.CURRENT_ACTIVITY);
        if (this.f1039g == null) {
            this.f1039g = new C1120a(activity, new C1416a());
        }
        return this.f1039g;
    }

    public void protocolError(ProtocolErrorEvent protocolErrorEvent) {
        m1155b();
        ChallengeStatusReceiver c = m1157c();
        if (c != null) {
            c.protocolError(protocolErrorEvent);
        }
    }

    public void runtimeError(RuntimeErrorEvent runtimeErrorEvent) {
        m1155b();
        ChallengeStatusReceiver c = m1157c();
        if (c != null) {
            c.runtimeError(runtimeErrorEvent);
        }
    }

    public void timedout() {
        m1155b();
        ChallengeStatusReceiver c = m1157c();
        if (c != null) {
            c.timedout();
        }
    }

    /* renamed from: b */
    private void m1156b(C0976a aVar) {
        Activity d = m1158d();
        if (d != null) {
            C1120a aVar2 = this.f1039g;
            if (aVar2 != null) {
                aVar2.hide();
            }
            d.startActivity(mo14879a(d, aVar));
        }
    }

    /* renamed from: a */
    public void mo14845a() {
        m1159e();
    }

    /* renamed from: a */
    public void mo14846a(C0976a aVar) {
        m1156b(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Intent mo14879a(Activity activity, C0976a aVar) {
        return ChallengeActivity.m1166a((Context) activity, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Intent mo14878a(Activity activity) {
        return ChallengeActivity.m1165a((Context) activity);
    }

    /* renamed from: a */
    private C1031a m1153a(String str) throws InvalidInputException {
        try {
            C1048d a = C1048d.m425a(str);
            a.mo13779a(this.f1033a);
            return new C1031a(a.mo13777a().mo13792d());
        } catch (SDKRuntimeException | JSONException e) {
            throw C1223a.CHALLENGE_PARAMETERS.mo13979a(e);
        }
    }

    /* renamed from: a */
    private C1023a m1152a(String str, C1033b bVar) {
        if (bVar instanceof C1032a) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(C1172a.m764a(-2259606129326L), str);
                C1028f fVar = new C1028f(C1010g.f265a, C0973c.f202a, jSONObject);
                C1036e eVar = new C1036e((String) null, this.f1034b.mo13759a((String) null, (String) null, this.f1035c.getSDKReferenceNumber(), ((C1032a) bVar).mo13762f()));
                this.f1034b.mo13765c();
                try {
                    return new C1023a(fVar, fVar.mo13751f().mo13730a(fVar, eVar), eVar);
                } catch (JSONException e) {
                    throw C1225c.CRYPTO_FAILURE.mo13983a(e);
                }
            } catch (JSONException e2) {
                throw C1225c.CRYPTO_FAILURE.mo13983a(e2);
            }
        } else {
            throw C1225c.CRYPTO_FAILURE.mo13982a();
        }
    }

    /* renamed from: b */
    private void m1155b() {
        Activity d = m1158d();
        if (d != null) {
            d.startActivity(mo14878a(d));
        }
    }
}

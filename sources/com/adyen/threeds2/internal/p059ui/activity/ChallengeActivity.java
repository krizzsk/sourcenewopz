package com.adyen.threeds2.internal.p059ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.widget.Toast;
import atd.p013c.C0961a;
import atd.p013c.C0963c;
import atd.p013c.C0965e;
import atd.p013c.C0966f;
import atd.p013c.C0967g;
import atd.p013c.C0968h;
import atd.p013c.C0969i;
import atd.p013c.C0970j;
import atd.p015d.C0976a;
import atd.p040p0.C1127a;
import atd.p040p0.C1128b;
import atd.p040p0.C1129c;
import atd.p040p0.C1130d;
import atd.p040p0.C1131e;
import atd.p042q0.C1134a;
import atd.p042q0.C1139e;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.C1399f;
import com.adyen.threeds2.internal.C1414h;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

/* renamed from: com.adyen.threeds2.internal.ui.activity.ChallengeActivity */
public class ChallengeActivity extends C1421b implements C1128b, C1129c, C1130d, C1131e {

    /* renamed from: d */
    static final String f1044d = ChallengeActivity.class.getSimpleName();

    /* renamed from: e */
    static final String f1045e = (f1044d + C1172a.m764a(-725592228317870L));

    /* renamed from: f */
    static final String f1046f = (f1044d + C1172a.m764a(-725695307532974L));

    /* renamed from: g */
    static final String f1047g = (f1044d + C1172a.m764a(-725798386748078L));

    /* renamed from: h */
    static final String f1048h = (f1044d + C1172a.m764a(-725897170995886L));

    /* renamed from: i */
    static final String f1049i = (f1044d + C1172a.m764a(-726004545178286L));

    /* renamed from: j */
    private static final String f1050j = (f1044d + C1172a.m764a(-726077559622318L));

    /* renamed from: k */
    private static final String f1051k = (f1044d + C1172a.m764a(-726184933804718L));

    /* renamed from: a */
    private C1418a f1052a;

    /* renamed from: b */
    private C0976a f1053b;

    /* renamed from: c */
    private boolean f1054c;

    /* renamed from: a */
    public static Intent m1166a(Context context, C0976a aVar) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(f1047g);
        intent.putExtra(f1049i, aVar);
        return intent;
    }

    /* renamed from: b */
    public static Intent m1171b(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(f1045e);
        return intent;
    }

    /* renamed from: g */
    public static boolean m1172g() {
        return C1418a.m1197g();
    }

    /* renamed from: h */
    private void m1173h() {
        C1134a c = this.f1052a.mo14886c();
        if (c != null) {
            c.setChallengeListener(null);
        }
    }

    /* renamed from: c */
    public void mo13860c() {
    }

    /* renamed from: d */
    public void mo13861d() {
        m1168a((C0963c) new C0968h());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C1414h mo14882e() {
        return C1414h.f1032a;
    }

    public void onBackPressed() {
        super.onBackPressed();
        mo13858a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            if (Process.myPid() != bundle.getInt(f1051k)) {
                finish();
            } else {
                this.f1054c = bundle.getBoolean(f1050j, false);
            }
        }
        this.f1052a = new C1418a(this, this);
        try {
            m1167a(getIntent());
        } catch (SDKRuntimeException e) {
            C1399f.m1120d().mo13556a((Throwable) e, e.getMessage());
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1052a.mo14883a();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m1167a(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m1173h();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C0976a aVar;
        super.onResume();
        m1170a((C1127a) this);
        if (this.f1054c && (aVar = this.f1053b) != null) {
            this.f1052a.mo14884a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f1050j, this.f1054c);
        bundle.putInt(f1051k, Process.myPid());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f1054c = true;
    }

    /* renamed from: b */
    public void mo13859b() {
        m1168a((C0963c) new C0966f());
    }

    /* renamed from: a */
    public static Intent m1165a(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        intent.setAction(f1048h);
        return intent;
    }

    /* renamed from: b */
    public void mo13862b(String str) {
        m1168a((C0963c) new C0965e(str));
    }

    /* renamed from: a */
    public void mo13858a() {
        m1168a((C0963c) new C0961a());
    }

    /* renamed from: a */
    public void mo13866a(String str, String str2) {
        m1169a((C0963c) new C0970j(str), str2);
    }

    /* renamed from: a */
    public void mo13865a(List<String> list, String str) {
        m1169a((C0963c) new C0969i(list), str);
    }

    /* renamed from: a */
    public void mo13863a(Uri uri) {
        Intent intent = new Intent(C1172a.m764a(-725244335966894L));
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.f1054c = true;
            startActivity(intent);
            return;
        }
        SystemUtils.showToast(Toast.makeText(this, C1172a.m764a(-725360300083886L) + uri, 0));
    }

    /* renamed from: a */
    public void mo13864a(String str) {
        m1169a((C0963c) new C0967g(), str);
    }

    /* renamed from: a */
    private void m1167a(Intent intent) {
        setIntent(intent);
        if (f1045e.equals(intent.getAction())) {
            this.f1052a.mo14888i();
        } else if (f1046f.equals(intent.getAction())) {
            this.f1052a.mo14887f();
        } else if (f1047g.equals(intent.getAction())) {
            C0976a aVar = (C0976a) intent.getParcelableExtra(f1049i);
            this.f1053b = aVar;
            this.f1052a.mo14885b(aVar);
        } else if (f1048h.equals(intent.getAction())) {
            finish();
        } else if (!C1172a.m764a(-725433314527918L).equals(intent.getAction()) || intent.getData() == null || !C1172a.m764a(-725549278644910L).equals(intent.getData().getScheme())) {
            throw C1225c.CHALLENGE_PRESENTATION_FAILURE.mo13982a();
        } else {
            C1134a c = this.f1052a.mo14886c();
            String str = null;
            if (c instanceof C1139e) {
                str = ((C1139e) c).getWhitelistStatus();
            }
            m1169a((C0963c) new C0967g(), str);
        }
    }

    /* renamed from: a */
    private void m1170a(C1127a aVar) {
        C1134a c = this.f1052a.mo14886c();
        if (c != null) {
            c.setChallengeListener(aVar);
        }
    }

    /* renamed from: a */
    private void m1168a(C0963c cVar) {
        m1169a(cVar, (String) null);
    }

    /* renamed from: a */
    private void m1169a(C0963c cVar, String str) {
        C1399f.m1120d().mo14854a(cVar, str);
    }
}

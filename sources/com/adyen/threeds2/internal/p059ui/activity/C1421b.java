package com.adyen.threeds2.internal.p059ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import atd.p036n0.C1116a;
import atd.p036n0.C1118b;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.internal.C1414h;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.adyen.threeds2.internal.ui.activity.b */
abstract class C1421b extends AppCompatActivity {
    C1421b() {
    }

    /* renamed from: a */
    private C1118b m1205a(C1414h hVar) {
        UiCustomization a = hVar.mo14877a();
        if (a != null) {
            return new C1118b(getWindow(), new C1116a(a));
        }
        return null;
    }

    /* renamed from: f */
    private void m1207f() {
        getWindow().setFlags(8192, 8192);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract C1414h mo14882e();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        C1118b a = m1205a(mo14882e());
        if (a != null) {
            m1206a(a);
        }
        super.onCreate(bundle);
        m1207f();
    }

    /* renamed from: a */
    private void m1206a(C1118b bVar) {
        LayoutInflater from = LayoutInflater.from(this);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, bVar);
        }
    }
}

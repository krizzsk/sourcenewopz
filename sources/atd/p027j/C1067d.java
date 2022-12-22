package atd.p027j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.j.d */
public class C1067d extends C1065b {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31263520279214L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean mo13785c(Context context) throws C1051c {
        BluetoothAdapter d = mo13794d(context);
        if (d != null) {
            return Boolean.valueOf(d.isEnabled());
        }
        return null;
    }
}

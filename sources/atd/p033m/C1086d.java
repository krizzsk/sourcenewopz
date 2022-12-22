package atd.p033m;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.m.d */
public final class C1086d extends C1053d {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31800391191214L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        if (Build.VERSION.SDK_INT < 31) {
            return Collections.singletonList(C1172a.m764a(-32105333869230L));
        }
        return Collections.unmodifiableList(Arrays.asList(new String[]{C1172a.m764a(-31821866027694L), C1172a.m764a(-31946420079278L)}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Object mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 18) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(C1172a.m764a(-32229887920814L));
            BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
            if (adapter != null) {
                return adapter.getName();
            }
            return null;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}

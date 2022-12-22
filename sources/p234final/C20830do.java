package p234final;

import android.os.Build;
import com.iproov.sdk.cameray.C19768break;
import com.iproov.sdk.cameray.C19775const;
import java.util.ArrayList;
import java.util.List;
import p055case.C1272else;
import p234final.C20833if;

/* renamed from: final.do */
/* compiled from: DeviceManager */
public class C20830do {

    /* renamed from: a */
    private static C20830do f57229a;

    /* renamed from: b */
    private final List<C20833if> f57230b;

    private C20830do() {
        ArrayList arrayList = new ArrayList();
        this.f57230b = arrayList;
        C20833if.C20834do doVar = new C20833if.C20834do("asus", "Nexus 7", "grouper");
        C19768break breakR = C19768break.f54006if;
        arrayList.add(doVar.mo170675do(breakR).mo170677do());
        arrayList.add(new C20833if.C20834do("android", "Amazon Tate", "bowser").mo170675do(breakR).mo170677do());
        arrayList.add(new C20833if.C20834do("Xiaomi", "Mi MIX 2", "qcom").mo170676do(C19775const.CAMERA2).mo170677do());
        arrayList.add(new C20833if.C20834do("LGE", "LG-M700", "mh").mo170676do(C19775const.CAMERA1).mo170677do());
        arrayList.add(new C20833if.C20834do("Huawei", "EML-L09", "kirin970").mo170674do(C1272else.AVC).mo170677do());
    }

    /* renamed from: do */
    public static C20830do m41031do() {
        if (f57229a == null) {
            f57229a = new C20830do();
        }
        return f57229a;
    }

    /* renamed from: if */
    public C20833if mo170663if() {
        return m41030a(Build.MANUFACTURER, Build.MODEL, Build.HARDWARE);
    }

    /* renamed from: a */
    private C20833if m41030a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("Looking for device profile for: ");
        sb.append(Build.MANUFACTURER);
        sb.append(" | ");
        sb.append(Build.MODEL);
        sb.append(" | ");
        sb.append(Build.HARDWARE);
        for (C20833if next : this.f57230b) {
            if ((next.m47639case() == null || next.m47639case().equalsIgnoreCase(str)) && ((next.m47640else() == null || next.m47640else().equalsIgnoreCase(str2)) && (next.m47644try() == null || next.m47644try().equalsIgnoreCase(str3)))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Device profile found: ");
                sb2.append(next.m47639case());
                sb2.append(" | ");
                sb2.append(next.m47640else());
                sb2.append(" | ");
                sb2.append(next.m47644try());
                return next;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("No device-specific profile found. Returning default device profile. ");
        sb3.append(str);
        sb3.append(" | ");
        sb3.append(str2);
        sb3.append(" | ");
        sb3.append(str3);
        return new C20833if(str, str2, str3, (C19768break) null, (C19775const) null, (Double) null, (C1272else) null);
    }
}

package p242io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.plugins.sharedpreferences.a */
/* compiled from: MethodCallHandlerImpl */
class C21162a implements MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private static final String f57902a = "FlutterSharedPreferences";

    /* renamed from: b */
    private static final String f57903b = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";

    /* renamed from: c */
    private static final String f57904c = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";

    /* renamed from: d */
    private static final String f57905d = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";

    /* renamed from: e */
    private final SharedPreferences f57906e;

    /* renamed from: f */
    private final ExecutorService f57907f = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Handler f57908g = new Handler(Looper.getMainLooper());

    C21162a(Context context) {
        this.f57906e = SystemUtils.getSharedPreferences(context, f57902a, 0);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        try {
            String str2 = methodCall.method;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1354815177:
                    if (str2.equals("commit")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1249367445:
                    if (str2.equals("getAll")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1096934831:
                    if (str2.equals("setStringList")) {
                        c = 4;
                        break;
                    }
                    break;
                case -934610812:
                    if (str2.equals(WalletExtraConstant.Key.REMOVE)) {
                        c = 7;
                        break;
                    }
                    break;
                case -905809875:
                    if (str2.equals("setInt")) {
                        c = 2;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c = 8;
                        break;
                    }
                    break;
                case 155439827:
                    if (str2.equals("setDouble")) {
                        c = 1;
                        break;
                    }
                    break;
                case 589412115:
                    if (str2.equals("setString")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1984457324:
                    if (str2.equals("setBool")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m41689a(this.f57906e.edit().putBoolean(str, ((Boolean) methodCall.argument("value")).booleanValue()), result);
                    return;
                case 1:
                    String d = Double.toString(((Number) methodCall.argument("value")).doubleValue());
                    SharedPreferences.Editor edit = this.f57906e.edit();
                    m41689a(edit.putString(str, f57905d + d), result);
                    return;
                case 2:
                    Number number = (Number) methodCall.argument("value");
                    if (number instanceof BigInteger) {
                        SharedPreferences.Editor edit2 = this.f57906e.edit();
                        m41689a(edit2.putString(str, f57904c + ((BigInteger) number).toString(36)), result);
                        return;
                    }
                    m41689a(this.f57906e.edit().putLong(str, number.longValue()), result);
                    return;
                case 3:
                    String str3 = (String) methodCall.argument("value");
                    if (!str3.startsWith(f57903b) && !str3.startsWith(f57904c)) {
                        if (!str3.startsWith(f57905d)) {
                            m41689a(this.f57906e.edit().putString(str, str3), result);
                            return;
                        }
                    }
                    result.error("StorageError", "This string cannot be stored as it clashes with special identifier prefixes.", (Object) null);
                    return;
                case 4:
                    SharedPreferences.Editor edit3 = this.f57906e.edit();
                    m41689a(edit3.putString(str, f57903b + m41687a((List<String>) (List) methodCall.argument("value"))), result);
                    return;
                case 5:
                    result.success(true);
                    return;
                case 6:
                    result.success(m41690b());
                    return;
                case 7:
                    m41689a(this.f57906e.edit().remove(str), result);
                    return;
                case 8:
                    Set<String> keySet = m41690b().keySet();
                    SharedPreferences.Editor edit4 = this.f57906e.edit();
                    for (String remove : keySet) {
                        edit4.remove(remove);
                    }
                    m41689a(edit4, result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        } catch (IOException e) {
            result.error("IOException encountered", methodCall.method, e);
        }
        result.error("IOException encountered", methodCall.method, e);
    }

    /* renamed from: a */
    public void mo172912a() {
        this.f57908g.removeCallbacksAndMessages((Object) null);
        this.f57907f.shutdown();
    }

    /* renamed from: a */
    private void m41689a(SharedPreferences.Editor editor, MethodChannel.Result result) {
        this.f57907f.execute(new MethodCallHandlerImpl$1(this, editor, result));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m41688a(java.lang.String r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x0022 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ ClassNotFoundException -> 0x0022 }
            r3 = 0
            byte[] r5 = android.util.Base64.decode(r5, r3)     // Catch:{ ClassNotFoundException -> 0x0022 }
            r2.<init>(r5)     // Catch:{ ClassNotFoundException -> 0x0022 }
            r1.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0022 }
            java.lang.Object r5 = r1.readObject()     // Catch:{ ClassNotFoundException -> 0x001d, all -> 0x001a }
            java.util.List r5 = (java.util.List) r5     // Catch:{ ClassNotFoundException -> 0x001d, all -> 0x001a }
            r1.close()
            return r5
        L_0x001a:
            r5 = move-exception
            r0 = r1
            goto L_0x0029
        L_0x001d:
            r5 = move-exception
            r0 = r1
            goto L_0x0023
        L_0x0020:
            r5 = move-exception
            goto L_0x0029
        L_0x0022:
            r5 = move-exception
        L_0x0023:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0020 }
            r1.<init>(r5)     // Catch:{ all -> 0x0020 }
            throw r1     // Catch:{ all -> 0x0020 }
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            r0.close()
        L_0x002e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.plugins.sharedpreferences.C21162a.m41688a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m41687a(java.util.List<java.lang.String> r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0021 }
            r1.<init>()     // Catch:{ all -> 0x0021 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0021 }
            r2.<init>(r1)     // Catch:{ all -> 0x0021 }
            r2.writeObject(r4)     // Catch:{ all -> 0x001e }
            r2.flush()     // Catch:{ all -> 0x001e }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x001e }
            r0 = 0
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r0)     // Catch:{ all -> 0x001e }
            r2.close()
            return r4
        L_0x001e:
            r4 = move-exception
            r0 = r2
            goto L_0x0022
        L_0x0021:
            r4 = move-exception
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()
        L_0x0027:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.plugins.sharedpreferences.C21162a.m41687a(java.util.List):java.lang.String");
    }

    /* renamed from: b */
    private Map<String, Object> m41690b() throws IOException {
        BigInteger bigInteger;
        Map<String, ?> all = this.f57906e.getAll();
        HashMap hashMap = new HashMap();
        for (String next : all.keySet()) {
            if (next.startsWith("flutter.")) {
                Object obj = all.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.startsWith(f57903b)) {
                        obj = m41688a(str.substring(40));
                    } else if (str.startsWith(f57904c)) {
                        bigInteger = new BigInteger(str.substring(44), 36);
                    } else if (str.startsWith(f57905d)) {
                        obj = Double.valueOf(str.substring(40));
                    }
                    hashMap.put(next, obj);
                } else {
                    if (obj instanceof Set) {
                        ArrayList arrayList = new ArrayList((Set) obj);
                        SharedPreferences.Editor remove = this.f57906e.edit().remove(next);
                        bigInteger = arrayList;
                        if (!remove.putString(next, f57903b + m41687a((List<String>) arrayList)).commit()) {
                            throw new IOException("Could not migrate set to list");
                        }
                    }
                    hashMap.put(next, obj);
                }
                obj = bigInteger;
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }
}

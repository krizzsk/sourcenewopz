package atd.p034m0;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Debug;
import atd.p044r0.C1158e;
import atd.p044r0.C1160g;
import atd.p046s0.C1172a;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* renamed from: atd.m0.g */
public final class C1113g implements C1107a, C1108b, C1109c, C1110d, C1112f {
    static {
        C1172a.m764a(-724076104862382L);
        C1172a.m764a(-724179184077486L);
    }

    /* renamed from: c */
    private boolean m598c() {
        String str = Build.TAGS;
        return str != null && str.contains(C1172a.m764a(-721215656643246L));
    }

    /* renamed from: d */
    private boolean m599d() {
        for (File exists : m600e()) {
            if (exists.exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private List<File> m600e() {
        return Arrays.asList(new File[]{new File(m592a(C1172a.m764a(-721258606316206L))), new File(m592a(C1172a.m764a(-721658038274734L))), new File(m592a(C1172a.m764a(-721795477228206L))), new File(m592a(C1172a.m764a(-722023110494894L))), new File(m592a(C1172a.m764a(-722263628663470L))), new File(m592a(C1172a.m764a(-722572866308782L))), new File(m592a(C1172a.m764a(-722860629117614L))), new File(m592a(C1172a.m764a(-723148391926446L))), new File(m592a(C1172a.m764a(-723513464146606L))), new File(m592a(C1172a.m764a(-723741097413294L)))});
    }

    /* renamed from: a */
    public boolean mo13838a() {
        return Build.FINGERPRINT.startsWith(C1172a.m764a(-720781864946350L)) || Build.FINGERPRINT.startsWith(C1172a.m764a(-720816224684718L)) || Build.MODEL.contains(C1172a.m764a(-720850584423086L)) || Build.MODEL.contains(C1172a.m764a(-720889239128750L)) || Build.MODEL.contains(C1172a.m764a(-721000908278446L)) || Build.MANUFACTURER.contains(C1172a.m764a(-721048152918702L)) || (Build.BRAND.startsWith(C1172a.m764a(-721095397558958L)) && Build.DEVICE.startsWith(C1172a.m764a(-721129757297326L))) || C1172a.m764a(-721164117035694L).equals(Build.PRODUCT);
    }

    /* renamed from: b */
    public boolean mo13836b(Context context) {
        return m597b() || Debug.isDebuggerConnected() || (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: b */
    public boolean mo13841b(Context context, Collection<String> collection) {
        return false;
    }

    /* renamed from: b */
    private boolean m597b() {
        try {
            throw new Exception(C1172a.m764a(-721211361675950L));
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                for (String startsWith : C1111e.m590a()) {
                    if (stackTraceElement.getClassName().startsWith(startsWith)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: b */
    private String m596b(String str) {
        return str.replaceAll(m592a(C1172a.m764a(-724015975320238L)), C1172a.m764a(-724050335058606L)).toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public boolean mo13837a(Context context) {
        return m597b() || m598c() || m599d();
    }

    /* renamed from: a */
    public boolean mo13839a(Context context, String str) {
        Signature[] a;
        if (str == null || (a = C1158e.m729a(context)) == null) {
            return false;
        }
        return m595a(a, str);
    }

    /* renamed from: a */
    public boolean mo13840a(Context context, Collection<String> collection) {
        HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
        hashSet.addAll(C1114h.m609a());
        return C1158e.m728a(context, hashSet);
    }

    /* renamed from: a */
    public boolean mo13842a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private boolean m595a(Signature[] signatureArr, String str) {
        for (Signature a : signatureArr) {
            if (m594a(a, str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m594a(Signature signature, String str) {
        String b = m596b(str);
        try {
            MessageDigest instance = MessageDigest.getInstance(m592a(C1172a.m764a(-723912896105134L)));
            instance.update(signature.toByteArray());
            return m593a(instance.digest()).equals(b);
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private String m593a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            sb.append(String.format(C1172a.m764a(-724054630025902L), new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m592a(String str) {
        return C1160g.m734a(str);
    }
}

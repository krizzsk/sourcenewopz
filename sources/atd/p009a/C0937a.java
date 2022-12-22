package atd.p009a;

import atd.p009a.C0953j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: atd.a.a */
public abstract class C0937a {

    /* renamed from: b */
    static final int f153b = ((int) TimeUnit.SECONDS.toMillis(60));

    /* renamed from: c */
    static final int f154c = ((int) TimeUnit.SECONDS.toMillis(60));

    /* renamed from: a */
    private final C0938b f155a = new C0947g();

    /* renamed from: b */
    private HttpURLConnection m106b(C0951i iVar) throws IOException {
        HttpURLConnection a = this.f155a.mo13553a(iVar.mo13575d());
        a.setRequestMethod(iVar.mo13574c().mo13567a());
        a.setConnectTimeout(mo13550a());
        a.setReadTimeout(mo13552b());
        a.setUseCaches(false);
        a.setDoInput(true);
        a.setDoOutput(iVar.mo13574c().mo13568b());
        Map<String, List<String>> b = iVar.mo13573b();
        if (b != null) {
            for (Map.Entry next : b.entrySet()) {
                String str = (String) next.getKey();
                for (String addRequestProperty : (List) next.getValue()) {
                    a.addRequestProperty(str, addRequestProperty);
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo13550a();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public atd.p009a.C0953j mo13551a(atd.p009a.C0951i r3) throws java.io.IOException {
        /*
            r2 = this;
            java.net.HttpURLConnection r0 = r2.m106b(r3)     // Catch:{ all -> 0x002e }
            r0.connect()     // Catch:{ all -> 0x002c }
            atd.a.f r1 = r3.mo13574c()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.mo13568b()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0022
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ all -> 0x002c }
            byte[] r3 = r3.mo13572a()     // Catch:{ all -> 0x002c }
            r1.write(r3)     // Catch:{ all -> 0x002c }
            r1.flush()     // Catch:{ all -> 0x002c }
            r1.close()     // Catch:{ all -> 0x002c }
        L_0x0022:
            atd.a.j r3 = r2.m104a((java.net.HttpURLConnection) r0)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x002b
            r0.disconnect()
        L_0x002b:
            return r3
        L_0x002c:
            r3 = move-exception
            goto L_0x0030
        L_0x002e:
            r3 = move-exception
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.disconnect()
        L_0x0035:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atd.p009a.C0937a.mo13551a(atd.a.i):atd.a.j");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo13552b();

    /* renamed from: a */
    private C0953j m104a(HttpURLConnection httpURLConnection) throws IOException {
        C0953j.C0954a a = new C0953j.C0954a().mo13584a(httpURLConnection.getResponseCode()).mo13586a((Map<String, List<String>>) httpURLConnection.getHeaderFields()).mo13585a(httpURLConnection.getResponseMessage());
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            errorStream = httpURLConnection.getInputStream();
        }
        a.mo13587a(m105a(errorStream));
        return a.mo13588a();
    }

    /* renamed from: a */
    private byte[] m105a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr);
        while (read > 0) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}

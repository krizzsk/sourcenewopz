package p240import;

import android.content.Context;
import android.graphics.RectF;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.core.exception.NetworkException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import p242io.socket.client.C21231IO;

/* renamed from: import.a */
/* compiled from: StreamerUtils */
class C21004a {

    /* renamed from: a */
    private static final String f57280a = C21006if.class.getSimpleName();

    /* renamed from: a */
    static void m41072a(Context context, IProov.Options.Network network, C21231IO.Options options) throws IProovException {
        X509TrustManager x509TrustManager;
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            m41073a(context, instance, network.certificates);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    x509TrustManager = null;
                    break;
                }
                TrustManager trustManager = trustManagers[i];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i++;
            }
            if (x509TrustManager != null) {
                SSLContext instance3 = SSLContext.getInstance("TLS");
                instance3.init((KeyManager[]) null, trustManagers, (SecureRandom) null);
                OkHttpClient build = new OkHttpClient.Builder().sslSocketFactory(instance3.getSocketFactory(), x509TrustManager).build();
                options.secure = true;
                options.callFactory = build;
                options.webSocketFactory = build;
                return;
            }
            throw new NetworkException(context, "Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetworkException(context, e.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private static void m41073a(Context context, KeyStore keyStore, List<Object> list) throws CertificateException, IProovException {
        InputStream inputStream;
        int i = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (obj instanceof Integer) {
                inputStream = new BufferedInputStream(context.getResources().openRawResource(((Integer) obj).intValue()));
            } else if (obj instanceof byte[]) {
                inputStream = new ByteArrayInputStream((byte[]) obj);
            } else if (obj instanceof Byte[]) {
                Byte[] bArr = (Byte[]) obj;
                byte[] bArr2 = new byte[bArr.length];
                int i2 = 0;
                while (i2 < bArr.length) {
                    Byte b = bArr[i2];
                    if (b != null) {
                        bArr2[i2] = b.byteValue();
                        i2++;
                    } else {
                        throw new InvalidOptionsException(context, "Certificate byte array can not contain a null element");
                    }
                }
                inputStream = new ByteArrayInputStream(bArr2);
            } else {
                throw new InvalidOptionsException(context, "Certificate must be of type Integer (raw resource id) or Byte array (contents of certificate in der format)");
            }
            try {
                Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
                if (!generateCertificates.isEmpty()) {
                    int i3 = 0;
                    for (Certificate certificate : generateCertificates) {
                        keyStore.setCertificateEntry("ca" + i + "-" + i3, certificate);
                        i3++;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ca");
                        sb.append(i);
                        sb.append("-");
                        sb.append(i3);
                        sb.append("=");
                        sb.append(((X509Certificate) certificate).getSubjectDN());
                    }
                    i++;
                } else {
                    throw new InvalidOptionsException(context, "Certificate file appears to be empty or not valid");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new InvalidOptionsException(context, e.getLocalizedMessage());
            }
        }
    }

    /* renamed from: a */
    static JSONArray m41071a(RectF rectF) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((double) rectF.left);
        jSONArray.put((double) rectF.top);
        jSONArray.put((double) rectF.width());
        jSONArray.put((double) rectF.height());
        return jSONArray;
    }
}

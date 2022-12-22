package com.jumio.core.network;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import com.jumio.commons.log.Log;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H$¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0004R\u001c\u0010\u0016\u001a\u00020\u00058\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, mo175978d2 = {"Lcom/jumio/core/network/JumioTrustManager;", "Ljavax/net/ssl/X509TrustManager;", "", "Ljava/security/cert/X509Certificate;", "chain", "", "authType", "", "checkClientTrusted", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "x509Certificates", "checkCertificateChain", "([Ljava/security/cert/X509Certificate;)V", "x509Certificate", "checkCertificate", "a", "Ljava/lang/String;", "getHostname", "()Ljava/lang/String;", "hostname", "<init>", "(Ljava/lang/String;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioTrustManager.kt */
public abstract class JumioTrustManager implements X509TrustManager {

    /* renamed from: a */
    public final String f54907a;

    /* renamed from: b */
    public final X509TrustManager f54908b;

    public JumioTrustManager(String str) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        this.f54907a = str;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager trustManager = instance.getTrustManagers()[0];
        if (trustManager != null) {
            this.f54908b = (X509TrustManager) trustManager;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    public final void checkCertificate(X509Certificate x509Certificate) throws CertificateException {
        Intrinsics.checkNotNullParameter(x509Certificate, "x509Certificate");
        try {
            x509Certificate.checkValidity();
        } catch (CertificateNotYetValidException e) {
            try {
                Log.m39477w("JumioTrustManager", "SSL Certificate is not yet valid", (Throwable) e);
            } catch (Exception e2) {
                throw new CertificateException("SSL Certificate match error", e2);
            }
        }
    }

    public abstract void checkCertificateChain(X509Certificate[] x509CertificateArr) throws CertificateException;

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
        Intrinsics.checkNotNullParameter(str, "authType");
        this.f54908b.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
        Intrinsics.checkNotNullParameter(str, "authType");
        if (x509CertificateArr.length >= 2) {
            if (Build.VERSION.SDK_INT >= 24) {
                new X509TrustManagerExtensions(this.f54908b).checkServerTrusted(x509CertificateArr, str, this.f54907a);
            } else {
                this.f54908b.checkServerTrusted(x509CertificateArr, str);
            }
            checkCertificateChain(x509CertificateArr);
            return;
        }
        throw new CertificateException("SSL Certificate Chain is not sufficient");
    }

    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] acceptedIssuers = this.f54908b.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "defaultTrustManager.acceptedIssuers");
        return acceptedIssuers;
    }

    public final String getHostname() {
        return this.f54907a;
    }
}

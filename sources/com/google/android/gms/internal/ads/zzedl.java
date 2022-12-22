package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedl {
    private static final Logger logger = Logger.getLogger(zzedl.class.getName());
    private static final ConcurrentMap<String, zzb> zzifd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zza> zzife = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zziff = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzecm<?>> zzifg = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzedg<?, ?>> zzifh = new ConcurrentHashMap();

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private interface zza {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private interface zzb {
        Set<Class<?>> zzbbl();

        zzect<?> zzbbv();

        Class<?> zzbbw();

        Class<?> zzbbx();

        <P> zzect<P> zzc(Class<P> cls) throws GeneralSecurityException;
    }

    private static <KeyProtoT extends zzeon> zzb zza(zzecu<KeyProtoT> zzecu) {
        return new zzedn(zzecu);
    }

    private static <KeyProtoT extends zzeon> zza zzb(zzecu<KeyProtoT> zzecu) {
        return new zzedo(zzecu);
    }

    private static synchronized zzb zzhr(String str) throws GeneralSecurityException {
        zzb zzb2;
        synchronized (zzedl.class) {
            if (!zzifd.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzb2 = (zzb) zzifd.get(str);
        }
        return zzb2;
    }

    @Deprecated
    public static zzecm<?> zzhs(String str) throws GeneralSecurityException {
        if (str != null) {
            zzecm<?> zzecm = (zzecm) zzifg.get(str.toLowerCase(Locale.US));
            if (zzecm != null) {
                return zzecm;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void zza(java.lang.String r8, java.lang.Class<?> r9, boolean r10) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzedl> r0 = com.google.android.gms.internal.ads.zzedl.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzedl$zzb> r1 = zzifd     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzedl$zzb> r1 = zzifd     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzedl$zzb r1 = (com.google.android.gms.internal.ads.zzedl.zzb) r1     // Catch:{ all -> 0x0093 }
            java.lang.Class r2 = r1.zzbbw()     // Catch:{ all -> 0x0093 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0093 }
            if (r2 != 0) goto L_0x0065
            java.util.logging.Logger r10 = logger     // Catch:{ all -> 0x0093 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r7 = r6.length()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0038
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x003e
        L_0x0038:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r5 = r6
        L_0x003e:
            r10.logp(r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0093 }
            r4 = 0
            r3[r4] = r8     // Catch:{ all -> 0x0093 }
            r8 = 1
            java.lang.Class r1 = r1.zzbbw()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r1     // Catch:{ all -> 0x0093 }
            r8 = 2
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r9     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0093 }
            r10.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r10     // Catch:{ all -> 0x0093 }
        L_0x0065:
            if (r10 == 0) goto L_0x0091
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = zziff     // Catch:{ all -> 0x0093 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x0093 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0093 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0093 }
            if (r9 != 0) goto L_0x0091
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r1 = r8.length()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0088:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r8.<init>(r10)     // Catch:{ all -> 0x0093 }
        L_0x008d:
            r9.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedl.zza(java.lang.String, java.lang.Class, boolean):void");
    }

    public static synchronized <P> void zza(zzect<P> zzect, boolean z) throws GeneralSecurityException {
        synchronized (zzedl.class) {
            if (zzect != null) {
                String keyType = zzect.getKeyType();
                zza(keyType, zzect.getClass(), z);
                zzifd.putIfAbsent(keyType, new zzedk(zzect));
                zziff.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzeon> void zza(zzecu<KeyProtoT> zzecu, boolean z) throws GeneralSecurityException {
        synchronized (zzedl.class) {
            String keyType = zzecu.getKeyType();
            zza(keyType, zzecu.getClass(), true);
            if (!zzifd.containsKey(keyType)) {
                zzifd.put(keyType, zza(zzecu));
                zzife.put(keyType, zzb(zzecu));
            }
            zziff.put(keyType, true);
        }
    }

    public static synchronized <KeyProtoT extends zzeon, PublicKeyProtoT extends zzeon> void zza(zzedi<KeyProtoT, PublicKeyProtoT> zzedi, zzecu<PublicKeyProtoT> zzecu, boolean z) throws GeneralSecurityException {
        Class<?> zzbbx;
        synchronized (zzedl.class) {
            String keyType = zzedi.getKeyType();
            String keyType2 = zzecu.getKeyType();
            zza(keyType, zzedi.getClass(), true);
            zza(keyType2, zzecu.getClass(), false);
            if (!keyType.equals(keyType2)) {
                if (zzifd.containsKey(keyType) && (zzbbx = ((zzb) zzifd.get(keyType)).zzbbx()) != null) {
                    if (!zzbbx.equals(zzecu.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzedi.getClass().getName(), zzbbx.getName(), zzecu.getClass().getName()}));
                    }
                }
                if (!zzifd.containsKey(keyType) || ((zzb) zzifd.get(keyType)).zzbbx() == null) {
                    zzifd.put(keyType, new zzedm(zzedi, zzecu));
                    zzife.put(keyType, zzb(zzedi));
                }
                zziff.put(keyType, true);
                if (!zzifd.containsKey(keyType2)) {
                    zzifd.put(keyType2, zza(zzecu));
                }
                zziff.put(keyType2, false);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    public static synchronized <B, P> void zza(zzedg<B, P> zzedg) throws GeneralSecurityException {
        synchronized (zzedl.class) {
            if (zzedg != null) {
                Class<P> zzbbh = zzedg.zzbbh();
                if (zzifh.containsKey(zzbbh)) {
                    zzedg zzedg2 = (zzedg) zzifh.get(zzbbh);
                    if (!zzedg.getClass().equals(zzedg2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzbbh);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzbbh.getName(), zzedg2.getClass().getName(), zzedg.getClass().getName()}));
                    }
                }
                zzifh.put(zzbbh, zzedg);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static zzect<?> zzht(String str) throws GeneralSecurityException {
        return zzhr(str).zzbbv();
    }

    private static <P> zzect<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzb zzhr = zzhr(str);
        if (cls == null) {
            return zzhr.zzbbv();
        }
        if (zzhr.zzbbl().contains(cls)) {
            return zzhr.zzc(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhr.zzbbw());
        Set<Class<?>> zzbbl = zzhr.zzbbl();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzbbl) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static synchronized zzeic zza(zzeif zzeif) throws GeneralSecurityException {
        zzeic zzo;
        synchronized (zzedl.class) {
            zzect<?> zzht = zzht(zzeif.zzbev());
            if (((Boolean) zziff.get(zzeif.zzbev())).booleanValue()) {
                zzo = zzht.zzo(zzeif.zzbew());
            } else {
                String valueOf = String.valueOf(zzeif.zzbev());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static synchronized zzeon zzb(zzeif zzeif) throws GeneralSecurityException {
        zzeon zzn;
        synchronized (zzedl.class) {
            zzect<?> zzht = zzht(zzeif.zzbev());
            if (((Boolean) zziff.get(zzeif.zzbev())).booleanValue()) {
                zzn = zzht.zzn(zzeif.zzbew());
            } else {
                String valueOf = String.valueOf(zzeif.zzbev());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    public static <P> P zza(String str, zzeon zzeon, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zza(zzeon);
    }

    private static <P> P zza(String str, zzelq zzelq, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zzm(zzelq);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzelq.zzt(bArr), cls);
    }

    public static <P> P zza(zzeic zzeic, Class<P> cls) throws GeneralSecurityException {
        return zza(zzeic.zzbev(), zzeic.zzbew(), cls);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzedc, com.google.android.gms.internal.ads.zzedc<B>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <B, P> P zza(com.google.android.gms.internal.ads.zzedc<B> r3, java.lang.Class<P> r4) throws java.security.GeneralSecurityException {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.google.android.gms.internal.ads.zzedg<?, ?>> r0 = zzifh
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.ads.zzedg r4 = (com.google.android.gms.internal.ads.zzedg) r4
            if (r4 != 0) goto L_0x002e
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            java.lang.String r0 = "No wrapper found for "
            java.lang.Class r3 = r3.zzbbh()
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r1 = r3.length()
            if (r1 == 0) goto L_0x0025
            java.lang.String r3 = r0.concat(r3)
            goto L_0x002a
        L_0x0025:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
        L_0x002a:
            r4.<init>(r3)
            throw r4
        L_0x002e:
            java.lang.Class r0 = r4.zzbbu()
            java.lang.Class r1 = r3.zzbbh()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0041
            java.lang.Object r3 = r4.zza(r3)
            return r3
        L_0x0041:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Class r4 = r4.zzbbu()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.Class r3 = r3.zzbbh()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r1 = r1.length()
            int r1 = r1 + 44
            java.lang.String r2 = java.lang.String.valueOf(r3)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Wrong input primitive class, expected "
            r2.append(r1)
            r2.append(r4)
            java.lang.String r4 = ", got "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedl.zza(com.google.android.gms.internal.ads.zzedc, java.lang.Class):java.lang.Object");
    }

    public static Class<?> zzd(Class<?> cls) {
        zzedg zzedg = (zzedg) zzifh.get(cls);
        if (zzedg == null) {
            return null;
        }
        return zzedg.zzbbu();
    }

    private zzedl() {
    }
}

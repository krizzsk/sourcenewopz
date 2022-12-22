package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C18431af;
import com.google.android.play.core.internal.C18448aw;
import com.google.android.play.core.internal.C18477by;
import com.google.android.play.core.splitcompat.C18546p;
import com.google.android.play.core.splitinstall.C18577e;
import com.google.android.play.core.splitinstall.C18580h;
import com.google.android.play.core.splitinstall.C18584l;
import com.google.android.play.core.splitinstall.C18589p;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {

    /* renamed from: a */
    public static final /* synthetic */ int f53348a = 0;

    /* renamed from: c */
    private static final long f53349c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b */
    private final Handler f53350b;

    /* renamed from: d */
    private final Context f53351d;

    /* renamed from: e */
    private final C18589p f53352e;

    /* renamed from: f */
    private final C18477by f53353f;

    /* renamed from: g */
    private final C18431af<SplitInstallSessionState> f53354g;

    /* renamed from: h */
    private final Executor f53355h;

    /* renamed from: i */
    private final C18577e f53356i;

    /* renamed from: j */
    private final File f53357j;

    /* renamed from: k */
    private final AtomicReference<SplitInstallSessionState> f53358k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Set<String> f53359l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Set<String> f53360m;

    /* renamed from: n */
    private final AtomicBoolean f53361n;

    /* renamed from: o */
    private final C18594a f53362o;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new C18589p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, File file, C18589p pVar) {
        Executor a = C18546p.m38077a();
        C18477by byVar = new C18477by(context);
        C18594a aVar = C18594a.f53364a;
        this.f53350b = new Handler(Looper.getMainLooper());
        this.f53358k = new AtomicReference<>();
        this.f53359l = Collections.synchronizedSet(new HashSet());
        this.f53360m = Collections.synchronizedSet(new HashSet());
        this.f53361n = new AtomicBoolean(false);
        this.f53351d = context;
        this.f53357j = file;
        this.f53352e = pVar;
        this.f53355h = a;
        this.f53353f = byVar;
        this.f53362o = aVar;
        this.f53354g = new C18431af<>();
        this.f53356i = C18584l.f53328a;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m38182a(int i, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    /* renamed from: a */
    private final synchronized SplitInstallSessionState m38183a(C18603j jVar) {
        SplitInstallSessionState c = m38196c();
        SplitInstallSessionState a = jVar.mo149310a(c);
        if (this.f53358k.compareAndSet(c, a)) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m38184a(Integer num, int i, int i2, Long l, Long l2, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i, i2, l == null ? create.bytesDownloaded() : l.longValue(), l2 == null ? create.totalBytesToDownload() : l2.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    /* renamed from: a */
    private static String m38185a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m38190a(List<Intent> list, List<String> list2, List<String> list3, long j, boolean z) {
        List<Intent> list4 = list;
        this.f53356i.mo149295a().mo149097a(list, new C18602i(this, list2, list3, j, z, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m38191a(int i) {
        return m38192a(6, i, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m38192a(int i, int i2, Long l, Long l2, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState a = m38183a((C18603j) new C18595b(num, i, i2, l, l2, list, list2));
        if (a == null) {
            return false;
        }
        m38195b(a);
        return true;
    }

    /* renamed from: b */
    private final void m38195b(SplitInstallSessionState splitInstallSessionState) {
        this.f53350b.post(new C18599f(this, splitInstallSessionState));
    }

    /* renamed from: c */
    private final SplitInstallSessionState m38196c() {
        return this.f53358k.get();
    }

    /* renamed from: d */
    private final C18580h m38197d() {
        C18580h c = this.f53352e.mo149302c();
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo149304a() {
        return this.f53357j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149305a(long j, List list, List list2, List list3) {
        long j2 = j;
        long j3 = j2 / 3;
        long j4 = 0;
        int i = 0;
        while (i < 3) {
            j4 = Math.min(j2, j4 + j3);
            m38192a(2, 0, Long.valueOf(j4), Long.valueOf(j), (List<String>) null, (Integer) null, (List<String>) null);
            SystemClock.sleep(f53349c);
            SplitInstallSessionState c = m38196c();
            if (c.status() != 9 && c.status() != 7 && c.status() != 6) {
                i++;
            } else {
                return;
            }
        }
        this.f53355h.execute(new C18601h(this, list, list2, list3, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149306a(SplitInstallSessionState splitInstallSessionState) {
        this.f53354g.mo149079a(splitInstallSessionState);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149307a(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String a = C18448aw.m37796a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.f53351d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", m38185a(a));
            intent.putExtra("split_id", a);
            arrayList.add(intent);
            arrayList2.add(m38185a(C18448aw.m37796a(file)));
        }
        SplitInstallSessionState c = m38196c();
        if (c != null) {
            this.f53355h.execute(new C18600g(this, c.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149308a(List list, List list2, List list3, long j) {
        if (this.f53361n.get()) {
            m38191a(-6);
        } else {
            m38190a((List<Intent>) list, (List<String>) list2, (List<String>) list3, j, false);
        }
    }

    public final Task<Void> cancelInstall(int i) {
        try {
            SplitInstallSessionState a = m38183a((C18603j) new C18598e(i));
            if (a != null) {
                m38195b(a);
            }
            return Tasks.m38221a(null);
        } catch (SplitInstallException e) {
            return Tasks.m38220a((Exception) e);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.m38220a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.m38220a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.m38220a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.m38220a((Exception) new SplitInstallException(-5));
    }

    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.f53352e.mo149301b() != null) {
            hashSet.addAll(this.f53352e.mo149301b());
        }
        hashSet.addAll(this.f53360m);
        return hashSet;
    }

    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f53352e.mo149300a());
        hashSet.addAll(this.f53359l);
        return hashSet;
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState c = m38196c();
        return (c == null || c.sessionId() != i) ? Tasks.m38220a((Exception) new SplitInstallException(-4)) : Tasks.m38221a(c);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState c = m38196c();
        return Tasks.m38221a(c != null ? Collections.singletonList(c) : Collections.emptyList());
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f53354g.mo149078a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.f53361n.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0137, code lost:
        if (r4.contains(r15) == false) goto L_0x013e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r25) {
        /*
            r24 = this;
            r9 = r24
            com.google.android.play.core.splitinstall.testing.d r0 = new com.google.android.play.core.splitinstall.testing.d     // Catch:{ SplitInstallException -> 0x0238 }
            r1 = r25
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x0238 }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r9.m38183a((com.google.android.play.core.splitinstall.testing.C18603j) r0)     // Catch:{ SplitInstallException -> 0x0238 }
            if (r0 == 0) goto L_0x022c
            int r0 = r0.sessionId()     // Catch:{ SplitInstallException -> 0x0238 }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r2 = r25.getLanguages()
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.f53357j
            java.io.File[] r3 = r3.listFiles()
            if (r3 != 0) goto L_0x005e
            r12 = 5
            r15 = 0
            r17 = -1
            java.lang.String r13 = "FakeSplitInstallManager"
            java.lang.String r14 = "Specified splits directory does not exist."
            java.lang.String r16 = "com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager"
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -5
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m38220a((java.lang.Exception) r0)
            return r0
        L_0x005e:
            int r4 = r3.length
            r8 = 0
            r12 = 0
        L_0x0062:
            if (r8 >= r4) goto L_0x01a3
            r14 = r3[r8]
            java.lang.String r15 = com.google.android.play.core.internal.C18448aw.m37796a(r14)
            java.lang.String r5 = m38185a((java.lang.String) r15)
            java.util.List r6 = r25.getModuleNames()
            boolean r5 = r6.contains(r5)
            if (r5 == 0) goto L_0x013a
            java.lang.String r5 = m38185a((java.lang.String) r15)
            java.util.HashSet r6 = new java.util.HashSet
            com.google.android.play.core.internal.by r7 = r9.f53353f
            java.util.List r7 = r7.mo149132a()
            r6.<init>(r7)
            com.google.android.play.core.splitinstall.h r7 = r24.m38197d()
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r18 = 0
            r1[r18] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            java.util.Map r1 = r7.mo149298a(r1)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a7:
            boolean r19 = r7.hasNext()
            if (r19 == 0) goto L_0x00bd
            java.lang.Object r19 = r7.next()
            r20 = r3
            r3 = r19
            java.util.Set r3 = (java.util.Set) r3
            r5.addAll(r3)
            r3 = r20
            goto L_0x00a7
        L_0x00bd:
            r20 = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x00c8:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f4
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r19 = r4
            java.lang.String r4 = "_"
            boolean r21 = r7.contains(r4)
            if (r21 == 0) goto L_0x00e9
            r21 = r6
            r6 = -1
            java.lang.String[] r4 = r7.split(r4, r6)
            r6 = 0
            r7 = r4[r6]
            goto L_0x00ec
        L_0x00e9:
            r21 = r6
            r6 = 0
        L_0x00ec:
            r3.add(r7)
            r4 = r19
            r6 = r21
            goto L_0x00c8
        L_0x00f4:
            r19 = r4
            r6 = 0
            java.util.Set<java.lang.String> r4 = r9.f53360m
            r3.addAll(r4)
            r3.addAll(r10)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x010c:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x012d
            java.lang.Object r7 = r1.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r6 = r7.getKey()
            boolean r6 = r3.contains(r6)
            if (r6 == 0) goto L_0x012b
            java.lang.Object r6 = r7.getValue()
            java.util.Collection r6 = (java.util.Collection) r6
            r4.addAll(r6)
        L_0x012b:
            r6 = 0
            goto L_0x010c
        L_0x012d:
            boolean r1 = r5.contains(r15)
            if (r1 == 0) goto L_0x018a
            boolean r1 = r4.contains(r15)
            if (r1 == 0) goto L_0x013e
            goto L_0x018a
        L_0x013a:
            r20 = r3
            r19 = r4
        L_0x013e:
            java.util.List r1 = r25.getLanguages()
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.Set<java.lang.String> r4 = r9.f53359l
            r3.<init>(r4)
            java.lang.String r4 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.addAll(r4)
            com.google.android.play.core.splitinstall.h r4 = r24.m38197d()
            java.util.Map r3 = r4.mo149298a(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0164:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0199
            java.lang.Object r4 = r1.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r5 = r4.getLanguage()
            boolean r5 = r3.containsKey(r5)
            if (r5 == 0) goto L_0x0164
            java.lang.String r4 = r4.getLanguage()
            java.lang.Object r4 = r3.get(r4)
            java.util.Set r4 = (java.util.Set) r4
            boolean r4 = r4.contains(r15)
            if (r4 == 0) goto L_0x0164
        L_0x018a:
            long r3 = r14.length()
            long r12 = r12 + r3
            java.lang.String r1 = com.google.android.play.core.internal.C18448aw.m37796a(r14)
            r2.add(r1)
            r11.add(r14)
        L_0x0199:
            int r8 = r8 + 1
            r1 = r25
            r4 = r19
            r3 = r20
            goto L_0x0062
        L_0x01a3:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.util.List r3 = r25.getModuleNames()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r4 = r4 + 21
            int r4 = r4 + r5
            r6.<init>(r4)
            java.lang.String r4 = "availableSplits"
            r6.append(r4)
            r6.append(r1)
            java.lang.String r1 = " want "
            r6.append(r1)
            r6.append(r3)
            java.lang.String r20 = r6.toString()
            r18 = 4
            r21 = 0
            r23 = -1
            java.lang.String r19 = "FakeSplitInstallManager"
            java.lang.String r22 = "com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager"
            com.didi.sdk.apm.SystemUtils.log(r18, r19, r20, r21, r22, r23)
            java.util.HashSet r1 = new java.util.HashSet
            java.util.List r3 = r25.getModuleNames()
            r1.<init>(r3)
            boolean r1 = r2.containsAll(r1)
            if (r1 != 0) goto L_0x0202
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -2
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m38220a((java.lang.Exception) r0)
            return r0
        L_0x0202:
            r1 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r1)
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.util.List r6 = r25.getModuleNames()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 1
            r3 = 0
            r1 = r24
            r7 = r0
            r8 = r10
            r1.m38192a(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.f53355h
            com.google.android.play.core.splitinstall.testing.c r2 = new com.google.android.play.core.splitinstall.testing.c
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m38221a(r0)
            return r0
        L_0x022c:
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException     // Catch:{ SplitInstallException -> 0x0238 }
            r1 = -100
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x0238 }
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m38220a((java.lang.Exception) r0)     // Catch:{ SplitInstallException -> 0x0238 }
            return r0
        L_0x0238:
            r0 = move-exception
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m38220a((java.lang.Exception) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f53354g.mo149080b(splitInstallStateUpdatedListener);
    }
}

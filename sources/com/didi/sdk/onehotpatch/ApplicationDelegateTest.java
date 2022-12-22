package com.didi.sdk.onehotpatch;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class ApplicationDelegateTest {
    private static String TAG = "app_delegate_test";
    private static Class sActivityThreadClass;
    private static Object sActivityThreadFieldObject;
    private static Object sActivityThreadMethodObject;
    private static List sAllApplicationsList;
    private static Field sApplicationField;
    private static Method sAttachMethod;
    public static Class sContextImplClass;
    private static Crash sCrash;
    private static boolean sExecute;
    private static Field sInitialApplicationField;
    private static Method sInstallContentProvidersMethod;
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private static Field sOuterContextField;
    private static Object sPackageInfoObject;
    private static List sProvidersList;
    private static Application sTempApp;

    public static void attach(Application application) {
        Logger.log("ApplicationDelegateTest attach " + UtilsHub.getProcessName(application) + " isMainProcess " + UtilsHub.isMainProcess(application), new Object[0]);
        if (application != null) {
            sCrash = new Crash(application);
            if (sMainHandler != null && UtilsHub.isMainProcess(application)) {
                sMainHandler.post(sCrash);
            }
            sExecute = sCrash.reset();
            Logger.log("sExecute: " + sExecute, new Object[0]);
            if (sExecute) {
                sTempApp = new Application();
                if (findFieldAndMethod(application)) {
                    if (sProvidersList != null) {
                        try {
                            boolean add = sProvidersList.add(new ProviderInfo());
                            Logger.log("add provider providers: " + sProvidersList.size(), new Object[0]);
                            if (add) {
                                try {
                                    sProvidersList.remove(sProvidersList.size() - 1);
                                    Logger.log("remove provider providers: " + sProvidersList.size(), new Object[0]);
                                } catch (Throwable th) {
                                    recordCrash(application, "providers remove fail ", th);
                                    throw new RuntimeException("providers remove fail");
                                }
                            }
                        } catch (Throwable th2) {
                            recordCrash(application, "providers add fail ", th2);
                            return;
                        }
                    }
                    try {
                        sAttachMethod.invoke(sTempApp, new Object[]{application.getBaseContext()});
                    } catch (Throwable th3) {
                        recordCrash(application, "attachMethod invoke fail ", th3);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void create(android.app.Application r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ApplicationDelegateTest create "
            r0.append(r1)
            java.lang.String r1 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getProcessName(r11)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r0, r2)
            if (r11 != 0) goto L_0x001e
            return
        L_0x001e:
            boolean r0 = sExecute
            if (r0 != 0) goto L_0x0023
            return
        L_0x0023:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.reflect.Field r2 = sOuterContextField     // Catch:{ all -> 0x0138 }
            android.content.Context r3 = r11.getBaseContext()     // Catch:{ all -> 0x0138 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0138 }
            java.lang.reflect.Field r3 = sApplicationField     // Catch:{ all -> 0x0138 }
            java.lang.Object r4 = sPackageInfoObject     // Catch:{ all -> 0x0138 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0138 }
            java.lang.reflect.Field r4 = sInitialApplicationField     // Catch:{ all -> 0x0138 }
            java.lang.Object r5 = sActivityThreadFieldObject     // Catch:{ all -> 0x0138 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x0138 }
            java.util.List r5 = sAllApplicationsList     // Catch:{ all -> 0x0138 }
            if (r5 == 0) goto L_0x004b
            java.util.List r5 = sAllApplicationsList     // Catch:{ all -> 0x0138 }
            r0.addAll(r5)     // Catch:{ all -> 0x0138 }
        L_0x004b:
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = "before replace"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x0105 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r8, r9)     // Catch:{ all -> 0x0105 }
            java.lang.reflect.Field r8 = sOuterContextField     // Catch:{ all -> 0x0105 }
            android.content.Context r9 = r11.getBaseContext()     // Catch:{ all -> 0x0105 }
            android.app.Application r10 = sTempApp     // Catch:{ all -> 0x0105 }
            r8.set(r9, r10)     // Catch:{ all -> 0x0105 }
            java.lang.reflect.Field r8 = sApplicationField     // Catch:{ all -> 0x0102 }
            java.lang.Object r9 = sPackageInfoObject     // Catch:{ all -> 0x0102 }
            android.app.Application r10 = sTempApp     // Catch:{ all -> 0x0102 }
            r8.set(r9, r10)     // Catch:{ all -> 0x0102 }
            java.lang.reflect.Field r8 = sInitialApplicationField     // Catch:{ all -> 0x00ff }
            java.lang.Object r9 = sActivityThreadFieldObject     // Catch:{ all -> 0x00ff }
            android.app.Application r10 = sTempApp     // Catch:{ all -> 0x00ff }
            r8.set(r9, r10)     // Catch:{ all -> 0x00ff }
            java.util.List r8 = sAllApplicationsList     // Catch:{ all -> 0x00fc }
            if (r8 == 0) goto L_0x0091
            r8 = 0
        L_0x0077:
            java.util.List r9 = sAllApplicationsList     // Catch:{ all -> 0x00fc }
            int r9 = r9.size()     // Catch:{ all -> 0x00fc }
            if (r8 >= r9) goto L_0x0091
            java.util.List r9 = sAllApplicationsList     // Catch:{ all -> 0x00fc }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x00fc }
            if (r9 != r11) goto L_0x008e
            java.util.List r9 = sAllApplicationsList     // Catch:{ all -> 0x00fc }
            android.app.Application r10 = sTempApp     // Catch:{ all -> 0x00fc }
            r9.set(r8, r10)     // Catch:{ all -> 0x00fc }
        L_0x008e:
            int r8 = r8 + 1
            goto L_0x0077
        L_0x0091:
            java.lang.String r8 = "after replace"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x00fc }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r8, r9)     // Catch:{ all -> 0x00fc }
            java.lang.reflect.Field r5 = sOuterContextField     // Catch:{ all -> 0x00ee }
            android.content.Context r8 = r11.getBaseContext()     // Catch:{ all -> 0x00ee }
            r5.set(r8, r2)     // Catch:{ all -> 0x00ee }
            java.lang.reflect.Field r2 = sApplicationField     // Catch:{ all -> 0x00ee }
            java.lang.Object r5 = sPackageInfoObject     // Catch:{ all -> 0x00ee }
            r2.set(r5, r3)     // Catch:{ all -> 0x00ee }
            java.lang.reflect.Field r2 = sInitialApplicationField     // Catch:{ all -> 0x00ee }
            java.lang.Object r3 = sActivityThreadFieldObject     // Catch:{ all -> 0x00ee }
            r2.set(r3, r4)     // Catch:{ all -> 0x00ee }
            java.util.List r2 = sAllApplicationsList     // Catch:{ all -> 0x00ee }
            if (r2 == 0) goto L_0x00bd
            java.util.List r2 = sAllApplicationsList     // Catch:{ all -> 0x00ee }
            r2.clear()     // Catch:{ all -> 0x00ee }
            java.util.List r2 = sAllApplicationsList     // Catch:{ all -> 0x00ee }
            r2.addAll(r0)     // Catch:{ all -> 0x00ee }
        L_0x00bd:
            java.lang.String r0 = "after recover"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x00ee }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r0, r2)     // Catch:{ all -> 0x00ee }
            java.lang.reflect.Method r0 = sInstallContentProvidersMethod     // Catch:{ all -> 0x00e7 }
            java.lang.Object r2 = sActivityThreadMethodObject     // Catch:{ all -> 0x00e7 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e7 }
            r3[r1] = r11     // Catch:{ all -> 0x00e7 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00e7 }
            r4.<init>()     // Catch:{ all -> 0x00e7 }
            r3[r7] = r4     // Catch:{ all -> 0x00e7 }
            r0.invoke(r2, r3)     // Catch:{ all -> 0x00e7 }
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "test succ!!!"
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r1, r0)
            com.didi.sdk.onehotpatch.Crash r0 = sCrash
            java.lang.String r11 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getProcessName(r11)
            r0.recordSuccToFile(r11)
            goto L_0x013e
        L_0x00e7:
            r0 = move-exception
            java.lang.String r1 = "installContentProvidersMethod fail! "
            recordCrash(r11, r1, r0)
            goto L_0x013e
        L_0x00ee:
            r0 = move-exception
            java.lang.String r1 = "recover context fail! "
            recordCrash(r11, r1, r0)
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r0 = "recover context fail!"
            r11.<init>(r0)
            throw r11
        L_0x00fc:
            r0 = move-exception
            r1 = 3
            goto L_0x0106
        L_0x00ff:
            r0 = move-exception
            r1 = 2
            goto L_0x0106
        L_0x0102:
            r0 = move-exception
            r1 = 1
            goto L_0x0106
        L_0x0105:
            r0 = move-exception
        L_0x0106:
            if (r1 == r7) goto L_0x011b
            if (r1 == r6) goto L_0x0114
            if (r1 == r5) goto L_0x010d
            goto L_0x0124
        L_0x010d:
            java.lang.reflect.Field r1 = sInitialApplicationField     // Catch:{ all -> 0x012a }
            java.lang.Object r5 = sActivityThreadFieldObject     // Catch:{ all -> 0x012a }
            r1.set(r5, r4)     // Catch:{ all -> 0x012a }
        L_0x0114:
            java.lang.reflect.Field r1 = sApplicationField     // Catch:{ all -> 0x012a }
            java.lang.Object r4 = sPackageInfoObject     // Catch:{ all -> 0x012a }
            r1.set(r4, r3)     // Catch:{ all -> 0x012a }
        L_0x011b:
            java.lang.reflect.Field r1 = sOuterContextField     // Catch:{ all -> 0x012a }
            android.content.Context r3 = r11.getBaseContext()     // Catch:{ all -> 0x012a }
            r1.set(r3, r2)     // Catch:{ all -> 0x012a }
        L_0x0124:
            java.lang.String r1 = "replace context fail! "
            recordCrash(r11, r1, r0)
            goto L_0x013e
        L_0x012a:
            r0 = move-exception
            java.lang.String r1 = "replace  and recover fail!!! "
            recordCrash(r11, r1, r0)
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r0 = "replace context fail!"
            r11.<init>(r0)
            throw r11
        L_0x0138:
            r0 = move-exception
            java.lang.String r1 = "backup fail "
            recordCrash(r11, r1, r0)
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.ApplicationDelegateTest.create(android.app.Application):void");
    }

    private static boolean findFieldAndMethod(Application application) {
        boolean z;
        try {
            sActivityThreadClass = ReflectUtil.forName("android.app.ActivityThread");
            sContextImplClass = ReflectUtil.forName("android.app.ContextImpl");
            z = true;
        } catch (Throwable th) {
            z = recordCrash(application, "find android.app.ActivityThread class fail ", th);
        }
        if (!z) {
            return false;
        }
        try {
            Field declaredField = ReflectUtil.getDeclaredField(sActivityThreadClass, "mBoundApplication");
            Object invoke = ReflectUtil.getDeclaredMethod(sActivityThreadClass, "currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            sActivityThreadMethodObject = invoke;
            Object obj = declaredField.get(invoke);
            sProvidersList = (List) ReflectUtil.getDeclaredField(obj.getClass(), "providers").get(obj);
            sInstallContentProvidersMethod = ReflectUtil.getDeclaredMethod(sActivityThreadClass, "installContentProviders", Context.class, List.class);
            sAttachMethod = ReflectUtil.getDeclaredMethod(Application.class, "attach", Context.class);
            sOuterContextField = ReflectUtil.getDeclaredField(sContextImplClass, "mOuterContext");
            Object obj2 = ReflectUtil.getDeclaredField(sContextImplClass, "mPackageInfo").get(application.getBaseContext());
            sPackageInfoObject = obj2;
            sApplicationField = ReflectUtil.getDeclaredField(obj2.getClass(), "mApplication");
            Object obj3 = ReflectUtil.getDeclaredField(sPackageInfoObject.getClass(), "mActivityThread").get(sPackageInfoObject);
            sActivityThreadFieldObject = obj3;
            sInitialApplicationField = ReflectUtil.getDeclaredField(obj3.getClass(), "mInitialApplication");
            sAllApplicationsList = (List) ReflectUtil.getDeclaredField(sActivityThreadFieldObject.getClass(), "mAllApplications").get(sActivityThreadFieldObject);
            return true;
        } catch (Throwable th2) {
            recordCrash(application, "find field or method fail!", th2);
            return false;
        }
    }

    public static boolean recordCrash(Context context, String str, Throwable th) {
        sExecute = false;
        try {
            sCrash.recordCrashToFile(UtilsHub.getProcessName(context), str + "\n" + UtilsHub.dumpException(th));
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void printApp(Application application) throws Exception {
        Object obj = ReflectUtil.getDeclaredField(sContextImplClass, "mOuterContext").get(application.getBaseContext());
        Object obj2 = ReflectUtil.getDeclaredField(sContextImplClass, "mPackageInfo").get(application.getBaseContext());
        Object obj3 = ReflectUtil.getDeclaredField(obj2.getClass(), "mApplication").get(obj2);
        Object obj4 = ReflectUtil.getDeclaredField(obj2.getClass(), "mActivityThread").get(obj2);
        Object obj5 = ReflectUtil.getDeclaredField(obj4.getClass(), "mInitialApplication").get(obj4);
        Logger.log("\n mOuterContextObject " + obj.toString() + "\n mPackageInfoObject " + obj2.toString() + "\n mApplicationObject " + obj3.toString() + "\n mInitialApplicationObject: " + obj5.toString() + "\n allApplicationsList: " + ((List) ReflectUtil.getDeclaredField(obj4.getClass(), "mAllApplications").get(obj4)).toString(), new Object[0]);
    }
}

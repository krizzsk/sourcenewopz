package com.didi.foundation.sdk;

import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logtime.DiDiLogLaunchTimer;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class MethodAspect {

    /* renamed from: a */
    private static Logger f21155a = LogService.getLogger("AppLaunchTime");

    /* renamed from: b */
    private static Map<String, String> f21156b = new HashMap();

    /* renamed from: c */
    private static Map<String, String> f21157c = new HashMap();

    /* renamed from: d */
    private static long f21158d;

    @Pointcut("execution(@com.didi.trace.annotations.Trace *.new(..)) || constructorInsideAnnotatedType()")
    public void constructor() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    public void constructorInsideAnnotatedType() {
    }

    @Pointcut("execution(!android.app.Application *(..))")
    public void excludeGetApplicationMethod() {
    }

    @Pointcut("execution(void com.didi.foundation.sdk.application.LaunchApplicationListener.onCreate(android.app.Application))")
    public void launchApplicationOnCreateMethod() {
    }

    @Pointcut("execution(@com.didi.trace.annotations.Trace * *(..)) || methodInsideAnnotatedType()")
    public void method() {
    }

    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass() && excludeGetApplicationMethod()")
    public void methodInsideAnnotatedType() {
    }

    @Pointcut("within(@com.didi.trace.annotations.Trace *)")
    public void withinAnnotatedClass() {
    }

    public static long report(List<Long> list, Map<String, Object> map, Map<String, Object> map2) {
        long j = 0;
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (f21156b.size() > 0) {
            map2.putAll(f21156b);
            m15567a();
        }
        j = f21158d;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                j += list.get(i).longValue();
            }
        }
        Event newEvent = OmegaSDK.newEvent("app_launch_time");
        newEvent.putAttr(DiDiLogLaunchTimer.KEY_TIME_TOTAL, Long.valueOf(j));
        newEvent.putNetType();
        map.put("FoundationApplication", Long.valueOf(f21158d));
        if (f21157c.size() > 0) {
            for (String next : f21157c.keySet()) {
                map.put(next, f21157c.get(next));
            }
        }
        newEvent.putAttr("mainevents", JsonUtil.map2Json(map));
        newEvent.putAttr("subevents", JsonUtil.map2Json(map2));
        OmegaSDKAdapter.trackEvent(newEvent);
        Logger logger = f21155a;
        logger.info(" app_launch_total = " + j + " mainevents = " + JsonUtil.map2Json(map) + " subevents" + JsonUtil.map2Json(map2), new Object[0]);
        m15568a(j);
        return j;
    }

    /* renamed from: a */
    private static void m15568a(long j) {
        Event newEvent = OmegaSDK.newEvent("soda_s_app_application_duration");
        newEvent.putAttr("duration", Long.valueOf(j));
        OmegaSDKAdapter.trackEvent(newEvent);
    }

    /* renamed from: a */
    private static void m15567a() {
        for (String next : f21156b.keySet()) {
            Logger logger = f21155a;
            logger.debug(next + "方法消耗了---->  " + f21156b.get(next) + " ms", new Object[0]);
        }
    }

    @Around("method()")
    public Object methodExecute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String str;
        long nanoTime = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        Signature signature = proceedingJoinPoint.getSignature();
        Class declaringType = signature.getDeclaringType();
        String name = signature.getName();
        if (declaringType.isAnonymousClass()) {
            str = declaringType.getName() + "." + name;
        } else {
            str = declaringType.getSimpleName() + "." + name;
        }
        if (name.equals(NachoLifecycleManager.LIFECYCLE_ON_CREATE)) {
            f21157c.put(str, String.valueOf(millis));
        }
        if (!TextUtils.isEmpty(str) && f21156b.get(str) == null) {
            f21156b.put(str, String.valueOf(millis));
        }
        return proceed;
    }

    @Around("launchApplicationOnCreateMethod()")
    public Object onCreateExecute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long nanoTime = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        f21158d = millis;
        Logger logger = f21155a;
        logger.info("Application onCreate finish time is  " + millis, new Object[0]);
        return proceed;
    }
}

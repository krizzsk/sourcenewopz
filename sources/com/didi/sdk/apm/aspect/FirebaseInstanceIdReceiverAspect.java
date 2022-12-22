package com.didi.sdk.apm.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.model.AsyncReceiverModel;
import com.didi.sdk.apm.service.FirebaseInstanceIdService;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class FirebaseInstanceIdReceiverAspect extends C11885a {
    private static final String TAG = "FirebaseInstanceIdReceiver";
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ FirebaseInstanceIdReceiverAspect ajc$perSingletonInstance;

    static {
        try {
            ajc$perSingletonInstance = new FirebaseInstanceIdReceiverAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static FirebaseInstanceIdReceiverAspect aspectOf() {
        FirebaseInstanceIdReceiverAspect firebaseInstanceIdReceiverAspect = ajc$perSingletonInstance;
        if (firebaseInstanceIdReceiverAspect != null) {
            return firebaseInstanceIdReceiverAspect;
        }
        throw new NoAspectBoundException("com.didi.sdk.apm.aspect.FirebaseInstanceIdReceiverAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    @Pointcut("execution(* com.google.firebase.iid.FirebaseInstanceIdReceiver.onReceive(..))")
    public void interceptOnReceive() {
    }

    @Around("interceptOnReceive()")
    public Object asyncOnReceive(ProceedingJoinPoint proceedingJoinPoint) {
        Context context;
        Log.v(TAG, "before onReceive when firebase instance id!");
        try {
            boolean isFirebaseInstanceIdReceiverByAsyncExecute = SystemUtils.isFirebaseInstanceIdReceiverByAsyncExecute();
            Log.v(TAG, "is Async :" + isFirebaseInstanceIdReceiverByAsyncExecute);
            Object[] args = proceedingJoinPoint.getArgs();
            int i = 0;
            if (args != null) {
                context = null;
                int i2 = 0;
                for (Object obj : args) {
                    if (obj instanceof Intent) {
                        i2 = ((Intent) obj).getIntExtra(AsyncReceiverModel.EXTRA_MARKUP_FLAG, 0);
                    } else if (obj instanceof Context) {
                        context = (Context) obj;
                    }
                }
                i = i2;
            } else {
                context = null;
            }
            if (!isFirebaseInstanceIdReceiverByAsyncExecute || context == null || i == 1) {
                Log.v(TAG, "FirebaseInstanceIdReceiver#onReceive origin executed");
                return proceedingJoinPoint.proceed(args);
            }
            Log.d(TAG, "FirebaseInstanceIdReceiver#onReceive hooked executed");
            FirebaseInstanceIdService.sAsyncReceiverModel = new AsyncReceiverModel(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod(), proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
            FirebaseInstanceIdService.enqueueWork(context, new Intent(FirebaseInstanceIdService.WORK_ACTION));
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

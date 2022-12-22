package com.didi.sdk.apm.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.model.AsyncReceiverModel;
import com.didi.sdk.apm.service.NetworkChangedService;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class NetworkChangedReceiverAspect extends C11885a {
    private static final String TAG = "NetworkChangedReceiverAspect";
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ NetworkChangedReceiverAspect ajc$perSingletonInstance;

    static {
        try {
            ajc$perSingletonInstance = new NetworkChangedReceiverAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static NetworkChangedReceiverAspect aspectOf() {
        NetworkChangedReceiverAspect networkChangedReceiverAspect = ajc$perSingletonInstance;
        if (networkChangedReceiverAspect != null) {
            return networkChangedReceiverAspect;
        }
        throw new NoAspectBoundException("com.didi.sdk.apm.aspect.NetworkChangedReceiverAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    @Pointcut("execution(* com.didi.sdk.connectivity.NetworkChangedReceiver.onReceive(..))")
    public void interceptOnReceiveMethod() {
    }

    @Around("interceptOnReceiveMethod()")
    public Object syncToAsync(ProceedingJoinPoint proceedingJoinPoint) {
        Context context;
        Log.v(TAG, "before onReceive when network changed!");
        try {
            boolean isNetworkChangedByAsyncExecute = SystemUtils.isNetworkChangedByAsyncExecute();
            Log.v(TAG, "is Async :" + isNetworkChangedByAsyncExecute);
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
            if (!isNetworkChangedByAsyncExecute || context == null || i == 1) {
                Log.v(TAG, "NetworkChangedReceiver#onReceive origin executed");
                return proceedingJoinPoint.proceed(args);
            }
            Log.v(TAG, "NetworkChangedReceiver#onReceive hooked executed");
            NetworkChangedService.sAsyncReceiverModel = new AsyncReceiverModel(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod(), proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
            NetworkChangedService.enqueueWork(context, new Intent(NetworkChangedService.WORK_ACTION));
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

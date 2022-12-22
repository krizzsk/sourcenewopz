package com.didi.sdk.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.aspect.NetworkChangedReceiverAspect;
import com.didi.sdk.apm.model.AsyncReceiverModel;
import com.didi.sdk.apm.service.NetworkChangedService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

public class NetworkChangedReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static /* synthetic */ JoinPoint.StaticPart f35753a;

    static {
        m25318a();
    }

    /* renamed from: a */
    private static /* synthetic */ void m25318a() {
        Factory factory = new Factory("NetworkChangedReceiver.java", NetworkChangedReceiver.class);
        f35753a = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("1", "onReceive", "com.didi.sdk.connectivity.NetworkChangedReceiver", "android.content.Context:android.content.Intent", "context:intent", "", "void"), 16);
    }

    public void onReceive(Context context, Intent intent) {
        JoinPoint makeJP = Factory.makeJP(f35753a, this, this, context, intent);
        m25317a(this, context, intent, makeJP, NetworkChangedReceiverAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* renamed from: a */
    private static final /* synthetic */ void m25319a(NetworkChangedReceiver networkChangedReceiver, Context context, Intent intent, JoinPoint joinPoint) {
        try {
            if (C12170f.m25339d(context)) {
                NetworkChangeHandler.m25306a().mo91470b(context);
            } else {
                NetworkChangeHandler.m25306a().mo91472c(context);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static final /* synthetic */ Object m25317a(NetworkChangedReceiver networkChangedReceiver, Context context, Intent intent, JoinPoint joinPoint, NetworkChangedReceiverAspect networkChangedReceiverAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Context context2;
        int i;
        SystemUtils.log(2, "NetworkChangedReceiverAspect", "before onReceive when network changed!", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 36);
        try {
            boolean isNetworkChangedByAsyncExecute = SystemUtils.isNetworkChangedByAsyncExecute();
            SystemUtils.log(2, "NetworkChangedReceiverAspect", "is Async :" + isNetworkChangedByAsyncExecute, (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 42);
            Object[] args = proceedingJoinPoint.getArgs();
            if (args != null) {
                context2 = null;
                i = 0;
                for (Object obj : args) {
                    if (obj instanceof Intent) {
                        i = ((Intent) obj).getIntExtra(AsyncReceiverModel.EXTRA_MARKUP_FLAG, 0);
                    } else if (obj instanceof Context) {
                        context2 = (Context) obj;
                    }
                }
            } else {
                context2 = null;
                i = 0;
            }
            if (!isNetworkChangedByAsyncExecute || context2 == null || i == 1) {
                SystemUtils.log(2, "NetworkChangedReceiverAspect", "NetworkChangedReceiver#onReceive origin executed", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 74);
                m25319a(networkChangedReceiver, (Context) args[0], (Intent) args[1], proceedingJoinPoint);
            } else {
                SystemUtils.log(2, "NetworkChangedReceiverAspect", "NetworkChangedReceiver#onReceive hooked executed", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 63);
                NetworkChangedService.sAsyncReceiverModel = new AsyncReceiverModel(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod(), proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
                NetworkChangedService.enqueueWork(context2, new Intent(NetworkChangedService.WORK_ACTION));
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}

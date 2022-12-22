package com.didi.sdk.onehotpatch.loader.crash;

import android.content.Context;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static final List<CrashInterceptor> sInterceptors;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mPreHandler = Thread.getDefaultUncaughtExceptionHandler();

    static {
        ArrayList arrayList = new ArrayList();
        sInterceptors = arrayList;
        arrayList.add(new PreVerifiedInterceptor());
        sInterceptors.add(new ClassCastInterceptor());
        sInterceptors.add(new ClassNotFoundInterceptor());
        sInterceptors.add(new NotDefInterceptor());
    }

    private CrashHandler(Context context) {
        this.mContext = context;
    }

    public static void init(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(context));
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (this.mContext != null && message != null) {
                Iterator<CrashInterceptor> it = sInterceptors.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().intercept(th)) {
                            handleException(th);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mPreHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void handleException(Throwable th) {
        try {
            PatchModule loadPatch = PatchManager.getLoadPatch(this.mContext, true);
            if (loadPatch != null) {
                PatchManager.setEnabledFlag(this.mContext, loadPatch, -100);
                HotPatchEvent.trackCrash(this.mContext, loadPatch, th);
            }
        } catch (Exception e) {
            Logger.warn(e);
        }
    }
}

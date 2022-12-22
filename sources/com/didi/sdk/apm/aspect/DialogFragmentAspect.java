package com.didi.sdk.apm.aspect;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.didi.sdk.apm.utils.EventReporter;
import com.didi.sdk.apm.utils.Maps;
import java.util.HashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class DialogFragmentAspect extends C11885a {
    private static final String DIALOGFRAGMENT_HOOK_ONACTIVITYCREATED = "dialogfragment_hook_onactivitycreated";
    private static final String TAG = "DialogFragmentAspect";
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ DialogFragmentAspect ajc$perSingletonInstance;

    static {
        try {
            ajc$perSingletonInstance = new DialogFragmentAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static DialogFragmentAspect aspectOf() {
        DialogFragmentAspect dialogFragmentAspect = ajc$perSingletonInstance;
        if (dialogFragmentAspect != null) {
            return dialogFragmentAspect;
        }
        throw new NoAspectBoundException("com.didi.sdk.apm.aspect.DialogFragmentAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    @Pointcut("execution(* android.support.v4.app.DialogFragment.onActivityCreated(android.os.Bundle))")
    public void removeChildViewByParent() {
    }

    @Before("removeChildViewByParent()")
    public void beforeOnActivityCreated(JoinPoint joinPoint) {
        View view;
        Object target = joinPoint.getTarget();
        try {
            if (!(!(target instanceof DialogFragment) || (view = ((DialogFragment) target).getView()) == null || view.getParent() == null)) {
                ((ViewGroup) view.getParent()).removeView(view);
                SourceLocation sourceLocation = joinPoint.getStaticPart().getSourceLocation();
                String displaySourceLocation = getDisplaySourceLocation(sourceLocation);
                String str = "Found DialogFragment#onActivityCreated IllegalStateException at " + displaySourceLocation + ",DialogFragment#getView() have parent,must be remove this view before call onActivityCreated to avoid 'DialogFragment can not be attached to a container view' Exception";
                Log.i(TAG, str);
                HashMap newHashMap = Maps.newHashMap();
                newHashMap.put("loc", getDisplaySourceLocation(sourceLocation));
                EventReporter.trackError(DIALOGFRAGMENT_HOOK_ONACTIVITYCREATED, displaySourceLocation, str, newHashMap);
            }
        } catch (Exception unused) {
        }
        Log.i(TAG, "Hook success!");
    }
}

package com.didi.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SchemeDispatcher extends Activity {

    /* renamed from: b */
    private static Logger f35211b = LoggerFactory.getLogger("SchemeDispatcher");

    /* renamed from: a */
    private Set<AbsSchemeDispatcherFilter> f35212a = new HashSet();
    protected boolean hasHand = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        Logger logger = f35211b;
        logger.debug("SchemeDispatcher onCreate.. mainIntentSet.size = " + this.f35212a.size(), new Object[0]);
        if (this.f35212a.isEmpty()) {
            Iterator<S> it = ServiceLoader.load(AbsSchemeDispatcherFilter.class).iterator();
            while (it.hasNext()) {
                AbsSchemeDispatcherFilter absSchemeDispatcherFilter = (AbsSchemeDispatcherFilter) it.next();
                this.f35212a.add(absSchemeDispatcherFilter);
                if (absSchemeDispatcherFilter.doFilter(intent, this)) {
                    Logger logger2 = f35211b;
                    logger2.debug("SchemeDispatcher onCreate.. AbsSchemeDispatcherFilter = " + absSchemeDispatcherFilter, new Object[0]);
                }
            }
            return;
        }
        for (AbsSchemeDispatcherFilter next : this.f35212a) {
            if (next.doFilter(intent, this)) {
                this.hasHand = true;
                Logger logger3 = f35211b;
                logger3.debug("SchemeDispatcher onCreate.. AbsSchemeDispatcherFilter = " + next, new Object[0]);
                return;
            }
        }
    }
}

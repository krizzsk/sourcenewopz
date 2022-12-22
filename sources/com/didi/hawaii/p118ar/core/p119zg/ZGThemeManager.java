package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGThemeManager */
public class ZGThemeManager {

    /* renamed from: a */
    private Context f23188a;

    /* renamed from: b */
    private int f23189b;

    /* renamed from: com.didi.hawaii.ar.core.zg.ZGThemeManager$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ZGThemeManager INSTANCE = new ZGThemeManager();

        private SingletonHolder() {
        }
    }

    private ZGThemeManager() {
        this.f23188a = null;
        this.f23189b = 0;
    }

    public static final ZGThemeManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context, int i) {
        this.f23188a = context;
        this.f23189b = i;
    }

    public String getThemeString(int i) {
        Context context = this.f23188a;
        if (context == null) {
            return "";
        }
        if (this.f23189b == 1 && i == R.string.reach_end) {
            return context.getString(R.string.reach_end_bus);
        }
        return this.f23188a.getString(i);
    }

    public int fromResource(int i) {
        return (this.f23189b == 1 && i == R.drawable.direction_start) ? R.drawable.direction_start_bus : i;
    }

    public void reset() {
        this.f23188a = null;
        this.f23189b = 0;
    }
}

package butterknife.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class DebouncingOnClickListener implements View.OnClickListener {
    /* access modifiers changed from: package-private */

    /* renamed from: a */
    public static boolean f441a = true;

    /* renamed from: b */
    private static final Runnable f442b = $$Lambda$DebouncingOnClickListener$fKu_GIo_pW_YXcz3KkfF3UXipRU.INSTANCE;

    /* renamed from: c */
    private static final Handler f443c = new Handler(Looper.getMainLooper());

    public abstract void doClick(View view);

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (f441a) {
            f441a = false;
            f443c.post(f442b);
            doClick(view);
        }
    }
}

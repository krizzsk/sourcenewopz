package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public interface zzcfl extends View.OnClickListener, View.OnTouchListener {
    void zza(String str, View view, boolean z);

    View zzakl();

    FrameLayout zzapo();

    zzqs zzapp();

    Map<String, WeakReference<View>> zzapq();

    Map<String, WeakReference<View>> zzapr();

    Map<String, WeakReference<View>> zzaps();

    String zzapt();

    IObjectWrapper zzapu();

    View zzgd(String str);

    JSONObject zztq();
}

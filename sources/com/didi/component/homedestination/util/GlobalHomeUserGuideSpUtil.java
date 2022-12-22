package com.didi.component.homedestination.util;

import android.content.Context;
import com.didi.sdk.util.SPUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/homedestination/util/GlobalHomeUserGuideSpUtil;", "", "()V", "isShowDestinationGuide", "", "context", "Landroid/content/Context;", "isShowStartingPointGuide", "setShowDestinationGuide", "", "show", "setShowStartingPointGuide", "comp-homedestination_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalHomeUserGuideSpUtil.kt */
public final class GlobalHomeUserGuideSpUtil {
    public static final GlobalHomeUserGuideSpUtil INSTANCE = new GlobalHomeUserGuideSpUtil();

    private GlobalHomeUserGuideSpUtil() {
    }

    public final boolean isShowStartingPointGuide(Context context) {
        Object obj = SPUtils.get(context, "sp_show_starting_point_guide", false);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final boolean isShowDestinationGuide(Context context) {
        Object obj = SPUtils.get(context, "sp_show_destination_guide", false);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void setShowStartingPointGuide(Context context, boolean z) {
        SPUtils.put(context, "sp_show_starting_point_guide", Boolean.valueOf(z));
    }

    public final void setShowDestinationGuide(Context context, boolean z) {
        SPUtils.put(context, "sp_show_destination_guide", Boolean.valueOf(z));
    }
}

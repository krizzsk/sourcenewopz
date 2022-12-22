package com.didi.common.map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.didi.common.map.internal.IMapAvailabilityDelegate;

public class MapAvailability {
    public static int isAvailable(Context context, MapVendor mapVendor) {
        IMapAvailabilityDelegate create = MapApiDelegateFactory.create(mapVendor);
        if (create != null) {
            return create.isAvailable(context);
        }
        return 0;
    }

    public static Dialog getErrorDialog(MapVendor mapVendor, Activity activity, int i, int i2) {
        IMapAvailabilityDelegate create = MapApiDelegateFactory.create(mapVendor);
        if (create != null) {
            return create.getErrorDialog(activity, i, i2);
        }
        return null;
    }

    public static Dialog getErrorDialog(MapVendor mapVendor, Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        IMapAvailabilityDelegate create = MapApiDelegateFactory.create(mapVendor);
        if (create != null) {
            return create.getErrorDialog(activity, i, i2, onCancelListener);
        }
        return null;
    }
}

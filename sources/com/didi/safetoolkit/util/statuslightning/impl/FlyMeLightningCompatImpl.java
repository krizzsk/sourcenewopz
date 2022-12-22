package com.didi.safetoolkit.util.statuslightning.impl;

import android.app.Activity;
import android.view.WindowManager;
import com.didi.safetoolkit.util.statuslightning.ILightningCompat;
import java.lang.reflect.Field;

public class FlyMeLightningCompatImpl implements ILightningCompat {
    public void setLightStatusBar(Activity activity, boolean z) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt((Object) null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
            declaredField.setAccessible(false);
            declaredField2.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

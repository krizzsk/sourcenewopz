package com.didi.dimina.container.bridge.loadsubpackage;

import android.content.Context;
import android.view.View;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.p106ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.p106ui.subpackage.DMSubPackageLoadingView;
import com.taxis99.R;

public class CustomSubpackageLoadingManager extends AbsLoadingManager {
    /* access modifiers changed from: protected */
    public int getDialogStyle() {
        return R.style.DiminaDialogTransparentBg;
    }

    public CustomSubpackageLoadingManager(Context context, DMMina dMMina) {
        super(context, dMMina);
    }

    /* access modifiers changed from: protected */
    public View getLoadingView() {
        try {
            Class<? extends DMSubPackageLoadingView> subPackageLoadingViewClazz = this.mDMMina.getConfig().getUIConfig().getSubPackageLoadingViewClazz();
            Class[] clsArr = {Context.class};
            return (DMSubPackageLoadingView) subPackageLoadingViewClazz.getConstructor(clsArr).newInstance(new Object[]{this.mContext});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

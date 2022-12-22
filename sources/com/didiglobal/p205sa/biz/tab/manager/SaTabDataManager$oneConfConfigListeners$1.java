package com.didiglobal.p205sa.biz.tab.manager;

import android.text.TextUtils;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"com/didiglobal/sa/biz/tab/manager/SaTabDataManager$oneConfConfigListeners$1", "Lcom/didi/sdk/oneconf/OneConfStore$OneConfConfigChangeListener;", "cityId", "", "onChanged", "", "oneConfData", "Lcom/didi/sdk/oneconf/OneConfData;", "lat", "", "lng", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabDataManager$oneConfConfigListeners$1 */
/* compiled from: SaTabDataManager.kt */
public final class SaTabDataManager$oneConfConfigListeners$1 implements OneConfStore.OneConfConfigChangeListener {
    private String cityId = "";

    SaTabDataManager$oneConfConfigListeners$1() {
    }

    public void onChanged(OneConfData oneConfData, double d, double d2) {
        String num;
        String str = "";
        if (!(oneConfData == null || (num = Integer.valueOf(oneConfData.cityId).toString()) == null)) {
            str = num;
        }
        if (!TextUtils.equals(this.cityId, str)) {
            SaTabDataManager.INSTANCE.m36697b(SaTabDataManager.f51229c);
            this.cityId = str;
        }
    }
}

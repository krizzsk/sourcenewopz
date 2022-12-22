package com.didi.soda.business;

import android.net.Uri;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/GroceryHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GroceryHelper.kt */
public final class GroceryHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/GroceryHelper$Companion;", "", "()V", "getBusinessType", "", "url", "", "isGrocery", "", "businessType", "(Ljava/lang/Integer;)Z", "openGrocery", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GroceryHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isGrocery(Integer num) {
            return num != null && num.intValue() == 3;
        }

        public final void openGrocery(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                LogUtil.m29104i("BusinessOpen", "打开商超页面，但是url为null");
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_OPEN_GROCERY_ERROR).addModuleName("shop").addErrorMsg("open grocery but url is empty!!!").addErrorType("-1").build().trackError();
                return;
            }
            SchemeHelper.dispatchMsg(Uri.parse(str), "webPage", "", false);
        }

        public final int getBusinessType(String str) {
            try {
                String queryParameter = Uri.parse(Uri.decode(Uri.parse(str).getQueryParameter("url"))).getQueryParameter(ParamKeys.PARAM_FLIER_BUSINESSTYPE);
                if (queryParameter == null) {
                    return 1;
                }
                return Integer.parseInt(queryParameter);
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }
    }
}

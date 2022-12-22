package com.didi.component.framework.pages.promo.presenter;

import android.content.Context;
import android.content.Intent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.promo.helper.PromoCodeInterceptor;
import com.didi.component.framework.pages.promo.model.WaiMaiVo;
import com.didi.component.framework.pages.promo.view.IPromoShowView;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J)\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/presenter/PromoShowPresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/promo/view/IPromoShowView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "applyPromoCode", "", "promoCode", "", "generateUrlForWaiMai", "waiMaiVo", "Lcom/didi/component/framework/pages/promo/model/WaiMaiVo;", "goToTargetWeb", "url", "isWaiMaiPromo", "", "traceEvent", "event", "errorNo", "", "errorMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShowPresenter.kt */
public final class PromoShowPresenter extends IPresenter<IPromoShowView> {

    /* renamed from: a */
    private final Context f13952a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoShowPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13952a = context;
    }

    public final Context getContext() {
        return this.f13952a;
    }

    public final void applyPromoCode(String str) {
        Intrinsics.checkNotNullParameter(str, PromoCodeInterceptor.PROMO_CODE);
        IPromoShowView iPromoShowView = (IPromoShowView) this.mView;
        if (iPromoShowView != null) {
            iPromoShowView.showLoadingView();
        }
        CarRequest.getPromoCodeRsp(this.f13952a, new PromoShowPresenter$applyPromoCode$1(this), str);
    }

    public final void goToTargetWeb(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intent intent = new Intent(this.f13952a, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        intent.addFlags(268435456);
        this.f13952a.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m9675a(WaiMaiVo waiMaiVo) {
        if (waiMaiVo == null) {
            return false;
        }
        CharSequence domain = waiMaiVo.getDomain();
        if (domain == null || domain.length() == 0) {
            return false;
        }
        CharSequence path = waiMaiVo.getPath();
        return !(path == null || path.length() == 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String m9676b(WaiMaiVo waiMaiVo) {
        String currentLang = LocaleCodeHolder.getInstance().getCurrentLang();
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        String str = null;
        sb.append(waiMaiVo == null ? null : waiMaiVo.getDomain());
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(currentLang);
        if (waiMaiVo != null) {
            str = waiMaiVo.getPath();
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m9674a(String str, Integer num, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errorNumber", num);
        hashMap.put(ParamConst.PARAM_ERROR_MESSAGE, str2);
        hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }
}

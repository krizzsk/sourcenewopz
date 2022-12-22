package com.didi.soda.customer.biz.popdialog.natived;

import android.view.ViewGroup;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.popdialog.natived.presenter.CouponPopDialogPresenter;
import com.didi.soda.customer.biz.popdialog.natived.presenter.ImagePopDialogPresenter;
import com.didi.soda.customer.biz.popdialog.natived.presenter.LoginPopDialogPresenter;
import com.didi.soda.customer.biz.popdialog.natived.presenter.PromoCodePopDialogPresenter;
import com.didi.soda.customer.biz.popdialog.natived.presenter.SharePopDialogPresenter;
import com.didi.soda.customer.biz.popdialog.natived.view.CouponPopDialogView;
import com.didi.soda.customer.biz.popdialog.natived.view.ImagePopDialogView;
import com.didi.soda.customer.biz.popdialog.natived.view.LoginPopDialogView;
import com.didi.soda.customer.biz.popdialog.natived.view.PromoCodePopDialogView;
import com.didi.soda.customer.biz.popdialog.natived.view.SharePopDialogView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;

public class PopDialogFactory {

    /* renamed from: a */
    private static final String f40486a = "PopDialogFactory";

    /* renamed from: com.didi.soda.customer.biz.popdialog.natived.PopDialogFactory$1 */
    static /* synthetic */ class C136401 {

        /* renamed from: $SwitchMap$com$didi$soda$customer$biz$popdialog$natived$PopupType */
        static final /* synthetic */ int[] f40487x848d0741;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.soda.customer.biz.popdialog.natived.PopupType[] r0 = com.didi.soda.customer.biz.popdialog.natived.PopupType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40487x848d0741 = r0
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.SEND_COUPON_POP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40487x848d0741     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.HAVED_COUPON_POP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40487x848d0741     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.PROMO_CODE_POP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40487x848d0741     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.IMAGE_POP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f40487x848d0741     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.NOT_LOGIN_POP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f40487x848d0741     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.soda.customer.biz.popdialog.natived.PopupType r1 = com.didi.soda.customer.biz.popdialog.natived.PopupType.SHARE_COUPON_POP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.popdialog.natived.PopDialogFactory.C136401.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Contract.AbsPopDialogView mo102134a(int i) {
        Contract.AbsPopDialogView absPopDialogView;
        switch (C136401.f40487x848d0741[PopupType.getByValue(i).ordinal()]) {
            case 1:
            case 2:
                absPopDialogView = new CouponPopDialogView();
                break;
            case 3:
                absPopDialogView = new PromoCodePopDialogView();
                break;
            case 4:
                absPopDialogView = new ImagePopDialogView();
                break;
            case 5:
                absPopDialogView = new LoginPopDialogView();
                break;
            case 6:
                absPopDialogView = new SharePopDialogView();
                break;
            default:
                absPopDialogView = null;
                break;
        }
        LogUtil.m29104i(f40486a, "creatPopView= " + absPopDialogView.getClass());
        return absPopDialogView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Contract.AbsPopDialogPresenter mo102133a(NAPopDialogEntity nAPopDialogEntity) {
        Contract.AbsPopDialogPresenter absPopDialogPresenter;
        switch (C136401.f40487x848d0741[PopupType.getByValue(nAPopDialogEntity.popupType).ordinal()]) {
            case 1:
            case 2:
                absPopDialogPresenter = new CouponPopDialogPresenter(nAPopDialogEntity);
                break;
            case 3:
                absPopDialogPresenter = new PromoCodePopDialogPresenter(nAPopDialogEntity);
                break;
            case 4:
                absPopDialogPresenter = new ImagePopDialogPresenter(nAPopDialogEntity);
                break;
            case 5:
                absPopDialogPresenter = new LoginPopDialogPresenter(nAPopDialogEntity);
                break;
            case 6:
                absPopDialogPresenter = new SharePopDialogPresenter(nAPopDialogEntity);
                break;
            default:
                absPopDialogPresenter = null;
                break;
        }
        LogUtil.m29104i(f40486a, "creatPopPresenter= " + absPopDialogPresenter.getClass());
        return absPopDialogPresenter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PopDialogComponent mo102135a(ViewGroup viewGroup, NAPopDialogEntity nAPopDialogEntity) {
        return new PopDialogComponent(viewGroup, nAPopDialogEntity);
    }
}

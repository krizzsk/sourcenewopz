package com.didi.beatles.p099im.access.style.custom;

import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMLocationCusView;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMSysOrderCusView;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMTextRenderCusView;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomViewHelper */
public class IMCustomViewHelper {

    /* renamed from: com.didi.beatles.im.access.style.custom.IMCustomViewHelper$Creator */
    private interface Creator<T extends IMCustomView> {
        T create(IMCustomViewBuilder iMCustomViewBuilder);
    }

    /* renamed from: a */
    private static <T extends IMCustomView> T m5917a(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext, Creator<T> creator) {
        IMCustomViewBuilder customViewBuilder;
        T create = (iMBusinessConfig == null || iMBusinessConfig.getCustomBuilder() == null) ? null : creator.create(iMBusinessConfig.getCustomBuilder());
        if (create == null && (customViewBuilder = IMContextInfoHelper.getCustomViewBuilder()) != null) {
            create = creator.create(customViewBuilder);
        }
        if (create != null) {
            create.bindIMContext(iMCustomContext);
        }
        return create;
    }

    public static IMTextRenderCusView createTextRender(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return (IMTextRenderCusView) m5917a(iMBusinessConfig, iMCustomContext, new Creator<IMTextRenderCusView>() {
            public IMTextRenderCusView create(IMCustomViewBuilder iMCustomViewBuilder) {
                return iMCustomViewBuilder.createTextRender();
            }
        });
    }

    public static IMSysOrderCusView createSysOrder(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return (IMSysOrderCusView) m5917a(iMBusinessConfig, iMCustomContext, new Creator<IMSysOrderCusView>() {
            public IMSysOrderCusView create(IMCustomViewBuilder iMCustomViewBuilder) {
                return iMCustomViewBuilder.createSysOrder();
            }
        });
    }

    public static IMLocationCusView createLocation(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return (IMLocationCusView) m5917a(iMBusinessConfig, iMCustomContext, new Creator<IMLocationCusView>() {
            public IMLocationCusView create(IMCustomViewBuilder iMCustomViewBuilder) {
                return iMCustomViewBuilder.createLocation();
            }
        });
    }

    public static IMTopOperationCusView createTopOperationView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return (IMTopOperationCusView) m5917a(iMBusinessConfig, iMCustomContext, new Creator<IMTopOperationCusView>() {
            public IMTopOperationCusView create(IMCustomViewBuilder iMCustomViewBuilder) {
                return iMCustomViewBuilder.createTopOperationView();
            }
        });
    }
}

package com.didichuxing.login;

import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class MsLoginFacade {

    /* renamed from: a */
    private static final String f47734a = MsLoginFacade.class.getSimpleName();

    public static final void init() {
        Iterator<S> it = ServiceLoader.load(IThirdPartFactory.class).iterator();
        while (it.hasNext()) {
            AbsThirdPartyLoginBase factory = ((IThirdPartFactory) it.next()).factory();
            if (factory != null) {
                ThirdPartyLoginManager.addThirdPartyLogin(factory);
            }
        }
    }

    public static final void init(List<String> list) {
        if (list != null && list.size() != 0) {
            String str = f47734a;
            LogUtil.m26099i(str, "init:list = " + list);
            Iterator<S> it = ServiceLoader.load(IThirdPartFactory.class).iterator();
            while (it.hasNext()) {
                IThirdPartFactory iThirdPartFactory = (IThirdPartFactory) it.next();
                AbsThirdPartyLoginBase factory = iThirdPartFactory.factory();
                if (factory != null && list.contains(iThirdPartFactory.getThirdParty())) {
                    String str2 = f47734a;
                    LogUtil.m26099i(str2, "init:thirdParty = " + iThirdPartFactory.getThirdParty());
                    ThirdPartyLoginManager.addThirdPartyLogin(factory);
                }
            }
        }
    }

    public static final void initWithSequence(List<String> list) {
        if (list != null && list.size() != 0) {
            String str = f47734a;
            LogUtil.m26099i(str, "init:list = " + list);
            ServiceLoader<S> load = ServiceLoader.load(IThirdPartFactory.class);
            HashMap hashMap = new HashMap();
            Iterator<S> it = load.iterator();
            while (it.hasNext()) {
                IThirdPartFactory iThirdPartFactory = (IThirdPartFactory) it.next();
                AbsThirdPartyLoginBase factory = iThirdPartFactory.factory();
                if (factory != null && list.contains(iThirdPartFactory.getThirdParty())) {
                    String str2 = f47734a;
                    LogUtil.m26099i(str2, "init:thirdParty = " + iThirdPartFactory.getThirdParty());
                    hashMap.put(iThirdPartFactory.getThirdParty(), factory);
                }
            }
            for (String next : list) {
                if (hashMap.get(next) != null) {
                    ThirdPartyLoginManager.addThirdPartyLogin((AbsThirdPartyLoginBase) hashMap.get(next));
                }
            }
        }
    }
}

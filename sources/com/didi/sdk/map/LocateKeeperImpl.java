package com.didi.sdk.map;

import com.didi.sdk.log.Logger;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class LocateKeeperImpl extends AbstractDelegateManager<LocateKeeper> implements LocateKeeper {
    /* access modifiers changed from: private */
    public ArrayList<LocateKeeper> mKeeperList = new ArrayList<>();

    public static LocateKeeperImpl getInstance() {
        return (LocateKeeperImpl) SingletonHolder.getInstance(LocateKeeperImpl.class);
    }

    private LocateKeeperImpl() {
        loadDelegates(LocateKeeper.class, new AbstractDelegateManager.DelegateListener<LocateKeeper>() {
            public void onDelegate(String str, LocateKeeper locateKeeper) {
                Logger.easylog("LocateKeeper", "onDelegate: " + str + "|" + locateKeeper);
                LocateKeeperImpl.this.mKeeperList.add(locateKeeper);
            }
        });
    }

    public boolean keepLocate() {
        Iterator<LocateKeeper> it = this.mKeeperList.iterator();
        while (it.hasNext()) {
            LocateKeeper next = it.next();
            if (next.keepLocate()) {
                Logger.easylog("LocateKeeper", "keepLocate return true: " + next);
                return true;
            }
        }
        Logger.easylog("LocateKeeper", "keepLocate return false");
        return false;
    }
}

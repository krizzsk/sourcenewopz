package com.didi.sdk.component.express;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;

public class ExpressShareStore extends BaseStore {
    public static final String ACTION_FROM_ADDRESS_CHANGED = "com.sdu.didi.psnger.action.FROM_ADDRESS_CHANGED";

    /* renamed from: a */
    private static final String f35651a = "exshare-debug";

    /* renamed from: b */
    private Logger f35652b = LoggerFactory.getLogger("ExpressShareStore");

    /* renamed from: c */
    private Address f35653c;

    /* renamed from: d */
    private Address f35654d;

    /* renamed from: e */
    private long f35655e;

    /* renamed from: f */
    private long f35656f;

    private ExpressShareStore() {
        super("framework-ExpressShareStore");
    }

    public static ExpressShareStore getInstance() {
        return (ExpressShareStore) SingletonHolder.getInstance(ExpressShareStore.class);
    }

    public synchronized Address getFromAddress() {
        return this.f35653c;
    }

    public synchronized long getLastFromTime() {
        return this.f35656f;
    }

    public synchronized void setFromAddress(Address address) {
        this.f35652b.infoEvent(f35651a, f35651a, "setFromAddress");
        this.f35653c = address;
        if (address != null) {
            Logger logger = this.f35652b;
            logger.infoEvent(f35651a, f35651a, "setFromAddress name = " + address.getDisplayName() + " cityId = " + address.getCityId());
        }
        this.f35656f = System.currentTimeMillis();
    }

    public synchronized Address getToAddress() {
        return this.f35654d;
    }

    public void setToAddress(Address address) {
        this.f35654d = address;
        if (address != null) {
            this.f35652b.infoEvent(f35651a, f35651a, address.toString());
        }
    }

    public synchronized long getDepartureTime() {
        return this.f35655e;
    }

    public synchronized void setDepartureTime(long j) {
        Logger logger = this.f35652b;
        logger.infoEvent(f35651a, f35651a, "ExpressShareStore setDepartureTime  mDepartureTime = " + j);
        this.f35655e = j;
    }

    public void notifyFromAddressChanged(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(ACTION_FROM_ADDRESS_CHANGED));
    }
}

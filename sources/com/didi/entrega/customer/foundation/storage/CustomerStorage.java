package com.didi.entrega.customer.foundation.storage;

import android.os.Parcelable;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.foundation.sdk.storage.Storage;

public class CustomerStorage<T extends Parcelable> extends Storage<T> {
    public CustomerStorage() {
        super(GlobalContext.getContext());
    }
}

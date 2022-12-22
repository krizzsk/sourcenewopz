package com.didi.soda.customer.foundation.storage;

import android.os.Parcelable;
import com.didi.foundation.sdk.storage.Storage;
import com.didi.soda.customer.app.GlobalContext;

public class CustomerStorage<T extends Parcelable> extends Storage<T> {
    public CustomerStorage() {
        super(GlobalContext.getContext());
    }
}

package com.didi.entrega.customer.foundation.locale;

import android.content.Context;
import com.didi.foundation.sdk.storage.Storage;

public class LocaleStorage extends Storage<LocaleStorageConfig> {
    public LocaleStorage(Context context) {
        super(context);
    }

    public LocaleStorageConfig getData() {
        LocaleStorageConfig localeStorageConfig = (LocaleStorageConfig) super.getData();
        return localeStorageConfig == null ? new LocaleStorageConfig() : localeStorageConfig;
    }
}

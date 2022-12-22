package com.didi.soda.customer.foundation.storage;

import com.didi.soda.home.policy.model.LocationSettingEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/storage/LocationSettingStorage;", "Lcom/didi/soda/customer/foundation/storage/CustomerStorage;", "Lcom/didi/soda/home/policy/model/LocationSettingEntity;", "()V", "getData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LocationSettingStorage.kt */
public final class LocationSettingStorage extends CustomerStorage<LocationSettingEntity> {
    public LocationSettingEntity getData() {
        LocationSettingEntity locationSettingEntity = (LocationSettingEntity) super.getData();
        return locationSettingEntity == null ? new LocationSettingEntity() : locationSettingEntity;
    }
}

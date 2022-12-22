package com.didi.soda.address.manager;

import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.storage.CustomerStorage;

public class AddressStorage extends CustomerStorage<AddressEntity> {
    public AddressEntity getData() {
        AddressEntity addressEntity = (AddressEntity) super.getData();
        return addressEntity == null ? new AddressEntity() : addressEntity;
    }

    public boolean hasData() {
        return AddressUtil.checkAddressValid((AddressEntity) super.getData());
    }
}

package com.android.didi.bfflib.task;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.concurrent.BffAbilityMapModel;
import com.android.didi.bfflib.concurrent.BffConcurrentFormStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BffAnonymousProxyImpl extends BffBaseProxyImpl {
    protected BffAnonymousProxyImpl(Context context, Bff.BffConfig bffConfig) {
        super(context, bffConfig);
    }

    public boolean canAddAbilityInThisTask(IBffProxy.Ability ability) {
        if (!TextUtils.isEmpty(ability.getServiceId())) {
            return false;
        }
        Map<String, List<String>> mappingTable = this.mBffConfig.getMappingTable();
        BffAbilityMapModel abilityMapModel = BffConcurrentFormStore.getInstance().getAbilityMapModel();
        if (!(abilityMapModel == null || abilityMapModel.errno != 0 || abilityMapModel.data == null)) {
            mappingTable = abilityMapModel.data;
        }
        if (mappingTable.size() > 0) {
            for (Map.Entry<String, List<String>> value : mappingTable.entrySet()) {
                Iterator it = ((List) value.getValue()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        if (!TextUtils.isEmpty(str) && str.equals(ability.getId())) {
                            return false;
                        }
                    }
                }
            }
        }
        if (this.mStatus == 1 || this.mStatus == 2) {
            return false;
        }
        for (IBffProxy.Ability ability2 : this.mAbilityList) {
            if (ability2 == ability || (!TextUtils.isEmpty(ability2.getId()) && ability2.getId().equals(ability.getId()))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        this.mStatus = 0;
    }
}

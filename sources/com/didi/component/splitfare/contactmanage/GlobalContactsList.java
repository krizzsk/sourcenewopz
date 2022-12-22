package com.didi.component.splitfare.contactmanage;

import java.util.ArrayList;
import java.util.Collection;

public class GlobalContactsList extends ArrayList<GlobalContactsModel> {
    public boolean addAll(Collection<? extends GlobalContactsModel> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (GlobalContactsModel globalContactsModel : collection) {
            if (globalContactsModel.type == 3 && contains(globalContactsModel)) {
                arrayList.add(globalContactsModel);
            }
        }
        if (arrayList.size() != 0) {
            collection.removeAll(arrayList);
        }
        return super.addAll(collection);
    }
}

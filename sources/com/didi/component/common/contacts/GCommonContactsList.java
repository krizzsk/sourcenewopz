package com.didi.component.common.contacts;

import java.util.ArrayList;
import java.util.Collection;

public class GCommonContactsList extends ArrayList<GCommonContactsModel> {
    public boolean addAll(Collection<? extends GCommonContactsModel> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (GCommonContactsModel gCommonContactsModel : collection) {
            if (gCommonContactsModel.type == 3 && contains(gCommonContactsModel)) {
                arrayList.add(gCommonContactsModel);
            }
        }
        if (arrayList.size() != 0) {
            collection.removeAll(arrayList);
        }
        return super.addAll(collection);
    }
}

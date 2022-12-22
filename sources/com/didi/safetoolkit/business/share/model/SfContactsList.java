package com.didi.safetoolkit.business.share.model;

import com.didi.safetoolkit.model.SfContactsModel;
import java.util.ArrayList;
import java.util.Collection;

public class SfContactsList extends ArrayList<SfContactsModel> {
    public boolean addAll(Collection<? extends SfContactsModel> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SfContactsModel sfContactsModel : collection) {
            if (sfContactsModel.type == 3 && contains(sfContactsModel)) {
                arrayList.add(sfContactsModel);
            }
        }
        if (arrayList.size() != 0) {
            collection.removeAll(arrayList);
        }
        return super.addAll(collection);
    }
}

package com.didi.component.company.model;

import android.text.TextUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CompanyInfo implements Serializable {
    public List<String> childCids;
    public CharSequence companyDesc;
    public String companyIconUrl;
    public String companyId;
    public CharSequence companyName;
    public CharSequence extend;
    public CharSequence extendTop;
    public boolean isPickupSvrFree;

    public TaxiCompanyListModel.CompanyModel toCompanyModel() {
        TaxiCompanyListModel.CompanyModel companyModel = new TaxiCompanyListModel.CompanyModel();
        companyModel.f44227id = this.companyId;
        companyModel.iconUrl = this.companyIconUrl;
        String str = "";
        companyModel.name = TextUtils.isEmpty(this.companyName) ? str : this.companyName.toString();
        if (!TextUtils.isEmpty(this.companyDesc)) {
            str = this.companyDesc.toString();
        }
        companyModel.desc = str;
        if (!CollectionUtil.isEmpty((Collection<?>) this.childCids)) {
            companyModel.fillChildCids(this.childCids);
        }
        return companyModel;
    }
}

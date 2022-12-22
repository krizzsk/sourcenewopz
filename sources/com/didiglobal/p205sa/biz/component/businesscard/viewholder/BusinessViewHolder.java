package com.didiglobal.p205sa.biz.component.businesscard.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.viewholder.BusinessViewHolder */
public class BusinessViewHolder extends BaseViewHolder<BusinessCardModel.BusinessMenuModel> {

    /* renamed from: a */
    private TextView f50829a = ((TextView) this.itemView.findViewById(R.id.tv_business_name));

    /* renamed from: b */
    private ImageView f50830b = ((ImageView) this.itemView.findViewById(R.id.iv_business_icon));

    public BusinessViewHolder(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.business_item_more, (ViewGroup) view, false));
    }

    public void setData(BusinessCardModel.BusinessMenuModel businessMenuModel) {
        if (businessMenuModel != null) {
            this.f50829a.setText(businessMenuModel.name.getContent());
            if (!TextUtils.isEmpty(businessMenuModel.businessIcon)) {
                ((RequestBuilder) Glide.with(this.itemView.getContext()).load(businessMenuModel.businessIcon).placeholder((int) R.drawable.sa_business_more_item_default)).into(this.f50830b);
            }
            m36487a(businessMenuModel);
        }
    }

    /* renamed from: a */
    private void m36487a(BusinessCardModel.BusinessMenuModel businessMenuModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "sa_pullup");
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        hashMap.put("size", Integer.valueOf(businessMenuModel.style));
        try {
            HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) businessMenuModel.log_data, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_sw", (Map<String, Object>) hashMap);
    }
}

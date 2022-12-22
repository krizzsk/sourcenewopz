package com.didi.soda.customer.animation.transitions.name;

import android.content.Context;
import com.taxis99.R;
import java.io.Serializable;

public class BusinessTransitionNameSet implements Serializable {
    private static final long serialVersionUID = 3429954202622796467L;
    public String mDescContainerTransitionName;
    public String mExceptionStatusTransitionName;
    public String mImageMaskTransitionName;
    public String mImageTransitionName;
    public String mLogoMaskTransitionName;
    public String mLogoTransitionName;
    public String mNameTransitionName;

    public static BusinessTransitionNameSet newInstance(Context context, String str, String str2) {
        String buildUid = buildUid(str, str2);
        BusinessTransitionNameSet businessTransitionNameSet = new BusinessTransitionNameSet();
        businessTransitionNameSet.mImageTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_image_named, new Object[]{buildUid});
        businessTransitionNameSet.mNameTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_name_named, new Object[]{buildUid});
        businessTransitionNameSet.mLogoTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_logo_named, new Object[]{buildUid});
        businessTransitionNameSet.mLogoMaskTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_logo_mask_named, new Object[]{buildUid});
        businessTransitionNameSet.mExceptionStatusTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_exception_status_named, new Object[]{buildUid});
        businessTransitionNameSet.mDescContainerTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_desc_container_named, new Object[]{buildUid});
        businessTransitionNameSet.mImageMaskTransitionName = context.getResources().getString(R.string.customer_transition_tag_business_image_mask_named, new Object[]{buildUid});
        return businessTransitionNameSet;
    }

    private static String buildUid(String str, String str2) {
        if (str == null) {
            return "null_" + str2;
        }
        return str + "_" + str2;
    }
}

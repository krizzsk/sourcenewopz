package com.didi.soda.home.binder.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.binder.model.business.BusinessInfoRvModel;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import java.util.ArrayList;
import java.util.List;

public class HomeScrollBusinessRvModel extends ModuleModel implements RecyclerModel {

    /* renamed from: a */
    private static final int f42545a = 6;
    public List<BusinessInfoRvModel> mBusinessInfoRvModels = new ArrayList();
    public boolean mHasMore = true;
    public int mMaxBusinessHeight;
    public String mModuleTitle;

    public static HomeScrollBusinessRvModel convertSlideEntity(List<BusinessInfoEntity> list, int i, String str, String str2, String str3, int i2, int i3, int i4, String str4, boolean z, boolean z2, Context context) {
        List<BusinessInfoEntity> list2 = list;
        String str5 = str;
        String str6 = str3;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        String str7 = str4;
        boolean z3 = z;
        Context context2 = context;
        HomeScrollBusinessRvModel homeScrollBusinessRvModel = new HomeScrollBusinessRvModel();
        if (list2 != null && list.size() > 0) {
            int size = list.size();
            int i8 = 0;
            if (z2) {
                size = Math.min(list.size(), 6);
                if (size == 6) {
                    homeScrollBusinessRvModel.mHasMore = true;
                } else {
                    homeScrollBusinessRvModel.mHasMore = false;
                }
            } else {
                homeScrollBusinessRvModel.mHasMore = false;
            }
            int i9 = 0;
            while (i9 < size) {
                BusinessInfoRvModel convertBusinessInfoEntity = BusinessInfoRvModel.convertBusinessInfoEntity(list2.get(i9), i8, i, context2, Const.ComponentType.SHOP_SMALL);
                convertBusinessInfoEntity.mRecId = str7;
                convertBusinessInfoEntity.mModuleId = str5;
                convertBusinessInfoEntity.mModuleType = str6;
                convertBusinessInfoEntity.mModuleIndex = i5;
                convertBusinessInfoEntity.mPageInModule = i7;
                convertBusinessInfoEntity.mIndexInModule = i9;
                convertBusinessInfoEntity.mRowInModule = i6;
                convertBusinessInfoEntity.mColumnInModule = i9;
                if (z3) {
                    convertBusinessInfoEntity.mMask = z3;
                }
                convertBusinessInfoEntity.mTransitionNameSet = BusinessTransitionNameSet.newInstance(context2, str5, convertBusinessInfoEntity.mShopId);
                homeScrollBusinessRvModel.mRecId = str7;
                homeScrollBusinessRvModel.mModuleId = str5;
                homeScrollBusinessRvModel.mModuleType = str6;
                homeScrollBusinessRvModel.mModuleIndex = i5;
                homeScrollBusinessRvModel.mPageInModule = i7;
                homeScrollBusinessRvModel.mIndexInModule = i6;
                homeScrollBusinessRvModel.mRowInModule = i6;
                homeScrollBusinessRvModel.mColumnInModule = i8;
                homeScrollBusinessRvModel.mMaxBusinessHeight = Math.max(m29990a(convertBusinessInfoEntity), homeScrollBusinessRvModel.mMaxBusinessHeight);
                homeScrollBusinessRvModel.mBusinessInfoRvModels.add(convertBusinessInfoEntity);
                i9++;
                i8 = 0;
            }
        }
        homeScrollBusinessRvModel.mModuleId = str5;
        homeScrollBusinessRvModel.mModuleTitle = str2;
        homeScrollBusinessRvModel.mModuleIndex = i5;
        return homeScrollBusinessRvModel;
    }

    /* renamed from: a */
    private static int m29990a(BusinessInfoRvModel businessInfoRvModel) {
        int i = 240;
        if (!businessInfoRvModel.mMask) {
            int size = (TextUtils.isEmpty(businessInfoRvModel.mShopTip) ^ true ? 1 : 0) + (CollectionsUtil.isEmpty(businessInfoRvModel.mActTipList) ? 0 : businessInfoRvModel.mActTipList.size());
            if (size > 0 && size <= 2) {
                i = 270;
            }
            if (size > 2) {
                i += 60;
            }
            if (!TextUtils.isEmpty(businessInfoRvModel.mCateTip)) {
                return i + 20;
            }
            return i;
        } else if (!TextUtils.isEmpty(businessInfoRvModel.mBusinessNextOpenTimeDesc)) {
            return 240;
        } else {
            return 210;
        }
    }
}

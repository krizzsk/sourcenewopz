package com.didi.soda.business.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.BusinessCateEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BusinessCategoryRvModel extends BaseBusinessRvModel implements IEntity {
    private static final String SEARCH_POLYMER_CATE_ID = "3";
    private static final long serialVersionUID = 8974864797596910787L;
    public BusinessTabTipRvModel businessTabTipRvModel;
    public boolean isFirst = false;
    public boolean isSelected = false;
    public String mCategoryDesc;
    public String mCategoryId;
    public int mCategoryIndex;
    public String mCategoryName;
    public BusinessExpandRvModel mExpandRvModel;
    public List<ComponentModel> mGoodsDynamicItemList = new ArrayList();
    public List<BusinessGoodsItemRvModel> mGoodsItemList = new ArrayList();
    public int mItemCount;
    public CharSequence mSelectedCateName;
    public CharSequence mUnSelectedCateName;

    public List<BusinessGoodsItemRvModel> getAllDisplayGoods() {
        ArrayList arrayList = new ArrayList(this.mGoodsItemList);
        BusinessExpandRvModel businessExpandRvModel = this.mExpandRvModel;
        if (businessExpandRvModel != null && businessExpandRvModel.mIsExpand) {
            arrayList.addAll(this.mExpandRvModel.mExpandList);
        }
        return arrayList;
    }

    public List<ComponentModel> getAllDyDisplayGoods() {
        ArrayList arrayList = new ArrayList(this.mGoodsDynamicItemList);
        BusinessExpandRvModel businessExpandRvModel = this.mExpandRvModel;
        if (businessExpandRvModel != null && businessExpandRvModel.mIsExpand) {
            arrayList.addAll(this.mExpandRvModel.mComponentModelExpandList);
        }
        return arrayList;
    }

    public List<BusinessGoodsItemRvModel> getAllGoods() {
        ArrayList arrayList = new ArrayList(this.mGoodsItemList);
        BusinessExpandRvModel businessExpandRvModel = this.mExpandRvModel;
        if (businessExpandRvModel != null) {
            arrayList.addAll(businessExpandRvModel.mExpandList);
        }
        return arrayList;
    }

    public List<ComponentModel> getAllDyGoods() {
        ArrayList arrayList = new ArrayList(this.mGoodsDynamicItemList);
        BusinessExpandRvModel businessExpandRvModel = this.mExpandRvModel;
        if (businessExpandRvModel != null) {
            arrayList.addAll(businessExpandRvModel.mComponentModelExpandList);
        }
        return arrayList;
    }

    public static BusinessCategoryRvModel newInstance(BusinessCateEntity businessCateEntity) {
        BusinessCategoryRvModel businessCategoryRvModel = new BusinessCategoryRvModel();
        businessCategoryRvModel.mCategoryId = businessCateEntity.cateId;
        businessCategoryRvModel.mCategoryName = businessCateEntity.cateName;
        if (businessCateEntity.cateTip != null && !TextUtils.isEmpty(businessCateEntity.cateTip.getTopContent())) {
            businessCategoryRvModel.businessTabTipRvModel = BusinessTabTipRvModel.newInstance(businessCateEntity.cateTip.getTopContent());
        }
        if ("3".equals(businessCateEntity.cateId)) {
            businessCategoryRvModel.mSelectedCateName = getSearchSelectedName(businessCateEntity.cateName);
            businessCategoryRvModel.mUnSelectedCateName = getSearchUnSelectedName(businessCateEntity.cateName);
        } else {
            businessCategoryRvModel.mSelectedCateName = getMediumName(businessCateEntity.cateName);
            businessCategoryRvModel.mUnSelectedCateName = getNormalName(businessCateEntity.cateName);
        }
        businessCategoryRvModel.mCategoryDesc = businessCateEntity.desc;
        if (businessCateEntity.items != null) {
            businessCategoryRvModel.mItemCount = businessCateEntity.items.size();
        }
        if (businessCateEntity.mJsonComponentList != null) {
            businessCategoryRvModel.mItemCount = businessCateEntity.mJsonComponentList.size();
        }
        return businessCategoryRvModel;
    }

    private static CharSequence getSearchUnSelectedName(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getSearchIcon(GlobalContext.getContext()));
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(getNormalName(str));
        return spannableStringBuilder;
    }

    private static CharSequence getSearchSelectedName(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getSearchIcon(GlobalContext.getContext()));
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(getMediumName(str));
        return spannableStringBuilder;
    }

    private static SpannableString getSearchIcon(Context context) {
        SpannableString spannableString = new SpannableString(context.getResources().getString(R.string.customer_common_icon_search));
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(16), 0, spannableString.length(), 33);
        return spannableString;
    }

    private static SpannableString getMediumName(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (CustomerApolloUtil.isShowNewBusiness()) {
            return spannableString;
        }
        spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.MEDIUM)), 0, spannableString.length(), 33);
        return spannableString;
    }

    private static SpannableString getNormalName(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (CustomerApolloUtil.isShowNewBusiness()) {
            return spannableString;
        }
        spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.NORMAL)), 0, spannableString.length(), 33);
        return spannableString;
    }
}

package com.didi.soda.home.topgun.binder.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeHorizontalScrollTopicRvModel extends ModuleModelV2 implements RecyclerModel {
    public BgColor mBgColor;
    public List<HomeBusinessInfoRvModel> mBusinessInfoRvModels = new ArrayList();
    public List<BusinessGoodsItemRvModel> mGoodsInfoRvModels = new ArrayList();
    public boolean mIsPlayHandAnim = false;
    public int mMaxBusinessHeight;
    public String mModuleTitle;
    public String mRuleDesc;
    public int mScene;
    public int mScrollX;
    public String mTopicTitle;
    public ViewMoreModel mViewMoreModel;

    public static ComponentModel convert(Context context, ComponentEntity componentEntity, FeedPayload feedPayload) {
        ComponentModel componentModel = new ComponentModel();
        HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = new HomeHorizontalScrollTopicRvModel();
        if (!(componentEntity == null || componentEntity.mTopicComp == null)) {
            homeHorizontalScrollTopicRvModel.mModuleTitle = componentEntity.mTitle;
            homeHorizontalScrollTopicRvModel.mComponentId = componentEntity.mComponentId;
            homeHorizontalScrollTopicRvModel.mScene = componentEntity.mTopicComp.scene;
            homeHorizontalScrollTopicRvModel.mRecId = feedPayload.mRecId;
            homeHorizontalScrollTopicRvModel.mTopicTitle = componentEntity.mTopicComp.mTopicTitle;
            homeHorizontalScrollTopicRvModel.mBgColor = new BgColor();
            if (componentEntity.mTopicComp.bgColor != null) {
                homeHorizontalScrollTopicRvModel.mBgColor.mAngle = componentEntity.mTopicComp.bgColor.angle;
                homeHorizontalScrollTopicRvModel.mBgColor.mColor = componentEntity.mTopicComp.bgColor.color;
            } else {
                homeHorizontalScrollTopicRvModel.mBgColor.defaultSetting();
            }
            homeHorizontalScrollTopicRvModel.mRuleDesc = componentEntity.mTopicComp.ruleDesc;
            homeHorizontalScrollTopicRvModel.mViewMoreModel = ViewMoreModel.Companion.convertModel(componentEntity.mTopicComp.mViewMore);
            if (componentEntity.mTopicComp.mShopList != null) {
                int size = componentEntity.mTopicComp.mShopList.size();
                for (int i = 0; i < size; i++) {
                    HomeBusinessInfoRvModel convertBusinessInfoEntity = HomeBusinessInfoRvModel.convertBusinessInfoEntity(componentEntity.mTopicComp.mShopList.get(i));
                    m30218a(convertBusinessInfoEntity, feedPayload, componentEntity, i);
                    homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.add(convertBusinessInfoEntity);
                }
            }
            if (componentEntity.mTopicComp.mItems != null) {
                int size2 = componentEntity.mTopicComp.mItems.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    homeHorizontalScrollTopicRvModel.mGoodsInfoRvModels.add(BusinessGoodsItemRvModel.newInstance(componentEntity.mTopicComp.mItems.get(i2)));
                }
            }
        }
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplId())) {
            homeHorizontalScrollTopicRvModel.mModuleType = componentEntity.mComponentV2.getTmplId();
        }
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplTag())) {
            homeHorizontalScrollTopicRvModel.mModuleIndex = componentEntity.mComponentV2.getTmplTag();
        }
        JsonParser jsonParser = new JsonParser();
        componentModel.setDataModel(homeHorizontalScrollTopicRvModel);
        componentModel.setTemplateId(componentEntity.mComponentV2.getTmplId());
        if (componentEntity.mComponentV2.getTmplId() != null) {
            componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance().buildWidgetNode(componentEntity.mComponentV2.getTmplId(), (JsonObject) jsonParser.parse(GsonUtil.toJson(componentEntity)), componentModel));
        }
        return componentModel;
    }

    public static HomeHorizontalScrollTopicRvModel convert(ComponentEntity componentEntity, FeedPayload feedPayload) {
        HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = new HomeHorizontalScrollTopicRvModel();
        if (!(componentEntity == null || componentEntity.mTopicComp == null)) {
            homeHorizontalScrollTopicRvModel.mModuleTitle = componentEntity.mTitle;
            homeHorizontalScrollTopicRvModel.mComponentId = componentEntity.mComponentId;
            homeHorizontalScrollTopicRvModel.mScene = componentEntity.mTopicComp.scene;
            homeHorizontalScrollTopicRvModel.mRecId = feedPayload.mRecId;
            homeHorizontalScrollTopicRvModel.mTopicTitle = componentEntity.mTopicComp.mTopicTitle;
            homeHorizontalScrollTopicRvModel.mBgColor = new BgColor();
            if (componentEntity.mTopicComp.bgColor != null) {
                homeHorizontalScrollTopicRvModel.mBgColor.mAngle = componentEntity.mTopicComp.bgColor.angle;
                homeHorizontalScrollTopicRvModel.mBgColor.mColor = componentEntity.mTopicComp.bgColor.color;
            } else {
                homeHorizontalScrollTopicRvModel.mBgColor.defaultSetting();
            }
            homeHorizontalScrollTopicRvModel.mRuleDesc = componentEntity.mTopicComp.ruleDesc;
            homeHorizontalScrollTopicRvModel.mViewMoreModel = ViewMoreModel.Companion.convertModel(componentEntity.mTopicComp.mViewMore);
            if (componentEntity.mTopicComp.mShopList != null) {
                int size = componentEntity.mTopicComp.mShopList.size();
                for (int i = 0; i < size; i++) {
                    HomeBusinessInfoRvModel convertBusinessInfoEntity = HomeBusinessInfoRvModel.convertBusinessInfoEntity(componentEntity.mTopicComp.mShopList.get(i));
                    m30218a(convertBusinessInfoEntity, feedPayload, componentEntity, i);
                    homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.add(convertBusinessInfoEntity);
                }
            }
            if (componentEntity.mTopicComp.mItems != null) {
                int size2 = componentEntity.mTopicComp.mItems.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    homeHorizontalScrollTopicRvModel.mGoodsInfoRvModels.add(BusinessGoodsItemRvModel.newInstance(componentEntity.mTopicComp.mItems.get(i2)));
                }
            }
        }
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplId())) {
            homeHorizontalScrollTopicRvModel.mModuleType = componentEntity.mComponentV2.getTmplId();
        }
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplTag())) {
            homeHorizontalScrollTopicRvModel.mModuleIndex = componentEntity.mComponentV2.getTmplTag();
        }
        return homeHorizontalScrollTopicRvModel;
    }

    public static HomeHorizontalScrollTopicRvModel convertSlideEntity(Context context, ComponentEntity componentEntity, FeedPayload feedPayload) {
        if (componentEntity == null || componentEntity.mShopList == null || componentEntity.mShopList.size() < 3) {
            return null;
        }
        HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = new HomeHorizontalScrollTopicRvModel();
        int size = componentEntity.mShopList.size();
        homeHorizontalScrollTopicRvModel.mModuleTitle = componentEntity.mTitle;
        homeHorizontalScrollTopicRvModel.mComponentId = componentEntity.mComponentId;
        for (int i = 0; i < size; i++) {
            HomeBusinessInfoRvModel convertBusinessInfoEntity = HomeBusinessInfoRvModel.convertBusinessInfoEntity(componentEntity.mShopList.get(i));
            m30218a(convertBusinessInfoEntity, feedPayload, componentEntity, i);
            homeHorizontalScrollTopicRvModel.mMaxBusinessHeight = Math.max(m30217a(context, convertBusinessInfoEntity), homeHorizontalScrollTopicRvModel.mMaxBusinessHeight);
            homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.add(convertBusinessInfoEntity);
        }
        return homeHorizontalScrollTopicRvModel;
    }

    /* renamed from: a */
    private static void m30218a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, FeedPayload feedPayload, ComponentEntity componentEntity, int i) {
        if (homeBusinessInfoRvModel != null && componentEntity != null) {
            if (feedPayload != null) {
                homeBusinessInfoRvModel.mPageId = feedPayload.mPageId;
                homeBusinessInfoRvModel.mPageInModule = feedPayload.mPageIndex;
                homeBusinessInfoRvModel.mPageFilter = feedPayload.mPageFilter;
                homeBusinessInfoRvModel.mRowInModule = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mRecId = feedPayload.mRecId;
            }
            homeBusinessInfoRvModel.mComponentId = componentEntity.mComponentId;
            homeBusinessInfoRvModel.mComponentType = componentEntity.mType;
            homeBusinessInfoRvModel.mColumnInModule = i;
            homeBusinessInfoRvModel.mIndexInModule = componentEntity.mPosition;
            if (componentEntity.mComponentV2 != null) {
                if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplId())) {
                    homeBusinessInfoRvModel.mModuleType = componentEntity.mComponentV2.getTmplId();
                }
                if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplTag())) {
                    homeBusinessInfoRvModel.mModuleIndex = componentEntity.mComponentV2.getTmplTag();
                }
            }
        }
    }

    /* renamed from: a */
    private static int m30217a(Context context, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        TextView textView = new TextView(context);
        textView.setTextSize(18.0f);
        textView.setText(homeBusinessInfoRvModel.mShopName);
        if (((int) textView.getPaint().measureText(textView.getText().toString())) > ((int) (((float) (DisplayUtils.getScreenWidth(context) - context.getResources().getDimensionPixelOffset(R.dimen.customer_94px))) * 0.47f))) {
            return GlobalContext.isEmbed() ? 217 : 210;
        }
        return 192;
    }

    public static class BgColor {
        public int mAngle;
        public List<String> mColor;

        /* access modifiers changed from: package-private */
        public void defaultSetting() {
            this.mAngle = 0;
            ArrayList arrayList = new ArrayList();
            this.mColor = arrayList;
            arrayList.add("#FFFFFF");
        }
    }
}

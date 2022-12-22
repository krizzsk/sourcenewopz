package com.didi.soda.goodsV2.component.multilevel;

import com.didi.soda.goodsV2.component.AbsCommonGoodsPresenter;
import com.didi.soda.goodsV2.component.AbsCommonGoodsView;

interface Contract {

    public static abstract class AbsMultiLevelPresenter extends AbsCommonGoodsPresenter<AbsMultiLevelView> {
    }

    public static abstract class AbsMultiLevelView extends AbsCommonGoodsView<AbsMultiLevelPresenter> {
    }
}

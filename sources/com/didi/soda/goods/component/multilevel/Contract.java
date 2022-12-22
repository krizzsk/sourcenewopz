package com.didi.soda.goods.component.multilevel;

import com.didi.soda.goods.component.AbsCommonGoodsPresenter;
import com.didi.soda.goods.component.AbsCommonGoodsView;

interface Contract {

    public static abstract class AbsMultiLevelPresenter extends AbsCommonGoodsPresenter<AbsMultiLevelView> {
    }

    public static abstract class AbsMultiLevelView extends AbsCommonGoodsView<AbsMultiLevelPresenter> {
    }
}

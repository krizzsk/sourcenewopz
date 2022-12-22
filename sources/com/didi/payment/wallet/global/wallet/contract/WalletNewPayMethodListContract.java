package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.taxis99.R;
import java.util.List;

public interface WalletNewPayMethodListContract {
    public static final int VIEW_ITEM_RIGHT_STYLE_ARROW = 1;
    public static final int VIEW_ITEM_RIGHT_STYLE_LABEL_ICON = 2;
    public static final int VIEW_ITEM_RIGHT_STYLE_NONE = 0;
    public static final int VIEW_ITEM_TYPE_LABEL = 2;
    public static final int VIEW_ITEM_TYPE_NORMAL = 1;
    public static final int VIEW_STYLE_HOME = 1;
    public static final int VIEW_STYLE_MAINLIST = 2;

    public static class ItemModel {
        public String desc;
        public int descColor = R.color.wallet_color_999999;
        public int iconId;
        public String iconUrl;
        public boolean isInFreezeMode = false;
        public int mainTextColor = 0;
        public String name;
        public String rightClickLink;
        public boolean rightClickable = false;
        public int rightStyle = 1;
        public String rightText;
        public int rightTextBg;
        public int rightTextColor = R.color.wallet_color_919599;
        public int type = 1;
    }

    public interface Listener {
        void onNewPayMethodItemClicked(int i);

        void onNewPayMethodItemRightLabelClicked(int i);
    }

    public static class Model {
        public String entranceLink;
        public String faqLink;
        public List<ItemModel> items;
        public String title;
        public String topTips;
        public int topTipsBgColor = 0;
        public int topTipsTextColor = 0;
        public String transEntrance;
    }

    public interface View extends WalletCommonContract.View<Model, Listener> {
        void setStyle(int i);
    }
}

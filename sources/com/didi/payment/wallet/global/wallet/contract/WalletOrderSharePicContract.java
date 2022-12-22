package com.didi.payment.wallet.global.wallet.contract;

import android.graphics.Bitmap;
import android.view.ViewGroup;

public interface WalletOrderSharePicContract {

    public interface Presenter {
        void onShareClicked();
    }

    public interface View {
        Bitmap createSharePic();

        void setAdapter(WalletOrderSharePicAdapter walletOrderSharePicAdapter);
    }

    public interface WalletOrderSharePicAdapter {
        String getBannerText();

        android.view.View getItemView(ViewGroup viewGroup, int i);

        int getItemsCount();

        android.view.View getPayeeItemView(ViewGroup viewGroup, int i);

        int getPayeementItemCount();

        String getPayeementTitle();

        String getPrice();

        android.view.View getRechargeItemView(ViewGroup viewGroup, int i);

        int getRechargementItemCount();

        String getRechargementTitle();

        int getResultIcon();

        int getStatusImg();

        String getSubTitle();

        int getSubTitleBgColorId();

        int getSubTitleColorId();

        String getSymbol();

        String getTitle();

        int getTitleColorId();
    }
}

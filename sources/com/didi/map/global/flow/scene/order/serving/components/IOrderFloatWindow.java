package com.didi.map.global.flow.scene.order.serving.components;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.didi.map.global.flow.scene.order.serving.param.OrderState;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;

public interface IOrderFloatWindow {
    void appTurnIntoBackGround();

    void appTurnIntoForeground();

    boolean hasPermission(Context context);

    void hidden();

    boolean isVisible();

    void requestPermission(Activity activity, int i);

    void resetState();

    void setContext(Context context);

    void setLicensePlate(String str);

    void setMapSdkType(String str);

    void setModelBitmap(Bitmap bitmap);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOrderId(String str);

    void setPageScene(PageSceneID pageSceneID);

    void setProductId(String str);

    void setServingParam(ServingParam servingParam);

    void setTripStage(int i);

    void show();

    void updateEtaEda(int i, int i2);

    void updateOrderState(OrderState orderState);
}

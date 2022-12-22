package com.didi.map.global.flow.scene.order.waiting.p123v2;

import android.graphics.Bitmap;
import com.didi.map.global.flow.scene.ISceneController;
import com.didichuxing.carsliding.model.Driver;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.IWaitingForReplyControllerV2 */
public interface IWaitingForReplyControllerV2 extends ISceneController {
    void onCarBitmapNetWorkSuccess(Bitmap bitmap);

    void onDriverReceivedOrder(Driver driver);

    void onDriverRefuseOrder(Driver driver);

    void onOrderToOneDriver(Driver driver);
}

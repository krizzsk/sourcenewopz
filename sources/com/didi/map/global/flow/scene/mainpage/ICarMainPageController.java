package com.didi.map.global.flow.scene.mainpage;

import com.didi.common.map.model.Padding;
import com.didi.map.global.flow.scene.ISceneController;

public interface ICarMainPageController extends ISceneController {

    /* renamed from: com.didi.map.global.flow.scene.mainpage.ICarMainPageController$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$hideCarSliding(ICarMainPageController iCarMainPageController) {
        }

        public static void $default$showCarSliding(ICarMainPageController iCarMainPageController) {
        }
    }

    void hideCarSliding();

    void leaveSaPage(int i);

    boolean onDomainChanged();

    void saCarMainToSAPage(Padding padding);

    void saUpdatePageSceneParam(MainPageSceneParam mainPageSceneParam);

    void showCarSliding();

    void updateCarIcon();
}

package com.didi.map.global.flow.presenter;

import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.scene.mainpage.MainPageSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.over.IMiniBusOrderOverSceneController;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.pre.IMiniBusConfirmSceneController;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusConfirmSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.IMiniBusSctxSceneController;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusAppointParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusSctxSceneParam;
import com.didi.map.global.flow.scene.order.confirm.normal.IOrderConfirmController;
import com.didi.map.global.flow.scene.order.confirm.normal.OrderConfirmSceneParam;
import com.didi.map.global.flow.scene.order.serving.ILockScreenServingController;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam;
import com.didi.map.global.flow.scene.order.serving.param.ServiceOverParam;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.order.waiting.IWaitingForReplyController;
import com.didi.map.global.flow.scene.order.waiting.WaitingForReplyParam;
import com.didi.map.global.flow.scene.order.waiting.p123v2.IWaitingForReplyControllerV2;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplyParamV2;
import com.didi.map.global.flow.scene.simple.ISimpleMapSceneController;
import com.didi.map.global.flow.scene.simple.params.SimpleSceneParams;
import com.didi.map.global.flow.scene.sug.IPopSugSceneController;
import com.didi.map.global.flow.scene.sug.PopSugSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.geton.IVamosConfirmGetOnController;
import com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.order.IVamosConfirmOrderController;
import com.didi.map.global.flow.scene.vamos.confirm.order.VamosConfirmOrderSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.order.driver.IVamosDriverConfirmOrderController;
import com.didi.map.global.flow.scene.vamos.confirm.order.driver.VamosDriverConfirmOrderSceneParam;
import com.didi.map.global.flow.scene.vamos.homepage.VamosHomePageSceneParam;
import com.didi.map.global.flow.scene.vamos.orderpreview.IVamosOrderPreviewController;
import com.didi.map.global.flow.scene.vamos.orderpreview.param.VamosOrderPreviewParams;
import com.didi.map.global.flow.scene.vamos.orderwait.IVamosOrderWaitController;
import com.didi.map.global.flow.scene.vamos.orderwait.param.VamosOrderWaitParams;
import com.didi.map.global.flow.scene.vamos.sctx.driver.IVamosDriverSctxController;
import com.didi.map.global.flow.scene.vamos.sctx.driver.param.VamosDriverSctxParam;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.IVamosPssengerSctxSceneController;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.global.flow.scene.vamos.sug.IVamosSugPageSceneController;
import com.didi.map.global.flow.scene.vamos.sug.VamosSugPageSceneParam;

public interface IMapFlowPresenter {
    void clear();

    IScene getCurrentScene();

    ISimpleMapSceneController openSimpleScene(SimpleSceneParams simpleSceneParams);

    ICarMainPageController switch2CarMainPageScene(MainPageSceneParam mainPageSceneParam);

    IServingController switch2InServiceScene(ServingParam servingParam);

    ILockScreenServingController switch2LockScreenScene(LockScreenServingParam lockScreenServingParam);

    IOrderConfirmController switch2OrderConfirmScene(OrderConfirmSceneParam orderConfirmSceneParam);

    IPopSugSceneController switch2PopSugPageScene(PopSugSceneParam popSugSceneParam);

    ISceneController switch2ServiceOverScene(ServiceOverParam serviceOverParam);

    IVamosConfirmGetOnController switch2VamosConfirmGetOnScene(VamosConfirmGetOnSceneParam vamosConfirmGetOnSceneParam);

    IVamosConfirmOrderController switch2VamosConfirmOrderScene(VamosConfirmOrderSceneParam vamosConfirmOrderSceneParam);

    IVamosDriverConfirmOrderController switch2VamosDriverConfirmOrderScene(VamosDriverConfirmOrderSceneParam vamosDriverConfirmOrderSceneParam);

    IVamosOrderPreviewController switch2VamosDriverOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams);

    IVamosOrderWaitController switch2VamosDriverOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams);

    IVamosDriverSctxController switch2VamosDriverPickupScene(VamosDriverSctxParam vamosDriverSctxParam);

    IVamosDriverSctxController switch2VamosDriverSendoffScene(VamosDriverSctxParam vamosDriverSctxParam);

    IVamosDriverSctxController switch2VamosDriverWaitScene(VamosDriverSctxParam vamosDriverSctxParam);

    ISceneController switch2VamosHomePageScene(VamosHomePageSceneParam vamosHomePageSceneParam);

    IVamosOrderPreviewController switch2VamosPaxOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams);

    IVamosOrderWaitController switch2VamosPaxOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams);

    IVamosSugPageSceneController switch2VamosSugPageScene(VamosSugPageSceneParam vamosSugPageSceneParam);

    IServingController switch2WaitingForDrivingAppointScene(ServingParam servingParam);

    IServingController switch2WaitingForDrivingScene(ServingParam servingParam);

    IWaitingForReplyController switch2WaitingForReplyOldScene(WaitingForReplyParam waitingForReplyParam);

    IWaitingForReplyController switch2WaitingForReplyScene(WaitingForReplyParam waitingForReplyParam);

    IWaitingForReplyControllerV2 switch2WaitingForReplySceneV2(WaitingForReplyParamV2 waitingForReplyParamV2);

    ISceneController switchMiniBusAppointScene(MiniBusAppointParam miniBusAppointParam);

    IMiniBusConfirmSceneController switchMiniBusConfirmScene(MiniBusConfirmSceneParam miniBusConfirmSceneParam);

    IMiniBusSctxSceneController switchMiniBusInsServiceScene(MiniBusSctxSceneParam miniBusSctxSceneParam);

    IMiniBusOrderOverSceneController switchMiniBusOrderOverScene(MiniBusOrderOverSceneParam miniBusOrderOverSceneParam);

    IMiniBusSctxSceneController switchMiniBusPickingScene(MiniBusSctxSceneParam miniBusSctxSceneParam);

    IVamosPssengerSctxSceneController switchVamosPassengerInServiceScene(VamosSctxSceneParam vamosSctxSceneParam);

    IVamosPssengerSctxSceneController switchVamosPassengerPickupScene(VamosSctxSceneParam vamosSctxSceneParam);

    IVamosPssengerSctxSceneController switchVamosPassengerWaitingScene(VamosSctxSceneParam vamosSctxSceneParam);
}

package com.didi.map.global.flow.scene.order.serving.components;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.serving.param.OrderState;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.ArrayList;
import java.util.List;

public class OrderFloatWindowManager implements IOrderFloatWindow {
    public static OrderFloatWindowManager Instance = null;

    /* renamed from: a */
    private static final String f26801a = "OrderFloatWindow";

    /* renamed from: b */
    private boolean f26802b;

    /* renamed from: c */
    private boolean f26803c;

    /* renamed from: d */
    private OrderFWMAgent f26804d = new OrderFWMAgent();

    /* renamed from: e */
    private List<String> f26805e = new ArrayList();

    public static final OrderFloatWindowManager Instance() {
        if (Instance == null) {
            synchronized (OrderFloatWindowManager.class) {
                if (Instance == null) {
                    Instance = new OrderFloatWindowManager();
                }
            }
        }
        return Instance;
    }

    private OrderFloatWindowManager() {
        boolean enableOrderFloatWindow = MapFlowApolloUtils.enableOrderFloatWindow();
        this.f26803c = enableOrderFloatWindow;
        this.f26802b = enableOrderFloatWindow;
        DLog.m7384d(f26801a, "apollo is enable:" + this.f26802b, new Object[0]);
        this.f26805e.add("21081");
        this.f26805e.add("21106");
    }

    public void setLicensePlate(String str) {
        if (this.f26802b) {
            this.f26804d.setLicensePlate(str);
        }
    }

    public void setModelBitmap(Bitmap bitmap) {
        if (this.f26802b) {
            this.f26804d.setModelBitmap(bitmap);
        }
    }

    public void updateEtaEda(int i, int i2) {
        if (this.f26802b) {
            this.f26804d.updateEtaEda(i, i2);
        }
    }

    public void updateOrderState(OrderState orderState) {
        if (this.f26802b) {
            this.f26804d.updateOrderState(orderState);
        }
    }

    public boolean isVisible() {
        if (this.f26802b) {
            return this.f26804d.isVisible();
        }
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.f26802b) {
            this.f26804d.setOnClickListener(onClickListener);
        }
    }

    public boolean hasPermission(Context context) {
        return this.f26804d.hasPermission(context);
    }

    public void requestPermission(Activity activity, int i) {
        this.f26804d.requestPermission(activity, i);
    }

    public void appTurnIntoForeground() {
        if (this.f26802b) {
            this.f26804d.appTurnIntoForeground();
        }
    }

    public void appTurnIntoBackGround() {
        if (this.f26802b) {
            this.f26804d.appTurnIntoBackGround();
        }
    }

    public void setContext(Context context) {
        if (this.f26802b) {
            this.f26804d.setContext(context);
        }
    }

    public void setProductId(String str) {
        DLog.m7384d(f26801a, "productId:" + str, new Object[0]);
        if (str == null || this.f26805e.contains(str)) {
            this.f26802b = false;
        } else {
            this.f26802b = this.f26803c;
        }
    }

    public void setOrderId(String str) {
        if (this.f26802b) {
            this.f26804d.setOrderId(str);
        }
    }

    public void setServingParam(ServingParam servingParam) {
        if (this.f26802b) {
            this.f26804d.setServingParam(servingParam);
        }
    }

    public void setMapSdkType(String str) {
        if (this.f26802b) {
            this.f26804d.setMapSdkType(str);
        }
    }

    public void setTripStage(int i) {
        if (this.f26802b) {
            this.f26804d.setTripStage(i);
        }
    }

    public void show() {
        if (this.f26802b) {
            this.f26804d.show();
        }
    }

    public void hidden() {
        if (this.f26802b) {
            this.f26804d.hidden();
        }
    }

    public void setPageScene(PageSceneID pageSceneID) {
        if (this.f26802b) {
            this.f26804d.setPageScene(pageSceneID);
        }
    }

    public void resetState() {
        if (this.f26802b) {
            this.f26804d.resetState();
        }
    }

    public static String getMapSdkType(Map map) {
        if (map == null || map.getMapVendor() == null) {
            return "google";
        }
        String mapVendor = map.getMapVendor().toString();
        if (TextUtils.isEmpty(mapVendor) || !mapVendor.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
            return "google";
        }
        return "didi";
    }
}

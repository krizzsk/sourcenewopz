package com.didi.soda.customer.service;

import com.didi.sdk.misconfig.store.MisConfigStore;
import com.didi.sdk.store.FetchCallback;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class FoodTabManager {
    public static final int CITY_ID = 52140500;
    public static final String HOOK_METHOD = "handleResponse";
    public static final String ONE_CONF = "{\n  \"errno\": 0,\n  \"errmsg\": \"\",\n  \"curtime\": 1554897964,\n  \"curVersion\": \"3139756507\",\n  \"data\": {\n    \"baseConf\": [{\n      \"name\": \"Ride\",\n      \"groupId\": 375,\n      \"groupType\": \"ride\",\n      \"openStatus\": 1,\n      \"link\": \"\",\n      \"linkText\": \"\",\n      \"iconFlipStatus\": 1,\n      \"mapIcon\": \"http://img0.didiglobal.com/static/titan_snapshot/upload/rooster20180206/ca02409c256fd3636e0be309c73530f77516aa21b471a132ffe45e27e594b375/img_upload_1517911554904.png\",\n      \"defaultCarId\": \"normal\",\n      \"submenuRange\": [{\n        \"businessId\": \"mxpop\",\n        \"businessNumId\": 375,\n        \"carIcon\": \"http://img0.didiglobal.com/static/titan_snapshot/upload/rooster20181104/1be1daa85b34e7a759f6ca2bb2947db14b59304cafcccc14a448e5a6e4a87e02/img_upload_1541277331644.png\",\n        \"carGrayIcon\": \"http://img0.didiglobal.com/static/titan_snapshot/upload/rooster20181104/6aeba1fdac730b5ed93a224c587e0b55bfbc9106513355fd3119e9263d669ea1/img_upload_1541277331641.png\",\n        \"carId\": \"normal\",\n        \"carLevel\": 2400,\n        \"comboType\": 0,\n        \"mapIcon\": \"http://img0.didiglobal.com/static/titan_snapshot/upload/rooster20181104/ca02409c256fd3636e0be309c73530f77516aa21b471a132ffe45e27e594b375/img_upload_1541277331646.png\",\n        \"name\": \"Express\",\n        \"subTitle\": \"\"\n      }]\n    }, {\n      \"name\": \"Food\",\n      \"groupId\": 392,\n      \"groupType\": \"soda\",\n      \"openStatus\": 1,\n      \"link\": \"\",\n      \"linkText\": \"\",\n      \"iconFlipStatus\": 1,\n      \"mapIcon\": \"\",\n      \"defaultCarId\": \"\",\n      \"submenuRange\": []\n    }],\n    \"smooth\": {\n      \"homeFrequency\": 5,\n      \"goingFrequency\": 10\n    },\n    \"currency\": {\n      \"abbr\": \"MXN\",\n      \"symbol\": \"MX$\",\n      \"unit\": \"peso\"\n    },\n    \"link\": \"\",\n    \"countryId\": 52,\n    \"cityId\": 52140500,\n    \"countyId\": 52140511,\n    \"utcOffset\": -300,\n    \"countryIsoCode\": \"MX\"\n  }\n}";

    private FoodTabManager() {
    }

    public static void showFoodTab() {
        MisConfigStore instance = MisConfigStore.getInstance();
        Class<?> cls = instance.getClass();
        try {
            Method declaredMethod = cls.getDeclaredMethod(HOOK_METHOD, new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, FetchCallback.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, new Object[]{ONE_CONF, "", Integer.valueOf(CITY_ID), 0, null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}

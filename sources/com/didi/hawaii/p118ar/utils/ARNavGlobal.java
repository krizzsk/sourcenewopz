package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.text.TextUtils;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.hawaii.ar.utils.ARNavGlobal */
public class ARNavGlobal {
    public static final String AT_Close = "0";
    public static final String AT_Exit = "1";
    public static final String AT_NeedReply = "2";
    public static final int BATTERY_MOSTLOW_STATE = ARAPollo.getLowerPower();
    public static final int DARCNaviTypeAR = 1;
    public static final int DARCNaviTypeARDirection = 2;
    public static String GPS_ACC_NOT_SATISFY = "当前卫星定位信号差，暂时无法使用AR上车点引导，请前往室外开阔地带使用";
    public static final long LOCATIONDISAPPEARTIME = 300;
    public static String LOWER_POWER = "电量不足，无法使用此功能";
    public static String NET_FAILED = "当前网络不畅，请检查网络设置";
    public static String NOT_IN_FENCE = "您不在导航区域";
    public static String OTHER_FAILED = "当前设备不支持";
    public static String alertMessage = "";
    public static Context context;
    public static String destSpotName = "上车点";
    public static long firstLocationSuccessTime = 0;
    public static String helpText = "•首先通过六边形识别周围环境，获取您的位置信息；\n•系统会根据您的位置信息，规划行走路线到上车点；\n•在导航过程中，请保持全程竖起手机，尽量不要抖动手机，减少路线误差；\n•AR实景导航仅可作为辅助，请不要作为您行走的唯一依据；\n•在您行走时，请注意观察周围行人及环境，以确保安全。";
    public static List<String> list = new ArrayList();
    public static String locFailMessage = "定位失败，请在北京南站出口楼层（地下一层）其他区域试试";
    public static LocationParam locationParam = new LocationParam();
    public static String motionlessHintMessage = "请移动手机";
    public static String zgAlertMessage = "AR方向引导仅作为寻找上车点的参考\n使用时以实际道路情况为准\n留意周围环境，注意安全！";
    public static String zgHelpText = "使用方法：\n\n•本功能为AR方向引导，辅助您找到上车点方向和位置，行走时以实际可通行区域为准；\n•使用时竖起手机，参照提示移动手机并查看上车点的实景指示牌信息和方向，前往上车点；\n•行走中，可随时在下方小地图中查看您和上车点的位置信息；\n•在上车点附近时，也可使用该功能查看上车点方位，更快到达上车点。\n\n注意事项：\n\n•本功能通过卫星定位信号获得您和上车点的位置信息，请尽量在室外开阔地带使用；\n•请确保您在安全位置使用，行走时随时留意周围环境，注意安全。";
    public static String zgLocFailMessage = "定位失败，请在信号稳定的区域尝试";

    /* renamed from: com.didi.hawaii.ar.utils.ARNavGlobal$LocationParam */
    public static class LocationParam {
        public float maxAngle;
        public float maxMotionlessAngle = 10.0f;
        public int maxMotionlessTime = 3;
        public float minAngle;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.utils.ARNavGlobal$buttonType */
    public @interface buttonType {
    }

    public static void init(Context context2) {
        context = context2.getApplicationContext();
        firstLocationSuccessTime = 0;
        List<String> list2 = list;
        if (list2 == null || list2.size() <= 0) {
            list.add(context2.getString(R.string.tips_msg));
            list.add(context2.getString(R.string.tips_msg2));
            list.add(context2.getString(R.string.tips_msg3));
            NOT_IN_FENCE = context2.getString(R.string.err_msg_not_in_fence);
            LOWER_POWER = context2.getString(R.string.err_msg_power_low);
            NET_FAILED = context2.getString(R.string.err_msg_net);
            OTHER_FAILED = context2.getString(R.string.err_msg_not_support);
        }
    }

    public static void parseResult(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            int i = jSONObject3.has("entrance-type") ? jSONObject3.getInt("entrance-type") : 1;
            if (1 == i) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("hint-text");
                if (jSONObject4 != null) {
                    String string = jSONObject4.getString("motionless-hint-message");
                    String string2 = jSONObject4.getString("loc-fail-message");
                    String string3 = jSONObject4.getString("help-text");
                    String string4 = jSONObject4.getString("alert-message");
                    JSONArray jSONArray = jSONObject4.getJSONArray("init-localization-tips");
                    if (!TextUtils.isEmpty(string)) {
                        motionlessHintMessage = string;
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        locFailMessage = string2;
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        helpText = string3;
                        helpText = string3.replace(Typography.middleDot, Typography.bullet);
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        alertMessage = string4;
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        list.clear();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            list.add(jSONArray.getString(i2));
                        }
                    }
                }
                JSONObject jSONObject5 = jSONObject3.getJSONObject("location-param");
                locationParam.maxAngle = (float) jSONObject5.getDouble("max-angle");
                locationParam.minAngle = (float) jSONObject5.getDouble("min-angle");
                locationParam.maxMotionlessAngle = (float) jSONObject5.getDouble("max-motionless-angle");
                locationParam.maxMotionlessTime = jSONObject5.getInt("max-motionless-time");
            } else if (2 == i && (jSONObject = jSONObject3.getJSONObject("direction-guide")) != null && (jSONObject2 = jSONObject.getJSONObject("hint-text")) != null) {
                String string5 = jSONObject2.getString("alert-message");
                String string6 = jSONObject2.getString("help-text");
                String string7 = jSONObject2.getString("loc-fail-message");
                if (!TextUtils.isEmpty(string5)) {
                    zgAlertMessage = string5;
                }
                if (!TextUtils.isEmpty(string7)) {
                    zgLocFailMessage = string7;
                }
                if (!TextUtils.isEmpty(string6)) {
                    zgHelpText = string6;
                    zgHelpText = string6.replace(Typography.middleDot, Typography.bullet);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

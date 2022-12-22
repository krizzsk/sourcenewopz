package com.tunasashimi.tuna;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaColorPicker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rui.config.RConfigConstants;

public class TunaView extends View {
    public static final int BOTTOM = 8;
    public static final int CENTER = 5;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 4;
    public static final int DIRECTION_BOTTOM = 8;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_MASK = 15;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 4;
    public static final String GRAPHICSTYPE_GIF = "GIF";
    public static final String GRAPHICSTYPE_JPG = "JPG";
    public static final String GRAPHICSTYPE_PNG = "PNG";
    public static final String GRAPHICSTYPE_UNKNOWN = "UNKNOWN";
    public static final int GRAVITY_MASK = 15;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    private static final int SHOW_PROPERTY_MAX_DISTANCE_DP = 10;
    private static final int SHOW_PROPERTY_MAX_TIME_MILLIS = 600;
    public static final int TOP = 0;
    private static final int TOUCH_DOWN_TIMES = 3;
    public static int bitmapMaxSize = 1536;
    protected static DisplayMetrics displayMetrics = null;
    public static TelephonyManager telephonyManager = null;
    private static final TunaContentGravity[] tunaContentGravityArray = {TunaContentGravity.ALL_CENTER, TunaContentGravity.ALL_LEFT, TunaContentGravity.CENTER_LEFT, TunaContentGravity.LEFT_CENTER};
    private static final int[] tunaContentTypeFaceArray = {0, 1, 2, 3};
    private static final TunaMaterial[] tunaMaterialArray = {TunaMaterial.SPREAD, TunaMaterial.TRANS};
    private static final TimeInterpolator[] tunaMaterialTimeInterpolatorArray = {new AccelerateDecelerateInterpolator(), new AccelerateInterpolator(), new AnticipateInterpolator(), new AnticipateOvershootInterpolator(), new BounceInterpolator(), new CycleInterpolator(0.0f), new DecelerateInterpolator(), new LinearInterpolator(), new OvershootInterpolator()};
    private static final PorterDuff.Mode[] tunaPorterDuffXfermodeArray = {PorterDuff.Mode.SRC_IN, PorterDuff.Mode.SRC_OUT};
    private static final TunaSelectType[] tunaSelectTypeArray = {TunaSelectType.NONE, TunaSelectType.SAME, TunaSelectType.REVERSE};
    protected static final int tunaStringBufferCapacity = 288;
    private static final TunaTextGravity[] tunaTextGravityArray = {TunaTextGravity.ALL_CENTER, TunaTextGravity.ALL_LEFT, TunaTextGravity.CENTER_LEFT, TunaTextGravity.LEFT_CENTER};
    private static final int[] tunaTextTypeFaceArray = {0, 1, 2, 3};
    private static final TunaTouchType[] tunaTouchTypeArray = {TunaTouchType.EDGE, TunaTouchType.ALWAYS, TunaTouchType.NONE};
    protected float displayDensity;
    protected int displayHeight;
    protected float displayScaledDensity;
    protected int displayWidth;
    protected float displayXdpi;
    protected float displayYdpi;
    private int touchDownCount;
    private long touchDownTimeEnd;
    private long touchDownTimeStart;
    protected Matrix tunaAnchorMatrix;
    protected TunaAnimateEndListener tunaAnimateEndListener;
    protected boolean tunaAnimationable;
    protected TunaAssociateListener tunaAssociateListener;
    /* access modifiers changed from: private */
    public int tunaBackgroundNormal;
    private int tunaBackgroundNormalAngle;
    private int tunaBackgroundNormalGradientEnd;
    private int tunaBackgroundNormalGradientStart;
    private Shader tunaBackgroundNormalShader;
    private int tunaBackgroundNormalShadowColor;
    private float tunaBackgroundNormalShadowDx;
    private float tunaBackgroundNormalShadowDy;
    private float tunaBackgroundNormalShadowRadius;
    /* access modifiers changed from: private */
    public int tunaBackgroundPress;
    private int tunaBackgroundPressAngle;
    private int tunaBackgroundPressGradientEnd;
    private int tunaBackgroundPressGradientStart;
    private Shader tunaBackgroundPressShader;
    private int tunaBackgroundPressShadowColor;
    private float tunaBackgroundPressShadowDx;
    private float tunaBackgroundPressShadowDy;
    private float tunaBackgroundPressShadowRadius;
    /* access modifiers changed from: private */
    public int tunaBackgroundSelect;
    private int tunaBackgroundSelectAngle;
    private int tunaBackgroundSelectGradientEnd;
    private int tunaBackgroundSelectGradientStart;
    private Shader tunaBackgroundSelectShader;
    private int tunaBackgroundSelectShadowColor;
    private float tunaBackgroundSelectShadowDx;
    private float tunaBackgroundSelectShadowDy;
    private float tunaBackgroundSelectShadowRadius;
    protected boolean tunaCanvasHardwareAccelerated;
    protected float tunaCenterX;
    protected float tunaCenterY;
    protected boolean tunaClassic;
    private int tunaContentColorNormal;
    private int tunaContentColorPress;
    private int tunaContentColorSelect;
    private float tunaContentDrawWidth;
    private float tunaContentDx;
    private float tunaContentDy;
    private float tunaContentEndOffsetCenterX;
    private float tunaContentEndOffsetCenterY;
    private float tunaContentFractionDx;
    private float tunaContentFractionDy;
    private TunaContentGravity tunaContentGravity;
    protected boolean tunaContentMark;
    private int tunaContentMarkColor;
    private float tunaContentMarkDx;
    private float tunaContentMarkDy;
    private float tunaContentMarkFractionDx;
    private float tunaContentMarkFractionDy;
    private float tunaContentMarkRadius;
    private int tunaContentMarkTextColor;
    private float tunaContentMarkTextSize;
    private String tunaContentMarkTextValue;
    private List<Integer> tunaContentMarkTextValueMeasureList;
    private boolean tunaContentMarkTouchable;
    private float tunaContentPaddingLeft;
    private float tunaContentPaddingRight;
    private float tunaContentRowSpaceRatio;
    private int tunaContentShadowColor;
    private float tunaContentShadowDx;
    private float tunaContentShadowDy;
    private float tunaContentShadowRadius;
    private float tunaContentSize;
    private Typeface tunaContentTypeFace;
    private String tunaContentValue;
    private List<Integer> tunaContentValueMeasureList;
    protected boolean tunaDebugable;
    protected TunaDrawListener tunaDrawListener;
    protected float tunaDx;
    protected float tunaDy;
    protected float[] tunaFloatArray;
    private int tunaForegroundNormal;
    private int tunaForegroundPress;
    private int tunaForegroundSelect;
    protected HashMap<String, Object> tunaGraphicsMap;
    protected int tunaHeight;
    protected boolean tunaIsHardwareAccelerated;
    protected int tunaLayer;
    protected LayoutInflater tunaLayoutInflater;
    protected TunaLayoutListener tunaLayoutListener;
    protected ViewGroup.LayoutParams tunaLayoutParams;
    protected Matrix tunaLeftMatrix;
    private TunaMaterial tunaMaterial;
    private AnimatorSet tunaMaterialAnimatorSet;
    private int tunaMaterialDuraction;
    private boolean tunaMaterialMove;
    private Property<TunaView, Float> tunaMaterialPaintXProperty;
    private Property<TunaView, Float> tunaMaterialPaintYProperty;
    /* access modifiers changed from: private */
    public boolean tunaMaterialPlay;
    /* access modifiers changed from: private */
    public float tunaMaterialRadius;
    private Property<TunaView, Float> tunaMaterialRadiusProperty;
    private TimeInterpolator tunaMaterialTimeInterpolator;
    protected Matrix tunaMatrix;
    protected Paint tunaPaint;
    private PaintFlagsDrawFilter tunaPaintFlagsDrawFilter;
    protected Path tunaPath;
    protected float tunaPercent;
    protected PorterDuffXfermode tunaPorterDuffXfermode;
    protected boolean tunaPress;
    protected View tunaPropertiesView;
    private float tunaRadius;
    private float tunaRadiusLeftBottom;
    private float tunaRadiusLeftTop;
    private float tunaRadiusRightBottom;
    private float tunaRadiusRightTop;
    protected Rect tunaRect;
    protected RectF tunaRectF;
    protected Matrix tunaRightMatrix;
    private int tunaRotate;
    protected float tunaScale;
    protected float tunaScaleSx;
    protected float tunaScaleSy;
    protected boolean tunaSelect;
    protected boolean tunaSelectRaw;
    private TunaSelectType tunaSelectType;
    protected float tunaShare;
    private int tunaSrcAnchorGravity;
    private Bitmap tunaSrcAnchorNormal;
    private float tunaSrcAnchorNormalDx;
    private float tunaSrcAnchorNormalDy;
    private float tunaSrcAnchorNormalHeight;
    private float tunaSrcAnchorNormalWidth;
    private Bitmap tunaSrcAnchorPress;
    private float tunaSrcAnchorPressDx;
    private float tunaSrcAnchorPressDy;
    private float tunaSrcAnchorPressHeight;
    private float tunaSrcAnchorPressWidth;
    private Bitmap tunaSrcAnchorSelect;
    private float tunaSrcAnchorSelectDx;
    private float tunaSrcAnchorSelectDy;
    private float tunaSrcAnchorSelectHeight;
    private float tunaSrcAnchorSelectWidth;
    protected Bitmap tunaSrcBitmap;
    protected float tunaSrcHeightScale;
    private Bitmap tunaSrcLeft;
    private float tunaSrcLeftDx;
    private float tunaSrcLeftDy;
    private float tunaSrcLeftHeight;
    private float tunaSrcLeftPadding;
    private float tunaSrcLeftWidth;
    private Bitmap tunaSrcNormal;
    private float tunaSrcNormalShadowDx;
    private float tunaSrcNormalShadowDy;
    private float tunaSrcNormalShadowRadius;
    private Bitmap tunaSrcPress;
    private float tunaSrcPressShadowDx;
    private float tunaSrcPressShadowDy;
    private float tunaSrcPressShadowRadius;
    private Bitmap tunaSrcRight;
    private float tunaSrcRightDx;
    private float tunaSrcRightDy;
    private float tunaSrcRightHeight;
    private float tunaSrcRightPadding;
    private float tunaSrcRightWidth;
    private Bitmap tunaSrcSelect;
    private float tunaSrcSelectShadowDx;
    private float tunaSrcSelectShadowDy;
    private float tunaSrcSelectShadowRadius;
    protected float tunaSrcWidthScale;
    protected String[] tunaStringArray;
    protected StringBuffer tunaStringBuffer;
    /* access modifiers changed from: private */
    public int tunaStrokeColorNormal;
    private int tunaStrokeColorPress;
    private int tunaStrokeColorSelect;
    /* access modifiers changed from: private */
    public float tunaStrokeWidthNormal;
    private float tunaStrokeWidthPress;
    private float tunaStrokeWidthSelect;
    protected TunaSubAnimateEndListener tunaSubAnimateEndListener;
    protected TunaSubDrawListener tunaSubDrawListener;
    protected TunaSubLayoutListener tunaSubLayoutListener;
    private boolean tunaSuper;
    protected float tunaSurplus;
    protected String tunaTag;
    /* access modifiers changed from: private */
    public int tunaTextColorNormal;
    private int tunaTextColorPress;
    private int tunaTextColorSelect;
    private float tunaTextDrawWidth;
    private float tunaTextDx;
    private float tunaTextDy;
    private float tunaTextEndOffsetCenterX;
    private float tunaTextEndOffsetCenterY;
    private float tunaTextFractionDx;
    private float tunaTextFractionDy;
    private TunaTextGravity tunaTextGravity;
    protected boolean tunaTextMark;
    private int tunaTextMarkColor;
    private float tunaTextMarkDx;
    private float tunaTextMarkDy;
    private float tunaTextMarkFractionDx;
    private float tunaTextMarkFractionDy;
    private float tunaTextMarkRadius;
    private int tunaTextMarkTextColor;
    private float tunaTextMarkTextSize;
    private String tunaTextMarkTextValue;
    private List<Integer> tunaTextMarkTextValueMeasureList;
    private boolean tunaTextMarkTouchable;
    private float tunaTextPaddingLeft;
    private float tunaTextPaddingRight;
    private float tunaTextRowSpaceRatio;
    private int tunaTextShadowColor;
    private float tunaTextShadowDx;
    private float tunaTextShadowDy;
    private float tunaTextShadowRadius;
    /* access modifiers changed from: private */
    public float tunaTextSize;
    private Typeface tunaTextTypeFace;
    private String tunaTextValue;
    private List<Integer> tunaTextValueMeasureList;
    protected int tunaTotal;
    protected TunaTouchCancelListener tunaTouchCancelListener;
    /* access modifiers changed from: private */
    public float tunaTouchDownEventX;
    /* access modifiers changed from: private */
    public float tunaTouchDownEventY;
    protected TunaTouchDownListener tunaTouchDownListener;
    protected float tunaTouchEventX;
    protected float tunaTouchEventY;
    protected TunaTouchInListener tunaTouchInListener;
    protected TunaTouchListener tunaTouchListener;
    protected TunaTouchMoveListener tunaTouchMoveListener;
    protected boolean tunaTouchOutBounds;
    protected TunaTouchOutListener tunaTouchOutListener;
    private TunaTouchType tunaTouchType;
    protected TunaTouchUpListener tunaTouchUpListener;
    protected int tunaWidth;

    public interface TunaAnimateEndListener {
        void tunaAnimateEnd(View view);
    }

    public interface TunaAssociateListener {
        void tunaAssociate(View view);
    }

    public interface TunaDrawListener {
        void tunaDraw(View view);
    }

    public interface TunaLayoutListener {
        void tunaLayout(View view);
    }

    public interface TunaSubAnimateEndListener {
        void tunaSubAnimateEnd(View view);
    }

    public interface TunaSubDrawListener {
        void tunaSubDraw(View view);
    }

    public interface TunaSubLayoutListener {
        void tunaSubLayout(View view);
    }

    public interface TunaTouchCancelListener {
        void tunaTouchCancel(View view);
    }

    public interface TunaTouchDownListener {
        void tunaTouchDown(View view);
    }

    public interface TunaTouchInListener {
        void tunaTouchIn(View view);
    }

    public interface TunaTouchListener {
        void tunaTouch(View view);
    }

    public interface TunaTouchMoveListener {
        void tunaTouchMove(View view);
    }

    public interface TunaTouchOutListener {
        void tunaTouchOut(View view);
    }

    public interface TunaTouchUpListener {
        void tunaTouchUp(View view);
    }

    public static String getDeviceMac(Context context) {
        return "";
    }

    public static class DeviceInfo {
        public String IMSI;
        public String deviceDensity;
        public String deviceHeight;
        public String deviceId;
        public String deviceMac;
        public String deviceManufacturer;
        public String deviceModel;
        public String deviceRelease;
        public String deviceSDK;
        public String deviceScaledDensity;
        public String deviceWidth;
        public String deviceXdpi;
        public String deviceYdpi;
        public String line1Number;
        public List neighboringCellInfo;
        public String networkCountryIso;
        public String networkOperator;
        public String networkOperatorName;
        public String networkType;
        public String operators;
        public int phoneType;
        public String simCountryIso;
        public String simOperator;
        public String simOperatorName;
        public String simSerialNumber;
        public String subscriberId;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("deviceId[");
            stringBuffer.append(this.deviceId + Const.jaRight);
            stringBuffer.append("\ndeviceMac[");
            stringBuffer.append(this.deviceMac + Const.jaRight);
            stringBuffer.append("\ndeviceManufacturer[");
            stringBuffer.append(this.deviceManufacturer + Const.jaRight);
            stringBuffer.append("\ndeviceModel[");
            stringBuffer.append(this.deviceModel + Const.jaRight);
            stringBuffer.append("\ndeviceRelease[");
            stringBuffer.append(this.deviceRelease + Const.jaRight);
            stringBuffer.append("\ndeviceSDK[");
            stringBuffer.append(this.deviceSDK + Const.jaRight);
            stringBuffer.append("\ndeviceWidth[");
            stringBuffer.append(this.deviceWidth + Const.jaRight);
            stringBuffer.append("\ndeviceHeight[");
            stringBuffer.append(this.deviceHeight + Const.jaRight);
            stringBuffer.append("\ndeviceDensity[");
            stringBuffer.append(this.deviceDensity + Const.jaRight);
            stringBuffer.append("\ndeviceScaledDensity[");
            stringBuffer.append(this.deviceScaledDensity + Const.jaRight);
            stringBuffer.append("\ndeviceXdpi[");
            stringBuffer.append(this.deviceXdpi + Const.jaRight);
            stringBuffer.append("\ndeviceYdpi[");
            stringBuffer.append(this.deviceYdpi + Const.jaRight);
            stringBuffer.append("\nIMSI[");
            stringBuffer.append(this.IMSI + Const.jaRight);
            stringBuffer.append("\noperators[");
            stringBuffer.append(this.operators + Const.jaRight);
            stringBuffer.append("\nline1Number[");
            stringBuffer.append(this.line1Number + Const.jaRight);
            stringBuffer.append("\nnetworkOperatorName[");
            stringBuffer.append(this.networkOperatorName + Const.jaRight);
            stringBuffer.append("\nnetworkOperator[");
            stringBuffer.append(this.networkOperator + Const.jaRight);
            stringBuffer.append("\nnetworkCountryIso[");
            stringBuffer.append(this.networkCountryIso + Const.jaRight);
            stringBuffer.append("\nsimCountryIso[");
            stringBuffer.append(this.simCountryIso + Const.jaRight);
            stringBuffer.append("\nsimOperator[");
            stringBuffer.append(this.simOperator + Const.jaRight);
            stringBuffer.append("\nsimOperatorName[");
            stringBuffer.append(this.simOperatorName + Const.jaRight);
            stringBuffer.append("\nsimSerialNumber[");
            stringBuffer.append(this.simSerialNumber + Const.jaRight);
            stringBuffer.append("\nsubscriberId[");
            stringBuffer.append(this.subscriberId + Const.jaRight);
            stringBuffer.append("\nneighboringCellInfo[");
            stringBuffer.append(this.neighboringCellInfo + Const.jaRight);
            stringBuffer.append("\nphoneType[");
            stringBuffer.append(this.phoneType + Const.jaRight);
            stringBuffer.append("\nnetworkType[");
            stringBuffer.append(this.networkType + Const.jaRight);
            return stringBuffer.toString();
        }
    }

    public static String getDeviceManufacturer(Context context) {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceRelease() {
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceSDK() {
        return Build.VERSION.SDK;
    }

    public static int getDeviceWidth(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return displayMetrics.widthPixels;
    }

    public static int getDeviceHeight(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return displayMetrics.heightPixels;
    }

    public static String getDeviceDensity(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return String.valueOf(displayMetrics.density);
    }

    public static String getDeviceScaledDensity(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return String.valueOf(displayMetrics.scaledDensity);
    }

    public static String getDeviceXdpi(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return String.valueOf(displayMetrics.xdpi);
    }

    public static String getDeviceYdpi(Context context) {
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        return String.valueOf(displayMetrics.ydpi);
    }

    public static String getOperators(Context context, String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("46000") || str.startsWith("46002")) {
            return context.getResources().getString(R.string.network_operator_cmcc);
        }
        if (str.startsWith("46001")) {
            return context.getResources().getString(R.string.network_operator_cucc);
        }
        if (str.startsWith("46003")) {
            return context.getResources().getString(R.string.network_operator_ctcc);
        }
        return null;
    }

    public static String getNetworkOperatorName(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static String getNetworkOperator(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getNetworkOperator();
    }

    public static String getNetworkCountryIso(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getNetworkCountryIso();
    }

    public static String getSimCountryIso(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getSimCountryIso();
    }

    public static String getSimOperator(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getSimOperator();
    }

    public static String getSimOperatorName(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getSimOperatorName();
    }

    public static int getPhoneType(Context context) {
        if (telephonyManager == null) {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return telephonyManager.getPhoneType();
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return "3G";
                        }
                        return subtypeName;
                }
            }
        }
        return "null";
    }

    public static String getMemoryInfo() {
        StringBuffer stringBuffer = new StringBuffer(28);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static float convertToPX(float f, Activity activity) {
        return convertToPX(f, 1, activity);
    }

    public static float convertToPX(float f, int i, Activity activity) {
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        return applyDimension(i, f, displayMetrics2);
    }

    public static float convertToPX(float f, View view) {
        return convertToPX(f, 1, view);
    }

    public static float convertToPX(float f, int i, View view) {
        return applyDimension(i, f, getViewDisplayMetrics(view));
    }

    public static float applyDimension(int i, float f, DisplayMetrics displayMetrics2) {
        float f2;
        if (i == 0) {
            return f;
        }
        if (i == 1) {
            f2 = displayMetrics2.density;
        } else if (i == 2) {
            f2 = displayMetrics2.scaledDensity;
        } else if (i == 3) {
            f *= displayMetrics2.xdpi;
            f2 = 0.013888889f;
        } else if (i == 4) {
            f2 = displayMetrics2.xdpi;
        } else if (i != 5) {
            return 0.0f;
        } else {
            f *= displayMetrics2.xdpi;
            f2 = 0.03937008f;
        }
        return f * f2;
    }

    public static Resources getViewResources(View view) {
        Context context = view.getContext();
        if (context == null) {
            return Resources.getSystem();
        }
        return context.getResources();
    }

    public static DisplayMetrics getViewDisplayMetrics(View view) {
        return getViewResources(view).getDisplayMetrics();
    }

    public static void setViewMargins(View view, int i, int i2, int i3, int i4) {
        setViewMargins(view, 1, i, i2, i3, i4);
    }

    public static void setViewMargins(View view, int i, int i2, int i3, int i4, int i5) {
        DisplayMetrics viewDisplayMetrics = getViewDisplayMetrics(view);
        setViewMarginsRaw(view, (int) applyDimension(i, (float) i2, viewDisplayMetrics), (int) applyDimension(i, (float) i3, viewDisplayMetrics), (int) applyDimension(i, (float) i4, viewDisplayMetrics), (int) applyDimension(i, (float) i5, viewDisplayMetrics));
    }

    private static void setViewMarginsRaw(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(i);
                marginLayoutParams.setMarginEnd(i3);
            }
            view.requestLayout();
        }
    }

    public static int getScreenWidth(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getHeight();
    }

    public static float getScreenDensity(Context context) {
        new DisplayMetrics();
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getLocationOnScreenX(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public static int getLocationOnScreenY(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static int getLocationInWindowX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    public static int getLocationInWindowY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int getTitleBarHeight(Activity activity) {
        return activity.getWindow().findViewById(16908290).getTop() - getStatusBarHeight(activity);
    }

    public static void setLayoutByWidth(View view, float f) {
        setLayoutByWidth(view, 1, f);
    }

    public static void setLayoutByWidth(View view, int i, float f) {
        setLayoutByWidthRaw(view, applyDimension(i, f, getViewDisplayMetrics(view)));
    }

    public static void setLayoutByWidthRaw(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f;
        view.setLayoutParams(layoutParams);
    }

    public static void setLayoutByHeight(View view, float f) {
        setLayoutByHeight(view, 1, f);
    }

    public static void setLayoutByHeight(View view, int i, float f) {
        setLayoutByHeightRaw(view, applyDimension(i, f, getViewDisplayMetrics(view)));
    }

    public static void setLayoutByHeightRaw(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) f;
        view.setLayoutParams(layoutParams);
    }

    public static void setLayout(View view, float f, float f2) {
        setLayout(view, 1, f, f2);
    }

    public static void setLayout(View view, int i, float f, float f2) {
        DisplayMetrics viewDisplayMetrics = getViewDisplayMetrics(view);
        setLayoutRaw(view, applyDimension(i, f, viewDisplayMetrics), applyDimension(i, f2, viewDisplayMetrics));
    }

    private static void setLayoutRaw(View view, float f, float f2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f;
        layoutParams.height = (int) f2;
        view.setLayoutParams(layoutParams);
    }

    public static void adjustViewHeightByWidth(final View view, final float f) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) (((float) view.getWidth()) / f);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public static void adjustViewWidthByHeight(final View view, final float f) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = (int) (((float) view.getHeight()) * f);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public static void adjustViewWidthByView(final View view, final View view2) {
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width = view2.getWidth();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = width;
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public static void adjustViewHeightByView(final View view, final View view2) {
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int height = view2.getHeight();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = height;
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public static void adjustViewByView(final View view, final View view2) {
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width = view2.getWidth();
                int height = view2.getHeight();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = height;
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public static void adaptViewAutomatic(View view, int i, int i2, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float f2 = (float) i;
        float f3 = (float) i2;
        if ((1.0f * f2) / f3 >= f) {
            layoutParams.height = i2;
            layoutParams.width = (int) (f3 * f);
        } else {
            layoutParams.width = i;
            layoutParams.height = (int) (f2 / f);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void fillViewAutomatic(View view, int i, int i2, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float f2 = (float) i;
        float f3 = (float) i2;
        if ((1.0f * f2) / f3 >= f) {
            layoutParams.width = i;
            layoutParams.height = (int) (f2 / f);
        } else {
            layoutParams.height = i2;
            layoutParams.width = (int) (f3 * f);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void keepListViewLocation(ListView listView) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i = 0;
        View childAt = listView.getChildAt(0);
        if (childAt != null) {
            i = childAt.getTop();
        }
        listView.setSelectionFromTop(firstVisiblePosition + 1, i);
    }

    public static LinearGradient getLinearGradient(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        if (i3 % 45 == 0) {
            int i8 = (i3 / 45) % 8;
            if (i8 < 0) {
                i8 += 8;
            }
            switch (i8) {
                case 0:
                    return new LinearGradient(0.0f, 0.0f, (float) i6, 0.0f, i4, i5, Shader.TileMode.CLAMP);
                case 1:
                    return new LinearGradient(0.0f, (float) i7, (float) i6, 0.0f, i4, i5, Shader.TileMode.CLAMP);
                case 2:
                    return new LinearGradient(0.0f, (float) i7, 0.0f, 0.0f, i4, i5, Shader.TileMode.CLAMP);
                case 3:
                    return new LinearGradient((float) i6, (float) i7, 0.0f, 0.0f, i4, i5, Shader.TileMode.CLAMP);
                case 4:
                    return new LinearGradient((float) i6, 0.0f, 0.0f, 0.0f, i4, i5, Shader.TileMode.CLAMP);
                case 5:
                    return new LinearGradient((float) i6, 0.0f, 0.0f, (float) i7, i4, i5, Shader.TileMode.CLAMP);
                case 6:
                    return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i7, i4, i5, Shader.TileMode.CLAMP);
                case 7:
                    return new LinearGradient(0.0f, 0.0f, (float) i6, (float) i7, i4, i5, Shader.TileMode.CLAMP);
                default:
                    return null;
            }
        } else {
            throw new IndexOutOfBoundsException("Angle value must be a multiple of 45");
        }
    }

    public static Bitmap getCustomRoundBitmap(Bitmap bitmap, float f, float f2, float f3, float f4) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{f, f, f3, f3, f4, f4, f2, f2}, Path.Direction.CW);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap getClassicRoundBitmap(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap getScaleBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public static Bitmap getAlphaBitmap(Bitmap bitmap, float f) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = (int) (f * 255.0f);
        for (int i2 = 0; i2 < width; i2++) {
            if (iArr[i2] != 0) {
                iArr[i2] = (i << 24) | (iArr[i2] & 16777215);
            } else {
                iArr[i2] = 0;
            }
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getRotateBitamp(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f, (float) (width >> 1), (float) (height >> 1));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap getReverseBitmap(Bitmap bitmap, int i) {
        float[] fArr = i != 0 ? i != 1 ? null : new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f} : new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        if (fArr == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap getSepiaBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = 0;
        while (i < height) {
            int i2 = 0;
            while (i2 < width) {
                int i3 = (width * i) + i2;
                int i4 = iArr[i3];
                int red = Color.red(i4);
                double d = (double) red;
                double green = (double) Color.green(i4);
                int i5 = i;
                double blue = (double) Color.blue(i4);
                int i6 = (int) ((0.393d * d) + (0.769d * green) + (0.189d * blue));
                int i7 = (int) ((0.349d * d) + (0.686d * green) + (0.168d * blue));
                int i8 = (int) ((d * 0.272d) + (green * 0.534d) + (blue * 0.131d));
                if (i6 > 255) {
                    i6 = 255;
                }
                if (i7 > 255) {
                    i7 = 255;
                }
                if (i8 > 255) {
                    i8 = 255;
                }
                iArr[i3] = Color.argb(255, i6, i7, i8);
                i2++;
                i = i5;
            }
            i++;
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap getEmbossBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = height - 1;
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = width - 1;
            for (int i4 = 1; i4 < i3; i4++) {
                int i5 = (i2 * width) + i4;
                int i6 = iArr[i5];
                int red = Color.red(i6);
                int green = Color.green(i6);
                int blue = Color.blue(i6);
                int i7 = iArr[i5 + 1];
                iArr[i5] = Color.argb(255, Math.min(255, Math.max(0, (Color.red(i7) - red) + 127)), Math.min(255, Math.max(0, (Color.green(i7) - green) + 127)), Math.min(255, Math.max(0, (Color.blue(i7) - blue) + 127)));
            }
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap getBacksheetBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = height - 1;
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = width - 1;
            for (int i4 = 1; i4 < i3; i4++) {
                int i5 = (i2 * width) + i4;
                int i6 = iArr[i5];
                iArr[i5] = Color.argb(255, Math.min(255, Math.max(0, 255 - Color.red(i6))), Math.min(255, Math.max(0, 255 - Color.green(i6))), Math.min(255, Math.max(0, 255 - Color.blue(i6))));
            }
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap getSunshineBitmap(Bitmap bitmap, float f, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        float min = Math.min(f, f2);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = height - 1;
        int i2 = 1;
        while (i2 < i) {
            int i3 = width - 1;
            int i4 = 1;
            while (i4 < i3) {
                int i5 = (i2 * width) + i4;
                int i6 = iArr[i5];
                int red = Color.red(i6);
                int green = Color.green(i6);
                int blue = Color.blue(i6);
                int i7 = i2;
                int i8 = width;
                int i9 = height;
                int pow = (int) (Math.pow((double) (f2 - ((float) i2)), 2.0d) + Math.pow((double) (f - ((float) i4)), 2.0d));
                if (((float) pow) < min * min) {
                    int sqrt = (int) ((1.0d - (Math.sqrt((double) pow) / ((double) min))) * 150.0d);
                    red += sqrt;
                    green += sqrt;
                    blue += sqrt;
                }
                iArr[i5] = Color.argb(255, Math.min(255, Math.max(0, red)), Math.min(255, Math.max(0, green)), Math.min(255, Math.max(0, blue)));
                i4++;
                i2 = i7;
                width = i8;
                height = i9;
            }
            int i10 = width;
            int i11 = height;
            i2++;
        }
        int i12 = width;
        createBitmap.setPixels(iArr, 0, i12, 0, 0, i12, height);
        return createBitmap;
    }

    public static Bitmap getSketchBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = (i2 * width) + i3;
                iArr[i4] = ((Color.red(iArr[i4]) + Color.green(iArr[i4])) + Color.blue(iArr[i4])) / 3;
                iArr2[i4] = 255 - iArr[i4];
            }
        }
        gaussGray(iArr2, 5.0d, 5.0d, width, height);
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                int i7 = (i5 * width) + i6;
                int min = Math.min((iArr[i7] << 8) / (256 - iArr2[i7]), 255);
                iArr[i7] = Color.rgb(min, min, min);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private static int gaussGray(int[] iArr, double d, double d2, int i, int i2) {
        int i3;
        double[] dArr;
        double[] dArr2;
        double[] dArr3;
        double[] dArr4;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        double d3;
        int[] iArr5;
        int i4;
        int i5 = i;
        int i6 = i2;
        int max = Math.max(i, i2);
        double[] dArr5 = new double[max];
        double[] dArr6 = new double[max];
        double[] dArr7 = new double[5];
        double[] dArr8 = new double[5];
        double[] dArr9 = new double[5];
        double[] dArr10 = new double[5];
        double[] dArr11 = new double[5];
        double[] dArr12 = new double[5];
        int[] iArr6 = new int[max];
        int[] iArr7 = new int[max];
        int[] iArr8 = new int[4];
        int[] iArr9 = new int[4];
        if (d2 > 0.0d) {
            d3 = Math.abs(d2) + 1.0d;
            int[] iArr10 = iArr7;
            iArr4 = iArr9;
            iArr3 = iArr8;
            int i7 = 4;
            iArr2 = iArr6;
            dArr4 = dArr11;
            dArr3 = dArr9;
            dArr2 = dArr10;
            findConstants(dArr7, dArr8, dArr9, dArr10, dArr11, dArr12, Math.sqrt((-(d3 * d3)) / (Math.log(0.00392156862745098d) * 2.0d)));
            int i8 = 0;
            while (i8 < i5) {
                for (int i9 = 0; i9 < max; i9++) {
                    dArr5[i9] = 0.0d;
                    dArr6[i9] = 0.0d;
                }
                int i10 = i2;
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr2[i11] = iArr[(i11 * i5) + i8];
                }
                int i12 = i10 - 1;
                iArr3[0] = iArr2[0];
                iArr4[0] = iArr2[i12];
                int i13 = i12;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (i14 < i10) {
                    int i17 = i14 < i7 ? i14 : 4;
                    int i18 = 0;
                    while (i18 <= i17) {
                        dArr5[i15] = dArr5[i15] + ((dArr7[i18] * ((double) iArr2[i16 - i18])) - (dArr3[i18] * dArr5[i15 - i18]));
                        dArr6[i12] = dArr6[i12] + ((dArr8[i18] * ((double) iArr2[i13 + i18])) - (dArr2[i18] * dArr6[i12 + i18]));
                        i18++;
                        i17 = i17;
                        i13 = i13;
                        int i19 = i2;
                        i14 = i14;
                        max = max;
                    }
                    int i20 = max;
                    int i21 = i13;
                    int i22 = i14;
                    while (i18 <= 4) {
                        double[] dArr13 = dArr12;
                        dArr5[i15] = dArr5[i15] + ((dArr7[i18] - dArr4[i18]) * ((double) iArr3[0]));
                        dArr6[i12] = dArr6[i12] + ((dArr8[i18] - dArr13[i18]) * ((double) iArr4[0]));
                        i18++;
                        dArr12 = dArr13;
                        i8 = i8;
                    }
                    double[] dArr14 = dArr12;
                    int i23 = i8;
                    i16++;
                    i13 = i21 - 1;
                    i15++;
                    i12--;
                    i14 = i22 + 1;
                    i10 = i2;
                    max = i20;
                    i7 = 4;
                }
                int i24 = max;
                double[] dArr15 = dArr12;
                int i25 = i8;
                int i26 = i10;
                int[] iArr11 = iArr10;
                transferGaussPixels(dArr5, dArr6, iArr11, 1, i26);
                for (int i27 = 0; i27 < i26; i27++) {
                    iArr[(i27 * i5) + i25] = iArr11[i27];
                }
                i8 = i25 + 1;
                iArr10 = iArr11;
                dArr12 = dArr15;
                max = i24;
                i7 = 4;
            }
            i4 = i2;
            i3 = max;
            dArr = dArr12;
            iArr5 = iArr10;
        } else {
            i4 = i2;
            i3 = max;
            dArr = dArr12;
            iArr4 = iArr9;
            iArr3 = iArr8;
            iArr5 = iArr7;
            iArr2 = iArr6;
            dArr4 = dArr11;
            dArr3 = dArr9;
            dArr2 = dArr10;
            d3 = d2;
        }
        if (d > 0.0d) {
            double abs = Math.abs(d) + 1.0d;
            if (abs != d3) {
                findConstants(dArr7, dArr8, dArr3, dArr2, dArr4, dArr, Math.sqrt((-(abs * abs)) / (Math.log(0.00392156862745098d) * 2.0d)));
            }
            int i28 = 0;
            while (i28 < i4) {
                int i29 = i3;
                for (int i30 = 0; i30 < i29; i30++) {
                    dArr5[i30] = 0.0d;
                    dArr6[i30] = 0.0d;
                }
                for (int i31 = 0; i31 < i5; i31++) {
                    iArr2[i31] = iArr[(i28 * i5) + i31];
                }
                int i32 = i5 - 1;
                iArr3[0] = iArr2[0];
                iArr4[0] = iArr2[i32];
                int i33 = i32;
                int i34 = i33;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                while (i35 < i5) {
                    int i38 = i35 < 4 ? i35 : 4;
                    int i39 = 0;
                    while (i39 <= i38) {
                        dArr5[i36] = dArr5[i36] + ((dArr7[i39] * ((double) iArr2[i37 - i39])) - (dArr3[i39] * dArr5[i36 - i39]));
                        dArr6[i33] = dArr6[i33] + ((dArr8[i39] * ((double) iArr2[i34 + i39])) - (dArr2[i39] * dArr6[i33 + i39]));
                        i39++;
                        int i40 = i;
                        int i41 = i2;
                        i28 = i28;
                        i29 = i29;
                    }
                    int i42 = i28;
                    int i43 = i29;
                    while (i39 <= 4) {
                        dArr5[i36] = dArr5[i36] + ((dArr7[i39] - dArr4[i39]) * ((double) iArr3[0]));
                        dArr6[i33] = dArr6[i33] + ((dArr8[i39] - dArr[i39]) * ((double) iArr4[0]));
                        i39++;
                        dArr7 = dArr7;
                    }
                    double[] dArr16 = dArr7;
                    i37++;
                    i34--;
                    i36++;
                    i33--;
                    i35++;
                    i5 = i;
                    int i44 = i2;
                    i28 = i42;
                    i29 = i43;
                }
                int i45 = i28;
                i3 = i29;
                double[] dArr17 = dArr7;
                transferGaussPixels(dArr5, dArr6, iArr5, 1, i5);
                for (int i46 = 0; i46 < i5; i46++) {
                    iArr[(i45 * i5) + i46] = iArr5[i46];
                }
                i28 = i45 + 1;
                i4 = i2;
                dArr7 = dArr17;
            }
        }
        return 0;
    }

    private static void findConstants(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, double d) {
        double sqrt = Math.sqrt(6.283186d) * d;
        double d2 = -1.783d / d;
        double d3 = -1.723d / d;
        double d4 = 0.6318d / d;
        double d5 = 1.997d / d;
        double d6 = 1.6803d / sqrt;
        double d7 = 3.735d / sqrt;
        double d8 = -0.6803d / sqrt;
        double d9 = -0.2598d / sqrt;
        double d10 = d6 + d8;
        dArr[0] = d10;
        dArr[1] = (Math.exp(d3) * ((Math.sin(d5) * d9) - ((d8 + (d6 * 2.0d)) * Math.cos(d5)))) + (Math.exp(d2) * ((Math.sin(d4) * d7) - (((d8 * 2.0d) + d6) * Math.cos(d4))));
        double d11 = d2 + d3;
        double exp = Math.exp(d11) * 2.0d * ((((d10 * Math.cos(d5)) * Math.cos(d4)) - ((Math.cos(d5) * d7) * Math.sin(d4))) - ((Math.cos(d4) * d9) * Math.sin(d5)));
        double d12 = d2 * 2.0d;
        double d13 = d3 * 2.0d;
        dArr[2] = exp + (Math.exp(d12) * d8) + (Math.exp(d13) * d6);
        double d14 = d3 + d12;
        double d15 = d2 + d13;
        dArr[3] = (Math.exp(d14) * ((d9 * Math.sin(d5)) - (d8 * Math.cos(d5)))) + (Math.exp(d15) * ((d7 * Math.sin(d4)) - (d6 * Math.cos(d4))));
        double d16 = 0.0d;
        dArr[4] = 0.0d;
        dArr3[0] = 0.0d;
        dArr3[1] = ((Math.exp(d3) * -2.0d) * Math.cos(d5)) - ((Math.exp(d2) * 2.0d) * Math.cos(d4));
        dArr3[2] = (Math.cos(d5) * 4.0d * Math.cos(d4) * Math.exp(d11)) + Math.exp(d13) + Math.exp(d12);
        dArr3[3] = ((Math.cos(d4) * -2.0d) * Math.exp(d15)) - ((Math.cos(d5) * 2.0d) * Math.exp(d14));
        dArr3[4] = Math.exp(d12 + d13);
        for (int i = 0; i <= 4; i++) {
            dArr4[i] = dArr3[i];
        }
        dArr2[0] = 0.0d;
        for (int i2 = 1; i2 <= 4; i2++) {
            dArr2[i2] = dArr[i2] - (dArr3[i2] * dArr[0]);
        }
        double d17 = 0.0d;
        double d18 = 0.0d;
        for (int i3 = 0; i3 <= 4; i3++) {
            d16 += dArr[i3];
            d18 += dArr2[i3];
            d17 += dArr3[i3];
        }
        double d19 = d17 + 1.0d;
        double d20 = d16 / d19;
        double d21 = d18 / d19;
        for (int i4 = 0; i4 <= 4; i4++) {
            dArr5[i4] = dArr3[i4] * d20;
            dArr6[i4] = dArr4[i4] * d21;
        }
    }

    private static void transferGaussPixels(double[] dArr, double[] dArr2, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int i8 = i5 + 1;
            double d = dArr[i5];
            int i9 = i6 + 1;
            double d2 = d + dArr2[i6];
            if (d2 > 255.0d) {
                d2 = 255.0d;
            } else if (d2 < 0.0d) {
                d2 = 0.0d;
            }
            iArr[i7] = (int) d2;
            i4++;
            i7++;
            i6 = i9;
            i5 = i8;
        }
    }

    public static Bitmap processBitmap(Bitmap bitmap, float f, float f2, float f3) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.reset();
        ColorMatrix colorMatrix3 = new ColorMatrix();
        colorMatrix3.reset();
        ColorMatrix colorMatrix4 = new ColorMatrix();
        colorMatrix4.reset();
        colorMatrix.setRotate(0, f);
        colorMatrix.setRotate(1, f);
        colorMatrix.setRotate(2, f);
        colorMatrix2.setScale(f2, f2, f2, 1.0f);
        colorMatrix3.setSaturation(f3);
        colorMatrix4.postConcat(colorMatrix2);
        colorMatrix4.postConcat(colorMatrix3);
        colorMatrix4.postConcat(colorMatrix);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static String getGraphicsType(File file) {
        byte[] bArr = new byte[10];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read != 10) {
                return "UNKNOWN";
            }
            byte b = bArr[0];
            byte b2 = bArr[1];
            byte b3 = bArr[2];
            byte b4 = bArr[3];
            byte b5 = bArr[6];
            byte b6 = bArr[7];
            byte b7 = bArr[8];
            byte b8 = bArr[9];
            if (b == 71 && b2 == 73 && b3 == 70) {
                return GRAPHICSTYPE_GIF;
            }
            if (b2 == 80 && b3 == 78 && b4 == 71) {
                return GRAPHICSTYPE_PNG;
            }
            if (b5 == 74 && b6 == 70 && b7 == 73 && b8 == 70) {
                return GRAPHICSTYPE_JPG;
            }
            return "UNKNOWN";
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getGraphicsType(String str) {
        byte[] bArr = new byte[10];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read != 10) {
                return "UNKNOWN";
            }
            byte b = bArr[0];
            byte b2 = bArr[1];
            byte b3 = bArr[2];
            byte b4 = bArr[3];
            byte b5 = bArr[6];
            byte b6 = bArr[7];
            byte b7 = bArr[8];
            byte b8 = bArr[9];
            if (b == 71 && b2 == 73 && b3 == 70) {
                return GRAPHICSTYPE_GIF;
            }
            if (b2 == 80 && b3 == 78 && b4 == 71) {
                return GRAPHICSTYPE_PNG;
            }
            if (b5 == 74 && b6 == 70 && b7 == 73 && b8 == 70) {
                return GRAPHICSTYPE_JPG;
            }
            return "UNKNOWN";
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public Bitmap decodeBitmapResource(int i) {
        return decodeBitmapResource(i, 1);
    }

    public Bitmap decodeBitmapResource(int i, int i2) {
        Bitmap bitmap;
        Object obj;
        String valueOf = String.valueOf(i);
        if (this.tunaGraphicsMap.containsKey(valueOf) && (obj = this.tunaGraphicsMap.get(valueOf)) != null && (obj instanceof Bitmap)) {
            return (Bitmap) obj;
        }
        if (i2 > 1) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i2;
            bitmap = BitmapFactory.decodeResource(getResources(), i, options);
        } else {
            bitmap = BitmapFactory.decodeResource(getResources(), i);
        }
        this.tunaGraphicsMap.put(valueOf, bitmap);
        return bitmap;
    }

    public Movie decodeGifResource(int i) {
        Object obj;
        String valueOf = String.valueOf(i);
        if (!this.tunaGraphicsMap.containsKey(valueOf) || (obj = this.tunaGraphicsMap.get(valueOf)) == null || !(obj instanceof Movie)) {
            return Movie.decodeStream(getResources().openRawResource(i));
        }
        return (Movie) obj;
    }

    public Object decodeGraphicsResource(int i) {
        return decodeGraphicsResource(i, 1);
    }

    public Object decodeGraphicsResource(int i, int i2) {
        Object obj;
        String valueOf = String.valueOf(i);
        if (this.tunaGraphicsMap.containsKey(valueOf) && (obj = this.tunaGraphicsMap.get(valueOf)) != null) {
            return obj;
        }
        Movie decodeGifResource = decodeGifResource(i);
        if (decodeGifResource != null) {
            return decodeGifResource;
        }
        return decodeBitmapResource(i, i2);
    }

    public Bitmap decodeBitmapFile(String str) {
        return decodeBitmapFile(str, 0, 0);
    }

    public Bitmap decodeBitmapFile(String str, int i, int i2) {
        Bitmap bitmap;
        Object obj;
        if (this.tunaGraphicsMap.containsKey(str) && (obj = this.tunaGraphicsMap.get(str)) != null && (obj instanceof Bitmap)) {
            return (Bitmap) obj;
        }
        if (i == 0 || i2 == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth * options.outHeight;
            int i4 = bitmapMaxSize;
            if (i3 > i4) {
                options.inSampleSize = (int) Math.ceil((double) (i3 / i4));
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeFile(str, options);
            } else {
                bitmap = BitmapFactory.decodeFile(str);
            }
        } else {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options2);
            options2.inSampleSize = computeSampleSize(options2, -1, i * i2);
            options2.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options2);
        }
        this.tunaGraphicsMap.put(str, bitmap);
        return bitmap;
    }

    public Movie decodeGifFile(String str) {
        Object obj;
        if (!this.tunaGraphicsMap.containsKey(str) || (obj = this.tunaGraphicsMap.get(str)) == null || !(obj instanceof Movie)) {
            return Movie.decodeFile(str);
        }
        return (Movie) obj;
    }

    public Object decodeGraphicsFile(String str) {
        Object obj;
        if (this.tunaGraphicsMap.containsKey(str) && (obj = this.tunaGraphicsMap.get(str)) != null) {
            return obj;
        }
        Movie decodeFile = Movie.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        return decodeBitmapFile(str);
    }

    public Object decodeGraphicsFile(String str, int i, int i2) {
        Object obj;
        if (this.tunaGraphicsMap.containsKey(str) && (obj = this.tunaGraphicsMap.get(str)) != null) {
            return obj;
        }
        Movie decodeFile = Movie.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        return decodeBitmapFile(str, i, i2);
    }

    public int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize > 8) {
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < computeInitialSampleSize) {
            i3 <<= 1;
        }
        return i3;
    }

    private int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? i3 : i4;
    }

    public Bitmap createImageThumbnail(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeSampleSize(options, -1, 16384);
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Paint getTunaPaint() {
        return this.tunaPaint;
    }

    public void setTunaPaint(Paint paint) {
        this.tunaPaint = paint;
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint() {
        Paint paint = this.tunaPaint;
        if (paint == null) {
            Paint paint2 = new Paint(1);
            this.tunaPaint = paint2;
            return paint2;
        }
        paint.reset();
        this.tunaPaint.clearShadowLayer();
        this.tunaPaint.setAntiAlias(true);
        return this.tunaPaint;
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(int i) {
        return initTunaPaint(Paint.Style.FILL, 0.0f, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i) {
        return initTunaPaint(style, 0.0f, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, Shader shader) {
        return initTunaPaint(style, 0.0f, 0, shader, 0.0f, 0, 0.0f, 0.0f, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i, float f) {
        return initTunaPaint(style, f, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i, Shader shader) {
        return initTunaPaint(style, 0.0f, i, shader, 0.0f, 0, 0.0f, 0.0f, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, Shader shader, int i) {
        return initTunaPaint(style, 0.0f, 0, shader, 0.0f, 0, 0.0f, 0.0f, i);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i, Shader shader, int i2) {
        return initTunaPaint(style, 0.0f, i, shader, 0.0f, 0, 0.0f, 0.0f, i2);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i, float f, int i2) {
        return initTunaPaint(style, f, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, i2);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, Shader shader, float f, int i, float f2, float f3) {
        return initTunaPaint(style, 0.0f, 0, shader, f, i, f2, f3, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, int i, float f, int i2, float f2, float f3) {
        return initTunaPaint(style, 0.0f, i, (Shader) null, f, i2, f2, f3, -1);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint.Style style, float f, int i, Shader shader, float f2, int i2, float f3, float f4, int i3) {
        initTunaPaint();
        if (style != null) {
            this.tunaPaint.setStyle(style);
        }
        if (f != 0.0f) {
            this.tunaPaint.setStrokeWidth(f);
        }
        if (shader == null) {
            this.tunaPaint.setColor(i);
        } else {
            this.tunaPaint.setShader(shader);
        }
        if (f2 != 0.0f) {
            this.tunaPaint.setShadowLayer(f2, f3, f4, i2);
        }
        if (i3 != -1) {
            this.tunaPaint.setAlpha(i3);
        }
        return this.tunaPaint;
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(float f) {
        return initTunaTextPaint((Paint.Style) null, -1, f, 0.0f, 0, 0.0f, 0.0f, (Typeface) null, (Paint.Align) null);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(int i, float f) {
        return initTunaTextPaint((Paint.Style) null, i, f, 0.0f, 0, 0.0f, 0.0f, (Typeface) null, (Paint.Align) null);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(int i, float f, Paint.Align align) {
        return initTunaTextPaint((Paint.Style) null, i, f, 0.0f, 0, 0.0f, 0.0f, (Typeface) null, align);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(Paint.Style style, int i, float f, Paint.Align align) {
        return initTunaTextPaint(style, i, f, 0.0f, 0, 0.0f, 0.0f, (Typeface) null, align);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(Paint.Style style, int i, float f, Typeface typeface, Paint.Align align) {
        return initTunaTextPaint(style, i, f, 0.0f, 0, 0.0f, 0.0f, typeface, align);
    }

    /* access modifiers changed from: protected */
    public Paint initTunaTextPaint(Paint.Style style, int i, float f, float f2, int i2, float f3, float f4, Typeface typeface, Paint.Align align) {
        initTunaPaint();
        if (style != null) {
            this.tunaPaint.setStyle(style);
        }
        this.tunaPaint.setColor(i);
        if (f != 0.0f) {
            this.tunaPaint.setTextSize(f);
        }
        if (f2 != 0.0f) {
            this.tunaPaint.setShadowLayer(f2, f3, f4, i2);
        }
        if (align != null) {
            this.tunaPaint.setTextAlign(align);
        }
        if (typeface != null) {
            this.tunaPaint.setTypeface(typeface);
        }
        return this.tunaPaint;
    }

    /* access modifiers changed from: protected */
    public Paint initTunaPaint(Paint paint, float f, float f2, float f3) {
        paint.clearShadowLayer();
        if (f > 0.0f) {
            paint.setShadowLayer(f, f2, f3, -1);
        }
        return paint;
    }

    public Path getTunaPath() {
        return this.tunaPath;
    }

    public void setTunaPath(Path path) {
        this.tunaPath = path;
    }

    /* access modifiers changed from: protected */
    public Path initTunaPath() {
        Path path = this.tunaPath;
        if (path == null) {
            this.tunaPath = new Path();
        } else {
            path.reset();
        }
        return this.tunaPath;
    }

    /* access modifiers changed from: protected */
    public Path initTunaPathMoveTo(float f, float f2) {
        Path path = this.tunaPath;
        if (path == null) {
            this.tunaPath = new Path();
        } else {
            path.reset();
        }
        this.tunaPath.moveTo(f, f2);
        return this.tunaPath;
    }

    /* access modifiers changed from: protected */
    public Path initTunaPathLineTo(float f, float f2) {
        Path path = this.tunaPath;
        if (path == null) {
            this.tunaPath = new Path();
        } else {
            path.reset();
        }
        this.tunaPath.lineTo(f, f2);
        return this.tunaPath;
    }

    /* access modifiers changed from: protected */
    public Path initTunaPathArc(RectF rectF, float f, float f2) {
        Path path = this.tunaPath;
        if (path == null) {
            this.tunaPath = new Path();
        } else {
            path.reset();
        }
        this.tunaPath.addArc(rectF, f, f2);
        return this.tunaPath;
    }

    /* access modifiers changed from: protected */
    public Path initTunaPathRoundRect(RectF rectF, float[] fArr, Path.Direction direction) {
        Path path = this.tunaPath;
        if (path == null) {
            this.tunaPath = new Path();
        } else {
            path.reset();
        }
        this.tunaPath.addRoundRect(rectF, fArr, direction);
        return this.tunaPath;
    }

    public Rect getTunaRect() {
        return this.tunaRect;
    }

    public void setTunaRect(Rect rect) {
        this.tunaRect = rect;
    }

    /* access modifiers changed from: protected */
    public Rect initTunaRect() {
        if (this.tunaRect == null) {
            this.tunaRect = new Rect();
        }
        return this.tunaRect;
    }

    /* access modifiers changed from: protected */
    public Rect initTunaRect(int i, int i2, int i3, int i4) {
        if (this.tunaRect == null) {
            this.tunaRect = new Rect(i, i2, i3, i4);
        }
        this.tunaRect.set(i, i2, i3, i4);
        return this.tunaRect;
    }

    public RectF getTunaRectF() {
        return this.tunaRectF;
    }

    public void setTunaRectF(RectF rectF) {
        this.tunaRectF = rectF;
    }

    /* access modifiers changed from: protected */
    public RectF initTunaRectF(float f, float f2, float f3, float f4) {
        if (this.tunaRectF == null) {
            this.tunaRectF = new RectF(f, f2, f3, f4);
        }
        this.tunaRectF.set(f, f2, f3, f4);
        return this.tunaRectF;
    }

    public Matrix getTunaMatrix() {
        return this.tunaMatrix;
    }

    public void setTunaMatrix(Matrix matrix) {
        this.tunaMatrix = matrix;
    }

    /* access modifiers changed from: protected */
    public Matrix initTunaMatrix(float f, float f2) {
        if (this.tunaMatrix == null) {
            this.tunaMatrix = new Matrix();
        }
        this.tunaMatrix.reset();
        this.tunaMatrix.setScale(f, f2);
        return this.tunaMatrix;
    }

    public static Matrix initTunaMatrix(Matrix matrix, float f, float f2) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.reset();
        matrix.setScale(f, f2);
        return matrix;
    }

    /* access modifiers changed from: protected */
    public LayoutInflater initTunaLayoutInflater() {
        if (this.tunaLayoutInflater == null) {
            this.tunaLayoutInflater = LayoutInflater.from(getContext());
        }
        return this.tunaLayoutInflater;
    }

    /* access modifiers changed from: protected */
    public float pxToDp(float f) {
        return f / this.displayDensity;
    }

    /* access modifiers changed from: protected */
    public float pxToSp(float f) {
        return f / this.displayScaledDensity;
    }

    /* access modifiers changed from: protected */
    public int spToPx(float f) {
        return (int) ((f * this.displayScaledDensity) + 0.5f);
    }

    /* access modifiers changed from: protected */
    public int dpToPx(float f) {
        return (int) ((f * this.displayDensity) + 0.5f);
    }

    /* access modifiers changed from: protected */
    public void setTunaLayout(int i, int i2) {
        if (this.tunaLayoutParams == null) {
            this.tunaLayoutParams = getLayoutParams();
        }
        this.tunaLayoutParams.width = i;
        this.tunaLayoutParams.height = i2;
        setLayoutParams(this.tunaLayoutParams);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void initDisplayMetrics() {
        if (displayMetrics == null) {
            DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
            displayMetrics = displayMetrics2;
            this.displayWidth = displayMetrics2.widthPixels;
            this.displayHeight = displayMetrics.heightPixels;
            this.displayDensity = displayMetrics.density;
            this.displayScaledDensity = displayMetrics.scaledDensity;
            this.displayXdpi = displayMetrics.xdpi;
            this.displayYdpi = displayMetrics.ydpi;
            StringBuffer stringBuffer = new StringBuffer(288);
            this.tunaStringBuffer = stringBuffer;
            stringBuffer.append(getResources().getString(R.string.publice_service_device_type));
            this.tunaStringBuffer.append(Build.MODEL);
            this.tunaStringBuffer.append(" , ");
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_system_version));
            this.tunaStringBuffer.append(Build.VERSION.RELEASE);
            this.tunaStringBuffer.append(" , ");
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_api_grade));
            this.tunaStringBuffer.append(Build.VERSION.SDK);
            this.tunaStringBuffer.append(" , ");
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_screen_display));
            this.tunaStringBuffer.append(this.displayWidth);
            this.tunaStringBuffer.append(" * ");
            this.tunaStringBuffer.append(this.displayHeight);
            this.tunaStringBuffer.append(" ( ");
            this.tunaStringBuffer.append(((float) this.displayWidth) / this.displayDensity);
            this.tunaStringBuffer.append("dp * ");
            this.tunaStringBuffer.append(((float) this.displayHeight) / this.displayDensity);
            this.tunaStringBuffer.append("dp ) ");
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_screen_dpi));
            this.tunaStringBuffer.append(this.displayDensity);
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_screen_scale));
            this.tunaStringBuffer.append(this.displayScaledDensity);
            this.tunaStringBuffer.append(" , ");
            this.tunaStringBuffer.append(getResources().getString(R.string.display_dimen));
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_screen_x));
            this.tunaStringBuffer.append(this.displayXdpi);
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_screen_y));
            this.tunaStringBuffer.append(this.displayYdpi);
            this.tunaStringBuffer.append(getResources().getString(R.string.publice_service_device_px));
        }
    }

    /* access modifiers changed from: protected */
    public void initTunaCanvas(Canvas canvas) {
        if (canvas.getDrawFilter() == null) {
            canvas.setDrawFilter(this.tunaPaintFlagsDrawFilter);
            this.tunaCanvasHardwareAccelerated = canvas.isHardwareAccelerated();
        }
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, int i, int i2, int i3, float f, float f2, float f3, float f4) {
        drawTunaRectCustom(canvas, 0.0f, 0.0f, (float) i, (float) i2, i3, (Shader) null, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, f, f2, f3, f4);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, int i, int i2, int i3, float f, int i4, float f2, float f3, float f4, float f5) {
        drawTunaRectCustom(canvas, 0.0f, 0.0f, (float) i, (float) i2, i3, (Shader) null, 0.0f, 0, 0.0f, 0.0f, f, i4, f2, f3, f4, f5);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, int i, int i2, Shader shader, float f, int i3, float f2, float f3, float f4, float f5) {
        drawTunaRectCustom(canvas, 0.0f, 0.0f, (float) i, (float) i2, 0, shader, 0.0f, 0, 0.0f, 0.0f, f, i3, f2, f3, f4, f5);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, int i, int i2, int i3, float f, int i4, float f2, float f3, float f4, int i5, float f5, float f6, float f7, float f8) {
        drawTunaRectCustom(canvas, 0.0f, 0.0f, (float) i, (float) i2, i3, (Shader) null, f, i4, f2, f3, f4, i5, f5, f6, f7, f8);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, int i, int i2, Shader shader, float f, int i3, float f2, float f3, float f4, int i4, float f5, float f6, float f7, float f8) {
        drawTunaRectCustom(canvas, 0.0f, 0.0f, (float) i, (float) i2, 0, shader, f, i3, f2, f3, f4, i4, f5, f6, f7, f8);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectCustom(Canvas canvas, float f, float f2, float f3, float f4, int i, Shader shader, float f5, int i2, float f6, float f7, float f8, int i3, float f9, float f10, float f11, float f12) {
        Paint paint;
        Canvas canvas2 = canvas;
        Shader shader2 = shader;
        float f13 = f8;
        float[] fArr = {f9, f9, f11, f11, f12, f12, f10, f10};
        if (f13 > 0.0f) {
            float f14 = 0.5f * f13;
            canvas.drawPath(initTunaPathRoundRect(initTunaRectF(f + f14, f2 + f14, f3 - f14, f4 - f14), fArr, Path.Direction.CW), initTunaPaint(Paint.Style.STROKE, i3, f13));
        }
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = fArr[i4] - f13;
            fArr[i4] = fArr[i4] >= 0.0f ? fArr[i4] : 0.0f;
        }
        Path initTunaPathRoundRect = initTunaPathRoundRect(initTunaRectF(f + f13, f2 + f13, f3 - f13, f4 - f13), fArr, Path.Direction.CW);
        if (shader2 == null) {
            paint = f5 == 0.0f ? initTunaPaint(i) : initTunaPaint(Paint.Style.FILL, i, f5, i2, f6, f7);
        } else {
            paint = f5 == 0.0f ? initTunaPaint(Paint.Style.FILL, shader2) : initTunaPaint(Paint.Style.FILL, shader, f5, i2, f6, f7);
        }
        canvas.drawPath(initTunaPathRoundRect, paint);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, int i, float f3) {
        drawTunaRectClassic(canvas, 0.0f, 0.0f, f, f2, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, f3);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, int i, float f3, int i2, float f4) {
        drawTunaRectClassic(canvas, 0.0f, 0.0f, f, f2, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, f3, i2, f4);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, Shader shader, float f3, int i, float f4) {
        drawTunaRectClassic(canvas, 0.0f, 0.0f, f, f2, 0, shader, 0.0f, 0, 0.0f, 0.0f, f3, i, f4);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, float f3, float f4, int i, float f5, int i2, float f6) {
        drawTunaRectClassic(canvas, f, f2, f3, f4, i, (Shader) null, 0.0f, 0, 0.0f, 0.0f, f5, i2, f6);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, float f3, float f4, Shader shader, float f5, int i, float f6) {
        drawTunaRectClassic(canvas, f, f2, f3, f4, 0, shader, 0.0f, 0, 0.0f, 0.0f, f5, i, f6);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, int i, float f3, int i2, float f4, float f5, float f6, int i3, float f7) {
        drawTunaRectClassic(canvas, 0.0f, 0.0f, f, f2, i, (Shader) null, f3, i2, f4, f5, f6, i3, f7);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, Shader shader, float f3, int i, float f4, float f5, float f6, int i2, float f7) {
        drawTunaRectClassic(canvas, 0.0f, 0.0f, f, f2, 0, shader, f3, i, f4, f5, f6, i2, f7);
    }

    /* access modifiers changed from: protected */
    public void drawTunaRectClassic(Canvas canvas, float f, float f2, float f3, float f4, int i, Shader shader, float f5, int i2, float f6, float f7, float f8, int i3, float f9) {
        Paint paint;
        Canvas canvas2 = canvas;
        Shader shader2 = shader;
        float f10 = f8;
        float f11 = f9;
        if (f10 > 0.0f) {
            float f12 = 0.5f * f10;
            canvas.drawRoundRect(initTunaRectF(f + f12, f2 + f12, f3 - f12, f4 - f12), f11, f11, initTunaPaint(Paint.Style.STROKE, i3, f10));
        }
        RectF initTunaRectF = initTunaRectF(f + f10, f2 + f10, f3 - f10, f4 - f10);
        if (shader2 == null) {
            if (f5 == 0.0f) {
                paint = initTunaPaint(i);
            } else {
                paint = initTunaPaint(Paint.Style.FILL, i, f5, i2, f6, f7);
            }
        } else if (f5 == 0.0f) {
            paint = initTunaPaint(Paint.Style.FILL, shader2);
        } else {
            paint = initTunaPaint(Paint.Style.FILL, shader, f5, i2, f6, f7);
        }
        canvas.drawRoundRect(initTunaRectF, f11, f11, paint);
    }

    /* access modifiers changed from: protected */
    public float[] drawTunaText(Canvas canvas, String str, float f, float f2, float f3, Paint paint) {
        return drawTunaText(canvas, str, f, f2, f3, 0.0f, 0.0f, paint, tunaTextGravityArray[0], 1.0f, (List<Integer>) null);
    }

    /* access modifiers changed from: protected */
    public float[] drawTunaText(Canvas canvas, String str, float f, float f2, float f3, float f4, float f5, Paint paint) {
        return drawTunaText(canvas, str, f, f2, f3, f4, f5, paint, tunaTextGravityArray[0], 1.0f, (List<Integer>) null);
    }

    /* access modifiers changed from: protected */
    public float[] drawTunaText(Canvas canvas, String str, float f, float f2, float f3, float f4, float f5, Paint paint, float f6, List<Integer> list) {
        return drawTunaText(canvas, str, f, f2, f3, f4, f5, paint, tunaTextGravityArray[0], f6, list);
    }

    /* access modifiers changed from: protected */
    public float[] drawTunaText(Canvas canvas, String str, float f, float f2, float f3, float f4, float f5, Paint paint, TunaTextGravity tunaTextGravity2, float f6, List<Integer> list) {
        String str2;
        Canvas canvas2 = canvas;
        String str3 = str;
        float f7 = f2;
        Paint paint2 = paint;
        List<Integer> generateMeasureList = list == null ? generateMeasureList(str, paint, f, f4, f5) : list;
        float size = ((float) (generateMeasureList.size() + 1)) * 0.5f;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        float f8 = (f3 - (((float) fontMetricsInt.bottom) * 0.5f)) - (((float) fontMetricsInt.top) * 0.5f);
        int i = (fontMetricsInt.descent - fontMetricsInt.ascent) >> 1;
        int size2 = generateMeasureList.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size2) {
            int i4 = i3 + 1;
            float textSize = ((((float) i4) - size) * paint.getTextSize() * f6) + f8;
            if (i3 == 0) {
                str2 = str3.substring(i2, generateMeasureList.get(i3).intValue());
            } else {
                str2 = str3.substring(generateMeasureList.get(i3 - 1).intValue(), generateMeasureList.get(i3).intValue());
            }
            float measureText = paint2.measureText(str2);
            if (i3 != size2 - 1) {
                int i5 = C2061417.$SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity[tunaTextGravity2.ordinal()];
                if (i5 == 1) {
                    canvas2.drawText(str2, f7 + ((f4 - f5) * 0.5f), textSize, paint2);
                } else if (i5 == 2) {
                    canvas2.drawText(str2, f4 + (measureText * 0.5f), textSize, paint2);
                } else if (i5 == 3) {
                    canvas2.drawText(str2, ((f4 - f5) * 0.5f) + f7, textSize, paint2);
                } else if (i5 == 4) {
                    canvas2.drawText(str2, f4 + (measureText * 0.5f), textSize, paint2);
                }
            } else {
                float f9 = (f - f4) - f5;
                int i6 = C2061417.$SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity[tunaTextGravity2.ordinal()];
                if (i6 == 1) {
                    canvas2.drawText(str2, f7, textSize, paint2);
                    return new float[]{measureText, measureText * 0.5f, (textSize - f3) - ((float) i)};
                } else if (i6 == 2) {
                    canvas2.drawText(str2, f4 + (measureText * 0.5f), textSize, paint2);
                    return new float[]{f9, (measureText + f4) - (0.5f * f), (textSize - f3) - ((float) i)};
                } else if (i6 == 3) {
                    canvas2.drawText(str2, f4 + (measureText * 0.5f), textSize, paint2);
                    return new float[]{f9, (measureText + f4) - (0.5f * f), (textSize - f3) - ((float) i)};
                } else if (i6 == 4) {
                    canvas2.drawText(str2, f7, textSize, paint2);
                    return new float[]{measureText, measureText * 0.5f, (textSize - f3) - ((float) i)};
                }
            }
            i3 = i4;
            i2 = 0;
        }
        return new float[]{f, 0.0f, 0.0f};
    }

    /* access modifiers changed from: protected */
    public void drawTunaTextMark(Canvas canvas, float f, Paint paint, float f2, float f3, float f4, float f5, float f6, String str, int i, float f7, List<Integer> list) {
        float f8 = ((float) (this.tunaWidth >> 1)) + f5 + f2 + f3;
        float f9 = ((float) (this.tunaHeight >> 1)) + f6 + f4;
        Canvas canvas2 = canvas;
        float f10 = f;
        Paint paint2 = paint;
        canvas.drawCircle(f8, f9, f, paint);
        if (str != null) {
            drawTunaText(canvas, str, (float) this.tunaWidth, f8, f9, 0.0f, 0.0f, initTunaTextPaint(Paint.Style.FILL, i, f7, Paint.Align.CENTER), 1.0f, list);
        }
    }

    public void setTunaStatius(boolean z, boolean z2, boolean z3) {
        if (this.tunaPress != z || this.tunaSelect != z2 || this.tunaTextMark != z3) {
            this.tunaPress = z;
            this.tunaSelect = z2;
            this.tunaTextMark = z3;
            invalidate();
        }
    }

    public void setTunaStatius(boolean z, boolean z2, boolean z3, boolean z4) {
        AnimatorSet animatorSet;
        if (this.tunaPress != z || this.tunaSelect != z2 || this.tunaTextMark != z3) {
            this.tunaPress = z;
            this.tunaSelect = z2;
            this.tunaTextMark = z3;
            if (!z4 && (animatorSet = this.tunaMaterialAnimatorSet) != null) {
                animatorSet.cancel();
            }
            invalidate();
        }
    }

    public static void tunaAssociate(final TunaView[] tunaViewArr) {
        if (tunaViewArr != null) {
            final int length = tunaViewArr.length;
            for (final int i = 0; i < length; i++) {
                tunaViewArr[i].setTunaAssociateListener(new TunaAssociateListener() {
                    public void tunaAssociate(View view) {
                        for (int i = 0; i < length; i++) {
                            if (i != i) {
                                tunaViewArr[i].setTunaStatius(false, false, false);
                            }
                        }
                    }
                });
                tunaViewArr[i].setTunaTouchCancelListener(new TunaTouchCancelListener() {
                    public void tunaTouchCancel(View view) {
                        for (int i = 0; i < length; i++) {
                            int i2 = i;
                            if (i2 != 0) {
                                if (i == i2 - 1) {
                                    tunaViewArr[i].setTunaStatius(false, true, false);
                                } else if (i < i2 - 1) {
                                    tunaViewArr[i].setTunaStatius(false, false, false);
                                }
                            } else if (i == i2 + 1) {
                                tunaViewArr[i].setTunaStatius(false, true, false);
                            } else if (i > i2 + 1) {
                                tunaViewArr[i].setTunaStatius(false, false, false);
                            }
                        }
                    }
                });
            }
        }
    }

    public static void tunaAssociate(final List<TunaView> list) {
        if (list != null) {
            final int size = list.size();
            for (final int i = 0; i < size; i++) {
                list.get(i).setTunaAssociateListener(new TunaAssociateListener() {
                    public void tunaAssociate(View view) {
                        for (int i = 0; i < size; i++) {
                            if (i != i) {
                                ((TunaView) list.get(i)).setTunaStatius(false, false, false, false);
                            }
                        }
                    }
                });
                list.get(i).setTunaTouchCancelListener(new TunaTouchCancelListener() {
                    public void tunaTouchCancel(View view) {
                        for (int i = 0; i < size; i++) {
                            int i2 = i;
                            if (i2 != 0) {
                                if (i == i2 - 1) {
                                    ((TunaView) list.get(i)).setTunaStatius(false, true, false, false);
                                } else if (i < i2 - 1) {
                                    ((TunaView) list.get(i)).setTunaStatius(false, false, false, false);
                                }
                            } else if (i == i2 + 1) {
                                ((TunaView) list.get(i)).setTunaStatius(false, true, false, false);
                            } else if (i > i2 + 1) {
                                ((TunaView) list.get(i)).setTunaStatius(false, false, false, false);
                            }
                        }
                    }
                });
            }
        }
    }

    public static void tunaDynamic(String[] strArr, String str, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i, int i2, int i3, int i4, int i5) {
        tunaDynamic(strArr, str, tunaTouchUpListener2, linearLayout, 1, i, i2, i3, i4, i5);
    }

    public static void tunaDynamic(String[] strArr, String str, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr2 = strArr;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= strArr2.length) {
                break;
            }
            String str2 = str;
            if (strArr2[i8].equals(str)) {
                i7 = i8;
                break;
            }
            i8++;
        }
        tunaDynamic(strArr, i7, tunaTouchUpListener2, linearLayout, i, i2, i3, i4, i5, i6);
    }

    public static void tunaDynamic(String[] strArr, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i, int i2, int i3, int i4, int i5) {
        tunaDynamic(strArr, 0, tunaTouchUpListener2, linearLayout, 1, i, i2, i3, i4, i5);
    }

    public static void tunaDynamic(String[] strArr, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        tunaDynamic(strArr, 0, tunaTouchUpListener2, linearLayout, i, i2, i3, i4, i5, i6);
    }

    public static void tunaDynamic(String[] strArr, int i, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i2, int i3, int i4, int i5, int i6) {
        tunaDynamic(strArr, i, tunaTouchUpListener2, linearLayout, 1, i2, i3, i4, i5, i6);
    }

    public static void tunaDynamic(String[] strArr, int i, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i2;
        tunaDynamicRaw(strArr, i, tunaTouchUpListener2, linearLayout, (int) applyDimension(i2, (float) i3, getViewDisplayMetrics(linearLayout)), i4, i5, i6, i7);
    }

    private static void tunaDynamicRaw(String[] strArr, int i, TunaTouchUpListener tunaTouchUpListener2, LinearLayout linearLayout, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr2 = strArr;
        TunaTouchUpListener tunaTouchUpListener3 = tunaTouchUpListener2;
        LinearLayout linearLayout2 = linearLayout;
        int i7 = i2;
        Context context = linearLayout.getContext();
        ArrayList arrayList = new ArrayList();
        if (strArr2.length > 0) {
            int i8 = 0;
            if (strArr2.length == 1) {
                TunaView tunaView = new TunaView(context, (AttributeSet) null, i6);
                tunaView.setTunaTextValue(strArr2[0]);
                tunaView.setTunaTouchUpListener(tunaTouchUpListener3);
                linearLayout2.addView(tunaView, i7, -1);
                return;
            }
            while (i8 < strArr2.length) {
                TunaView tunaView2 = new TunaView(context, (AttributeSet) null, i8 == 0 ? i3 : i8 == strArr2.length - 1 ? i4 : i5);
                tunaView2.setTunaTextValue(strArr2[i8]);
                if (i8 == i) {
                    tunaView2.setTunaSelect(true);
                }
                tunaView2.setTunaTouchUpListener(tunaTouchUpListener3);
                arrayList.add(tunaView2);
                linearLayout2.addView(tunaView2, i7, -1);
                if (i8 == 0 && strArr2.length == 2) {
                    setViewMargins(tunaView2, 0, 0, 0, -2, 0);
                } else if (i8 == 1 && strArr2.length == 2) {
                    setViewMargins(tunaView2, 0, -2, 0, 0, 0);
                } else if (!(i8 == 0 || i8 == strArr2.length - 1)) {
                    setViewMargins(tunaView2, 0, -2, 0, -2, 0);
                }
                i8++;
            }
            tunaAssociate((List<TunaView>) arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void showTunaProperties() {
        View inflate = initTunaLayoutInflater().inflate(R.layout.tunapropertiesview, (ViewGroup) null);
        this.tunaPropertiesView = inflate;
        EditText editText = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_width);
        EditText editText2 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_height);
        EditText editText3 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_backgroundNormal);
        EditText editText4 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_backgroundPress);
        EditText editText5 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_backgroundSelect);
        EditText editText6 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_textSize);
        EditText editText7 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_textColorNormal);
        EditText editText8 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_strokeWidth);
        EditText editText9 = (EditText) this.tunaPropertiesView.findViewById(R.id.edit_strokeColor);
        Button button = (Button) this.tunaPropertiesView.findViewById(R.id.btn_height_pius);
        Button button2 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_textSize_pius);
        Button button3 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_textSize_minus);
        Button button4 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_strokeWidth_pius);
        Button button5 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_strokeWidth_minus);
        Button button6 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_backgroundNormal);
        Button button7 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_width_minus);
        Button button8 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_backgroundPress);
        Button button9 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_width_pius);
        Button button10 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_backgroundSelect);
        Button button11 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_height_minus);
        Button button12 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_textColorNormal);
        Button button13 = (Button) this.tunaPropertiesView.findViewById(R.id.btn_strokeColor);
        ToggleButton toggleButton = (ToggleButton) this.tunaPropertiesView.findViewById(R.id.toogle_mark);
        TextView textView = (TextView) this.tunaPropertiesView.findViewById(R.id.text_mark);
        ToggleButton toggleButton2 = (ToggleButton) this.tunaPropertiesView.findViewById(R.id.toogle_thisHardwareAccelerated);
        TextView textView2 = (TextView) this.tunaPropertiesView.findViewById(R.id.text_thisHardwareAccelerated);
        ToggleButton toggleButton3 = (ToggleButton) this.tunaPropertiesView.findViewById(R.id.toogle_canvasHardwareAccelerated);
        TextView textView3 = (TextView) this.tunaPropertiesView.findViewById(R.id.text_canvasHardwareAccelerated);
        ((TextView) inflate.findViewById(R.id.text_display)).setText(this.tunaStringBuffer);
        editText.setText(String.valueOf(pxToDp((float) this.tunaWidth)));
        editText2.setText(String.valueOf(pxToDp((float) this.tunaHeight)));
        int i = this.tunaBackgroundNormal;
        String str = "00000000";
        editText3.setText(i != 0 ? String.valueOf(Integer.toHexString(i)) : str);
        int i2 = this.tunaBackgroundPress;
        editText4.setText(i2 != 0 ? String.valueOf(Integer.toHexString(i2)) : str);
        int i3 = this.tunaBackgroundSelect;
        editText5.setText(i3 != 0 ? String.valueOf(Integer.toHexString(i3)) : str);
        editText6.setText(String.valueOf(pxToDp(this.tunaTextSize)));
        int i4 = this.tunaTextColorNormal;
        editText7.setText(i4 != 0 ? String.valueOf(Integer.toHexString(i4)) : str);
        editText8.setText(String.valueOf(pxToDp(this.tunaStrokeWidthNormal)));
        int i5 = this.tunaStrokeColorNormal;
        if (i5 != 0) {
            str = String.valueOf(Integer.toHexString(i5));
        }
        editText9.setText(str);
        button6.setBackgroundColor(this.tunaBackgroundNormal);
        button8.setBackgroundColor(this.tunaBackgroundPress);
        button10.setBackgroundColor(this.tunaBackgroundSelect);
        button13.setBackgroundColor(this.tunaStrokeColorNormal);
        Button button14 = button12;
        button14.setBackgroundColor(this.tunaTextColorNormal);
        Button button15 = button6;
        ToggleButton toggleButton4 = toggleButton;
        toggleButton4.setChecked(this.tunaTextMark);
        Button button16 = button14;
        final TextView textView4 = textView;
        textView4.setText(String.valueOf(this.tunaTextMark));
        boolean isHardwareAccelerated = isHardwareAccelerated();
        this.tunaIsHardwareAccelerated = isHardwareAccelerated;
        Button button17 = button8;
        toggleButton2.setChecked(isHardwareAccelerated);
        textView2.setText(String.valueOf(this.tunaIsHardwareAccelerated));
        toggleButton3.setChecked(this.tunaCanvasHardwareAccelerated);
        textView3.setText(String.valueOf(this.tunaCanvasHardwareAccelerated));
        toggleButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                textView4.setText(String.valueOf(z));
            }
        });
        Button button18 = button;
        Button button19 = button2;
        Button button20 = button3;
        Button button21 = button4;
        Button button22 = button5;
        final EditText editText10 = editText;
        C2060311 r38 = r0;
        Button button23 = button7;
        final EditText editText11 = editText2;
        Button button24 = button10;
        Button button25 = button9;
        final EditText editText12 = editText6;
        EditText editText13 = editText9;
        final EditText editText14 = editText8;
        EditText editText15 = editText8;
        final Button button26 = button15;
        EditText editText16 = editText7;
        final EditText editText17 = editText3;
        EditText editText18 = editText6;
        final Button button27 = button17;
        EditText editText19 = editText5;
        final EditText editText20 = editText4;
        EditText editText21 = editText4;
        final Button button28 = button24;
        EditText editText22 = editText3;
        final EditText editText23 = editText19;
        EditText editText24 = editText2;
        final Button button29 = button16;
        EditText editText25 = editText;
        final EditText editText26 = editText16;
        TextView textView5 = textView4;
        final Button button30 = button13;
        final EditText editText27 = editText13;
        C2060311 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int id = view.getId();
                if (id == R.id.btn_width_pius) {
                    EditText editText = editText10;
                    editText.setText(String.valueOf(Float.parseFloat(editText.getText().toString().trim()) + 1.0f));
                } else if (id == R.id.btn_width_minus) {
                    EditText editText2 = editText10;
                    editText2.setText(String.valueOf(Float.parseFloat(editText2.getText().toString().trim()) - 1.0f));
                } else if (id == R.id.btn_height_pius) {
                    EditText editText3 = editText11;
                    editText3.setText(String.valueOf(Float.parseFloat(editText3.getText().toString().trim()) + 1.0f));
                } else if (id == R.id.btn_height_minus) {
                    EditText editText4 = editText11;
                    editText4.setText(String.valueOf(Float.parseFloat(editText4.getText().toString().trim()) - 1.0f));
                } else if (id == R.id.btn_textSize_pius) {
                    EditText editText5 = editText12;
                    editText5.setText(String.valueOf(Float.parseFloat(editText5.getText().toString().trim()) + 1.0f));
                } else if (id == R.id.btn_textSize_minus) {
                    EditText editText6 = editText12;
                    editText6.setText(String.valueOf(Float.parseFloat(editText6.getText().toString().trim()) - 1.0f));
                } else if (id == R.id.btn_strokeWidth_pius) {
                    EditText editText7 = editText14;
                    editText7.setText(String.valueOf(Float.parseFloat(editText7.getText().toString().trim()) + 1.0f));
                } else if (id == R.id.btn_strokeWidth_minus) {
                    EditText editText8 = editText14;
                    editText8.setText(String.valueOf(Float.parseFloat(editText8.getText().toString().trim()) - 1.0f));
                } else if (id == R.id.btn_backgroundNormal) {
                    SystemUtils.showDialog(new TunaColorPicker(TunaView.this.getContext(), new TunaColorPicker.OnColorChangedListener() {
                        public void colorChanged(int i) {
                            button26.setBackgroundColor(i);
                            editText17.setText(String.valueOf(Integer.toHexString(i)));
                        }
                    }, TunaView.this.tunaBackgroundNormal));
                } else if (id == R.id.btn_backgroundPress) {
                    SystemUtils.showDialog(new TunaColorPicker(TunaView.this.getContext(), new TunaColorPicker.OnColorChangedListener() {
                        public void colorChanged(int i) {
                            button27.setBackgroundColor(i);
                            editText20.setText(String.valueOf(Integer.toHexString(i)));
                        }
                    }, TunaView.this.tunaBackgroundNormal));
                } else if (id == R.id.btn_backgroundSelect) {
                    SystemUtils.showDialog(new TunaColorPicker(TunaView.this.getContext(), new TunaColorPicker.OnColorChangedListener() {
                        public void colorChanged(int i) {
                            button28.setBackgroundColor(i);
                            editText23.setText(String.valueOf(Integer.toHexString(i)));
                        }
                    }, TunaView.this.tunaBackgroundNormal));
                } else if (id == R.id.btn_textColorNormal) {
                    SystemUtils.showDialog(new TunaColorPicker(TunaView.this.getContext(), new TunaColorPicker.OnColorChangedListener() {
                        public void colorChanged(int i) {
                            button29.setBackgroundColor(i);
                            editText26.setText(String.valueOf(Integer.toHexString(i)));
                        }
                    }, TunaView.this.tunaStrokeColorNormal));
                } else if (id == R.id.btn_strokeColor) {
                    SystemUtils.showDialog(new TunaColorPicker(TunaView.this.getContext(), new TunaColorPicker.OnColorChangedListener() {
                        public void colorChanged(int i) {
                            button30.setBackgroundColor(i);
                            editText27.setText(String.valueOf(Integer.toHexString(i)));
                        }
                    }, TunaView.this.tunaStrokeColorNormal));
                }
            }
        };
        C2060311 r02 = r38;
        button25.setOnClickListener(r02);
        button23.setOnClickListener(r02);
        button18.setOnClickListener(r02);
        button11.setOnClickListener(r02);
        button19.setOnClickListener(r02);
        button20.setOnClickListener(r02);
        button21.setOnClickListener(r02);
        button22.setOnClickListener(r02);
        button15.setOnClickListener(r02);
        button17.setOnClickListener(r02);
        button24.setOnClickListener(r02);
        button13.setOnClickListener(r02);
        final EditText editText28 = editText22;
        final EditText editText29 = editText21;
        final EditText editText30 = editText19;
        final EditText editText31 = editText18;
        final EditText editText32 = editText16;
        final EditText editText33 = editText15;
        final EditText editText34 = editText13;
        final TextView textView6 = textView5;
        final EditText editText35 = editText25;
        final EditText editText36 = editText24;
        SystemUtils.showDialog(new AlertDialog.Builder(getContext(), 16973931).setIconAttribute(16843605).setTitle(this.tunaTag).setView(this.tunaPropertiesView).setPositiveButton(Payload.RESPONSE_OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                TunaView tunaView = TunaView.this;
                int unused = tunaView.tunaBackgroundNormal = Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + editText28.getText().toString().trim());
                TunaView tunaView2 = TunaView.this;
                int unused2 = tunaView2.tunaBackgroundPress = Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + editText29.getText().toString().trim());
                TunaView tunaView3 = TunaView.this;
                int unused3 = tunaView3.tunaBackgroundSelect = Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + editText30.getText().toString().trim());
                TunaView tunaView4 = TunaView.this;
                float unused4 = tunaView4.tunaTextSize = (float) tunaView4.dpToPx(Float.parseFloat(editText31.getText().toString().trim()));
                TunaView tunaView5 = TunaView.this;
                int unused5 = tunaView5.tunaTextColorNormal = Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + editText32.getText().toString().trim());
                TunaView tunaView6 = TunaView.this;
                float unused6 = tunaView6.tunaStrokeWidthNormal = (float) tunaView6.dpToPx(Float.parseFloat(editText33.getText().toString().trim()));
                TunaView tunaView7 = TunaView.this;
                int unused7 = tunaView7.tunaStrokeColorNormal = Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + editText34.getText().toString().trim());
                TunaView.this.tunaTextMark = textView6.getText().toString().trim().equals("true");
                TunaView tunaView8 = TunaView.this;
                tunaView8.setTunaLayout(tunaView8.dpToPx(Float.parseFloat(editText35.getText().toString().trim())), TunaView.this.dpToPx(Float.parseFloat(editText36.getText().toString().trim())));
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create());
    }

    public enum TunaTouchType {
        EDGE(0),
        ALWAYS(1),
        NONE(2);
        
        final int nativeInt;

        private TunaTouchType(int i) {
            this.nativeInt = i;
        }
    }

    public TunaTouchType getTunaTouchType() {
        return this.tunaTouchType;
    }

    public void setTunaTouchType(TunaTouchType tunaTouchType2) {
        this.tunaTouchType = tunaTouchType2;
    }

    public boolean isTunaSuper() {
        return this.tunaSuper;
    }

    public void setTunaSuper(boolean z) {
        this.tunaSuper = z;
    }

    public boolean isTunaClassic() {
        return this.tunaClassic;
    }

    public void setTunaClassic(boolean z) {
        this.tunaClassic = z;
    }

    public boolean isTunaDebugable() {
        return this.tunaDebugable;
    }

    public void setTunaDebugable(boolean z) {
        this.tunaDebugable = z;
    }

    public boolean isTunaPress() {
        return this.tunaPress;
    }

    public void setTunaPress(boolean z) {
        this.tunaPress = z;
    }

    public boolean isTunaSelect() {
        return this.tunaSelect;
    }

    public void setTunaSelect(boolean z) {
        this.tunaSelect = z;
    }

    public enum TunaSelectType {
        NONE(0),
        SAME(1),
        REVERSE(2);
        
        final int nativeInt;

        private TunaSelectType(int i) {
            this.nativeInt = i;
        }
    }

    public TunaSelectType getTunaSelectType() {
        return this.tunaSelectType;
    }

    public void setTunaSelectType(TunaSelectType tunaSelectType2) {
        this.tunaSelectType = tunaSelectType2;
    }

    public int getTunaRotate() {
        return this.tunaRotate;
    }

    public void setTunaRotate(int i) {
        this.tunaRotate = i;
    }

    public boolean isTunaAnimationable() {
        return this.tunaAnimationable;
    }

    public void setTunaAnimationable(boolean z) {
        this.tunaAnimationable = z;
        if (z) {
            invalidate();
        }
    }

    public float getTunaTouchEventX() {
        return this.tunaTouchEventX;
    }

    public void setTunaTouchEventX(float f) {
        this.tunaTouchEventX = f;
    }

    public float getTunaTouchEventY() {
        return this.tunaTouchEventY;
    }

    public void setTunaTouchEventY(float f) {
        this.tunaTouchEventY = f;
    }

    public boolean isTunaTouchOutBounds() {
        return this.tunaTouchOutBounds;
    }

    public void setTunaTouchOutBounds(boolean z) {
        this.tunaTouchOutBounds = z;
    }

    public TunaLayoutListener getTunaLayoutListener() {
        return this.tunaLayoutListener;
    }

    public void setTunaLayoutListener(TunaLayoutListener tunaLayoutListener2) {
        this.tunaLayoutListener = tunaLayoutListener2;
    }

    public TunaDrawListener getTunaDrawListener() {
        return this.tunaDrawListener;
    }

    public void setTunaDrawListener(TunaDrawListener tunaDrawListener2) {
        this.tunaDrawListener = tunaDrawListener2;
    }

    public TunaAnimateEndListener getTunaAnimateEndListener() {
        return this.tunaAnimateEndListener;
    }

    public void setTunaAnimateEndListener(TunaAnimateEndListener tunaAnimateEndListener2) {
        this.tunaAnimateEndListener = tunaAnimateEndListener2;
    }

    public TunaTouchListener getTunaTouchListener() {
        return this.tunaTouchListener;
    }

    public void setTunaTouchListener(TunaTouchListener tunaTouchListener2) {
        this.tunaTouchListener = tunaTouchListener2;
    }

    public TunaTouchDownListener getTunaTouchDownListener() {
        return this.tunaTouchDownListener;
    }

    public void setTunaTouchDownListener(TunaTouchDownListener tunaTouchDownListener2) {
        this.tunaTouchDownListener = tunaTouchDownListener2;
    }

    public TunaTouchMoveListener getTunaTouchMoveListener() {
        return this.tunaTouchMoveListener;
    }

    public void setTunaTouchMoveListener(TunaTouchMoveListener tunaTouchMoveListener2) {
        this.tunaTouchMoveListener = tunaTouchMoveListener2;
    }

    public TunaTouchUpListener getTunaTouchUpListener() {
        return this.tunaTouchUpListener;
    }

    public void setTunaTouchUpListener(TunaTouchUpListener tunaTouchUpListener2) {
        this.tunaTouchUpListener = tunaTouchUpListener2;
    }

    public TunaTouchCancelListener getTunaTouchCancelListener() {
        return this.tunaTouchCancelListener;
    }

    public void setTunaTouchCancelListener(TunaTouchCancelListener tunaTouchCancelListener2) {
        this.tunaTouchCancelListener = tunaTouchCancelListener2;
    }

    public TunaTouchOutListener getTunaTouchOutListener() {
        return this.tunaTouchOutListener;
    }

    public void setTunaTouchOutListener(TunaTouchOutListener tunaTouchOutListener2) {
        this.tunaTouchOutListener = tunaTouchOutListener2;
    }

    public TunaTouchInListener getTunaTouchInListener() {
        return this.tunaTouchInListener;
    }

    public void setTunaTouchInListener(TunaTouchInListener tunaTouchInListener2) {
        this.tunaTouchInListener = tunaTouchInListener2;
    }

    public TunaAssociateListener getTunaAssociateListener() {
        return this.tunaAssociateListener;
    }

    public void setTunaAssociateListener(TunaAssociateListener tunaAssociateListener2) {
        this.tunaAssociateListener = tunaAssociateListener2;
    }

    public TunaSubLayoutListener getTunaSubLayoutListener() {
        return this.tunaSubLayoutListener;
    }

    public void setTunaSubLayoutListener(TunaSubLayoutListener tunaSubLayoutListener2) {
        this.tunaSubLayoutListener = tunaSubLayoutListener2;
    }

    public TunaSubDrawListener getTunaSubDrawListener() {
        return this.tunaSubDrawListener;
    }

    public void setTunaSubDrawListener(TunaSubDrawListener tunaSubDrawListener2) {
        this.tunaSubDrawListener = tunaSubDrawListener2;
    }

    public TunaSubAnimateEndListener getTunaSubAnimateEndListener() {
        return this.tunaSubAnimateEndListener;
    }

    public void setTunaSubAnimateEndListener(TunaSubAnimateEndListener tunaSubAnimateEndListener2) {
        this.tunaSubAnimateEndListener = tunaSubAnimateEndListener2;
    }

    public int getTunaBackgroundNormal() {
        return this.tunaBackgroundNormal;
    }

    public void setTunaBackgroundNormal(int i) {
        this.tunaBackgroundNormal = i;
    }

    public int getTunaBackgroundPress() {
        return this.tunaBackgroundPress;
    }

    public void setTunaBackgroundPress(int i) {
        this.tunaBackgroundPress = i;
    }

    public int getTunaBackgroundSelect() {
        return this.tunaBackgroundSelect;
    }

    public void setTunaBackgroundSelect(int i) {
        this.tunaBackgroundSelect = i;
    }

    public int getTunaForegroundNormal() {
        return this.tunaForegroundNormal;
    }

    public void setTunaForegroundNormal(int i) {
        this.tunaForegroundNormal = i;
    }

    public int getTunaForegroundPress() {
        return this.tunaForegroundPress;
    }

    public void setTunaForegroundPress(int i) {
        this.tunaForegroundPress = i;
    }

    public int getTunaForegroundSelect() {
        return this.tunaForegroundSelect;
    }

    public void setTunaForegroundSelect(int i) {
        this.tunaForegroundSelect = i;
    }

    public int getTunaBackgroundNormalAngle() {
        return this.tunaBackgroundNormalAngle;
    }

    public void setTunaBackgroundNormalAngle(int i) {
        this.tunaBackgroundNormalAngle = i;
    }

    public int getTunaBackgroundPressAngle() {
        return this.tunaBackgroundPressAngle;
    }

    public void setTunaBackgroundPressAngle(int i) {
        this.tunaBackgroundPressAngle = i;
    }

    public int getTunaBackgroundSelectAngle() {
        return this.tunaBackgroundSelectAngle;
    }

    public void setTunaBackgroundSelectAngle(int i) {
        this.tunaBackgroundSelectAngle = i;
    }

    public int getTunaBackgroundNormalGradientStart() {
        return this.tunaBackgroundNormalGradientStart;
    }

    public void setTunaBackgroundNormalGradientStart(int i) {
        this.tunaBackgroundNormalGradientStart = i;
    }

    public int getTunaBackgroundNormalGradientEnd() {
        return this.tunaBackgroundNormalGradientEnd;
    }

    public void setTunaBackgroundNormalGradientEnd(int i) {
        this.tunaBackgroundNormalGradientEnd = i;
    }

    public int getTunaBackgroundPressGradientStart() {
        return this.tunaBackgroundPressGradientStart;
    }

    public void setTunaBackgroundPressGradientStart(int i) {
        this.tunaBackgroundPressGradientStart = i;
    }

    public int getTunaBackgroundPressGradientEnd() {
        return this.tunaBackgroundPressGradientEnd;
    }

    public void setTunaBackgroundPressGradientEnd(int i) {
        this.tunaBackgroundPressGradientEnd = i;
    }

    public int getTunaBackgroundSelectGradientStart() {
        return this.tunaBackgroundSelectGradientStart;
    }

    public void setTunaBackgroundSelectGradientStart(int i) {
        this.tunaBackgroundSelectGradientStart = i;
    }

    public int getTunaBackgroundSelectGradientEnd() {
        return this.tunaBackgroundSelectGradientEnd;
    }

    public void setTunaBackgroundSelectGradientEnd(int i) {
        this.tunaBackgroundSelectGradientEnd = i;
    }

    public Shader getTunaBackgroundNormalShader() {
        return this.tunaBackgroundNormalShader;
    }

    public void setTunaBackgroundNormalShader(Shader shader) {
        this.tunaBackgroundNormalShader = shader;
    }

    public Shader getTunaBackgroundPressShader() {
        return this.tunaBackgroundPressShader;
    }

    public void setTunaBackgroundPressShader(Shader shader) {
        this.tunaBackgroundPressShader = shader;
    }

    public Shader getTunaBackgroundSelectShader() {
        return this.tunaBackgroundSelectShader;
    }

    public void setTunaBackgroundSelectShader(Shader shader) {
        this.tunaBackgroundSelectShader = shader;
    }

    public float getTunaBackgroundNormalShadowRadius() {
        return this.tunaBackgroundNormalShadowRadius;
    }

    public void setTunaBackgroundNormalShadowRadius(float f) {
        setTunaBackgroundNormalShadowRadius(1, f);
    }

    public void setTunaBackgroundNormalShadowRadius(int i, float f) {
        setTunaBackgroundNormalShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundNormalShadowRadiusRaw(float f) {
        if (this.tunaBackgroundNormalShadowRadius != f) {
            this.tunaBackgroundNormalShadowRadius = f;
            invalidate();
        }
    }

    public int getTunaBackgroundNormalShadowColor() {
        return this.tunaBackgroundNormalShadowColor;
    }

    public void setTunaBackgroundNormalShadowColor(int i) {
        this.tunaBackgroundNormalShadowColor = i;
    }

    public float getTunaBackgroundNormalShadowDx() {
        return this.tunaBackgroundNormalShadowDx;
    }

    public void setTunaBackgroundNormalShadowDx(float f) {
        setTunaBackgroundNormalShadowDx(1, f);
    }

    public void setTunaBackgroundNormalShadowDx(int i, float f) {
        setTunaBackgroundNormalShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundNormalShadowDxRaw(float f) {
        if (this.tunaBackgroundNormalShadowDx != f) {
            this.tunaBackgroundNormalShadowDx = f;
            invalidate();
        }
    }

    public float getTunaBackgroundNormalShadowDy() {
        return this.tunaBackgroundNormalShadowDy;
    }

    public void setTunaBackgroundNormalShadowDy(float f) {
        setTunaBackgroundNormalShadowDy(1, f);
    }

    public void setTunaBackgroundNormalShadowDy(int i, float f) {
        setTunaBackgroundNormalShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundNormalShadowDyRaw(float f) {
        if (this.tunaBackgroundNormalShadowDy != f) {
            this.tunaBackgroundNormalShadowDy = f;
            invalidate();
        }
    }

    public float getTunaBackgroundPressShadowRadius() {
        return this.tunaBackgroundPressShadowRadius;
    }

    public void setTunaBackgroundPressShadowRadius(float f) {
        setTunaBackgroundPressShadowRadius(1, f);
    }

    public void setTunaBackgroundPressShadowRadius(int i, float f) {
        setTunaBackgroundPressShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundPressShadowRadiusRaw(float f) {
        if (this.tunaBackgroundPressShadowRadius != f) {
            this.tunaBackgroundPressShadowRadius = f;
            invalidate();
        }
    }

    public int getTunaBackgroundPressShadowColor() {
        return this.tunaBackgroundPressShadowColor;
    }

    public void setTunaBackgroundPressShadowColor(int i) {
        this.tunaBackgroundPressShadowColor = i;
    }

    public float getTunaBackgroundPressShadowDx() {
        return this.tunaBackgroundPressShadowDx;
    }

    public void setTunaBackgroundPressShadowDx(float f) {
        setTunaBackgroundPressShadowDx(1, f);
    }

    public void setTunaBackgroundPressShadowDx(int i, float f) {
        setTunaBackgroundPressShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundPressShadowDxRaw(float f) {
        if (this.tunaBackgroundPressShadowDx != f) {
            this.tunaBackgroundPressShadowDx = f;
            invalidate();
        }
    }

    public float getTunaBackgroundPressShadowDy() {
        return this.tunaBackgroundPressShadowDy;
    }

    public void setTunaBackgroundPressShadowDy(float f) {
        setTunaBackgroundPressShadowDy(1, f);
    }

    public void setTunaBackgroundPressShadowDy(int i, float f) {
        setTunaBackgroundPressShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundPressShadowDyRaw(float f) {
        if (this.tunaBackgroundPressShadowDy != f) {
            this.tunaBackgroundPressShadowDy = f;
            invalidate();
        }
    }

    public float getTunaBackgroundSelectShadowRadius() {
        return this.tunaBackgroundSelectShadowRadius;
    }

    public void setTunaBackgroundSelectShadowRadius(float f) {
        setTunaBackgroundSelectShadowRadius(1, f);
    }

    public void setTunaBackgroundSelectShadowRadius(int i, float f) {
        setTunaBackgroundSelectShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundSelectShadowRadiusRaw(float f) {
        if (this.tunaBackgroundSelectShadowRadius != f) {
            this.tunaBackgroundSelectShadowRadius = f;
            invalidate();
        }
    }

    public int getTunaBackgroundSelectShadowColor() {
        return this.tunaBackgroundSelectShadowColor;
    }

    public void setTunaBackgroundSelectShadowColor(int i) {
        this.tunaBackgroundSelectShadowColor = i;
    }

    public float getTunaBackgroundSelectShadowDx() {
        return this.tunaBackgroundSelectShadowDx;
    }

    public void setTunaBackgroundSelectShadowDx(float f) {
        setTunaBackgroundSelectShadowDx(1, f);
    }

    public void setTunaBackgroundSelectShadowDx(int i, float f) {
        setTunaBackgroundSelectShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundSelectShadowDxRaw(float f) {
        if (this.tunaBackgroundSelectShadowDx != f) {
            this.tunaBackgroundSelectShadowDx = f;
            invalidate();
        }
    }

    public float getTunaBackgroundSelectShadowDy() {
        return this.tunaBackgroundSelectShadowDy;
    }

    public void setTunaBackgroundSelectShadowDy(float f) {
        setTunaBackgroundSelectShadowDy(1, f);
    }

    public void setTunaBackgroundSelectShadowDy(int i, float f) {
        setTunaBackgroundSelectShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaBackgroundSelectShadowDyRaw(float f) {
        if (this.tunaBackgroundSelectShadowDy != f) {
            this.tunaBackgroundSelectShadowDy = f;
            invalidate();
        }
    }

    public Bitmap getTunaSrcNormal() {
        return this.tunaSrcNormal;
    }

    public void setTunaSrcNormal(int i) {
        setTunaSrcNormal(decodeBitmapResource(i));
    }

    public void setTunaSrcNormal(Bitmap bitmap) {
        this.tunaSrcNormal = bitmap;
        invalidate();
    }

    public Bitmap getTunaSrcPress() {
        return this.tunaSrcPress;
    }

    public void setTunaSrcPress(int i) {
        setTunaSrcPress(decodeBitmapResource(i));
    }

    public void setTunaSrcPress(Bitmap bitmap) {
        this.tunaSrcPress = bitmap;
        invalidate();
    }

    public Bitmap getTunaSrcSelect() {
        return this.tunaSrcSelect;
    }

    public void setTunaSrcSelect(int i) {
        setTunaSrcSelect(decodeBitmapResource(i));
    }

    public void setTunaSrcSelect(Bitmap bitmap) {
        this.tunaSrcSelect = bitmap;
        invalidate();
    }

    public float getTunaSrcNormalShadowRadius() {
        return this.tunaSrcNormalShadowRadius;
    }

    public void setTunaSrcNormalShadowRadius(float f) {
        setTunaSrcNormalShadowRadius(1, f);
    }

    public void setTunaSrcNormalShadowRadius(int i, float f) {
        setTunaSrcNormalShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcNormalShadowRadiusRaw(float f) {
        if (this.tunaSrcNormalShadowRadius != f) {
            this.tunaSrcNormalShadowRadius = f;
            invalidate();
        }
    }

    public float getTunaSrcNormalShadowDx() {
        return this.tunaSrcNormalShadowDx;
    }

    public void setTunaSrcNormalShadowDx(float f) {
        setTunaSrcNormalShadowDx(1, f);
    }

    public void setTunaSrcNormalShadowDx(int i, float f) {
        setTunaSrcNormalShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcNormalShadowDxRaw(float f) {
        if (this.tunaSrcNormalShadowDx != f) {
            this.tunaSrcNormalShadowDx = f;
            invalidate();
        }
    }

    public float getTunaSrcNormalShadowDy() {
        return this.tunaSrcNormalShadowDy;
    }

    public void setTunaSrcNormalShadowDy(float f) {
        setTunaSrcNormalShadowDy(1, f);
    }

    public void setTunaSrcNormalShadowDy(int i, float f) {
        setTunaSrcNormalShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcNormalShadowDyRaw(float f) {
        if (this.tunaSrcNormalShadowDy != f) {
            this.tunaSrcNormalShadowDy = f;
            invalidate();
        }
    }

    public float getTunaSrcPressShadowRadius() {
        return this.tunaSrcPressShadowRadius;
    }

    public void setTunaSrcPressShadowRadius(float f) {
        setTunaSrcPressShadowRadius(1, f);
    }

    public void setTunaSrcPressShadowRadius(int i, float f) {
        setTunaSrcPressShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcPressShadowRadiusRaw(float f) {
        if (this.tunaSrcPressShadowRadius != f) {
            this.tunaSrcPressShadowRadius = f;
            invalidate();
        }
    }

    public float getTunaSrcPressShadowDx() {
        return this.tunaSrcPressShadowDx;
    }

    public void setTunaSrcPressShadowDx(float f) {
        setTunaSrcPressShadowDx(1, f);
    }

    public void setTunaSrcPressShadowDx(int i, float f) {
        setTunaSrcPressShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcPressShadowDxRaw(float f) {
        if (this.tunaSrcPressShadowDx != f) {
            this.tunaSrcPressShadowDx = f;
            invalidate();
        }
    }

    public float getTunaSrcPressShadowDy() {
        return this.tunaSrcPressShadowDy;
    }

    public void setTunaSrcPressShadowDy(float f) {
        setTunaSrcPressShadowDy(1, f);
    }

    public void setTunaSrcPressShadowDy(int i, float f) {
        setTunaSrcPressShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcPressShadowDyRaw(float f) {
        if (this.tunaSrcPressShadowDy != f) {
            this.tunaSrcPressShadowDy = f;
            invalidate();
        }
    }

    public float getTunaSrcSelectShadowRadius() {
        return this.tunaSrcSelectShadowRadius;
    }

    public void setTunaSrcSelectShadowRadius(float f) {
        setTunaSrcSelectShadowRadius(1, f);
    }

    public void setTunaSrcSelectShadowRadius(int i, float f) {
        setTunaSrcSelectShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcSelectShadowRadiusRaw(float f) {
        if (this.tunaSrcSelectShadowRadius != f) {
            this.tunaSrcSelectShadowRadius = f;
            invalidate();
        }
    }

    public float getTunaSrcSelectShadowDx() {
        return this.tunaSrcSelectShadowDx;
    }

    public void setTunaSrcSelectShadowDx(float f) {
        setTunaSrcSelectShadowDx(1, f);
    }

    public void setTunaSrcSelectShadowDx(int i, float f) {
        setTunaSrcSelectShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcSelectShadowDxRaw(float f) {
        if (this.tunaSrcSelectShadowDx != f) {
            this.tunaSrcSelectShadowDx = f;
            invalidate();
        }
    }

    public float getTunaSrcSelectShadowDy() {
        return this.tunaSrcSelectShadowDy;
    }

    public void setTunaSrcSelectShadowDy(float f) {
        setTunaSrcSelectShadowDy(1, f);
    }

    public void setTunaSrcSelectShadowDy(int i, float f) {
        setTunaSrcSelectShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcSelectShadowDyRaw(float f) {
        if (this.tunaSrcSelectShadowDy != f) {
            this.tunaSrcSelectShadowDy = f;
            invalidate();
        }
    }

    public int getTunaDownloadMarkGravity() {
        return this.tunaSrcAnchorGravity;
    }

    public void setSrcAnchorGravity(int i) {
        this.tunaSrcAnchorGravity = i;
    }

    public Matrix getTunaAnchorMatrix() {
        return this.tunaAnchorMatrix;
    }

    public void setTunaAnchorMatrix(Matrix matrix) {
        this.tunaAnchorMatrix = matrix;
    }

    /* access modifiers changed from: protected */
    public Matrix initTunaAnchorMatrix(float f, float f2) {
        if (this.tunaAnchorMatrix == null) {
            this.tunaAnchorMatrix = new Matrix();
        }
        this.tunaAnchorMatrix.reset();
        this.tunaAnchorMatrix.setScale(f, f2);
        return this.tunaAnchorMatrix;
    }

    public Bitmap getTunaSrcAnchorNormal() {
        return this.tunaSrcAnchorNormal;
    }

    public void setTunaSrcAnchorNormal(Bitmap bitmap) {
        this.tunaSrcAnchorNormal = bitmap;
    }

    public float getTunaSrcAnchorNormalWidth() {
        return this.tunaSrcAnchorNormalWidth;
    }

    public void setTunaSrcAnchorNormalWidth(float f) {
        setTunaSrcAnchorNormalWidth(1, f);
    }

    public void setTunaSrcAnchorNormalWidth(int i, float f) {
        setTunaSrcAnchorNormalWidthRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorNormalWidthRaw(float f) {
        if (this.tunaSrcAnchorNormalWidth != f) {
            this.tunaSrcAnchorNormalWidth = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorNormalHeight() {
        return this.tunaSrcAnchorNormalHeight;
    }

    public void setTunaSrcAnchorNormalHeight(float f) {
        setTunaSrcAnchorNormalHeight(1, f);
    }

    public void setTunaSrcAnchorNormalHeight(int i, float f) {
        setTunaSrcAnchorNormalHeightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorNormalHeightRaw(float f) {
        if (this.tunaSrcAnchorNormalHeight != f) {
            this.tunaSrcAnchorNormalHeight = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorNormalDx() {
        return this.tunaSrcAnchorNormalDx;
    }

    public void setTunaSrcAnchorNormalDx(float f) {
        setTunaSrcAnchorNormalDx(1, f);
    }

    public void setTunaSrcAnchorNormalDx(int i, float f) {
        setTunaSrcAnchorNormalDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorNormalDxRaw(float f) {
        if (this.tunaSrcAnchorNormalDx != f) {
            this.tunaSrcAnchorNormalDx = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorNormalDy() {
        return this.tunaSrcAnchorNormalDy;
    }

    public void setTunaSrcAnchorNormalDy(float f) {
        setTunaSrcAnchorNormalDy(1, f);
    }

    public void setTunaSrcAnchorNormalDy(int i, float f) {
        setTunaSrcAnchorNormalDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorNormalDyRaw(float f) {
        if (this.tunaSrcAnchorNormalDy != f) {
            this.tunaSrcAnchorNormalDy = f;
            invalidate();
        }
    }

    public Bitmap getTunaSrcAnchorPress() {
        return this.tunaSrcAnchorPress;
    }

    public void setTunaSrcAnchorPress(Bitmap bitmap) {
        this.tunaSrcAnchorPress = bitmap;
    }

    public float getTunaSrcAnchorPressWidth() {
        return this.tunaSrcAnchorPressWidth;
    }

    public void setTunaSrcAnchorPressWidth(float f) {
        setTunaSrcAnchorPressWidth(1, f);
    }

    public void setTunaSrcAnchorPressWidth(int i, float f) {
        setTunaSrcAnchorPressWidthRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorPressWidthRaw(float f) {
        if (this.tunaSrcAnchorPressWidth != f) {
            this.tunaSrcAnchorPressWidth = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorPressHeight() {
        return this.tunaSrcAnchorPressHeight;
    }

    public void setTunaSrcAnchorPressHeight(float f) {
        setTunaSrcAnchorPressHeight(1, f);
    }

    public void setTunaSrcAnchorPressHeight(int i, float f) {
        setTunaSrcAnchorPressHeightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorPressHeightRaw(float f) {
        if (this.tunaSrcAnchorPressHeight != f) {
            this.tunaSrcAnchorPressHeight = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorPressDx() {
        return this.tunaSrcAnchorPressDx;
    }

    public void setTunaSrcAnchorPressDx(float f) {
        setTunaSrcAnchorPressDx(1, f);
    }

    public void setTunaSrcAnchorPressDx(int i, float f) {
        setTunaSrcAnchorPressDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorPressDxRaw(float f) {
        if (this.tunaSrcAnchorPressDx != f) {
            this.tunaSrcAnchorPressDx = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorPressDy() {
        return this.tunaSrcAnchorPressDy;
    }

    public void setTunaSrcAnchorPressDy(float f) {
        setTunaSrcAnchorPressDy(1, f);
    }

    public void setTunaSrcAnchorPressDy(int i, float f) {
        setTunaSrcAnchorPressDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorPressDyRaw(float f) {
        if (this.tunaSrcAnchorPressDy != f) {
            this.tunaSrcAnchorPressDy = f;
            invalidate();
        }
    }

    public Bitmap getTunaSrcAnchorSelect() {
        return this.tunaSrcAnchorSelect;
    }

    public void setTunaSrcAnchorSelect(Bitmap bitmap) {
        this.tunaSrcAnchorSelect = bitmap;
    }

    public float getTunaSrcAnchorSelectWidth() {
        return this.tunaSrcAnchorSelectWidth;
    }

    public void setTunaSrcAnchorSelectWidth(float f) {
        setTunaSrcAnchorSelectWidth(1, f);
    }

    public void setTunaSrcAnchorSelectWidth(int i, float f) {
        setTunaSrcAnchorSelectWidthRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorSelectWidthRaw(float f) {
        if (this.tunaSrcAnchorSelectWidth != f) {
            this.tunaSrcAnchorSelectWidth = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorSelectHeight() {
        return this.tunaSrcAnchorSelectHeight;
    }

    public void setTunaSrcAnchorSelectHeight(float f) {
        setTunaSrcAnchorSelectHeight(1, f);
    }

    public void setTunaSrcAnchorSelectHeight(int i, float f) {
        setTunaSrcAnchorSelectHeightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorSelectHeightRaw(float f) {
        if (this.tunaSrcAnchorSelectHeight != f) {
            this.tunaSrcAnchorSelectHeight = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorSelectDx() {
        return this.tunaSrcAnchorSelectDx;
    }

    public void setTunaSrcAnchorSelectDx(float f) {
        setTunaSrcAnchorSelectDx(1, f);
    }

    public void setTunaSrcAnchorSelectDx(int i, float f) {
        setTunaSrcAnchorSelectDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorSelectDxRaw(float f) {
        if (this.tunaSrcAnchorSelectDx != f) {
            this.tunaSrcAnchorSelectDx = f;
            invalidate();
        }
    }

    public float getTunaSrcAnchorSelectDy() {
        return this.tunaSrcAnchorSelectDy;
    }

    public void setTunaSrcAnchorSelectDy(float f) {
        setTunaSrcAnchorSelectDy(1, f);
    }

    public void setTunaSrcAnchorSelectDy(int i, float f) {
        setTunaSrcAnchorSelectDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcAnchorSelectDyRaw(float f) {
        if (this.tunaSrcAnchorSelectDy != f) {
            this.tunaSrcAnchorSelectDy = f;
            invalidate();
        }
    }

    public float getTunaStrokeWidthNormal() {
        return this.tunaStrokeWidthNormal;
    }

    public void setTunaStrokeWidthNormal(float f) {
        setTunaStrokeWidthNormal(1, f);
    }

    public void setTunaStrokeWidthNormal(int i, float f) {
        setTunaStrokeWidthNormalRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaStrokeWidthNormalRaw(float f) {
        if (this.tunaStrokeWidthNormal != f) {
            this.tunaStrokeWidthNormal = f;
            invalidate();
        }
    }

    public int getTunaStrokeColorNormal() {
        return this.tunaStrokeColorNormal;
    }

    public void setTunaStrokeColorNormal(int i) {
        this.tunaStrokeColorNormal = i;
    }

    public float getTunaStrokeWidthPress() {
        return this.tunaStrokeWidthPress;
    }

    public void setTunaStrokeWidthPress(float f) {
        setTunaStrokeWidthPress(1, f);
    }

    public void setTunaStrokeWidthPress(int i, float f) {
        setTunaStrokeWidthPressRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaStrokeWidthPressRaw(float f) {
        if (this.tunaStrokeWidthPress != f) {
            this.tunaStrokeWidthPress = f;
            invalidate();
        }
    }

    public int getTunaStrokeColorPress() {
        return this.tunaStrokeColorPress;
    }

    public void setTunaStrokeColorPress(int i) {
        this.tunaStrokeColorPress = i;
    }

    public float getTunaStrokeWidthSelect() {
        return this.tunaStrokeWidthSelect;
    }

    public void setTunaStrokeWidthSelect(float f) {
        setTunaStrokeWidthSelect(1, f);
    }

    public void setTunaStrokeWidthSelect(int i, float f) {
        setTunaStrokeWidthSelectRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaStrokeWidthSelectRaw(float f) {
        if (this.tunaStrokeWidthSelect != f) {
            this.tunaStrokeWidthSelect = f;
            invalidate();
        }
    }

    public int getTunaStrokeColorSelect() {
        return this.tunaStrokeColorSelect;
    }

    public void setTunaStrokeColorSelect(int i) {
        this.tunaStrokeColorSelect = i;
    }

    public float getTunaRadius() {
        return this.tunaRadius;
    }

    public void setTunaRadius(float f) {
        setTunaRadius(1, f);
    }

    public void setTunaRadius(int i, float f) {
        setTunaRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRadiusRaw(float f) {
        if (this.tunaRadius != f) {
            this.tunaRadius = f;
            invalidate();
        }
    }

    public float getTunaRadiusLeftTop() {
        return this.tunaRadiusLeftTop;
    }

    public void setTunaRadiusLeftTop(float f) {
        setTunaRadiusLeftTop(1, f);
    }

    public void setTunaRadiusLeftTop(int i, float f) {
        setTunaRadiusLeftTopRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRadiusLeftTopRaw(float f) {
        if (this.tunaRadiusLeftTop != f) {
            this.tunaRadiusLeftTop = f;
            invalidate();
        }
    }

    public float getTunaRadiusLeftBottom() {
        return this.tunaRadiusLeftBottom;
    }

    public void setTunaRadiusLeftBottom(float f) {
        setTunaRadiusLeftBottom(1, f);
    }

    public void setTunaRadiusLeftBottom(int i, float f) {
        setTunaRadiusLeftBottomRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRadiusLeftBottomRaw(float f) {
        if (this.tunaRadiusLeftBottom != f) {
            this.tunaRadiusLeftBottom = f;
            invalidate();
        }
    }

    public float getTunaRadiusRightTop() {
        return this.tunaRadiusRightTop;
    }

    public void setTunaRadiusRightTop(float f) {
        setTunaRadiusRightTop(1, f);
    }

    public void setTunaRadiusRightTop(int i, float f) {
        setTunaRadiusRightTopRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRadiusRightTopRaw(float f) {
        if (this.tunaRadiusRightTop != f) {
            this.tunaRadiusRightTop = f;
            invalidate();
        }
    }

    public float getTunaRadiusRightBottom() {
        return this.tunaRadiusRightBottom;
    }

    public void setTunaRadiusRightBottom(float f) {
        setTunaRadiusRightBottom(1, f);
    }

    public void setTunaRadiusRightBottom(int i, float f) {
        setTunaRadiusRightBottomRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRadiusRightBottomRaw(float f) {
        if (this.tunaRadiusRightBottom != f) {
            this.tunaRadiusRightBottom = f;
            invalidate();
        }
    }

    public boolean isTunaTextMark() {
        return this.tunaTextMark;
    }

    public void setTunaTextMark(boolean z) {
        this.tunaTextMark = z;
        invalidate();
    }

    public void setTunaTextMark(String str) {
        this.tunaTextMarkTextValue = str;
        requestLayout();
    }

    public void setTunaTextMark(float f, int i, String str, float f2, int i2, float f3, float f4) {
        setTunaTextMark(1, f, i, str, 1, f2, i2, 1, f3, 1, f4);
    }

    public void setTunaTextMark(int i, float f, int i2, String str, int i3, float f2, int i4, int i5, float f3, int i6, float f4) {
        DisplayMetrics viewDisplayMetrics = getViewDisplayMetrics(this);
        int i7 = i;
        float f5 = f;
        int i8 = i3;
        float f6 = f2;
        setTunaTextMarkRaw(applyDimension(i, f, viewDisplayMetrics), i2, str, applyDimension(i3, f2, viewDisplayMetrics), i4, applyDimension(i5, f3, viewDisplayMetrics), applyDimension(i6, f4, viewDisplayMetrics));
    }

    private void setTunaTextMarkRaw(float f, int i, String str, float f2, int i2, float f3, float f4) {
        if (this.tunaTextMarkRadius != f || this.tunaTextMarkColor != i || !TextUtils.equals(this.tunaTextMarkTextValue, str) || this.tunaTextMarkTextSize != f2 || this.tunaTextMarkTextColor != i2 || this.tunaTextMarkDx != f3 || this.tunaTextMarkDy != f4) {
            this.tunaTextMarkRadius = f;
            this.tunaTextMarkColor = i;
            this.tunaTextMarkTextValue = str;
            this.tunaTextMarkTextSize = f2;
            this.tunaTextMarkTextColor = i2;
            this.tunaTextMarkDx = f3;
            this.tunaTextMarkDy = f4;
            this.tunaTextMark = true;
            invalidate();
        }
    }

    public boolean isTunaTextMarkTouchable() {
        return this.tunaTextMarkTouchable;
    }

    public void setTunaTextMarkTouchable(boolean z) {
        this.tunaTextMarkTouchable = z;
    }

    public float getTunaTextMarkRadius() {
        return this.tunaTextMarkRadius;
    }

    public void setTunaTextMarkRadius(float f) {
        setTunaTextMarkRadius(1, f);
    }

    public void setTunaTextMarkRadius(int i, float f) {
        setTunaTextMarkRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextMarkRadiusRaw(float f) {
        if (this.tunaTextMarkRadius != f) {
            this.tunaTextMarkRadius = f;
            invalidate();
        }
    }

    public int getTunaTextMarkColor() {
        return this.tunaTextMarkColor;
    }

    public void setTunaTextMarkColor(int i) {
        this.tunaTextMarkColor = i;
    }

    public String getTunaTextMarkTextValue() {
        return this.tunaTextMarkTextValue;
    }

    public void setTunaTextMarkTextValue(String str) {
        this.tunaTextMarkTextValue = str;
        requestLayout();
    }

    public List<Integer> getTunaTextMarkTextValueMeasureList() {
        return this.tunaTextMarkTextValueMeasureList;
    }

    public void setTunaTextMarkTextValueMeasureList(List<Integer> list) {
        this.tunaTextMarkTextValueMeasureList = list;
    }

    public float getTunaTextMarkTextSize() {
        return this.tunaTextMarkTextSize;
    }

    public void setTunaTextMarkTextSize(float f) {
        setTunaTextMarkTextSize(1, f);
    }

    public void setTunaTextMarkTextSize(int i, float f) {
        setTunaTextMarkTextSizeRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextMarkTextSizeRaw(float f) {
        if (this.tunaTextMarkTextSize != f) {
            this.tunaTextMarkTextSize = f;
            invalidate();
        }
    }

    public int getTunaTextMarkTextColor() {
        return this.tunaTextMarkTextColor;
    }

    public void setTunaTextMarkTextColor(int i) {
        this.tunaTextMarkTextColor = i;
    }

    public float getTunaTextMarkDx() {
        return this.tunaTextMarkDx;
    }

    public void setTunaTextMarkDx(float f) {
        setTunaTextMarkDx(1, f);
    }

    public void setTunaTextMarkDx(int i, float f) {
        setTunaTextMarkDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextMarkDxRaw(float f) {
        if (this.tunaTextMarkDx != f) {
            this.tunaTextMarkDx = f;
            invalidate();
        }
    }

    public float getTunaTextMarkDy() {
        return this.tunaTextMarkDy;
    }

    public void setTunaTextMarkDy(float f) {
        setTunaTextMarkDy(1, f);
    }

    public void setTunaTextMarkDy(int i, float f) {
        setTunaTextMarkDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextMarkDyRaw(float f) {
        if (this.tunaTextMarkDy != f) {
            this.tunaTextMarkDy = f;
            invalidate();
        }
    }

    public float getTunaTextMarkFractionDx() {
        return this.tunaTextMarkFractionDx;
    }

    public void setTunaTextMarkFractionDx(float f) {
        this.tunaTextMarkFractionDx = f;
    }

    public float getTunaTextMarkFractionDy() {
        return this.tunaTextMarkFractionDy;
    }

    public void setTunaTextMarkFractionDy(float f) {
        this.tunaTextMarkFractionDy = f;
    }

    public String getTunaTextValue() {
        return this.tunaTextValue;
    }

    public void setTunaTextValue(String str) {
        this.tunaTextValue = str;
        requestLayout();
    }

    public List<Integer> getTunaTextValueMeasureList() {
        return this.tunaTextValueMeasureList;
    }

    public void setTunaTextValueMeasureList(List<Integer> list) {
        this.tunaTextValueMeasureList = list;
    }

    public float getTunaTextSize() {
        return this.tunaTextSize;
    }

    public void setTunaTextSize(float f) {
        setTunaTextSize(1, f);
    }

    public void setTunaTextSize(int i, float f) {
        setTunaTextSizeRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextSizeRaw(float f) {
        if (this.tunaTextSize != f) {
            this.tunaTextSize = f;
            invalidate();
        }
    }

    public int getTunaTextColorNormal() {
        return this.tunaTextColorNormal;
    }

    public void setTunaTextColorNormal(int i) {
        this.tunaTextColorNormal = i;
    }

    public int getTunaTextColorPress() {
        return this.tunaTextColorPress;
    }

    public void setTunaTextColorPress(int i) {
        this.tunaTextColorPress = i;
    }

    public int getTunaTextColorSelect() {
        return this.tunaTextColorSelect;
    }

    public void setTunaTextColorSelect(int i) {
        this.tunaTextColorSelect = i;
    }

    public float getTunaTextPaddingLeft() {
        return this.tunaTextPaddingLeft;
    }

    public void setTunaTextPaddingLeft(float f) {
        setTunaTextPaddingLeft(1, f);
    }

    public void setTunaTextPaddingLeft(int i, float f) {
        setTunaTextPaddingLeftRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextPaddingLeftRaw(float f) {
        if (this.tunaTextPaddingLeft != f) {
            this.tunaTextPaddingLeft = f;
            invalidate();
        }
    }

    public float getTunaTextPaddingRight() {
        return this.tunaTextPaddingRight;
    }

    public void setTunaTextPaddingRight(float f) {
        setTunaTextPaddingRight(1, f);
    }

    public void setTunaTextPaddingRight(int i, float f) {
        setTunaTextPaddingRightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextPaddingRightRaw(float f) {
        if (this.tunaTextPaddingRight != f) {
            this.tunaTextPaddingRight = f;
            invalidate();
        }
    }

    public float getTunaTextRowSpaceRatio() {
        return this.tunaTextRowSpaceRatio;
    }

    public void setTunaTextRowSpaceRatio(float f) {
        this.tunaTextRowSpaceRatio = f;
    }

    public enum TunaTextGravity {
        ALL_CENTER(0),
        ALL_LEFT(1),
        CENTER_LEFT(2),
        LEFT_CENTER(3);
        
        final int nativeInt;

        private TunaTextGravity(int i) {
            this.nativeInt = i;
        }
    }

    public TunaTextGravity getTunaTextGravity() {
        return this.tunaTextGravity;
    }

    public void setTunaTextGravity(TunaTextGravity tunaTextGravity2) {
        this.tunaTextGravity = tunaTextGravity2;
    }

    public enum TunaTextTypeFace {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        final int nativeInt;

        private TunaTextTypeFace(int i) {
            this.nativeInt = i;
        }
    }

    public Typeface getTunaTextTypeFace() {
        return this.tunaTextTypeFace;
    }

    public void setTunaTextTypeFace(Typeface typeface) {
        this.tunaTextTypeFace = typeface;
    }

    public float getTunaTextDx() {
        return this.tunaTextDx;
    }

    public void setTunaTextDx(float f) {
        setTunaTextDx(1, f);
    }

    public void setTunaTextDx(int i, float f) {
        setTunaTextDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextDxRaw(float f) {
        if (this.tunaTextDx != f) {
            this.tunaTextDx = f;
            invalidate();
        }
    }

    public float getTunaTextDy() {
        return this.tunaTextDy;
    }

    public void setTunaTextDy(float f) {
        setTunaTextDy(1, f);
    }

    public void setTunaTextDy(int i, float f) {
        setTunaTextDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextDyRaw(float f) {
        if (this.tunaTextDy != f) {
            this.tunaTextDy = f;
            invalidate();
        }
    }

    public float getTunaTextFractionDx() {
        return this.tunaTextFractionDx;
    }

    public void setTunaTextFractionDx(float f) {
        this.tunaTextFractionDx = f;
    }

    public float getTunaTextFractionDy() {
        return this.tunaTextFractionDy;
    }

    public void setTunaTextFractionDy(float f) {
        this.tunaTextFractionDy = f;
    }

    public float getTunaTextShadowRadius() {
        return this.tunaTextShadowRadius;
    }

    public void setTunaTextShadowRadius(float f) {
        setTunaTextShadowRadius(1, f);
    }

    public void setTunaTextShadowRadius(int i, float f) {
        setTunaTextShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextShadowRadiusRaw(float f) {
        if (this.tunaTextShadowRadius != f) {
            this.tunaTextShadowRadius = f;
            invalidate();
        }
    }

    public int getTunaTextShadowColor() {
        return this.tunaTextShadowColor;
    }

    public void setTunaTextShadowColor(int i) {
        this.tunaTextShadowColor = i;
    }

    public float getTunaTextShadowDx() {
        return this.tunaTextShadowDx;
    }

    public void setTunaTextShadowDx(float f) {
        setTunaTextShadowDx(1, f);
    }

    public void setTunaTextShadowDx(int i, float f) {
        setTunaTextShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextShadowDxRaw(float f) {
        if (this.tunaTextShadowDx != f) {
            this.tunaTextShadowDx = f;
            invalidate();
        }
    }

    public float getTunaTextShadowDy() {
        return this.tunaTextShadowDy;
    }

    public void setTunaTextShadowDy(float f) {
        setTunaTextShadowDy(1, f);
    }

    public void setTunaTextShadowDy(int i, float f) {
        setTunaTextShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaTextShadowDyRaw(float f) {
        if (this.tunaTextShadowDy != f) {
            this.tunaTextShadowDy = f;
            invalidate();
        }
    }

    public String getTunaContentValue() {
        return this.tunaContentValue;
    }

    public void setTunaContentValue(String str) {
        this.tunaContentValue = str;
        requestLayout();
    }

    public List<Integer> getTunaContentValueMeasureList() {
        return this.tunaContentValueMeasureList;
    }

    public void setTunaContentValueMeasureList(List<Integer> list) {
        this.tunaContentValueMeasureList = list;
    }

    public float getTunaContentSize() {
        return this.tunaContentSize;
    }

    public void setTunaContentSize(float f) {
        setTunaContentSize(1, f);
    }

    public void setTunaContentSize(int i, float f) {
        setTunaContentSizeRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentSizeRaw(float f) {
        if (this.tunaContentSize != f) {
            this.tunaContentSize = f;
            invalidate();
        }
    }

    public float getTunaContentShadowRadius() {
        return this.tunaContentShadowRadius;
    }

    public void setTunaContentShadowRadius(float f) {
        setTunaContentShadowRadius(1, f);
    }

    public void setTunaContentShadowRadius(int i, float f) {
        setTunaContentShadowRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentShadowRadiusRaw(float f) {
        if (this.tunaContentShadowRadius != f) {
            this.tunaContentShadowRadius = f;
            invalidate();
        }
    }

    public int getTunaContentShadowColor() {
        return this.tunaContentShadowColor;
    }

    public void setTunaContentShadowColor(int i) {
        this.tunaContentShadowColor = i;
    }

    public float getTunaContentShadowDx() {
        return this.tunaContentShadowDx;
    }

    public void setTunaContentShadowDx(float f) {
        setTunaContentShadowDx(1, f);
    }

    public void setTunaContentShadowDx(int i, float f) {
        setTunaContentShadowDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentShadowDxRaw(float f) {
        if (this.tunaContentShadowDx != f) {
            this.tunaContentShadowDx = f;
            invalidate();
        }
    }

    public float getTunaContentShadowDy() {
        return this.tunaContentShadowDy;
    }

    public void setTunaContentShadowDy(float f) {
        setTunaContentShadowDy(1, f);
    }

    public void setTunaContentShadowDy(int i, float f) {
        setTunaContentShadowDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentShadowDyRaw(float f) {
        if (this.tunaContentShadowDy != f) {
            this.tunaContentShadowDy = f;
            invalidate();
        }
    }

    public int getTunaContentColorNormal() {
        return this.tunaContentColorNormal;
    }

    public void setTunaContentColorNormal(int i) {
        this.tunaContentColorNormal = i;
    }

    public int getTunaContentColorPress() {
        return this.tunaContentColorPress;
    }

    public void setTunaContentColorPress(int i) {
        this.tunaContentColorPress = i;
    }

    public int getTunaContentColorSelect() {
        return this.tunaContentColorSelect;
    }

    public void setTunaContentColorSelect(int i) {
        this.tunaContentColorSelect = i;
    }

    public float getTunaContentPaddingLeft() {
        return this.tunaContentPaddingLeft;
    }

    public void setTunaContentPaddingLeft(float f) {
        setTunaContentPaddingLeft(1, f);
    }

    public void setTunaContentPaddingLeft(int i, float f) {
        setTunaContentPaddingLeftRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentPaddingLeftRaw(float f) {
        if (this.tunaContentPaddingLeft != f) {
            this.tunaContentPaddingLeft = f;
            invalidate();
        }
    }

    public float getTunaContentPaddingRight() {
        return this.tunaContentPaddingRight;
    }

    public void setTunaContentPaddingRight(float f) {
        setTunaContentPaddingRight(1, f);
    }

    public void setTunaContentPaddingRight(int i, float f) {
        setTunaContentPaddingRightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentPaddingRightRaw(float f) {
        if (this.tunaContentPaddingRight != f) {
            this.tunaContentPaddingRight = f;
            invalidate();
        }
    }

    public float getTunaContentRowSpaceRatio() {
        return this.tunaContentRowSpaceRatio;
    }

    public void setTunaContentRowSpaceRatio(float f) {
        this.tunaContentRowSpaceRatio = f;
    }

    public enum TunaContentGravity {
        ALL_CENTER(0),
        ALL_LEFT(1),
        CENTER_LEFT(2),
        LEFT_CENTER(3);
        
        final int nativeInt;

        private TunaContentGravity(int i) {
            this.nativeInt = i;
        }
    }

    public TunaContentGravity getTunaContentGravity() {
        return this.tunaContentGravity;
    }

    public void setTunaContentGravity(TunaContentGravity tunaContentGravity2) {
        this.tunaContentGravity = tunaContentGravity2;
    }

    public enum TunaContentTypeFace {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        final int nativeInt;

        private TunaContentTypeFace(int i) {
            this.nativeInt = i;
        }
    }

    public Typeface getTunaContentTypeFace() {
        return this.tunaContentTypeFace;
    }

    public void Typeface(Typeface typeface) {
        this.tunaContentTypeFace = typeface;
    }

    public float getTunaContenttDx() {
        return this.tunaContentDx;
    }

    public void setTunaContentDx(float f) {
        setTunaTextDx(1, f);
    }

    public void setTunaContentDx(int i, float f) {
        setTunaContentDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentDxRaw(float f) {
        if (this.tunaContentDx != f) {
            this.tunaContentDx = f;
            invalidate();
        }
    }

    public float getTunaContentDy() {
        return this.tunaContentDy;
    }

    public void setTunaContentDy(float f) {
        setTunaContentDy(1, f);
    }

    public void setTunaContentDy(int i, float f) {
        setTunaContentDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentDyRaw(float f) {
        if (this.tunaContentDy != f) {
            this.tunaContentDy = f;
            invalidate();
        }
    }

    public float getTunaContentFractionDx() {
        return this.tunaContentFractionDx;
    }

    public void setTunaContentFractionDx(float f) {
        this.tunaContentFractionDx = f;
    }

    public float getTunaContentFractionDy() {
        return this.tunaContentFractionDy;
    }

    public void setTunaContentFractionDy(float f) {
        this.tunaContentFractionDy = f;
    }

    public boolean isTunaContentMark() {
        return this.tunaContentMark;
    }

    public void setTunaContentMark(boolean z) {
        this.tunaContentMark = z;
        invalidate();
    }

    public void setTunaContentMark(String str) {
        this.tunaContentMarkTextValue = str;
        invalidate();
    }

    public void setTunaContentMark(float f, int i, String str, float f2, int i2, float f3, float f4) {
        setTunaContentMark(1, f, i, str, 1, f2, i2, 1, f3, 1, f4);
    }

    public void setTunaContentMark(int i, float f, int i2, String str, int i3, float f2, int i4, int i5, float f3, int i6, float f4) {
        DisplayMetrics viewDisplayMetrics = getViewDisplayMetrics(this);
        int i7 = i;
        float f5 = f;
        int i8 = i3;
        float f6 = f2;
        setTunaContentMarkRaw(applyDimension(i, f, viewDisplayMetrics), i2, str, applyDimension(i3, f2, viewDisplayMetrics), i4, applyDimension(i5, f3, viewDisplayMetrics), applyDimension(i6, f4, viewDisplayMetrics));
    }

    private void setTunaContentMarkRaw(float f, int i, String str, float f2, int i2, float f3, float f4) {
        if (this.tunaContentMarkRadius != f || this.tunaContentMarkColor != i || this.tunaContentMarkTextValue != str || this.tunaContentMarkTextSize != f2 || this.tunaContentMarkTextColor != i2 || this.tunaContentMarkDx != f3 || this.tunaContentMarkDy != f4) {
            this.tunaContentMarkRadius = f;
            this.tunaContentMarkColor = i;
            this.tunaContentMarkTextValue = str;
            this.tunaContentMarkTextSize = f2;
            this.tunaContentMarkTextColor = i2;
            this.tunaContentMarkDx = f3;
            this.tunaContentMarkDy = f4;
            this.tunaContentMark = true;
            invalidate();
        }
    }

    public boolean isTunaContentMarkTouchable() {
        return this.tunaContentMarkTouchable;
    }

    public void setTunaContentMarkTouchable(boolean z) {
        this.tunaContentMarkTouchable = z;
    }

    public float getTunaContentMarkRadius() {
        return this.tunaContentMarkRadius;
    }

    public void setTunaContentMarkRadius(float f) {
        setTunaContentMarkRadius(1, f);
    }

    public void setTunaContentMarkRadius(int i, float f) {
        setTunaContentMarkRadiusRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentMarkRadiusRaw(float f) {
        if (this.tunaContentMarkRadius != f) {
            this.tunaContentMarkRadius = f;
            invalidate();
        }
    }

    public int getTunaContentMarkColor() {
        return this.tunaContentMarkColor;
    }

    public void setTunaContentMarkColor(int i) {
        this.tunaContentMarkColor = i;
    }

    public String getTunaContentMarkTextValue() {
        return this.tunaContentMarkTextValue;
    }

    public void setTunaContentMarkTextValue(String str) {
        this.tunaContentMarkTextValue = str;
        requestLayout();
    }

    public List<Integer> getTunaContentMarkTextValueMeasureList() {
        return this.tunaContentMarkTextValueMeasureList;
    }

    public void setTunaContentMarkTextValueMeasureList(List<Integer> list) {
        this.tunaContentMarkTextValueMeasureList = list;
    }

    public float getTunaContentMarkTextSize() {
        return this.tunaContentMarkTextSize;
    }

    public void setTunaContentMarkTextSize(float f) {
        setTunaContentMarkTextSize(1, f);
    }

    public void setTunaContentMarkTextSize(int i, float f) {
        setTunaContentMarkTextSizeRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentMarkTextSizeRaw(float f) {
        if (this.tunaContentMarkTextSize != f) {
            this.tunaContentMarkTextSize = f;
            invalidate();
        }
    }

    public int getTunaContentMarkTextColor() {
        return this.tunaContentMarkTextColor;
    }

    public void setTunaContentMarkTextColor(int i) {
        this.tunaContentMarkTextColor = i;
    }

    public float getTunaContentMarkDx() {
        return this.tunaContentMarkDx;
    }

    public void setTunaContentMarkDx(float f) {
        setTunaContentMarkDx(1, f);
    }

    public void setTunaContentMarkDx(int i, float f) {
        setTunaContentMarkDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentMarkDxRaw(float f) {
        if (this.tunaContentMarkDx != f) {
            this.tunaContentMarkDx = f;
            invalidate();
        }
    }

    public float getTunaContentMarkDy() {
        return this.tunaContentMarkDy;
    }

    public void setTunaContentMarkDy(float f) {
        setTunaContentMarkDy(1, f);
    }

    public void setTunaContentMarkDy(int i, float f) {
        setTunaContentMarkDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaContentMarkDyRaw(float f) {
        if (this.tunaContentMarkDy != f) {
            this.tunaContentMarkDy = f;
            invalidate();
        }
    }

    public float getTunaContentMarkFractionDx() {
        return this.tunaContentMarkFractionDx;
    }

    public void setTunaContentMarkFractionDx(float f) {
        this.tunaContentMarkFractionDx = f;
    }

    public float getTunaContentMarkFractionDy() {
        return this.tunaContentMarkFractionDy;
    }

    public void setTunaContentMarkFractionDy(float f) {
        this.tunaContentMarkFractionDy = f;
    }

    public Bitmap getTunaSrcLeft() {
        return this.tunaSrcLeft;
    }

    public void setTunaSrcLeft(Bitmap bitmap) {
        this.tunaSrcLeft = bitmap;
    }

    public float getTunaSrcLeftWidth() {
        return this.tunaSrcLeftWidth;
    }

    public void setTunaSrcLeftWidth(float f) {
        setTunaSrcLeftWidth(1, f);
    }

    public void setTunaSrcLeftWidth(int i, float f) {
        setTunaSrcLeftWidthRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcLeftWidthRaw(float f) {
        if (this.tunaSrcLeftWidth != f) {
            this.tunaSrcLeftWidth = f;
            invalidate();
        }
    }

    public float getTunaSrcLeftHeight() {
        return this.tunaSrcLeftHeight;
    }

    public void setTunaSrcLeftHeight(float f) {
        setTunaSrcLeftHeight(1, f);
    }

    public void setTunaSrcLeftHeight(int i, float f) {
        setTunaSrcLeftHeightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcLeftHeightRaw(float f) {
        if (this.tunaSrcLeftHeight != f) {
            this.tunaSrcLeftHeight = f;
            invalidate();
        }
    }

    public Matrix getTunaLeftMatrix() {
        return this.tunaLeftMatrix;
    }

    public void setTunaLeftMatrix(Matrix matrix) {
        this.tunaLeftMatrix = matrix;
    }

    /* access modifiers changed from: protected */
    public Matrix initTunaLeftMatrix(float f, float f2) {
        if (this.tunaLeftMatrix == null) {
            this.tunaLeftMatrix = new Matrix();
        }
        this.tunaLeftMatrix.reset();
        this.tunaLeftMatrix.setScale(f, f2);
        return this.tunaLeftMatrix;
    }

    public float getTunaSrcLeftPadding() {
        return this.tunaSrcLeftPadding;
    }

    public void setTunaSrcLeftPadding(float f) {
        setTunaSrcLeftPadding(1, f);
    }

    public void setTunaSrcLeftPadding(int i, float f) {
        setTunaSrcLeftPaddingRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcLeftPaddingRaw(float f) {
        if (this.tunaSrcLeftPadding != f) {
            this.tunaSrcLeftPadding = f;
            invalidate();
        }
    }

    public float getTunaSrcLeftDx() {
        return this.tunaSrcLeftDx;
    }

    public void setTunaSrcLeftDx(float f) {
        setTunaSrcLeftDx(1, f);
    }

    public void setTunaSrcLeftDx(int i, float f) {
        setTunaSrcLeftDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcLeftDxRaw(float f) {
        if (this.tunaSrcLeftDx != f) {
            this.tunaSrcLeftDx = f;
            invalidate();
        }
    }

    public float getTunaSrcLeftDy() {
        return this.tunaSrcLeftDy;
    }

    public void setTunaSrcLeftDy(float f) {
        setTunaSrcLeftDy(1, f);
    }

    public void setTunaSrcLeftDy(int i, float f) {
        setTunaSrcLeftDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcLeftDyRaw(float f) {
        if (this.tunaSrcLeftDy != f) {
            this.tunaSrcLeftDy = f;
            invalidate();
        }
    }

    public Bitmap getTunaSrcRight() {
        return this.tunaSrcRight;
    }

    public void setTunaSrcRight(Bitmap bitmap) {
        this.tunaSrcRight = bitmap;
    }

    public float getTunaSrcRightWidth() {
        return this.tunaSrcRightWidth;
    }

    public void setTunaSrcRightWidth(float f) {
        setTunaSrcRightWidth(1, f);
    }

    public void setTunaSrcRightWidth(int i, float f) {
        setTunaSrcRightWidthRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcRightWidthRaw(float f) {
        if (this.tunaSrcRightWidth != f) {
            this.tunaSrcRightWidth = f;
            invalidate();
        }
    }

    public float getTunaSrcRightHeight() {
        return this.tunaSrcRightHeight;
    }

    public void setTunaSrcRightHeight(float f) {
        setTunaSrcRightHeight(1, f);
    }

    public void setTunaSrcRightHeight(int i, float f) {
        setTunaSrcRightHeightRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcRightHeightRaw(float f) {
        if (this.tunaSrcRightHeight != f) {
            this.tunaSrcRightHeight = f;
            invalidate();
        }
    }

    public Matrix getTunaRightMatrix() {
        return this.tunaRightMatrix;
    }

    public void setTunaRightMatrix(Matrix matrix) {
        this.tunaRightMatrix = matrix;
    }

    /* access modifiers changed from: protected */
    public Matrix initTunaRightMatrix(float f, float f2) {
        if (this.tunaRightMatrix == null) {
            this.tunaRightMatrix = new Matrix();
        }
        this.tunaRightMatrix.reset();
        this.tunaRightMatrix.setScale(f, f2);
        return this.tunaRightMatrix;
    }

    public float getTunaSrcRightPadding() {
        return this.tunaSrcRightPadding;
    }

    public void setTunaSrcRightPadding(float f) {
        setTunaSrcRightPadding(1, f);
    }

    public void setTunaSrcRightPadding(int i, float f) {
        setTunaSrcRightPaddingRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcRightPaddingRaw(float f) {
        if (this.tunaSrcRightPadding != f) {
            this.tunaSrcRightPadding = f;
            invalidate();
        }
    }

    public float getTunaSrcRightDx() {
        return this.tunaSrcRightDx;
    }

    public void setTunaSrcRightDx(float f) {
        setTunaSrcRightDx(1, f);
    }

    public void setTunaSrcRightDx(int i, float f) {
        setTunaSrcRightDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcRightDxRaw(float f) {
        if (this.tunaSrcRightDx != f) {
            this.tunaSrcRightDx = f;
            invalidate();
        }
    }

    public float getTunaSrcRightDy() {
        return this.tunaSrcRightDy;
    }

    public void setTunaSrcRightDy(float f) {
        setTunaSrcRightDy(1, f);
    }

    public void setTunaSrcRightDy(int i, float f) {
        setTunaSrcRightDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaSrcRightDyRaw(float f) {
        if (this.tunaSrcRightDy != f) {
            this.tunaSrcRightDy = f;
            invalidate();
        }
    }

    public enum TunaPorterDuffXfermode {
        SRC_IN(0),
        SRC_OUT(1);
        
        final int nativeInt;

        private TunaPorterDuffXfermode(int i) {
            this.nativeInt = i;
        }
    }

    public PorterDuffXfermode getTunaPorterDuffXfermode() {
        return this.tunaPorterDuffXfermode;
    }

    public void setTunaPorterDuffXfermode(PorterDuffXfermode porterDuffXfermode) {
        this.tunaPorterDuffXfermode = porterDuffXfermode;
    }

    public enum TunaMaterial {
        SPREAD(0),
        TRANS(1);
        
        final int nativeInt;

        private TunaMaterial(int i) {
            this.nativeInt = i;
        }
    }

    public TunaMaterial getTunaMaterial() {
        return this.tunaMaterial;
    }

    public void setTunaMaterial(TunaMaterial tunaMaterial2) {
        this.tunaMaterial = tunaMaterial2;
    }

    public boolean isTunaMaterialMove() {
        return this.tunaMaterialMove;
    }

    public void setTunaMaterialMove(boolean z) {
        this.tunaMaterialMove = z;
    }

    public float getTunaMaterialRadius() {
        return this.tunaMaterialRadius;
    }

    public void setTunaMaterialRadius(float f) {
        this.tunaMaterialRadius = f;
    }

    public float getTunaTouchDownEventX() {
        return this.tunaTouchDownEventX;
    }

    public void setTunaTouchDownEventX(float f) {
        this.tunaTouchDownEventX = f;
    }

    public float getTunaTouchDownEventY() {
        return this.tunaTouchDownEventY;
    }

    public void setTunaTouchDownEventY(float f) {
        this.tunaTouchDownEventY = f;
    }

    public int getTunaMaterialDuraction() {
        return this.tunaMaterialDuraction;
    }

    public void setTunaMaterialDuraction(int i) {
        this.tunaMaterialDuraction = i;
    }

    public boolean isTunaMaterialPlay() {
        return this.tunaMaterialPlay;
    }

    public void setTunaMaterialPlay(boolean z) {
        this.tunaMaterialPlay = z;
    }

    public TimeInterpolator getTunaMaterialTimeInterpolator() {
        return this.tunaMaterialTimeInterpolator;
    }

    public void setTunaMaterialTimeInterpolator(TimeInterpolator timeInterpolator) {
        this.tunaMaterialTimeInterpolator = timeInterpolator;
    }

    public enum TunaMaterialTimeInterpolator {
        ACCELERATEDECELERATEINTERPOLATOR(0),
        ACCELERATEINTERPOLATOR(1),
        ANTICIPATEINTERPOLATOR(2),
        ANTICIPATEOVERSHOOTINTERPOLATOR(3),
        BOUNCEINTERPOLATOR(4),
        CYCLEINTERPOLATOR(5),
        DECELERATEINTERPOLATOR(6),
        LINEARINTERPOLATOR(7),
        OVERSHOOTINTERPOLATOR(8);
        
        final int nativeInt;

        private TunaMaterialTimeInterpolator(int i) {
            this.nativeInt = i;
        }
    }

    public AnimatorSet getTunaMaterialAnimatorSet() {
        return this.tunaMaterialAnimatorSet;
    }

    public void setTunaMaterialAnimatorSet(AnimatorSet animatorSet) {
        this.tunaMaterialAnimatorSet = animatorSet;
    }

    public PaintFlagsDrawFilter getTunaPaintFlagsDrawFilter() {
        return this.tunaPaintFlagsDrawFilter;
    }

    public void setTunaPaintFlagsDrawFilter(PaintFlagsDrawFilter paintFlagsDrawFilter) {
        this.tunaPaintFlagsDrawFilter = paintFlagsDrawFilter;
    }

    public TunaView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TunaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0614  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x059c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TunaView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            java.lang.Class<com.tunasashimi.tuna.TunaView> r0 = com.tunasashimi.tuna.TunaView.class
            r7.<init>(r8, r9, r10)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r7.tunaGraphicsMap = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r7.tunaTextRowSpaceRatio = r1
            r7.tunaContentRowSpaceRatio = r1
            r2 = 500(0x1f4, float:7.0E-43)
            r7.tunaMaterialDuraction = r2
            com.tunasashimi.tuna.TunaView$13 r2 = new com.tunasashimi.tuna.TunaView$13
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            java.lang.String r4 = "tunaMaterialRadius"
            r2.<init>(r3, r4)
            r7.tunaMaterialRadiusProperty = r2
            com.tunasashimi.tuna.TunaView$14 r2 = new com.tunasashimi.tuna.TunaView$14
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            java.lang.String r4 = "tunaMaterialPaintX"
            r2.<init>(r3, r4)
            r7.tunaMaterialPaintXProperty = r2
            com.tunasashimi.tuna.TunaView$15 r2 = new com.tunasashimi.tuna.TunaView$15
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            java.lang.String r4 = "tunaMaterialPaintY"
            r2.<init>(r3, r4)
            r7.tunaMaterialPaintYProperty = r2
            android.graphics.PaintFlagsDrawFilter r2 = new android.graphics.PaintFlagsDrawFilter
            r3 = 0
            r4 = 3
            r2.<init>(r3, r4)
            r7.tunaPaintFlagsDrawFilter = r2
            java.lang.String r2 = r0.getSimpleName()
            r7.tunaTag = r2
            android.content.pm.ApplicationInfo r2 = r8.getApplicationInfo()
            int r2 = r2.flags
            r5 = 2
            r2 = r2 & r5
            r6 = 1
            if (r2 == 0) goto L_0x0053
            r2 = 1
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            r7.tunaDebugable = r2
            int[] r2 = com.didi.passenger.C10448R.styleable.TunaView
            android.content.res.TypedArray r8 = r8.obtainStyledAttributes(r9, r2, r3, r10)
            r9 = 146(0x92, float:2.05E-43)
            int r9 = r8.getInt(r9, r3)
            com.tunasashimi.tuna.TunaView$TunaTouchType[] r10 = tunaTouchTypeArray
            r9 = r10[r9]
            r7.tunaTouchType = r9
            r9 = 62
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaPress = r9
            r9 = 69
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaSelect = r9
            r9 = 70
            int r9 = r8.getInt(r9, r3)
            com.tunasashimi.tuna.TunaView$TunaSelectType[] r10 = tunaSelectTypeArray
            r9 = r10[r9]
            r7.tunaSelectType = r9
            boolean r9 = r8.getBoolean(r3, r3)
            r7.tunaAnimationable = r9
            r9 = 68
            int r9 = r8.getInt(r9, r3)
            r7.tunaRotate = r9
            java.lang.Class r9 = r7.getClass()
            if (r0 != r9) goto L_0x009a
            r9 = 1
            goto L_0x009b
        L_0x009a:
            r9 = 0
        L_0x009b:
            r7.tunaSuper = r9
            if (r9 == 0) goto L_0x061a
            int r9 = r8.getColor(r6, r3)
            r7.tunaBackgroundNormal = r9
            r10 = 9
            int r9 = r8.getColor(r10, r9)
            r7.tunaBackgroundPress = r9
            r9 = 17
            int r10 = r7.tunaBackgroundNormal
            int r9 = r8.getColor(r9, r10)
            r7.tunaBackgroundSelect = r9
            r9 = 54
            int r9 = r8.getColor(r9, r3)
            r7.tunaForegroundNormal = r9
            r10 = 55
            int r9 = r8.getColor(r10, r9)
            r7.tunaForegroundPress = r9
            r9 = 56
            int r10 = r7.tunaForegroundNormal
            int r9 = r8.getColor(r9, r10)
            r7.tunaForegroundSelect = r9
            r9 = 2147483647(0x7fffffff, float:NaN)
            int r10 = r8.getInt(r5, r9)
            r7.tunaBackgroundNormalAngle = r10
            if (r10 == r9) goto L_0x00ed
            r10 = 4
            int r0 = r7.tunaBackgroundNormal
            int r10 = r8.getColor(r10, r0)
            r7.tunaBackgroundNormalGradientStart = r10
            int r10 = r7.tunaBackgroundNormal
            int r10 = r8.getColor(r4, r10)
            r7.tunaBackgroundNormalGradientEnd = r10
        L_0x00ed:
            r10 = 10
            int r10 = r8.getInt(r10, r9)
            r7.tunaBackgroundPressAngle = r10
            if (r10 == r9) goto L_0x010b
            r10 = 12
            int r0 = r7.tunaBackgroundPress
            int r10 = r8.getColor(r10, r0)
            r7.tunaBackgroundPressGradientStart = r10
            r10 = 11
            int r0 = r7.tunaBackgroundPress
            int r10 = r8.getColor(r10, r0)
            r7.tunaBackgroundPressGradientEnd = r10
        L_0x010b:
            r10 = 18
            int r10 = r8.getInt(r10, r9)
            r7.tunaBackgroundSelectAngle = r10
            if (r10 == r9) goto L_0x0129
            r9 = 20
            int r10 = r7.tunaBackgroundSelect
            int r9 = r8.getColor(r9, r10)
            r7.tunaBackgroundSelectGradientStart = r9
            r9 = 19
            int r10 = r7.tunaBackgroundSelect
            int r9 = r8.getColor(r9, r10)
            r7.tunaBackgroundSelectGradientEnd = r9
        L_0x0129:
            r9 = 8
            r10 = 0
            float r9 = r8.getDimension(r9, r10)
            r7.tunaBackgroundNormalShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x014b
            r9 = 5
            int r9 = r8.getColor(r9, r3)
            r7.tunaBackgroundNormalShadowColor = r9
            r9 = 6
            float r9 = r8.getDimension(r9, r10)
            r7.tunaBackgroundNormalShadowDx = r9
            r9 = 7
            float r9 = r8.getDimension(r9, r10)
            r7.tunaBackgroundNormalShadowDy = r9
        L_0x014b:
            r9 = 16
            float r0 = r7.tunaBackgroundNormalShadowRadius
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundPressShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0177
            r9 = 13
            int r0 = r7.tunaBackgroundNormalShadowColor
            int r9 = r8.getColor(r9, r0)
            r7.tunaBackgroundPressShadowColor = r9
            r9 = 14
            float r0 = r7.tunaBackgroundNormalShadowDx
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundPressShadowDx = r9
            r9 = 15
            float r0 = r7.tunaBackgroundNormalShadowDy
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundPressShadowDy = r9
        L_0x0177:
            r9 = 24
            float r0 = r7.tunaBackgroundNormalShadowRadius
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundSelectShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x01a3
            r9 = 21
            int r0 = r7.tunaBackgroundNormalShadowColor
            int r9 = r8.getColor(r9, r0)
            r7.tunaBackgroundSelectShadowColor = r9
            r9 = 22
            float r0 = r7.tunaBackgroundNormalShadowDx
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundSelectShadowDx = r9
            r9 = 23
            float r0 = r7.tunaBackgroundNormalShadowDy
            float r9 = r8.getDimension(r9, r0)
            r7.tunaBackgroundSelectShadowDy = r9
        L_0x01a3:
            r9 = 93
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x0253
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcNormal = r9
            r9 = 61
            int r9 = r8.getInt(r9, r3)
            android.graphics.PorterDuffXfermode r2 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode[] r4 = tunaPorterDuffXfermodeArray
            r9 = r4[r9]
            r2.<init>(r9)
            r7.tunaPorterDuffXfermode = r2
            r9 = 97
            int r2 = r8.getResourceId(r9, r0)
            if (r2 == r0) goto L_0x01da
            android.content.res.Resources r4 = r7.getResources()
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r4, r2)
            r7.tunaSrcPress = r2
            goto L_0x01de
        L_0x01da:
            android.graphics.Bitmap r2 = r7.tunaSrcNormal
            r7.tunaSrcPress = r2
        L_0x01de:
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x01ef
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcSelect = r9
            goto L_0x01f3
        L_0x01ef:
            android.graphics.Bitmap r9 = r7.tunaSrcNormal
            r7.tunaSrcSelect = r9
        L_0x01f3:
            r9 = 96
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcNormalShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x020f
            r9 = 94
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcNormalShadowDx = r9
            r9 = 95
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcNormalShadowDy = r9
        L_0x020f:
            r9 = 100
            float r2 = r7.tunaSrcNormalShadowRadius
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcPressShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0231
            r9 = 98
            float r2 = r7.tunaSrcNormalShadowDx
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcPressShadowDx = r9
            r9 = 99
            float r2 = r7.tunaSrcNormalShadowDy
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcPressShadowDy = r9
        L_0x0231:
            r9 = 110(0x6e, float:1.54E-43)
            float r2 = r7.tunaSrcNormalShadowRadius
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcSelectShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0253
            r9 = 108(0x6c, float:1.51E-43)
            float r2 = r7.tunaSrcNormalShadowDx
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcSelectShadowDx = r9
            r9 = 109(0x6d, float:1.53E-43)
            float r2 = r7.tunaSrcNormalShadowDy
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcSelectShadowDy = r9
        L_0x0253:
            r9 = 72
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x030b
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcAnchorNormal = r9
            r9 = 76
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcAnchorNormalWidth = r9
            r9 = 75
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcAnchorNormalHeight = r9
            r9 = 73
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcAnchorNormalDx = r9
            r9 = 74
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcAnchorNormalDy = r9
            r9 = 81
            float r2 = r7.tunaSrcAnchorNormalWidth
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorPressWidth = r9
            r9 = 80
            float r2 = r7.tunaSrcAnchorNormalHeight
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorPressHeight = r9
            r9 = 78
            float r2 = r7.tunaSrcAnchorNormalDx
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorPressDx = r9
            r9 = 79
            float r2 = r7.tunaSrcAnchorNormalDy
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorPressDy = r9
            r9 = 86
            float r2 = r7.tunaSrcAnchorNormalWidth
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorSelectWidth = r9
            r9 = 85
            float r2 = r7.tunaSrcAnchorNormalHeight
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorSelectHeight = r9
            r9 = 83
            float r2 = r7.tunaSrcAnchorNormalDx
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorSelectDx = r9
            r9 = 84
            float r2 = r7.tunaSrcAnchorNormalDy
            float r9 = r8.getDimension(r9, r2)
            r7.tunaSrcAnchorSelectDy = r9
            r9 = 77
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x02e8
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcAnchorPress = r9
            goto L_0x02ec
        L_0x02e8:
            android.graphics.Bitmap r9 = r7.tunaSrcAnchorNormal
            r7.tunaSrcAnchorPress = r9
        L_0x02ec:
            r9 = 82
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x02ff
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcAnchorSelect = r9
            goto L_0x0303
        L_0x02ff:
            android.graphics.Bitmap r9 = r7.tunaSrcAnchorNormal
            r7.tunaSrcAnchorSelect = r9
        L_0x0303:
            r9 = 71
            int r9 = r8.getInt(r9, r3)
            r7.tunaSrcAnchorGravity = r9
        L_0x030b:
            r9 = 87
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x035a
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcLeft = r9
            r9 = 92
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcLeftWidth = r9
            r9 = 90
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcLeftHeight = r9
            r9 = 91
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcLeftPadding = r9
            r9 = 88
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcLeftDx = r9
            r9 = 89
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcLeftDy = r9
            float r9 = r7.tunaSrcLeftWidth
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x0352
            float r9 = r7.tunaSrcLeftHeight
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x0352
            goto L_0x035a
        L_0x0352:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The content attribute require property named tunaSrcLeftWidth and tunaSrcLeftHeight"
            r8.<init>(r9)
            throw r8
        L_0x035a:
            r9 = 101(0x65, float:1.42E-43)
            int r9 = r8.getResourceId(r9, r0)
            if (r9 == r0) goto L_0x03a9
            android.content.res.Resources r2 = r7.getResources()
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r2, r9)
            r7.tunaSrcRight = r9
            r9 = 106(0x6a, float:1.49E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcRightWidth = r9
            r9 = 104(0x68, float:1.46E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcRightHeight = r9
            r9 = 105(0x69, float:1.47E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcRightPadding = r9
            r9 = 102(0x66, float:1.43E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcRightDx = r9
            r9 = 103(0x67, float:1.44E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaSrcRightDy = r9
            float r9 = r7.tunaSrcRightWidth
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x03a1
            float r9 = r7.tunaSrcRightHeight
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x03a1
            goto L_0x03a9
        L_0x03a1:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The content attribute require property named tunaSrcRightWidth and tunaSrcRightHeight"
            r8.<init>(r9)
            throw r8
        L_0x03a9:
            r9 = 125(0x7d, float:1.75E-43)
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaTextMark = r9
            r9 = 135(0x87, float:1.89E-43)
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaTextMarkTouchable = r9
            r9 = 131(0x83, float:1.84E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextMarkRadius = r9
            r9 = 126(0x7e, float:1.77E-43)
            int r9 = r8.getColor(r9, r3)
            r7.tunaTextMarkColor = r9
            r9 = 134(0x86, float:1.88E-43)
            java.lang.String r9 = r8.getString(r9)
            r7.tunaTextMarkTextValue = r9
            r9 = 133(0x85, float:1.86E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextMarkTextSize = r9
            r9 = 132(0x84, float:1.85E-43)
            int r9 = r8.getColor(r9, r3)
            r7.tunaTextMarkTextColor = r9
            r9 = 33
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaContentMark = r9
            r9 = 43
            boolean r9 = r8.getBoolean(r9, r3)
            r7.tunaContentMarkTouchable = r9
            r9 = 39
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentMarkRadius = r9
            r9 = 34
            int r9 = r8.getColor(r9, r3)
            r7.tunaContentMarkColor = r9
            r9 = 42
            java.lang.String r9 = r8.getString(r9)
            r7.tunaContentMarkTextValue = r9
            r9 = 41
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentMarkTextSize = r9
            r9 = 40
            int r9 = r8.getColor(r9, r3)
            r7.tunaContentMarkTextColor = r9
            r9 = 114(0x72, float:1.6E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaStrokeWidthNormal = r9
            r9 = 111(0x6f, float:1.56E-43)
            int r9 = r8.getColor(r9, r3)
            r7.tunaStrokeColorNormal = r9
            r9 = 115(0x73, float:1.61E-43)
            float r2 = r7.tunaStrokeWidthNormal
            float r9 = r8.getDimension(r9, r2)
            r7.tunaStrokeWidthPress = r9
            r9 = 112(0x70, float:1.57E-43)
            int r2 = r7.tunaStrokeColorNormal
            int r9 = r8.getColor(r9, r2)
            r7.tunaStrokeColorPress = r9
            r9 = 116(0x74, float:1.63E-43)
            float r2 = r7.tunaStrokeWidthNormal
            float r9 = r8.getDimension(r9, r2)
            r7.tunaStrokeWidthSelect = r9
            r9 = 113(0x71, float:1.58E-43)
            int r2 = r7.tunaStrokeColorNormal
            int r9 = r8.getColor(r9, r2)
            r7.tunaStrokeColorSelect = r9
            r9 = 63
            float r9 = r8.getDimension(r9, r10)
            r7.tunaRadius = r9
            r2 = 65
            float r9 = r8.getDimension(r2, r9)
            r7.tunaRadiusLeftTop = r9
            r9 = 64
            float r2 = r7.tunaRadius
            float r9 = r8.getDimension(r9, r2)
            r7.tunaRadiusLeftBottom = r9
            r9 = 67
            float r2 = r7.tunaRadius
            float r9 = r8.getDimension(r9, r2)
            r7.tunaRadiusRightTop = r9
            r9 = 66
            float r2 = r7.tunaRadius
            float r9 = r8.getDimension(r9, r2)
            r7.tunaRadiusRightBottom = r9
            float r2 = r7.tunaRadius
            float r4 = r7.tunaRadiusLeftTop
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0499
            float r2 = r7.tunaRadiusLeftBottom
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0499
            float r4 = r7.tunaRadiusRightTop
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0499
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x0499
            r9 = 1
            goto L_0x049a
        L_0x0499:
            r9 = 0
        L_0x049a:
            r7.tunaClassic = r9
            r9 = 145(0x91, float:2.03E-43)
            java.lang.String r9 = r8.getString(r9)
            r7.tunaTextValue = r9
            r9 = 143(0x8f, float:2.0E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextSize = r9
            r9 = 117(0x75, float:1.64E-43)
            int r9 = r8.getColor(r9, r3)
            r7.tunaTextColorNormal = r9
            r2 = 118(0x76, float:1.65E-43)
            int r9 = r8.getColor(r2, r9)
            r7.tunaTextColorPress = r9
            r9 = 119(0x77, float:1.67E-43)
            int r2 = r7.tunaTextColorNormal
            int r9 = r8.getColor(r9, r2)
            r7.tunaTextColorSelect = r9
            r9 = 136(0x88, float:1.9E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextPaddingLeft = r9
            r9 = 137(0x89, float:1.92E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextPaddingRight = r9
            r9 = 138(0x8a, float:1.93E-43)
            float r9 = r8.getFraction(r9, r6, r6, r1)
            r7.tunaTextRowSpaceRatio = r9
            r9 = 124(0x7c, float:1.74E-43)
            int r9 = r8.getInt(r9, r3)
            if (r9 < 0) goto L_0x04ec
            com.tunasashimi.tuna.TunaView$TunaTextGravity[] r2 = tunaTextGravityArray
            r9 = r2[r9]
            r7.tunaTextGravity = r9
        L_0x04ec:
            r9 = 144(0x90, float:2.02E-43)
            int r9 = r8.getInt(r9, r3)
            if (r9 < 0) goto L_0x0500
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            int[] r4 = tunaTextTypeFaceArray
            r9 = r4[r9]
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r2, r9)
            r7.tunaTextTypeFace = r9
        L_0x0500:
            r9 = 120(0x78, float:1.68E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextDx = r9
            r9 = 121(0x79, float:1.7E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextDy = r9
            r9 = 122(0x7a, float:1.71E-43)
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaTextFractionDx = r9
            r9 = 123(0x7b, float:1.72E-43)
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaTextFractionDy = r9
            r9 = 142(0x8e, float:1.99E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0544
            r9 = 139(0x8b, float:1.95E-43)
            int r9 = r8.getColor(r9, r3)
            r7.tunaTextShadowColor = r9
            r9 = 140(0x8c, float:1.96E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextShadowDx = r9
            r9 = 141(0x8d, float:1.98E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextShadowDy = r9
        L_0x0544:
            r9 = 53
            java.lang.String r9 = r8.getString(r9)
            r7.tunaContentValue = r9
            r9 = 51
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentSize = r9
            r9 = 25
            int r9 = r8.getColor(r9, r3)
            r7.tunaContentColorNormal = r9
            r2 = 26
            int r9 = r8.getColor(r2, r9)
            r7.tunaContentColorPress = r9
            r9 = 27
            int r2 = r7.tunaContentColorNormal
            int r9 = r8.getColor(r9, r2)
            r7.tunaContentColorSelect = r9
            r9 = 44
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentPaddingLeft = r9
            r9 = 45
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentPaddingRight = r9
            r9 = 46
            float r9 = r8.getFraction(r9, r6, r6, r1)
            r7.tunaContentRowSpaceRatio = r9
            r9 = 32
            int r9 = r8.getInt(r9, r3)
            if (r9 < 0) goto L_0x0594
            com.tunasashimi.tuna.TunaView$TunaContentGravity[] r1 = tunaContentGravityArray
            r9 = r1[r9]
            r7.tunaContentGravity = r9
        L_0x0594:
            r9 = 52
            int r9 = r8.getInt(r9, r3)
            if (r9 < 0) goto L_0x05a8
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT
            int[] r2 = tunaContentTypeFaceArray
            r9 = r2[r9]
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r1, r9)
            r7.tunaContentTypeFace = r9
        L_0x05a8:
            r9 = 28
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentDx = r9
            r9 = 29
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentDy = r9
            r9 = 30
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaContentFractionDx = r9
            r9 = 31
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaContentFractionDy = r9
            r9 = 50
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentShadowRadius = r9
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x05ec
            r9 = 47
            int r9 = r8.getColor(r9, r3)
            r7.tunaContentShadowColor = r9
            r9 = 48
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentShadowDx = r9
            r9 = 49
            float r9 = r8.getDimension(r9, r10)
            r7.tunaContentShadowDy = r9
        L_0x05ec:
            r9 = 127(0x7f, float:1.78E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextMarkDx = r9
            r9 = 128(0x80, float:1.794E-43)
            float r9 = r8.getDimension(r9, r10)
            r7.tunaTextMarkDy = r9
            r9 = 129(0x81, float:1.81E-43)
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaTextMarkFractionDx = r9
            r9 = 130(0x82, float:1.82E-43)
            float r9 = r8.getFraction(r9, r6, r6, r10)
            r7.tunaTextMarkFractionDy = r9
            r9 = 57
            int r9 = r8.getInt(r9, r0)
            if (r9 <= r0) goto L_0x061a
            com.tunasashimi.tuna.TunaView$TunaMaterial[] r10 = tunaMaterialArray
            r9 = r10[r9]
            r7.tunaMaterial = r9
        L_0x061a:
            r8.recycle()
            r7.initDisplayMetrics()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
        if (r12 <= ((float) r11.tunaHeight)) goto L_0x00a1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            com.tunasashimi.tuna.TunaView$TunaTouchType r0 = r11.tunaTouchType
            com.tunasashimi.tuna.TunaView$TunaTouchType r1 = com.tunasashimi.tuna.TunaView.TunaTouchType.NONE
            if (r0 != r1) goto L_0x000b
            boolean r12 = super.dispatchTouchEvent(r12)
            return r12
        L_0x000b:
            float r0 = r12.getX()
            r11.tunaTouchEventX = r0
            float r0 = r12.getY()
            r11.tunaTouchEventY = r0
            com.tunasashimi.tuna.TunaView$TunaTouchListener r0 = r11.tunaTouchListener
            if (r0 == 0) goto L_0x002a
            com.tunasashimi.tuna.TunaView$TunaTouchType r0 = r11.tunaTouchType
            com.tunasashimi.tuna.TunaView$TunaTouchType r1 = com.tunasashimi.tuna.TunaView.TunaTouchType.ALWAYS
            if (r0 == r1) goto L_0x0025
            boolean r0 = r11.tunaTouchOutBounds
            if (r0 != 0) goto L_0x002a
        L_0x0025:
            com.tunasashimi.tuna.TunaView$TunaTouchListener r0 = r11.tunaTouchListener
            r0.tunaTouch(r11)
        L_0x002a:
            int r0 = r12.getAction()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x012b
            if (r0 == r3) goto L_0x00e5
            if (r0 == r2) goto L_0x0059
            if (r0 == r1) goto L_0x003c
            goto L_0x026e
        L_0x003c:
            r11.tunaPress = r4
            r11.tunaSelect = r4
            boolean r12 = r11.tunaTextMarkTouchable
            if (r12 != 0) goto L_0x0046
            r11.tunaTextMark = r4
        L_0x0046:
            boolean r12 = r11.tunaContentMarkTouchable
            if (r12 != 0) goto L_0x004c
            r11.tunaContentMark = r4
        L_0x004c:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x026e
            com.tunasashimi.tuna.TunaView$TunaTouchCancelListener r12 = r11.tunaTouchCancelListener
            if (r12 == 0) goto L_0x026e
            r12.tunaTouchCancel(r11)
            goto L_0x026e
        L_0x0059:
            com.tunasashimi.tuna.TunaView$TunaTouchType r12 = r11.tunaTouchType
            com.tunasashimi.tuna.TunaView$TunaTouchType r0 = com.tunasashimi.tuna.TunaView.TunaTouchType.ALWAYS
            if (r12 != r0) goto L_0x0065
            r11.tunaPress = r3
            r11.tunaSelect = r4
            goto L_0x00d8
        L_0x0065:
            boolean r12 = r11.tunaTouchOutBounds
            r0 = 0
            if (r12 != 0) goto L_0x00a1
            float r12 = r11.tunaTouchEventX
            int r1 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x0084
            int r1 = r11.tunaWidth
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0084
            float r12 = r11.tunaTouchEventY
            int r1 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x0084
            int r1 = r11.tunaHeight
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a1
        L_0x0084:
            r11.tunaPress = r4
            r11.tunaSelect = r4
            boolean r12 = r11.tunaTextMarkTouchable
            if (r12 != 0) goto L_0x008e
            r11.tunaTextMark = r4
        L_0x008e:
            boolean r12 = r11.tunaContentMarkTouchable
            if (r12 != 0) goto L_0x0094
            r11.tunaContentMark = r4
        L_0x0094:
            r11.invalidate()
            r11.tunaTouchOutBounds = r3
            com.tunasashimi.tuna.TunaView$TunaTouchOutListener r12 = r11.tunaTouchOutListener
            if (r12 == 0) goto L_0x00d8
            r12.tunaTouchOut(r11)
            goto L_0x00d8
        L_0x00a1:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 == 0) goto L_0x00d8
            float r12 = r11.tunaTouchEventX
            int r1 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x00d8
            int r1 = r11.tunaWidth
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x00d8
            float r12 = r11.tunaTouchEventY
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00d8
            int r0 = r11.tunaHeight
            float r0 = (float) r0
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 > 0) goto L_0x00d8
            r11.tunaPress = r3
            r11.tunaSelect = r4
            boolean r12 = r11.tunaTextMarkTouchable
            if (r12 != 0) goto L_0x00c9
            r11.tunaTextMark = r4
        L_0x00c9:
            boolean r12 = r11.tunaContentMarkTouchable
            if (r12 != 0) goto L_0x00cf
            r11.tunaContentMark = r4
        L_0x00cf:
            r11.tunaTouchOutBounds = r4
            com.tunasashimi.tuna.TunaView$TunaTouchInListener r12 = r11.tunaTouchInListener
            if (r12 == 0) goto L_0x00d8
            r12.tunaTouchIn(r11)
        L_0x00d8:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x026e
            com.tunasashimi.tuna.TunaView$TunaTouchMoveListener r12 = r11.tunaTouchMoveListener
            if (r12 == 0) goto L_0x026e
            r12.tunaTouchMove(r11)
            goto L_0x026e
        L_0x00e5:
            r11.tunaPress = r4
            int[] r12 = com.tunasashimi.tuna.TunaView.C2061417.$SwitchMap$com$tunasashimi$tuna$TunaView$TunaSelectType
            com.tunasashimi.tuna.TunaView$TunaSelectType r0 = r11.tunaSelectType
            int r0 = r0.ordinal()
            r12 = r12[r0]
            if (r12 == r3) goto L_0x0103
            if (r12 == r2) goto L_0x0100
            if (r12 == r1) goto L_0x00f8
            goto L_0x0105
        L_0x00f8:
            boolean r12 = r11.tunaSelectRaw
            r12 = r12 ^ r3
            r11.tunaSelectRaw = r12
            r11.tunaSelect = r12
            goto L_0x0105
        L_0x0100:
            r11.tunaSelect = r3
            goto L_0x0105
        L_0x0103:
            r11.tunaSelect = r4
        L_0x0105:
            boolean r12 = r11.tunaTextMarkTouchable
            if (r12 != 0) goto L_0x010b
            r11.tunaTextMark = r4
        L_0x010b:
            boolean r12 = r11.tunaContentMarkTouchable
            if (r12 != 0) goto L_0x0111
            r11.tunaContentMark = r4
        L_0x0111:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x011c
            com.tunasashimi.tuna.TunaView$TunaAssociateListener r12 = r11.tunaAssociateListener
            if (r12 == 0) goto L_0x011c
            r12.tunaAssociate(r11)
        L_0x011c:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x0127
            com.tunasashimi.tuna.TunaView$TunaTouchUpListener r12 = r11.tunaTouchUpListener
            if (r12 == 0) goto L_0x0127
            r12.tunaTouchUp(r11)
        L_0x0127:
            r11.tunaTouchOutBounds = r4
            goto L_0x026e
        L_0x012b:
            boolean r0 = r11.tunaDebugable
            if (r0 == 0) goto L_0x0197
            int r0 = r11.touchDownCount
            r5 = 600(0x258, double:2.964E-321)
            if (r0 != 0) goto L_0x013e
            r11.touchDownCount = r3
            long r7 = java.lang.System.currentTimeMillis()
            r11.touchDownTimeStart = r7
            goto L_0x017e
        L_0x013e:
            if (r0 != r2) goto L_0x0153
            long r7 = java.lang.System.currentTimeMillis()
            r11.touchDownTimeEnd = r7
            long r9 = r11.touchDownTimeStart
            long r7 = r7 - r9
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0150
            r11.showTunaProperties()
        L_0x0150:
            r11.touchDownCount = r4
            goto L_0x017e
        L_0x0153:
            float r0 = r11.tunaTouchDownEventX
            float r7 = r12.getX()
            float r0 = r0 - r7
            float r0 = java.lang.Math.abs(r0)
            float r7 = r11.tunaTouchDownEventY
            float r8 = r12.getY()
            float r7 = r7 - r8
            float r7 = java.lang.Math.abs(r7)
            float r8 = r11.displayDensity
            r9 = 1092616192(0x41200000, float:10.0)
            float r10 = r8 * r9
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x017e
            float r8 = r8 * r9
            int r0 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x017e
            int r0 = r11.touchDownCount
            int r0 = r0 + r3
            r11.touchDownCount = r0
        L_0x017e:
            float r0 = r12.getX()
            r11.tunaTouchDownEventX = r0
            float r12 = r12.getY()
            r11.tunaTouchDownEventY = r12
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = r11.touchDownTimeStart
            long r7 = r7 - r9
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x0197
            r11.touchDownCount = r4
        L_0x0197:
            r11.tunaPress = r3
            r11.tunaSelect = r4
            boolean r12 = r11.tunaTextMarkTouchable
            if (r12 != 0) goto L_0x01a1
            r11.tunaTextMark = r4
        L_0x01a1:
            boolean r12 = r11.tunaContentMarkTouchable
            if (r12 != 0) goto L_0x01a7
            r11.tunaContentMark = r4
        L_0x01a7:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x01b2
            com.tunasashimi.tuna.TunaView$TunaAssociateListener r12 = r11.tunaAssociateListener
            if (r12 == 0) goto L_0x01b2
            r12.tunaAssociate(r11)
        L_0x01b2:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x01bd
            com.tunasashimi.tuna.TunaView$TunaTouchDownListener r12 = r11.tunaTouchDownListener
            if (r12 == 0) goto L_0x01bd
            r12.tunaTouchDown(r11)
        L_0x01bd:
            com.tunasashimi.tuna.TunaView$TunaMaterial r12 = r11.tunaMaterial
            if (r12 == 0) goto L_0x026e
            int[] r12 = com.tunasashimi.tuna.TunaView.C2061417.$SwitchMap$com$tunasashimi$tuna$TunaView$TunaMaterial
            com.tunasashimi.tuna.TunaView$TunaMaterial r0 = r11.tunaMaterial
            int r0 = r0.ordinal()
            r12 = r12[r0]
            if (r12 == r3) goto L_0x01cf
            goto L_0x026e
        L_0x01cf:
            int r12 = r11.tunaWidth
            int r0 = r11.tunaHeight
            if (r12 < r0) goto L_0x01e4
            float r12 = r11.tunaTouchDownEventY
            float r5 = (float) r0
            float r5 = r5 - r12
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x01de
            goto L_0x01e1
        L_0x01de:
            float r0 = (float) r0
            float r12 = r0 - r12
        L_0x01e1:
            int r0 = r11.tunaWidth
            goto L_0x01f2
        L_0x01e4:
            float r0 = r11.tunaTouchDownEventX
            float r5 = (float) r12
            float r5 = r5 - r0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x01ee
            r12 = r0
            goto L_0x01f0
        L_0x01ee:
            float r12 = (float) r12
            float r12 = r12 - r0
        L_0x01f0:
            int r0 = r11.tunaHeight
        L_0x01f2:
            int r0 = r0 << r3
            float r0 = (float) r0
            android.animation.AnimatorSet r5 = new android.animation.AnimatorSet
            r5.<init>()
            r11.tunaMaterialAnimatorSet = r5
            boolean r6 = r11.tunaMaterialMove
            if (r6 == 0) goto L_0x023b
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            android.util.Property<com.tunasashimi.tuna.TunaView, java.lang.Float> r6 = r11.tunaMaterialRadiusProperty
            float[] r7 = new float[r2]
            r7[r4] = r12
            r7[r3] = r0
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r11, r6, r7)
            r1[r4] = r12
            android.util.Property<com.tunasashimi.tuna.TunaView, java.lang.Float> r12 = r11.tunaMaterialPaintXProperty
            float[] r0 = new float[r2]
            float r6 = r11.tunaTouchDownEventX
            r0[r4] = r6
            int r6 = r11.tunaWidth
            int r6 = r6 >> r3
            float r6 = (float) r6
            r0[r3] = r6
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
            r1[r3] = r12
            android.util.Property<com.tunasashimi.tuna.TunaView, java.lang.Float> r12 = r11.tunaMaterialPaintYProperty
            float[] r0 = new float[r2]
            float r6 = r11.tunaTouchDownEventY
            r0[r4] = r6
            int r4 = r11.tunaHeight
            int r4 = r4 >> r3
            float r4 = (float) r4
            r0[r3] = r4
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
            r1[r2] = r12
            r5.playTogether(r1)
            goto L_0x024e
        L_0x023b:
            android.animation.Animator[] r1 = new android.animation.Animator[r3]
            android.util.Property<com.tunasashimi.tuna.TunaView, java.lang.Float> r6 = r11.tunaMaterialRadiusProperty
            float[] r2 = new float[r2]
            r2[r4] = r12
            r2[r3] = r0
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r11, r6, r2)
            r1[r4] = r12
            r5.playTogether(r1)
        L_0x024e:
            android.animation.AnimatorSet r12 = r11.tunaMaterialAnimatorSet
            int r0 = r11.tunaMaterialDuraction
            long r0 = (long) r0
            r12.setDuration(r0)
            android.animation.TimeInterpolator r12 = r11.tunaMaterialTimeInterpolator
            if (r12 == 0) goto L_0x025f
            android.animation.AnimatorSet r0 = r11.tunaMaterialAnimatorSet
            r0.setInterpolator(r12)
        L_0x025f:
            android.animation.AnimatorSet r12 = r11.tunaMaterialAnimatorSet
            com.tunasashimi.tuna.TunaView$16 r0 = new com.tunasashimi.tuna.TunaView$16
            r0.<init>()
            r12.addListener(r0)
            android.animation.AnimatorSet r12 = r11.tunaMaterialAnimatorSet
            r12.start()
        L_0x026e:
            boolean r12 = r11.tunaTouchOutBounds
            if (r12 != 0) goto L_0x0275
            r11.invalidate()
        L_0x0275:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: com.tunasashimi.tuna.TunaView$17 */
    static /* synthetic */ class C2061417 {
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaView$TunaMaterial;
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaView$TunaSelectType;
        static final /* synthetic */ int[] $SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        static {
            /*
                com.tunasashimi.tuna.TunaView$TunaSelectType[] r0 = com.tunasashimi.tuna.TunaView.TunaSelectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tunasashimi$tuna$TunaView$TunaSelectType = r0
                r1 = 1
                com.tunasashimi.tuna.TunaView$TunaSelectType r2 = com.tunasashimi.tuna.TunaView.TunaSelectType.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaSelectType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tunasashimi.tuna.TunaView$TunaSelectType r3 = com.tunasashimi.tuna.TunaView.TunaSelectType.SAME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaSelectType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tunasashimi.tuna.TunaView$TunaSelectType r4 = com.tunasashimi.tuna.TunaView.TunaSelectType.REVERSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.tunasashimi.tuna.TunaView$TunaMaterial[] r3 = com.tunasashimi.tuna.TunaView.TunaMaterial.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$tunasashimi$tuna$TunaView$TunaMaterial = r3
                com.tunasashimi.tuna.TunaView$TunaMaterial r4 = com.tunasashimi.tuna.TunaView.TunaMaterial.SPREAD     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaMaterial     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.tunasashimi.tuna.TunaView$TunaMaterial r4 = com.tunasashimi.tuna.TunaView.TunaMaterial.TRANS     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.tunasashimi.tuna.TunaView$TunaTextGravity[] r3 = com.tunasashimi.tuna.TunaView.TunaTextGravity.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity = r3
                com.tunasashimi.tuna.TunaView$TunaTextGravity r4 = com.tunasashimi.tuna.TunaView.TunaTextGravity.ALL_CENTER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity     // Catch:{ NoSuchFieldError -> 0x005e }
                com.tunasashimi.tuna.TunaView$TunaTextGravity r3 = com.tunasashimi.tuna.TunaView.TunaTextGravity.ALL_LEFT     // Catch:{ NoSuchFieldError -> 0x005e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.tunasashimi.tuna.TunaView$TunaTextGravity r1 = com.tunasashimi.tuna.TunaView.TunaTextGravity.CENTER_LEFT     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$com$tunasashimi$tuna$TunaView$TunaTextGravity     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.tunasashimi.tuna.TunaView$TunaTextGravity r1 = com.tunasashimi.tuna.TunaView.TunaTextGravity.LEFT_CENTER     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaView.C2061417.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        String str = this.tunaTextValue;
        if (str != null) {
            this.tunaTextValueMeasureList = tunaMeasure(i, i2, str, initTunaTextPaint(this.tunaTextSize), this.tunaTextPaddingLeft, this.tunaTextPaddingRight, this.tunaTextRowSpaceRatio);
            return;
        }
        this.tunaContentValueMeasureList = tunaMeasure(i, i2, this.tunaContentValue, initTunaTextPaint(this.tunaContentSize), this.tunaTextPaddingLeft, this.tunaTextPaddingRight, this.tunaContentRowSpaceRatio);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> tunaMeasure(int r13, int r14, java.lang.String r15, android.graphics.Paint r16, float r17, float r18, float r19) {
        /*
            r12 = this;
            r6 = r12
            r1 = r15
            int r0 = android.view.View.MeasureSpec.getMode(r13)
            int r2 = android.view.View.MeasureSpec.getSize(r13)
            int r3 = android.view.View.MeasureSpec.getMode(r14)
            int r4 = android.view.View.MeasureSpec.getSize(r14)
            r5 = 1119879168(0x42c00000, float:96.0)
            float r5 = convertToPX((float) r5, (android.view.View) r12)
            int r5 = (int) r5
            r7 = 1111490560(0x42400000, float:48.0)
            float r7 = convertToPX((float) r7, (android.view.View) r12)
            int r7 = (int) r7
            r8 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r9) goto L_0x0038
            if (r1 == 0) goto L_0x0038
            r10 = r16
            float r0 = r10.measureText(r15)
            float r0 = r0 + r17
            float r0 = r0 + r18
            int r0 = (int) r0
            int r2 = java.lang.Math.min(r2, r0)
            goto L_0x003f
        L_0x0038:
            r10 = r16
            if (r0 != r8) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            if (r0 != 0) goto L_0x0041
        L_0x003f:
            r11 = r2
            goto L_0x0042
        L_0x0041:
            r11 = r5
        L_0x0042:
            r0 = 0
            if (r3 != r9) goto L_0x0069
            if (r1 == 0) goto L_0x0069
            float r3 = (float) r11
            r0 = r12
            r1 = r15
            r2 = r16
            r4 = r17
            r5 = r18
            java.util.List r0 = r0.generateMeasureList(r1, r2, r3, r4, r5)
            android.graphics.Paint$FontMetricsInt r1 = r16.getFontMetricsInt()
            int r2 = r1.descent
            int r1 = r1.ascent
            int r2 = r2 - r1
            float r1 = (float) r2
            float r1 = r1 * r19
            int r2 = r0.size()
        L_0x0064:
            float r2 = (float) r2
            float r1 = r1 * r2
            int r4 = (int) r1
            goto L_0x008f
        L_0x0069:
            if (r3 != r8) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            if (r3 != 0) goto L_0x008e
            if (r1 == 0) goto L_0x008e
            float r3 = (float) r11
            r0 = r12
            r1 = r15
            r2 = r16
            r4 = r17
            r5 = r18
            java.util.List r0 = r0.generateMeasureList(r1, r2, r3, r4, r5)
            android.graphics.Paint$FontMetricsInt r1 = r16.getFontMetricsInt()
            int r2 = r1.descent
            int r1 = r1.ascent
            int r2 = r2 - r1
            float r1 = (float) r2
            float r1 = r1 * r19
            int r2 = r0.size()
            goto L_0x0064
        L_0x008e:
            r4 = r7
        L_0x008f:
            r12.setMeasuredDimension(r11, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaView.tunaMeasure(int, int, java.lang.String, android.graphics.Paint, float, float, float):java.util.List");
    }

    /* access modifiers changed from: protected */
    public List<Integer> generateMeasureList(String str, Paint paint, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        float f4 = (f - f2) - f3;
        if (paint.measureText(str) > f4) {
            int i = 0;
            for (int i2 = 1; i2 <= length; i2++) {
                if (paint.measureText(str.substring(i, i2)) > f4) {
                    i = i2 - 1;
                    arrayList.add(Integer.valueOf(i));
                } else if (i2 == length) {
                    arrayList.add(Integer.valueOf(i2));
                    i = i2;
                }
            }
        } else {
            arrayList.add(Integer.valueOf(length));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        super.onLayout(z, i, i2, i3, i4);
        this.tunaWidth = getWidth();
        this.tunaHeight = getHeight();
        if (this.tunaSuper) {
            if (!(this.tunaForegroundNormal == 0 && this.tunaForegroundPress == 0 && this.tunaForegroundSelect == 0 && this.tunaSrcNormal == null && this.tunaSrcPress == null && this.tunaSrcSelect == null && this.tunaSrcNormalShadowRadius <= 0.0f && this.tunaSrcPressShadowRadius <= 0.0f && this.tunaSrcSelectShadowRadius <= 0.0f && this.tunaBackgroundNormalShadowRadius <= 0.0f && this.tunaBackgroundPressShadowRadius <= 0.0f && this.tunaBackgroundSelectShadowRadius <= 0.0f && this.tunaBackgroundNormalAngle == Integer.MAX_VALUE && this.tunaBackgroundPressAngle == Integer.MAX_VALUE && this.tunaBackgroundSelectAngle == Integer.MAX_VALUE && this.tunaSrcAnchorNormal == null && this.tunaSrcAnchorPress == null && this.tunaSrcAnchorSelect == null)) {
                setLayerType(1, (Paint) null);
            }
            if (this.tunaSrcNormal != null || this.tunaSrcPress != null || this.tunaSrcSelect != null || this.tunaBackgroundNormalShadowRadius > 0.0f || this.tunaBackgroundPressShadowRadius > 0.0f || this.tunaBackgroundSelectShadowRadius > 0.0f) {
                if (this.tunaBackgroundNormal == 0) {
                    this.tunaBackgroundNormal = -1;
                }
                if (this.tunaBackgroundPress == 0) {
                    this.tunaBackgroundPress = this.tunaBackgroundNormal;
                }
                if (this.tunaBackgroundSelect == 0) {
                    this.tunaBackgroundSelect = this.tunaBackgroundNormal;
                }
            }
            float f = this.tunaTextDx;
            int i16 = this.tunaWidth;
            this.tunaTextDx = f + (((float) i16) * this.tunaTextFractionDx);
            float f2 = this.tunaTextDy;
            int i17 = this.tunaHeight;
            this.tunaTextDy = f2 + (((float) i17) * this.tunaTextFractionDy);
            this.tunaTextMarkDx += ((float) i16) * this.tunaTextMarkFractionDx;
            this.tunaTextMarkDy += ((float) i17) * this.tunaTextMarkFractionDy;
            int i18 = this.tunaBackgroundNormalAngle;
            if (i18 != Integer.MAX_VALUE) {
                this.tunaBackgroundNormalShader = getLinearGradient(i16, i17, i18, this.tunaBackgroundNormalGradientStart, this.tunaBackgroundNormalGradientEnd);
            }
            int i19 = this.tunaBackgroundPressAngle;
            if (i19 != Integer.MAX_VALUE) {
                this.tunaBackgroundPressShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i19, this.tunaBackgroundPressGradientStart, this.tunaBackgroundPressGradientEnd);
            }
            int i20 = this.tunaBackgroundSelectAngle;
            if (i20 != Integer.MAX_VALUE) {
                this.tunaBackgroundSelectShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i20, this.tunaBackgroundSelectGradientStart, this.tunaBackgroundSelectGradientEnd);
            }
            Bitmap bitmap = this.tunaSrcNormal;
            int i21 = 0;
            if (bitmap != null) {
                i6 = bitmap.getWidth();
                i5 = this.tunaSrcNormal.getHeight();
                float f3 = this.tunaSrcNormalShadowRadius;
                float f4 = ((float) this.tunaWidth) - (f3 * 2.0f);
                float f5 = this.tunaBackgroundNormalShadowRadius;
                initTunaMatrix(((f4 - (f5 * 2.0f)) - (this.tunaBackgroundNormalShadowDx * 2.0f)) / ((float) i6), (((((float) this.tunaHeight) - (f3 * 2.0f)) - (f5 * 2.0f)) - (this.tunaBackgroundNormalShadowDy * 2.0f)) / ((float) i5));
            } else {
                i6 = 0;
                i5 = 0;
            }
            Bitmap bitmap2 = this.tunaSrcPress;
            if (bitmap2 != null) {
                i8 = bitmap2.getWidth();
                i7 = this.tunaSrcPress.getHeight();
            } else {
                i8 = 0;
                i7 = 0;
            }
            Bitmap bitmap3 = this.tunaSrcSelect;
            if (bitmap3 != null) {
                i10 = bitmap3.getWidth();
                i9 = this.tunaSrcSelect.getHeight();
            } else {
                i10 = 0;
                i9 = 0;
            }
            if (i6 == i8 && i5 == i7 && i8 == i10 && i7 == i9) {
                Bitmap bitmap4 = this.tunaSrcAnchorNormal;
                if (bitmap4 != null) {
                    i12 = bitmap4.getWidth();
                    i11 = this.tunaSrcAnchorNormal.getHeight();
                    initTunaAnchorMatrix(this.tunaSrcAnchorNormalWidth / ((float) i12), this.tunaSrcAnchorNormalHeight / ((float) i11));
                } else {
                    i12 = 0;
                    i11 = 0;
                }
                Bitmap bitmap5 = this.tunaSrcAnchorPress;
                if (bitmap5 != null) {
                    i14 = bitmap5.getWidth();
                    i13 = this.tunaSrcAnchorPress.getHeight();
                } else {
                    i14 = 0;
                    i13 = 0;
                }
                Bitmap bitmap6 = this.tunaSrcAnchorSelect;
                if (bitmap6 != null) {
                    i21 = bitmap6.getWidth();
                    i15 = this.tunaSrcAnchorSelect.getHeight();
                } else {
                    i15 = 0;
                }
                if (i12 == i14 && i11 == i13 && i14 == i21 && i13 == i15) {
                    Bitmap bitmap7 = this.tunaSrcLeft;
                    if (bitmap7 != null) {
                        initTunaLeftMatrix(this.tunaSrcLeftWidth / ((float) bitmap7.getWidth()), this.tunaSrcLeftHeight / ((float) this.tunaSrcLeft.getHeight()));
                    }
                    Bitmap bitmap8 = this.tunaSrcRight;
                    if (bitmap8 != null) {
                        initTunaRightMatrix(this.tunaSrcRightWidth / ((float) bitmap8.getWidth()), this.tunaSrcRightHeight / ((float) this.tunaSrcRight.getHeight()));
                    }
                    TunaLayoutListener tunaLayoutListener2 = this.tunaLayoutListener;
                    if (tunaLayoutListener2 != null) {
                        tunaLayoutListener2.tunaLayout(this);
                        return;
                    }
                    return;
                }
                throw new IndexOutOfBoundsException("Both the width and height of the attribute tunaSrcAnchorNormal ,tunaSrcAnchorPress and tunaSrcAnchorSelect needed equal");
            }
            throw new IndexOutOfBoundsException("Both the width and height of the attribute tunaSrcNormal ,tunaSrcPress and tunaSrcSelect needed equal");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03d5, code lost:
        r2 = r2 * 0.5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03d7, code lost:
        r0 = r0 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03e8, code lost:
        r1 = r0 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03ed, code lost:
        if (r13.tunaSelect == false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03ef, code lost:
        r2 = r13.tunaSrcAnchorSelectDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03f4, code lost:
        if (r13.tunaPress == false) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03f6, code lost:
        r2 = r13.tunaSrcAnchorPressDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x03f9, code lost:
        r2 = r13.tunaSrcAnchorNormalDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x03fb, code lost:
        r2 = r2 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x03fe, code lost:
        if (r13.tunaSelect == false) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0400, code lost:
        r3 = r13.tunaSrcAnchorSelectDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0405, code lost:
        if (r13.tunaPress == false) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0407, code lost:
        r3 = r13.tunaSrcAnchorPressDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x040a, code lost:
        r3 = r13.tunaSrcAnchorNormalDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x040c, code lost:
        r14.translate(r2, r3 + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0412, code lost:
        if (r13.tunaSelect == false) goto L_0x0417;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0414, code lost:
        r2 = r13.tunaSrcAnchorSelect;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0419, code lost:
        if (r13.tunaPress == false) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x041b, code lost:
        r2 = r13.tunaSrcAnchorPress;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x041e, code lost:
        r2 = r13.tunaSrcAnchorNormal;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0420, code lost:
        r14.drawBitmap(r2, r13.tunaAnchorMatrix, r13.tunaPaint);
        r1 = -r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x042a, code lost:
        if (r13.tunaSelect == false) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x042c, code lost:
        r2 = r13.tunaSrcAnchorSelectDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0432, code lost:
        if (r13.tunaPress == false) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0434, code lost:
        r2 = r13.tunaSrcAnchorPressDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0437, code lost:
        r2 = r13.tunaSrcAnchorNormalDx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x043a, code lost:
        r1 = r1 + (-r2);
        r0 = -r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x043e, code lost:
        if (r13.tunaSelect == false) goto L_0x0444;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0440, code lost:
        r2 = r13.tunaSrcAnchorSelectDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0446, code lost:
        if (r13.tunaPress == false) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0448, code lost:
        r2 = r13.tunaSrcAnchorPressDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x044b, code lost:
        r2 = r13.tunaSrcAnchorNormalDy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x044e, code lost:
        r14.translate(r1, r0 + (-r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r15 = r24
            r14 = r25
            r24.initTunaCanvas(r25)
            int r0 = r15.tunaRotate
            r18 = 1
            if (r0 == 0) goto L_0x001b
            float r0 = (float) r0
            int r1 = r15.tunaWidth
            int r1 = r1 >> 1
            float r1 = (float) r1
            int r2 = r15.tunaHeight
            int r2 = r2 >> 1
            float r2 = (float) r2
            r14.rotate(r0, r1, r2)
        L_0x001b:
            boolean r0 = r15.tunaSuper
            if (r0 != 0) goto L_0x0020
            return
        L_0x0020:
            android.graphics.Bitmap r0 = r15.tunaSrcNormal
            r19 = 0
            if (r0 != 0) goto L_0x0032
            android.graphics.Bitmap r0 = r15.tunaSrcPress
            if (r0 != 0) goto L_0x0032
            android.graphics.Bitmap r0 = r15.tunaSrcSelect
            if (r0 == 0) goto L_0x002f
            goto L_0x0032
        L_0x002f:
            r20 = 0
            goto L_0x0034
        L_0x0032:
            r20 = 1
        L_0x0034:
            if (r20 == 0) goto L_0x0049
            r1 = 0
            r2 = 0
            int r0 = r15.tunaWidth
            float r3 = (float) r0
            int r0 = r15.tunaHeight
            float r4 = (float) r0
            r5 = 0
            r6 = 31
            r0 = r25
            int r0 = r0.saveLayer(r1, r2, r3, r4, r5, r6)
            r15.tunaLayer = r0
        L_0x0049:
            boolean r0 = r15.tunaClassic
            if (r0 == 0) goto L_0x0152
            boolean r0 = r15.tunaMaterialPlay
            if (r0 == 0) goto L_0x0091
            float r8 = r15.tunaBackgroundNormalShadowRadius
            float r10 = r15.tunaBackgroundNormalShadowDx
            float r2 = r8 + r10
            float r11 = r15.tunaBackgroundNormalShadowDy
            float r3 = r8 + r11
            int r0 = r15.tunaWidth
            float r0 = (float) r0
            float r0 = r0 - r8
            float r4 = r0 - r10
            int r0 = r15.tunaHeight
            float r0 = (float) r0
            float r0 = r0 - r8
            float r5 = r0 - r11
            int r6 = r15.tunaBackgroundNormal
            android.graphics.Shader r7 = r15.tunaBackgroundNormalShader
            int r9 = r15.tunaBackgroundNormalShadowColor
            float r12 = r15.tunaStrokeWidthNormal
            int r13 = r15.tunaStrokeColorNormal
            float r1 = r15.tunaRadius
            r0 = r24
            r16 = r1
            r1 = r25
            r14 = r16
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            float r0 = r15.tunaTouchDownEventX
            float r1 = r15.tunaTouchDownEventY
            float r2 = r15.tunaMaterialRadius
            int r3 = r15.tunaBackgroundPress
            android.graphics.Paint r3 = r15.initTunaPaint(r3)
            r14 = r25
            r14.drawCircle(r0, r1, r2, r3)
            goto L_0x026e
        L_0x0091:
            float r0 = r15.tunaBackgroundNormalShadowRadius
            float r1 = r15.tunaBackgroundNormalShadowDx
            float r2 = r0 + r1
            float r3 = r15.tunaBackgroundNormalShadowDy
            float r4 = r0 + r3
            int r5 = r15.tunaWidth
            float r5 = (float) r5
            float r5 = r5 - r0
            float r5 = r5 - r1
            int r1 = r15.tunaHeight
            float r1 = (float) r1
            float r1 = r1 - r0
            float r6 = r1 - r3
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x00ae
            int r0 = r15.tunaBackgroundSelect
        L_0x00ac:
            r7 = r0
            goto L_0x00b8
        L_0x00ae:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x00b5
            int r0 = r15.tunaBackgroundPress
            goto L_0x00ac
        L_0x00b5:
            int r0 = r15.tunaBackgroundNormal
            goto L_0x00ac
        L_0x00b8:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x00c0
            android.graphics.Shader r0 = r15.tunaBackgroundSelectShader
        L_0x00be:
            r8 = r0
            goto L_0x00ca
        L_0x00c0:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x00c7
            android.graphics.Shader r0 = r15.tunaBackgroundPressShader
            goto L_0x00be
        L_0x00c7:
            android.graphics.Shader r0 = r15.tunaBackgroundNormalShader
            goto L_0x00be
        L_0x00ca:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x00d2
            float r0 = r15.tunaBackgroundSelectShadowRadius
        L_0x00d0:
            r9 = r0
            goto L_0x00dc
        L_0x00d2:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x00d9
            float r0 = r15.tunaBackgroundPressShadowRadius
            goto L_0x00d0
        L_0x00d9:
            float r0 = r15.tunaBackgroundNormalShadowRadius
            goto L_0x00d0
        L_0x00dc:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x00e4
            int r0 = r15.tunaBackgroundSelectShadowColor
        L_0x00e2:
            r10 = r0
            goto L_0x00ee
        L_0x00e4:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x00eb
            int r0 = r15.tunaBackgroundPressShadowColor
            goto L_0x00e2
        L_0x00eb:
            int r0 = r15.tunaBackgroundNormalShadowColor
            goto L_0x00e2
        L_0x00ee:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x00f6
            float r0 = r15.tunaBackgroundSelectShadowDx
        L_0x00f4:
            r11 = r0
            goto L_0x0100
        L_0x00f6:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x00fd
            float r0 = r15.tunaBackgroundPressShadowDx
            goto L_0x00f4
        L_0x00fd:
            float r0 = r15.tunaBackgroundNormalShadowDx
            goto L_0x00f4
        L_0x0100:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x0108
            float r0 = r15.tunaBackgroundSelectShadowDy
        L_0x0106:
            r12 = r0
            goto L_0x0112
        L_0x0108:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x010f
            float r0 = r15.tunaBackgroundPressShadowDy
            goto L_0x0106
        L_0x010f:
            float r0 = r15.tunaBackgroundNormalShadowDy
            goto L_0x0106
        L_0x0112:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x011a
            float r0 = r15.tunaStrokeWidthSelect
        L_0x0118:
            r13 = r0
            goto L_0x0124
        L_0x011a:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x0121
            float r0 = r15.tunaStrokeWidthPress
            goto L_0x0118
        L_0x0121:
            float r0 = r15.tunaStrokeWidthNormal
            goto L_0x0118
        L_0x0124:
            boolean r0 = r15.tunaSelect
            if (r0 == 0) goto L_0x012d
            int r0 = r15.tunaStrokeColorSelect
        L_0x012a:
            r16 = r0
            goto L_0x0137
        L_0x012d:
            boolean r0 = r15.tunaPress
            if (r0 == 0) goto L_0x0134
            int r0 = r15.tunaStrokeColorPress
            goto L_0x012a
        L_0x0134:
            int r0 = r15.tunaStrokeColorNormal
            goto L_0x012a
        L_0x0137:
            float r3 = r15.tunaRadius
            r0 = r24
            r1 = r25
            r17 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r16
            r14 = r17
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x026e
        L_0x0152:
            boolean r0 = r15.tunaMaterialPlay
            if (r0 == 0) goto L_0x01a2
            float r0 = r15.tunaBackgroundNormalShadowRadius
            r8 = r0
            float r1 = r15.tunaBackgroundNormalShadowDx
            r10 = r1
            float r2 = r0 + r1
            float r5 = r15.tunaBackgroundNormalShadowDy
            r11 = r5
            float r3 = r0 + r5
            int r4 = r15.tunaWidth
            float r4 = (float) r4
            float r4 = r4 - r0
            float r4 = r4 - r1
            int r1 = r15.tunaHeight
            float r1 = (float) r1
            float r1 = r1 - r0
            float r5 = r1 - r5
            int r6 = r15.tunaBackgroundNormal
            android.graphics.Shader r7 = r15.tunaBackgroundNormalShader
            int r9 = r15.tunaBackgroundNormalShadowColor
            float r12 = r15.tunaStrokeWidthNormal
            int r13 = r15.tunaStrokeColorNormal
            float r14 = r15.tunaRadiusLeftTop
            float r0 = r15.tunaRadiusLeftBottom
            r1 = r15
            r15 = r0
            float r0 = r1.tunaRadiusRightTop
            r16 = r0
            float r0 = r1.tunaRadiusRightBottom
            r17 = r0
            r0 = r24
            r1 = r25
            r0.drawTunaRectCustom(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r13 = r24
            float r0 = r13.tunaTouchDownEventX
            float r1 = r13.tunaTouchDownEventY
            float r2 = r13.tunaMaterialRadius
            int r3 = r13.tunaBackgroundPress
            android.graphics.Paint r3 = r13.initTunaPaint(r3)
            r12 = r25
            r12.drawCircle(r0, r1, r2, r3)
            goto L_0x026e
        L_0x01a2:
            r12 = r25
            r13 = r15
            float r0 = r13.tunaBackgroundNormalShadowRadius
            float r1 = r13.tunaBackgroundNormalShadowDx
            float r2 = r0 + r1
            float r3 = r13.tunaBackgroundNormalShadowDy
            float r4 = r0 + r3
            int r5 = r13.tunaWidth
            float r5 = (float) r5
            float r5 = r5 - r0
            float r5 = r5 - r1
            int r1 = r13.tunaHeight
            float r1 = (float) r1
            float r1 = r1 - r0
            float r6 = r1 - r3
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x01c2
            int r0 = r13.tunaBackgroundSelect
        L_0x01c0:
            r7 = r0
            goto L_0x01cc
        L_0x01c2:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x01c9
            int r0 = r13.tunaBackgroundPress
            goto L_0x01c0
        L_0x01c9:
            int r0 = r13.tunaBackgroundNormal
            goto L_0x01c0
        L_0x01cc:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x01d4
            android.graphics.Shader r0 = r13.tunaBackgroundSelectShader
        L_0x01d2:
            r8 = r0
            goto L_0x01de
        L_0x01d4:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x01db
            android.graphics.Shader r0 = r13.tunaBackgroundPressShader
            goto L_0x01d2
        L_0x01db:
            android.graphics.Shader r0 = r13.tunaBackgroundNormalShader
            goto L_0x01d2
        L_0x01de:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x01e6
            float r0 = r13.tunaBackgroundSelectShadowRadius
        L_0x01e4:
            r9 = r0
            goto L_0x01f0
        L_0x01e6:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x01ed
            float r0 = r13.tunaBackgroundPressShadowRadius
            goto L_0x01e4
        L_0x01ed:
            float r0 = r13.tunaBackgroundNormalShadowRadius
            goto L_0x01e4
        L_0x01f0:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x01f8
            int r0 = r13.tunaBackgroundSelectShadowColor
        L_0x01f6:
            r10 = r0
            goto L_0x0202
        L_0x01f8:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x01ff
            int r0 = r13.tunaBackgroundPressShadowColor
            goto L_0x01f6
        L_0x01ff:
            int r0 = r13.tunaBackgroundNormalShadowColor
            goto L_0x01f6
        L_0x0202:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x020a
            float r0 = r13.tunaBackgroundSelectShadowDx
        L_0x0208:
            r11 = r0
            goto L_0x0214
        L_0x020a:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x0211
            float r0 = r13.tunaBackgroundPressShadowDx
            goto L_0x0208
        L_0x0211:
            float r0 = r13.tunaBackgroundNormalShadowDx
            goto L_0x0208
        L_0x0214:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x021d
            float r0 = r13.tunaBackgroundSelectShadowDy
        L_0x021a:
            r21 = r0
            goto L_0x0227
        L_0x021d:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x0224
            float r0 = r13.tunaBackgroundPressShadowDy
            goto L_0x021a
        L_0x0224:
            float r0 = r13.tunaBackgroundNormalShadowDy
            goto L_0x021a
        L_0x0227:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x0230
            float r0 = r13.tunaStrokeWidthSelect
        L_0x022d:
            r22 = r0
            goto L_0x023a
        L_0x0230:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x0237
            float r0 = r13.tunaStrokeWidthPress
            goto L_0x022d
        L_0x0237:
            float r0 = r13.tunaStrokeWidthNormal
            goto L_0x022d
        L_0x023a:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x0243
            int r0 = r13.tunaStrokeColorSelect
        L_0x0240:
            r23 = r0
            goto L_0x024d
        L_0x0243:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x024a
            int r0 = r13.tunaStrokeColorPress
            goto L_0x0240
        L_0x024a:
            int r0 = r13.tunaStrokeColorNormal
            goto L_0x0240
        L_0x024d:
            float r14 = r13.tunaRadiusLeftTop
            float r15 = r13.tunaRadiusLeftBottom
            float r0 = r13.tunaRadiusRightTop
            r16 = r0
            float r0 = r13.tunaRadiusRightBottom
            r17 = r0
            r0 = r24
            r1 = r25
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r21
            r12 = r22
            r13 = r23
            r0.drawTunaRectCustom(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x026e:
            r13 = r24
            if (r20 == 0) goto L_0x0377
            android.graphics.Paint r0 = r13.tunaPaint
            android.graphics.PorterDuffXfermode r1 = r13.tunaPorterDuffXfermode
            r0.setXfermode(r1)
            boolean r0 = r13.tunaSelect
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == 0) goto L_0x028a
            float r0 = r13.tunaBackgroundSelectShadowDx
            float r0 = r0 * r1
            float r2 = r13.tunaSrcSelectShadowRadius
            float r0 = r0 + r2
            float r2 = r13.tunaSrcSelectShadowDx
        L_0x0288:
            float r0 = r0 - r2
            goto L_0x02a2
        L_0x028a:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x0298
            float r0 = r13.tunaBackgroundPressShadowDx
            float r0 = r0 * r1
            float r2 = r13.tunaSrcPressShadowRadius
            float r0 = r0 + r2
            float r2 = r13.tunaSrcPressShadowDx
            goto L_0x0288
        L_0x0298:
            float r0 = r13.tunaBackgroundNormalShadowDx
            float r0 = r0 * r1
            float r2 = r13.tunaSrcNormalShadowRadius
            float r0 = r0 + r2
            float r2 = r13.tunaSrcNormalShadowDx
            goto L_0x0288
        L_0x02a2:
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x02b3
            float r2 = r13.tunaBackgroundSelectShadowDy
            float r2 = r2 * r1
            float r3 = r13.tunaSrcSelectShadowRadius
            float r2 = r2 + r3
            float r3 = r13.tunaSrcSelectShadowDy
        L_0x02af:
            float r2 = r2 - r3
            r14 = r25
            goto L_0x02cb
        L_0x02b3:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x02c1
            float r2 = r13.tunaBackgroundPressShadowDy
            float r2 = r2 * r1
            float r3 = r13.tunaSrcPressShadowRadius
            float r2 = r2 + r3
            float r3 = r13.tunaSrcPressShadowDy
            goto L_0x02af
        L_0x02c1:
            float r2 = r13.tunaBackgroundNormalShadowDy
            float r2 = r2 * r1
            float r3 = r13.tunaSrcNormalShadowRadius
            float r2 = r2 + r3
            float r3 = r13.tunaSrcNormalShadowDy
            goto L_0x02af
        L_0x02cb:
            r14.translate(r0, r2)
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x02d5
            android.graphics.Bitmap r0 = r13.tunaSrcSelect
            goto L_0x02de
        L_0x02d5:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x02dc
            android.graphics.Bitmap r0 = r13.tunaSrcPress
            goto L_0x02de
        L_0x02dc:
            android.graphics.Bitmap r0 = r13.tunaSrcNormal
        L_0x02de:
            android.graphics.Matrix r2 = r13.tunaMatrix
            android.graphics.Paint r3 = r13.tunaPaint
            boolean r4 = r13.tunaSelect
            if (r4 == 0) goto L_0x02e9
            float r4 = r13.tunaSrcSelectShadowRadius
            goto L_0x02f2
        L_0x02e9:
            boolean r4 = r13.tunaPress
            if (r4 == 0) goto L_0x02f0
            float r4 = r13.tunaSrcPressShadowRadius
            goto L_0x02f2
        L_0x02f0:
            float r4 = r13.tunaSrcNormalShadowRadius
        L_0x02f2:
            boolean r5 = r13.tunaSelect
            if (r5 == 0) goto L_0x02f9
            float r5 = r13.tunaSrcSelectShadowDx
            goto L_0x0302
        L_0x02f9:
            boolean r5 = r13.tunaPress
            if (r5 == 0) goto L_0x0300
            float r5 = r13.tunaSrcPressShadowDx
            goto L_0x0302
        L_0x0300:
            float r5 = r13.tunaSrcNormalShadowDx
        L_0x0302:
            boolean r6 = r13.tunaSelect
            if (r6 == 0) goto L_0x0309
            float r6 = r13.tunaSrcSelectShadowDy
            goto L_0x0312
        L_0x0309:
            boolean r6 = r13.tunaPress
            if (r6 == 0) goto L_0x0310
            float r6 = r13.tunaSrcPressShadowDy
            goto L_0x0312
        L_0x0310:
            float r6 = r13.tunaSrcNormalShadowDy
        L_0x0312:
            android.graphics.Paint r3 = r13.initTunaPaint((android.graphics.Paint) r3, (float) r4, (float) r5, (float) r6)
            r14.drawBitmap(r0, r2, r3)
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x0329
            float r0 = r13.tunaBackgroundSelectShadowDx
            float r0 = -r0
            float r0 = r0 * r1
            float r2 = r13.tunaSrcSelectShadowRadius
            float r0 = r0 - r2
            float r2 = r13.tunaSrcSelectShadowDx
        L_0x0327:
            float r0 = r0 + r2
            goto L_0x0343
        L_0x0329:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x0338
            float r0 = r13.tunaBackgroundPressShadowDx
            float r0 = -r0
            float r0 = r0 * r1
            float r2 = r13.tunaSrcPressShadowRadius
            float r0 = r0 - r2
            float r2 = r13.tunaSrcPressShadowDx
            goto L_0x0327
        L_0x0338:
            float r0 = r13.tunaBackgroundNormalShadowDx
            float r0 = -r0
            float r0 = r0 * r1
            float r2 = r13.tunaSrcNormalShadowRadius
            float r0 = r0 - r2
            float r2 = r13.tunaSrcNormalShadowDx
            goto L_0x0327
        L_0x0343:
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x0353
            float r2 = r13.tunaBackgroundSelectShadowDy
            float r2 = -r2
            float r2 = r2 * r1
            float r1 = r13.tunaSrcSelectShadowRadius
            float r2 = r2 - r1
            float r1 = r13.tunaSrcSelectShadowDy
        L_0x0351:
            float r2 = r2 + r1
            goto L_0x036d
        L_0x0353:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x0362
            float r2 = r13.tunaBackgroundPressShadowDy
            float r2 = -r2
            float r2 = r2 * r1
            float r1 = r13.tunaSrcPressShadowRadius
            float r2 = r2 - r1
            float r1 = r13.tunaSrcPressShadowDy
            goto L_0x0351
        L_0x0362:
            float r2 = r13.tunaBackgroundNormalShadowDy
            float r2 = -r2
            float r2 = r2 * r1
            float r1 = r13.tunaSrcNormalShadowRadius
            float r2 = r2 - r1
            float r1 = r13.tunaSrcNormalShadowDy
            goto L_0x0351
        L_0x036d:
            r14.translate(r0, r2)
            android.graphics.Paint r0 = r13.tunaPaint
            r1 = 0
            r0.setXfermode(r1)
            goto L_0x0379
        L_0x0377:
            r14 = r25
        L_0x0379:
            android.graphics.Bitmap r0 = r13.tunaSrcAnchorNormal
            r12 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x0452
            int r0 = r13.tunaSrcAnchorGravity
            r0 = r0 & 15
            r1 = 0
            switch(r0) {
                case 1: goto L_0x03df;
                case 2: goto L_0x03d9;
                case 3: goto L_0x0387;
                case 4: goto L_0x03ce;
                case 5: goto L_0x03bb;
                case 6: goto L_0x03ac;
                case 7: goto L_0x0387;
                case 8: goto L_0x03a6;
                case 9: goto L_0x0395;
                case 10: goto L_0x0388;
                default: goto L_0x0387;
            }
        L_0x0387:
            goto L_0x03ea
        L_0x0388:
            int r0 = r13.tunaWidth
            float r0 = (float) r0
            float r1 = r13.tunaSrcAnchorNormalWidth
            float r1 = r0 - r1
            int r0 = r13.tunaHeight
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
            goto L_0x03d7
        L_0x0395:
            int r0 = r13.tunaWidth
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaSrcAnchorNormalWidth
            float r1 = r1 * r12
            float r1 = r0 - r1
            int r0 = r13.tunaHeight
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
            goto L_0x03d7
        L_0x03a6:
            int r0 = r13.tunaHeight
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
            goto L_0x03d7
        L_0x03ac:
            int r0 = r13.tunaWidth
            float r0 = (float) r0
            float r1 = r13.tunaSrcAnchorNormalWidth
            float r1 = r0 - r1
            int r0 = r13.tunaHeight
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
            goto L_0x03d5
        L_0x03bb:
            int r0 = r13.tunaWidth
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaSrcAnchorNormalWidth
            float r1 = r1 * r12
            float r1 = r0 - r1
            int r0 = r13.tunaHeight
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
            goto L_0x03d5
        L_0x03ce:
            int r0 = r13.tunaHeight
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalHeight
        L_0x03d5:
            float r2 = r2 * r12
        L_0x03d7:
            float r0 = r0 - r2
            goto L_0x03eb
        L_0x03d9:
            int r0 = r13.tunaWidth
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalWidth
            goto L_0x03e8
        L_0x03df:
            int r0 = r13.tunaWidth
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r2 = r13.tunaSrcAnchorNormalWidth
            float r2 = r2 * r12
        L_0x03e8:
            float r0 = r0 - r2
            r1 = r0
        L_0x03ea:
            r0 = 0
        L_0x03eb:
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x03f2
            float r2 = r13.tunaSrcAnchorSelectDx
            goto L_0x03fb
        L_0x03f2:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x03f9
            float r2 = r13.tunaSrcAnchorPressDx
            goto L_0x03fb
        L_0x03f9:
            float r2 = r13.tunaSrcAnchorNormalDx
        L_0x03fb:
            float r2 = r2 + r1
            boolean r3 = r13.tunaSelect
            if (r3 == 0) goto L_0x0403
            float r3 = r13.tunaSrcAnchorSelectDy
            goto L_0x040c
        L_0x0403:
            boolean r3 = r13.tunaPress
            if (r3 == 0) goto L_0x040a
            float r3 = r13.tunaSrcAnchorPressDy
            goto L_0x040c
        L_0x040a:
            float r3 = r13.tunaSrcAnchorNormalDy
        L_0x040c:
            float r3 = r3 + r0
            r14.translate(r2, r3)
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x0417
            android.graphics.Bitmap r2 = r13.tunaSrcAnchorSelect
            goto L_0x0420
        L_0x0417:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x041e
            android.graphics.Bitmap r2 = r13.tunaSrcAnchorPress
            goto L_0x0420
        L_0x041e:
            android.graphics.Bitmap r2 = r13.tunaSrcAnchorNormal
        L_0x0420:
            android.graphics.Matrix r3 = r13.tunaAnchorMatrix
            android.graphics.Paint r4 = r13.tunaPaint
            r14.drawBitmap(r2, r3, r4)
            float r1 = -r1
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x0430
            float r2 = r13.tunaSrcAnchorSelectDx
        L_0x042e:
            float r2 = -r2
            goto L_0x043a
        L_0x0430:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x0437
            float r2 = r13.tunaSrcAnchorPressDx
            goto L_0x042e
        L_0x0437:
            float r2 = r13.tunaSrcAnchorNormalDx
            goto L_0x042e
        L_0x043a:
            float r1 = r1 + r2
            float r0 = -r0
            boolean r2 = r13.tunaSelect
            if (r2 == 0) goto L_0x0444
            float r2 = r13.tunaSrcAnchorSelectDy
        L_0x0442:
            float r2 = -r2
            goto L_0x044e
        L_0x0444:
            boolean r2 = r13.tunaPress
            if (r2 == 0) goto L_0x044b
            float r2 = r13.tunaSrcAnchorPressDy
            goto L_0x0442
        L_0x044b:
            float r2 = r13.tunaSrcAnchorNormalDy
            goto L_0x0442
        L_0x044e:
            float r0 = r0 + r2
            r14.translate(r1, r0)
        L_0x0452:
            java.lang.String r10 = r13.tunaTextValue
            r15 = 2
            if (r10 == 0) goto L_0x04d7
            int r0 = r13.tunaWidth
            float r11 = (float) r0
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaTextDx
            float r0 = r0 + r1
            float r1 = r13.tunaSrcLeftWidth
            float r2 = r1 * r12
            float r0 = r0 + r2
            float r2 = r13.tunaSrcLeftPadding
            float r2 = r2 * r12
            float r0 = r0 + r2
            float r2 = r13.tunaSrcRightWidth
            float r3 = r2 * r12
            float r0 = r0 - r3
            float r3 = r13.tunaSrcRightPadding
            float r3 = r3 * r12
            float r16 = r0 - r3
            int r0 = r13.tunaHeight
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r3 = r13.tunaTextDy
            float r17 = r0 + r3
            float r0 = r13.tunaTextPaddingLeft
            float r20 = r0 + r1
            float r0 = r13.tunaTextPaddingRight
            float r21 = r0 + r2
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            boolean r0 = r13.tunaMaterialPlay
            if (r0 == 0) goto L_0x0490
        L_0x048c:
            int r0 = r13.tunaTextColorPress
        L_0x048e:
            r2 = r0
            goto L_0x049f
        L_0x0490:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x0497
            int r0 = r13.tunaTextColorSelect
            goto L_0x048e
        L_0x0497:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x049c
            goto L_0x048c
        L_0x049c:
            int r0 = r13.tunaTextColorNormal
            goto L_0x048e
        L_0x049f:
            float r3 = r13.tunaTextSize
            float r4 = r13.tunaTextShadowRadius
            int r5 = r13.tunaTextShadowColor
            float r6 = r13.tunaTextShadowDx
            float r7 = r13.tunaTextShadowDy
            android.graphics.Typeface r8 = r13.tunaTextTypeFace
            android.graphics.Paint$Align r9 = android.graphics.Paint.Align.CENTER
            r0 = r24
            android.graphics.Paint r8 = r0.initTunaTextPaint(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            com.tunasashimi.tuna.TunaView$TunaTextGravity r9 = r13.tunaTextGravity
            float r7 = r13.tunaTextRowSpaceRatio
            java.util.List<java.lang.Integer> r6 = r13.tunaTextValueMeasureList
            r1 = r25
            r2 = r10
            r3 = r11
            r4 = r16
            r5 = r17
            r11 = r6
            r6 = r20
            r10 = r7
            r7 = r21
            float[] r0 = r0.drawTunaText(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r0[r19]
            r13.tunaTextDrawWidth = r1
            r1 = r0[r18]
            r13.tunaTextEndOffsetCenterX = r1
            r0 = r0[r15]
            r13.tunaTextEndOffsetCenterY = r0
        L_0x04d7:
            java.lang.String r0 = r13.tunaContentValue
            if (r0 == 0) goto L_0x056c
            com.tunasashimi.tuna.TunaView$TunaTextGravity[] r0 = tunaTextGravityArray
            com.tunasashimi.tuna.TunaView$TunaContentGravity r1 = r13.tunaContentGravity
            int r1 = r1.nativeInt
            r10 = r0[r1]
            java.lang.String r11 = r13.tunaContentValue
            int r0 = r13.tunaWidth
            float r9 = (float) r0
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaContentDx
            float r0 = r0 + r1
            float r1 = r13.tunaSrcLeftWidth
            float r2 = r1 * r12
            float r0 = r0 + r2
            float r2 = r13.tunaSrcLeftPadding
            float r2 = r2 * r12
            float r0 = r0 + r2
            float r2 = r13.tunaSrcRightWidth
            float r3 = r2 * r12
            float r0 = r0 - r3
            float r3 = r13.tunaSrcRightPadding
            float r3 = r3 * r12
            float r16 = r0 - r3
            int r0 = r13.tunaHeight
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r3 = r13.tunaContentDy
            float r17 = r0 + r3
            float r0 = r13.tunaContentPaddingLeft
            float r20 = r0 + r1
            float r0 = r13.tunaContentPaddingRight
            float r21 = r0 + r2
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            boolean r0 = r13.tunaMaterialPlay
            if (r0 == 0) goto L_0x051e
        L_0x051a:
            int r0 = r13.tunaContentColorPress
        L_0x051c:
            r2 = r0
            goto L_0x052d
        L_0x051e:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x0525
            int r0 = r13.tunaContentColorSelect
            goto L_0x051c
        L_0x0525:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x052a
            goto L_0x051a
        L_0x052a:
            int r0 = r13.tunaContentColorNormal
            goto L_0x051c
        L_0x052d:
            float r3 = r13.tunaContentSize
            float r4 = r13.tunaContentShadowRadius
            int r5 = r13.tunaContentShadowColor
            float r6 = r13.tunaContentShadowDx
            float r7 = r13.tunaContentShadowDy
            android.graphics.Typeface r8 = r13.tunaContentTypeFace
            android.graphics.Paint$Align r22 = android.graphics.Paint.Align.CENTER
            r0 = r24
            r23 = r9
            r9 = r22
            android.graphics.Paint r8 = r0.initTunaTextPaint(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            float r9 = r13.tunaContentRowSpaceRatio
            java.util.List<java.lang.Integer> r7 = r13.tunaContentValueMeasureList
            r1 = r25
            r2 = r11
            r3 = r23
            r4 = r16
            r5 = r17
            r6 = r20
            r11 = r7
            r7 = r21
            r16 = r9
            r9 = r10
            r10 = r16
            float[] r0 = r0.drawTunaText(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r0[r19]
            r13.tunaContentDrawWidth = r1
            r1 = r0[r18]
            r13.tunaContentEndOffsetCenterX = r1
            r0 = r0[r15]
            r13.tunaContentEndOffsetCenterY = r0
        L_0x056c:
            android.graphics.Bitmap r0 = r13.tunaSrcLeft
            if (r0 == 0) goto L_0x05a5
            int r0 = r13.tunaWidth
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaSrcLeftWidth
            float r1 = r1 * r12
            float r0 = r0 - r1
            float r1 = r13.tunaTextDrawWidth
            float r1 = r1 * r12
            float r0 = r0 - r1
            float r1 = r13.tunaSrcLeftPadding
            float r1 = r1 * r12
            float r0 = r0 - r1
            float r1 = r13.tunaSrcLeftDx
            float r0 = r0 + r1
            int r1 = r13.tunaHeight
            int r1 = r1 >> 1
            float r1 = (float) r1
            float r2 = r13.tunaSrcLeftHeight
            float r2 = r2 * r12
            float r1 = r1 - r2
            float r2 = r13.tunaSrcLeftDy
            float r1 = r1 + r2
            r14.translate(r0, r1)
            android.graphics.Bitmap r2 = r13.tunaSrcLeft
            android.graphics.Matrix r3 = r13.tunaLeftMatrix
            android.graphics.Paint r4 = r13.tunaPaint
            r14.drawBitmap(r2, r3, r4)
            float r0 = -r0
            float r1 = -r1
            r14.translate(r0, r1)
        L_0x05a5:
            android.graphics.Bitmap r0 = r13.tunaSrcRight
            if (r0 == 0) goto L_0x05de
            int r0 = r13.tunaWidth
            int r0 = r0 >> 1
            float r0 = (float) r0
            float r1 = r13.tunaSrcRightWidth
            float r1 = r1 * r12
            float r0 = r0 - r1
            float r1 = r13.tunaTextDrawWidth
            float r1 = r1 * r12
            float r0 = r0 + r1
            float r1 = r13.tunaSrcRightPadding
            float r1 = r1 * r12
            float r0 = r0 + r1
            float r1 = r13.tunaSrcRightDx
            float r0 = r0 + r1
            int r1 = r13.tunaHeight
            int r1 = r1 >> 1
            float r1 = (float) r1
            float r2 = r13.tunaSrcRightHeight
            float r2 = r2 * r12
            float r1 = r1 - r2
            float r2 = r13.tunaSrcRightDy
            float r1 = r1 + r2
            r14.translate(r0, r1)
            android.graphics.Bitmap r2 = r13.tunaSrcRight
            android.graphics.Matrix r3 = r13.tunaRightMatrix
            android.graphics.Paint r4 = r13.tunaPaint
            r14.drawBitmap(r2, r3, r4)
            float r0 = -r0
            float r1 = -r1
            r14.translate(r0, r1)
        L_0x05de:
            boolean r0 = r13.tunaTextMark
            if (r0 == 0) goto L_0x060d
            float r2 = r13.tunaTextMarkRadius
            int r0 = r13.tunaTextMarkColor
            android.graphics.Paint r3 = r13.initTunaPaint(r0)
            float r4 = r13.tunaTextMarkRadius
            float r5 = r13.tunaTextMarkDx
            float r6 = r13.tunaTextMarkDy
            float r0 = r13.tunaTextDx
            float r1 = r13.tunaTextEndOffsetCenterX
            float r0 = r0 + r1
            float r7 = r0 + r5
            float r0 = r13.tunaTextDy
            float r1 = r13.tunaTextEndOffsetCenterY
            float r0 = r0 + r1
            float r8 = r0 + r6
            java.lang.String r9 = r13.tunaTextMarkTextValue
            int r10 = r13.tunaTextMarkTextColor
            float r11 = r13.tunaTextMarkTextSize
            java.util.List<java.lang.Integer> r12 = r13.tunaTextMarkTextValueMeasureList
            r0 = r24
            r1 = r25
            r0.drawTunaTextMark(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x060d:
            boolean r0 = r13.tunaContentMark
            if (r0 == 0) goto L_0x063c
            float r2 = r13.tunaContentMarkRadius
            int r0 = r13.tunaContentMarkColor
            android.graphics.Paint r3 = r13.initTunaPaint(r0)
            float r4 = r13.tunaContentMarkRadius
            float r5 = r13.tunaContentMarkDx
            float r6 = r13.tunaContentMarkDy
            float r0 = r13.tunaContentDx
            float r1 = r13.tunaContentEndOffsetCenterX
            float r0 = r0 + r1
            float r7 = r0 + r5
            float r0 = r13.tunaContentDy
            float r1 = r13.tunaContentEndOffsetCenterY
            float r0 = r0 + r1
            float r8 = r0 + r6
            java.lang.String r9 = r13.tunaContentMarkTextValue
            int r10 = r13.tunaContentMarkTextColor
            float r11 = r13.tunaContentMarkTextSize
            java.util.List<java.lang.Integer> r12 = r13.tunaContentMarkTextValueMeasureList
            r0 = r24
            r1 = r25
            r0.drawTunaTextMark(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x063c:
            boolean r0 = r13.tunaSelect
            if (r0 == 0) goto L_0x066f
            int r4 = r13.tunaForegroundSelect
            if (r4 == 0) goto L_0x066f
            boolean r0 = r13.tunaClassic
            if (r0 == 0) goto L_0x0659
            int r0 = r13.tunaWidth
            float r2 = (float) r0
            int r0 = r13.tunaHeight
            float r3 = (float) r0
            float r5 = r13.tunaRadius
            r0 = r24
            r1 = r25
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5)
            goto L_0x06ce
        L_0x0659:
            int r2 = r13.tunaWidth
            int r3 = r13.tunaHeight
            r5 = 0
            r6 = 0
            float r7 = r13.tunaRadiusLeftTop
            float r8 = r13.tunaRadiusLeftBottom
            float r9 = r13.tunaRadiusRightTop
            float r10 = r13.tunaRadiusRightBottom
            r0 = r24
            r1 = r25
            r0.drawTunaRectCustom((android.graphics.Canvas) r1, (int) r2, (int) r3, (int) r4, (float) r5, (int) r6, (float) r7, (float) r8, (float) r9, (float) r10)
            goto L_0x06ce
        L_0x066f:
            boolean r0 = r13.tunaPress
            if (r0 == 0) goto L_0x06a1
            int r4 = r13.tunaForegroundPress
            if (r4 == 0) goto L_0x06a1
            boolean r0 = r13.tunaClassic
            if (r0 == 0) goto L_0x068b
            int r0 = r13.tunaWidth
            float r2 = (float) r0
            int r0 = r13.tunaHeight
            float r3 = (float) r0
            float r5 = r13.tunaRadius
            r0 = r24
            r1 = r25
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5)
            goto L_0x06ce
        L_0x068b:
            int r2 = r13.tunaWidth
            int r3 = r13.tunaHeight
            r5 = 0
            r6 = 0
            float r7 = r13.tunaRadiusLeftTop
            float r8 = r13.tunaRadiusLeftBottom
            float r9 = r13.tunaRadiusRightTop
            float r10 = r13.tunaRadiusRightBottom
            r0 = r24
            r1 = r25
            r0.drawTunaRectCustom((android.graphics.Canvas) r1, (int) r2, (int) r3, (int) r4, (float) r5, (int) r6, (float) r7, (float) r8, (float) r9, (float) r10)
            goto L_0x06ce
        L_0x06a1:
            int r4 = r13.tunaForegroundNormal
            if (r4 == 0) goto L_0x06ce
            boolean r0 = r13.tunaClassic
            if (r0 == 0) goto L_0x06b9
            int r0 = r13.tunaWidth
            float r2 = (float) r0
            int r0 = r13.tunaHeight
            float r3 = (float) r0
            float r5 = r13.tunaRadius
            r0 = r24
            r1 = r25
            r0.drawTunaRectClassic(r1, r2, r3, r4, r5)
            goto L_0x06ce
        L_0x06b9:
            int r2 = r13.tunaWidth
            int r3 = r13.tunaHeight
            r5 = 0
            r6 = 0
            float r7 = r13.tunaRadiusLeftTop
            float r8 = r13.tunaRadiusLeftBottom
            float r9 = r13.tunaRadiusRightTop
            float r10 = r13.tunaRadiusRightBottom
            r0 = r24
            r1 = r25
            r0.drawTunaRectCustom((android.graphics.Canvas) r1, (int) r2, (int) r3, (int) r4, (float) r5, (int) r6, (float) r7, (float) r8, (float) r9, (float) r10)
        L_0x06ce:
            int r0 = r13.tunaRotate
            if (r0 == 0) goto L_0x06e1
            int r0 = -r0
            float r0 = (float) r0
            int r1 = r13.tunaWidth
            int r1 = r1 >> 1
            float r1 = (float) r1
            int r2 = r13.tunaHeight
            int r2 = r2 >> 1
            float r2 = (float) r2
            r14.rotate(r0, r1, r2)
        L_0x06e1:
            com.tunasashimi.tuna.TunaView$TunaDrawListener r0 = r13.tunaDrawListener
            if (r0 == 0) goto L_0x06e8
            r0.tunaDraw(r13)
        L_0x06e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaView.onDraw(android.graphics.Canvas):void");
    }
}

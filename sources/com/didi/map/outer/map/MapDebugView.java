package com.didi.map.outer.map;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.log.HWLog;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.sdk.apm.SystemUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class MapDebugView {
    private static final double BYTE_TO_GB_SIZE = 1.073741824E9d;
    private static final double KB_TO_MB_SIZE = 1024.0d;
    private static LimitList<String> MESSAGES = new LimitList<>(3);
    private static final boolean OPEN_MAP_TIME_VIEW = ApolloHawaii.isOpenMapTimeView();
    private static final boolean OPEN_MEMORY_VIEW = ApolloHawaii.isOpenMapMemoryView();
    private static final int[] P_ID = {Process.myPid()};
    private static final long STAT_MEMORY_DURATION = 30000;
    private static final String[] TITLE_LIST;
    public static final String TYPE_CONFIG_FILES = "type_config_files";
    /* access modifiers changed from: private */
    public static WeakReference<MapDebugView> sInstance = null;
    /* access modifiers changed from: private */
    public static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public float StartX;
    /* access modifiers changed from: private */
    public float StartY;
    private final ActivityManager activityManager;
    /* access modifiers changed from: private */
    public final Context context;
    private final Data data = new Data();
    private Runnable debugTextRunnable;
    /* access modifiers changed from: private */
    public TextView debugTextView;
    /* access modifiers changed from: private */
    public DidiMap didiMap;
    /* access modifiers changed from: private */
    public boolean isMoved;
    /* access modifiers changed from: private */
    public final DateFormat mDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.CHINA);
    /* access modifiers changed from: private */
    public float mTouchStartX;
    /* access modifiers changed from: private */
    public float mTouchStartY;
    private Runnable memoryRunnable;
    /* access modifiers changed from: private */
    public TextView memoryView;
    /* access modifiers changed from: private */
    public TextView scaleView;
    private Runnable timerRunnable;
    /* access modifiers changed from: private */
    public TextView timerView;
    public TextView ttlTimeView;
    /* access modifiers changed from: private */
    public final WindowManager windowManager;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public float f27849x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public float f27850y;

    static {
        if (OPEN_MAP_TIME_VIEW) {
            TITLE_LIST = new String[]{"配置文件管理"};
        } else {
            TITLE_LIST = null;
        }
    }

    private static class LimitList<T> extends LinkedList<T> {
        private int limit;

        LimitList(int i) {
            this.limit = i;
        }

        public boolean add(T t) {
            if (size() + 1 > this.limit) {
                super.removeFirst();
            }
            return super.add(t);
        }
    }

    MapDebugView(Context context2) {
        this.context = context2;
        sInstance = new WeakReference<>(this);
        this.windowManager = (WindowManager) context2.getSystemService("window");
        this.activityManager = (ActivityManager) HWContextProvider.getContext().getSystemService("activity");
    }

    /* access modifiers changed from: package-private */
    public void init(DidiMap didiMap2, final FrameLayout frameLayout) {
        if (OPEN_MAP_TIME_VIEW) {
            final LinearLayout linearLayout = new LinearLayout(this.context);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(Color.argb(50, 0, 0, 0));
            TextView textView = new TextView(this.context);
            textView.setText("MAP");
            textView.setTextColor(Color.argb(150, 0, 0, 0));
            textView.setTextSize(2, 18.0f);
            textView.setGravity(1);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(this.context);
            this.timerView = textView2;
            textView2.setTextColor(Color.argb(150, 0, 0, 0));
            this.timerView.setTextSize(10.0f);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            linearLayout.addView(this.timerView, layoutParams);
            if (OPEN_MEMORY_VIEW) {
                TextView textView3 = new TextView(this.context);
                this.memoryView = textView3;
                textView3.setTextColor(Color.argb(150, 0, 0, 0));
                this.memoryView.setTextSize(10.0f);
                linearLayout.addView(this.memoryView, layoutParams);
            }
            TextView textView4 = new TextView(this.context);
            this.debugTextView = textView4;
            textView4.setTextColor(Color.argb(150, 0, 0, 0));
            this.debugTextView.setTextSize(10.0f);
            linearLayout.addView(this.debugTextView, layoutParams);
            TextView textView5 = new TextView(this.context);
            this.scaleView = textView5;
            textView5.setTextColor(Color.argb(150, 0, 0, 0));
            this.scaleView.setTextSize(10.0f);
            linearLayout.addView(this.scaleView, layoutParams);
            TextView textView6 = new TextView(this.context);
            this.ttlTimeView = textView6;
            textView6.setTextColor(Color.argb(150, 0, 0, 0));
            this.ttlTimeView.setTextSize(10.0f);
            linearLayout.addView(this.ttlTimeView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = 800;
            frameLayout.addView(linearLayout, layoutParams2);
            linearLayout.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    float unused = MapDebugView.this.f27849x = motionEvent.getRawX();
                    float unused2 = MapDebugView.this.f27850y = motionEvent.getRawY();
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        MapDebugView mapDebugView = MapDebugView.this;
                        float unused3 = mapDebugView.StartX = mapDebugView.f27849x;
                        MapDebugView mapDebugView2 = MapDebugView.this;
                        float unused4 = mapDebugView2.StartY = mapDebugView2.f27850y;
                        float unused5 = MapDebugView.this.mTouchStartX = motionEvent.getX();
                        float unused6 = MapDebugView.this.mTouchStartY = motionEvent.getY();
                        boolean unused7 = MapDebugView.this.isMoved = false;
                    } else if (action == 1) {
                        if (Math.abs(MapDebugView.this.f27849x - MapDebugView.this.StartX) > 10.0f || Math.abs(MapDebugView.this.f27850y - MapDebugView.this.StartY) > 10.0f) {
                            layoutParams.leftMargin = (int) (MapDebugView.this.f27849x - MapDebugView.this.mTouchStartX);
                            layoutParams.topMargin = (int) (MapDebugView.this.f27850y - MapDebugView.this.mTouchStartY);
                            boolean unused8 = MapDebugView.this.isMoved = true;
                            frameLayout.updateViewLayout(linearLayout, layoutParams);
                        }
                        MapDebugView mapDebugView3 = MapDebugView.this;
                        float unused9 = mapDebugView3.mTouchStartX = mapDebugView3.mTouchStartY = 0.0f;
                        if (!MapDebugView.this.isMoved) {
                            boolean unused10 = MapDebugView.this.isMoved = false;
                        }
                    } else if (action == 2 && (Math.abs(MapDebugView.this.f27849x - MapDebugView.this.StartX) > 10.0f || Math.abs(MapDebugView.this.f27850y - MapDebugView.this.StartY) > 10.0f)) {
                        layoutParams.leftMargin = (int) (MapDebugView.this.f27849x - MapDebugView.this.mTouchStartX);
                        layoutParams.topMargin = (int) (MapDebugView.this.f27850y - MapDebugView.this.mTouchStartY);
                        boolean unused11 = MapDebugView.this.isMoved = true;
                        frameLayout.updateViewLayout(linearLayout, layoutParams);
                    }
                    return true;
                }
            });
            C99042 r10 = new Runnable() {
                public void run() {
                    MapDebugView.this.timerView.setText(MapDebugView.this.mDateFormat.format(new Date(System.currentTimeMillis())));
                    MapDebugView.this.timerView.setTextColor(Color.parseColor("#FF0000"));
                    MapDebugView.sMainHandler.postDelayed(this, 300);
                }
            };
            this.timerRunnable = r10;
            sMainHandler.post(r10);
            if (OPEN_MEMORY_VIEW) {
                C99053 r102 = new Runnable() {
                    public void run() {
                        MapDebugView.this.memoryView.setText(MapDebugView.this.getMemNowAppInfo());
                        MapDebugView.this.memoryView.setTextColor(Color.parseColor("#FF0000"));
                        MapDebugView.sMainHandler.postDelayed(this, 30000);
                    }
                };
                this.memoryRunnable = r102;
                sMainHandler.post(r102);
            }
            C99064 r103 = new Runnable() {
                public void run() {
                    String access$1300 = MapDebugView.this.getDebugInfo();
                    if (!MapDebugView.this.debugTextView.getText().toString().equals(access$1300)) {
                        MapDebugView.this.debugTextView.setText(access$1300);
                        MapDebugView.this.debugTextView.setTextColor(Color.parseColor("#FF0000"));
                    }
                    MapDebugView.sMainHandler.postDelayed(this, 1000);
                }
            };
            this.debugTextRunnable = r103;
            sMainHandler.post(r103);
            this.didiMap = didiMap2;
            ((DidiMapExt) didiMap2).addScaleChangeListener(new OnMapScaleChangedListener() {
                public void onScaleChanged(OnMapScaleChangedListener.ScaleChangedType scaleChangedType) {
                    if (scaleChangedType == OnMapScaleChangedListener.ScaleChangedType.SCALE_LEVEL_CHANGED) {
                        MapDebugView.sMainHandler.post(new Runnable() {
                            public void run() {
                                TextView access$1600 = MapDebugView.this.scaleView;
                                access$1600.setText("ScaleLevel: " + MapDebugView.this.didiMap.getCurScaleLevel());
                            }
                        });
                    }
                }
            });
        }
    }

    private String formatMemoryKB2MB(double d) {
        return String.format("%.2f", new Object[]{Double.valueOf(d / KB_TO_MB_SIZE)});
    }

    private String formatMemoryByte2GB(double d) {
        return String.format("%.2f", new Object[]{Double.valueOf(d / BYTE_TO_GB_SIZE)});
    }

    /* access modifiers changed from: private */
    public String getMemNowAppInfo() {
        StringBuilder sb = new StringBuilder();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            sb.append("totalMemory:");
            sb.append(formatMemoryByte2GB((double) memoryInfo.totalMem));
            sb.append(",avilMemory:");
            sb.append(formatMemoryByte2GB((double) memoryInfo.availMem));
            sb.append("\n");
        }
        if (Build.VERSION.SDK_INT >= 5) {
            Debug.MemoryInfo[] processMemoryInfo = this.activityManager.getProcessMemoryInfo(P_ID);
            if (processMemoryInfo.length > 0) {
                Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                sb.append("dalvikPrivateDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.dalvikPrivateDirty));
                sb.append(",dalvikSharedDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.dalvikSharedDirty));
                sb.append(",dalvikPss:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.dalvikPss));
                sb.append("\n");
                sb.append("nativePrivateDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.nativePrivateDirty));
                sb.append(",nativeSharedDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.nativeSharedDirty));
                sb.append(",nativePss:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.nativePss));
                sb.append("\n");
                sb.append(",otherPrivateDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.otherPrivateDirty));
                sb.append(",otherSharedDirty:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.otherSharedDirty));
                sb.append(",otherPss:");
                sb.append(formatMemoryKB2MB((double) memoryInfo2.otherPss));
                sb.append("\n");
                if (Build.VERSION.SDK_INT >= 23) {
                    for (Map.Entry next : memoryInfo2.getMemoryStats().entrySet()) {
                        sb.append((String) next.getKey());
                        sb.append(":");
                        sb.append(formatMemoryKB2MB(Double.valueOf((String) next.getValue()).doubleValue()));
                        sb.append("\n");
                    }
                }
            }
        }
        HWLog.m16759d("MapDebugView", "AppMemoryInfo:" + sb);
        return sb.toString();
    }

    private void performClick(FrameLayout frameLayout) {
        final LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        TextView textView = new TextView(this.context);
        textView.setText(this.data.configFiles.toString());
        textView.setTextColor(-16777216);
        Button button = new Button(this.context);
        button.setText("Close");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapDebugView.this.windowManager.removeView(linearLayout);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView(button);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2005;
        layoutParams.flags |= 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = 1;
        this.windowManager.addView(linearLayout, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        if (OPEN_MAP_TIME_VIEW) {
            sMainHandler.removeCallbacks(this.timerRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        if (OPEN_MAP_TIME_VIEW) {
            sMainHandler.removeCallbacks(this.timerRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        if (OPEN_MAP_TIME_VIEW) {
            sMainHandler.removeCallbacks(this.timerRunnable);
            sMainHandler.post(this.timerRunnable);
        }
    }

    public static void notifiedDebugView(final String str, final Object obj) {
        if (OPEN_MAP_TIME_VIEW) {
            sMainHandler.post(new Runnable() {
                public void run() {
                    MapDebugView mapDebugView;
                    if (MapDebugView.sInstance != null && (mapDebugView = (MapDebugView) MapDebugView.sInstance.get()) != null) {
                        Context access$2000 = mapDebugView.context;
                        SystemUtils.showToast(Toast.makeText(access$2000, "MapDebugView update " + str + " with " + obj, 0));
                        mapDebugView.updateView(str, obj);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateView(String str, Object obj) {
        if (OPEN_MAP_TIME_VIEW) {
            char c = 65535;
            if (str.hashCode() == 966823967 && str.equals(TYPE_CONFIG_FILES)) {
                c = 0;
            }
            if (c == 0) {
                Object obj2 = SystemUtils.getSharedPreferences(this.context, "com.didi.map", 0).getAll().get("MAP_CONFIG_INFO");
                if (obj2 instanceof Set) {
                    for (Object next : (Set) obj2) {
                        if (next instanceof String) {
                            String[] split = ((String) next).split(",");
                            if (split.length > 2) {
                                this.data.configFiles.put(split[0], split[1]);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void pushDebugText(String str) {
        MESSAGES.add(str);
    }

    public static void showTTLTimeInfo(final String str) {
        if (OPEN_MAP_TIME_VIEW) {
            sMainHandler.post(new Runnable() {
                public void run() {
                    MapDebugView mapDebugView;
                    if (MapDebugView.sInstance != null && (mapDebugView = (MapDebugView) MapDebugView.sInstance.get()) != null && mapDebugView.ttlTimeView != null) {
                        mapDebugView.ttlTimeView.setText(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String getDebugInfo() {
        StringBuilder sb = new StringBuilder();
        Iterator it = MESSAGES.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        return sb.toString();
    }

    private static class Data {
        /* access modifiers changed from: private */
        public final Map<String, String> configFiles;

        private Data() {
            this.configFiles = new HashMap();
        }
    }
}

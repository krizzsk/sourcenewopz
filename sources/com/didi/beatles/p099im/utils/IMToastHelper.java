package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.utils.IMToastHelper */
public class IMToastHelper {

    /* renamed from: a */
    private static WeakReference<Toast> f9796a;

    /* renamed from: com.didi.beatles.im.utils.IMToastHelper$IconType */
    public enum IconType {
        INFO,
        COMPLETE,
        ERROR
    }

    /* renamed from: a */
    private static Toast m6647a(Context context) {
        WeakReference<Toast> weakReference = f9796a;
        Toast toast = weakReference == null ? null : (Toast) weakReference.get();
        if (toast != null) {
            return toast;
        }
        Toast b = m6649b(context);
        f9796a = new WeakReference<>(b);
        return b;
    }

    /* renamed from: b */
    private static Toast m6649b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_common_toast, (ViewGroup) null, false);
        Toast toast = new Toast(context);
        toast.setView(inflate);
        toast.setGravity(1, 0, 0);
        return toast;
    }

    /* renamed from: a */
    private static void m6648a(Context context, IconType iconType, ImageView imageView) {
        if (iconType == null) {
            imageView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.im_common_toast_icon_info));
        } else if (IconType.INFO.toString().equals(iconType.name())) {
            imageView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.im_common_toast_icon_info));
        } else if (IconType.COMPLETE.toString().equals(iconType.name())) {
            imageView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.im_common_toast_icon_complete));
        } else if (IconType.ERROR.toString().equals(iconType.name())) {
            imageView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.im_common_toast_icon_error));
        }
    }

    public static void showLongInfo(Context context, int i) {
        showLongInfo(context, context.getResources().getString(i));
    }

    public static void showShortInfo(Context context, int i) {
        showShortInfo(context, context.getResources().getString(i));
    }

    public static void showShortError(Context context, int i) {
        showShortError(context, context.getResources().getString(i));
    }

    public static void showLongError(Context context, int i) {
        showLongError(context, context.getResources().getString(i));
    }

    public static void showLongCompleteMessage(Context context, int i) {
        showLongCompleteMessage(context, context.getResources().getString(i));
    }

    public static void showShortCompleted(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.COMPLETE, imageView);
            }
        }
        a.setDuration(0);
        SystemUtils.showToast(a);
    }

    public static void showShortCompleted(Context context, int i) {
        showShortCompleted(context, context.getResources().getString(i));
    }

    public static void showShortInfo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.INFO, imageView);
            }
        }
        a.setDuration(0);
        SystemUtils.showToast(a);
    }

    public static void showShortInfo(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setText(str2);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.INFO, imageView);
            }
        }
        a.setDuration(0);
        SystemUtils.showToast(a);
    }

    public static void showLongInfo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.INFO, imageView);
            }
        }
        a.setDuration(1);
        SystemUtils.showToast(a);
    }

    public static void showShortError(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.ERROR, imageView);
            }
        }
        a.setDuration(0);
        SystemUtils.showToast(a);
    }

    public static void showLongCompleteMessage(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.COMPLETE, imageView);
            }
        }
        a.setDuration(1);
        SystemUtils.showToast(a);
    }

    public static void showLongError(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast a = m6647a(applicationContext);
        if (a.getView() != null) {
            ImageView imageView = (ImageView) a.getView().findViewById(R.id.imgViewIcon);
            TextView textView = (TextView) a.getView().findViewById(R.id.txtViewContent);
            TextView textView2 = (TextView) a.getView().findViewById(R.id.subContent);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                m6648a(applicationContext, IconType.ERROR, imageView);
            }
        }
        a.setDuration(1);
        SystemUtils.showToast(a);
    }
}

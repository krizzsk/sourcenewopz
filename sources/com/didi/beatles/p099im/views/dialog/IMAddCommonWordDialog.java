package com.didi.beatles.p099im.views.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.activity.IMBaseActivity;
import com.didi.beatles.p099im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.dialog.addWord.IMAddCommonWord;
import com.didi.beatles.p099im.views.dialog.addWord.IMAddCommonWordDefault;
import com.didi.beatles.p099im.views.dialog.addWord.IMAddCommonWordGlobalPsg;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog */
public class IMAddCommonWordDialog extends IMBaseActivity {
    public static final int MAX_LENGTH = 60;
    public static final int MAX_TITLE_LENGTH = 10;
    public static final int MAX_WORD_NUM = 60;
    public static final int RESOUCE_HAND = 1;
    public static final int RESOUCE_LONG_PRESSED = 3;
    public static final int RESOUCE_RECOMMOND = 2;

    /* renamed from: a */
    private static final String f10159a = "custom_word";

    /* renamed from: b */
    private static final String f10160b = "resource";

    /* renamed from: c */
    private static final String f10161c = "word_type";

    /* renamed from: d */
    private static final String f10162d = "word_num";

    /* renamed from: e */
    private static final String f10163e = "bussiness_id";

    /* renamed from: f */
    private IMAddCommonWord f10164f;
    public int mBussinessId;
    public int mCommondWordType;
    public String mContentText;
    public int mCustomWordNum;
    public int mResource = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog$CommonWordResouce */
    public @interface CommonWordResouce {
    }

    /* access modifiers changed from: protected */
    public boolean isUseTheme() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        m6927a();
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f10164f = new IMAddCommonWordGlobalPsg();
        } else {
            this.f10164f = new IMAddCommonWordDefault();
        }
        setContentView(this.f10164f.layoutRes());
        this.f10164f.bind(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        IMAddCommonWord iMAddCommonWord = this.f10164f;
        if (iMAddCommonWord != null) {
            iMAddCommonWord.release();
        }
    }

    public static void show(Context context, int i, String str, int i2, int i3, int i4) {
        Intent intent = new Intent(context, IMAddCommonWordDialog.class);
        intent.putExtra(f10159a, str);
        intent.putExtra("resource", i2);
        intent.putExtra("word_type", i3);
        intent.putExtra(f10162d, i4);
        intent.putExtra(f10163e, i);
        context.startActivity(intent);
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i2));
        IMMsgOmega.getInstance().track("ddim_dy_all_add_sw", hashMap);
    }

    /* renamed from: a */
    private void m6927a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mResource = intent.getIntExtra("resource", 1);
            this.mContentText = intent.getStringExtra(f10159a);
            this.mCommondWordType = intent.getIntExtra("word_type", 1);
            this.mCustomWordNum = intent.getIntExtra(f10162d, -1);
            this.mBussinessId = intent.getIntExtra(f10163e, -1);
        }
    }

    public void showToast(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }

    public void dismiss() {
        closeSoftInput();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                IMAddCommonWordDialog.this.finish();
                EventBus.getDefault().post(new IMMessageUnlockRecyclerViewEvent(0));
            }
        }, 300);
    }

    public void closeSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 2);
        }
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAddCommonWordDialog$CustomWord */
    public static class CustomWord {
        public int resource;
        public String text;

        public CustomWord(String str, int i) {
            this.text = str;
            this.resource = i;
        }
    }
}

package com.didi.addressold.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.addressold.fastframe.IView;
import com.didi.addressold.util.SavedInstance;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class BaseActivity extends InstanceStateActivity implements IView {

    /* renamed from: a */
    private Toast f7844a = null;

    /* renamed from: b */
    private RelativeLayout f7845b = null;

    /* renamed from: c */
    private ImageView f7846c = null;

    /* renamed from: d */
    private TextView f7847d = null;

    /* renamed from: e */
    private ViewGroup f7848e = null;

    /* renamed from: f */
    private ViewStub f7849f = null;

    /* renamed from: g */
    private ViewGroup f7850g = null;

    /* renamed from: h */
    private TextView f7851h = null;
    @SavedInstance

    /* renamed from: i */
    private boolean f7852i = false;

    public abstract void loadContentView(Bundle bundle);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        super.setContentView((int) R.layout.old_poi_one_address_fastframe_activity_base);
        this.f7845b = (RelativeLayout) findViewById(R.id.toolbar_main);
        ImageView imageView = (ImageView) findViewById(R.id.image_title_default);
        this.f7846c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseActivity.this.finish();
            }
        });
        super.setTitle("");
        this.f7847d = (TextView) findViewById(R.id.txt_title);
        this.f7848e = (ViewGroup) findViewById(R.id.layout_content);
        this.f7851h = (TextView) findViewById(R.id.txt_menu);
    }

    public void setContentView(int i) {
        if (this.f7848e != null) {
            LayoutInflater.from(this).inflate(i, this.f7848e);
        }
    }

    public void setTitle(String str) {
        super.setTitle("");
        TextView textView = this.f7847d;
        if (textView != null) {
            textView.setText(str);
            this.f7847d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str)) {
            setTitleTextVisible(true);
        }
    }

    public void setToolbarVisibility(int i) {
        RelativeLayout relativeLayout = this.f7845b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void setTitle(View view) {
        super.setTitle("");
        TextView textView = this.f7847d;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setTitleTextVisible(boolean z) {
        TextView textView = this.f7847d;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSingleMenu(String str, View.OnClickListener onClickListener) {
        if (this.f7851h == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || onClickListener == null) {
            this.f7851h.setVisibility(8);
            this.f7851h.setText((CharSequence) null);
            this.f7851h.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.f7851h.setVisibility(0);
        this.f7851h.setText(str);
        this.f7851h.setOnClickListener(onClickListener);
    }

    public View getFallbackView() {
        return this.f7845b;
    }

    public void showProgressDialog(String str, boolean z) {
        if (z) {
            showMaskLayerLoading();
        } else {
            showLoading();
        }
    }

    public void showProgressDialog(boolean z) {
        showProgressDialog(getString(R.string.global_sug_loading), z);
    }

    public void dismissProgressDialog() {
        hideLoading();
    }

    public void showToastComplete(String str) {
        ToastHelper.showShortCompleted((Context) this, str);
    }

    public void showToastError(String str) {
        if (str != null) {
            showToastError(str, str.length() > 20);
        }
    }

    public void showToastError(String str, boolean z) {
        if (str == null) {
            return;
        }
        if (z) {
            ToastHelper.showLongError((Context) this, str);
        } else {
            ToastHelper.showShortError((Context) this, str);
        }
    }

    @Deprecated
    public void showToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            Toast toast = this.f7844a;
            if (toast != null) {
                toast.cancel();
            }
            Toast makeText = Toast.makeText(this, str, 1);
            this.f7844a = makeText;
            SystemUtils.showToast(makeText);
        }
    }

    public void showContentView() {
        this.f7852i = false;
        ViewGroup viewGroup = this.f7848e;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f7850g;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    public void showEmptyView() {
        this.f7852i = true;
        ViewGroup viewGroup = this.f7848e;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.f7849f == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_empty);
            this.f7849f = viewStub;
            viewStub.inflate();
            this.f7850g = (ViewGroup) findViewById(R.id.layout_empty);
        }
        ViewGroup viewGroup2 = this.f7850g;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            this.f7850g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseActivity.this.loadContentView((Bundle) null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f7852i) {
            showEmptyView();
        } else {
            showContentView();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f7844a = null;
    }
}

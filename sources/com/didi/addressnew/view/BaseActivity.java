package com.didi.addressnew.view;

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
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.util.SavedInstance;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class BaseActivity extends InstanceStateActivity implements IView {

    /* renamed from: a */
    private Toast f7490a = null;

    /* renamed from: b */
    private RelativeLayout f7491b = null;

    /* renamed from: c */
    private ImageView f7492c = null;

    /* renamed from: d */
    private TextView f7493d = null;

    /* renamed from: e */
    private ViewGroup f7494e = null;

    /* renamed from: f */
    private ViewStub f7495f = null;

    /* renamed from: g */
    private ViewGroup f7496g = null;

    /* renamed from: h */
    private TextView f7497h = null;
    @SavedInstance

    /* renamed from: i */
    private boolean f7498i = false;

    public /* synthetic */ String getStringVal(int i) {
        return IView.CC.$default$getStringVal(this, i);
    }

    public abstract void loadContentView(Bundle bundle);

    public /* synthetic */ void onHttpRequestSuccess() {
        IView.CC.$default$onHttpRequestSuccess(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        super.setContentView((int) R.layout.poi_one_address_fastframe_activity_base);
        this.f7491b = (RelativeLayout) findViewById(R.id.toolbar_main);
        ImageView imageView = (ImageView) findViewById(R.id.image_title_default);
        this.f7492c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseActivity.this.finish();
            }
        });
        super.setTitle("");
        this.f7493d = (TextView) findViewById(R.id.txt_title);
        this.f7494e = (ViewGroup) findViewById(R.id.layout_content);
        this.f7497h = (TextView) findViewById(R.id.txt_menu);
    }

    public void setContentView(int i) {
        if (this.f7494e != null) {
            LayoutInflater.from(this).inflate(i, this.f7494e);
        }
    }

    public void setTitle(String str) {
        super.setTitle("");
        TextView textView = this.f7493d;
        if (textView != null) {
            textView.setText(str);
            this.f7493d.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str)) {
            setTitleTextVisible(true);
        }
    }

    public void setToolbarVisibility(int i) {
        RelativeLayout relativeLayout = this.f7491b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void setTitle(View view) {
        super.setTitle("");
        TextView textView = this.f7493d;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setTitleTextVisible(boolean z) {
        TextView textView = this.f7493d;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSingleMenu(String str, View.OnClickListener onClickListener) {
        if (this.f7497h == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || onClickListener == null) {
            this.f7497h.setVisibility(8);
            this.f7497h.setText((CharSequence) null);
            this.f7497h.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.f7497h.setVisibility(0);
        this.f7497h.setText(str);
        this.f7497h.setOnClickListener(onClickListener);
    }

    public View getFallbackView() {
        return this.f7491b;
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
            Toast toast = this.f7490a;
            if (toast != null) {
                toast.cancel();
            }
            Toast makeText = Toast.makeText(this, str, 1);
            this.f7490a = makeText;
            SystemUtils.showToast(makeText);
        }
    }

    public void showContentView() {
        this.f7498i = false;
        ViewGroup viewGroup = this.f7494e;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f7496g;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    public void showEmptyView() {
        this.f7498i = true;
        ViewGroup viewGroup = this.f7494e;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.f7495f == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_empty);
            this.f7495f = viewStub;
            viewStub.inflate();
            this.f7496g = (ViewGroup) findViewById(R.id.layout_empty);
        }
        ViewGroup viewGroup2 = this.f7496g;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            this.f7496g.setOnClickListener(new View.OnClickListener() {
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
        if (this.f7498i) {
            showEmptyView();
        } else {
            showContentView();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f7490a = null;
    }
}

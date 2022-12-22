package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didichuxing.afanty.common.collector.NetworkCollector;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.FeedbackBitmap;
import com.didichuxing.omega.sdk.feedback.shake.ShakeConfig;
import com.didichuxing.omega.sdk.feedback.webview.TitleBar;
import com.didichuxing.omega.sdk.feedback.webview.WebAppInterface;
import com.didichuxing.omega.sdk.feedback.webview.neweb.BaseWebView;
import com.didichuxing.omega.sdk.feedback.webview.neweb.BottomListMenu;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.IOException;

public class AfantyWebActivity extends FragmentActivity implements ITitleBarGetter {
    private static final String KEY_TITLE = "title";
    private static final String KEY_URL = "url";
    public static final String KEY_WEB_VIEW_MODEL = "web_view_model";
    private static final int REQUEST_CODE_CAPTURE_PIC = 1006;
    private static final int REQUEST_CODE_SELECT_PIC = 1005;
    private static final int REQUEST_PERMISSION_CODE_CAMERA = 0;
    private static final int REQUEST_PERMISSION_CODE_STORAGE = 1;
    private WebAppInterface anInterface;
    private File mChosenFile;
    /* access modifiers changed from: private */
    public View mContentView;
    private ImageView mErrorImage;
    private TextView mErrorText;
    /* access modifiers changed from: private */
    public View mErrorView;
    /* access modifiers changed from: private */
    public ValueCallback mFileChooserCallback;
    private final BaseWebView.FileChooserListener mFileChooserListener = new BaseWebView.FileChooserListener() {
        public void openFileChooser(ValueCallback valueCallback) {
            ValueCallback unused = AfantyWebActivity.this.mFileChooserCallback = valueCallback;
            AfantyWebActivity afantyWebActivity = AfantyWebActivity.this;
            BottomListMenu bottomListMenu = new BottomListMenu(afantyWebActivity, afantyWebActivity.mContentView, AfantyWebActivity.this.getResources().getStringArray(R.array.afanty_avatar_menu));
            bottomListMenu.setListMenuListener(new BottomListMenu.ListMenuListener() {
                public void onItemSelected(int i, String str) {
                    if (i == 0) {
                        if (ActivityCompat.checkSelfPermission(AfantyWebActivity.this.mContentView.getContext(), Permission.CAMERA) != 0) {
                            ActivityCompat.requestPermissions(AfantyWebActivity.this, new String[]{Permission.CAMERA}, 0);
                        } else if (!AfantyWebActivity.this.hasStoragePermission()) {
                            AfantyWebActivity.this.requestStoragePermission(AfantyWebActivity.this);
                        } else {
                            AfantyWebActivity.this.startCamera();
                        }
                    } else if (i == 1) {
                        Intent intent = new Intent();
                        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
                        intent.setAction("android.intent.action.GET_CONTENT");
                        AfantyWebActivity.this.startActivityForResult(intent, 1005);
                    }
                }
            });
            bottomListMenu.setDismissListener(new BottomListMenu.OnDismissListener() {
                public void dismiss() {
                    AfantyWebActivity.this.onActivityResult(1006, -1, (Intent) null);
                }
            });
            bottomListMenu.showDialog();
        }
    };
    private final View.OnClickListener mOnBackClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AfantyWebActivity.this.goBack();
        }
    };
    /* access modifiers changed from: private */
    public TitleBar mWebTitleBar;
    /* access modifiers changed from: private */
    public BaseWebView mWebView;
    /* access modifiers changed from: private */
    public WebViewModel mWebViewModel;
    private final View.OnClickListener onClickListenerReload = new View.OnClickListener() {
        private long mLastClickTime = 0;

        public void onClick(View view) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime >= 3000) {
                String url = AfantyWebActivity.this.mWebView.getUrl();
                if (TextUtils.equals(url, "about:blank")) {
                    WebBackForwardList copyBackForwardList = AfantyWebActivity.this.mWebView.copyBackForwardList();
                    int i = -1;
                    while (true) {
                        if (!AfantyWebActivity.this.mWebView.canGoBackOrForward(i)) {
                            url = "";
                            break;
                        }
                        WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                        if (itemAtIndex == null) {
                            str = null;
                        } else {
                            str = itemAtIndex.getUrl();
                        }
                        if (str != null && !str.equals("about:blank")) {
                            url = str;
                            break;
                        }
                        i--;
                    }
                }
                if (!TextUtils.isEmpty(url)) {
                    AfantyWebActivity.this.showProgressDialog("");
                    AfantyWebActivity.this.mWebView.loadUrl(url);
                    AfantyWebActivity.this.mErrorView.setVisibility(8);
                }
                this.mLastClickTime = currentTimeMillis;
            }
        }
    };

    public static void startFeedbackForScreenShot(Context context, String str, String str2) {
        Uri uri;
        if (context == null || TextUtils.isEmpty(str)) {
            OLog.m32669i("soda context is null || imgPath is empty.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            OLog.m32669i("soda File is not exist.");
            return;
        }
        Intent intent = new Intent(context, AfantyWebActivity.class);
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
            context.grantUriPermission(context.getPackageName(), uri, 1);
        }
        FeedbackBitmap.getInstance().setScreenshot_uri(uri);
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = str2;
        intent.putExtra("web_view_model", webViewModel);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        SystemUtils.hookSetRequestedOrientation(this, 1);
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
            return;
        }
        if (intent.hasExtra("web_view_model")) {
            this.mWebViewModel = (WebViewModel) intent.getSerializableExtra("web_view_model");
        } else if (intent.hasExtra("url")) {
            WebViewModel webViewModel = new WebViewModel();
            this.mWebViewModel = webViewModel;
            webViewModel.url = intent.getStringExtra("url");
            if (intent.hasExtra("title")) {
                this.mWebViewModel.title = intent.getStringExtra("title");
                this.mWebViewModel.canChangeWebViewTitle = false;
            }
        } else {
            finishWithResultCodeCanceled();
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.afanty_webview_main, (ViewGroup) null);
        this.mContentView = inflate;
        setContentView(inflate);
        init();
    }

    public View getCurTitleBar() {
        return this.mWebTitleBar;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1005 || i == 1006) {
            handleFileChooseResult(i, i2, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        cancelProgressDialog();
        if (this.mWebView != null) {
            if (this.anInterface != null) {
                WebAppInterface.setMyWebView((WebView) null);
                this.anInterface.setTitleBar((TitleBar) null);
            }
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
        }
        FeedbackBitmap.getInstance().setScreenshot_uri((Uri) null);
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    /* access modifiers changed from: private */
    public void showProgressDialog(String str) {
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.showLoadingDialog(str);
        }
    }

    /* access modifiers changed from: private */
    public void cancelProgressDialog() {
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.removeLoadingDialog();
        }
    }

    private void finishWithResultCodeCanceled() {
        setResult(0);
        finish();
    }

    private void finishWithResultCodeOK() {
        setResult(-1);
        finish();
    }

    private void init() {
        this.mWebTitleBar = (TitleBar) findViewById(R.id.afanty_web_title_bar);
        this.mWebView = (BaseWebView) findViewById(R.id.afanty_web_view);
        this.mErrorView = findViewById(R.id.afanty_web_error_view);
        this.mErrorImage = (ImageView) findViewById(R.id.afanty_web_error_image);
        this.mErrorText = (TextView) findViewById(R.id.afanty_web_error_text);
        initWebTitleBar();
        initWebView();
    }

    private void initWebTitleBar() {
        if (!TextUtils.isEmpty(this.mWebViewModel.title)) {
            this.mWebTitleBar.setTitle(this.mWebViewModel.title);
        }
        this.mWebTitleBar.setLeftBackListener(this.mOnBackClickListener);
    }

    private void initWebView() {
        if (TextUtils.isEmpty(this.mWebViewModel.url)) {
            finishWithResultCodeCanceled();
            return;
        }
        this.mWebView.setWebViewSetting(this.mWebViewModel);
        this.mWebView.setWebViewClient(new InnerWebViewClient());
        this.mWebView.setJavascriptBridge(new JavascriptBridge());
        this.mWebView.setFileChooserListener(this.mFileChooserListener);
        WebAppInterface webAppInterface = new WebAppInterface(this.mWebView);
        this.anInterface = webAppInterface;
        webAppInterface.setTitleBar(this.mWebTitleBar);
        this.mWebView.addJavascriptInterface(this.anInterface, ShakeConfig.JavascriptInterface);
        showProgressDialog("");
        this.mWebView.loadUrl(this.mWebViewModel.url);
    }

    /* access modifiers changed from: private */
    public void showErrorView(int i) {
        this.mErrorView.setVisibility(0);
        if (i == -14) {
            this.mErrorImage.setImageResource(R.drawable.afanty_icon_webview_error_notfound);
            this.mErrorText.setText(R.string.afanty_webview_error_notfound);
            this.mErrorView.setOnClickListener((View.OnClickListener) null);
        } else if (i == -2 || i == -6 || i == -5) {
            this.mErrorImage.setImageResource(R.drawable.afanty_icon_webview_error_connectfail);
            this.mErrorText.setText(R.string.afanty_webview_error_connectfail);
            this.mErrorView.setOnClickListener(this.onClickListenerReload);
        } else if (i == -8) {
            this.mErrorImage.setImageResource(R.drawable.afanty_icon_webview_error_busy);
            this.mErrorText.setText(R.string.afanty_webview_error_busy);
            this.mErrorView.setOnClickListener((View.OnClickListener) null);
        } else {
            this.mErrorImage.setImageResource(R.drawable.afanty_icon_webview_error_connectfail);
            this.mErrorText.setText(R.string.afanty_webview_error_connectfail);
            this.mErrorView.setOnClickListener(this.onClickListenerReload);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r6 = r6.getDataString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleFileChooseResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = -1
            r1 = 0
            r2 = 1005(0x3ed, float:1.408E-42)
            if (r4 != r2) goto L_0x0013
            if (r5 != r0) goto L_0x0013
            java.lang.String r6 = r6.getDataString()
            if (r6 == 0) goto L_0x0013
            android.net.Uri r6 = android.net.Uri.parse(r6)
            goto L_0x0014
        L_0x0013:
            r6 = r1
        L_0x0014:
            r2 = 1006(0x3ee, float:1.41E-42)
            if (r4 != r2) goto L_0x0022
            if (r5 != r0) goto L_0x0022
            java.io.File r4 = r3.mChosenFile
            if (r4 == 0) goto L_0x0022
            android.net.Uri r6 = android.net.Uri.fromFile(r4)
        L_0x0022:
            android.webkit.ValueCallback r4 = r3.mFileChooserCallback
            if (r4 == 0) goto L_0x0043
            if (r6 != 0) goto L_0x002c
            r4.onReceiveValue(r1)
            goto L_0x0043
        L_0x002c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 20
            if (r4 <= r5) goto L_0x003e
            android.webkit.ValueCallback r4 = r3.mFileChooserCallback
            r5 = 1
            android.net.Uri[] r5 = new android.net.Uri[r5]
            r0 = 0
            r5[r0] = r6
            r4.onReceiveValue(r5)
            goto L_0x0043
        L_0x003e:
            android.webkit.ValueCallback r4 = r3.mFileChooserCallback
            r4.onReceiveValue(r6)
        L_0x0043:
            r3.mFileChooserCallback = r1
            r3.mChosenFile = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.webview.neweb.AfantyWebActivity.handleFileChooseResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public void goBack() {
        boolean z;
        String str;
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        String url = this.mWebView.getUrl();
        int i = -1;
        while (true) {
            z = true;
            if (this.mWebView.canGoBackOrForward(i)) {
                if (TextUtils.equals(url, "about:blank") && !NetworkCollector.isAvailable(this)) {
                    finishWithResultCodeOK();
                    break;
                }
                WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                if (itemAtIndex == null) {
                    str = null;
                } else {
                    str = itemAtIndex.getUrl();
                }
                if (str != null && !TextUtils.equals(str, url) && !TextUtils.equals(str, "about:blank")) {
                    this.mWebView.goBackOrForward(i);
                    break;
                }
                i--;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            finishWithResultCodeOK();
        }
    }

    private class InnerWebViewClient extends BaseWebView.WebViewClientEx {
        private InnerWebViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AfantyWebActivity.this.mWebTitleBar.setTitle(AfantyWebActivity.this.mWebViewModel.title);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AfantyWebActivity.this.cancelProgressDialog();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AfantyWebActivity.this.cancelProgressDialog();
            if (Build.VERSION.SDK_INT < 18) {
                webView.clearView();
            } else {
                webView.loadUrl("about:blank");
            }
            AfantyWebActivity.this.showErrorView(i);
        }
    }

    /* access modifiers changed from: private */
    public void requestStoragePermission(Activity activity) {
        boolean z = false;
        boolean z2 = ActivityCompat.checkSelfPermission(this.mContentView.getContext(), Permission.WRITE_EXTERNAL_STORAGE) == 0;
        if (ActivityCompat.checkSelfPermission(this.mContentView.getContext(), Permission.READ_EXTERNAL_STORAGE) == 0) {
            z = true;
        }
        if (!z2 || !z) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    /* access modifiers changed from: private */
    public boolean hasStoragePermission() {
        if (!(ActivityCompat.checkSelfPermission(this.mContentView.getContext(), Permission.WRITE_EXTERNAL_STORAGE) == 0)) {
            return false;
        }
        return ActivityCompat.checkSelfPermission(this.mContentView.getContext(), Permission.READ_EXTERNAL_STORAGE) == 0;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            if (iArr.length != 1 || iArr[0] != 0) {
                onActivityResult(1006, -1, (Intent) null);
            } else if (hasStoragePermission()) {
                startCamera();
            } else {
                requestStoragePermission(this);
            }
        } else if (i != 1) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr.length != 2 || iArr[0] != 0 || iArr[1] != 0) {
            onActivityResult(1006, -1, (Intent) null);
        } else if (ActivityCompat.checkSelfPermission(this.mContentView.getContext(), Permission.CAMERA) != 0) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 0);
        } else {
            startCamera();
        }
    }

    /* access modifiers changed from: private */
    public void startCamera() {
        Uri uri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File photoOutputFile = DidiFileConfig.getPhotoOutputFile();
        this.mChosenFile = photoOutputFile;
        try {
            if (photoOutputFile.exists()) {
                this.mChosenFile.delete();
            }
            this.mChosenFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(this.mChosenFile);
        } else {
            uri = FileProvider.getUriForFile(this, getApplication().getPackageName() + ".fileProvider", this.mChosenFile);
            grantUriPermission(getPackageName(), uri, 1);
        }
        intent.putExtra("output", uri);
        startActivityForResult(intent, 1006);
    }
}

package com.didi.dimina.container.p106ui.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;

/* renamed from: com.didi.dimina.container.ui.webview.FileChooser */
public final class FileChooser {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final WebView f17863a;

    /* renamed from: b */
    private final FileChooserOpener f17864b;

    public FileChooser(WebView webView, FileChooserOpener fileChooserOpener) {
        this.f17863a = webView;
        this.f17864b = fileChooserOpener;
    }

    public void showFileChooser(final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        this.f17864b.openFileChooser(new WebViewEngine.WebViewEngineValueCallback<Uri[]>() {
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        }, new FileChooserParams() {
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            public int getMode() {
                return fileChooserParams.getMode();
            }

            public Intent createIntent() {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.PICK");
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
                if (fileChooserParams.getMode() == 1) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                if (acceptTypes != null) {
                    int length = acceptTypes.length;
                    String str = AsyncHttpRequest.HEADER_ACCEPT_ALL;
                    if (length > 1) {
                        intent.putExtra("android.intent.extra.MIME_TYPES", acceptTypes);
                        intent.setType(str);
                    } else if (acceptTypes.length > 0) {
                        String str2 = acceptTypes[0];
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        intent.setType(str);
                    } else {
                        intent.setType(str);
                    }
                }
                if (ActivityCompat.checkSelfPermission(FileChooser.this.f17863a.getContext(), Permission.CAMERA) == 0) {
                    String type = intent.getType();
                    intent = Intent.createChooser(intent, getTitle());
                    ArrayList arrayList = new ArrayList();
                    if (type != null) {
                        if (type.startsWith("image/")) {
                            arrayList.add(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", getOutput()));
                        }
                        if (type.startsWith("video/")) {
                            arrayList.add(new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", getOutput()));
                        }
                        if (type.startsWith("audio/")) {
                            arrayList.add(new Intent("android.provider.MediaStore.RECORD_SOUND"));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[arrayList.size()]));
                    }
                }
                return intent;
            }
        });
    }
}

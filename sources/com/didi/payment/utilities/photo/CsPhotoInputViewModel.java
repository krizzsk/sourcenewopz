package com.didi.payment.utilities.photo;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.scan.utils.ZbarSoLoader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import p065me.dm7.barcodescanner.zbar.BarcodeFormat;
import p065me.dm7.barcodescanner.zbar.Result;

public class CsPhotoInputViewModel extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MutableLiveData<String> f31647a = new MutableLiveData<>();

    public LiveData<String> getBareCodeData() {
        return this.f31647a;
    }

    public void scanPhoto(final Bitmap bitmap) {
        if (bitmap == null) {
            this.f31647a.postValue("");
        } else {
            new Thread() {
                public void run() {
                    String str;
                    try {
                        ImageScanner imageScanner = new ImageScanner();
                        imageScanner.setConfig(0, 256, 1);
                        imageScanner.setConfig(0, 257, 1);
                        imageScanner.setConfig(0, 0, 0);
                        imageScanner.setConfig(25, 0, 1);
                        imageScanner.setConfig(38, 0, 1);
                        if (WalletApolloUtil.isBoletoScanOptEnable()) {
                            imageScanner.setConfig(25, 32, 44);
                            imageScanner.setConfig(38, 32, 44);
                        } else {
                            imageScanner.setConfig(25, 32, 40);
                            imageScanner.setConfig(38, 32, 40);
                        }
                        if (WalletApolloUtil.getBoletoScanOptQRTipsFlag()) {
                            imageScanner.setConfig(64, 0, 1);
                        }
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        Image image = new Image(width, height, "RGB4");
                        int[] iArr = new int[(width * height)];
                        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                        image.setData(iArr);
                        String str2 = null;
                        if (imageScanner.scanImage(image.convert("Y800")) > 0) {
                            Result result = new Result();
                            Iterator<Symbol> it = imageScanner.getResults().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Symbol next = it.next();
                                if (Build.VERSION.SDK_INT >= 19) {
                                    str = new String(next.getDataBytes(), StandardCharsets.UTF_8);
                                } else {
                                    str = next.getData();
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    result.setContents(str);
                                    result.setBarcodeFormat(BarcodeFormat.getFormatById(next.getType()));
                                    break;
                                }
                            }
                            str2 = result.getContents();
                        }
                        CsPhotoInputViewModel.this.f31647a.postValue(str2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        ZbarSoLoader.loadSoError = true;
                        HashMap hashMap = new HashMap();
                        hashMap.put("error", th.getCause());
                        PayTracker.trackEvent("ibt_gp_scan_zbar_so_load_error_bt", hashMap);
                        CsPhotoInputViewModel.this.f31647a.postValue("");
                    }
                }
            }.start();
        }
    }
}

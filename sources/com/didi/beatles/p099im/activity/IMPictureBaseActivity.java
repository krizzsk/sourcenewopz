package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.beatles.p099im.common.IMLifecycleHandler;
import com.didi.beatles.p099im.picture.IMPictureSelector;
import com.didi.beatles.p099im.picture.config.IMPictureConfig;
import com.didi.beatles.p099im.picture.config.IMPictureSelectionConfig;
import com.didi.beatles.p099im.picture.entity.IMEventEntity;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p099im.picture.luban.CompressionPredicate;
import com.didi.beatles.p099im.picture.luban.Luban;
import com.didi.beatles.p099im.picture.luban.OnCompressListener;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.IMDialogFactory;
import com.didi.beatles.p099im.views.dialog.IMDialog;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.activity.IMPictureBaseActivity */
public class IMPictureBaseActivity extends IMBaseActivity {
    protected static final float ALPHA_BUTTON_DISABLE = 0.5f;
    protected static final float ALPHA_BUTTON_ENABLE = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f8984a = IMPictureBaseActivity.class.getSimpleName();

    /* renamed from: b */
    private IMDialog f8985b;
    protected String cameraPath;
    protected IMPictureSelectionConfig config;
    protected Context mContext;
    public IMLifecycleHandler.Controller mController;
    protected String originalPath;
    protected String outputCameraPath;
    protected List<IMLocalMedia> selectionMedias;

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        if (bundle != null) {
            this.config = (IMPictureSelectionConfig) bundle.getParcelable(IMPictureConfig.EXTRA_CONFIG);
            this.cameraPath = bundle.getString(IMPictureConfig.BUNDLE_CAMERA_PATH);
            this.originalPath = bundle.getString(IMPictureConfig.BUNDLE_ORIGINAL_PATH);
        } else {
            this.config = IMPictureSelectionConfig.getInstance();
        }
        super.onActivityCreate(bundle);
        this.mContext = this;
        if (this.config != null) {
            m6089b();
            this.mController = IMLifecycleHandler.attach(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(IMPictureConfig.BUNDLE_CAMERA_PATH, this.cameraPath);
        bundle.putString(IMPictureConfig.BUNDLE_ORIGINAL_PATH, this.originalPath);
        bundle.putParcelable(IMPictureConfig.EXTRA_CONFIG, this.config);
    }

    /* renamed from: b */
    private void m6089b() {
        this.outputCameraPath = this.config.outputCameraPath;
        List<IMLocalMedia> list = this.config.selectionMedias;
        this.selectionMedias = list;
        if (list == null) {
            this.selectionMedias = new ArrayList();
        }
    }

    /* access modifiers changed from: protected */
    public void onResult(List<IMLocalMedia> list) {
        m6091d();
        if (this.config.camera && this.config.selectionMode == 2 && this.selectionMedias != null) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        for (IMLocalMedia next : list) {
            String str = f8984a;
            IMLog.m6635i(str, "[IM-Picture] [onResult] #FixSelectResult# w=" + next.getWidth() + " |h=" + next.getHeight() + " |size=" + next.getSize() + " |comPath=" + next.getCompressPath() + " |path=" + next.getPath());
            if (TextUtils.isEmpty(next.getCompressPath())) {
                next.setCompressPath(next.getPath());
            }
            String compressPath = next.getCompressPath();
            if (next.getWidth() <= 0 || next.getHeight() <= 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(compressPath, options);
                next.setWidth(options.outWidth);
                next.setHeight(options.outHeight);
                String str2 = f8984a;
                IMLog.m6635i(str2, "[IM-Picture] [onResult] #FixSelectResult# #RESET Width*Height# w=" + next.getWidth() + " |h=" + next.getHeight());
            }
            if (next.getSize() == 0) {
                next.setSize(new File(compressPath).length());
                String str3 = f8984a;
                IMLog.m6635i(str3, "[IM-Picture] [onResult] #FixSelectResult# #RESET Size# size=" + next.getSize());
            }
        }
        setResult(-1, IMPictureSelector.putIntentResult(list));
        finish();
    }

    /* access modifiers changed from: protected */
    public void createNewFolder(List<IMLocalMediaFolder> list) {
        if (list.size() == 0) {
            IMLocalMediaFolder iMLocalMediaFolder = new IMLocalMediaFolder();
            iMLocalMediaFolder.setName(getString(R.string.im_picture_camera_roll));
            iMLocalMediaFolder.setPath("");
            iMLocalMediaFolder.setFirstImagePath("");
            list.add(iMLocalMediaFolder);
        }
    }

    /* access modifiers changed from: protected */
    public IMLocalMediaFolder getImageFolder(String str, List<IMLocalMediaFolder> list) {
        File parentFile = new File(str).getParentFile();
        for (IMLocalMediaFolder next : list) {
            if (next.getName().equals(parentFile.getName())) {
                return next;
            }
        }
        IMLocalMediaFolder iMLocalMediaFolder = new IMLocalMediaFolder();
        iMLocalMediaFolder.setName(parentFile.getName());
        iMLocalMediaFolder.setPath(parentFile.getAbsolutePath());
        iMLocalMediaFolder.setFirstImagePath(str);
        list.add(iMLocalMediaFolder);
        return iMLocalMediaFolder;
    }

    /* access modifiers changed from: protected */
    public void compressImage(final List<IMLocalMedia> list) {
        final long currentTimeMillis = System.currentTimeMillis();
        IMLog.m6631d(f8984a, "[compressImage] start...");
        m6090c();
        Luban.with(this).load(list).ignoreBy(this.config.minimumCompressSize).setTargetDir(this.config.compressSavePath).setFocusAlpha(false).maxImageSize(this.config.maxImageSize).filter(new CompressionPredicate() {
            public boolean apply(String str) {
                return !TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".gif");
            }
        }).setCompressListener(new OnCompressListener() {
            long itemCompressTS;

            public void onStart() {
                String a = IMPictureBaseActivity.f8984a;
                IMLog.m6631d(a, "[compressImage] #onStart# " + (System.currentTimeMillis() - this.itemCompressTS));
                this.itemCompressTS = System.currentTimeMillis();
            }

            public void onSuccess(List<IMLocalMedia> list) {
                String a = IMPictureBaseActivity.f8984a;
                IMLog.m6631d(a, "[compressImage] #onSuccess# " + list.size() + " |consumeTime=" + (System.currentTimeMillis() - currentTimeMillis));
                EventBus.getDefault().post(new IMEventEntity(2770));
                IMPictureBaseActivity.this.onResult(list);
            }

            public void onError(Throwable th) {
                String a = IMPictureBaseActivity.f8984a;
                IMLog.m6631d(a, "[compressImage] #onError# consumeTime=" + (System.currentTimeMillis() - currentTimeMillis));
                EventBus.getDefault().post(new IMEventEntity(2770));
                IMPictureBaseActivity.this.onResult(list);
            }
        }).launch();
    }

    /* renamed from: c */
    private void m6090c() {
        if (this.f8985b == null) {
            this.f8985b = IMDialogFactory.getLoadingDialog((Activity) this, getString(R.string.bts_im_loading), false);
        }
        this.f8985b.show(this.mController, getSupportFragmentManager(), "im_picture_compress");
    }

    /* renamed from: d */
    private void m6091d() {
        IMDialog iMDialog = this.f8985b;
        if (iMDialog != null) {
            iMDialog.dismiss();
        }
    }
}

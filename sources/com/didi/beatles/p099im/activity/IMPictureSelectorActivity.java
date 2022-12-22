package com.didi.beatles.p099im.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.picture.IMPictureSelector;
import com.didi.beatles.p099im.picture.adapter.IMAlbumAdapter;
import com.didi.beatles.p099im.picture.adapter.IMMediaGridAdapter;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.beatles.p099im.picture.entity.IMEventEntity;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p099im.picture.loader.IMLocalMediaLoader;
import com.didi.beatles.p099im.picture.observable.IMMediaObservable;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didi.beatles.p099im.picture.utils.IMStringUtils;
import com.didi.beatles.p099im.picture.widget.IMAlbumPopupWindow;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMPermissionUtil;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.IMGridSpacingItemDecoration;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMPictureSelectorActivity */
public class IMPictureSelectorActivity extends IMPictureBaseActivity implements View.OnClickListener, IMAlbumAdapter.OnAlbumSelectListener, IMMediaGridAdapter.OnMediaSelectChangedListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9006a = IMPictureSelectorActivity.class.getSimpleName();

    /* renamed from: b */
    private RelativeLayout f9007b;

    /* renamed from: c */
    private ImageView f9008c;

    /* renamed from: d */
    private TextView f9009d;

    /* renamed from: e */
    private FrameLayout f9010e;

    /* renamed from: f */
    private TextView f9011f;

    /* renamed from: g */
    private TextView f9012g;

    /* renamed from: h */
    private RecyclerView f9013h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMMediaGridAdapter f9014i;

    /* renamed from: j */
    private IMLocalMediaLoader f9015j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<IMLocalMediaFolder> f9016k = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<IMLocalMedia> f9017l = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IMAlbumPopupWindow f9018m;

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        if (this.config == null) {
            IMLog.m6632e(f9006a, "[onActivityCreate] finish activity with NULL selection config.");
            SystemUtils.showToast(IMTipsToast.makeText((Context) this, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
            finish();
            return;
        }
        String str = f9006a;
        IMLog.m6631d(str, "[onActivityCreate] camera=" + this.config.camera);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.config.camera) {
            m6117a(bundle);
        } else {
            m6122b(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /* renamed from: a */
    private void m6117a(Bundle bundle) {
        if (bundle == null) {
            final String[] strArr = {Permission.CAMERA};
            IMPermissionUtil.checkAndRequestPermission((FragmentActivity) this, (IMPermissionUtil.OnPermissionGrantCallback) new IMPermissionUtil.OnPermissionGrantCallback() {
                public void onGranted(String... strArr) {
                    boolean z = false;
                    if (strArr != null) {
                        String[] strArr2 = strArr;
                        int length = strArr2.length;
                        int i = 0;
                        while (true) {
                            boolean z2 = true;
                            if (i >= length) {
                                z = true;
                                break;
                            }
                            String str = strArr2[i];
                            int length2 = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    z2 = false;
                                    break;
                                } else if (TextUtils.equals(str, strArr[i2])) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (!z2) {
                                String b = IMPictureSelectorActivity.f9006a;
                                IMLog.m6631d(b, "[onGranted] requestPermission not granted : " + str);
                                break;
                            }
                            i++;
                        }
                    }
                    String b2 = IMPictureSelectorActivity.f9006a;
                    IMLog.m6631d(b2, "[onGranted] allGranted=" + z);
                    if (z) {
                        IMPictureSelectorActivity.this.onTakePhoto();
                    }
                }

                public void onDenied(IMPermissionUtil.PermissionDenyResult... permissionDenyResultArr) {
                    IMPictureSelectorActivity iMPictureSelectorActivity = IMPictureSelectorActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText((Context) iMPictureSelectorActivity, (CharSequence) iMPictureSelectorActivity.getString(R.string.im_picture_permission_reject_camera), 0));
                    IMPictureSelectorActivity.this.finish();
                }
            }, strArr);
        }
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_im_picture_camera);
    }

    /* renamed from: b */
    private void m6122b(Bundle bundle) {
        setContentView((int) R.layout.activity_im_picture_selector);
        this.f9015j = new IMLocalMediaLoader(this, this.config.mimeType, this.config.isGif, (long) this.config.videoMaxSecond, (long) this.config.videoMinSecond);
        if (bundle != null) {
            this.selectionMedias = IMPictureSelector.obtainSelectorList(bundle);
        }
        m6124c();
        if (Build.VERSION.SDK_INT >= 16) {
            IMPermissionUtil.checkAndRequestPermission((FragmentActivity) this, (IMPermissionUtil.OnPermissionGrantCallback) new IMPermissionUtil.OnPermissionGrantCallback() {
                public void onGranted(String... strArr) {
                    IMLog.m6631d(IMPictureSelectorActivity.f9006a, "[onGranted] ......");
                    IMPictureSelectorActivity.this.readLocalMedia();
                }

                public void onDenied(IMPermissionUtil.PermissionDenyResult... permissionDenyResultArr) {
                    IMPictureSelectorActivity iMPictureSelectorActivity = IMPictureSelectorActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText((Context) iMPictureSelectorActivity, (CharSequence) iMPictureSelectorActivity.getString(R.string.im_picture_permission_reject_storage), 0));
                }
            }, new String[]{Permission.READ_EXTERNAL_STORAGE});
        } else {
            readLocalMedia();
        }
    }

    /* renamed from: c */
    private void m6124c() {
        this.f9007b = (RelativeLayout) findViewById(R.id.title_bar_layout_above);
        this.f9008c = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f9009d = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.f9010e = (FrameLayout) findViewById(R.id.im_picture_bottom_bar_container);
        this.f9011f = (TextView) findViewById(R.id.tv_picture_preview);
        this.f9012g = (TextView) findViewById(R.id.tv_send_image);
        this.f9013h = (RecyclerView) findViewById(R.id.im_media_recycler_view);
        this.f9007b.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_nomix_titlebar_bg));
        this.f9008c.setImageResource(IMResource.getDrawableID(R.drawable.im_common_title_bar_btn_back_selector));
        this.f9009d.setTextSize(0, IMResource.getDimension(R.dimen.im_nomix_titlebar_textsize, 18));
        this.f9009d.setTextColor(IMResource.getColor(R.color.im_nomix_color_titlebar_text));
        this.f9008c.setOnClickListener(this);
        this.f9009d.setOnClickListener(this);
        this.f9011f.setText(R.string.im_picture_preview);
        this.f9011f.setOnClickListener(this);
        this.f9012g.setOnClickListener(this);
        this.f9009d.setText(getString(R.string.im_picture_camera_roll));
        updateBottomBar((List<IMLocalMedia>) null);
        IMAlbumPopupWindow iMAlbumPopupWindow = new IMAlbumPopupWindow(this, this.config.mimeType);
        this.f9018m = iMAlbumPopupWindow;
        iMAlbumPopupWindow.setPictureTitleView(this.f9009d);
        this.f9018m.setOnAlbumSelectListener(this);
        IMMediaGridAdapter iMMediaGridAdapter = new IMMediaGridAdapter(this.mContext, this.config);
        this.f9014i = iMMediaGridAdapter;
        iMMediaGridAdapter.setOnMediaSelectChangedListener(this);
        this.f9014i.bindSelectImages(this.selectionMedias);
        this.f9013h.setHasFixedSize(true);
        if (this.config.imageSpanCount == 0) {
            IMLog.m6632e(f9006a, "[initViews] reset image span count");
            this.config.imageSpanCount = 4;
        }
        this.f9013h.addItemDecoration(new IMGridSpacingItemDecoration(this.config.imageSpanCount, IMViewUtil.dp2px(this, 2.0f), false));
        this.f9013h.setLayoutManager(new GridLayoutManager(this, this.config.imageSpanCount));
        ((SimpleItemAnimator) this.f9013h.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f9013h.setAdapter(this.f9014i);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IMMediaGridAdapter iMMediaGridAdapter = this.f9014i;
        if (iMMediaGridAdapter != null) {
            IMPictureSelector.saveSelectorList(bundle, iMMediaGridAdapter.getSelectedImages());
        }
    }

    /* access modifiers changed from: protected */
    public void readLocalMedia() {
        IMLog.m6631d(f9006a, "[readLocalMedia] start...");
        this.f9015j.loadAllMedia(new IMLocalMediaLoader.LocalMediaLoadListener() {
            public void onLoadComplete(List<IMLocalMediaFolder> list) {
                if (list == null) {
                    IMLog.m6632e(IMPictureSelectorActivity.f9006a, "[readLocalMedia] Null folders");
                    return;
                }
                String b = IMPictureSelectorActivity.f9006a;
                StringBuilder sb = new StringBuilder();
                sb.append("[onLoadComplete] -> ");
                sb.append(list == null ? "NULL" : Integer.valueOf(list.size()));
                IMLog.m6631d(b, sb.toString());
                if (list.size() > 0) {
                    List unused = IMPictureSelectorActivity.this.f9016k = list;
                    IMLocalMediaFolder iMLocalMediaFolder = list.get(0);
                    iMLocalMediaFolder.setChecked(true);
                    List<IMLocalMedia> images = iMLocalMediaFolder.getImages();
                    if (images.size() >= IMPictureSelectorActivity.this.f9017l.size()) {
                        List unused2 = IMPictureSelectorActivity.this.f9017l = images;
                        IMPictureSelectorActivity.this.f9018m.bindFolder(list);
                    }
                }
                if (IMPictureSelectorActivity.this.f9014i != null) {
                    if (IMPictureSelectorActivity.this.f9017l == null) {
                        List unused3 = IMPictureSelectorActivity.this.f9017l = new ArrayList();
                    }
                    IMPictureSelectorActivity.this.f9014i.bindImagesData(IMPictureSelectorActivity.this.f9017l);
                }
            }
        });
    }

    public void startOpenCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            File createCameraFile = IMPictureFileUtils.createCameraFile(this, this.config.mimeType == 0 ? 1 : this.config.mimeType, this.outputCameraPath, this.config.suffixType);
            this.cameraPath = createCameraFile.getAbsolutePath();
            Uri a = m6114a(createCameraFile);
            String str = f9006a;
            IMLog.m6631d(str, "[startOpenCamera] imageUri->" + a);
            if (a != null) {
                try {
                    intent.putExtra("output", a);
                    startActivityForResult(intent, 909);
                } catch (Exception e) {
                    IMLog.m6632e(f9006a, "[startOpenCamera]", e);
                    SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
                    finish();
                }
            } else {
                IMLog.m6632e(f9006a, "[startOpenCamera] generate invalid image uri");
                SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
                finish();
            }
        }
    }

    /* renamed from: a */
    private Uri m6114a(File file) {
        String str = getPackageName() + ".com.didi.beatles.im.fileprovider";
        if (Build.VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        try {
            return FileProvider.getUriForFile(this.mContext, str, file);
        } catch (Exception e) {
            IMLog.m6632e(f9006a, "[parUri]", e);
            return null;
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.common_title_bar_left_img) {
            if (this.f9018m.isShowing()) {
                this.f9018m.dismiss();
            } else {
                finish();
            }
        } else if (id == R.id.common_title_bar_middle_tv) {
            if (this.f9018m.isShowing()) {
                this.f9018m.dismiss();
                return;
            }
            List<IMLocalMedia> list = this.f9017l;
            if (list != null && list.size() > 0) {
                this.f9018m.showAsDropDown(this.f9009d);
                this.f9018m.notifyDataCheckedStatus(this.f9014i.getSelectedImages());
            }
        } else if (id == R.id.tv_picture_preview) {
            List<IMLocalMedia> selectedImages = this.f9014i.getSelectedImages();
            ArrayList arrayList = new ArrayList();
            for (IMLocalMedia add : selectedImages) {
                arrayList.add(add);
            }
            IMPictureGalleryPreviewActivity.startActivity(this, arrayList, selectedImages, true);
        } else if (id == R.id.tv_send_image) {
            List<IMLocalMedia> selectedImages2 = this.f9014i.getSelectedImages();
            int size = selectedImages2.size();
            if (this.config.minSelectNum > 0 && this.config.selectionMode == 2 && size < this.config.minSelectNum) {
                SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.im_picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}), 0));
            } else if (this.config.isCompress) {
                compressImage(selectedImages2);
            } else {
                onResult(selectedImages2);
            }
        }
    }

    public void onTakePhoto() {
        startOpenCamera();
    }

    public void onMediaSelectChange(List<IMLocalMedia> list) {
        updateBottomBar(list);
    }

    public void onMediaPreviewClick(IMLocalMedia iMLocalMedia, int i) {
        startPreview(this.f9014i.getImages(), i);
    }

    public void startPreview(List<IMLocalMedia> list, int i) {
        int isPictureType = IMPictureMimeType.isPictureType(list.get(i).getPictureType());
        if (isPictureType != 1) {
            String str = f9006a;
            IMLog.m6632e(str, "[startPreview] with invalid mediaType : " + isPictureType);
            return;
        }
        List<IMLocalMedia> selectedImages = this.f9014i.getSelectedImages();
        IMMediaObservable.getInstance().saveLocalMedia(list);
        IMPictureGalleryPreviewActivity.startActivity(this, selectedImages, i);
    }

    public void updateBottomBar(List<IMLocalMedia> list) {
        if (list != null && list.size() > 0) {
            this.f9010e.setSelected(true);
            this.f9011f.setEnabled(true);
            this.f9011f.setAlpha(1.0f);
            this.f9012g.setEnabled(true);
            this.f9012g.setAlpha(1.0f);
            this.f9012g.setText(String.format(getString(R.string.im_picture_send_with_count), new Object[]{Integer.valueOf(list.size())}));
            return;
        }
        this.f9010e.setSelected(false);
        this.f9011f.setEnabled(false);
        this.f9011f.setAlpha(0.5f);
        this.f9012g.setEnabled(false);
        this.f9012g.setText(String.format(getString(R.string.im_picture_send), new Object[0]));
        this.f9012g.setAlpha(0.5f);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            if (i == 909) {
                File file = new File(this.cameraPath);
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                String absolutePath = file.getAbsolutePath();
                rotateImage(IMPictureFileUtils.readPictureDegree(absolutePath), file);
                IMLocalMedia iMLocalMedia = new IMLocalMedia();
                iMLocalMedia.setPath(this.cameraPath);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(absolutePath, options);
                iMLocalMedia.setWidth(options.outWidth);
                iMLocalMedia.setHeight(options.outHeight);
                iMLocalMedia.setSize(file.length());
                iMLocalMedia.setPictureType(IMPictureMimeType.createImageType(this.cameraPath));
                iMLocalMedia.setMimeType(this.config.mimeType);
                if (!this.config.camera) {
                    this.f9017l.add(0, iMLocalMedia);
                    IMMediaGridAdapter iMMediaGridAdapter = this.f9014i;
                    if (iMMediaGridAdapter != null) {
                        List<IMLocalMedia> selectedImages = iMMediaGridAdapter.getSelectedImages();
                        if (selectedImages.size() < this.config.maxSelectNum) {
                            if ((IMPictureMimeType.mimeToEqual(selectedImages.size() > 0 ? selectedImages.get(0).getPictureType() : "", iMLocalMedia.getPictureType()) || selectedImages.size() == 0) && selectedImages.size() < this.config.maxSelectNum) {
                                if (this.config.selectionMode == 1) {
                                    m6125d();
                                }
                                selectedImages.add(iMLocalMedia);
                                this.f9014i.bindSelectImages(selectedImages);
                            }
                        }
                        this.f9014i.notifyDataSetChanged();
                    }
                } else if (this.config.isCompress) {
                    arrayList.add(iMLocalMedia);
                    compressImage(arrayList);
                    if (this.f9014i != null) {
                        this.f9017l.add(0, iMLocalMedia);
                        this.f9014i.notifyDataSetChanged();
                    }
                } else {
                    arrayList.add(iMLocalMedia);
                    onResult(arrayList);
                }
                if (this.f9014i != null) {
                    m6118a(iMLocalMedia);
                }
            }
        } else if (i2 != 0) {
        } else {
            if (this.config == null) {
                IMLog.m6632e(f9006a, "[onActivityResult] NULL config");
                finish();
            } else if (this.config.camera) {
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void rotateImage(int i, File file) {
        if (i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                IMPictureFileUtils.saveBitmapFile(IMPictureFileUtils.rotaingImageView(i, BitmapFactory.decodeFile(file.getAbsolutePath(), options)), file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m6125d() {
        List<IMLocalMedia> selectedImages;
        IMMediaGridAdapter iMMediaGridAdapter = this.f9014i;
        if (iMMediaGridAdapter != null && (selectedImages = iMMediaGridAdapter.getSelectedImages()) != null && selectedImages.size() > 0) {
            selectedImages.clear();
        }
    }

    /* renamed from: a */
    private void m6118a(IMLocalMedia iMLocalMedia) {
        try {
            createNewFolder(this.f9016k);
            IMLocalMediaFolder imageFolder = getImageFolder(iMLocalMedia.getPath(), this.f9016k);
            IMLocalMediaFolder iMLocalMediaFolder = this.f9016k.size() > 0 ? this.f9016k.get(0) : null;
            if (iMLocalMediaFolder != null && imageFolder != null) {
                iMLocalMediaFolder.setFirstImagePath(iMLocalMedia.getPath());
                iMLocalMediaFolder.setImages(this.f9017l);
                iMLocalMediaFolder.setImageNum(iMLocalMediaFolder.getImageNum() + 1);
                imageFolder.setImageNum(imageFolder.getImageNum() + 1);
                imageFolder.getImages().add(0, iMLocalMedia);
                imageFolder.setFirstImagePath(this.cameraPath);
                this.f9018m.bindFolder(this.f9016k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPictureEvent(IMEventEntity iMEventEntity) {
        String str = f9006a;
        IMLog.m6631d(str, "[onPictureEvent] what=" + iMEventEntity.what + " |position=" + iMEventEntity.position);
        int i = iMEventEntity.what;
        if (i == 2771) {
            List<IMLocalMedia> list = iMEventEntity.medias;
            if (list.size() > 0) {
                String pictureType = list.get(0).getPictureType();
                if (!this.config.isCompress || !pictureType.startsWith("image")) {
                    onResult(list);
                } else {
                    compressImage(list);
                }
            }
        } else if (i == 2774) {
            List<IMLocalMedia> list2 = iMEventEntity.medias;
            int i2 = iMEventEntity.position;
            String str2 = f9006a;
            IMLog.m6635i(str2, "[onPictureEvent] #UPDATE_FLAG# " + i2);
            this.f9014i.bindSelectImages(list2);
            this.f9014i.notifyItemChanged(i2);
        }
    }

    public void onAlbumSelect(String str, List<IMLocalMedia> list) {
        boolean isCamera = IMStringUtils.isCamera(str);
        if (!this.config.showCameraInGallery) {
            isCamera = false;
        }
        this.f9014i.setShowCamera(isCamera);
        this.f9009d.setText(str);
        this.f9014i.bindImagesData(list);
        this.f9018m.dismiss();
    }
}

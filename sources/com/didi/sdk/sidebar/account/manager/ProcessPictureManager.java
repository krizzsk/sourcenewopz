package com.didi.sdk.sidebar.account.manager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.image.CropActivity;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.security.uuid.share.ShareDBHelper;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProcessPictureManager {
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1008;
    public static final int REQUEST_CODE_CAPTURE_PIC = 1006;
    public static final int REQUEST_CODE_CROP_PIC = 1007;
    public static final int REQUEST_CODE_PHOTO_PERMISSION = 1009;
    public static final int REQUEST_CODE_SELECT_PIC = 1005;

    /* renamed from: a */
    private static final String f37181a = ".fileprovider";

    /* renamed from: b */
    private File f37182b;

    /* renamed from: c */
    private File f37183c;

    /* renamed from: d */
    private OnFinishPictureCallBack f37184d = null;

    /* renamed from: e */
    private final FragmentActivity f37185e;

    /* renamed from: f */
    private TheOneBaseFragment f37186f;

    public interface OnFinishPictureCallBack {
        void onCropFinish(File file);
    }

    public ProcessPictureManager(FragmentActivity fragmentActivity) {
        this.f37185e = fragmentActivity;
        this.f37182b = m26356a();
    }

    public ProcessPictureManager(TheOneBaseFragment theOneBaseFragment) {
        this.f37186f = theOneBaseFragment;
        this.f37185e = theOneBaseFragment.getActivity();
        this.f37182b = m26356a();
    }

    /* renamed from: a */
    private File m26356a() {
        Context context = this.f37185e;
        if (context == null) {
            context = this.f37186f.getContext();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalFilesDir, "IMG_" + format + ".jpg");
    }

    public String getCropFile() {
        File file = this.f37183c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void setCropFile(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f37183c = new File(str);
        }
    }

    public String getAvatarOriginFile() {
        File file = this.f37182b;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void setAvatarOriginFile(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f37182b = new File(str);
        }
    }

    public void takePhotoByCamera() {
        Fragment findFragmentById;
        if (this.f37182b != null && (findFragmentById = this.f37185e.getSupportFragmentManager().findFragmentById(R.id.fragment_container)) != null) {
            if (PermissionUtil.checkPermissionAllGranted((Context) DIDIApplication.getAppContext(), new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE})) {
                isAllGranted();
            } else {
                findFragmentById.requestPermissions(new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, 1008);
            }
        }
    }

    public void isAllGranted() {
        try {
            Context context = this.f37185e == null ? this.f37186f.getContext() : this.f37185e;
            String absolutePath = this.f37182b.getAbsolutePath();
            m26357a(IntentUtil.getCameraIntent(context, absolutePath, context.getPackageName() + f37181a), 1006);
        } catch (Exception unused) {
        }
    }

    public void allGalleryAccess() {
        Intent intent = new Intent();
        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
        intent.setAction("android.intent.action.GET_CONTENT");
        try {
            m26357a(intent, 1005);
        } catch (Exception unused) {
            ToastHelper.showShortInfo(this.f37185e.getApplicationContext(), "无法打开图片库");
        }
    }

    public void selectPhotoFromGallery() {
        Fragment findFragmentById;
        if (this.f37182b != null && (findFragmentById = this.f37185e.getSupportFragmentManager().findFragmentById(R.id.fragment_container)) != null) {
            if (PermissionUtil.checkPermissionAllGranted((Context) this.f37185e, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE})) {
                allGalleryAccess();
            } else {
                findFragmentById.requestPermissions(new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, 1009);
            }
        }
    }

    /* renamed from: a */
    private void m26357a(Intent intent, int i) {
        FragmentActivity fragmentActivity = this.f37185e;
        if (fragmentActivity == null) {
            this.f37186f.startActivityForResult(intent, i);
            return;
        }
        Fragment findFragmentById = fragmentActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById != null) {
            try {
                findFragmentById.startActivityForResult(intent, i);
            } catch (Exception unused) {
            }
        } else {
            this.f37185e.startActivityForResult(intent, i);
        }
    }

    public void processPhotoFromGallery(Intent intent) {
        FragmentActivity fragmentActivity = this.f37185e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f37186f.getActivity();
        }
        if (intent == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        File file = this.f37182b;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (TextUtil.isEmpty(absolutePath)) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        String path = FileUtil.getPath(fragmentActivity, data);
        if (TextUtil.isEmpty(path)) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (!new File(path).exists()) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            FileUtil.copyFile(path, absolutePath);
            m26358a(Uri.fromFile(this.f37182b));
        }
    }

    public void processPhotoFromCamera() {
        FragmentActivity fragmentActivity = this.f37185e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f37186f.getActivity();
        }
        File file = this.f37182b;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (TextUtil.isEmpty(file.getAbsolutePath())) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            File file2 = this.f37182b;
            if (file2 != null) {
                m26358a(Uri.fromFile(file2));
            }
        }
    }

    public void processCropPhoto() {
        FragmentActivity fragmentActivity = this.f37185e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f37186f.getActivity();
        }
        File file = this.f37183c;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (TextUtil.isEmpty(file.getAbsolutePath())) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            OnFinishPictureCallBack onFinishPictureCallBack = this.f37184d;
            if (onFinishPictureCallBack != null) {
                onFinishPictureCallBack.onCropFinish(this.f37183c);
            }
        }
    }

    /* renamed from: a */
    private void m26358a(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(this.f37185e.getContentResolver().openInputStream(uri), (Rect) null, options);
            if (options.outHeight >= 300 && options.outWidth >= 300) {
                this.f37183c = m26356a();
                Intent intent = new Intent(this.f37185e, CropActivity.class);
                intent.setData(uri);
                intent.putExtra("width", 300);
                intent.putExtra("height", 300);
                intent.putExtra("output", this.f37183c.getAbsolutePath());
                m26357a(intent, 1007);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{ShareDBHelper.ID_NAME}, "_data=? ", new String[]{absolutePath}, (String) null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex(ShareDBHelper.ID_NAME));
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i);
        } else if (!file.exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public void deleteFile() {
        File file = this.f37182b;
        if (file != null) {
            FileUtil.deleteFile(file);
        }
        File file2 = this.f37183c;
        if (file2 != null) {
            FileUtil.deleteFile(file2);
        }
    }

    public void setOnFinishPictureCallBack(OnFinishPictureCallBack onFinishPictureCallBack) {
        this.f37184d = onFinishPictureCallBack;
    }
}

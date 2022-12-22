package com.didi.beatles.p099im.picture.loader;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.security.uuid.share.ShareDBHelper;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.picture.loader.IMLocalMediaLoader */
public class IMLocalMediaLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Uri f9403a = MediaStore.Files.getContentUri("external");

    /* renamed from: b */
    private static final String f9404b = "_id DESC";

    /* renamed from: c */
    private static final String f9405c = "duration";

    /* renamed from: d */
    private static final String f9406d = "!='image/gif'";

    /* renamed from: e */
    private static final int f9407e = 500;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final String[] f9408k = {ShareDBHelper.ID_NAME, "_data", "mime_type", "width", "height", "_size", "duration", "media_type"};

    /* renamed from: l */
    private static final String f9409l = "media_type=? AND _size>0";

    /* renamed from: m */
    private static final String f9410m = "media_type=? AND _size>0 AND mime_type!='image/gif'";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static final String[] f9411n = {String.valueOf(1), String.valueOf(3)};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f9412f = 1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FragmentActivity f9413g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f9414h;

    /* renamed from: i */
    private long f9415i = 0;

    /* renamed from: j */
    private long f9416j = 0;

    /* renamed from: com.didi.beatles.im.picture.loader.IMLocalMediaLoader$LocalMediaLoadListener */
    public interface LocalMediaLoadListener {
        void onLoadComplete(List<IMLocalMediaFolder> list);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m6392b(String str) {
        return "media_type=? AND _size>0 AND " + str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m6393b(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("(media_type=?");
        sb.append(z ? "" : " AND mime_type!='image/gif'");
        sb.append(" OR ");
        sb.append("media_type=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append("_size");
        sb.append(">0");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String[] m6395b(int i) {
        return new String[]{String.valueOf(i)};
    }

    public IMLocalMediaLoader(FragmentActivity fragmentActivity, int i, boolean z, long j, long j2) {
        this.f9413g = fragmentActivity;
        this.f9412f = i;
        this.f9414h = z;
        this.f9415i = j;
        this.f9416j = j2;
    }

    public void loadAllMedia(final LocalMediaLoadListener localMediaLoadListener) {
        this.f9413g.getSupportLoaderManager().initLoader(this.f9412f, (Bundle) null, new LoaderManager.LoaderCallbacks<Cursor>() {
            public void onLoaderReset(Loader<Cursor> loader) {
            }

            public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
                int i2 = i;
                if (i2 == 0) {
                    return new CursorLoader(IMLocalMediaLoader.this.f9413g, IMLocalMediaLoader.f9403a, IMLocalMediaLoader.f9408k, IMLocalMediaLoader.m6393b(IMLocalMediaLoader.this.m6383a(0, 0), IMLocalMediaLoader.this.f9414h), IMLocalMediaLoader.f9411n, IMLocalMediaLoader.f9404b);
                } else if (i2 == 1) {
                    return new CursorLoader(IMLocalMediaLoader.this.f9413g, IMLocalMediaLoader.f9403a, IMLocalMediaLoader.f9408k, IMLocalMediaLoader.this.f9414h ? IMLocalMediaLoader.f9409l : IMLocalMediaLoader.f9410m, IMLocalMediaLoader.m6395b(1), IMLocalMediaLoader.f9404b);
                } else if (i2 == 2) {
                    return new CursorLoader(IMLocalMediaLoader.this.f9413g, IMLocalMediaLoader.f9403a, IMLocalMediaLoader.f9408k, IMLocalMediaLoader.m6392b(IMLocalMediaLoader.this.m6383a(0, 0)), IMLocalMediaLoader.m6395b(3), IMLocalMediaLoader.f9404b);
                } else if (i2 != 3) {
                    return null;
                } else {
                    return new CursorLoader(IMLocalMediaLoader.this.f9413g, IMLocalMediaLoader.f9403a, IMLocalMediaLoader.f9408k, IMLocalMediaLoader.m6392b(IMLocalMediaLoader.this.m6383a(0, 500)), IMLocalMediaLoader.m6395b(2), IMLocalMediaLoader.f9404b);
                }
            }

            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                String str;
                Uri uri;
                Cursor cursor2 = cursor;
                int i = 2;
                try {
                    ArrayList arrayList = new ArrayList();
                    IMLocalMediaFolder iMLocalMediaFolder = new IMLocalMediaFolder();
                    ArrayList arrayList2 = new ArrayList();
                    if (cursor2 == null) {
                        return;
                    }
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        while (true) {
                            String string = cursor2.getString(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[i]));
                            int i2 = cursor2.getInt(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[3]));
                            int i3 = cursor2.getInt(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[4]));
                            int i4 = cursor2.getInt(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[5]));
                            int i5 = cursor2.getInt(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[6]));
                            if (Build.VERSION.SDK_INT > 28) {
                                int i6 = cursor2.getInt(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[7]));
                                long j = cursor2.getLong(cursor2.getColumnIndexOrThrow(ShareDBHelper.ID_NAME));
                                str = null;
                                if (i6 == 1) {
                                    uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j);
                                } else if (i6 == 3) {
                                    uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j);
                                } else {
                                    uri = i6 == i ? ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, j) : null;
                                }
                                if (uri != null) {
                                    str = uri.toString();
                                }
                            } else {
                                str = cursor2.getString(cursor2.getColumnIndexOrThrow(IMLocalMediaLoader.f9408k[1]));
                            }
                            long j2 = (long) i5;
                            IMLocalMedia iMLocalMedia = r9;
                            String str2 = str;
                            try {
                                IMLocalMedia iMLocalMedia2 = new IMLocalMedia(str, j2, IMLocalMediaLoader.this.f9412f, string, i2, i3, i4);
                                IMLocalMediaFolder a = IMLocalMediaLoader.this.m6382a(str2, (List<IMLocalMediaFolder>) arrayList);
                                a.getImages().add(iMLocalMedia);
                                a.setImageNum(a.getImageNum() + 1);
                                arrayList2.add(iMLocalMedia);
                                iMLocalMediaFolder.setImageNum(iMLocalMediaFolder.getImageNum() + 1);
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                i = 2;
                            } catch (Exception e) {
                                e = e;
                                i = 2;
                                Object[] objArr = new Object[i];
                                objArr[0] = "[loadAllMedia]";
                                objArr[1] = e;
                                IMLog.m6632e("IMLocalMediaLoader", objArr);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            IMLocalMediaLoader.this.m6388a((List<IMLocalMediaFolder>) arrayList);
                            arrayList.add(0, iMLocalMediaFolder);
                            iMLocalMediaFolder.setFirstImagePath(((IMLocalMedia) arrayList2.get(0)).getPath());
                            iMLocalMediaFolder.setName(IMLocalMediaLoader.this.f9413g.getString(R.string.im_picture_camera_roll));
                            iMLocalMediaFolder.setImages(arrayList2);
                        }
                        localMediaLoadListener.onLoadComplete(arrayList);
                        return;
                    }
                    localMediaLoadListener.onLoadComplete(arrayList);
                } catch (Exception e2) {
                    e = e2;
                    Object[] objArr2 = new Object[i];
                    objArr2[0] = "[loadAllMedia]";
                    objArr2[1] = e;
                    IMLog.m6632e("IMLocalMediaLoader", objArr2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6388a(List<IMLocalMediaFolder> list) {
        Collections.sort(list, new Comparator<IMLocalMediaFolder>() {
            public int compare(IMLocalMediaFolder iMLocalMediaFolder, IMLocalMediaFolder iMLocalMediaFolder2) {
                int imageNum;
                int imageNum2;
                if (iMLocalMediaFolder.getImages() == null || iMLocalMediaFolder2.getImages() == null || (imageNum = iMLocalMediaFolder.getImageNum()) == (imageNum2 = iMLocalMediaFolder2.getImageNum())) {
                    return 0;
                }
                return imageNum < imageNum2 ? 1 : -1;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public IMLocalMediaFolder m6382a(String str, List<IMLocalMediaFolder> list) {
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m6383a(long j, long j2) {
        long j3 = this.f9415i;
        if (j3 == 0) {
            j3 = Long.MAX_VALUE;
        }
        if (j != 0) {
            j3 = Math.min(j3, j);
        }
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Math.max(j2, this.f9416j));
        objArr[1] = Math.max(j2, this.f9416j) == 0 ? "" : "=";
        objArr[2] = Long.valueOf(j3);
        return String.format(locale, "%d <%s duration and duration <= %d", objArr);
    }
}

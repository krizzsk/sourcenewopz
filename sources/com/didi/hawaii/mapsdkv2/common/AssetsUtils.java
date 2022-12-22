package com.didi.hawaii.mapsdkv2.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import com.didi.hawaii.utils.C9266IO;
import com.didi.map.constant.FileNameConstant;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetsUtils {
    private AssetsUtils() {
    }

    public static void checkFile(Context context, String str, String str2, String str3) {
        if (!new File(str, str2).exists()) {
            copyFile(context, str, str2, str3);
        }
    }

    public static boolean renameFile(String str, String str2, String str3) {
        File file = new File(str, str3);
        File file2 = new File(str, str2);
        if (file.exists()) {
            file.delete();
        }
        return file2.renameTo(file);
    }

    public static void copyFile(String str, String str2, byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                File file = new File(str, str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    C9266IO.safeClose(fileOutputStream2);
                    C9266IO.safeClose(byteArrayInputStream);
                } catch (Throwable th) {
                    th = th;
                    C9266IO.safeClose(fileOutputStream2);
                    C9266IO.safeClose(byteArrayInputStream);
                    throw th;
                }
            }
            try {
                C9266IO.pipe(byteArrayInputStream, fileOutputStream);
                C9266IO.safeClose(fileOutputStream);
            } catch (IOException e2) {
                fileOutputStream2 = fileOutputStream;
                e = e2;
                e.printStackTrace();
                C9266IO.safeClose(fileOutputStream2);
                C9266IO.safeClose(byteArrayInputStream);
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                C9266IO.safeClose(fileOutputStream2);
                C9266IO.safeClose(byteArrayInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayInputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(fileOutputStream2);
            C9266IO.safeClose(byteArrayInputStream);
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            C9266IO.safeClose(fileOutputStream2);
            C9266IO.safeClose(byteArrayInputStream);
            throw th;
        }
        C9266IO.safeClose(byteArrayInputStream);
    }

    public static void copyFile(Context context, String str, String str2, String str3) {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = readMapAssets(context, str3);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str, str2));
                try {
                    C9266IO.pipe(inputStream, fileOutputStream2);
                    C9266IO.safeClose(fileOutputStream2);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        C9266IO.safeClose(fileOutputStream);
                        C9266IO.safeClose(inputStream);
                    } catch (Throwable th) {
                        th = th;
                        C9266IO.safeClose(fileOutputStream);
                        C9266IO.safeClose(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C9266IO.safeClose(fileOutputStream);
                    C9266IO.safeClose(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                C9266IO.safeClose(fileOutputStream);
                C9266IO.safeClose(inputStream);
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(fileOutputStream);
            C9266IO.safeClose(inputStream);
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C9266IO.safeClose(fileOutputStream);
            C9266IO.safeClose(inputStream);
            throw th;
        }
        C9266IO.safeClose(inputStream);
    }

    public static void checkCustomizedFile(Context context, String str, String str2, String str3) {
        if (!new File(str, str2).exists()) {
            copyCustomizedFileFirst(context, str, str2, str3);
        }
    }

    public static void replaceCustomizedFile(Context context, String str, String str2, String str3) {
        File file = new File(str, str2);
        if (file.exists()) {
            file.delete();
        }
        copyCustomizedFileFirst(context, str, str2, str3);
    }

    public static void copyCustomizedFileFirst(Context context, String str, String str2, String str3) {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = readCustomizedAssetsImg(context, str3);
            if (inputStream == null) {
                try {
                    inputStream = readMapAssets(context, str3);
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        C9266IO.safeClose(fileOutputStream);
                        C9266IO.safeClose(inputStream);
                    } catch (Throwable th) {
                        th = th;
                        C9266IO.safeClose(fileOutputStream);
                        C9266IO.safeClose(inputStream);
                        throw th;
                    }
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str, str2));
            try {
                C9266IO.pipe(inputStream, fileOutputStream2);
                C9266IO.safeClose(fileOutputStream2);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                C9266IO.safeClose(fileOutputStream);
                C9266IO.safeClose(inputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                C9266IO.safeClose(fileOutputStream);
                C9266IO.safeClose(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(fileOutputStream);
            C9266IO.safeClose(inputStream);
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C9266IO.safeClose(fileOutputStream);
            C9266IO.safeClose(inputStream);
            throw th;
        }
        C9266IO.safeClose(inputStream);
    }

    public static final InputStream readMapAssets(Context context, String str) {
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return null;
        }
        try {
            return assets.open(FileNameConstant.ASSET_MAP_FOLDER + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final InputStream readCustomizedAssetsImg(Context context, String str) {
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return null;
        }
        try {
            return assets.open("map/customized/" + str);
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static final InputStream readAssetsImg2(Context context, String str) {
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return null;
        }
        try {
            return assets.open(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Drawable loadImageFromAsserts(Context context, String str) {
        try {
            return Drawable.createFromStream(context.getResources().getAssets().open(str), (String) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.didi.beatles.p099im.service.dao;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.p100db.dao.DaoMaster;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.service.dao.IMDaoInitTrace;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.utils.IMEncryptionUtil;
import com.didi.security.wireless.DAQException;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoCipherInit */
public class IMDaoCipherInit implements IMDaoInit {

    /* renamed from: a */
    private static final int f9600a = 1;

    /* renamed from: b */
    private static final int f9601b = 2;

    /* renamed from: c */
    private static final int f9602c = -1;

    /* renamed from: d */
    private static final int f9603d = 0;

    /* renamed from: e */
    private static final int f9604e = 3;

    /* renamed from: f */
    private Context f9605f;

    /* renamed from: g */
    private IMDaoInitTrace.Builder f9606g;

    /* renamed from: h */
    private DaoMaster.DevOpenHelper f9607h;

    /* renamed from: i */
    private Database f9608i;

    /* renamed from: j */
    private Map<String, String> f9609j = new HashMap(2);

    /* renamed from: k */
    private Map<String, String> f9610k = new HashMap(2);

    public IMDaoCipherInit(Context context, IMDaoInitTrace.Builder builder) {
        this.f9605f = context;
        this.f9606g = builder;
        IMPreference.getInstance(context).increaseCrashCount();
    }

    public void end() {
        IMPreference.getInstance(this.f9605f).decreaseCrashCount();
    }

    public void init(long j) throws Exception {
        if (IMContextInfoHelper.isNewInnerFlow()) {
            this.f9606g.addApollo(IMDaoInitTrace.APOLLO_NO_ENC);
        }
        try {
            m6491a(j);
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH).setResult(true, (Exception) null).report();
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setResult(true, (Exception) null).report();
            m6505j(j);
        } catch (Exception e) {
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH).setResult(false, e).report();
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setResult(false, e).report();
            throw e;
        }
    }

    /* renamed from: a */
    private void m6491a(long j) {
        File i = m6504i(j);
        if (i.exists()) {
            this.f9606g.addAction("no_enc_open");
            try {
                this.f9608i = m6493b(j);
                this.f9606g.addDao("new_in");
            } catch (SQLiteException e) {
                Throwable cause = e.getCause();
                if (cause != null && cause.getMessage() != null && cause.getMessage().contains("database disk image is malformed")) {
                    IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setError(e);
                    this.f9606g.addDegree("no_enc_rebuild");
                    i.delete();
                    this.f9608i = m6493b(j);
                    this.f9606g.addDao("new_in");
                }
            }
        } else {
            File b = m6494b(-1, j);
            if (!b.exists()) {
                int i2 = 3;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    File b2 = m6494b(i2, j);
                    if (b2.exists()) {
                        b = b2;
                        break;
                    }
                    i2--;
                }
            }
            if (b.exists()) {
                this.f9606g.addAction("no_enc_new");
                this.f9608i = m6493b(j);
                b.delete();
                this.f9606g.addDao("new_in");
            } else if (m6502g(j).exists()) {
                this.f9606g.addAction("no_enc_inner");
                try {
                    this.f9608i = m6497c(j);
                    this.f9606g.addDao("new_in");
                } catch (Exception e2) {
                    IMTraceError.trackError("im_no_cipher_inner", e2);
                    this.f9606g.addDegree("no_enc_inner");
                    this.f9608i = m6500e(j);
                    this.f9606g.addDao("inner");
                }
            } else {
                File h = m6503h(j);
                if (h == null || !h.exists()) {
                    this.f9606g.addAction("no_enc_create");
                    this.f9608i = m6493b(j);
                    this.f9606g.addDao("new_in");
                    return;
                }
                this.f9606g.addAction("no_enc_outer");
                try {
                    this.f9608i = m6499d(j);
                    this.f9606g.addDao("new_in");
                } catch (Exception e3) {
                    IMTraceError.trackError("im_no_cipher_outer", e3);
                    this.f9606g.addDegree("no_enc_outer");
                    this.f9608i = m6493b(j);
                    this.f9606g.addDao("outer");
                }
            }
        }
    }

    public Database getInitDatabase() {
        return this.f9608i;
    }

    public DaoMaster.DevOpenHelper getOpenHelper() {
        return this.f9607h;
    }

    /* renamed from: b */
    private Database m6493b(long j) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f9605f, m6504i(j).getAbsolutePath());
        this.f9607h = devOpenHelper;
        return devOpenHelper.getWritableDb();
    }

    /* renamed from: c */
    private Database m6497c(long j) {
        m6492a(m6502g(j), m6504i(j));
        return m6493b(j);
    }

    /* renamed from: d */
    private Database m6499d(long j) {
        File h = m6503h(j);
        if (h != null) {
            m6496b(h, m6504i(j));
            return m6493b(j);
        }
        throw new IllegalArgumentException("open old outer in empty file");
    }

    /* renamed from: e */
    private Database m6500e(long j) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f9605f, m6502g(j).getAbsolutePath());
        this.f9607h = devOpenHelper;
        return devOpenHelper.getWritableDb();
    }

    /* renamed from: f */
    private Database m6501f(long j) throws IllegalArgumentException {
        File h = m6503h(j);
        if (h != null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f9605f, h.getAbsolutePath());
            this.f9607h = devOpenHelper;
            return devOpenHelper.getWritableDb();
        }
        throw new IllegalArgumentException("open old outer in empty file");
    }

    /* renamed from: a */
    private static void m6492a(File file, File file2) {
        if (!file.renameTo(file2)) {
            throw new IllegalStateException("move file inner fail");
        }
    }

    /* renamed from: b */
    private static void m6496b(File file, File file2) {
        File file3 = new File(file2.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);
        if (!file3.exists() || file3.delete()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.flush();
                fileInputStream.close();
                fileOutputStream.close();
                if (!file3.renameTo(file2)) {
                    throw new IllegalStateException("moveFileOuter temp rename fail");
                } else if (file.exists() && !file.delete()) {
                    IMTraceError.trackError("im_dao_cipher_new_move", new IllegalStateException("moveFileOuter old file delete fail"));
                }
            } catch (IOException e) {
                throw new IllegalStateException("moveFileOuter io fail", e);
            }
        } else {
            throw new IllegalStateException("moveFileOuter temp delete fail");
        }
    }

    /* renamed from: a */
    private String m6490a(int i, long j) throws PasswordException {
        String str;
        if (this.f9609j.containsKey(m6498c(i, j))) {
            return this.f9609j.get(m6498c(i, j));
        }
        if (i == -1 || i == 0) {
            str = IMEncryptionUtil.toMD5(String.valueOf(j));
        } else if (i == 1) {
            str = SecurityWrapper.secKey(String.valueOf(j));
        } else if (i == 2) {
            try {
                str = SecurityWrapper.secKey2(String.valueOf(j));
            } catch (DAQException e) {
                throw new PasswordException("cipher dao key error by security version " + i + " by error code " + e.getErrorCode(), e);
            }
        } else if (i == 3) {
            try {
                str = SecurityWrapper.secKey3(String.valueOf(j));
            } catch (DAQException e2) {
                throw new PasswordException("cipher dao key error by security version " + i + " by error code " + e2.getErrorCode(), e2);
            }
        } else {
            throw new PasswordException("cipher dao key get by wrong version " + i);
        }
        if (str != null) {
            this.f9606g.addKey(i, str);
            this.f9609j.put(m6498c(i, j), str);
            return str;
        }
        throw new PasswordException("cipher dao key empty by security version " + i);
    }

    /* renamed from: com.didi.beatles.im.service.dao.IMDaoCipherInit$PasswordException */
    private class PasswordException extends Exception {
        PasswordException(String str) {
            super(str);
        }

        PasswordException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: g */
    private File m6502g(long j) {
        return new File(m6495b(), "im_database_" + j + ".db");
    }

    /* renamed from: h */
    private File m6503h(long j) {
        String a = m6489a();
        if (a == null) {
            return null;
        }
        return new File(a, "im_database_" + j + ".db");
    }

    /* renamed from: b */
    private File m6494b(int i, long j) {
        String str = this.f9610k.get(m6498c(i, j));
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(IMEncryptionUtil.toMD5(i + "_" + j));
            sb.append(".im");
            str = sb.toString();
            this.f9610k.put(m6498c(i, j), str);
        }
        return new File(m6495b(), str);
    }

    /* renamed from: i */
    private File m6504i(long j) {
        String str = this.f9610k.get(String.valueOf(j));
        if (TextUtils.isEmpty(str)) {
            str = IMEncryptionUtil.toMD5(String.valueOf(j)) + ".im2";
        }
        return new File(m6495b(), str);
    }

    /* renamed from: a */
    private String m6489a() {
        File externalFilesDir = this.f9605f.getExternalFilesDir("im");
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* renamed from: b */
    private String m6495b() {
        File file = new File(this.f9605f.getFilesDir().getAbsolutePath(), "im");
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        IMTraceError.TraceFlow trackErrorFlow = IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH);
        trackErrorFlow.setError(new IllegalStateException("get inner path fail " + file.getAbsolutePath()));
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    private String m6498c(int i, long j) {
        return i + "_" + j;
    }

    /* renamed from: j */
    private void m6505j(long j) {
        LinkedList<File> linkedList = new LinkedList<>();
        linkedList.add(m6502g(j));
        linkedList.add(m6503h(j));
        linkedList.add(m6504i(j));
        linkedList.add(m6494b(-1, j));
        for (int i = 0; i < 3; i++) {
            linkedList.add(m6494b(i, j));
        }
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        for (File file : linkedList) {
            if (file != null && file.exists()) {
                linkedList2.add(file);
                sb.append(file.getName());
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("num", Integer.valueOf(linkedList2.size()));
        hashMap.put("name", sb.toString());
        OmegaSDKAdapter.trackEvent("im_db_num", (Map<String, Object>) hashMap);
    }
}

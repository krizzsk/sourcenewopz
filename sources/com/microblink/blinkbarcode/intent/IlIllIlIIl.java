package com.microblink.blinkbarcode.intent;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.util.lIlIIIIlIl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: line */
class IlIllIlIIl {
    private static volatile IlIllIlIIl IllIIIllII;
    /* access modifiers changed from: private */
    public Map<String, llIIIlllll> IlIllIlIIl = new HashMap();
    private lIlIIIIlIl llIIlIlIIl = null;

    /* renamed from: com.microblink.blinkbarcode.intent.IlIllIlIIl$IlIllIlIIl  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22032IlIllIlIIl implements Runnable {
        public final /* synthetic */ boolean IlIllIlIIl;
        public final /* synthetic */ String IllIIIllII;
        public final /* synthetic */ Context llIIlIlIIl;

        public C22032IlIllIlIIl(Context context, boolean z, String str) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = z;
            this.IllIIIllII = str;
        }

        public void run() {
            File file = new File(this.llIIlIlIIl.getFilesDir(), "microblink_intent_data");
            if (this.IlIllIlIIl) {
                for (File file2 : file.listFiles()) {
                    if (!IlIllIlIIl.this.IlIllIlIIl.containsKey(file2.getName())) {
                        file2.delete();
                    }
                }
                return;
            }
            File file3 = new File(file, this.IllIIIllII);
            if (file3.exists()) {
                file3.delete();
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public final /* synthetic */ String IlIllIlIIl;
        public final /* synthetic */ Context llIIlIlIIl;

        public IllIIIllII(Context context, String str) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = str;
        }

        public void run() {
            File filesDir = this.llIIlIlIIl.getFilesDir();
            IlIllIlIIl ilIllIlIIl = IlIllIlIIl.this;
            String str = this.IlIllIlIIl;
            ilIllIlIIl.getClass();
            new File(filesDir, "microblink_intent_data/" + str).delete();
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ String IlIllIlIIl;
        public final /* synthetic */ llIIIlllll IllIIIllII;
        public final /* synthetic */ Context llIIlIlIIl;

        public llIIlIlIIl(IlIllIlIIl ilIllIlIIl, Context context, String str, llIIIlllll lliiilllll) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = str;
            this.IllIIIllII = lliiilllll;
        }

        public void run() {
            File file = new File(this.llIIlIlIIl.getFilesDir(), "microblink_intent_data");
            file.mkdirs();
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, this.IlIllIlIIl)));
                Parcel obtain = Parcel.obtain();
                this.IllIIIllII.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                bufferedOutputStream.write(marshall);
                bufferedOutputStream.close();
            } catch (IOException unused) {
                Log.m40235w(this, "Error while storing intent transferable data.", new Object[0]);
            }
        }
    }

    private IlIllIlIIl() {
        lIlIIIIlIl liliiiilil = new lIlIIIIlIl("IntentDataIO");
        this.llIIlIlIIl = liliiiilil;
        liliiiilil.start();
    }

    public static IlIllIlIIl llIIlIlIIl() {
        if (IllIIIllII == null) {
            synchronized (IlIllIlIIl.class) {
                if (IllIIIllII == null) {
                    IllIIIllII = new IlIllIlIIl();
                }
            }
        }
        return IllIIIllII;
    }

    public void llIIlIlIIl(Context context, String str, llIIIlllll lliiilllll, boolean z) {
        this.IlIllIlIIl.put(str, lliiilllll);
        if (z) {
            this.llIIlIlIIl.llIIlIlIIl((Runnable) new llIIlIlIIl(this, context, str, lliiilllll));
        }
    }

    public <T extends llIIIlllll> T llIIlIlIIl(Context context, String str, Parcelable.Creator<T> creator, boolean z) {
        try {
            T t = (llIIIlllll) this.IlIllIlIIl.get(str);
            boolean z2 = !this.IlIllIlIIl.isEmpty();
            this.IlIllIlIIl.remove(str);
            if (z) {
                if (t == null) {
                    File file = new File(context.getFilesDir(), "microblink_intent_data/" + str);
                    byte[] bArr = null;
                    if (file.exists()) {
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = bufferedInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            bufferedInputStream.close();
                            byteArrayOutputStream.close();
                            bArr = byteArray;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bArr != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        obtain.recycle();
                        t = (llIIIlllll) creator.createFromParcel(obtain);
                    }
                }
                this.llIIlIlIIl.llIIlIlIIl((Runnable) new C22032IlIllIlIIl(context, z2, str));
            }
            return t;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Previously stored transferable data is of unexpected type!");
        }
    }

    public void llIIlIlIIl(Context context, String str, boolean z) {
        this.IlIllIlIIl.remove(str);
        if (z) {
            this.llIIlIlIIl.llIIlIlIIl((Runnable) new IllIIIllII(context, str));
        }
    }
}

package com.microblink.blinkbarcode.recognition;

import android.content.Context;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager;
import com.microblink.blinkbarcode.recognition.callback.RecognitionProcessCallback;
import com.microblink.blinkbarcode.secured.IIIIIllIll;
import com.microblink.blinkbarcode.secured.llIIlllIll;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;
import com.microblink.blinkbarcode.util.FileLog;
import com.microblink.blinkbarcode.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: line */
public enum NativeRecognizerWrapper {
    INSTANCE;
    
    /* access modifiers changed from: private */
    public AtomicBoolean IIlIIIllIl;
    /* access modifiers changed from: private */
    public volatile boolean IlIllIlIIl;
    /* access modifiers changed from: private */
    public int IlIllIlllI;
    private com.microblink.blinkbarcode.util.lIlIIIIlIl IllIIIIllI;
    /* access modifiers changed from: private */
    public Timer IllIIIllII;
    /* access modifiers changed from: private */
    public IlIllIlllI lIIIIIllll;
    private llIIlIlIIl lIlIIIIlIl;
    /* access modifiers changed from: private */
    public volatile NativeLibraryInfo llIIIlllll;
    /* access modifiers changed from: private */
    public RecognizerBundle llIIlIIlll;
    /* access modifiers changed from: private */
    public AtomicReference<IllIIIllII> llIIlIlIIl;
    /* access modifiers changed from: private */
    public lIIIIIlIlI lllIIIlIlI;
    /* access modifiers changed from: private */
    public long lllIlIlIIl;

    /* compiled from: line */
    public class IIlIIIllIl implements Runnable {
        public final /* synthetic */ CountDownLatch llIIlIlIIl;

        public IIlIIIllIl(CountDownLatch countDownLatch) {
            this.llIIlIlIIl = countDownLatch;
        }

        public void run() {
            NativeRecognizerWrapper.this.IllIIIIllI();
            this.llIIlIlIIl.countDown();
        }
    }

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        public final /* synthetic */ RecognizerBundle llIIlIlIIl;

        public IlIllIlIIl(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
            this.llIIlIlIIl = recognizerBundle;
            this.IlIllIlIIl = llliiilili;
        }

        public void run() {
            NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.llIIlIlIIl, this.IlIllIlIIl);
        }
    }

    /* compiled from: line */
    public class IlIllIlllI implements IllIIlIIII {
        private llIIlllIll llIIlIlIIl;

        private IlIllIlllI() {
        }

        public void llIIlIlIIl(llIIlllIll lliilllill) {
            this.llIIlIlIIl = lliilllill;
        }

        public /* synthetic */ IlIllIlllI(NativeRecognizerWrapper nativeRecognizerWrapper, llIIlIlIIl lliililiil) {
            this();
        }

        public int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback) {
            Log.m40233v(this, "Recognizing frame ID " + this.llIIlIlIIl.lIlIIIIlIl(), new Object[0]);
            int llIIlIlIIl2 = NativeRecognizerWrapper.recognize(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl.IlIllIlIIl(), recognitionProcessCallback.getNativeContext());
            Log.m40233v(this, "Finished recognizing frame ID " + this.llIIlIlIIl.lIlIIIIlIl(), new Object[0]);
            this.llIIlIlIIl.IllIIIllII();
            return llIIlIlIIl2;
        }
    }

    /* compiled from: line */
    public class IllIIIIllI implements Runnable {
        public IllIIIIllI() {
        }

        public void run() {
            if (NativeRecognizerWrapper.this.llIIlIlIIl.get() == IllIIIllII.DONE) {
                NativeRecognizerWrapper.this.lIlIIIIlIl();
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public final /* synthetic */ RecognizerBundle IlIllIlIIl;
        public final /* synthetic */ RecognitionProcessCallback IllIIIIllI;
        public final /* synthetic */ lllIIIlIlI IllIIIllII;
        public final /* synthetic */ lllIlIlIIl lIlIIIIlIl;
        public final /* synthetic */ llIIlllIll llIIIlllll;
        public final /* synthetic */ boolean llIIlIlIIl;

        public IllIIIllII(boolean z, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili, llIIlllIll lliilllill, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
            this.llIIlIlIIl = z;
            this.IlIllIlIIl = recognizerBundle;
            this.IllIIIllII = llliiilili;
            this.llIIIlllll = lliilllill;
            this.IllIIIIllI = recognitionProcessCallback;
            this.lIlIIIIlIl = lllililiil;
        }

        public void run() {
            IllIIIllII illIIIllII = (IllIIIllII) NativeRecognizerWrapper.this.llIIlIlIIl.get();
            if (illIIIllII == IllIIIllII.READY || illIIIllII == IllIIIllII.DISPATCH_READY || (this.llIIlIlIIl && illIIIllII == IllIIIllII.DONE)) {
                if (!this.IlIllIlIIl.equals(NativeRecognizerWrapper.this.llIIlIIlll)) {
                    NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.IlIllIlIIl, this.IllIIIllII);
                    NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, true);
                }
                NativeRecognizerWrapper.this.lIIIIIllll.llIIlIlIIl(this.llIIIlllll);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                NativeRecognizerWrapper.llIIlIlIIl(nativeRecognizerWrapper, (IllIIlIIII) nativeRecognizerWrapper.lIIIIIllll, this.IllIIIIllI, this.lIlIIIIlIl);
            }
        }
    }

    /* compiled from: line */
    public interface IllIIlIIII {
        int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback);
    }

    /* compiled from: line */
    public class lIIIIIlIlI implements IllIIlIIII {
        private String llIIlIlIIl;

        private lIIIIIlIlI() {
        }

        public void llIIlIlIIl(String str) {
            this.llIIlIlIIl = str;
        }

        public /* synthetic */ lIIIIIlIlI(NativeRecognizerWrapper nativeRecognizerWrapper, llIIlIlIIl lliililiil) {
            this();
        }

        public int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback) {
            Log.m40233v(this, "Recognizing from string " + this.llIIlIlIIl, new Object[0]);
            int llIIlIlIIl2 = NativeRecognizerWrapper.recognizeString(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl, recognitionProcessCallback.getNativeContext());
            Log.m40233v(this, "Finished recognizing from string " + this.llIIlIlIIl, new Object[0]);
            return llIIlIlIIl2;
        }
    }

    /* compiled from: line */
    public class lIIIIIllll extends TimerTask {
        public lIIIIIllll() {
        }

        public void run() {
            boolean unused = NativeRecognizerWrapper.this.IlIllIlIIl = true;
            Timer unused2 = NativeRecognizerWrapper.this.IllIIIllII = null;
        }
    }

    /* compiled from: line */
    public class lIlIIIIlIl implements Runnable {
        public final /* synthetic */ boolean llIIlIlIIl;

        public lIlIIIIlIl(boolean z) {
            this.llIIlIlIIl = z;
        }

        public void run() {
            if (!NativeRecognizerWrapper.this.IIlIIIllIl.get()) {
                Log.m40227d(NativeRecognizerWrapper.class, "RESETTING RECOGNIZERS", new Object[0]);
                NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl);
                NativeRecognizerWrapper.this.llIIlIlIIl();
            }
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements Runnable {
        public final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        public final /* synthetic */ lllIlIlIIl IllIIIIllI;
        public final /* synthetic */ String IllIIIllII;
        public final /* synthetic */ RecognitionProcessCallback llIIIlllll;
        public final /* synthetic */ RecognizerBundle llIIlIlIIl;

        public llIIIlllll(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili, String str, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
            this.llIIlIlIIl = recognizerBundle;
            this.IlIllIlIIl = llliiilili;
            this.IllIIIllII = str;
            this.llIIIlllll = recognitionProcessCallback;
            this.IllIIIIllI = lllililiil;
        }

        public void run() {
            IllIIIllII illIIIllII = (IllIIIllII) NativeRecognizerWrapper.this.llIIlIlIIl.get();
            if (illIIIllII == IllIIIllII.READY || illIIIllII == IllIIIllII.DISPATCH_READY || illIIIllII == IllIIIllII.DONE) {
                if (!this.llIIlIlIIl.equals(NativeRecognizerWrapper.this.llIIlIIlll)) {
                    NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.llIIlIlIIl, this.IlIllIlIIl);
                    NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, true);
                }
                NativeRecognizerWrapper.this.lllIIIlIlI.llIIlIlIIl(this.IllIIIllII);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                NativeRecognizerWrapper.llIIlIlIIl(nativeRecognizerWrapper, (IllIIlIIII) nativeRecognizerWrapper.lllIIIlIlI, this.llIIIlllll, this.IllIIIIllI);
            }
        }
    }

    /* compiled from: line */
    public class llIIlIIlll implements Runnable {
        public final /* synthetic */ CountDownLatch llIIlIlIIl;

        public llIIlIIlll(NativeRecognizerWrapper nativeRecognizerWrapper, CountDownLatch countDownLatch) {
            this.llIIlIlIIl = countDownLatch;
        }

        public void run() {
            this.llIIlIlIIl.countDown();
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        public final /* synthetic */ RecognizerBundle IllIIIllII;
        public final /* synthetic */ Context llIIlIlIIl;

        public llIIlIlIIl(Context context, lllIIIlIlI llliiilili, RecognizerBundle recognizerBundle) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = llliiilili;
            this.IllIIIllII = recognizerBundle;
        }

        public void run() {
            try {
                IIIIIllIll.llIIlIlIIl().llIIlIlIIl(this.llIIlIlIIl);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                Log.m40227d(nativeRecognizerWrapper, "Initializing library from state: {}", ((IllIIIllII) nativeRecognizerWrapper.llIIlIlIIl.get()).name());
                if (NativeRecognizerWrapper.this.llIIlIlIIl.compareAndSet(IllIIIllII.PRE_INIT, IllIIIllII.INITIALIZING)) {
                    ResourceProvider.INSTANCE.prepareAssertManager(this.llIIlIlIIl);
                    Log.m40233v(NativeRecognizerWrapper.this, "Calling native init...", new Object[0]);
                    Log.m40231i(this, "Native context ptr: {}", Long.valueOf(NativeRecognizerWrapper.this.lllIlIlIIl));
                    NativeRecognizerWrapper nativeRecognizerWrapper2 = NativeRecognizerWrapper.this;
                    NativeLibraryInfo unused = nativeRecognizerWrapper2.llIIIlllll = new NativeLibraryInfo(NativeRecognizerWrapper.initNativeRecognizers(nativeRecognizerWrapper2.lllIlIlIIl, NativeRecognizerWrapper.llIIlIlIIl(this.IllIIIllII.getRecognizers()), this.IllIIIllII.shouldAllowMultipleScanResultsOnSingleImage(), FileLog.getLogFolder(this.llIIlIlIIl)));
                    RecognizerBundle unused2 = NativeRecognizerWrapper.this.llIIlIIlll = this.IllIIIllII;
                    if (!NativeRecognizerWrapper.this.llIIIlllll.IlIllIlIIl()) {
                        Log.m40229e(NativeRecognizerWrapper.this, "Failed to initialize native library!", new Object[0]);
                        NativeRecognizerWrapper nativeRecognizerWrapper3 = NativeRecognizerWrapper.this;
                        Log.m40229e(nativeRecognizerWrapper3, "Reason: {}", nativeRecognizerWrapper3.llIIIlllll.llIIlIlIIl());
                        synchronized (NativeRecognizerWrapper.this) {
                            int unused3 = NativeRecognizerWrapper.this.IlIllIlllI = 0;
                        }
                        NativeRecognizerWrapper.this.IllIIIIllI();
                        this.IlIllIlIIl.onRecognizerError(new RecognizerError(NativeRecognizerWrapper.this.llIIIlllll.llIIlIlIIl()));
                        return;
                    }
                    Log.m40227d(NativeRecognizerWrapper.this, "Native library has initialized.", new Object[0]);
                    NativeRecognizerWrapper.this.lIlIIIIlIl();
                    return;
                }
                NativeRecognizerWrapper nativeRecognizerWrapper4 = NativeRecognizerWrapper.this;
                Log.m40235w(nativeRecognizerWrapper4, "Library is already initialized (state: {})", ((IllIIIllII) nativeRecognizerWrapper4.llIIlIlIIl.get()).name());
            } catch (Exception e) {
                this.IlIllIlIIl.onRecognizerError(e);
            }
        }
    }

    /* compiled from: line */
    public interface lllIIIlIlI {
        void onRecognizerError(Throwable th);
    }

    /* compiled from: line */
    public interface lllIlIlIIl {
        void onRecognitionDone(RecognitionSuccessType recognitionSuccessType);

        void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType);
    }

    /* access modifiers changed from: public */
    static {
        IlIllIlIIl.IllIIIllII();
    }

    /* access modifiers changed from: private */
    public static native long initNativeRecognizers(long j, long[] jArr, boolean z, String str);

    private static native long nativeConstruct();

    /* access modifiers changed from: private */
    public static native int recognize(long j, long j2, long j3);

    /* access modifiers changed from: private */
    public static native int recognizeString(long j, String str, long j2);

    /* access modifiers changed from: private */
    public static native void resetRecognizers(long j, boolean z);

    private static native void terminateNativeRecognizers(long j);

    private static native String updateRecognizers(long j, long[] jArr, boolean z);

    /* access modifiers changed from: private */
    public void IllIIIIllI() {
        Log.m40233v(this, "Terminating native library, state was: {}", this.llIIlIlIIl.get().name());
        this.llIIlIIlll = null;
        IllIIIllII illIIIllII = this.llIIlIlIIl.get();
        IllIIIllII illIIIllII2 = IllIIIllII.UNINITIALIZED;
        if (illIIIllII != illIIIllII2) {
            Log.m40233v(this, "Calling native terminate...", new Object[0]);
            terminateNativeRecognizers(this.lllIlIlIIl);
            this.lllIlIlIIl = 0;
            this.llIIlIlIIl.set(illIIIllII2);
        }
    }

    /* access modifiers changed from: private */
    public void lIlIIIIlIl() {
        llIIlIlIIl lliililiil = this.lIlIIIIlIl;
        if (lliililiil != null) {
            llIIlllIll llIIlIlIIl2 = lliililiil.llIIlIlIIl();
            if (llIIlIlIIl2 != null) {
                Log.m40227d(this, "Obtained already best frame ID {} from provider. Starting recognition...", Long.valueOf(llIIlIlIIl2.lIlIIIIlIl()));
                this.llIIlIlIIl.set(IllIIIllII.DISPATCH_READY);
                llIIlIlIIl(llIIlIlIIl2, this.lIlIIIIlIl.IlIllIlIIl(), this.lIlIIIIlIl.IllIIIIllI(), this.lIlIIIIlIl.llIIIlllll(), this.lIlIIIIlIl.IllIIIllII(), false);
                return;
            }
            Log.m40227d(this, "Provider still does not have best frame available. Will wait for it to dispatch a frame", new Object[0]);
        }
        Log.m40227d(this, "Transitioned to state READY", new Object[0]);
        this.llIIlIlIIl.set(IllIIIllII.READY);
    }

    public void IlIllIlIIl(boolean z) {
        this.IIlIIIllIl.set(z);
    }

    public void IllIIIllII() {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
        if (liliiiilil != null) {
            liliiiilil.llIIlIlIIl((Runnable) new IllIIIIllI());
        } else {
            Log.wtf(this, "Processing thread is null! Unable to prepare for next recognition!", new Object[0]);
        }
    }

    public void llIIIlllll() {
        int i = this.IlIllIlllI - 1;
        this.IlIllIlllI = i;
        if (i > 0) {
            Log.m40231i(this, "Still having {} instances running, will not terminate native recognizer", Integer.valueOf(i));
            return;
        }
        this.IIlIIIllIl.set(true);
        llIIlIlIIl();
        if (this.IllIIIIllI != null) {
            Log.m40233v(this, "Dispatching termination task. State was: {}", this.llIIlIlIIl);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.IllIIIIllI.llIIlIlIIl((Runnable) new IIlIIIllIl(countDownLatch));
            Log.m40231i(this, "Waiting for native library to terminate...", new Object[0]);
            try {
                countDownLatch.await();
                Log.m40231i(this, "Native library has terminated.", new Object[0]);
            } catch (InterruptedException e) {
                Log.m40236w(this, e, "Interrupted while waiting for native library to terminate.", new Object[0]);
            }
        } else {
            Log.m40235w(this, "Library is already terminated or is terminating. State: {}", this.llIIlIlIIl);
        }
    }

    public void llIIlIIlll() {
        if (this.IllIIIIllI != null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.IllIIIIllI.llIIlIlIIl((Runnable) new llIIlIIlll(this, countDownLatch));
            try {
                Log.m40231i(this, "Waiting for recognition...", new Object[0]);
                countDownLatch.await();
            } catch (InterruptedException e) {
                Log.m40236w(this, e, "Interrupted while waiting for recognition", new Object[0]);
            }
        } else {
            Log.wtf(this, "Cannot wait for recognition, processing thread is null", new Object[0]);
        }
    }

    public IllIIIllII IlIllIlIIl() {
        return this.llIIlIlIIl.get();
    }

    public void llIIlIlIIl(llIIlIlIIl lliililiil) {
        this.lIlIIIIlIl = lliililiil;
    }

    public static long[] llIIlIlIIl(Recognizer[] recognizerArr) {
        long[] jArr = new long[recognizerArr.length];
        for (int i = 0; i < recognizerArr.length; i++) {
            if (recognizerArr[i] != null) {
                jArr[i] = recognizerArr[i].getNativeContext();
            } else {
                jArr[i] = 0;
            }
        }
        return jArr;
    }

    public void llIIlIlIIl(Context context, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        int i = this.IlIllIlllI + 1;
        this.IlIllIlllI = i;
        Log.m40227d(this, "Active instances: {}", Integer.valueOf(i));
        if (!this.llIIlIlIIl.compareAndSet(IllIIIllII.UNINITIALIZED, IllIIIllII.PRE_INIT)) {
            Log.m40235w(this, "Will not initialize native recognizer because it is already initialized, state is {}", this.llIIlIlIIl);
            com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
            if (liliiiilil != null) {
                liliiiilil.llIIlIlIIl((Runnable) new IlIllIlIIl(recognizerBundle, llliiilili));
                return;
            }
            throw new IllegalStateException("Cannot reconfigure recognizers when they are not active. Please initialize first!");
        }
        IlIllIlIIl.llIIlIlIIl();
        if (this.lllIlIlIIl == 0) {
            this.lllIlIlIIl = nativeConstruct();
        }
        if (MicroblinkDeviceManager.llIIlIlIIl(context) != null) {
            this.IIlIIIllIl.set(false);
            Log.m40227d(this, "Posting init task to RecognitionQueue...", new Object[0]);
            this.IllIIIIllI.llIIlIlIIl((Runnable) new llIIlIlIIl(context, llliiilili, recognizerBundle));
            return;
        }
        throw new NullPointerException("Device manager was not initialised!");
    }

    public static void llIIlIlIIl(NativeRecognizerWrapper nativeRecognizerWrapper, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        IllIIIllII illIIIllII = nativeRecognizerWrapper.llIIlIlIIl.get();
        if (illIIIllII != IllIIIllII.UNINITIALIZED && illIIIllII != IllIIIllII.PRE_INIT && illIIIllII != IllIIIllII.INITIALIZING) {
            String updateRecognizers = updateRecognizers(nativeRecognizerWrapper.lllIlIlIIl, llIIlIlIIl(recognizerBundle.getRecognizers()), recognizerBundle.shouldAllowMultipleScanResultsOnSingleImage());
            nativeRecognizerWrapper.llIIlIIlll = recognizerBundle;
            if (updateRecognizers != null) {
                Log.m40229e(nativeRecognizerWrapper, "Failed to reconfigure native recognizers!", new Object[0]);
                Log.m40229e(nativeRecognizerWrapper, "Reason: {}", updateRecognizers);
                nativeRecognizerWrapper.IllIIIIllI();
                llliiilili.onRecognizerError(new RecognizerError(updateRecognizers));
            }
        }
    }

    public void llIIlIlIIl(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
        if (liliiiilil != null) {
            liliiiilil.llIIlIlIIl((Runnable) new IlIllIlIIl(recognizerBundle, llliiilili));
            return;
        }
        throw new IllegalStateException("Cannot reconfigure recognizers when they are not active. Please initialize first!");
    }

    public static void llIIlIlIIl(NativeRecognizerWrapper nativeRecognizerWrapper, IllIIlIIII illIIlIIII, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
        if (nativeRecognizerWrapper.lllIlIlIIl == 0) {
            Log.m40235w(nativeRecognizerWrapper, "Reconfiguration or initialisation has failed. Cannot recognise input data!", new Object[0]);
            return;
        }
        nativeRecognizerWrapper.llIIlIlIIl.set(IllIIIllII.WORKING);
        recognitionProcessCallback.setNativeRecognizerWrapper(nativeRecognizerWrapper);
        int llIIlIlIIl2 = illIIlIIII.llIIlIlIIl(recognitionProcessCallback);
        recognitionProcessCallback.setNativeRecognizerWrapper((NativeRecognizerWrapper) null);
        nativeRecognizerWrapper.llIIlIlIIl.set(IllIIIllII.DONE);
        if (lllililiil != null) {
            RecognitionSuccessType fromNativeRecognitionState = RecognitionSuccessType.fromNativeRecognitionState(llIIlIlIIl2);
            if (nativeRecognizerWrapper.IlIllIlIIl) {
                lllililiil.onRecognitionDoneWithTimeout(fromNativeRecognitionState);
            } else {
                lllililiil.onRecognitionDone(fromNativeRecognitionState);
            }
        } else {
            nativeRecognizerWrapper.lIlIIIIlIl();
        }
    }

    public void llIIlIlIIl(llIIlllIll lliilllill, RecognizerBundle recognizerBundle, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil, lllIIIlIlI llliiilili, boolean z) {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
        if (liliiiilil != null) {
            liliiiilil.llIIlIlIIl((Runnable) new IllIIIllII(z, recognizerBundle, llliiilili, lliilllill, recognitionProcessCallback, lllililiil));
        } else {
            Log.wtf(this, "Processing thread is null! Unable to perform recognition!", new Object[0]);
        }
    }

    public void llIIlIlIIl(String str, RecognizerBundle recognizerBundle, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil, lllIIIlIlI llliiilili) {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
        if (liliiiilil != null) {
            liliiiilil.llIIlIlIIl((Runnable) new llIIIlllll(recognizerBundle, llliiilili, str, recognitionProcessCallback, lllililiil));
        } else {
            Log.wtf(this, "Processing thread is null! Unable to perform recognition!", new Object[0]);
        }
    }

    public void llIIlIlIIl(boolean z) {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = this.IllIIIIllI;
        if (liliiiilil != null) {
            liliiiilil.llIIlIlIIl((Runnable) new lIlIIIIlIl(z));
        } else {
            Log.wtf(this, "Unable to reset recognizers: processing thread is null", new Object[0]);
        }
    }

    public void llIIlIlIIl() {
        Timer timer = this.IllIIIllII;
        if (timer != null) {
            timer.cancel();
        }
        this.IlIllIlIIl = false;
        this.IllIIIllII = null;
    }

    public void llIIlIlIIl(int i) {
        if (i == 0) {
            llIIlIlIIl();
        } else if (this.IllIIIllII == null) {
            Log.m40227d(this, "Scheduling timeout after {} miliseconds", Integer.valueOf(i));
            this.IllIIIllII = new Timer();
            this.IlIllIlIIl = false;
            this.IllIIIllII.schedule(new lIIIIIllll(), (long) i);
        }
    }
}

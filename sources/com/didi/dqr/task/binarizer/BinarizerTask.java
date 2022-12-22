package com.didi.dqr.task.binarizer;

import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.OpenCVBinarizer;
import com.didi.dqr.common.GlobalHistogramBinarizer;
import com.didi.dqr.common.HybridBinarizer;
import com.didi.dqr.task.base.DqrTask;
import com.didi.dqr.task.base.DqrTaskData;
import com.didi.dqr.task.base.DqrTaskType;
import com.didi.dqrutil.DqrConfigHelper;

public class BinarizerTask extends DqrTask {

    /* renamed from: a */
    private volatile BinarizerEnum f19110a;

    public BinarizerTask(BinarizerEnum binarizerEnum) {
        this.f19110a = binarizerEnum;
    }

    public DqrTaskType getTaskType() {
        return DqrTaskType.TASK_BINARIZER;
    }

    public DqrTaskData run(DqrTaskData dqrTaskData) {
        BinaryBitmap binaryBitmap;
        BinaryBitmap binaryBitmap2;
        LuminanceSource source = dqrTaskData.getSource();
        if (source != null) {
            int i = C79071.$SwitchMap$com$didi$dqr$BinarizerEnum[dqrTaskData.getDecodeOptions().binarizer.ordinal()];
            if (i == 1) {
                this.f19110a = BinarizerEnum.HybridBinarizer;
                BinarizerEnum binarizerEnum = BinarizerEnum.HybridBinarizer;
                binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(source));
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5 && !OpenCVBinarizer.isLoadLibraryError()) {
                            BinarizerEnum binarizerEnum2 = BinarizerEnum.OpenCV;
                            OpenCVBinarizer openCVBinarizer = new OpenCVBinarizer(source);
                            openCVBinarizer.setBlockSizeFact(DqrConfigHelper.cvBlockSizeFact());
                            binaryBitmap = new BinaryBitmap(openCVBinarizer);
                            dqrTaskData.setBinaryBitmap(binaryBitmap);
                        } else {
                            BinarizerEnum binarizerEnum3 = BinarizerEnum.HybridBinarizer;
                            binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(source));
                        }
                    }
                } else if (!OpenCVBinarizer.isLoadLibraryError()) {
                    if (this.f19110a == BinarizerEnum.OpenCV) {
                        this.f19110a = BinarizerEnum.HybridBinarizer;
                        BinarizerEnum binarizerEnum4 = BinarizerEnum.HybridBinarizer;
                        binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(source));
                    } else {
                        this.f19110a = BinarizerEnum.OpenCV;
                        BinarizerEnum binarizerEnum5 = BinarizerEnum.OpenCV;
                        OpenCVBinarizer openCVBinarizer2 = new OpenCVBinarizer(source);
                        openCVBinarizer2.setBlockSizeFact(DqrConfigHelper.cvBlockSizeFact());
                        binaryBitmap = new BinaryBitmap(openCVBinarizer2);
                        dqrTaskData.setBinaryBitmap(binaryBitmap);
                    }
                }
                if (this.f19110a == BinarizerEnum.GlobalHistogramBinarizer) {
                    this.f19110a = BinarizerEnum.HybridBinarizer;
                    BinarizerEnum binarizerEnum6 = BinarizerEnum.HybridBinarizer;
                    binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(source));
                } else {
                    this.f19110a = BinarizerEnum.GlobalHistogramBinarizer;
                    BinarizerEnum binarizerEnum7 = BinarizerEnum.GlobalHistogramBinarizer;
                    binaryBitmap2 = new BinaryBitmap(new GlobalHistogramBinarizer(source));
                }
            } else {
                this.f19110a = BinarizerEnum.GlobalHistogramBinarizer;
                BinarizerEnum binarizerEnum8 = BinarizerEnum.GlobalHistogramBinarizer;
                binaryBitmap2 = new BinaryBitmap(new GlobalHistogramBinarizer(source));
            }
            binaryBitmap = binaryBitmap2;
            dqrTaskData.setBinaryBitmap(binaryBitmap);
        }
        return dqrTaskData;
    }

    /* renamed from: com.didi.dqr.task.binarizer.BinarizerTask$1 */
    static /* synthetic */ class C79071 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dqr$BinarizerEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.dqr.BinarizerEnum[] r0 = com.didi.dqr.BinarizerEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dqr$BinarizerEnum = r0
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.HybridBinarizer     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.CommixtureWithOpenCV     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.Commixture     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.OpenCV     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.task.binarizer.BinarizerTask.C79071.<clinit>():void");
        }
    }
}

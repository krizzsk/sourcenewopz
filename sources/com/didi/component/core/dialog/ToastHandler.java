package com.didi.component.core.dialog;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.ToastHelper;

public class ToastHandler {

    /* renamed from: a */
    private Context f12751a;

    public enum ToastType {
        COMPLETE,
        INFO,
        ERROR
    }

    public ToastHandler(Context context) {
        this.f12751a = context.getApplicationContext();
    }

    public void showToast(ToastInfo toastInfo) {
        if (toastInfo != null && !toastInfo.invalid()) {
            int i = C53491.$SwitchMap$com$didi$component$core$dialog$ToastHandler$ToastType[toastInfo.type.ordinal()];
            if (i == 1) {
                m8687a(toastInfo);
            } else if (i == 2) {
                m8688b(toastInfo);
            } else if (i == 3) {
                m8689c(toastInfo);
            }
        }
    }

    /* renamed from: com.didi.component.core.dialog.ToastHandler$1 */
    static /* synthetic */ class C53491 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$core$dialog$ToastHandler$ToastType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.component.core.dialog.ToastHandler$ToastType[] r0 = com.didi.component.core.dialog.ToastHandler.ToastType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$core$dialog$ToastHandler$ToastType = r0
                com.didi.component.core.dialog.ToastHandler$ToastType r1 = com.didi.component.core.dialog.ToastHandler.ToastType.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$component$core$dialog$ToastHandler$ToastType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.core.dialog.ToastHandler$ToastType r1 = com.didi.component.core.dialog.ToastHandler.ToastType.INFO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$component$core$dialog$ToastHandler$ToastType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.component.core.dialog.ToastHandler$ToastType r1 = com.didi.component.core.dialog.ToastHandler.ToastType.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.core.dialog.ToastHandler.C53491.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m8687a(ToastInfo toastInfo) {
        int access$100 = toastInfo.duration;
        if (access$100 == 0) {
            ToastHelper.showShortCompleted(this.f12751a, toastInfo.message);
        } else if (access$100 == 1) {
            ToastHelper.showLongCompleteMessage(this.f12751a, toastInfo.message);
        }
    }

    /* renamed from: b */
    private void m8688b(ToastInfo toastInfo) {
        int access$100 = toastInfo.duration;
        if (access$100 != 0) {
            if (access$100 == 1) {
                ToastHelper.showLongInfo(this.f12751a, toastInfo.message);
            }
        } else if (TextUtils.isEmpty(toastInfo.subTitle)) {
            ToastHelper.showShortInfo(this.f12751a, toastInfo.message);
        } else {
            ToastHelper.showShortInfo(this.f12751a, toastInfo.message, toastInfo.subTitle);
        }
    }

    /* renamed from: c */
    private void m8689c(ToastInfo toastInfo) {
        int access$100 = toastInfo.duration;
        if (access$100 == 0) {
            ToastHelper.showShortError(this.f12751a, toastInfo.message);
        } else if (access$100 == 1) {
            ToastHelper.showLongError(this.f12751a, toastInfo.message);
        }
    }

    public static class ToastInfo {
        /* access modifiers changed from: private */
        public int duration;
        /* access modifiers changed from: private */
        public String message;
        /* access modifiers changed from: private */
        public String subTitle;
        /* access modifiers changed from: private */
        public ToastType type;

        public ToastInfo setToastType(ToastType toastType) {
            this.type = toastType;
            return this;
        }

        public ToastInfo setMessage(String str) {
            this.message = str;
            return this;
        }

        public ToastInfo setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        public ToastInfo setDuration(int i) {
            this.duration = i;
            return this;
        }

        public boolean invalid() {
            if (this.type == null || TextUtils.isEmpty(this.message)) {
                return true;
            }
            int i = this.duration;
            if (i == 1 || i == 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "{type=" + this.type + ", message=" + this.message + ", subTitle=" + this.subTitle + ", duration=" + this.duration + "}";
        }
    }
}

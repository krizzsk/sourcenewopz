package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCAlert */
public class DARCAlert extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCAlert(long j, boolean z) {
        super(AREngineJNIBridge.DARCAlert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCAlert dARCAlert) {
        if (dARCAlert == null) {
            return 0;
        }
        return dARCAlert.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
        super.delete();
    }

    public static DARCAlert alloc() {
        long DARCAlert_alloc = AREngineJNIBridge.DARCAlert_alloc();
        if (DARCAlert_alloc == 0) {
            return null;
        }
        return new DARCAlert(DARCAlert_alloc, false);
    }

    /* renamed from: com.didi.hawaii.ar.jni.DARCAlert$Button */
    public static class Button {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        protected Button(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(Button button) {
            if (button == null) {
                return 0;
            }
            return button.swigCPtr;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            delete();
        }

        public synchronized void delete() {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    AREngineJNIBridge.delete_DARCAlert_Button(this.swigCPtr);
                }
                this.swigCPtr = 0;
            }
        }

        public void setText(String str) {
            AREngineJNIBridge.DARCAlert_Button_text_set(this.swigCPtr, this, str);
        }

        public String getText() {
            return AREngineJNIBridge.DARCAlert_Button_text_get(this.swigCPtr, this);
        }

        public void setAction(ActionType actionType) {
            AREngineJNIBridge.DARCAlert_Button_action_set(this.swigCPtr, this, actionType.swigValue());
        }

        public ActionType getAction() {
            return ActionType.swigToEnum(AREngineJNIBridge.DARCAlert_Button_action_get(this.swigCPtr, this));
        }

        public void setCountDown(int i) {
            AREngineJNIBridge.DARCAlert_Button_countDown_set(this.swigCPtr, this, i);
        }

        public int getCountDown() {
            return AREngineJNIBridge.DARCAlert_Button_countDown_get(this.swigCPtr, this);
        }

        public Button() {
            this(AREngineJNIBridge.new_DARCAlert_Button(), true);
        }
    }

    public void setTitle(String str) {
        AREngineJNIBridge.DARCAlert_title_set(this.swigCPtr, this, str);
    }

    public String getTitle() {
        return AREngineJNIBridge.DARCAlert_title_get(this.swigCPtr, this);
    }

    public void setContent(String str) {
        AREngineJNIBridge.DARCAlert_content_set(this.swigCPtr, this, str);
    }

    public String getContent() {
        return AREngineJNIBridge.DARCAlert_content_get(this.swigCPtr, this);
    }

    /* renamed from: com.didi.hawaii.ar.jni.DARCAlert$ActionType */
    public static final class ActionType {
        public static final ActionType AT_Close = new ActionType("AT_Close", AREngineJNIBridge.DARCAlert_AT_Close_get());
        public static final ActionType AT_Exit = new ActionType("AT_Exit", AREngineJNIBridge.DARCAlert_AT_Exit_get());
        public static final ActionType AT_NeedReply;
        private static int swigNext = 0;
        private static ActionType[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            ActionType actionType = new ActionType("AT_NeedReply", AREngineJNIBridge.DARCAlert_AT_NeedReply_get());
            AT_NeedReply = actionType;
            swigValues = new ActionType[]{AT_Close, AT_Exit, actionType};
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static ActionType swigToEnum(int i) {
            ActionType[] actionTypeArr = swigValues;
            if (i < actionTypeArr.length && i >= 0 && actionTypeArr[i].swigValue == i) {
                return actionTypeArr[i];
            }
            int i2 = 0;
            while (true) {
                ActionType[] actionTypeArr2 = swigValues;
                if (i2 >= actionTypeArr2.length) {
                    throw new IllegalArgumentException("No enum " + ActionType.class + " with value " + i);
                } else if (actionTypeArr2[i2].swigValue == i) {
                    return actionTypeArr2[i2];
                } else {
                    i2++;
                }
            }
        }

        private ActionType(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private ActionType(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private ActionType(String str, ActionType actionType) {
            this.swigName = str;
            int i = actionType.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}

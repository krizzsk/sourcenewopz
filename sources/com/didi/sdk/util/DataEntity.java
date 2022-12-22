package com.didi.sdk.util;

import android.view.View;

public class DataEntity {

    /* renamed from: a */
    private View f37580a;

    /* renamed from: b */
    private Align f37581b;

    /* renamed from: c */
    private Offset f37582c;

    /* renamed from: d */
    private IDataEntityChangeListener f37583d;

    public interface IDataEntityChangeListener {
        void onChange(String str, int i);
    }

    public static class Offset {

        /* renamed from: x */
        public int f37584x;

        /* renamed from: y */
        public int f37585y;
    }

    public void setDataEntityChangeListener(IDataEntityChangeListener iDataEntityChangeListener) {
        this.f37583d = iDataEntityChangeListener;
    }

    public IDataEntityChangeListener getDataEntityChangeListener() {
        return this.f37583d;
    }

    private DataEntity() {
    }

    public Align getAlign() {
        return this.f37581b;
    }

    public View getView() {
        return this.f37580a;
    }

    public static DataEntity create() {
        return new DataEntity();
    }

    public DataEntity setView(View view) {
        this.f37580a = view;
        return this;
    }

    public DataEntity setOffset(Offset offset) {
        this.f37582c = offset;
        return this;
    }

    public Offset getOffset() {
        return this.f37582c;
    }

    public DataEntity setAlign(Align align) {
        this.f37581b = align;
        return this;
    }

    public enum Align {
        BOTTON(80),
        CENTER(17),
        FILL_HORIZONTAL(7),
        TOP(48),
        FILL_BOTTOM_HORIZONTAL(87),
        FILL_TOP_HORIZONTAL(55);
        
        int align;

        private Align(int i) {
            this.align = i;
        }
    }
}

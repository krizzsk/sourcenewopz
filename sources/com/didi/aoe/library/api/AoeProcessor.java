package com.didi.aoe.library.api;

import android.content.Context;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.lang.AoeIOException;
import java.util.List;

public interface AoeProcessor {

    public interface Component {
    }

    public interface InterpreterComponent<TInput, TOutput> extends Component {
        void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener);

        boolean isReady();

        void release();

        TOutput run(TInput tinput);
    }

    @FunctionalInterface
    public interface ModelOptionLoaderComponent extends Component {
        AoeModelOption load(Context context, String str) throws AoeIOException;
    }

    public interface ParcelComponent extends Component {
        Object byte2Obj(byte[] bArr);

        byte[] obj2Byte(Object obj);
    }

    InterpreterComponent getInterpreterComponent();

    ParcelComponent getParcelComponent();

    void setId(String str);
}

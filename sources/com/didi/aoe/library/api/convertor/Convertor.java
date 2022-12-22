package com.didi.aoe.library.api.convertor;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0003H&¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00018\u00022\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/aoe/library/api/convertor/Convertor;", "TInput", "TOutput", "TModelInput", "TModelOutput", "", "postProcess", "modelOutput", "(Ljava/lang/Object;)Ljava/lang/Object;", "preProcess", "input", "library-api_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Convertor.kt */
public interface Convertor<TInput, TOutput, TModelInput, TModelOutput> {
    TOutput postProcess(TModelOutput tmodeloutput);

    TModelInput preProcess(TInput tinput);
}

package com.didi.aoe.library.api.convertor;

import java.util.Map;

public interface MultiConvertor<TInput, TOutput, TModelInput, TModelOutput> {
    TOutput postProcessMulti(Map<Integer, TModelOutput> map);

    TModelInput[] preProcessMulti(TInput tinput);
}

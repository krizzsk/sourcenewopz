package com.didi.soda.search.component.suggestion;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.SugCompEntity;
import java.util.List;

public class SearchSuggestionState implements IEntity {
    private static final long serialVersionUID = 3978537746736713165L;
    public String searchKey;
    public String sugId = null;
    public int sugIndex = 0;
    public List<SugCompEntity> sugList;
    public List<String> suggestions;
    public String traceId = null;
}

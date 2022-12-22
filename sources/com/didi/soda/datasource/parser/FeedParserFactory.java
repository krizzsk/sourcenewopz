package com.didi.soda.datasource.parser;

import com.didi.soda.customer.dynamic.AbsFeedParserFactory;
import com.didi.soda.datasource.parser.impl.CategoryNotifyParser;
import com.didi.soda.datasource.parser.impl.ExpandMoreTitleParser;
import com.didi.soda.datasource.parser.impl.FeedBannerParser;
import com.didi.soda.datasource.parser.impl.FeedBusinessParser;
import com.didi.soda.datasource.parser.impl.FeedKingKongParser;
import com.didi.soda.datasource.parser.impl.FeedNoResultParser;
import com.didi.soda.datasource.parser.impl.FeedOrderCardParser;
import com.didi.soda.datasource.parser.impl.FeedTaskCenterParser;
import com.didi.soda.datasource.parser.impl.FeedTopicV2Parser;
import com.didi.soda.datasource.parser.impl.FilterParser;
import com.didi.soda.datasource.parser.impl.LandingFilterParser;
import com.didi.soda.datasource.parser.impl.SimpleTitleParser;
import com.didi.soda.search.component.result.parser.SearchBusinessResultParser;

public class FeedParserFactory extends AbsFeedParserFactory<FeedParser> {

    /* renamed from: a */
    private static final FeedParserFactory f42276a = new FeedParserFactory();

    public static FeedParserFactory getFactory() {
        return f42276a;
    }

    public void initParser() {
        registerParser(FeedBusinessParser.class);
        registerParser(FeedKingKongParser.class);
        registerParser(FilterParser.class);
        registerParser(LandingFilterParser.class);
        registerParser(FeedTopicV2Parser.class);
        registerParser(FeedBannerParser.class);
        registerParser(FeedOrderCardParser.class);
        registerParser(FeedNoResultParser.class);
        registerParser(FeedTaskCenterParser.class);
        registerParser(SimpleTitleParser.class);
        registerParser(ExpandMoreTitleParser.class);
        registerParser(SearchBusinessResultParser.class);
        registerParser(CategoryNotifyParser.class);
    }
}

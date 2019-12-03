package com.epam.ta.service;

import com.epam.ta.model.SearchQuery;

public class SearchQueryCreate {
    public static final String SEARCHQUERY_PLACE = "testdata.searchQuery.place";
    public static final String SEARCHQUERY_PLACE_UNREAL = "testdata.searchQuery.placeUnreal";

    public static SearchQuery withRealPlace(){
        return new SearchQuery(TestDataReader.getTestData(SEARCHQUERY_PLACE));
    }

    public static SearchQuery withUnrealPlace(){
        return new SearchQuery(TestDataReader.getTestData(SEARCHQUERY_PLACE_UNREAL));
    }

    public static SearchQuery withEmptyPlace(){
        return new SearchQuery(TestDataReader.getTestData(SEARCHQUERY_PLACE));
    }
}

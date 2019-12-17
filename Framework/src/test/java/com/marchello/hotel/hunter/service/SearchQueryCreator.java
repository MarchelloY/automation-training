package com.marchello.hotel.hunter.service;

import com.marchello.hotel.hunter.model.SearchQuery;

public class SearchQueryCreator {
    public static final String SEARCH_DATE_PLACE_INCORRECT = "search.place.incorrect";
    public static final String SEARCH_DATE_PLACE_CORRECT = "search.place.correct";

    public static SearchQuery withIncorrectPlace() {
        return new SearchQuery(DataReader.getData(SEARCH_DATE_PLACE_INCORRECT));
    }

    public static SearchQuery withCorrectPlace() {
        return new SearchQuery(DataReader.getData(SEARCH_DATE_PLACE_CORRECT));
    }
}

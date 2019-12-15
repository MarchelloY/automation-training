package com.marchello.hotel.hunter.model;

import java.util.Objects;

public class SearchQuery {

    private String place;

    public SearchQuery(String place) {
        this.place = place;
    }

    public SearchQuery() {}

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "place='" + place + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchQuery that = (SearchQuery) o;
        return Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }
}

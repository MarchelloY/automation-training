package com.epam.ta.test;

import com.epam.ta.model.SearchQuery;
import com.epam.ta.page.HotelsPage;
import com.epam.ta.service.SearchQueryCreate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHotelsTest extends CommonConditions{
    @Test
    public void thereMessageEmptyPlace() {
        SearchQuery searchQuery = SearchQueryCreate.withEmptyPlace();
        String messageError = new HotelsPage(driver)
                .openPage()
                .searchHotelsWithEmptyPlace(searchQuery)
                .messageEmptyPlaceError();

        Assert.assertEquals(messageError, "Пожайлуйста, укажите город, регион или название отеля для начала поиска");
    }
    @Test
    public void thereMessageUnrealPlace() {
        SearchQuery searchQuery = SearchQueryCreate.withUnrealPlace();
        String messageError = new HotelsPage(driver)
                .openPage()
                .searchHotelsWithUnrealPlace(searchQuery)
                .unrealPlaceMessageError();

        Assert.assertEquals(messageError, "К сожалению, во время поиска произошла ошибка, измените условия поиска или попробуйте позднее");
    }
}

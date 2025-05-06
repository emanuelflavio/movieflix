package dev.emanuel.movieflix.mapper;

import dev.emanuel.movieflix.Controller.request.CategoryRequest;
import dev.emanuel.movieflix.Controller.response.CategoryResponse;
import dev.emanuel.movieflix.Entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .nome(categoryRequest.nome())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .nome(category.getNome())
                .build();
    }
}

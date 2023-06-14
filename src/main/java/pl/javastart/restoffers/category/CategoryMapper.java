package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    CategoryInfoDto mapToDto(Category category) {
        return new CategoryInfoDto(category.getName(), category.getDescription(), category.getOffersSize());
    }


}

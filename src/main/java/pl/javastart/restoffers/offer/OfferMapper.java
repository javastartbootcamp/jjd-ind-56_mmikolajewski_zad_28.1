package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

@Service
public class OfferMapper {

    private final CategoryRepository categoryRepository;

    public OfferMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    OfferDto mapToDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setImgUrl(offer.getImgUrl());
        dto.setPrice(offer.getPrice());
        dto.setCategory(offer.getCategory().getName());
        return dto;
    }

    Offer maptoOffer(OfferDto dto) {
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setImgUrl(dto.getImgUrl());
        offer.setPrice(dto.getPrice());
        Category category = categoryRepository.findByName(dto.getCategory());
        offer.setCategory(category);
        return offer;
    }
}

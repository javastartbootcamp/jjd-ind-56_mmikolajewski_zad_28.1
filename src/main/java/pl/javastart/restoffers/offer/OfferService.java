package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    public List<OfferDto> findAllOfferDtos() {
        List<Offer> offers = offerRepository.findAll();
        return offers
                .stream()
                .map(offerMapper::mapToDto)
                .collect(Collectors.toList());

    }

    public List<OfferDto> findOffersByContainsWord(String title) {
        List<Offer> allByTitleContains = offerRepository.findOffersByTitleContainsIgnoreCase(title);
        return allByTitleContains
                .stream()
                .map(offerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public OfferDto insert(OfferDto dto) {
        Offer offer = offerMapper.maptoOffer(dto);
        Offer savedOffer = offerRepository.save(offer);
        return offerMapper.mapToDto(savedOffer);

    }

    public Optional<OfferDto> getOfferById(Long id) {
        return offerRepository.findById(id)
                .map(offerMapper::mapToDto);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}

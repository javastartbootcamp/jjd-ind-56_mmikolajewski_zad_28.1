package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferRestController {

    private final OfferService offerService;

    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/count")
    int countOffers() {
        return offerService.findAllOfferDtos().size();
    }

    @GetMapping
    ResponseEntity<List<OfferDto>> findOffersByContainsWord(@RequestParam(required = false) String title) {
        if (title == null) {
            List<OfferDto> allOfferDtos = offerService.findAllOfferDtos();
            return ResponseEntity.ok(allOfferDtos);
        }
        List<OfferDto> offersByContainsWord = offerService.findOffersByContainsWord(title);
        if (offersByContainsWord.isEmpty()) {
            List<OfferDto> allOfferDtos = offerService.findAllOfferDtos();
            return ResponseEntity.ok(allOfferDtos);
        } else {
            return ResponseEntity.ok(offersByContainsWord);
        }
    }

    @PostMapping
    ResponseEntity<OfferDto> addOffer(@RequestBody OfferDto dto) {
        OfferDto offerDto = offerService.insert(dto);
        return ResponseEntity.ok(offerDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<OfferDto> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }





}

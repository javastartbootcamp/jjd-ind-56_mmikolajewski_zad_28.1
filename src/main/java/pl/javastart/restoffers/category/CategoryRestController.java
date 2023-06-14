package pl.javastart.restoffers.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/names")
    List<String> findAllCategoriesNames() {
        return categoryService.findAllCategoriesNames();
    }

    @GetMapping
    ResponseEntity<List<CategoryInfoDto>> getAllCategories() {
        if (categoryService.getAllCategories().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    ResponseEntity<CategoryInfoDto> saveCategory(@RequestBody CategoryToCreateDto categoryToCreateDto) {
        CategoryInfoDto categoryInfoDto = categoryService.saveCategory(categoryToCreateDto);
        return ResponseEntity.ok(categoryInfoDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }


}

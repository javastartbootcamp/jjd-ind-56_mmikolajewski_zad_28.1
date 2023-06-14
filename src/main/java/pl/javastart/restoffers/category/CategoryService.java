package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<String> findAllCategoriesNames() {
        List<Category> all = categoryRepository.findAll();
        return all
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public List<CategoryInfoDto> getAllCategories() {
        List<Category> categoriesFromRepository = categoryRepository.findAll();
        return categoriesFromRepository
                .stream()
                .map(categoryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CategoryInfoDto saveCategory(CategoryToCreateDto categoryToCreateDto) {
        Category category = new Category(categoryToCreateDto.getName(), categoryToCreateDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.mapToDto(savedCategory);
    }

    public void deleteOffer(Long id) {
        categoryRepository.deleteById(id);

    }
}

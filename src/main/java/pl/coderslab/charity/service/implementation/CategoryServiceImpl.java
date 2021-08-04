package pl.coderslab.charity.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepo;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    public final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }
}

package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}

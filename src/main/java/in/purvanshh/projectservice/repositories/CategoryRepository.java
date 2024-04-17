package in.purvanshh.projectservice.repositories;

import in.purvanshh.projectservice.models.Category;
import in.purvanshh.projectservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}
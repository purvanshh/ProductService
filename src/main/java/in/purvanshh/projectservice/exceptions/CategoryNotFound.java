package in.purvanshh.projectservice.exceptions;

import in.purvanshh.projectservice.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
public class CategoryNotFound extends RuntimeException {
    public CategoryNotFound(String message) {
        super(message);
    }
}
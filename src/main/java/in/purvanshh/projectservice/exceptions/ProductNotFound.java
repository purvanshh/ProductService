package in.purvanshh.projectservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFound extends RuntimeException {
    private Long id;

    public ProductNotFound(Long id, String message) {
        super(message);
        this.id = id;
    }
}
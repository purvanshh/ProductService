package in.purvanshh.projectservice.exceptionhandler;

import in.purvanshh.projectservice.dtos.ExceptionDTO;
import in.purvanshh.projectservice.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundsException() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFound(ProductNotFound productNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Invalid productId " + productNotFoundException.getId() + " passed");
        dto.setResolution("ProductNotFoundException caught");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
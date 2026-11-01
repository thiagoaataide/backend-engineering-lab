package dev.backendlab.lab001.product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/products/" + created.id())).body(created);
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return service.findAll();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(ProductNotFoundException exception) {
        return new ErrorResponse("PRODUCT_NOT_FOUND", exception.getMessage());
    }

    public record ErrorResponse(String code, String message) {}
}

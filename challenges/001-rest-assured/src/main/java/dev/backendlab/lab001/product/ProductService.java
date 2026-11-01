package dev.backendlab.lab001.product;

import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final Map<Long, ProductResponse> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public ProductResponse create(CreateProductRequest request) {
        long id = nextId.incrementAndGet();
        ProductResponse product = new ProductResponse(id, request.name(), request.price());
        products.put(id, product);
        return product;
    }

    public List<ProductResponse> findAll() {
        return products.values().stream()
                .sorted(Comparator.comparingLong(ProductResponse::id))
                .toList();
    }

    public ProductResponse findById(long id) {
        ProductResponse product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }
        return product;
    }
}

package dev.backendlab.lab001.product;

import java.math.BigDecimal;

public record ProductResponse(long id, String name, BigDecimal price) {}

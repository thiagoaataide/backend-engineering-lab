package dev.backendlab.lab001.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * LAB-001: escreva os testes de integração HTTP com REST Assured MockMvc.
 * A implementação foi deixada em aberto de propósito.
 */
class ProductControllerIT {

    @Test
    @DisplayName("TODO: criar produto válido retorna 201 e Location")
    void shouldCreateProduct() {
        // TODO: configurar o contexto de teste e executar POST /products.
    }

    @Test
    @DisplayName("TODO: consultar produto inexistente retorna 404")
    void shouldReturnNotFound() {
        // TODO: executar GET /products/{id} com um identificador ausente.
    }

    @Test
    @DisplayName("TODO: criar produto inválido retorna 400")
    void shouldRejectInvalidProduct() {
        // TODO: exercitar uma violação de Bean Validation.
    }
}

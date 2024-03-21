package com.example.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Interface é como uma classe sem implementacão de métodos, porém essa interface cria os métodos em RunTime
// Essa interface nos trás todos os métodos padrão do SQL: GetReferenceById, GetAllById, etc.
// Caso seja necessário criar querys mais complexas, é possível fazer elas aqui
public interface ProductRepository extends JpaRepository<Product, String> {
    // Dessa forma o Spring entende o contexto
    // Ele irá construir um query onde selecionará todos os itens da tabela onde o valor de Active seja true
    List<Product> findAllByActiveTrue();
}

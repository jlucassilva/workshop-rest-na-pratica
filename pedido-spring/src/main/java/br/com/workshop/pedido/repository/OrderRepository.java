package br.com.workshop.pedido.repository;

import br.com.workshop.pedido.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

package br.com.workshop.pedido.controller;

import br.com.workshop.pedido.model.entity.Order;
import br.com.workshop.pedido.model.vo.ErrorMessageDefault;
import br.com.workshop.pedido.model.vo.OrderOnlyAmountVO;
import br.com.workshop.pedido.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> listAll() {
        return repository.findAll();
    }

//    @GetMapping
//    public List<Order> allOrder(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
//        if (pageSize == 0) pageSize = 2;
//        return repository.findAll();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") String id) {
        Optional<Order> orderOptional = repository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return ResponseEntity.ok(order);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{client}")
    public List<Order> findByClient(@PathVariable("client") String client, @RequestParam("page") Integer page) {
        if (page == null) page = 0;

        Pageable pageable = PageRequest.of(page, 3);
        Slice<Order> byClient = repository.findByClient(client, pageable);
        return byClient.getContent();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Order order) {
        if (repository.findByClientAndProduct(order.client, order.product).size() > 0) {
            return ResponseEntity.badRequest().body(new ErrorMessageDefault("Bad Request", 44));
        }
        repository.save(order);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Order order) {
        repository.save(order);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity parcialUpdate(@PathVariable("id") String id, @RequestBody OrderOnlyAmountVO amountVo) {
        Optional<Order> orderOptional = repository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setAmount(amountVo.amount);
            repository.save(order);
            return ResponseEntity.ok(order);
        }

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

package br.com.sprj.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sprj.mvc.mudi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
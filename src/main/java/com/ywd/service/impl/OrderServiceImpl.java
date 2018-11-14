package com.ywd.service.impl;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ywd.entity.Order;
import com.ywd.repository.OrderRepository;
import com.ywd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service实现类
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public Order getByOrderNo(String orderNo) {
		return orderRepository.getByOrderNo(orderNo);
	}

	@Override
	public Order getById(Integer id) {
		return orderRepository.getOne(id);
	}

	@Override
	public List<Order> list(Order order, Integer page, Integer pageSize) {
		Pageable pageable=new PageRequest(page-1,pageSize, Sort.Direction.DESC,"buyTime");
		Page<Order> pageOrder = orderRepository.findAll(new Specification<Order>() {

			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				predicate.getExpressions().add(cb.equal(root.get("isPay"), 1));
				return predicate;
			}
		}, pageable);
		return pageOrder.getContent();
	}

	@Override
	public Long getCount(Order order) {
		return orderRepository.count(new Specification<Order>() {

			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				predicate.getExpressions().add(cb.equal(root.get("isPay"), 1));
				return predicate;
			}
		});
	}
}

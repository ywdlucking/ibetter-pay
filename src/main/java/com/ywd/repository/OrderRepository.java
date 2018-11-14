package com.ywd.repository;

import com.ywd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


/**
 * 订单Repository接口
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>,JpaSpecificationExecutor<Order>{

    @Query(value="select * from t_order where order_no=?1",nativeQuery=true)
    Order getByOrderNo(String orderNo);
}

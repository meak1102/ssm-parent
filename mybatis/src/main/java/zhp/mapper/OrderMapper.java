package zhp.mapper;

import org.apache.ibatis.annotations.Param;
import zhp.entity.Order;

/**
 * Created by 张华平 on 2017/8/4.
 */
public interface OrderMapper {
    /**
     * 查询出订单信息，并查询出下单人信息
     */
    public Order queryOrderandUserByOrderNumber(@Param("orderNumber") String orderNumber);
    /**
     * 查询订单，查询出下单人信息并且查询出订单详情。
     */
    public Order queryOrderAndUserAndOrderByOrderNumber(@Param("orderNumber") String orderNumber);

    /**
     * 查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
     */
    public Order queryOrderAndUserAndOrderdetailAndItem(@Param("orderNumber") String orderNumber);
}

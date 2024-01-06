package com.spring.projetinhoSpringBoot3.domain.usecase;

import com.spring.projetinhoSpringBoot3.domain.gateway.OrdersItemDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.gateway.ProductDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.gateway.UserDataBaseGateway;
import com.spring.projetinhoSpringBoot3.domain.model.OrderModel;
import com.spring.projetinhoSpringBoot3.domain.model.OrdersItemModel;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.domain.model.UserModel;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrderEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.OrdersItemEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.ProductEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.entity.UserEntity;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrderAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.OrdersItemAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.ProductAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.adapter.mapper.UserAdapterMapper;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.response.OrdersItemResponse;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrdersItemUseCaseImpl implements OrdersItemUseCase {

    @Autowired
    private OrdersItemAdapterMapper ordersItemAdapterMapper;
    @Autowired
    private OrdersItemDataBaseGateway ordersItemDataBaseGateway;
    @Autowired
    private ProductAdapterMapper productAdapterMapper;
    @Autowired
    private UserDataBaseGateway userDataBaseGateway;
    @Autowired
    private ProductDataBaseGateway productDataBaseGateway;
    @Autowired
    private UserAdapterMapper userAdapterMapper;
    @Autowired
    private OrderAdapterMapper orderAdapterMapper;

    @Override
    public OrdersItemModel createOrdersItem(OrderEntity orderEntity ,OrdersItemRequest ordersItemRequest,BigDecimal frete,int serviceCharge, BigDecimal discount, BigDecimal valueTotal,  BigDecimal valueTotalUser) {
        UserEntity userEntity;

        List<ProductEntity> productEntityList = new ArrayList<>();
        OrdersItemModel ordersItemModel = new OrdersItemModel();
        ordersItemModel =ordersItemAdapterMapper.toModel(ordersItemRequest);
        ordersItemModel.setValueTotalUser(valueTotalUser);
        ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
        OrdersItemEntity ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel);
        ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
        ProductEntity productEntity;
        for(var i = 0;i<ordersItemRequest.productModel().length;i++){
            productEntity = productAdapterMapper.toEntity(ordersItemRequest.productModel()[i]);
            productEntity.setOrdersItemEntity(ordersItemEntity);
            try {
                productDataBaseGateway.productSave(productEntity);
            }catch (RuntimeException e){
                System.out.println("falied to save product ");
            }
            productEntityList.add(productEntity);
        }
        UserModel userModel = ordersItemRequest.userModel();
        userEntity = userAdapterMapper.toEntity(userModel);
        userEntity.setOrdersItemEntity(ordersItemEntity);
        userDataBaseGateway.userSave(userEntity);

        return processOrdersItem(orderEntity,ordersItemRequest,frete,serviceCharge,discount,valueTotal,productEntityList,userEntity,valueTotalUser);
    }

/*
    @Override
    public List<OrdersItemModel> createOrdersItem(OrderEntity orderEntity,OrderRequest orderRequest, BigDecimal valueTotal) {
        OrdersItemModel ordersItemModel;
        List<OrdersItemRequest> ordersItemRequestList;
        BigDecimal valueTotalUser = BigDecimal.valueOf(0);
        List<OrdersItemModel> ordersItemModelList;
        OrdersItemEntity ordersItemEntity = ordersItemAdapterMapper.toEntity());
        for(var i=0;i<orderRequest.ordersItemRequestList().length;i++){
            getProductEntityList(ordersItemRequestList.get(i));
            ordersItemRequestList = Arrays.stream(orderRequest.ordersItemRequestList()).toList();
            valueTotalUser = calculateTotalValueUser(ordersItemRequestList.get(i));
            ordersItemModelList.add(processOrdersItem(
                    orderEntity,
                    orderRequest.ordersItemRequestList()[i],
                    orderRequest.frete(),
                    orderRequest.serviceCharge(),
                    orderRequest.discount(),
                    valueTotal,
                    getProductEntityList(ordersItemRequestList.get(i),ordersItemEntity),
                    userEntity,
                    valueTotalUser));
        }
        return null;
    }



    private List<ProductEntity> getProductEntityList(OrdersItemRequest ordersItemRequest,) {

        ProductEntity productEntity;
        for(var i = 0;i<ordersItemRequest.productModel().length;i++){
            productEntity = productAdapterMapper.toEntity(ordersItemRequest.productModel()[i]);
            productEntity.setOrdersItemEntity(ordersItemEntity);
            try {
                productDataBaseGateway.productSave(productEntity);
            }catch (RuntimeException e){
                System.out.println("falied to save product ");
            }
            productEntityList.add(productEntity);
        }

    }

 */

    public OrdersItemModel processOrdersItem(OrderEntity orderEntity,OrdersItemRequest ordersItemRequest, BigDecimal frete, int serviceCharge, BigDecimal discount, BigDecimal valueTotal,List<ProductEntity> productEntityList, UserEntity userEntity, BigDecimal valueTotalUser) {
        OrdersItemEntity ordersItemEntity;
        List<ProductModel> productModelList = new ArrayList<>();
        for(var i=0;i<productEntityList.size();i++){
            productModelList.add(productAdapterMapper.toModel(productEntityList.get(i)));
        }
        UserModel userModel = userAdapterMapper.toModel(userEntity);
        OrdersItemModel ordersItemModel = ordersItemAdapterMapper.toModel(ordersItemRequest);
        if(frete.compareTo(BigDecimal.ZERO)==0){
            if(serviceCharge==0){
                if (discount.compareTo(BigDecimal.ZERO)==0){
                    ordersItemModel.setValueTotalUser(valueTotalUser);
                    ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
                    ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel);
                    ordersItemEntity.setOrderEntity(orderEntity);
                    ordersItemEntity.setUserEntity(userEntity);
                    ordersItemEntity.setProductEntityList(productEntityList);
                    ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
                    ordersItemModel  = ordersItemAdapterMapper.toModel(ordersItemEntity,productModelList,userModel);
                    return ordersItemModel;
                }
                valueTotalUser = valueTotalUser.subtract(valueTotalUser.multiply(calculatePercentageDiscount(valueTotal,discount)));
                ordersItemModel.setValueTotalUser(valueTotalUser);
                ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
                ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
                ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
                return ordersItemModel;
            }
            if (discount.compareTo(BigDecimal.ZERO)==0){
                valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(BigDecimal.valueOf(serviceCharge)));
                ordersItemModel.setValueTotalUser(valueTotalUser);
                ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
                ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
                ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
                return ordersItemModel;
            }
            valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(BigDecimal.valueOf(serviceCharge)));
            valueTotalUser = valueTotalUser.subtract(valueTotalUser.multiply(calculatePercentageDiscount(valueTotal,discount)));
            ordersItemModel.setValueTotalUser(valueTotalUser);
            ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
            ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
            ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
            return ordersItemModel;
        }
        if(serviceCharge==0){
            if (discount.compareTo(BigDecimal.ZERO)==0){
                valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(calculatePercentageFrete(valueTotal,frete)));
                ordersItemModel.setValueTotalUser(valueTotalUser);
                ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
                ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
                ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
                return ordersItemModel;
            }

            valueTotalUser = valueTotalUser.subtract(valueTotalUser.multiply(calculatePercentageDiscount(valueTotal,discount)));
            valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(calculatePercentageFrete(valueTotal,valueTotalUser)));
            ordersItemModel.setValueTotalUser(valueTotalUser);
            ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
            ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
            ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
            return ordersItemModel;
        }
        if (discount.compareTo(BigDecimal.ZERO)==0){
            valueTotalUser.subtract(valueTotalUser.multiply(calculatePercentageDiscount(valueTotal,discount)));
            valueTotalUser.add(valueTotalUser.multiply(calculatePercentageFrete(valueTotal,valueTotalUser)));
            ordersItemModel.setValueTotalUser(valueTotalUser);
            ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
            ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
            ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
            return ordersItemModel;
        }
        valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(calculatePercentageFrete(valueTotal,frete)));
        valueTotalUser = valueTotalUser.add(valueTotalUser.multiply(BigDecimal.valueOf(serviceCharge)));
        valueTotalUser = valueTotalUser.subtract(valueTotalUser.multiply(calculatePercentageDiscount(valueTotal,discount)));
        ordersItemModel.setValueTotalUser(valueTotalUser);
        ordersItemModel.setUrlPayment(GenerationType.UUID.toString());
        ordersItemEntity = ordersItemAdapterMapper.toEntity(ordersItemModel,productEntityList,userEntity);
        ordersItemDataBaseGateway.ordersItemSave(ordersItemEntity);
        return ordersItemModel;
    }

    private BigDecimal calculatePercentageDiscount(BigDecimal valueTotal, BigDecimal discount) {
        int escala = 2;
        RoundingMode modoArredondamento = RoundingMode.HALF_UP;
        BigDecimal total;
        total = discount.multiply(BigDecimal.valueOf(100)).divide(valueTotal,escala,modoArredondamento);
        return total;
    }

    private BigDecimal calculatePercentageFrete(BigDecimal valueTotal, BigDecimal frete) {
        int escala = 2;
        RoundingMode modoArredondamento = RoundingMode.HALF_UP;
        BigDecimal total;
        total = frete.multiply(BigDecimal.valueOf(100)).divide(valueTotal,escala,modoArredondamento);
        return total;
    }

    public BigDecimal calculateTotalValueUser(OrdersItemRequest ordersItemRequest) {
        ProductModel productModel;
        BigDecimal subvalueTotalUser;
        BigDecimal valueTotalUser = BigDecimal.valueOf(0);
        for (var i = 0; i < ordersItemRequest.productModel().length; i++) {
            productModel = Arrays.stream(ordersItemRequest.productModel()).toList().get(i);
            BigDecimal valueProduct = productModel.getValueProduct();
            int quantity = productModel.getQuantity();
            subvalueTotalUser = valueProduct.multiply(BigDecimal.valueOf(quantity));
            valueTotalUser = valueTotalUser.add(subvalueTotalUser);
        }
        return valueTotalUser;
    }
}

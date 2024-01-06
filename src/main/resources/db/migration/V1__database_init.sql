CREATE SEQUENCE idt_order_table START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9999999999 ;
CREATE TABLE ORDER_TABLE (
    order_id                           NUMBERidt_order_table.NEXTVAL not null PRIMARY KEY (order_id),
    frete                              NUMBER(10, 2),
    taxa_de_servico                    NUMBER(10, 2),
    discount                           NUMBER(10, 2),
    value_total_order                  NUMBER(10, 2),
    orders_item_id                     NUMBER,
    FOREIGN KEY (orders_item_id)       REFERENCES ORDERS_ITEM_TABLE(orders_item_id)
);

CREATE SEQUENCE idt_orders_item_table START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9999999999 ;
CREATE TABLE ORDERS_ITEM_TABLE (
    orders_item_id                     NUMBER idt_orders_item_table.NEXTVAL not null PRIMARY KEY (orders_item_id),
    value_total_user                   NUMBER(10, 2) not null,
    url_payment                        VARCHAR2(255) not null,
    product_id                         NUMBER,
    user_id                            NUMBER,
    FOREIGN KEY (product_id)           REFERENCES PRODUCT_TABLE(product_id),
    FOREIGN KEY (user_id)              REFERENCES USER_TABLE(user_id)
);

CREATE SEQUENCE sq_user_table_idt START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9999999999 ;
CREATE TABLE USER_TABLE (
    user_id                         number sq_user_table_idt.NEXTVAL not null PRIMARY KEY (user_id),
    user_name                       VARCHAR2(255) not null,
    cpf                             VARCHAR2(255) not null,
    email                           VARCHAR2(255) not null,
    password                        VARCHAR2(255) not null
);

CREATE SEQUENCE idt_product_table START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9999999999 ;
CREATE TABLE PRODUCT_TABLE (
    product_id                         number idt_product_table.NEXTVAL not null PRIMARY KEY (product_id),
    product_name                       VARCHAR2(255) not null,
    quantity_product                   NUMBER(2),
    value_product                      NUMBER(10, 2) not null
);


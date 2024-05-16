import { OrderModel } from "../../../domain/models/order.model";

export interface IOrderService {
    list(): Promise<OrderModel[]>;
    create(product: OrderModel): Promise<OrderModel>;
    update(product: OrderModel): Promise<OrderModel>;
};
import { OrderModel } from '../../../domain/models/order.model';


export interface IOrderPersistencePort {
    list(): Promise<OrderModel[]>;
    create(order: OrderModel): Promise<OrderModel>;
    update(order: OrderModel): Promise<OrderModel>;
}
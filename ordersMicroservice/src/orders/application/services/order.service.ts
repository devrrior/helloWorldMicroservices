import { OrderModel } from '../../domain/models/order.model';
import { IOrderService } from '../ports/inputs/order.service.interface';
import { IOrderPersistencePort } from '../ports/outputs/orderPersistencePort.interface';

export class OrderService implements IOrderService {
    constructor(readonly portPersistance : IOrderPersistencePort) {}

    async list() {
        return await this.portPersistance.list();
    }
    async create(order: OrderModel) {
        return await this.portPersistance.create(order);
    }
    async update(order: OrderModel) {
        return await this.portPersistance.update(order);
    }
}
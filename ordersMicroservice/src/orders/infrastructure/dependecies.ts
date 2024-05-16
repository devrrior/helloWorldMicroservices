import { OrderService } from '../application/services/order.service';
import { OrderPersistanceAdapter } from './adapters/outputs/persistance/orderPersistenceAdapter';

const orderPersistanceAdapter: OrderPersistanceAdapter = new OrderPersistanceAdapter();

export const orderService = new OrderService(orderPersistanceAdapter);
import { prisma } from '../../../../../server';
import { IOrderPersistencePort } from '../../../../application/ports/outputs/orderPersistencePort.interface';
import { OrderModel } from '../../../../domain/models/order.model';

export class OrderPersistanceAdapter implements IOrderPersistencePort {

    async list() {
        return await prisma.order.findMany();
    }

    async create(order: OrderModel) {

        return await prisma.order.create({
            data: {
                total: order.total,
                status: order.status,
            }
        });

    }

    async update(order: OrderModel) {

        return await prisma.order.update({
            where: {
                id: order.id
            },
            data: {
                total: order.total,
                status: order.status,
            }
        });

    }

}
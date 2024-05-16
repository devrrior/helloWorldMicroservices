import { Request, Response, Router } from "express";
import { orderService } from "../../../dependecies";
import { BaseResponse } from "../models/baseResponse";
import { OrderModel } from "../../../../domain/models/order.model";

export const router = Router();

router.get('/', async (req: Request, res: Response) => {
  const products = await orderService.list();
  const response = new BaseResponse(products, 'Products listed successfully', true, 200);

  res.status(response.httpStatus).json(response);
});

router.post('/', async (req: Request, res: Response) => {
  const {total, status } = req.body;

  const orderModel = new OrderModel('', total, new Date(), status);

  const product = await orderService.create(orderModel);
  const response = new BaseResponse(product, 'Product created successfully', true, 201);

  res.status(response.httpStatus).json(response);
});

router.put('/:id', async (req: Request, res: Response) => {
  const { id } = req.params;
  const { total, status } = req.body;

  const orderModel = new OrderModel(id, total, new Date(), status);

  const product = await orderService.update(orderModel);
  const response = new BaseResponse(product, 'Product updated successfully', true, 200);

  res.status(response.httpStatus).json(response);
});
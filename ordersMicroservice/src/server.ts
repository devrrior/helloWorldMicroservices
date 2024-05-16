import express from 'express';
import morgan from 'morgan';
import { PrismaClient } from '@prisma/client'
import { router as productRouter } from './orders/infrastructure/adapters/inputs/rest/productRestAdapter';

export const prisma = new PrismaClient();

const app = express();

const port = process.env.PORT || 3000;

const morganConfig = morgan(':method :url :status :res[content-length] - :response-time ms');

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(morganConfig);

app.use('/api/orders', productRouter);

app.get('/', (req, res) => {
  res.json({ message: 'Hello from Orders Microservice' });
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
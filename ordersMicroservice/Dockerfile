FROM node:20.13-alpine3.19

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

RUN npx prisma generate --schema ./prisma/schema.prisma

CMD ["npm", "run", "start"]
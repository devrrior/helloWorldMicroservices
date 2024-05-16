export class OrderModel {
    id: string;
    total: number;
    date: Date;
    status: string;

    constructor(id: string, total: number, date: Date, status: string) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.status = status;
    }

}
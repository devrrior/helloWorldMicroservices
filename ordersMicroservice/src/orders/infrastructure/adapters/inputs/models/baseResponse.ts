export class BaseResponse {
  data: object;
  message: string;
  success: boolean;
  httpStatus: number;

  constructor(data: any, message: string, success: boolean, httpStatus: number) {
    this.data = data;
    this.message = message;
    this.success = success;
    this.httpStatus = httpStatus;
  }
}
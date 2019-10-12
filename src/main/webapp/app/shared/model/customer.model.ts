export interface ICustomer {
  id?: number;
  name?: string;
  address?: string;
  phone?: string;
  email?: string;
}

export class Customer implements ICustomer {
  constructor(public id?: number, public name?: string, public address?: string, public phone?: string, public email?: string) {}
}

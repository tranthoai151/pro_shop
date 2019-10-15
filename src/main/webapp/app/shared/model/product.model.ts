import { ICategory } from 'app/entities/category/category.model';

export interface IProduct {
  id?: number;
  name?: string;
  category?: ICategory;
  price?: string;
  img?: string;
  description?: string;
}

export class Product implements IProduct {
  constructor(
    public id?: number,
    public name?: string,
    public category?: ICategory,
    public price?: string,
    public img?: string,
    public description?: string
  ) {}
}

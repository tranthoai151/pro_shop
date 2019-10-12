export interface ICategory {
  categoryId?: any;
  name?: string;
  description?: string;
  status?: any;
}

export class Category implements ICategory {
  constructor(public categoryId?: any, public name?: string, public description?: string, public status?: any) {
    this.categoryId = categoryId ? categoryId : null;
    this.name = name ? name : null;
    this.description = description ? description : null;
    this.status = status ? status : null;
  }
}

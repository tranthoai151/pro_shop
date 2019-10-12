import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes } from '@angular/router';
import { CategoryService } from 'app/core/category/category.service';
import { Category } from 'app/core/category/category.model';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { CategoryManagementComponent } from 'app/admin/categories/category-management.component';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class CategoryMgmt implements Resolve<any> {
  constructor(private service: CategoryService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params['category'] ? route.params['category'] : null;
    if (id) {
      return this.service.find(id);
    }
    return new Category();
  }
}

export const categoryMgmRoute: Routes = [
  {
    path: 'catergory-management',
    component: CategoryManagementComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      pageTitle: 'Categories',
      defaultSort: 'id,asc'
    }
  }
];

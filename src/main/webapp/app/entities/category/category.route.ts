import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes } from '@angular/router';
import { CategoryService } from 'app/entities/category/category.service';
import { Category } from 'app/entities/category/category.model';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { CategoryComponent } from 'app/entities/category/category.component';
import { Injectable } from '@angular/core';
import { UserRouteAccessService } from 'app/core';

@Injectable({ providedIn: 'root' })
export class CategoryResolve implements Resolve<any> {
  constructor(private service: CategoryService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params['category'] ? route.params['category'] : null;
    if (id) {
      return this.service.find(id);
    }
    return new Category();
  }
}

export const categoryRoute: Routes = [
  {
    path: '',
    component: CategoryComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'Categories'
    },
    canActivate: [UserRouteAccessService]
  }
];

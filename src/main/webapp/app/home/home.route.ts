import { ActivatedRouteSnapshot, Resolve, Route, RouterStateSnapshot } from '@angular/router';

import { CustomComponent } from 'app/home/custom.component';
import { Injectable } from '@angular/core';
import { Customer, ICustomer } from 'app/shared/model/customer.model';
import { CustomerService } from 'app/entities/customer';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { IProduct, Product } from 'app/shared/model/product.model';
import { ProductService } from 'app/home/custom.service';
import { JhiResolvePagingParams } from 'ng-jhipster';

@Injectable({ providedIn: 'root' })
export class CustomResolve implements Resolve<IProduct> {
  constructor(private service: ProductService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IProduct> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Product>) => response.ok),
        map((product: HttpResponse<Product>) => product.body)
      );
    }
    return of(new Customer());
  }
}

export const HOME_ROUTE: Route = {
  path: '',
  component: CustomComponent,
  resolve: {
    pagingParams: JhiResolvePagingParams
  },
  data: {
    authorities: [],
    defaultSort: 'id,asc',
    pageTitle: 'Products'
  }
};

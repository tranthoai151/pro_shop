import { Component, OnDestroy, OnInit } from '@angular/core';
import { IProduct, Product } from 'app/shared/model/product.model';
import { JhiAlertService, JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { AccountService } from 'app/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductService } from 'app/home/custom.service';
import { ITEMS_PER_PAGE } from 'app/shared';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-custom',
  templateUrl: './custom.component.html',
  styleUrls: ['custom.scss']
})
export class CustomComponent implements OnInit, OnDestroy {
  products: Product[];
  error: any;
  success: any;
  routeData: any;
  links: any;
  totalItems: any;
  itemsPerPage: any;
  page: any;
  predicate: any;
  previousPage: any;
  reverse: any;

  constructor(
    private productService: ProductService,
    private alertService: JhiAlertService,
    private accountService: AccountService,
    private parseLinks: JhiParseLinks,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private eventManager: JhiEventManager,
    private modalService: NgbModal
  ) {
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.routeData = this.activatedRoute.data.subscribe(data => {
      this.page = data.pagingParams.page;
      this.previousPage = data.pagingParams.page;
      this.reverse = data.pagingParams.ascending;
      this.predicate = data.pagingParams.predicate;
    });
  }
  ngOnDestroy(): void {}

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.productService
      .getProducts({
        page: 0,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<IProduct[]>) => this.onSuccess(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  sort() {
    const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  private onSuccess(data, headers) {
    this.links = this.parseLinks.parse(headers.get('link'));
    this.totalItems = headers.get('X-Total-Count');
    this.products = data;
    this.hardCodeImg(this.products);
    console.log(this.products);
  }
  private onError(error) {
    this.alertService.error(error.error, error.message, null);
  }

  loadPage(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }
  transition() {
    this.router.navigate(['/p/products'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.reverse ? 'asc' : 'desc')
      }
    });
    this.loadAll();
  }

  hardCodeImg(products: Product[]) {
    products.forEach(p => {
      switch (p.id) {
        case 1: {
          p.img = '../../content/images/products/chaca.jpg';
          break;
        }
        case 3: {
          p.img = '../../content/images/products/canuc.jpg';
          break;
        }
        case 4: {
          p.img = '../../content/images/products/nuocmamnguyenchat.jpg';
          break;
        }
        case 5: {
          p.img = '../../content/images/products/mamcacom.jpg';
          break;
        }
        default: {
          p.img = 'http://placehold.it/700x400';
          break;
        }
      }
    });
  }
}

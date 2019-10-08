import { Component, OnDestroy, OnInit } from '@angular/core';
import { Category } from 'app/core/category/category.model';
import { AccountService, User, UserService } from 'app/core';
import { JhiAlertService, JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ITEMS_PER_PAGE } from 'app/shared';
import { CategoryService } from 'app/core/category/category.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'category-mgmt',
  templateUrl: './category-management.component.html'
})
export class CategoryManagementComponent implements OnInit, OnDestroy {
  categories: Category[];
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
    private categoryService: CategoryService,
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
      this.page = data['pagingParams'].page;
      this.previousPage = data['pagingParams'].page;
      this.reverse = data['pagingParams'].ascending;
      this.predicate = data['pagingParams'].predicate;
    });
  }
  ngOnDestroy(): void {}

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.categoryService
      .searchCategories({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<Category[]>) => this.onSuccess(res.body, res.headers),
        (res: HttpResponse<any>) => this.onError(res.body)
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
    this.categories = data;
  }
  private onError(error) {
    this.alertService.error(error.error, error.message, null);
  }
}

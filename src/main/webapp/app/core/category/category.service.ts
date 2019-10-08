import { SERVER_API_URL } from 'app/app.constants';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICategory } from 'app/core/category/category.model';
import { createRequestOption } from 'app/shared';
import { IUser } from 'app/core';

@Injectable({ providedIn: 'root' })
export class CategoryService {
  public resourceUrl = SERVER_API_URL + 'api/users';

  constructor(private http: HttpClient) {}

  searchCategories(req?: any): Observable<HttpResponse<ICategory[]>> {
    const options = createRequestOption(req);
    return this.http.get<ICategory[]>(this.resourceUrl, { params: options, observe: 'response' });
  }
}

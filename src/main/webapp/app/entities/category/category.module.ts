import { categoryRoute } from 'app/entities/category/category.route';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { MyProSharedModule } from 'app/shared';
import { RouterModule } from '@angular/router';
import { CategoryComponent } from 'app/entities/category/category.component';

const ENTITY_STATES = [...categoryRoute];

@NgModule({
  imports: [MyProSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [CategoryComponent],
  entryComponents: [CategoryComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyProCategoryModule {}

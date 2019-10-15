import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyProSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from './';
import { CustomComponent } from 'app/home/custom.component';

@NgModule({
  imports: [MyProSharedModule, RouterModule.forChild([HOME_ROUTE])],
  // declarations: [HomeComponent],
  declarations: [CustomComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyProHomeModule {}

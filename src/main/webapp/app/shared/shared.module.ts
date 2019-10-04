import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MyProSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [MyProSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [MyProSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyProSharedModule {
  static forRoot() {
    return {
      ngModule: MyProSharedModule
    };
  }
}

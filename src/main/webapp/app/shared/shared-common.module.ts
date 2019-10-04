import { NgModule } from '@angular/core';

import { MyProSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [MyProSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [MyProSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class MyProSharedCommonModule {}

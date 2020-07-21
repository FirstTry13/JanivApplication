import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule  } from "@angular/common/http";
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatToolbarModule } from  '@angular/material/toolbar';
import { MatCardModule } from  '@angular/material/card';
import { MatButtonModule } from  '@angular/material/button';  

import { environment } from '../environments/environment';
import { ServiceWorkerModule } from  '@angular/service-worker';
import { AlertComponent } from './_components/alert/alert.component';


import { JwtInterceptor, ErrorInterceptor} from './_helpers';

import { HomeComponent } from './home';

// used to create fake backend
/*import { fakeBackendProvider } from './_helpers'; */

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,    
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    ServiceWorkerModule.register('/ngsw-worker.js', { enabled:  environment.production })
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
    
    // provider used to create fake backend
    /*, fakeBackendProvider */
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

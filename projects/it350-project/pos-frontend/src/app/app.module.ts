import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatNativeDateModule} from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import {HttpClientModule} from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';
import {MatMenuModule} from '@angular/material/menu';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSortModule} from '@angular/material/sort';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {CrudPageComponent} from './crud-page/crud-page.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';
import { AddProductComponent } from './crud-page/dialogs/add-product/add-product.component';
import { EditProductComponent } from './crud-page/dialogs/edit-product/edit-product.component';
import { DeleteDialogComponent } from './crud-page/dialogs/delete-dialog/delete-dialog.component';
import { CrudAddressComponent } from './address/crud-address/crud-address.component';
import { CrudCashRegisterComponent } from './cashRegister/crud-cash-register/crud-cash-register.component';
import { CrudDeliveryComponent } from './delivery/crud-delivery/crud-delivery.component';
import { CrudDeliveryProductComponent } from './deliveryProduct/crud-delivery-product/crud-delivery-product.component';
import { CrudProcurementComponent } from './procurement/crud-procurement/crud-procurement.component';
import { CrudProductTypeComponent } from './productType/crud-product-type/crud-product-type.component';
import { CrudRetailStoreComponent } from './retailStore/crud-retail-store/crud-retail-store.component';
import { CrudRoleComponent } from './role/crud-role/crud-role.component';
import { CrudSupplierComponent } from './supplier/crud-supplier/crud-supplier.component';
import { CrudUserComponent } from './user/crud-user/crud-user.component';
import { AddAddressComponent } from './address/crud-address/dialogs/add-address/add-address.component';
import { EditAddressComponent } from './address/crud-address/dialogs/edit-address/edit-address.component';
import { DeleteAddressComponent } from './address/crud-address/dialogs/delete-address/delete-address.component';
import { AddCashRegisterComponent } from './cashRegister/crud-cash-register/dialogs/add-cash-register/add-cash-register.component';
import { EditCashRegisterComponent } from './cashRegister/crud-cash-register/dialogs/edit-cash-register/edit-cash-register.component';
import { DeleteCashRegisterComponent } from './cashRegister/crud-cash-register/dialogs/delete-cash-register/delete-cash-register.component';
import { AddDeliveryComponent } from './delivery/crud-delivery/dialogs/add-delivery/add-delivery.component';
import { EditDeliveryComponent } from './delivery/crud-delivery/dialogs/edit-delivery/edit-delivery.component';
import { DeleteDeliveryComponent } from './delivery/crud-delivery/dialogs/delete-delivery/delete-delivery.component';
import { AddDeliveryProductComponent } from './deliveryProduct/crud-delivery-product/dialogs/add-delivery-product/add-delivery-product.component';
import { EditDeliveryProductComponent } from './deliveryProduct/crud-delivery-product/dialogs/edit-delivery-product/edit-delivery-product.component';
import { DeleteDeliveryProductComponent } from './deliveryProduct/crud-delivery-product/dialogs/delete-delivery-product/delete-delivery-product.component';
import { AddProcurementComponent } from './procurement/crud-procurement/dialogs/add-procurement/add-procurement.component';
import { EditProcurementComponent } from './procurement/crud-procurement/dialogs/edit-procurement/edit-procurement.component';
import { DeleteProcurementComponent } from './procurement/crud-procurement/dialogs/delete-procurement/delete-procurement.component';
import { AddProductTypeComponent } from './productType/crud-product-type/dialogs/add-product-type/add-product-type.component';
import { EditProductTypeComponent } from './productType/crud-product-type/dialogs/edit-product-type/edit-product-type.component';
import { DeleteProductTypeComponent } from './productType/crud-product-type/dialogs/delete-product-type/delete-product-type.component';
import { AddRetailStoreComponent } from './retailStore/crud-retail-store/dialogs/add-retail-store/add-retail-store.component';
import { EditRetailStoreComponent } from './retailStore/crud-retail-store/dialogs/edit-retail-store/edit-retail-store.component';
import { DeleteRetailStoreComponent } from './retailStore/crud-retail-store/dialogs/delete-retail-store/delete-retail-store.component';
import { AddRoleComponent } from './role/crud-role/dialogs/add-role/add-role.component';
import { EditRoleComponent } from './role/crud-role/dialogs/edit-role/edit-role.component';
import { DeleteRoleComponent } from './role/crud-role/dialogs/delete-role/delete-role.component';
import { AddSupplierComponent } from './supplier/crud-supplier/dialogs/add-supplier/add-supplier.component';
import { EditSupplierComponent } from './supplier/crud-supplier/dialogs/edit-supplier/edit-supplier.component';
import { DeleteSupplierComponent } from './supplier/crud-supplier/dialogs/delete-supplier/delete-supplier.component';
import { AddUserComponent } from './user/crud-user/dialogs/add-user/add-user.component';
import { EditUserComponent } from './user/crud-user/dialogs/edit-user/edit-user.component';
import { DeleteUserComponent } from './user/crud-user/dialogs/delete-user/delete-user.component';
import {RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  {path: "", component: CrudPageComponent},
  {path: "address", component: CrudAddressComponent},
  {path: "cashRegister", component: CrudCashRegisterComponent},
  {path: "delivery", component: CrudDeliveryComponent},
  {path: "deliveryProduct", component: CrudDeliveryProductComponent},
  {path: "procurement", component: CrudProcurementComponent},
  {path: "productType", component: CrudProductTypeComponent},
  {path: "role", component: CrudRoleComponent},
  {path: "supplier", component: CrudSupplierComponent},
  {path: "retailStore", component: CrudRetailStoreComponent},
  {path: "user", component: CrudUserComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CrudPageComponent,
    AddProductComponent,
    EditProductComponent,
    DeleteDialogComponent,
    CrudAddressComponent,
    CrudCashRegisterComponent,
    CrudDeliveryComponent,
    CrudDeliveryProductComponent,
    CrudProcurementComponent,
    CrudProductTypeComponent,
    CrudRetailStoreComponent,
    CrudRoleComponent,
    CrudSupplierComponent,
    CrudUserComponent,
    AddAddressComponent,
    EditAddressComponent,
    DeleteAddressComponent,
    AddCashRegisterComponent,
    EditCashRegisterComponent,
    DeleteCashRegisterComponent,
    AddDeliveryComponent,
    EditDeliveryComponent,
    DeleteDeliveryComponent,
    AddDeliveryProductComponent,
    EditDeliveryProductComponent,
    DeleteDeliveryProductComponent,
    AddProcurementComponent,
    EditProcurementComponent,
    DeleteProcurementComponent,
    AddProductTypeComponent,
    EditProductTypeComponent,
    DeleteProductTypeComponent,
    AddRetailStoreComponent,
    EditRetailStoreComponent,
    DeleteRetailStoreComponent,
    AddRoleComponent,
    EditRoleComponent,
    DeleteRoleComponent,
    AddSupplierComponent,
    EditSupplierComponent,
    DeleteSupplierComponent,
    AddUserComponent,
    EditUserComponent,
    DeleteUserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatSidenavModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    MatSnackBarModule,
    MatMenuModule,
    MatSelectModule,
    MatRadioModule,
    MatDatepickerModule,
    MatSortModule,
    MatStepperModule,
    MatTabsModule,
    MatTooltipModule,
    RouterModule.forRoot(appRoutes)
  ], entryComponents: [
    AddProductComponent,
    EditProductComponent,
    DeleteDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductServicesService} from '../../../../crud-services/product-services-service';
import {ProductTypeServiceService} from '../../../../crud-services/productType-service-service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  productTypeList: any[] = [];
  product: any;
  products: any[] = [];

  form = new FormGroup({
    name: new FormControl(),
    productType: new FormControl(),
    price: new FormControl(),
    stock: new FormControl()
  });

  constructor(private productService: ProductServicesService, private productTypeService: ProductTypeServiceService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<EditProductComponent>, @Inject(MAT_DIALOG_DATA) public data) {
    this.product = data;
  }

  ngOnInit(): void {
    this.getAllProductTypes();
    this.form.get('name').setValue(this.product.name);
    this.form.get('productType').setValue(this.product.productType);
    this.form.get('price').setValue(this.product.price);
    this.form.get('stock').setValue(this.product.stock);
  }

  close() {
    this.dialogRef.close(true);
  }

  getAllProductTypes(){
    this.productTypeService.getAllProductTypes().subscribe(data => {
      this.productTypeList = data;
    });
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAllProducts(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  editProduct() {
    const product = this.form.value;
    product.id = this.data.id;
    this.productService.editProduct(product).subscribe(() => {
      this.getAllProducts();
      this.close();
      this.openSnackBar("Successfully edited product", "Close");
    }, err => {
      this.openSnackBar(err.error.message, "Close");
    });
  }

  compareProductType(productType1: any, productType2: any): boolean {
    if (!productType1 || !productType2) {
      return false;
    }
    return productType1.id === productType2.id;
  }
}

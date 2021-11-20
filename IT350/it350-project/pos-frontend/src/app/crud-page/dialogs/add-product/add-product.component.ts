import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductServicesService} from '../../../../crud-services/product-services-service';
import {ProductTypeServiceService} from '../../../../crud-services/productType-service-service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  productTypeList: any[] = [];

  form = new FormGroup({
    name: new FormControl(),
    productType: new FormControl(),
    price: new FormControl(),
    stock: new FormControl()
  });

  constructor(private productService: ProductServicesService, private productTypeService: ProductTypeServiceService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<AddProductComponent>) { }

  ngOnInit(): void {
    this.getAllProductTypes();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  close() {
    this.dialogRef.close(true);
  }

  getAllProductTypes(){
    this.productTypeService.getAllProductTypes().subscribe(data => {
      this.productTypeList = data;
    });
  }

  addProduct(): void {
    this.productService.addProduct(this.form.value).subscribe(() => {
      this.openSnackBar("Successfully added product", "Close");
      this.close();
    }, err => {
      this.openSnackBar(err.error.message, "Close");
    });
  }
}

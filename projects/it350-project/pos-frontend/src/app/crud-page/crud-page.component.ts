import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {ProductServicesService} from '../../crud-services/product-services-service';
import {AddProductComponent} from './dialogs/add-product/add-product.component';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {EditProductComponent} from './dialogs/edit-product/edit-product.component';
import {DeleteDialogComponent} from './dialogs/delete-dialog/delete-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import {filterProducts} from '../../utils/filterUtil';

@Component({
  selector: 'app-crud-page',
  templateUrl: './crud-page.component.html',
  styleUrls: ['./crud-page.component.css']
})
export class CrudPageComponent implements OnInit {
  displayedColumns: string[] = ['name', 'productType', 'price', 'stock', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  products: any[] = [];

  constructor(private productService: ProductServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAllProducts(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
      this.dataSource.data = this.products;
    });
  }

  openAddProductDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddProductComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAllProducts();
    });
  }


  openEditDialog(product): void {
    const dialogRef = this.dialog.open(EditProductComponent, {
      width: '300px',
      backdropClass: 'background',
      data: product
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAllProducts();
      }
    });
  }

  openDeleteDialog(id: number): void {
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.productService.deleteProduct(id).subscribe(() => {
            this.openSnackBar('Successfully deleted product', 'Close');
            this.getAllProducts();
          }, err => {
            this.openSnackBar(err.error.message, 'Close');
          });
        } else if (result === 'no') {
          this.dialog.closeAll();
        }
      }
    });
  }

  searchProduct(inputPar: string) {
    if (inputPar) {
      this.dataSource.data = this.products.filter(item => filterProducts(item, inputPar));
    } else {
      this.dataSource.data = this.products;
    }
  }
}

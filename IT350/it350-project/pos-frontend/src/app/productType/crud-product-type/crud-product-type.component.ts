import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {RoleServicesService} from '../../../crud-services/role-services-service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {AddRoleComponent} from '../../role/crud-role/dialogs/add-role/add-role.component';
import {EditRoleComponent} from '../../role/crud-role/dialogs/edit-role/edit-role.component';
import {DeleteRoleComponent} from '../../role/crud-role/dialogs/delete-role/delete-role.component';
import {ProductTypeServiceService} from '../../../crud-services/productType-service-service';
import {AddProductTypeComponent} from './dialogs/add-product-type/add-product-type.component';
import {EditProductTypeComponent} from './dialogs/edit-product-type/edit-product-type.component';
import {DeleteProductTypeComponent} from './dialogs/delete-product-type/delete-product-type.component';

@Component({
  selector: 'app-crud-product-type',
  templateUrl: './crud-product-type.component.html',
  styleUrls: ['./crud-product-type.component.css']
})
export class CrudProductTypeComponent implements OnInit {

  displayedColumns: string[] = ['name', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  genericObjects: any[] = [];

  constructor(private productType: ProductTypeServiceService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAll();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAll(): void {
    this.productType.getAllProductTypes().subscribe(data => {
      this.genericObjects = data;
      this.dataSource.data = this.genericObjects;
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddProductTypeComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAll();
    });
  }


  openEditDialog(object): void {
    const dialogRef = this.dialog.open(EditProductTypeComponent, {
      width: '300px',
      backdropClass: 'background',
      data: object
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAll();
      }
    });
  }

  openDeleteDialog(id: number): void {
    const dialogRef = this.dialog.open(DeleteProductTypeComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.productType.delete(id).subscribe(() => {
            this.openSnackBar('Successfully deleted role', 'Close');
            this.getAll();
          }, err => {
            this.openSnackBar(err.error.message, 'Close');
          });
        } else if (result === 'no') {
          this.dialog.closeAll();
        }
      }
    });
  }

}

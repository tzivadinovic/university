import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {RoleServicesService} from '../../../crud-services/role-services-service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {AddRoleComponent} from '../../role/crud-role/dialogs/add-role/add-role.component';
import {EditRoleComponent} from '../../role/crud-role/dialogs/edit-role/edit-role.component';
import {DeleteRoleComponent} from '../../role/crud-role/dialogs/delete-role/delete-role.component';
import {SupplierServicesService} from '../../../crud-services/supplier-services-service';
import {AddSupplierComponent} from './dialogs/add-supplier/add-supplier.component';
import {EditSupplierComponent} from './dialogs/edit-supplier/edit-supplier.component';
import {DeleteSupplierComponent} from './dialogs/delete-supplier/delete-supplier.component';

@Component({
  selector: 'app-crud-supplier',
  templateUrl: './crud-supplier.component.html',
  styleUrls: ['./crud-supplier.component.css']
})
export class CrudSupplierComponent implements OnInit {

  displayedColumns: string[] = ['name', 'email', 'address', 'phoneNumber', 'contactPerson', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  genericObjects: any[] = [];

  constructor(private supplierServices: SupplierServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAll();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAll(): void {
    this.supplierServices.getAll().subscribe(data => {
      this.genericObjects = data;
      this.dataSource.data = this.genericObjects;
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddSupplierComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAll();
    });
  }


  openEditDialog(object): void {
    const dialogRef = this.dialog.open(EditSupplierComponent, {
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
    const dialogRef = this.dialog.open(DeleteSupplierComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.supplierServices.delete(id).subscribe(() => {
            this.openSnackBar('Successfully deleted supplier', 'Close');
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

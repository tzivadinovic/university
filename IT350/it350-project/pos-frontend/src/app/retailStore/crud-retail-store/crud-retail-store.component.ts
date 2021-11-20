import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {DeleteAddressComponent} from '../../address/crud-address/dialogs/delete-address/delete-address.component';
import {RetailStoreServicesService} from '../../../crud-services/retailStore-services-service';
import {AddRetailStoreComponent} from './dialogs/add-retail-store/add-retail-store.component';
import {EditRetailStoreComponent} from './dialogs/edit-retail-store/edit-retail-store.component';

@Component({
  selector: 'app-crud-retail-store',
  templateUrl: './crud-retail-store.component.html',
  styleUrls: ['./crud-retail-store.component.css']
})
export class CrudRetailStoreComponent implements OnInit {

  displayedColumns: string[] = ['taxId', 'name', 'workCode', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  retailStores: any[] = [];

  constructor(private retailStoreServices: RetailStoreServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAll();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAll(): void {
    this.retailStoreServices.getAll().subscribe(data => {
      this.retailStores = data;
      this.dataSource.data = this.retailStores;
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddRetailStoreComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAll();
    });
  }


  openEditDialog(object): void {
    const dialogRef = this.dialog.open(EditRetailStoreComponent, {
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
    const dialogRef = this.dialog.open(DeleteAddressComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.retailStoreServices.delete(id).subscribe(() => {
            this.openSnackBar('Successfully deleted retail store', 'Close');
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

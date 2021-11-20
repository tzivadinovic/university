import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {AddAddressComponent} from './dialogs/add-address/add-address.component';
import {EditAddressComponent} from './dialogs/edit-address/edit-address.component';
import {DeleteAddressComponent} from './dialogs/delete-address/delete-address.component';
import {AddressServicesService} from '../../../crud-services/address-services-service';

@Component({
  selector: 'app-crud-address',
  templateUrl: './crud-address.component.html',
  styleUrls: ['./crud-address.component.css']
})
export class CrudAddressComponent implements OnInit {
  displayedColumns: string[] = ['municipality', 'city', 'streetName', 'streetNumber', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  addresses: any[] = [];

  constructor(private addressServices: AddressServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllAddresses();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAllAddresses(): void {
    this.addressServices.getAllAddresses().subscribe(data => {
      this.addresses = data;
      this.dataSource.data = this.addresses;
    });
  }

  openAddAddressDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddAddressComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAllAddresses();
    });
  }


  openEditDialog(address): void {
    const dialogRef = this.dialog.open(EditAddressComponent, {
      width: '300px',
      backdropClass: 'background',
      data: address
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAllAddresses();
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
          this.addressServices.deleteAddress(id).subscribe(() => {
            this.openSnackBar('Successfully deleted address', 'Close');
            this.getAllAddresses();
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

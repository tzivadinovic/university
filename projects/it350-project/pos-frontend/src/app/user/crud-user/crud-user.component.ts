import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {UserServicesService} from '../../../crud-services/user-services-service';
import {AddUserComponent} from './dialogs/add-user/add-user.component';
import {EditUserComponent} from './dialogs/edit-user/edit-user.component';
import {DeleteUserComponent} from './dialogs/delete-user/delete-user.component';

@Component({
  selector: 'app-crud-user',
  templateUrl: './crud-user.component.html',
  styleUrls: ['./crud-user.component.css']
})
export class CrudUserComponent implements OnInit {

  displayedColumns: string[] = ['firstname', 'lastname', 'address', 'username', 'role', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  genericObjects: any[] = [];

  constructor(private userServices: UserServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAll();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAll(): void {
    this.userServices.getAll().subscribe(data => {
      this.genericObjects = data;
      this.dataSource.data = this.genericObjects;
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddUserComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAll();
    });
  }


  openEditDialog(object): void {
    const dialogRef = this.dialog.open(EditUserComponent, {
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
    const dialogRef = this.dialog.open(DeleteUserComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.userServices.delete(id).subscribe(() => {
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

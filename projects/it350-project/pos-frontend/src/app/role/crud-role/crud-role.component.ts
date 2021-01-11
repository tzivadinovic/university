import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {RoleServicesService} from '../../../crud-services/role-services-service';
import {AddRoleComponent} from './dialogs/add-role/add-role.component';
import {EditRoleComponent} from './dialogs/edit-role/edit-role.component';
import {DeleteRoleComponent} from './dialogs/delete-role/delete-role.component';

@Component({
  selector: 'app-crud-role',
  templateUrl: './crud-role.component.html',
  styleUrls: ['./crud-role.component.css']
})
export class CrudRoleComponent implements OnInit {

  displayedColumns: string[] = ['role', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  genericObjects: any[] = [];

  constructor(private roleServices: RoleServicesService, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAll();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAll(): void {
    this.roleServices.getAll().subscribe(data => {
      this.genericObjects = data;
      this.dataSource.data = this.genericObjects;
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '300px';
    this.dialog.open(AddRoleComponent, dialogConfig).afterClosed().subscribe( () => {
      this.getAll();
    });
  }


  openEditDialog(object): void {
    const dialogRef = this.dialog.open(EditRoleComponent, {
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
    const dialogRef = this.dialog.open(DeleteRoleComponent, {
      width: '300px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'yes') {
          this.roleServices.delete(id).subscribe(() => {
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

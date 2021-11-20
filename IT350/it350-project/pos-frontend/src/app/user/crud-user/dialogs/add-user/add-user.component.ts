import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {AddressServicesService} from '../../../../../crud-services/address-services-service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogRef} from '@angular/material/dialog';
import {RoleServicesService} from '../../../../../crud-services/role-services-service';
import {UserServicesService} from '../../../../../crud-services/user-services-service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  addresses: any[] = [];
  roles: any[] = [];


  form = new FormGroup({
    firstname: new FormControl(),
    lastname: new FormControl(),
    address: new FormControl(),
    username: new FormControl(),
    role: new FormControl()
  });

  constructor(private addressServices: AddressServicesService, private userServices: UserServicesService, private roleService: RoleServicesService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<AddUserComponent>) {
  }

  ngOnInit(): void {
    this.getAllAddresses();
    this.getAllRoles();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  close() {
    this.dialogRef.close(true);
  }

  getAllAddresses(): void {
    this.addressServices.getAllAddresses().subscribe(data => {
      this.addresses = data;
    });
  }

  getAllRoles(): void {
    this.roleService.getAll().subscribe(data => {
      this.roles = data;
    });
  }

  addUser(): void {
    if (this.form.invalid) {
      this.openSnackBar('Invalid form', 'Zatvori');
    } else {
      const user: any = {
        id: 0,
        firstname: this.form.get('firstname').value,
        lastname: this.form.get('lastname').value,
        username: this.form.get('username').value,
        address: this.form.get('address').value,
        role: this.form.get('role').value,
      };
      this.userServices.add(user).subscribe(() => {
        this.openSnackBar("Successfully added user", "Close");
        this.close();
      });
    }
  }
}

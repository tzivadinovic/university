import {Component, Inject, OnInit} from '@angular/core';
import {AddressServicesService} from '../../../../../crud-services/address-services-service';
import {UserServicesService} from '../../../../../crud-services/user-services-service';
import {RoleServicesService} from '../../../../../crud-services/role-services-service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  addresses: any[] = [];
  roles: any[] = [];
  user: any;

  form = new FormGroup({
    firstname: new FormControl(),
    lastname: new FormControl(),
    address: new FormControl(),
    username: new FormControl(),
    role: new FormControl()
  });

  constructor(private addressServices: AddressServicesService, private userServices: UserServicesService, private roleService: RoleServicesService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<EditUserComponent>, @Inject(MAT_DIALOG_DATA) public data) {
    this.user = data;
  }

  ngOnInit(): void {
    this.getAllAddresses();
    this.getAllRoles();
    this.insertUserInForm();
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

  compareRole(role1: any, role2: any): any {
    return role1 && role2 ? role1.id === role2.id : false;
  }

  compareAddress(address1: any, address2: any): any {
    return address1 && address2 ? address1.id === address2.id : false;
  }

  private getUserFormData(): any {
    return {
      firstname: this.form.get('firstname').value,
      lastname: this.form.get('lastname').value,
      address: this.form.get('address').value,
      username: this.form.get('username').value,
      role: this.form.get('role').value,
    };
  }

  editUser(): void {
    const user: any = this.getUserFormData();
    user.id = this.user.id;
    this.userServices.edit(user).subscribe(_user => {
      this.user = _user;
      this.close();
      this.openSnackBar("Successfully edited user", "Close");
    }, err => {
      this.openSnackBar(err.error.message, "Close");
    });
  }

  insertUserInForm(): void {
    this.form.get('firstname').setValue(this.user.firstname);
    this.form.get('lastname').setValue(this.user.lastname);
    this.form.get('username').setValue(this.user.username);
    this.form.get('address').setValue(this.user.address);
    this.form.get('role').setValue(this.user.role);
  }

}

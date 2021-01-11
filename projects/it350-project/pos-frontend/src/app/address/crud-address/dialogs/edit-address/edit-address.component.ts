import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductServicesService} from '../../../../../crud-services/product-services-service';
import {ProductTypeServiceService} from '../../../../../crud-services/productType-service-service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {AddressServicesService} from '../../../../../crud-services/address-services-service';

@Component({
  selector: 'app-edit-address',
  templateUrl: './edit-address.component.html',
  styleUrls: ['./edit-address.component.css']
})
export class EditAddressComponent implements OnInit {

  address: any;
  addresses: any[] = [];

  form = new FormGroup({
    municipality: new FormControl(),
    city: new FormControl(),
    streetName: new FormControl(),
    streetNumber: new FormControl()
  });

  constructor(private addressServices: AddressServicesService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<EditAddressComponent>, @Inject(MAT_DIALOG_DATA) public data) {
    this.address = data;
  }

  ngOnInit(): void {
    this.form.get('municipality').setValue(this.address.municipality);
    this.form.get('city').setValue(this.address.city);
    this.form.get('streetName').setValue(this.address.streetName);
    this.form.get('streetNumber').setValue(this.address.streetNumber);
  }

  close() {
    this.dialogRef.close(true);
  }


  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAllAddresses(): void {
    this.addressServices.getAllAddresses().subscribe(data => {
      this.addresses = data;
    });
  }

  editAddress() {
    const address = this.form.value;
    address.id = this.data.id;
    this.addressServices.editAddress(address).subscribe(() => {
      this.getAllAddresses();
      this.close();
      this.openSnackBar("Successfully edited address", "Close");
    }, err => {
      this.openSnackBar(err.error.message, "Close");
    });
  }

}

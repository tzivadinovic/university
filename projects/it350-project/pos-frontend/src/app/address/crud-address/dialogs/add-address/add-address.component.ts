import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogRef} from '@angular/material/dialog';
import {AddressServicesService} from '../../../../../crud-services/address-services-service';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {
  form = new FormGroup({
    municipality: new FormControl(),
    city: new FormControl(),
    streetName: new FormControl(),
    streetNumber: new FormControl()
  });

  constructor(private addressServices: AddressServicesService, private snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<AddAddressComponent>) { }

  ngOnInit(): void {
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  close() {
    this.dialogRef.close(true);
  }

  addAddress(): void {
    this.addressServices.addAddress(this.form.value).subscribe(() => {
      this.openSnackBar("Successfully added address", "Close");
      this.close();
    }, err => {
      this.openSnackBar(err.error.message, "Close");
    });
  }

}

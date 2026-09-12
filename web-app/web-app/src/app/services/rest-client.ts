import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class RestClient {

  constructor(private http: HttpClient) {
  }

}

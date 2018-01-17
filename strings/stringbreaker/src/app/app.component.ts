import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UnformattedTextDto} from './model/unformatted-text-dto';
import {FormattedTextDto} from './model/formatted-text-dto';
import {Message} from 'primeng/primeng';
import {environment} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public unformattedText: string;
  public lineLength = 40;
  public formattedText: string;
  public messages: Message[];

  constructor(private http: HttpClient) {
  }

  public sendFormatTextRequest() {
    const body = new UnformattedTextDto(this.unformattedText, this.lineLength);

    this.http.post<FormattedTextDto>(environment.API_ENDPOINT + '/formatted-text', body, {responseType: 'json'})
      .subscribe(response => {
        this.formattedText = response.text;
        this.showMessage('success', 'Sucesso', 'Texto formatado. :)');
      }, err => {
        const errorMessage = JSON.parse(JSON.stringify(err)).error.message;
        this.showMessage('error', 'Erro', errorMessage);
      });
  }

  private showMessage(type: string, title: string, body: string): void {
    this.messages = [];
    this.messages.push({severity: type, summary: title, detail: body});
  }
}

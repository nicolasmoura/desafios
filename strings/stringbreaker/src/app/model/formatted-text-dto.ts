export class FormattedTextDto {
  private _message: string;
  private _text: string;


  constructor(message: string, text: string) {
    this._message = message;
    this._text = text;
  }

  get message(): string {
    return this._message;
  }

  set message(value: string) {
    this._message = value;
  }

  get text(): string {
    return this._text;
  }

  set text(value: string) {
    this._text = value;
  }
}

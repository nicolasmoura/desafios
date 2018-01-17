export class UnformattedTextDto {
  private text: string;
  private lineLength: number;


  constructor(text: string, lineLength: number) {
    this.text = text;
    this.lineLength = lineLength;
  }
}

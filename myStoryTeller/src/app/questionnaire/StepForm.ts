export class StepForm {

  constructor(
    public subject: string,
    public verb: string,
    public complement: string,
    public place: string,
    public idSentence: integer,
    public actionType: int // 1 : Poursuivre, 2 : Completer, 3 : Fin (et ils vécurent heureux....)
  ) { }
}

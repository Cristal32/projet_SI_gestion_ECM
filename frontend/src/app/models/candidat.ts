import { FileData } from "./fileData";

export class Candidat {
    email : string = '';
    cin: string = '';
    nom : string = '';
    prenom : string = '';
    dossier: FileData | null = null;
    dossierComplete: FileData | null = null;
    statut: string = ''
}
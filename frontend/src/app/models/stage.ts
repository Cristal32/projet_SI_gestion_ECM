import { Entreprise } from "./entreprise";
import { Etudiant } from "./etudiant";
import { Prof } from "./prof";
import { Tuteur } from "./tuteur";
import { TypeStage } from "./typeStage";


export class Stage{
    id: number = 0;
    annee: number = 0;
    compteRendu: string = '';
    etudiant: Etudiant | null = null;
    entreprise: Entreprise | null = null;
    prof: Prof | null = null;
    typeStage: TypeStage | null = null;
    tuteur: Tuteur | null = null;
    statut: String = ''
}
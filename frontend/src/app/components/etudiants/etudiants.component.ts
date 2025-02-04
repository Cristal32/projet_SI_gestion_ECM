import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Etudiant } from 'src/app/models/etudiant';
import { Stage } from 'src/app/models/stage';
import { EtudiantService } from 'src/app/services/etudiant.service';
import { StageService } from 'src/app/services/stage.service';
// import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-etudiants',
  templateUrl: './etudiants.component.html',
  styleUrls: ['./etudiants.component.css']
})
export class EtudiantsComponent {
  // currentUser: any;
  // currentUtilisateur: Utilisateur = new Utilisateur();

  ListeEtudiants: Etudiant[] = [];
  filteredListeEtudiants: Etudiant[] = [];
  selectedEtudiant: Etudiant = new Etudiant();
  editedEtudiant: Etudiant = new Etudiant();

  //tabs
  editEtudiantModal_ActiveTab: string = '';
  createEtudiantModal_ActiveTab: string = '';
  etudiant_activeTab: string = 'etudiant';

  // constructor(
  //   private stagiaireService: StageService,
  //   private utilisateurService: UtilisateurService,
  //   private fileService: FileService){}
  constructor(
    private etudiantService: EtudiantService){}

  ngOnInit(){
    this.getEtudiants();
    // this.currentUser = JSON.parse(localStorage.getItem('currentUser')|| '{}');
    // this.getCurrentUser();
    
    //test
    // this.ListeEtudiants = [
    //   {
    //     id: 1,
    //     nom: 'Atatri',
    //     prenom: 'Doaa',
    //     adrs: 'Kenitra',
    //     dateNaissance: new Date(2002,5,1),
    //     sexe: 'F',
    //     tel: '0000000000',
    //     mention: 'Tres bien',
    //     promo: {
    //       annee: 2022
    //     }
    //   },
    //   {
    //     id: 1,
    //     nom: 'Braikat',
    //     prenom: 'Fatima Zahra',
    //     adrs: 'Casa',
    //     dateNaissance: new Date(2002,6,2),
    //     sexe: 'F',
    //     tel: '1111111111',
    //     mention: 'Tres bien',
    //     promo: {
    //       annee: 2022
    //     }
    //   }
    // ];
    // this.filteredListeEtudiants = this.ListeEtudiants;
  }
  //============================================== managing variables ==============================================

  assignSelectedEtudiant(etudiant: Etudiant){
    this.selectedEtudiant = etudiant;
  }

  assignEditedEtudiant(){
    this.editedEtudiant = {...this.selectedEtudiant};
    console.log(this.editedEtudiant)
  }

  //============================================== get all etudiants ==============================================

  public getEtudiants(): void{
    this.etudiantService.getEtudiants().subscribe(
      data => {
       this.ListeEtudiants = data;
       this.filteredListeEtudiants = [...this.ListeEtudiants];
       //console.log(data);
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  //============================================== get current user ==============================================
  // getCurrentUser(){
  //   return this.utilisateurService.getUtilisateurById(this.currentUser.userId).subscribe(
  //     data => {
  //       this.currentUtilisateur = data;
  //       this.getStagiairesValides(this.currentUtilisateur.userId);
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.log(error)
  //     }
  //   );
  // }

  //============================================== update etudiant ============================================== 
  
  editEtudiantForm(){
    this.etudiantService.updateEtudiant(this.editedEtudiant).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

  //============================================== download stagiaire cv ============================================== 

  // downloadStagiaireCv(stagiaireCv : FileData){
  //   if(stagiaireCv != null){
  //     let filename : string = stagiaireCv.fileName;
  //     console.log(filename);
  //     this.fileService.downloadFile(filename).subscribe(
  //       data => {
  //         console.log(data);
  //         const blob = new Blob([data], { type: 'application/octet-stream' });
  //         const url = window.URL.createObjectURL(blob);
  //         const link = document.createElement('a');
  //         link.href = url;
  //         link.download = filename;
  //         link.click();
  //         window.URL.revokeObjectURL(url);
  //       },
  //       error => console.log(error)
  //     );
  //    }
  // }

  //============================================== search bar ==============================================
  filterResults(text: string) {
    if (!text) {
      this.filteredListeEtudiants = this.ListeEtudiants;
    } else {
      this.filteredListeEtudiants = this.ListeEtudiants.filter(etudiant =>
        this.matchesSearchCriteria(etudiant, text)
      );
    }
  }
  matchesSearchCriteria(etudiant: Etudiant, text: string): boolean {
    const searchFields: string[] = [
      etudiant?.nom.toLowerCase(),
      etudiant?.prenom.toLowerCase(),
      etudiant?.adrs.toLowerCase()
    ];
    return searchFields.some(field => field.includes(text.toLowerCase()));
  }
  resetFilteredList(input: HTMLInputElement) {
    this.filteredListeEtudiants = this.ListeEtudiants;
    input.value = '';
  }
}
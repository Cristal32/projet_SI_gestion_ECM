import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Entreprise } from 'src/app/models/entreprise';
import { Tuteur } from 'src/app/models/tuteur';
import { EntrepriseService } from 'src/app/services/entreprise.service';
import { TuteurService } from 'src/app/services/tuteur.service';


@Component({
  selector: 'app-tuteurs',
  templateUrl: './tuteurs.component.html',
  styleUrls: ['./tuteurs.component.css']
})

export class TuteursComponent {
  // currentUser: any;
  // currentUtilisateur: Utilisateur = new Utilisateur();

  ListeTuteurs: Tuteur[] = [];
  filteredListeTuteurs: Tuteur[] = [];
  selectedTuteur: Tuteur = new Tuteur();
  editedTuteur: Tuteur = new Tuteur();
  deletedTuteur: Tuteur = new Tuteur();
  createdTuteur: Tuteur = new Tuteur();
  createdEntreprise: Entreprise = new Entreprise();
  


  //tabs
  editTuteurModal_ActiveTab: string = '';
  createTuteurModal_ActiveTab: string = '';
  stage_activeTab: string = 'stage';

  //============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';

  setActiveCreateTab(tab: string){
    this.createTuteurModal_ActiveTab = tab;
  }
  setActiveEditTab(tab: string){
    this.editTuteurModal_ActiveTab = tab;
  }

  setActiveTuteurTab(tab: string){
    this.stage_activeTab = tab;
  }


  // constructor(
  //   private stagiaireService: StageService,
  //   private utilisateurService: UtilisateurService,
  //   private fileService: FileService){}
  constructor(
    private entrepriseService: EntrepriseService,
    private tuteurService: TuteurService
    ){}
  
  

  ngOnInit(){
    this.getTuteurs();

    // this.currentUser = JSON.parse(localStorage.getItem('currentUser')|| '{}');
    // this.getCurrentUser();
  }

  //create Tuteurs form
  form: any = {
    entreprise: null,
    id_tuteur:'',
    nom_tuteur:'',
    prenom_tuteur:'',
    tel_tuteur:''
  };


  //puts the value of the create Tuteur form in the createdTuteur variable
  setFormInCreatedTuteur(){
    this.createdTuteur.id = this.form.id_tuteur;
    this.createdTuteur.nom = this.form.nom_tuteur;
    this.createdTuteur.prenom = this.form.prenom_tuteur;
    this.createdTuteur.tel = this.form.tel_tuteur;
  }
  
  //====================== create stagiaire ===================================

createTuteurForm(){
  this.setFormInCreatedTuteur();
  console.log("createdTuteur: ", this.createdTuteur);
  this.tuteurService.addTuteur(this.createdTuteur).subscribe(
        data => {
          console.log(data);
          window.location.reload();
        },
            error => console.log(error)
  );
}
    
    //test
    // this.ListeStages = [
      /*
        id: 1,
        annee: 2024,
        etudiant:{
          id: 1,
          nom: 'Atatri',
          prenom: 'Doaa',
          adrs: 'Kenitra',
          dateNaissance: new Date(2002,5,1),
          sexe: 'F',
          tel: '0000000000',
          mention: 'Tres bien',
          promo: {
            id: 2022,
            nbrRecus: 100,
            nbrInscrits: 200,
            dirigeant: null
          }
        }
      },
      {
        id: 2,
        annee: 2024,
        etudiant:{
          id: 1,
          nom: 'Braikat',
          prenom: 'Fatima Zahra',
          adrs: 'Casa',
          dateNaissance: new Date(2002,6,2),
          sexe: 'F',
          tel: '1111111111',
          mention: 'Tres bien',
          promo: {
            id: 2021,
            nbrInscrits: 300,
            nbrRecus: 24,
            dirigeant: null
          }
        }
      }
    ];
    this.filteredListeStages = this.ListeStages;
  */
  //============================================== managing variables ==============================================
  
  assignSelectedTuteur(tuteur: Tuteur){
    this.selectedTuteur = tuteur;
  }

  assignEditedTuteur(){
    this.editedTuteur = {...this.selectedTuteur};
  }

  assignDeletedTuteur(){
    this.deletedTuteur = {...this.selectedTuteur};
  }

  //========================== get all tuteurs ==================================

  public getTuteurs(): void{
    this.tuteurService.getTuteurs().subscribe(
      data => {
       this.ListeTuteurs = data;
       this.filteredListeTuteurs = [...this.ListeTuteurs];
       //console.log(data);
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }


  //=============== get all étudiants ==============================================

  // public getEtudiants(): void{
  //   this.etudiantService.getEtudiants().subscribe(
  //     data => {
  //      this.ListeEtudiants = data;
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.log(error)
  //     }
  //   );
  // }

  //============================================== get all types ==============================================

  // public getTypes(): void{
  //   this.typeService.getTypes().subscribe(
  //     data => {
  //      this.ListeTypes = data;
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.log(error)
  //     }
  //   );
  //   // console.log("liste des types:", this.ListeTypes);
  // }

  //============================================== get all profs ==============================================

  // public getProfs(): void{
  //   this.profService.getProfs().subscribe(
  //     data => {
  //      this.ListeProfs = data;
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.log(error)
  //     }
  //   );
  // }

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

  //============================================== update stage ============================================== 
  
  editTuteurForm(){
    this.tuteurService.updateTuteur(this.editedTuteur).subscribe(
      data => {
        console.log(data);
        // window.location.reload();
      },
      error => console.log(error)
    );
  }

  //========================== delete Tuteur ========================================= 

deleteTuteurForm(){
  this.tuteurService.deleteTuteur(this.deletedTuteur.id).subscribe(
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
      this.filteredListeTuteurs = this.ListeTuteurs;
    } else {
      this.filteredListeTuteurs = this.ListeTuteurs.filter(tuteur =>
        this.matchesSearchCriteria(tuteur, text)
      );
    }
  }
  matchesSearchCriteria(tuteur: Tuteur, text: string): boolean {
    const searchFields: string[] = [
      tuteur.id.toString(),
      tuteur.nom.toString(),
      tuteur.prenom.toString(),
      tuteur.tel.toString(),
      ];
    //console.log("searchFields.includes('Bob')",searchFields.includes('Bob'));
    //console.log("text a chercher :",text);
    //console.log("searchFields",searchFields );
    //console.log("results: ",searchFields.some(field => field.includes(text.toLowerCase())))
    return searchFields.some(field => field.includes(text));
  }
  resetFilteredList(input: HTMLInputElement) {
    this.filteredListeTuteurs = this.ListeTuteurs;
    input.value = '';
  }
}

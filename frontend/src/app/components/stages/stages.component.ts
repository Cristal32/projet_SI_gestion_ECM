import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Stage } from 'src/app/models/stage';
import { StageService } from 'src/app/services/stage.service';
import { EtudiantService } from 'src/app/services/etudiant.service';
import { Etudiant } from 'src/app/models/etudiant';
import { TypeStage } from 'src/app/models/typeStage';
import { TypeStageService } from 'src/app/services/type-stage.service';
import { Prof } from 'src/app/models/prof';
import { ProfService } from 'src/app/services/prof.service';
import { Entreprise } from 'src/app/models/entreprise';
import { EntrepriseService } from 'src/app/services/entreprise.service';
import { Tuteur } from 'src/app/models/tuteur';
import { TuteurService } from 'src/app/services/tuteur.service';



// import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-stages',
  templateUrl: './stages.component.html',
  styleUrls: ['./stages.component.css']
})
export class StagesComponent {
  // currentUser: any;
  // currentUtilisateur: Utilisateur = new Utilisateur();

  ListeStages: Stage[] = [];
  ListeEtudiants: Etudiant[] = [];
  ListeEntreprises: Entreprise[] = [];
  ListeTuteurs: Tuteur[] = [];
  ListeTypesStage: TypeStage[] = [];
  ListeProfs: Prof[] = [];
  filteredListeStages: Stage[] = [];
  selectedStage: Stage = new Stage();
  editedStage: Stage = new Stage();
  deletedStage: Stage = new Stage();
  createdStage: Stage = new Stage();
  createdEntreprise: Entreprise = new Entreprise();
  createdTuteur: Tuteur = new Tuteur();


  //tabs
  editStageModal_ActiveTab: string = '';
  createStageModal_ActiveTab: string = '';
  stage_activeTab: string = 'stage';

  //============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';

  setActiveCreateTab(tab: string){
    this.createStageModal_ActiveTab = tab;
  }
  setActiveEditTab(tab: string){
    this.editStageModal_ActiveTab = tab;
  }

  setActiveStageTab(tab: string){
    this.stage_activeTab = tab;
  }


  // constructor(
  //   private stagiaireService: StageService,
  //   private utilisateurService: UtilisateurService,
  //   private fileService: FileService){}
  constructor(
    private stageService: StageService,
    private etudiantService: EtudiantService,
    private typeStageService: TypeStageService,
    private profService: ProfService,
    private entrepriseService: EntrepriseService,
    private tuteurService: TuteurService
    ){}
  
  

  ngOnInit(){
    this.getStages();
    this.getEtudiants();
    this.getTypes();
    this.getProfs();
    this.getEntreprises();
    this.getTuteurs();

    // this.currentUser = JSON.parse(localStorage.getItem('currentUser')|| '{}');
    // this.getCurrentUser();
  }

  //create stagiaire form
  form: any = {
    annee: '',
    compteRendu: '',
    etudiant: null,
    entreprise: null,
    prof: null,
    typeStage: '',
    tuteur: null,
    statut: ''
  }

  //puts the value of the create stagiaire form in the createdStagiaire variable
  setFormInCreatedStage(){
    this.createdStage.annee = this.form.annee;
    this.createdStage.compteRendu = this.form.compteRendu;
    this.createdStage.etudiant = this.form.etudiant;
    this.createdStage.entreprise = this.form.entreprise;
    this.createdStage.prof = this.form.prof;
    this.createdStage.typeStage = this.form.typeStage;
    this.createdStage.tuteur = this.form.tuteur;
    this.createdStage.statut = this.form.statut;
  }

  
  
  //============================================== create stage ==============================================
//dateValidationError: boolean = false;

createStageForm(){
  //this.dateValidationError= false;
  this.setFormInCreatedStage();
  console.log("createdStage: ", this.createdStage);
  this.stageService.addStage(this.createdStage).subscribe(
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
  
  assignSelectedStage(stage: Stage){
    this.selectedStage = stage;
  }

  assignEditedStage(){
    this.editedStage = {...this.selectedStage};
  }

  assignDeletedStage(){
    this.deletedStage = {...this.selectedStage};
  }

  //============================================== get all stages ==============================================

  public getStages(): void{
    this.stageService.getStages().subscribe(
      data => {
       this.ListeStages = data;
       this.filteredListeStages = [...this.ListeStages];
       //console.log(data);
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }


  //============================================== get all étudiants ==============================================

  public getEtudiants(): void{
    this.etudiantService.getEtudiants().subscribe(
      data => {
       this.ListeEtudiants = data;
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  //============================================== get all types ==============================================

  public getTypes(): void{
    this.typeStageService.getTypesStage().subscribe(
      data => {
       this.ListeTypesStage = data;
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
    // console.log("liste des types:", this.ListeTypes);
  }

  //============================================== get all entreprises ==============================================

  public getEntreprises(): void{
    this.entrepriseService.getEntreprises().subscribe(
      data => {
       this.ListeEntreprises = data;
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
    // console.log("liste des types:", this.ListeTypes);
  }

  //============================================== get all entreprises ==============================================

  public getTuteurs(): void{
    this.tuteurService.getTuteurs().subscribe(
      data => {
       this.ListeTuteurs = data;
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
    // console.log("liste des types:", this.ListeTypes);
  }

  //============================================== get all profs ==============================================

  public getProfs(): void{
    this.profService.getProfs().subscribe(
      data => {
       this.ListeProfs = data;
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

  //============================================== update stage ============================================== 
  
  editStageForm(){
    this.stageService.updateStage(this.editedStage).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

  //============================================== delete stage ============================================== 

deleteStageForm(){
  this.stageService.deleteStage(this.deletedStage.id).subscribe(
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
      this.filteredListeStages = this.ListeStages;
    } else {
      this.filteredListeStages = this.ListeStages.filter(stage =>
        this.matchesSearchCriteria(stage, text)
      );
    }
  }
  matchesSearchCriteria(stage: Stage, text: string): boolean {
    const searchFields: (string | undefined)[] = [
      stage.annee.toString(),
      stage.etudiant?.nom.toString(),
      stage.etudiant?.prenom.toString(),
      stage.prof?.nom.toString(),
      stage.prof?.prenom.toString(),
      stage.tuteur?.nom.toString(),
      stage.tuteur?.prenom.toString(),
      stage.entreprise?.raisonSoc.toString(),
      stage.typeStage?.id.toString(),
      stage.compteRendu?.toString(),
    ];
    //console.log("searchFields.includes('Bob')",searchFields.includes('Bob'));
    //console.log("text a chercher :",text);
    //console.log("searchFields",searchFields );
    //console.log("results: ",searchFields.some(field => field.includes(text.toLowerCase())))
    return searchFields.some(field => field != undefined && field.includes(text));
  }
  resetFilteredList(input: HTMLInputElement) {
    this.filteredListeStages = this.ListeStages;
    input.value = '';
  }
}
import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Prof } from 'src/app/models/prof';
import { ProfService } from 'src/app/services/prof.service';


@Component({
  selector: 'app-profs',
  templateUrl: './profs.component.html',
  styleUrls: ['./profs.component.css']
})

export class ProfsComponent {
  // currentUser: any;
  // currentUtilisateur: Utilisateur = new Utilisateur();

  ListeProfs: Prof[] = [];
  filteredListeProfs: Prof[] = [];
  selectedProf: Prof = new Prof();
  editedProf: Prof = new Prof();
  deletedProf: Prof = new Prof();
  createdProf: Prof = new Prof();
  


  //tabs
  editProfModal_ActiveTab: string = '';
  createProfModal_ActiveTab: string = '';
  prof_activeTab: string = 'prof';

  //============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';

  setActiveCreateTab(tab: string){
    this.createProfModal_ActiveTab = tab;
  }
  setActiveEditTab(tab: string){
    this.editProfModal_ActiveTab = tab;
  }

  setActiveProfTab(tab: string){
    this.prof_activeTab = tab;
  }


  // constructor(
  //   private stagiaireService: StageService,
  //   private utilisateurService: UtilisateurService,
  //   private fileService: FileService){}
  constructor(
    private profService: ProfService,
    ){}
  
  

  ngOnInit(){
    this.getProfs();

    // this.currentUser = JSON.parse(localStorage.getItem('currentUser')|| '{}');
    // this.getCurrentUser();
  }

  //create Tuteurs form
  form: any = {
    nom_prof:'',
    prenom_prof:'',
    adrs_prof:'',
    tel_prof:'',
    dateEmbauche_prof:new Date(),
    dateDepart_prof:new Date()
  };

  
  //puts the value of the create Prof form in the createdProf variable
  setFormInCreatedProf(){
    this.createdProf.nom = this.form.nom_prof;
    this.createdProf.prenom = this.form.prenom_prof;
    this.createdProf.adrs = this.form.adrs_prof;
    this.createdProf.tel = this.form.tel_prof;
    this.createdProf.dateEmbauche = this.form.dateEmbauche_prof;
    this.createdProf.dateDepart = this.form.dateDepart_prof;
  }
  
  //====================== create Prof ===================================

  CreateProfForm(){
  this.setFormInCreatedProf();
  console.log( this.createdProf);
  this.profService.addProf(this.createdProf).subscribe(
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
  
  assignSelectedProf(prof: Prof){
    this.selectedProf = prof;
  }

  assignEditedProf(){
    this.editedProf = {...this.selectedProf};
  }

  assignDeletedProf(){
    this.deletedProf = {...this.selectedProf};
  }

  //========================== get all Profs ==================================

  public getProfs(): void{
    this.profService.getProfs().subscribe(
      data => {
       this.ListeProfs = data;
       this.filteredListeProfs = [...this.ListeProfs];
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

  //============================================== update Prof ============================================== 
  
  editProfForm(){
    this.profService.updateProf(this.editedProf).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

  //========================== delete Prof ========================================= 

deleteProfForm(){
  this.profService.deleteProf(this.deletedProf.id).subscribe(
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
      this.filteredListeProfs = this.ListeProfs;
    } else {
      this.filteredListeProfs = this.ListeProfs.filter(prof =>
        this.matchesSearchCriteria(prof, text)
      );
    }
  }
  matchesSearchCriteria(prof: Prof, text: string): boolean {
    const searchFields: (string | undefined)[] = [
      prof.id.toString(),
      prof.nom.toString(),
      prof.prenom.toString(),
      prof.adrs.toString(),
      prof.tel.toString(),
      prof.dateEmbauche?.toString(),
      prof.dateDepart?.toString()
      ];
    //console.log("searchFields.includes('Bob')",searchFields.includes('Bob'));
    //console.log("text a chercher :",text);
    //console.log("searchFields",searchFields );
    //console.log("results: ",searchFields.some(field => field.includes(text.toLowerCase())))
    return searchFields.some(field => field !== undefined && field.toLowerCase().includes(text.toLowerCase()));
  }
  resetFilteredList(input: HTMLInputElement) {
    this.filteredListeProfs = this.ListeProfs;
    input.value = '';
  }
}

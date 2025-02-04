import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Entreprise } from 'src/app/models/entreprise';
import { Stage } from 'src/app/models/stage';
import { EntrepriseService } from 'src/app/services/entreprise.service';
import { EtudiantService } from 'src/app/services/etudiant.service';
import { StageService } from 'src/app/services/stage.service';
// import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent {

  ListeEntreprises: Entreprise[] = [];
  filteredListeEntreprises: Entreprise[] = [];
  selectedEntreprise: Entreprise = new Entreprise();
  editedEntreprise: Entreprise = new Entreprise();
  deletedEntreprise: Entreprise = new Entreprise();
  createdEntreprise: Entreprise = new Entreprise();

  //tabs
  editEntrepriseModal_ActiveTab: string = '';
  createEntrepriseModal_ActiveTab: string = '';
  entreprise_activeTab: string = 'entreprise';

  //============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';

  setActiveCreateTab(tab: string){
    this.createEntrepriseModal_ActiveTab = tab;
  }
  setActiveEditTab(tab: string){
    this.editEntrepriseModal_ActiveTab = tab;
  }

  setActiveTuteurTab(tab: string){
    this.entreprise_activeTab = tab;
  }


  // constructor(
  //   private stagiaireService: StageService,
  //   private utilisateurService: UtilisateurService,
  //   private fileService: FileService){}
  constructor(
    private entrepriseService: EntrepriseService){}

  ngOnInit(){
    this.getEntreprises();
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

  //create Entreprises form
  form: any = {
    siret:'',
    raison_social:'',
    forme_juridique:'',
    adrs_entreprise:'',
    tel_standard:'',
    contact:'',
    tel_contact:''
  };


  //puts the value of the create Entreprise form in the createdEntreprise variable
  setFormInCreatedEntreprise(){
    this.createdEntreprise.id = this.form.siret;
    this.createdEntreprise.raisonSoc = this.form.raison_social;
    this.createdEntreprise.formeJur = this.form.forme_juridique;
    this.createdEntreprise.adrs = this.form.adrs_entreprise;
    this.createdEntreprise.telStandard = this.form.tel_standard;
    this.createdEntreprise.contact = this.form.contact;
    this.createdEntreprise.telContact = this.form.tel_contact;
  }
  
  //====================== create Entreprise ===================================

createEntrepriseForm(){
  this.setFormInCreatedEntreprise();
  console.log(this.createdEntreprise);
  this.entrepriseService.addEntreprise(this.createdEntreprise).subscribe(
        data => {
          console.log(data);
          window.location.reload();
        },
            error => console.log(error)
  );
}

  //============================================== managing variables ==============================================

  assignSelectedEntreprise(entreprise: Entreprise){
    this.selectedEntreprise = entreprise;
  }

  assignEditedEntreprise(){
    this.editedEntreprise = {...this.selectedEntreprise};
    console.log(this.editedEntreprise)
  }

  assignDeletedEntreprise(){
    this.deletedEntreprise = {...this.selectedEntreprise};
  }

  //============================================== get all entreprises ==============================================

  public getEntreprises(): void{
    this.entrepriseService.getEntreprises().subscribe(
      data => {
       this.ListeEntreprises = data;
       this.filteredListeEntreprises = [...this.ListeEntreprises];
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

  //============================================== update Entreprise ============================================== 
  
  editEntrepriseForm(){
    this.entrepriseService.updateEntreprise(this.editedEntreprise).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

  //========================== delete Entreprise ========================================= 

deleteEntrepriseForm(){
  this.entrepriseService.deleteEntreprise(this.deletedEntreprise.id).subscribe(
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
      this.filteredListeEntreprises = this.ListeEntreprises;
    } else {
      this.filteredListeEntreprises = this.ListeEntreprises.filter(entreprise =>
        this.matchesSearchCriteria(entreprise, text)
      );
    }
  }
  matchesSearchCriteria(entreprise: Entreprise, text: string): boolean {
    const searchFields: string[] = [
      entreprise?.id.toString(),
      entreprise?.raisonSoc.toLowerCase(),
      entreprise?.formeJur.toLowerCase(),
      entreprise?.adrs.toLowerCase(),
      entreprise?.telStandard.toLowerCase(),
      entreprise?.contact.toLowerCase(),
      entreprise?.telContact.toLowerCase()
    ];
    return searchFields.some(field => field.includes(text.toLowerCase()));
  }
  resetFilteredList(input: HTMLInputElement) {
    this.filteredListeEntreprises = this.ListeEntreprises;
    input.value = '';
  }

}

  

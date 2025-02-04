import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { Candidat } from 'src/app/models/candidat';
import { Etudiant } from 'src/app/models/etudiant';
import { FileData } from 'src/app/models/fileData';
import { CandidatService } from 'src/app/services/candidat.service';
import { EtudiantService } from 'src/app/services/etudiant.service';
import { FileService } from 'src/app/services/file.service';

@Component({
  selector: 'app-candidats',
  templateUrl: './candidats.component.html',
  styleUrls: ['./candidats.component.css']
})
export class CandidatsComponent {
  listeCandidats : Candidat[] = [];
  selectedCandidat : Candidat = new Candidat();
  filteredListeCandidats: Candidat[] = [];

  //tabs
  candidat_activeTab: string = 'stagiaire';

  constructor(private candidatService : CandidatService, private fileService : FileService, private etudiantService: EtudiantService){}

  ngOnInit(){
      this.getCandidats();
  }

  //============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';

  setActiveCandidatTab(tab: string){
    this.candidat_activeTab = tab;
  }

  //============================================== get candidats ==============================================

  getCandidats(){
    this.candidatService.getCandidats().subscribe(
      data => {
       this.listeCandidats = data;
       this.filteredListeCandidats = [...this.listeCandidats];
       console.log(data);
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  //============================================== file system ==============================================
   //initialise a file
   fileContent: BlobPart[] = [""];
   fileName = "";
   selectedDossier: File = new File(this.fileContent, this.fileName);

  getFileByFileName(filename: string){
    this.fileService.getFileByFileName(filename).subscribe(
      data => {
        console.log(data);

      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  @ViewChild('createDossierInput') createDossierInput!: ElementRef;
  resetSelectedDossier(){
    this.selectedDossier = new File(this.fileContent, this.fileName);
    this.createDossierInput.nativeElement.value = null;
  }

  downloadCandidatFile(candidatFile : FileData){
    if(candidatFile != null){
      let filename : string = candidatFile.fileName;
      console.log(filename);
      this.fileService.downloadFile(filename).subscribe(
        data => {
          console.log(data);
          const blob = new Blob([data], { type: 'application/octet-stream' });
          const url = window.URL.createObjectURL(blob);
          const link = document.createElement('a');
          link.href = url;
          link.download = filename;
          link.click();
          window.URL.revokeObjectURL(url);
        },
        error => console.log(error)
      );
     }
  }

  refuserCandidat(candidat : Candidat){
    const candidatEmail = candidat.email;
    this.candidatService.deleteCandidat(candidatEmail).subscribe(() => {
      this.getCandidats();
    });
  }

  validerCandidat(candidat : Candidat){
    // Construisez l'objet Etudiant à partir des données du Candidat
    const etudiant : Etudiant = {
      id : 0,
      nom : candidat.nom,
      prenom : candidat.prenom,
      dateNaissance : null,
      sexe : '',
      adrs: '',
      tel: '',
      mention: '',
      promo: null
    };
    this.etudiantService.addEtudiant(etudiant).subscribe(
      (etudiantAjoute) => {
        console.log('Étudiant ajouté avec succès:', etudiantAjoute);
        // Vous pouvez également mettre à jour la liste des candidats ou effectuer d'autres actions ici
      },
      (error: HttpErrorResponse) => {
        console.error('Erreur lors de l\'ajout de l\'étudiant:', error);
        // Gérez l'erreur en conséquence
      }
    );
  }
}

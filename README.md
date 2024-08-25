# Application backend pour gestion des stages d'une école (ECM)

# Frontend
Pour voir la partie frontend: 
https://github.com/Cristal32/SI_Angular_front_gestionECM

## Table des matières

- [Dossier d'analyse](#dossier-danalyse)
  - [Partie donnnées](#partie-donnnées)
    - [Dictionnaire de donnnées](#dictionnaire-de-donnnées)
    - [Règles de gestion](#règles-de-gestion)
    - [MCD: Modèle Conceptuel de Données](#mcd-modèle-conceptuel-de-données)
  - [Partie traitements](#partie-traitements)
    - [Acteurs](#acteurs)
    - [MCC: Modèle Conceptuel des Communications](#mcc-modèle-conceptuel-des-communications)
    - [Traitement des stages](#traitement-des-stages)
      - [GOE - stages: Graphe d’Ordonnancement des Evénements](#goe---stages-graphe-dordonnancement-des-evénements)
      - [MCT - stages: Modèle Conceptuel des Traitements](#mct---stages-modèle-conceptuel-des-traitements)
      - [MOT - stages: Modèle Organisationnel des Traitements](#mot---stages-modèle-organisationnel-des-traitements)
    - [Traitement des inscriptions](#traitement-des-inscriptions)
      - [GOE - inscriptions](#goe---inscriptions)
      - [MCT - inscriptions](#mct---inscriptions)
      - [MOT - inscriptions](#mot---inscriptions)
- [Contributeurs](#contributeurs)

# Dossier d'analyse

Afin d’assurer une structuration optimale de nos données au sein de notre base, il est nécessaire de suivre une méthodologie de conception rigoureuse. Notre choix s’est porté sur la méthode MERISE (Méthode d’Etude et de Réalisation Informatique pour les Systèmes d’Entreprise), motivé par la clarté et la simplicité de ses modèles, ainsi que par sa capacité à séparer de manière distincte les données des traitements.

## Partie donnnées

### Dictionnaire de donnnées

<p align="center">
  <img src="assets/dictionnaire de donnees.PNG" alt="Dictionnaire de données"/>
</p>

### Règles de gestion

<ul>
  <li>Un candidat accepté devient un étudiant</li>
  <li>Chaque étudiant appartient à une et une seule promotion</li>
  <li>Chaque promotion est dirigée par un professeur</li>
  <li>Un professeur peut diriger une ou plusieurs promotions</li>
  <li>Chaque étudiant est contraint de faire plusieurs stages</li>
  <li>Un stage est effectué par un seul étudiant</li>
  <li>Chaque stage est assisté par un tuteur</li>
  <li>Un tuteur peut assister à plusieurs stages</li>
  <li>Chaque stage est associé à un seul type de stage</li>
  <li>Les compétences à acquérir sont définies avec des niveaux spécifiques</li>
  <li>Les dates de début et de fin de chaque type de stage varient selon l’année</li>
  <li>Un utilisateur peut être soit un étudiant soit un administrateur</li>
</ul>

### MCD: Modèle Conceptuel de Données

<p align="center">
  <img src="assets/MCD.png" alt="Le modèle conceptuel de données"/>
</p>

## Partie traitements

Notre système fait beaucoup de traitements sur les étudiants et leurs stages. Nous avons donc décidé de les décrire et de les modéliser à travers les différents diagrammes de traitement offerts par la méthode Merise. Les traitements concerneront deux parties principales, la gestion des stages, et la gestion des inscriptions.

### Acteurs

<b>- les acteurs internes :</b> l’administration de la plateforme et les commissions ; <br/>
<b>- les acteurs externes :</b> le candidat et l’étudiant ;

### MCC: Modèle Conceptuel des Communications

<p align="center">
  <img src="assets/MCC_niv0.PNG" alt="Le modèle conceptuel des communications niveau 0"/>
</p>

On peut aussi modèliser le MCC niveau 1 pour visualiser le flux de communications des acteurs internes :

<p align="center">
  <img src="assets/MCC_niv1.PNG" alt="Le modèle conceptuel des communications niveau 1"/>
</p>

### Traitement des stages

En ce qui concerne le traitement des stages, une fois qu'un étudiant est parvenu à décrocher une opportunité de stage chez une entreprise, il doit formuler une demande à l'administration pour avoir une fiche de stage à remplir auprès de l'organisme d'accueil. Ensuite, il doit renvoyer la fiche remplie aux services de stage de l'école, qui seront, dans notre cas, les administrateurs du système.

#### GOE - stages: Graphe d’Ordonnancement des Evénements

<p align="center">
  <img src="assets/GOE_stages.png" alt="Le graphe d’ordonnancement des événements pour les stages" width="400px"/>
</p>

A chaque nouvelle période de stage, lorsque l'étudiant envoie la fiche de stage remplie, les informations de ce stage seront enregistrées dans le système, ensuite, il génère une convention que l'étudiant devra rapporter à l'organisme d'accueil pour signer. Uniquement après avoir reçu cette convention signée qu'on entamera l'assignation d'un professeur encadrant pour assister au stage. En même temps, Le stage débute, et suite à sa fin, l'étudiant doit remettre la fiche d'évaluation auprès du système pour clôturer son stage.

#### MCT - stages: Modèle Conceptuel des Traitements

<p align="center">
  <img src="assets/MCT - Stages.png" alt="Le modèle conceptuel des traitements pour les stages" width="400px"/>
</p>

<p align="center">
  <img src="assets/MCT - Apres stage.png" alt="Le modèle conceptuel des traitements après le stage" width="400px"/>
</p>

#### MOT - stages: Modèle Organisationnel des Traitements

<p align="center">
  <img src="assets/MOT-stages.png" alt="Le modèle organisationnel des traitements pour les stages"/>
</p>

### Traitement des inscriptions

D'autre part, pour les inscriptions, chaque candidat désirant s'inscrire à l'école doit fournir son dossier de candidature pour être examiné. L'école lui renvoie ensuite le résultat de l'examination. En cas d'acceptation, il doit envoyer un chèque pour confirmer et clôturer son inscription, puis une carte d'étudiant lui sera attribuée (par l'école). En cas de mise en attente, le candidat doit envoyer des informations supplémentaires pour complèter son dossier. Suite à cela, ce dernier peut soit être accepté soit rejeté.

#### GOE - inscriptions

<p align="center">
  <img src="assets/GOE_inscriptions.PNG" alt="Le graphe d’ordonnancement des événements pour les inscriptions"/>
</p>

#### MCT - inscriptions

<p align="center">
  <img src="assets/MCT - Gestion des inscriptions.png" alt="Le modèle conceptuel des traitements pour les stages"/>
</p>

#### MOT - inscriptions

<p align="center">
  <img src="assets/MOT_Inscriptions.png" alt="Le modèle organisationnel des traitements pour les inscriptions"/>
</p>

# Contributeurs

- [@Cristal32](https://github.com/Cristal32)
- [@dodoLR](https://github.com/dodoLR)
- [@fatibr19](https://github.com/fatibr19)

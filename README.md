# 🎓 ProjetWS — Application Android + Web Service PHP

![Android](https://img.shields.io/badge/Android-Studio-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![PHP](https://img.shields.io/badge/PHP-8.0-777BB4?style=for-the-badge&logo=php&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-XAMPP-F29111?style=for-the-badge&logo=mysql&logoColor=white)
![Gson](https://img.shields.io/badge/Gson-2.10.1-FF6F00?style=for-the-badge&logo=google&logoColor=white)

> Application Android de gestion des étudiants connectée à un Web Service PHP/MySQL via Volley et Gson.

---

## 🎬 Démonstration Vidéo

> 📹 **[Cliquez ici pour voir la démonstration complète](#)**

https://github.com/user-attachments/assets/841d4656-5b9a-4fff-9f86-96fd2a70dedb


---

## 📋 Description du Projet

Ce projet est une application mobile Android qui permet de :
- **Afficher** la liste de tous les étudiants stockés en base de données
- **Ajouter** un nouvel étudiant via un formulaire
- **Communiquer** avec un serveur local XAMPP via des requêtes HTTP

---

## 🏗️ Architecture du Projet

### Backend (PHP + MySQL)
```
C:\xampp\htdocs\projetws\
├── classes/
│   └── Etudiant.php
├── connexion/
│   └── Connexion.php
├── dao/
│   └── IDao.php
├── service/
│   └── EtudiantService.php
└── ws/
    ├── createEtudiant.php
    └── loadEtudiant.php
```

### Frontend (Android)
```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/com/example/projetws/
│   ├── models/
│   │   └── Etudiant.java
│   ├── activities/
│   │   ├── MainActivity.java
│   │   └── AddEtudiantActivity.java
│   ├── adapters/
│   │   └── EtudiantAdapter.java
│   └── network/
│       └── VolleySingleton.java
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_add_etudiant.xml
    │   └── item_etudiant.xml
    └── drawable/
        └── circle_background.xml
```

---

## ⚙️ Technologies Utilisées

| Technologie | Version | Rôle |
|---|---|---|
| Android Studio | Hedgehog+ | IDE mobile |
| Java | 11 | Langage Android |
| Volley | 1.2.1 | Requêtes HTTP |
| Gson | 2.10.1 | Parsing JSON |
| PHP | 8.0 | Web Service backend |
| MySQL | 8.0 | Base de données |
| XAMPP | 8.x | Serveur local |
| PDO | — | Connexion base de données |

---

## 🚀 Installation et Configuration

### Étape 1 — Prérequis
- [XAMPP](https://www.apachefriends.org/) installé et démarré (Apache + MySQL)
- [Android Studio](https://developer.android.com/studio) installé
- Émulateur Android configuré

### Étape 2 — Base de données
Ouvrez [http://localhost/phpmyadmin](http://localhost/phpmyadmin) et exécutez :

```sql
CREATE DATABASE school1;

USE school1;

CREATE TABLE Etudiant (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nom VARCHAR(50),
  prenom VARCHAR(50),
  ville VARCHAR(50),
  sexe VARCHAR(10)
);

INSERT INTO Etudiant (nom, prenom, ville, sexe)
VALUES ('Lachgar', 'Mohamed', 'Rabat', 'homme'),
       ('Safi', 'Amine', 'Marrakech', 'homme');
```

### Étape 3 — Web Service PHP
Copiez le dossier `projetws` dans :
```
C:\xampp\htdocs\projetws\
```

Testez les services dans le navigateur :
- **GET** → [http://localhost/projetws/ws/loadEtudiant.php](http://localhost/projetws/ws/loadEtudiant.php)

### Étape 4 — Application Android

1. Ouvrez le projet dans **Android Studio**
2. Ajoutez les dépendances dans `build.gradle` :

```gradle
dependencies {
    implementation 'com.android.volley:volley:1.2.1'
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

3. Vérifiez les URLs selon votre environnement :

| Environnement | URL à utiliser |
|---|---|
| Émulateur Android | `http://10.0.2.2/projet/ws/` |
| Vrai téléphone (WiFi) | `http://192.168.X.X/projet/ws/` |

4. Cliquez sur **Run ▶️**

---

## 📱 Fonctionnalités

### 🏠 Écran Principal
- Liste de tous les étudiants avec nom, prénom, ville et sexe
- Bouton **+ Ajouter** pour accéder au formulaire
- Rechargement automatique à chaque retour sur l'écran

### ➕ Écran Ajout
- Formulaire avec 4 champs : Nom, Prénom, Ville, Sexe
- Validation des champs avant envoi
- Retour automatique à la liste après ajout réussi

---

## 🌐 Web Services

### `loadEtudiant.php` — GET
```
GET http://10.0.2.2/projetws/ws/loadEtudiant.php
```
**Réponse :**
```json
[
  {"id":1,"nom":"Lachgar","prenom":"Mohamed","ville":"Rabat","sexe":"homme"},
  {"id":2,"nom":"Safi","prenom":"Amine","ville":"Marrakech","sexe":"homme"}
]
```

### `createEtudiant.php` — POST
```
POST http://10.0.2.2/projetws/ws/createEtudiant.php
Body: nom=Dupont&prenom=Sara&ville=Casablanca&sexe=femme
```
**Réponse :** liste complète mise à jour en JSON

---

## 🐛 Problèmes Fréquents

| Erreur | Cause | Solution |
|---|---|---|
| `Erreur réseau: null` | XAMPP non démarré | Démarrer Apache + MySQL |
| `Erreur réseau: null` | Mauvaise URL | Utiliser `10.0.2.2` sur émulateur |
| `Erreur réseau: null` | HTTP bloqué | Ajouter `usesCleartextTraffic="true"` dans Manifest |
| `resource not found` | drawable manquant | Créer `circle_background.xml` dans `res/drawable/` |
| Liste vide | Base de données vide | Insérer des données dans phpMyAdmin |

---

## 👨‍💻 Auteur

**ASSEKNOUR SANA**
- GitHub : https://github.com/sana-sana25
- Email : asseknour.sana21@gmail.com



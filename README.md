# Spring Microservices Repository

Ce référentiel contient un ensemble de micro-services développés avec Spring Boot, destinés à être utilisés dans une architecture de micro-services.

## Microservice: bank-account

Le micro-service `bank-account` est le premier service de ce projet. Suivez les étapes ci-dessous pour comprendre le développement progressif de ce micro-service.

### Étape 1 : Initialiser un micro-service bank-account

```bash
# Cloner le référentiel
git clone https://github.com/votre-utilisateur/spring-microservices-repo.git
cd spring-microservices-repo

# Accéder au répertoire du micro-service `bank-account`
cd bank-account

# Lancer le micro-service
./mvnw spring-boot:run
```

### Étape 2 : Exposer le micro-service pour le monde extérieur

Le micro-service bank-account est accessible à l'adresse : http://localhost:8081

### Étape 3 : Documenter l'API REST avec Swagger
Accéder à la documentation Swagger : http://localhost:8081/swagger-ui.html

### Étape 4 : Ajouter la dépendance Spring JPA Rest
La couche JPA est intégrée pour faciliter l'accès aux données.

### Étape 5 : Ajouter les bonnes pratiques de DTO et les services dans la couche service
Les classes DTO sont utilisées pour transférer les données entre les couches.
La logique métier est implémentée dans la couche service.

### Auteur
Moutaouikil Bahae Ddine 
@Bahaee
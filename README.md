# Projet Microservices avec Spring Boot

Ce projet est une architecture microservices développée avec Spring Boot. Il met en œuvre plusieurs composants distribués interconnectés à travers des services REST, des systèmes de messagerie et divers outils pour la gestion, la sécurité et le monitoring des services.

## Technologies utilisées

- **Spring Boot**
- **Spring Cloud**
  - **Eureka** : Service Discovery pour la gestion des microservices.
  - **OpenFeign** : Appels inter-services simplifiés via HTTP.
  - **Sleuth** : Suivi de requêtes distribuées.
  - **Zipkin** : Visualisation des traces distribuées.
- **PostgreSQL** : Base de données relationnelle.
- **RestTemplate** : Client HTTP pour la communication entre microservices.
- **RabbitMQ** : Système de messagerie pour l'échange de messages.
- **Kafka** : Bus de données pour la gestion des événements.
- **Amazon SQS** : Service de file d'attente pour les messages distribués.
- **Docker** : Conteneurisation des microservices.
- **Kubernetes** : Orchestration des conteneurs Docker pour la scalabilité et la gestion des déploiements.
- **Keycloak** : Gestion de l'authentification et des autorisations (OIDC et OAuth2).

## Prérequis

Avant de démarrer, assurez-vous d'avoir installé les outils suivants :

- [JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3+](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Kubernetes (minikube ou k3s recommandé)](https://kubernetes.io/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Architecture

Le projet est organisé autour des services suivants :

1. **Service de découverte** (Eureka) : Permet l'enregistrement et la découverte des microservices.
2. **Service Gateway** : Point d'entrée des requêtes clients avec routage vers les microservices internes.
3. **Service Authentification** : Utilise **Keycloak** pour gérer l'authentification et l'autorisation.
4. **Microservices métiers** :
   - Service A (exemple : gestion des utilisateurs)
   - Service B (exemple : gestion des commandes)
5. **Systèmes de messagerie** :
   - RabbitMQ, Kafka, SQS pour l'envoi et la réception d'événements.
6. **Traçabilité** : Zipkin pour suivre les appels distribués entre microservices.

## Installation et démarrage

### 1. Cloner le projet

```bash
git clone https://github.com/ton-repo/projet-microservices.git
cd projet-microservices
```

### 2. Construire les services avec Maven

Dans chaque microservice, exécutez la commande suivante pour construire les artefacts Maven :

```bash
mvn clean install
```

### 3. Lancer les services avec Docker

Assurez-vous que Docker est en cours d'exécution et utilisez le fichier `docker-compose.yml` pour lancer tous les services :

```bash
docker-compose up --build
```

Cela démarrera :
- Les microservices Spring Boot
- Les bases de données PostgreSQL
- RabbitMQ, Kafka, Eureka, Zipkin

### 4. Déployer avec Kubernetes

Pour déployer le projet dans Kubernetes, vous devez d'abord créer un cluster avec Minikube (ou un autre outil). Ensuite, utilisez les fichiers `deployment.yaml` pour déployer les services :

```bash
kubectl apply -f kubernetes/deployment.yaml
```

### 5. Accéder aux services

- **API Gateway** : [http://localhost:8080](http://localhost:8080)
- **Eureka Dashboard** : [http://localhost:8761](http://localhost:8761)
- **Zipkin** : [http://localhost:9411](http://localhost:9411)

## Sécurité

L'authentification et l'autorisation sont gérées avec **Keycloak**. Un serveur Keycloak est configuré pour gérer l'authentification via OpenID Connect et OAuth2. Pour accéder aux microservices, vous devez d'abord obtenir un jeton d'authentification depuis Keycloak.

### Configuration de Keycloak

1. Installer Keycloak (utilisez l'image Docker fournie ou déployez-le dans Kubernetes).
2. Configurer un **client** pour les microservices avec les bonnes redirections et permissions.
3. Créer des **utilisateurs** et affecter des rôles.

## Monitoring et traçabilité

L'intégration de **Spring Cloud Sleuth** et **Zipkin** permet d'effectuer le suivi des requêtes entre microservices. Cela permet de comprendre la latence et le flux des appels dans l'ensemble de l'architecture.

Pour visualiser les traces :
- **Zipkin** est accessible à l'URL : [http://localhost:9411](http://localhost:9411)

## Contribution

Les contributions sont les bienvenues. Veuillez suivre ces étapes pour contribuer :

1. Forker le projet.
2. Créer une branche pour vos modifications (`git checkout -b ma-branche`).
3. Soumettre vos modifications (`git commit -m "Mon amélioration"`).
4. Pousser la branche (`git push origin ma-branche`).
5. Ouvrir une Pull Request.

## License

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus d'informations.

---

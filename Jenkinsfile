pipeline {
    agent any

    environment {
        // Définir JAVA_HOME avec l'emplacement de l'installation Java
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        // Définir le chemin de Docker
        DOCKER_PATH = "C:\\Program Files\\Docker\\cli-plugins"
        // Ajouter Java au PATH
        PATH = "${JAVA_HOME}\\bin:${PATH};${DOCKER_PATH}"
        // Utilisez les informations d'identification Docker Hub en tant que variable d'environnement
        DOCKERHUB_CREDENTIALS = credentials('DockerHub')
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Récupérez les sources du référentiel Git
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Changez de répertoire vers le dossier de votre application
                    // Exécutez la commande Maven pour nettoyer et construire le projet
                    bat './mvnw clean install'
                }
            }
        }

        stage('Build & rename Docker Image') {
            steps {
                script {
                    // Connectez-vous à Docker Hub en utilisant les informations d'identification stockées
                    bat "docker login -u ${DOCKERHUB_CREDENTIALS_USR} -p ${DOCKERHUB_CREDENTIALS_PSW}"
                    
                    // Construisez l'image Docker
                    bat 'docker --version'
                    bat 'docker build -t backend-img .'
                    
                    // Étiquetez l'image Docker avec le numéro de version de la construction (%BUILD_ID%)
                    bat "docker tag backend-img:latest chetouiiftikhar/backend-img:%BUILD_ID%"
                    
                    // Poussez l'image Docker vers Docker Hub
                    bat "docker push chetouiiftikhar/backend-img:%BUILD_ID%"
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    // Exécutez le conteneur Docker en utilisant l'image construite
                    bat "docker run -d -p 8888:8080 --name backend_cont_${BUILD_ID} chetouiiftikhar/backend-img:${BUILD_ID}"
                }
            }
        }
    }
}

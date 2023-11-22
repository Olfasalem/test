
pipeline {
    agent any

    environment {
        // Définir JAVA_HOME avec l'emplacement de l'installation Java
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        // Ajouter Java au PATH
        PATH = "${JAVA_HOME}\\bin:${PATH};${DOCKER_PATH}"
        // Définir le chemin de Docker
         DOCKER_PATH = "C:\\Program Files\\Docker\\cli-plugins"
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
                    bat 'dir'
                    bat "docker login -u ${DOCKERHUB_CREDENTIALS_USR} -p ${DOCKERHUB_CREDENTIALS_PSW}"
                    // Supprimez le conteneur Docker existant
                    //bat 'docker rm -f back_container'
                    // Construisez l'image Docker
                    bat 'docker --version'
                    bat 'docker build -t backend-img .'
                    // Étiquetez l'image Docker avec le numéro de version de la construction (%BUILD_ID%)
                    bat "docker tag back-img:latest olfasalem/backend-img:%BUILD_ID%"
                    // Poussez l'image Docker vers Docker Hub
                    bat "docker push olfasalem/backend-img:%BUILD_ID%
            
                }
            }
                
                }
            
        

        stage('Run Docker Container') {
            steps {
                script {
                    // Exécutez le conteneur Docker en utilisant l'image construite
                
                       bat "docker run -d -p 8888:8080 --name backend_cont_${BUILD_ID} olfasalem/back-end-image:${BUILD_ID}"
                }
            }
        }




        

        //stage('Docker Build and Push') {
          //  steps {
            //    script {
                    // Revenez au répertoire parent
              //      bat 'dir'
                //    {
                         // Connectez-vous à Docker Hub en utilisant les informations d'identification stockées dans la variable d'environnement
                  //    bat "docker login -u ${DOCKERHUB_CREDENTIALS_USR} -p ${DOCKERHUB_CREDENTIALS_PSW}"
                    // Supprimez le conteneur Docker existant
                    //bat 'docker rm -f back_container'
                    // Construisez l'image Docker
                    //bat 'docker --version'
                    //bat 'docker build -t spring-img .'
                    // Étiquetez l'image Docker avec le numéro de version de la construction (%BUILD_ID%)
                    //bat "docker tag spring-img:latest olfasalem/spring-img:%BUILD_ID%"
                    // Poussez l'image Docker vers Docker Hub
                    //bat "docker push olfasalem/spring-img:%BUILD_ID%"
                //}}
            //}
        //}
        //stage('Run Docker Container') {
          //  steps {
            //    script {
                        // Exécutez le conteneur Docker en utilisant l'image  construite 
              //          bat "docker run -d -p 8888:8080 --name backend_cont_${BUILD_ID} olfasalem/spring-img:${BUILD_ID}"
                //                 }
    //}
//}

  //  }
}
}



/*
///  /Si vamos a ejecutar esto en otra maquina que no sea local tiene que ser asi y sino abajo esta el codigo

pipeline {
//master executor deber ser 0 numero de ejecuciones
    agent any
    stages {
    //Aqui vamos desvargar una imagen que tiene lo que ocupamos
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
            //luego de eso va a hacer build del codigo que tenemos
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                //vamos a construir la imagen con el nombre que le pongamos
                	app = docker.build("1112170559/seleniumImage")
                }
            }
        }
        stage('Push Image') {
            steps {
            //Aqui le decimos donde lo guarde en docker hub
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}
pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='112170559/lastbuild' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push 112170559/lastbuild:latest"
			    }
            }
        }
    }
}
 */

pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("112170559/lastbuild")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}
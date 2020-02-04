pipeline {
   agent any

   stages {
   stage('Build') {
      steps{
         // Run the maven build
         sh 'mvn -Dmaven.test.failure.ignore clean package'
      }
   }
   stage('Results') {
      steps {
         junit '**/target/surefire-reports/TEST-*.xml'
         archiveArtifacts 'target/*.jar'
      }
   }
   }
}

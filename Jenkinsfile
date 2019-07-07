node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/mconsta000/divide-two-integers.git/'
   }
   stage('Build') {
      // Run the maven buil
      jdk = tool name: 'Open JDK 8 i386', type: 'jdk'
      env.JAVA_HOME = "${jdk}"
      sh 'mvn -Dmaven.test.failure.ignore clean package'
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
}
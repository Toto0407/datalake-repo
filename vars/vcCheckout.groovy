import java.nio.file.Files
import java.nio.file.Paths

def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        sh"""
        ls -la
        """ 
        Files.copy(Paths.get("./emr/"), Paths.get("../aws/unified/dev/environment/files/")) 

        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

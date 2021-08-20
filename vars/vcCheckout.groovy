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
        Path source = stageParams.src_repo_dir
        Path target = stageParams.dst_repo_dir
        Files.copy(source, target)
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

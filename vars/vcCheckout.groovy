import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import groovy.util.AntBuilder

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
       Path sourceDir = Paths.get(stageParams.src_repo_dir)
       System.out.println(sourceDir.toAbsolutePath()) 
       Path destinationDir = Paths.get(stageParams.dst_repo_dir) 
       Files.copy(sourceDir, destinationDir)
      

        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

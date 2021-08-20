import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path

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
       Path destinationDir = Paths.get(stageParams.dst_repo_dir) 

       new AntBuilder().copy(todir: destinationDir) {
       fileset(dir : sourceDir) {
        exclude(name:"*.java")
          }
        }

        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

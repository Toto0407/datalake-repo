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
        new AntBuilder().copy(todir: stageParams.dst_repo_dir) {
        fileset(dir: stageParams.src_repo_dir, includes: "**")
}
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

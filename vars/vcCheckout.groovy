import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import groovy.util.AntBuilder
import org.springframework.util.FileSystemUtils

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
        
       File trgDir = new File("/tmp/myTarget/")
       File srcDir = new File("/tmp/mySource/")

       FileUtils.copyDirectory(srcDir, trgDir)
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

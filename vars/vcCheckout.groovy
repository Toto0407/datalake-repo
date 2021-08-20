import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import org.apache.commons.io.FileUtils


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
        class Example {
   static void main(String[] args) {
      new File("/emr").eachFile() {  
         file->println file.getAbsolutePath()
      }
   } 
}
  
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

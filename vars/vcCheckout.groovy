@Grab(group = 'commons-io', module = 'commons-io', version = '2.6')
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
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        pwd
        """  
        
       String s_path = "opt/workspace/test_new_jobs/Test-jenkins-shared-library/data-platform/emr"
       println(s_path) 
       String d_path = "opt/workspace/test_new_jobs/Test-jenkins-shared-library/aws/unified/dev/environment/files" 
       println(d_path) 
       Files.copy(Paths.get("~./emr"), Paths.get("~./aws/unified/dev/environment/files"))  
        
         
  
        
            
             
   }
}

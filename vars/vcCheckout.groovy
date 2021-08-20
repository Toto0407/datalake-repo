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
        
       File srcDir = new File("opt/workspace/test_new_jobs/Test-jenkins-shared-library/data-platform/emr/")
       String s_path = srcDir.getCanonicalPath(); 
       println(s_path) 
       File trgDir = new File("opt/workspace/test_new_jobs/Test-jenkins-shared-library/aws/unified/dev/environment/files/")
       String d_path = trgDir.getCanonicalPath(); 
       println(d_path) 
      
         Files.move(s_path, d_pat.resolve(source.getFileName()), REPLACE_EXISTING)
        
  
        
            
             
   }
}

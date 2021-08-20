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
        
       File srcDir = new File("./opt/workspace/test_new_jobs/Test-jenkins-shared-library/data-platform/emr/bootstrap_post_provision.sh")
       String s_path = srcDir.getAbsolutePath(); 
       File trgDir = new File("..//aws//unified//dev//environment//files//bootstrap_post_provision.sh")
       String d_path = trgDir.getAbsolutePath(); 
       
       FileUtils.copyDirectory(s_path, d_path)
        
  
        
            
             
   }
}

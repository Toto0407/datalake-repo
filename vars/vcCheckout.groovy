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
        new File('.').eachFile{src->
          if(src.name.endsWith('.*')){
        def dst = new File('../aws/unified/dev/environment/files/', src.name)
        src.withInputStream{stream-> dst << stream }
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
              
          }
       }
   }
}

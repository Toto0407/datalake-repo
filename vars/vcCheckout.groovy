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
        URI uri = null
         try {
             uri = new URI("/emr")
             }
        Path source=Paths.get(uri)
         URI uri2 = null;
         try {
             uri2 = new URI("/aws/unified/dev/environment/files/")  
             }
        Path target=Paths.get(uri2)
        
        Files.copy(source, target)
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

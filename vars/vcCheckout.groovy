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
        URI uri = null;
         try {
             uri = new URI("/emr");  
             }
        Path source=Paths.get(uri);
         URI uri2 = null;
         try {
             uri2 = new URI("/aws/unified/dev/environment/files/");  
             }
        Path source=Paths.get(uri2);
        
        Path target = Paths.get(new URI(stageParams.dst_repo_dir))
        Files.copy(source, target)
        
        sh"""
        ls -la ../aws/unified/dev/environment/files/
        """      
             
   }
}

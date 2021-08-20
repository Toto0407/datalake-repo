import java.nio.file.Files
import java.nio.file.Paths

def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        Files.copy(Paths.get("${stageParams.src_repo_dir}"), Paths.get("${stageParams.dst_repo_dir}"))   
       
   }
}

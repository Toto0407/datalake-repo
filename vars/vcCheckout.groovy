def call(Map stageParams){
    
    sh"""
     ls -la
     ls -la ./${stageParams.dst_repo_dir}
     """  
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
     sh"""
     ls -la
     ls -la ./${stageParams.dst_repo_dir}
     """    
   }
}

def call(Map stageParams){
    sh 'ls -la'
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        Files.copy(Paths.get("./${stageParams.src_repo_dir}"), Paths.get("../${stageParams.dst_repo_dir}"), StandardCopyOption.REPLACE_EXISTING)   
     sh"""
     #cp ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}
     ls -la ../${stageParams.dst_repo_dir}
     """    
   }
}

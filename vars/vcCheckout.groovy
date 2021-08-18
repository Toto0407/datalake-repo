def call(Map stageParams){
    sh 'ls -la'
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        Files.copy(Paths.get("emr/"), Paths.get("aws/unified/dev/environment/files/"), StandardCopyOption.REPLACE_EXISTING)   
     sh"""
     #cp ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}
     ls -la ../${stageParams.dst_repo_dir}
     """    
   }
}

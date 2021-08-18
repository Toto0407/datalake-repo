def call(Map stageParams){
    def repo_dir = new File( stageParams.src_repo_name )
    
    if (repo_dir.exists()){
        deleteDir(repo_dir)
    }
    repo_dir.mkdir()
    
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
     }   
     sh"""
     cp ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}
     ls -la ../${stageParams.dst_repo_dir}
     """    
} 

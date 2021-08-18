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
     new AntBuilder().copy( todir: stageParams.dst_repo_dir ) {
         fileset( dir:stageParams.src_repo_dir )
     }   
     sh"""
     ls -la ../${stageParams.dst_repo_di}
     """    
    } 
    
  }

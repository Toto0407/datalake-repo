def call(Map stageParams){
    def r_dir = new File( stageParams.repodirname )
    
    if (r_dir.exists()){
        deleteDir(dir_name)
    }
    r_dir.mkdir()
    
    dir("${stageParams.repodirname}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
     Files.copy(stageParams.srcpath, stageParams.destpath)   
     sh"""
     #cp ./${stageParams.srcpath}${stageParams.filemask} ../${stageParams.destpath}
     ls -la ../${stageParams.destpath}
     """    
    } 
    
  }

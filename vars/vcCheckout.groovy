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
     new AntBuilder().copy( todir: stageParams.destpath ) {
         fileset( dir:stageParams.srcpath )
     }   
     sh"""
     ls -la ../${stageParams.destpath}
     """    
    } 
    
  }

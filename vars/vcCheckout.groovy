def call(Map stageParams){
    sh """
    if [ -d ${stageParams.repodirname} ]
    then
        rm -r ${stageParams.repodirname}/
    fi
    mkdir ${stageParams.repodirname}
    """
    dir("${stageParams.repodirname}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ]) 
     sh"""
     cp ./${stageParams.srcpath}*.* ../${stageParams.destpath}
     ls -la ../${stageParams.destpath}
     """    
    } 
    
  }

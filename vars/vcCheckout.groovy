def call(Map stageParams){
    sh """
    if [ -d ${stageParams.repodir} ] 
    then
        rm -r ${stageParams.repodir}/ 
    fi
    mkdir ${stageParams.repodir}
    """
    dir("${stageParams.repodir}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ]) 
     sh"""
     cp .${stageParams.srcpath}*.* ../${stageParams.destpath}
     """    
    } 
    
  }

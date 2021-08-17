def call(Map stageParams){
    sh """
    if [ -d ${stageParam.repodir} ] 
    then
        rm -r ${stageParam.repodir}/ 
    fi
    mkdir ${stageParam.repodir}
    """
    dir("${stageParam.repodir}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
    }    
  }

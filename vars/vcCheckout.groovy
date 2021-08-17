def call(Map stageParams, String repodir=evaluate("repodir"){
    sh """
    if [ -d ${repodir} ] 
    then
        rm -r ${repodir}/ 
    fi
    mkdir ${repodir}
    """
    dir('Test'){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
    }    
  }

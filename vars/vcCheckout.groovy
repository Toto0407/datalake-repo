def call(Map stageParams) {
    sh """
    if [ -d "Test" ] 
    then
        rm -r Test/ 
    fi
    mkdir Test
    """
    dir('Test'){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
    }    
  }

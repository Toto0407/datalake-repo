def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
         sh"""
         ls -la ./emr
          """  
        command = ["sh", "cp ./emr/*.* ../aws/unified/dev/environment/files/"]
        Runtime.getRuntime().exec((String[]) command.toArray())
         sh"""
         ls -la ../${stageParams.dst_repo_dir}
          """  
      }
   }

def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        command = ["sh", "-c", "cp .${stageParams.src_repo_dir}/${stageParams.file_mask} ..${stageParams.dst_repo_dir}"]
        Runtime.getRuntime().exec((String[]) command.toArray())
      }
   }

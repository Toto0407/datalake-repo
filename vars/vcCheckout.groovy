def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        sh("cp ${stageParams.cp_param} ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}")
        sh("dir ../${stageParams.dst_repo_dir}/umr")
   }
}

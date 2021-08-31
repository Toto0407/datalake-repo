def call(String src_repo_name, String src_repo_branch, Strin src_repo_url, Stirng src_repo_dir, String file_mask, String dst_repo_dir){
    dir("${src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  src_repo_branch ]],
        userRemoteConfigs: [[ url: src_repo_url ]]
    ])
     sh("cp ./${src_repo_dir}${file_mask} ../${dst_repo_dir}")
   }
}

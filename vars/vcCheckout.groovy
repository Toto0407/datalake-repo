def call(Map stageParams){
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
        new AntBuilder().copy( todir:'/aws/unified/dev/environment/files' ) {
        fileset( dir:'/emr' )
        }
        sh"""
        ls -la ../${stageParams.dst_repo_dir}
        """  
    }
}

def call(Map stageParams){
    def repo_dir = new File('data-platform')
    sh'pwd'
    if (repo_dir.exists()){
        sh'echo exist'
    }
   
     sh"""
     ls -la
     ls -la ./${stageParams.dst_repo_dir}
     """    
 
}

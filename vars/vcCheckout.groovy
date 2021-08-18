def call(Map stageParams){
    def repo_dir = new File( stageParams.src_repo_name )
    sh'pwd'
    if (repo_dir.exists()){
        deleteDir(repo_dir)
    }
   
     sh"""
     ls -la
     ls -la ../${stageParams.dst_repo_dir}
     """    
 
}

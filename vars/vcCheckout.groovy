def call(Map stageParams){
    def repo_dir = new File( stageParams.src_repo_name )
    
    if (repo_dir.exists()){
        deleteDir(repo_dir)
    }
   
     sh"""
     ls -la
     cp ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}
     ls -la ../${stageParams.dst_repo_dir}
     """    
 
}

def call(Map stageParams){
    def repo_dir = new File('data-platform')
    sh'pwd'
    if (repo_dir.exists()){
        echo " folder exist"
    }
    repo_dir.mkdir()
   
     sh"""
     ls -la
     ls -la ./${stageParams.dst_repo_dir}
     """    
 
}

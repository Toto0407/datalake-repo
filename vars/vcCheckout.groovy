import org.apache.commons.io.FileUtils
def call(Map stageParams){
    def src = new File("emr/")
    def dest = new File("aws/unified/dev/environment/files/")
    sh 'ls -la'
    dir("${stageParams.src_repo_name}"){
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.src_repo_branch ]],
        userRemoteConfigs: [[ url: stageParams.src_repo_url ]]
    ])
    try {
    FileUtils.copyDirectory(src, dest);
      } catch (IOException e) {
            e.printStackTrace();
     }
     sh"""
     #cp ./${stageParams.src_repo_dir}${stageParams.file_mask} ../${stageParams.dst_repo_dir}
     ls -la ../${stageParams.dst_repo_dir}
     """    
   }
}

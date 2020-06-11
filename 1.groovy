import jenkins.model.Jenkins;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;
import hudson.tasks.BatchFile;


//def userId = 'jenkinsadmin'
def jobname = binding.variables["target"]

try{
def job = Jenkins.instance.createProject(FreeStyleProject, jobname)
}

catch(Exception e){
def job = Jenkins.instance.getItem(jobname)
}

finally{
job.buildersList.clear()
//job.buildersList.add(new BatchFile('echo hello world'))
job.buildersList.add(new Shell('echo hello world'))

job.removeProperty(hudson.security.AuthorizationMatrixProperty)
job.addProperty(new hudson.security.AuthorizationMatrixProperty())
def permission = job.getProperty(hudson.security.AuthorizationMatrixProperty)

//JOB PERMISSION
//permission.add(hudson.model.Item.BUILD,userId)
//permission.add(hudson.model.Item.CANCEL,userId)
//permission.add(hudson.model.Item.CONFIGURE,userId)
//permission.add(hudson.model.Item.DELETE,userId)
//permission.add(hudson.model.Item.DISCOVER,userId)
//permission.add(hudson.model.Item.READ,userId)
//permission.add(hudson.model.Item.WORKSPACE,userId)


//RUN PERMISSION
//permission.add(hudson.model.Run.UPDATE,userId)
//permission.add(hudson.model.Run.DELETE,userId)


//CREDENTIALS PERMISSION
//permission.add(com.cloudbees.plugins.credentials.CredentialsProvider.VIEW,userId)
//permission.add(com.cloudbees.plugins.credentials.CredentialsProvider.UPDATE,userId)
//permission.add(com.cloudbees.plugins.credentials.CredentialsProvider.MANAGE_DOMAINS,userId)
//permission.add(com.cloudbees.plugins.credentials.CredentialsProvider.DELETE,userId)
//permission.add(com.cloudbees.plugins.credentials.CredentialsProvider.CREATE,userId)

//SCM PERMISSION
//permission.add(hudson.scm.SCM.TAG,userId)

job.save()
//build = job.scheduleBuild2(0, new hudson.model.Cause.UserIdCause())

//build.get()
}

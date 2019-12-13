def call(String msg = 'deletepreviousbuilds'){
  echo "${msg}"
  import jenkins.model.Jenkins
import hudson.model.Job

MAX_BUILDS = 20

for (job in Jenkins.instance.items) {
  println job.name

  def recent = job.builds.limit(MAX_BUILDS)

  for (build in job.builds) {
    if (!recent.contains(build)) {
      println "Preparing to delete: " + build
      // build.delete()
    }
  }
}
}


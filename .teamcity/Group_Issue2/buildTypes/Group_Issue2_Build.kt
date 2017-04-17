package Group_Issue2.buildTypes

import Group_Issue2.vcsRoots.Group_Issue2
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object Group_Issue2_Build : BuildType({
    uuid = "29a28a1e-0917-46f6-a417-2d8ad66754d3"
    extId = "Group_Issue2_Build"
    name = "Build"

    vcs {
        root(Group_Issue2)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Building %teamcity.build.branch% ...""""
        }
    }

    triggers {
        vcs {
            perCheckinTriggering = true
        }
    }

})

package Group_Issue2.buildTypes

import Group_Issue2.vcsRoots.Group_Issue2
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.finishBuildTrigger

object Group_Issue2_Test : BuildType({
    uuid = "aa10fd9e-13ec-4736-b812-dce03a60f5e3"
    extId = "Group_Issue2_Test"
    name = "Test Name Changed"

    vcs {
        root(Group_Issue2)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Testing %teamcity.build.branch% ...""""
        }
    }

    triggers {
        finishBuildTrigger {
            buildTypeExtId = Group_Issue2_Build.extId
            successfulOnly = true
            branchFilter = """
                +:*
                """.trimIndent()
        }
    }

})

package Group_Issue2.buildTypes

import Group_Issue2.vcsRoots.Group_Issue2
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.vcsLabeling
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.finishBuildTrigger

object Group_Issue2_Publish : BuildType({
    uuid = "634a11fd-db2d-438c-b438-115ee8b9b012"
    extId = "Group_Issue2_Publish"
    name = "Publish Name Changed"

    vcs {
        root(Group_Issue2)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Publishing %teamcity.build.branch% ...""""
        }
    }

    triggers {
        finishBuildTrigger {
            buildTypeExtId = Group_Issue2_Test.extId
            successfulOnly = true
            branchFilter = """
                +:master
                +:release/*
                """.trimIndent()
        }
    }

    features {
        vcsLabeling {
            vcsRootExtId = Group_Issue2.extId
            labelingPattern = "%system.build.number%"
            successfulOnly = true
        }
    }
})

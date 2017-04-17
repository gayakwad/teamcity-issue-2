package Group_Issue2.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Group_Issue2 : GitVcsRoot({
    uuid = "a3e7a7de-bd45-4708-9678-4187feb8863b"
    extId = "Group_Issue2"
    name = "Group_Issue2"
    url = "git@github.com:gayakwad/teamcity-issue-2.git"
    pushUrl = "git@github.com:gayakwad/teamcity-issue-2.git"
    authMethod = uploadedKey {
        uploadedKey = "VSC Key"
    }
    agentCleanPolicy = AgentCleanPolicy.ALWAYS
    branchSpec = """
        +:refs/heads/(master)
        +:refs/heads/(release/*)
        +:refs/(pull-requests/*)/from
    """.trimIndent()
})

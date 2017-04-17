package Group_Issue2

import Group_Issue2.buildTypes.Group_Issue2_Build
import Group_Issue2.buildTypes.Group_Issue2_Publish
import Group_Issue2.buildTypes.Group_Issue2_Test
import Group_Issue2.vcsRoots.Group_Issue2
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.Format.KOTLIN
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.Mode.ENABLED
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "63984bf0-290b-496b-89fb-de1394faccf3"
    extId = "Group_Issue2"
    parentId = "Group"
    name = "Issue 2"

    vcsRoot(Group_Issue2)

    buildType(Group_Issue2_Build)
    buildType(Group_Issue2_Test)
    buildType(Group_Issue2_Publish)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = ENABLED
            buildSettingsMode = PREFER_SETTINGS_FROM_VCS
            rootExtId = Group_Issue2.extId
            showChanges = false
            settingsFormat = KOTLIN
        }
    }

    buildTypesOrder = arrayListOf(
        Group_Issue2_Build,
        Group_Issue2_Test,
        Group_Issue2_Publish
    )
})

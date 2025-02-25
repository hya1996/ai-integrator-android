package convention.plugin

import convention.Configs
import convention.ext.configureKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("kotlin-parcelize")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = Configs.TARGET_SDK_VERSION
            }

            dependencies {
                "implementation"(libs.findBundle("common-base").get())
                "implementation"(libs.findBundle("android-base").get())

                "implementation"(project(Modules.Core.framework))
            }
        }
    }
}
package convention.plugin

import com.android.build.gradle.LibraryExtension
import convention.Configs
import convention.ext.configureKotlinAndroid
import convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFrameworkConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("kotlin-parcelize")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = Configs.TARGET_SDK_VERSION
            }

            dependencies {
                "implementation"(libs.findBundle("common-base").get())
                "implementation"(libs.findBundle("android-base").get())
            }
        }
    }
}
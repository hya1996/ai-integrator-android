package convention.plugin

import convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDataConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("convention.android.library")
            }

            dependencies {
                "implementation"(libs.findLibrary("retrofit").get())
            }
        }
    }
}
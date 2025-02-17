plugins {
    alias(libs.plugins.convention.android.feature)
}

android {
    namespace = "com.ai.integrator.feature.dialogue"

    dependencies {
        implementation(project(Modules.Data.dialogue))
    }
}
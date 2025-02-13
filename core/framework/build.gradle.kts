plugins {
    alias(libs.plugins.convention.android.framework)
}

android {
    namespace = "com.ai.integrator.core.framework"

    dependencies {
        implementation(libs.androidx.activity.compose)
    }
}
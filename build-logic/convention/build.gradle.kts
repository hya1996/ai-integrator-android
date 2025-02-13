import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.ai.integrator.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.compose.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("conventionAndroidFramework") {
            id = "convention.android.framework"
            implementationClass = "convention.plugin.AndroidFrameworkConventionPlugin"
        }

        register("conventionAndroidApplication") {
            id = "convention.android.application"
            implementationClass = "convention.plugin.AndroidApplicationConventionPlugin"
        }

        register("conventionAndroidLibrary") {
            id = "convention.android.library"
            implementationClass = "convention.plugin.AndroidLibraryConventionPlugin"
        }

        register("conventionAndroidApplicationCompose") {
            id = "convention.android.application.compose"
            implementationClass = "convention.plugin.AndroidApplicationComposeConventionPlugin"
        }

        register("conventionAndroidLibraryCompose") {
            id = "convention.android.library.compose"
            implementationClass = "convention.plugin.AndroidLibraryComposeConventionPlugin"
        }

        register("conventionAndroidFeature") {
            id = "convention.android.feature"
            implementationClass = "convention.plugin.AndroidFeatureConventionPlugin"
        }

        register("conventionAndroidData") {
            id = "convention.android.data"
            implementationClass = "convention.plugin.AndroidDataConventionPlugin"
        }
    }
}